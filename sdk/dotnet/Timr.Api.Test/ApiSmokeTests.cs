using System;
using System.IO;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using Microsoft.Extensions.Logging.Abstractions;
using Microsoft.Extensions.DependencyInjection;
using Timr.Api.Extensions;
using Timr.Api.Endpoints;
using Timr.Api.Client;
using Xunit;

namespace Timr.Api.Test;

public sealed class ApiSmokeTests
{
    [Fact]
    public Task DefaultUserAgentIsSentWithAuthenticatedRequest() =>
        AssertAuthenticatedRequest(ExpectedDefaultUserAgent);

    [Fact]
    public Task ManualApiConstructionLeavesAnUninitializedUserAgentUnchanged() =>
        AssertAuthenticatedRequest("", initializeDefault: false);

    [Fact]
    public Task ExplicitUserAgentIsPreservedWithAuthenticatedRequest() =>
        AssertAuthenticatedRequest("my-integration/1.0",
            beforeApiCreation: client => client.SetUserAgent("my-integration/1.0"));

    [Fact]
    public Task ApplicationIdentifierCanBeAppendedToUserAgent() =>
        AssertAuthenticatedRequest(ExpectedDefaultUserAgent + " my-integration/1.0",
            beforeApiCreation: client => client.AppendUserAgent("my-integration/1.0"));

    [Fact]
    public Task ApplicationIdentifierCanBeAppendedToExplicitUserAgent() =>
        AssertAuthenticatedRequest("custom-client/1.0 my-integration/1.0",
            beforeApiCreation: client => client.SetUserAgent("custom-client/1.0").AppendUserAgent("my-integration/1.0"));

    [Fact]
    public Task ExplicitUserAgentReplacesAnInitializedSdkDefault() =>
        AssertAuthenticatedRequest("my-integration/1.0",
            beforeApiCreation: client => client.ApplyDefaultUserAgent().SetUserAgent("my-integration/1.0"));

    private static string ExpectedDefaultUserAgent =>
        "timr-sdk-dotnet/" + (Environment.GetEnvironmentVariable("TIMR_SDK_VERSION") ?? "2.0.0");

