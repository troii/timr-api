using System;
using System.Text.Json;
using Microsoft.Extensions.DependencyInjection;
using Timr.Api.Client;

namespace Timr.Api.Test;

/// <summary>
/// Builds the same JsonSerializerOptions the SDK uses in production.
/// </summary>
public sealed class JsonSerializerFixture : IDisposable
{
    private readonly ServiceProvider _provider;

    public JsonSerializerOptions Options { get; }

    public JsonSerializerFixture()
    {
        var services = new ServiceCollection();

        // HostConfiguration wires up all custom converters and registers the provider.
        new HostConfiguration(services);

        _provider = services.BuildServiceProvider();
        Options = _provider.GetRequiredService<JsonSerializerOptionsProvider>().Options;
    }

    public T Deserialize<T>(string json) =>
        JsonSerializer.Deserialize<T>(json, Options)!;

    public void Dispose() => _provider.Dispose();
}
