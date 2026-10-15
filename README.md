# timr API

[![SDK CI](https://github.com/troii/timr-api/actions/workflows/sdk.yml/badge.svg?branch=main)](https://github.com/troii/timr-api/actions/workflows/sdk.yml)
[![Documentation](https://github.com/troii/timr-api/actions/workflows/pages.yml/badge.svg?branch=main)](https://github.com/troii/timr-api/actions/workflows/pages.yml)

The public REST API of [timr](https://www.timr.com), the time tracking service: the OpenAPI
specification that defines it, the developer documentation published at
<https://developer.timr.com>, and the client SDKs generated from it.

## How it fits together

The specification is the contract. The documentation renders it, and the SDK sources are generated
from it. A specification update regenerates the clients; publishing new SDK packages is a separate
step.

```
spec/openapi.yaml ──┬── site/  →  developer.timr.com
                    └── sdk/   →  one client library per language
```

The specification is maintained together with the service and published here with each release. It
is therefore not edited in this repository — see [CONTRIBUTING.md](CONTRIBUTING.md) if something in
it looks wrong or missing.

The specification and each SDK are versioned independently — see [VERSIONING.md](VERSIONING.md)
for how they move and what a release of each kind means for an integration.

## Client SDKs

Registry links below identify each SDK's publishing destination; a release may not yet be available
there. Swift publication is postponed.

| Client | Package | Registry |
| --- | --- | --- |
| Java, Spring `RestClient` | [com.timr:timr-api-restclient][restclient-package] | [![Maven Central][maven-registry]][restclient-package] |
| Java, Spring `RestTemplate` | [com.timr:timr-api-resttemplate][resttemplate-package] | [![Maven Central][maven-registry]][resttemplate-package] |
| Kotlin, OkHttp and coroutines | [com.timr:timr-api-kotlin][kotlin-package] | [![Maven Central][maven-registry]][kotlin-package] |
| C# / .NET | [timr.Api][nuget-package] | [![NuGet][nuget-registry]][nuget-package] |
| TypeScript / JavaScript, `fetch` | [timr-api][npm-package] | [![npm][npm-registry]][npm-package] |
| Python | [timr-api][python-package] | [![PyPI][python-registry]][python-package] |
| [Swift, Alamofire and async/await](sdk/swift/) | — | Not published |

[restclient-package]: https://central.sonatype.com/artifact/com.timr/timr-api-restclient
[resttemplate-package]: https://central.sonatype.com/artifact/com.timr/timr-api-resttemplate
[kotlin-package]: https://central.sonatype.com/artifact/com.timr/timr-api-kotlin
[maven-registry]: https://img.shields.io/badge/Maven_Central-SDK-blue?logo=apachemaven
[nuget-package]: https://www.nuget.org/packages/timr.Api
[nuget-registry]: https://img.shields.io/badge/NuGet-SDK-004880?logo=nuget
[npm-package]: https://www.npmjs.com/package/timr-api
[npm-registry]: https://img.shields.io/badge/npm-SDK-CB3837?logo=npm
[python-package]: https://pypi.org/project/timr-api/
[python-registry]: https://img.shields.io/badge/PyPI-SDK-3776AB?logo=pypi

### Java and Kotlin — Gradle Kotlin DSL

Choose one client. This example uses Spring `RestClient`; replace its dependency with the
`RestTemplate` or Kotlin coordinate from the table to use another client.

Replace `<sdk-version>` with the SDK version to install. The Spring clients need the Spring Boot BOM
on Gradle's compile classpath; use the BOM version from the chosen SDK's published POM for
`<spring-boot-version>`. The Kotlin client does not need that platform dependency.

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:<spring-boot-version>"))
    implementation("com.timr:timr-api-restclient:<sdk-version>")
}
```

### .NET

```sh
dotnet add package timr.Api
```

### TypeScript / JavaScript

```sh
npm install timr-api
```

Types are included. The package page contains the README for the published version; the source
README in this repository can describe changes that have not been uploaded yet.

### Python

```sh
python -m pip install timr-api
```

Import it as `timr_api`.

## Layout

### `spec/`

`openapi.yaml` is the API contract, written in OpenAPI format. It describes every
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

The generated sources are committed. They are produced by
[OpenAPI Generator](https://openapi-generator.tech) and regenerated whenever the specification
changes. Custom template differences are recorded in
[sdk/custom-template-changes.md](sdk/custom-template-changes.md); fixes supplied by the generator
use its upstream templates. The Java clients maintain their own `ApiClient` implementations and
exclude supporting files that only apply to the upstream client. Each package is built from a
particular commit, which records the contract it speaks;
the current source tree can contain changes that have not been published yet.

SDKs are published independently through `<module>/<version>` tags, with approval through the
`Release` environment. Build, package validation and registry authentication instructions are in
[sdk/README.md](sdk/README.md).

A bare `<version>` tag releases the API contract. After verifying the generated sources and SDKs,
the workflow creates a GitHub Release linking to the documentation. If a release already exists for
that tag, it keeps its title and notes unchanged and succeeds.

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

The TypeScript SDK uses one `sdk/typescript-fetch/tsconfig.json` to check its sources and
`tsdown.config.mjs` to bundle ESM and CommonJS with matching declarations into `dist/`. Its
`package.json` exports select the format for `import` and `require`. Run `npm ci` and `npm test` in
`sdk/typescript-fetch/` using Node 24. The tests cover request behavior and an installed tarball's
Node entry points, public types and browser bundling.

## Contributing

Questions, bug reports and pull requests are welcome — see [CONTRIBUTING.md](CONTRIBUTING.md). We are
especially interested in how the API and its SDKs hold up in real integrations.
