# timr API

The public REST API of [timr](https://www.timr.com), the time tracking service: the OpenAPI
specification that defines it, the developer documentation published at
<https://developer.timr.com>, and the client SDKs generated from it.

Version 1.0 is the first public release of this API.

## How it fits together

The specification is the contract, and everything else here is derived from it. The documentation
renders it, and every SDK is generated from it, so a single specification update moves the
documentation and all SDKs together and they cannot drift apart from what the service actually
serves.

```
spec/openapi.yaml ──┬── site/  →  developer.timr.com
                    └── sdk/   →  one client library per language
```

The specification is maintained together with the service and published here with each release. It
is therefore not edited in this repository — see [CONTRIBUTING.md](CONTRIBUTING.md) if something in
it looks wrong or missing.

The specification carries a version, and each SDK carries a version of its own that states which
contract it speaks — see [VERSIONING.md](VERSIONING.md) for how they move and what a release of each
kind means for an integration.

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

### `sdk/`

One generated client library per language, each with the generator configuration it is produced
from. `sdk/overlay.yaml` applies to all of them, and a module carries an `openapi-overlay.yaml` of
its own where a language needs something the others do not:

| Directory                | Language and flavour              |
|--------------------------|-----------------------------------|
| `sdk/java-restclient/`   | Java, Spring `RestClient`         |
| `sdk/java-resttemplate/` | Java, Spring `RestTemplate`       |
| `sdk/kotlin-okhttp/`     | Kotlin, OkHttp, coroutines        |
| `sdk/python/`            | Python                            |
| `sdk/typescript-fetch/`  | TypeScript, `fetch`               |
| `sdk/swift/`             | Swift, Alamofire, async/await     |
| `sdk/dotnet/`            | C#                                |

The generated sources are committed, so the library you read here is exactly the one you get. They
are produced by [OpenAPI Generator](https://openapi-generator.tech) and regenerated whenever the
specification changes. The release commit records exactly which contract each SDK was built from.

### JVM SDKs

The JVM clients target Java 17 and are published to Maven Central under these coordinates:

| Client | Coordinate |
| --- | --- |
| Java, Spring `RestClient` | `com.timr:timr-api-restclient:<version>` |
| Java, Spring `RestTemplate` | `com.timr:timr-api-resttemplate:<version>` |
| Kotlin, OkHttp and coroutines | `com.timr:timr-api-kotlin:<version>` |

Each client is versioned independently. Use the version shown in `sdk/versions.properties` or the
latest matching module tag described in [VERSIONING.md](VERSIONING.md).

### .NET SDK

The .NET client is packaged as `timr.Api` for .NET 8 and .NET 10. A `dotnet/<version>` tag publishes
that version to NuGet. The manually dispatched **Publish Snapshot** workflow publishes a prerelease
as `<version>-snapshot.<run-id>.<attempt>`; it does not change which stable version consumers resolve.
Both use NuGet Trusted Publishing with the repository variable `NUGET_USER`, set to the username of
the account that created the trust policies. The package owner selected in the policy can differ.
The snapshot trust policy leaves its environment blank; the stable release policy specifies `Release`.

To inspect the package locally, run `./gradlew :dotnet:dotnetTest :dotnet:dotnetPack`. The package is
written to `sdk/dotnet/build/nuget/`; **Validate Publishing**, with `module=dotnet`, runs the tests,
packs the SDK and attaches the package as a workflow artifact without uploading to NuGet.

### Publishing approval and credentials

Stable JVM and .NET publications use the `Release` environment and require approval. Snapshot
publication uses no GitHub environment and needs no deployment approval.

Maven snapshots read `MAVEN_CENTRAL_USERNAME` and `MAVEN_CENTRAL_PASSWORD` from repository secrets.
Stable Maven publications read the same credential names and the signing key and password from
`Release` environment secrets. Signed JVM validation also uses `Release` for access to signing keys.
NuGet obtains a short-lived publishing key through GitHub OIDC for each upload.

## Local development

The documentation site:

```bash
cd site
npm ci
npm run dev
```

Its console runs the OAuth2 authorization code flow with PKCE against the timr authorization server,
which accepts only registered redirect URIs — use `http://127.0.0.1:5173/` rather than `localhost`.

The SDKs:

```bash
./gradlew openApiGenerate
./gradlew :kotlin-okhttp:assemble
```

## Contributing

Questions, bug reports and pull requests are welcome — see [CONTRIBUTING.md](CONTRIBUTING.md). We are
especially interested in how the API and its SDKs hold up in real integrations.
