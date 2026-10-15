using System;
using System.Net.Http;
using System.Reflection;

namespace Timr.Api.Client;

/// <summary>Identifies the SDK package in HTTP requests.</summary>
public static class SdkUserAgent
{
    /// <summary>The SDK identifier and assembly informational version, without build metadata.</summary>
    public static string Default { get; } = "timr-sdk-dotnet/" +
        (typeof(SdkUserAgent).Assembly.GetCustomAttribute<AssemblyInformationalVersionAttribute>()?.InformationalVersion.Split('+')[0] ?? "unknown");

    /// <summary>Initializes a missing User-Agent with the SDK identifier and preserves an existing header.</summary>
    public static HttpClient ApplyDefaultUserAgent(this HttpClient client)
    {
        ArgumentNullException.ThrowIfNull(client);
        if (!client.DefaultRequestHeaders.Contains("User-Agent"))
            client.DefaultRequestHeaders.UserAgent.ParseAdd(Default);
        return client;
    }

    /// <summary>Replaces the entire User-Agent header.</summary>
    public static HttpClient SetUserAgent(this HttpClient client, string userAgent)
    {
        ArgumentNullException.ThrowIfNull(client);
        ArgumentException.ThrowIfNullOrWhiteSpace(userAgent);
        client.DefaultRequestHeaders.UserAgent.Clear();
        client.DefaultRequestHeaders.UserAgent.ParseAdd(userAgent);
        return client;
    }

    /// <summary>Appends application identification, initializing the SDK default when the header is missing.</summary>
    public static HttpClient AppendUserAgent(this HttpClient client, string applicationIdentifier)
    {
        ArgumentNullException.ThrowIfNull(client);
        ArgumentException.ThrowIfNullOrWhiteSpace(applicationIdentifier);
        client.ApplyDefaultUserAgent();
        client.DefaultRequestHeaders.UserAgent.ParseAdd(applicationIdentifier);
        return client;
    }
}
