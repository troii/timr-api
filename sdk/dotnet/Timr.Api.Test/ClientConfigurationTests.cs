using System;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text.Json.Serialization;
using System.Threading.Tasks;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Timr.Api.Client;
using Timr.Api.Endpoints;
using Timr.Api.Extensions;
using WireMock.RequestBuilders;
using WireMock.ResponseBuilders;
using WireMock.Server;
using Xunit;

namespace Timr.Api.Test;

public sealed class ClientConfigurationTests
{
    [Fact]
    public void HostConfigurationExposesOnlyAuthenticationAndHttpConfiguration()
    {
        var type = typeof(HostConfiguration);

        Assert.True(type.IsVisible);
        Assert.Empty(type.GetConstructors());
        Assert.Equal(new[] { "ConfigureHttpClient", "UseAccessToken", "UseAccessTokenProvider" },
            type.GetMethods(BindingFlags.Public | BindingFlags.Instance | BindingFlags.DeclaredOnly)
                .Select(method => method.Name).OrderBy(name => name).ToArray());
        Assert.Null(type.Assembly.GetType("Timr.Api.Client.TimrClientOptions"));
    }

    [Fact]
    public void SdkJsonSettingsCannotBeChangedBeforeTheFirstRequest()
    {
        var services = new ServiceCollection();
        services.AddTimrApiClient(options => options.UseAccessToken("token-abc"));
        using var provider = services.BuildServiceProvider();
        var json = provider.GetRequiredService<JsonSerializerOptionsProvider>().Options;

        Assert.Throws<InvalidOperationException>(() => json.PropertyNamingPolicy = System.Text.Json.JsonNamingPolicy.CamelCase);
        Assert.Throws<InvalidOperationException>(() => json.Converters.Clear());
        Assert.Throws<InvalidOperationException>(() => json.Converters.Add(new JsonStringEnumConverter()));
    }

    [Fact]
    public void MissingAuthenticationFailsDuringRegistration()
    {
        var services = new ServiceCollection();

        Assert.Throws<InvalidOperationException>(() => services.AddTimrApiClient(_ => { }));
    }

    [Fact]
    public void HttpConfigurationRetainsTheDefaultServerAddress()
    {
        var services = new ServiceCollection();
        services.AddLogging();
        services.AddTimrApiClient(options => options
            .UseAccessToken("token-abc")
            .ConfigureHttpClient(client => client.AppendUserAgent("example-app/1.0")));
        using var provider = services.BuildServiceProvider();

        var client = provider.GetRequiredService<IUserApi>().HttpClient;

        Assert.Equal(new Uri("https://api.timr.com/v1"), client.BaseAddress);
        Assert.Equal(SdkUserAgent.Default + " example-app/1.0", client.DefaultRequestHeaders.UserAgent.ToString());
    }

    [Fact]
    public async Task ApplicationBuilderUsesStaticAuthenticationAndCombinesHttpConfiguration()
    {
        using var server = WireMockServer.Start();
        server.Given(Request.Create().WithPath("/v1/users/user123").UsingGet())
            .RespondWith(Response.Create().WithStatusCode(200).WithHeader("Content-Type", "application/json")
                .WithBody(await File.ReadAllTextAsync(Path.Combine(AppContext.BaseDirectory, "test-fixtures", "user.json"))));
        var builder = Host.CreateApplicationBuilder();
        builder.Services.AddTimrApiClient(options => options
            .UseAccessToken("token-abc")
            .ConfigureHttpClient(client =>
            {
                client.BaseAddress = new Uri(server.Url + "/v1/");
                client.Timeout = TimeSpan.FromSeconds(10);
            })
            .ConfigureHttpClient(client =>
            {
                client.Timeout = TimeSpan.FromSeconds(5);
                client.AppendUserAgent("example-app/1.0");
            }));
        using var host = builder.Build();

        var api = host.Services.GetRequiredService<IUserApi>();
        var response = await api.GetUserAsync("user123");

        Assert.True(response.TryOk(out var user));
        Assert.Equal("user123", user.Id);
        Assert.Equal(TimeSpan.FromSeconds(5), api.HttpClient.Timeout);
        Assert.Single(server.FindLogEntries(Request.Create().UsingGet().WithPath("/v1/users/user123")
            .WithHeader("Authorization", "Bearer token-abc")
            .WithHeader("User-Agent", SdkUserAgent.Default + " example-app/1.0")));
    }
}
