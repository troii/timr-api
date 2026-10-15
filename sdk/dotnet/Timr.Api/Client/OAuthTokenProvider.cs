using System;
using System.Threading;
using System.Threading.Tasks;

namespace Timr.Api.Client;

/// <summary>Retrieves the current OAuth access token through an asynchronous callback.</summary>
public sealed class OAuthTokenProvider : TokenProvider<OAuthToken>
{
    private readonly Func<CancellationToken, ValueTask<string>> _getAccessToken;

    /// <summary>Creates a provider whose callback handles token caching and refresh.</summary>
    /// <remarks>The callback can be invoked more than once for a single API request.</remarks>
    public OAuthTokenProvider(Func<CancellationToken, ValueTask<string>> getAccessToken)
    {
        ArgumentNullException.ThrowIfNull(getAccessToken);
        _getAccessToken = getAccessToken;
    }

    /// <inheritdoc/>
    protected async override internal ValueTask<OAuthToken> GetAsync(string header = "", CancellationToken cancellation = default)
    {
        cancellation.ThrowIfCancellationRequested();
        var accessToken = await _getAccessToken(cancellation).ConfigureAwait(false);
        return new OAuthToken(accessToken);
    }
}
