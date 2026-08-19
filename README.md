# timr API

The public REST API of [timr](https://www.timr.com), the time tracking service: the OpenAPI
specification that defines it, and the developer documentation published at
<https://developer.timr.com>.

Version 1.0 is the first public release of this API.

## How it fits together

The specification is the contract, and the documentation is rendered from it, so it cannot drift
apart from what the service actually serves.

The specification is maintained together with the service and published here with each release. It
is therefore not edited in this repository — see [CONTRIBUTING.md](CONTRIBUTING.md) if something in
it looks wrong or missing.

## Layout

### `spec/`

`openapi.yaml` is the API contract, written to the OpenAPI 3.0 specification. It describes every
endpoint, the shape of every request and response, and the OAuth2 flows used to authenticate.

`overlay.yaml` is an [OpenAPI Overlay 1.0](https://spec.openapis.org/overlay/v1.0.0) document applied
to the contract before the documentation is built, and it carries the settings the try-it console
needs. Overlays are used throughout this repository for anything a tool needs but the contract should
not state, which keeps the published API description free of tooling detail.

### `site/`

The developer documentation, built with [Vite](https://vite.dev) around the open-source
[Scalar](https://scalar.com) API reference. Its console can call the API directly, using the OAuth2
authorization code flow with PKCE.

Prose lives in `site/guides/` as ordinary Markdown. The build folds each guide into the published
copy of the specification as a tag that carries the prose but no operations, grouped ahead of the
API itself, so a reader moves from a guide to an endpoint within one navigation rather than crossing
into a separate site. The contract itself never carries them.

## Local development

```bash
cd site
npm ci
npm run dev
```

The console runs the OAuth2 authorization code flow with PKCE against the timr authorization server,
which accepts only registered redirect URIs — use `http://127.0.0.1:5173/` rather than `localhost`.

## Contributing

Questions, bug reports and pull requests are welcome — see [CONTRIBUTING.md](CONTRIBUTING.md). We are
especially interested in how the API holds up in real integrations.
