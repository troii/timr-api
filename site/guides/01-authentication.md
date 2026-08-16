# Authentication

Integrations authenticate with OAuth2. Rather than handling a timr username and password, your
application obtains an access token from the timr authorization server and sends it with every
request:

```http
GET /v1/working-times HTTP/1.1
Host: api.timr.com
Authorization: Bearer <access_token>
```

A request without a valid token is answered with `401 Unauthorized`.

## Choosing a flow

Which flow you use depends on whose data your integration touches.

**Client credentials** suits a system talking to timr as itself — a nightly export, a sync job, a
service reconciling timr with another system. The token is issued for the client and grants access in
the client context, across users, according to the permissions the client has. No person signs in and
no browser is involved.

**Authorization code** suits an integration acting on behalf of an individual timr user — a desktop
tool, a mobile app, anything where someone signs in and works with their own data. The token is
issued in the context of that user and is limited to that user's permissions; it does not grant
account-wide access. Add the `offline_access` scope to receive a refresh token as well.

## Creating API credentials

You need to be a timr administrator.

Open **Administration → Settings → Integrations**, and under **API Credentials** click **+ Add**.
Give the client a name, choose its grant type, and save. timr then shows the client ID, and for a
confidential client the client secret — which is displayed only there, so store it securely.

## Finding the endpoints

The authorization server publishes its OpenID Provider metadata:

```
https://system.timr.com/id/.well-known/openid-configuration
```

Read the authorization and token endpoints from that document rather than hardcoding them, so an
endpoint can move without breaking your integration. Today they are:

|                        |                                               |
|------------------------|-----------------------------------------------|
| Authorization endpoint | `https://system.timr.com/id/oauth2/authorize` |
| Token endpoint         | `https://system.timr.com/id/oauth2/token`     |
| API base URL           | `https://api.timr.com/v1`                     |

An unauthenticated response also points at the metadata describing this API, following
[RFC 9728](https://www.rfc-editor.org/rfc/rfc9728.html), which names the authorization server that
protects it:

```http
HTTP/1.1 401 Unauthorized
WWW-Authenticate: Bearer resource_metadata="https://api.timr.com/v1/.well-known/oauth-protected-resource"
```

## Client credentials

Client credentials clients use the scopes `openid timrclient`. Request a token from the token
endpoint:

```http
POST /id/oauth2/token HTTP/1.1
Host: system.timr.com
Content-Type: application/x-www-form-urlencoded

client_id=<client_id>&client_secret=<client_secret>&grant_type=client_credentials&scope=openid timrclient
```

```json
{
  "access_token": "<access_token>",
  "scope": "openid timrclient",
  "token_type": "Bearer",
  "expires_in": 3599
}
```

This flow returns no refresh token. When the access token expires, repeat the same request.

## Authorization code

Authorization code clients use the scopes `openid offline_access`.

### Redirect URLs

Configure at least one redirect URL on the client. They must be absolute and must not contain a
fragment, one per line:

```
https://example.com/oauth/timr/callback
https://app.example.com/integrations/timr/callback
```

The `redirect_uri` you send in the authorization and token requests must match one of them exactly,
so register every URL you use — including the one you develop against.

### Step 1 — send the user to the authorization endpoint

```http
GET /id/oauth2/authorize?response_type=code&client_id=<client_id>&redirect_uri=<redirect_uri>&scope=openid%20offline_access&state=<state> HTTP/1.1
Host: system.timr.com
```

Generate `state` yourself, store it before redirecting, and verify it when the user comes back — it
is what protects the callback from being forged. After signing in, the user is returned to your
redirect URL:

```
https://example.com/oauth/timr/callback?code=<authorization_code>&state=<state>
```

### Step 2 — exchange the code for tokens

```http
POST /id/oauth2/token HTTP/1.1
Host: system.timr.com
Content-Type: application/x-www-form-urlencoded

client_id=<client_id>&client_secret=<client_secret>&grant_type=authorization_code&code=<authorization_code>&redirect_uri=<redirect_uri>
```

```json
{
  "access_token": "<access_token>",
  "refresh_token": "<refresh_token>",
  "scope": "openid offline_access",
  "token_type": "Bearer",
  "expires_in": 3599
}
```

### Step 3 — refresh when the token expires

```http
POST /id/oauth2/token HTTP/1.1
Host: system.timr.com
Content-Type: application/x-www-form-urlencoded

client_id=<client_id>&client_secret=<client_secret>&grant_type=refresh_token&refresh_token=<refresh_token>
```

If the response carries a new refresh token, replace the one you stored.

### Public clients and PKCE

An application that cannot keep a secret — anything running on a user's device or in a browser — is
a public client. It must not embed a client secret, and secures the flow with PKCE instead: send a
`code_challenge` with the authorization request and the matching `code_verifier` with the token
request, and omit `client_secret` entirely.

## Troubleshooting

**The authorization request is rejected.** Check that `redirect_uri` matches a configured URL
exactly, that it is absolute, and that it has no fragment.

**No refresh token came back.** Refresh tokens are issued only by the authorization code flow, and
only when `offline_access` is among the requested scopes.

**A request returns fewer entries than expected.** Each endpoint returns only what the authenticated
user or client may see, so an empty list can mean a missing permission rather than missing data.
Requesting something that exists but is not visible to you is answered with `403 Forbidden`.

## Trying it out

The **Authorize** button at the top of this page runs the authorization code flow with PKCE for you.
Enter your client ID, choose the scopes, and the requests you send from any endpoint below carry the
resulting token — register this page's URL as a redirect URL on the client you use here.
