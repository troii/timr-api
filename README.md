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

### TypeScript SDK

The TypeScript client is published as `timr-api` on npm. A `typescript-fetch/<version>` tag publishes
that version under the `latest` dist-tag. **Publish Snapshot**, with `module=typescript-fetch`,
publishes `<version>-snapshot.<run-id>.<attempt>` under `next`.

Publishing uses npm Trusted Publishing and provenance. Configure GitHub publishers for `troii/timr-api`:
`publish-snapshot.yml` with no environment, and `release.yml` with environment `Release`; both must
allow direct `npm publish`. The package must exist on npm before its trusted publishers can be set up.
The source repository must be public for provenance. The initial package upload uses an authorized
npm account; subsequent uploads use the configured trusted publishers.

Run `npm ci` and `npm test` in `sdk/typescript-fetch/`, then `./gradlew :typescript-fetch:npmPack`
from the repository root to build `sdk/typescript-fetch/build/npm/`. Packing stamps `package.json`
and `package-lock.json` from `sdk/versions.properties`; snapshot builds add the prerelease suffix.
**Validate Publishing**, with `module=typescript-fetch`, tests and packs the SDK and attaches the
tarball without uploading it. The package contains compiled JavaScript, declarations, README and license.
The [npm README](sdk/typescript-fetch/README.md) is hand-maintained and preserved during generation. TypeScript methods accept path IDs and bodies directly, with query parameters in a typed options object: `getCar(id)`, `createCar(body)` and `fetchCars({ pageToken, limit })`. The API templates implement this convention; `npm test` checks request serialization and public types.

### Python SDK

The Python client is packaged as `timr-api` on PyPI and imported as `timr_api`.
A `python/<version>` tag publishes the wheel and source distribution to PyPI.
**Publish Snapshot**, with `module=python`, publishes development versions to TestPyPI without
deployment approval. Their PEP 440 version is `<version>.dev<stamp>`, where CI uses the run ID
and attempt to make the numeric stamp unique.

Both indexes use Trusted Publishing. Register these GitHub publishers for `troii/timr-api`, using
pending publishers if the project does not exist yet:

| Index | Project | Workflow | Environment |
| --- | --- | --- | --- |
| PyPI | `timr-api` | `release.yml` | `Release` |
| TestPyPI | `timr-api` | `publish-snapshot.yml` | leave blank |

No PyPI API token or publishing username is stored in GitHub. PyPI and TestPyPI have separate
accounts and publisher configurations.

Install Python's `build` and `twine` packages, then run `./gradlew :python:pythonPack` to regenerate
and build `sdk/python/build/dist/`. **Validate Publishing**, with `module=python`, builds both
distributions, checks their metadata, tests the installed wheel and attaches the files without
uploading to an index.

### Publishing approval and credentials

Stable JVM, .NET, TypeScript and Python publications use the `Release` environment and require approval. Snapshot
publication uses no GitHub environment and needs no deployment approval.

Maven snapshots read `MAVEN_CENTRAL_USERNAME` and `MAVEN_CENTRAL_PASSWORD` from repository secrets.
Stable Maven publications read the same credential names and the signing key and password from
`Release` environment secrets. Signed JVM validation also uses `Release` for access to signing keys.
NuGet obtains a short-lived publishing key through GitHub OIDC for each upload.
npm authenticates through GitHub OIDC; no npm publishing token is stored in GitHub.
PyPI and TestPyPI also authenticate through GitHub OIDC.

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
