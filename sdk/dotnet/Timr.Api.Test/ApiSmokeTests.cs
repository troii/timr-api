using System;
using System.IO;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using Microsoft.Extensions.Logging.Abstractions;
using Timr.Api.Api;
using Timr.Api.Client;
using Xunit;

namespace Timr.Api.Test;

public sealed class ApiSmokeTests
{
    [Fact]
    public async Task AuthenticatedRequestReachesTheEndpointAndDecodesItsResponse()
    {
        using var serializers = new JsonSerializerFixture();
        var handler = new RecordingHandler(
            await File.ReadAllTextAsync(Path.Combine(AppContext.BaseDirectory, "test-fixtures", "user.json")));
        using var httpClient = new HttpClient(handler) { BaseAddress = new Uri("https://example.test/v1/") };
        var api = new UserApi(
            NullLogger<UserApi>.Instance,
            NullLoggerFactory.Instance,
            httpClient,
            new JsonSerializerOptionsProvider(serializers.Options),
            new UserApiEvents(),
            new StaticTokenProvider("token-abc"));

        var response = await api.GetUserAsync("user123");

        Assert.True(response.TryOk(out var user));
        Assert.Equal("user123", user.Id);
        Assert.Equal("John Doe", user.Fullname);
        Assert.Equal(HttpMethod.Get, handler.Method);
        Assert.Equal("https://example.test/v1/users/user123", handler.RequestUri?.ToString());
        Assert.Equal("Bearer token-abc", handler.Authorization);
    }

    private sealed class StaticTokenProvider(string token) : TokenProvider<OAuthToken>
    {
        public override ValueTask<OAuthToken> GetAsync(string header = "", CancellationToken cancellation = default) =>
            ValueTask.FromResult(new OAuthToken(token));
    }

    private sealed class RecordingHandler(string responseBody) : HttpMessageHandler
    {
        public HttpMethod? Method { get; private set; }
        public Uri? RequestUri { get; private set; }
        public string? Authorization { get; private set; }

        protected override Task<HttpResponseMessage> SendAsync(HttpRequestMessage request, CancellationToken cancellationToken)
        {
            Method = request.Method;
            RequestUri = request.RequestUri;
            Authorization = request.Headers.Authorization?.ToString();

            return Task.FromResult(new HttpResponseMessage(HttpStatusCode.OK)
            {
                Content = new StringContent(responseBody, Encoding.UTF8, "application/json")
            });
        }
    }
}