    private static async Task AssertAuthenticatedRequest(string expectedAgent,
        Action<HttpClient>? beforeApiCreation = null, bool initializeDefault = true)
    {
        using var serializers = new JsonSerializerFixture();
        var handler = new RecordingHandler(
            await File.ReadAllTextAsync(Path.Combine(AppContext.BaseDirectory, "test-fixtures", "user.json")));
        using var httpClient = new HttpClient(handler) { BaseAddress = new Uri("https://example.test/v1/") };
        beforeApiCreation?.Invoke(httpClient);
        if (initializeDefault)
            httpClient.ApplyDefaultUserAgent();
        var api = new UserApi(
            NullLogger<UserApi>.Instance,
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
        Assert.Equal(expectedAgent, handler.UserAgent);
    }

    [Theory]
    [InlineData(true, true)]
    [InlineData(false, true)]
    [InlineData(true, false)]
    [InlineData(false, false)]
    public async Task HttpClientConfigurationReachesTheRequest(bool useSeparateRegistration, bool useCallbackProvider)
    {
        var handler = new RecordingHandler(
            await File.ReadAllTextAsync(Path.Combine(AppContext.BaseDirectory, "test-fixtures", "user.json")));
        var services = new ServiceCollection();
        services.AddLogging();
        services.AddTimrApiClient(options =>
        {
            if (useCallbackProvider)
            {
                options.UseAccessToken("obsolete-token");
                options.UseAccessTokenProvider(_ => ValueTask.FromResult("token-abc"));
            }
            else
            {
                options.UseAccessTokenProvider(_ => ValueTask.FromException<string>(new InvalidOperationException("Obsolete provider must not run.")));
                options.UseAccessToken("token-abc");
            }
            options.ConfigureHttpClient(client => client.Timeout = TimeSpan.FromSeconds(17));
            if (!useSeparateRegistration)
                options.ConfigureHttpClient(client => client.BaseAddress = new Uri("https://example.test/v1/"));
        });
        if (useSeparateRegistration)
        {
            services.AddHttpClient<IUserApi, UserApi>("Timr.Api.Endpoints.IUserApi",
                    client => client.BaseAddress = new Uri("https://example.test/v1/"))
                .ConfigurePrimaryHttpMessageHandler(() => handler);
        }
        else
        {
            services.AddHttpClient<IUserApi, UserApi>("Timr.Api.Endpoints.IUserApi")
                .ConfigurePrimaryHttpMessageHandler(() => handler);
        }
        using var provider = services.BuildServiceProvider();
        var api = (UserApi)provider.GetRequiredService<IUserApi>();

        var response = await api.GetUserAsync("user123");

        Assert.True(response.TryOk(out var user));
        Assert.Equal("user123", user.Id);
        Assert.Equal("https://example.test/v1/users/user123", handler.RequestUri?.ToString());
        Assert.Equal("Bearer token-abc", handler.Authorization);
        Assert.Equal(TimeSpan.FromSeconds(17), api.HttpClient.Timeout);
        Assert.Equal(ExpectedDefaultUserAgent, handler.UserAgent);
    }

    [Theory]
    [InlineData("default", false)]
    [InlineData("default", true)]
    [InlineData("replace", false)]
    [InlineData("append", false)]
    [InlineData("replace", true)]
    [InlineData("append", true)]
    [InlineData("header", false)]
    [InlineData("header", true)]
    public async Task RegisteredHttpClientsRespectUserAgentConfiguration(string mode, bool configureAfterSdkRegistration)
    {
        var handler = new RecordingHandler(
            await File.ReadAllTextAsync(Path.Combine(AppContext.BaseDirectory, "test-fixtures", "user.json")));
        var services = new ServiceCollection();
        services.AddLogging();
        Action<HttpClient> configure = client =>
        {
            client.BaseAddress = new Uri("https://example.test/v1/");
            if (mode == "replace")
                client.SetUserAgent("my-integration/1.0");
            else if (mode == "append")
                client.AppendUserAgent("my-integration/1.0");
            else if (mode == "header")
                client.DefaultRequestHeaders.UserAgent.ParseAdd("my-integration/1.0");
        };
        services.AddTimrApiClient(options =>
        {
            options.UseAccessTokenProvider(_ => ValueTask.FromResult("token-abc"));
            if (!configureAfterSdkRegistration)
                options.ConfigureHttpClient(configure);
        });
        if (configureAfterSdkRegistration)
            services.AddHttpClient<IUserApi, UserApi>("Timr.Api.Endpoints.IUserApi", configure)
                .ConfigurePrimaryHttpMessageHandler(() => handler);
        else
            services.AddHttpClient<IUserApi, UserApi>("Timr.Api.Endpoints.IUserApi")
                .ConfigurePrimaryHttpMessageHandler(() => handler);
        using var provider = services.BuildServiceProvider();

        var response = await provider.GetRequiredService<IUserApi>().GetUserAsync("user123");

        Assert.True(response.TryOk(out _));
        Assert.Equal("Bearer token-abc", handler.Authorization);
        Assert.Equal(mode switch
        {
            "replace" => "my-integration/1.0",
            "header" => "my-integration/1.0",
            "append" => ExpectedDefaultUserAgent + " my-integration/1.0",
            _ => ExpectedDefaultUserAgent
        }, handler.UserAgent);
    }

    private sealed class StaticTokenProvider(string token) : TokenProvider<OAuthToken>
    {
        protected internal override ValueTask<OAuthToken> GetAsync(string header = "", CancellationToken cancellation = default) =>
            ValueTask.FromResult(new OAuthToken(token));
    }

    private sealed class RecordingHandler(string responseBody) : HttpMessageHandler
    {
        public HttpMethod? Method { get; private set; }
        public Uri? RequestUri { get; private set; }
        public string? Authorization { get; private set; }
        public string? UserAgent { get; private set; }

        protected override Task<HttpResponseMessage> SendAsync(HttpRequestMessage request, CancellationToken cancellationToken)
        {
            Method = request.Method;
            RequestUri = request.RequestUri;
            Authorization = request.Headers.Authorization?.ToString();
            UserAgent = request.Headers.UserAgent.ToString();

            return Task.FromResult(new HttpResponseMessage(HttpStatusCode.OK)
            {
                Content = new StringContent(responseBody, Encoding.UTF8, "application/json")
            });
        }
    }
}
