using System;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Timr.Api.Client;

namespace Timr.Api.Extensions;

/// <summary>Registers the timr SDK with a host builder.</summary>
public static class IHostBuilderExtensions
{
    /// <summary>Configures authentication and HTTP clients for the timr SDK.</summary>
    public static IHostBuilder ConfigureTimrApiClient(this IHostBuilder builder, Action<HostBuilderContext, HostConfiguration> options)
    {
        ArgumentNullException.ThrowIfNull(builder);
        ArgumentNullException.ThrowIfNull(options);
        return builder.ConfigureServices((context, services) =>
            services.AddTimrApiClient(configuration => options(context, configuration)));
    }
}
