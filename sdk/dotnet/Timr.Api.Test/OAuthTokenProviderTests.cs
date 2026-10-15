using System;
using System.Collections.Generic;
using System.IO;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using Microsoft.Extensions.DependencyInjection;
using Timr.Api.Client;
using Timr.Api.Endpoints;
using Timr.Api.Extensions;
using Xunit;

namespace Timr.Api.Test;

public sealed class OAuthTokenProviderTests
{
    [Fact]
    public async Task CallbackTokenChangesAreUsedBySubsequentRequests()
    {
        var handler = new RecordingHandler();
        var currentToken = "initial-token";
        using var services = CreateServices(handler, async cancellation =>
        {
            await Task.Yield();
            cancellation.ThrowIfCancellationRequested();
            return currentToken;
        });
        var api = services.GetRequiredService<IUserApi>();

        var firstResponse = await api.GetUserAsync("user123");
        currentToken = "refreshed-token";
        var secondResponse = await api.GetUserAsync("user123");

        Assert.True(firstResponse.TryOk(out var firstUser));
        Assert.True(secondResponse.TryOk(out var secondUser));
        Assert.Equal("user123", firstUser.Id);
        Assert.Equal("user123", secondUser.Id);
        Assert.Equal(new[] { "Bearer initial-token", "Bearer refreshed-token" }, handler.Authorizations);
    }

    [Fact]
    public async Task CancellingTokenAcquisitionCancelsRequest()
    {
        var handler = new RecordingHandler();
        var started = new TaskCompletionSource<CancellationToken>(TaskCreationOptions.RunContinuationsAsynchronously);
        using var cancellation = new CancellationTokenSource();
        using var services = CreateServices(handler, async token =>
        {
            started.TrySetResult(token);
            await Task.Delay(Timeout.Infinite, token);
            return "unreachable";
        });
        var api = services.GetRequiredService<IUserApi>();

        var request = api.GetUserAsync("user123", cancellation.Token);
        var callbackCancellation = await started.Task.WaitAsync(TimeSpan.FromSeconds(5));
        cancellation.Cancel();

        await Assert.ThrowsAnyAsync<OperationCanceledException>(() => request);
        Assert.Equal(cancellation.Token, callbackCancellation);
        Assert.Empty(handler.Authorizations);
    }

    [Fact]
    public async Task CancelledRequestDoesNotInvokeTokenCallback()
    {
        var handler = new RecordingHandler();
        var callbackInvoked = false;
        using var services = CreateServices(handler, _ =>
        {
            callbackInvoked = true;
            return ValueTask.FromResult("token");
        });
        var api = services.GetRequiredService<IUserApi>();
        using var cancellation = new CancellationTokenSource();
        cancellation.Cancel();

        await Assert.ThrowsAnyAsync<OperationCanceledException>(() => api.GetUserAsync("user123", cancellation.Token));

        Assert.False(callbackInvoked);
        Assert.Empty(handler.Authorizations);
    }

    [Fact]
    public async Task TokenAcquisitionFailurePreventsRequest()
    {
        var handler = new RecordingHandler();
        var failure = new InvalidOperationException("Token refresh failed.");
        using var services = CreateServices(handler, _ => ValueTask.FromException<string>(failure));
        var api = services.GetRequiredService<IUserApi>();

        var thrown = await Assert.ThrowsAsync<InvalidOperationException>(() => api.GetUserAsync("user123"));

        Assert.Same(failure, thrown);
        Assert.Empty(handler.Authorizations);
    }

    private static ServiceProvider CreateServices(RecordingHandler handler, Func<CancellationToken, ValueTask<string>> getAccessToken)
    {
        var services = new ServiceCollection();
        services.AddLogging();
        services.AddTimrApiClient(options => options
            .UseAccessTokenProvider(getAccessToken)
            .ConfigureHttpClient(client => client.BaseAddress = new Uri("https://example.test/v1/")));
        services.AddHttpClient<IUserApi, UserApi>("Timr.Api.Endpoints.IUserApi")
            .ConfigurePrimaryHttpMessageHandler(() => handler);
        return services.BuildServiceProvider();
    }

    private sealed class RecordingHandler : HttpMessageHandler
    {
        private readonly string _responseBody = File.ReadAllText(Path.Combine(AppContext.BaseDirectory, "test-fixtures", "user.json"));

        public List<string?> Authorizations { get; } = new();

        protected override Task<HttpResponseMessage> SendAsync(HttpRequestMessage request, CancellationToken cancellationToken)
        {
            Authorizations.Add(request.Headers.Authorization?.ToString());
            return Task.FromResult(new HttpResponseMessage(HttpStatusCode.OK)
            {
                Content = new StringContent(_responseBody, Encoding.UTF8, "application/json")
            });
        }
    }
}
