# SDK maintenance

Build, validate and publish the generated client SDKs. For package links and installation examples,
see the [repository README](../README.md#client-sdks). Run commands from the repository root unless
a different working directory is stated.

## Publishing SDKs

Each SDK's stable publishing version is declared in [versions.properties](versions.properties).
This file is build configuration; it does not mean that the version is already available on a registry.

A `<module>/<version>` tag, such as `python/<version>`, publishes one SDK. The tag must point to a commit
on `main` and match the module's declared version. The **[Release](../.github/workflows/release.yml)**
workflow runs the SDK checks and requires approval through the `Release` environment before
uploading. A bare contract version tag creates the API's GitHub release; SDK publications use their
own tags.

Swift publication is postponed; its publishing workflow is prepared as described below.

### Swift publication

The Swift client is distributed from [troii/timr-api-swift](https://github.com/troii/timr-api-swift),
with `Package.swift` at the repository root. A `swift/<version>` tag here exports the committed
`sdk/swift/` history and publishes a matching bare version tag there. The destination's branches
are not updated. SwiftPM consumes the version tag; CocoaPods can use the same Git repository and
tag with the included `TimrApi.podspec`. No CocoaPods Trunk upload is configured.

Create the destination as a public repository before the first publication. The release workflow
needs a fine-grained GitHub token in the `Release` environment, restricted to the destination
repository with Contents read/write permission. The source repository's `GITHUB_TOKEN` cannot
write to a different repository.

Run `swift test --package-path sdk/swift` locally. **Validate Publishing**, with `module=swift`,
exports and tests the standalone package and attaches its source archive without publishing.
Swift snapshots are not configured; use the validation artifact to inspect an unpublished build.

### Authentication

The [release workflow](../.github/workflows/release.yml) defines the required credentials, variables
and environment. Maven uses registry credentials and a signing key. NuGet, npm and PyPI use GitHub
OIDC Trusted Publishing to obtain short-lived credentials.

NuGet's publishing user must be the account that created its trust policies. The package owner
selected in the policy can differ.

### Building and validating packages

**[Validate Publishing](../.github/workflows/validate-publishing.yml)** builds the selected module and
attaches its packages without uploading to a registry. It also checks package metadata and tests
installed packages where configured. Successful publishing jobs link the uploaded version in
their Actions summary.

For local builds, run Gradle commands from the repository root. TypeScript's `npm ci` and `npm test`
run in `sdk/typescript-fetch/`; Python packaging needs `build` installed in the active Python
environment.

| SDK | Build or pack command | Output |
| --- | --- | --- |
| JVM clients | `./gradlew :<module>:assemble :<module>:test` | `sdk/<module>/build/libs/` |
| .NET | `./gradlew :dotnet:dotnetTest :dotnet:dotnetPack` | `sdk/dotnet/build/nuget/` |
| TypeScript | `./gradlew :typescript-fetch:npmPack` after `npm ci` and `npm test` | `sdk/typescript-fetch/build/npm/` |
| Python | `./gradlew :python:pythonPack` | `sdk/python/build/dist/` |

TypeScript packing stamps `package.json` and `package-lock.json` with the publication version.
Python packing regenerates the package with its publication version. Their hand-maintained READMEs
are preserved during generation.
