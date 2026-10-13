# Custom OpenAPI Generator templates

The Java, TypeScript, Swift and Python SDK modules override some of the generator's Mustache templates. This
file records only what **differs** from upstream, so a version bump can be reconciled by diffing our
copy against the matching upstream file and checking each difference below still applies.

Generator version: **7.22.0** (`libs.plugins.openapi`).

## All modules — the specification version leaves the header

`Java/licenseInfo.mustache`, `csharp/partial_header.mustache`, `python/partial_header.mustache` and
`typescript-fetch/licenseInfo.mustache` each render `The version of the OpenAPI document: {{version}}`
into every file they head. Overridden to drop that one line, and nothing else.

The version already lives in `spec/openapi.yaml`, in the release tag and in each SDK's own version, so
in a generated file it only means that every specification bump rewrites 775 headers — a diff with no
information in it. There is no setting for this: `hideGenerationTimestamp` covers the date only, and
`DefaultGenerator` writes `version` into the template context unconditionally.

`kotlin-client` and `swift5` never render the line, so those two modules override nothing.

The hand-maintained files under `.openapi-generator-ignore` (`ApiClient.java`, the RFC3339 helpers)
carry a copy of the header that generation no longer touches; the line was removed from them by hand.

## Java

### Upstream source

The `java` generator resolves `pojo.mustache` **per library**, so the upstream baseline is not the
generic `Java/pojo.mustache`:

| Module | Upstream baseline |
| --- | --- |
| `sdk/java-restclient` | `Java/libraries/restclient/pojo.mustache` |
| `sdk/java-resttemplate` | `Java/libraries/resttemplate/pojo.mustache` |

The two library templates differ from each other (`{{>sealed}}`/`{{>permits}}` and the
`additional_properties` partial path), so the modules do **not** share one file. Diffing against
`Java/pojo.mustache` produces plausible but wrong results — it omits the JSpecify type-position
wiring these libraries use.

`nullable_var_annotations.mustache` is upstream **verbatim**; it is present only because a
template directory must supply every partial it references indirectly. Under `useJspecify` the
`jSpecifyNullable` lambda deliberately renders nothing there — the annotation moves to the type
position via `nullableDatatypeWithEnum`.

Extract both from the generator jar rather than GitHub, so the templates match the version we run:

```bash
unzip -o ~/.gradle/caches/modules-2/files-2.1/org.openapitools/openapi-generator/7.22.0/*/openapi-generator-7.22.0.jar 'Java/*' -d /tmp/upstream
```

### Our changes

### Java 1 — Optionality drives `JsonNullable`, not nullability

Upstream keys the `JsonNullable<T>` wrapper on `{{#vendorExtensions.x-is-jackson-optional-nullable}}`
(the property is *nullable*). We key it on `{{^required}}` (the property is *optional*), so every
non-required property is wrapped.

This is the central customisation: the API distinguishes "absent" from "explicitly null", and
`JsonNullable.undefined()` is what carries "absent" through to serialization. A required property is
declared as a plain type even when it is nullable.

Applied as a polarity swap — `{{#…x-is-jackson-optional-nullable}}` → `{{^required}}`,
`{{^…}}` → `{{#required}}`, `{{/…}}` → `{{/required}}`. Mustache closes both `{{#x}}` and `{{^x}}`
with `{{/x}}`, so renaming all three forms is a safe textual transformation.

### Java 2 — `equalsNullable` / `hashCodeNullable` are gated on `openApiNullable`

Consequence of (1). Upstream emits the helpers under
`{{#vendorExtensions.x-jackson-optional-nullable-helpers}}`, which the generator sets only when it
considers a property optional-nullable. Because we call the helpers for every non-required property,
that extension is false for models the helpers are still needed in, so the gate is
`{{#openApiNullable}}` instead — the config option, which is always on here.

Symptom if this is lost: `cannot find symbol: equalsNullable` on models whose optional properties are
not nullable.

### Java 3 — `JsonNullable` is part of the public API

Upstream generates `T getX()` (unwrapping via `.orElse(null)`, annotated `@JsonIgnore`) plus
`JsonNullable<T> getX_JsonNullable()`, and the same split for setters. We generate a single
`JsonNullable<T> getX()` / `void setX(JsonNullable<T>)` pair and no `_JsonNullable` accessors, so
callers see and set the three-state value directly. The plain `setX(T)` is generated for required
properties only.

Changing this is a breaking change for SDK consumers, not a template detail.

### Java 4 — JSpecify annotates the wrapped value, not the wrapper

Where a field or getter is `JsonNullable<…>`, the inner type is rendered with
`{{>nullableDatatypeWithEnum}}`, giving `JsonNullable<@Nullable T>`. Annotating the wrapper instead
would claim the `JsonNullable` reference itself can be null, which it never is — it is initialised to
`JsonNullable.undefined()`.

### Java 5 — `toString` is an allow-list

Upstream prints every property. We print a property only if it carries `x-log`, or its size only if it
carries `x-log-count`. Both are set in `sdk/overlay.yaml`.

This is a privacy control, not formatting: names, plates, e-mail addresses and other personal data
must not reach a log. A refork that restores upstream's unconditional `{{#vars}}` loop silently starts
logging all of it. See `AGENTS.md`.

### Java 6 — Imports

`JsonNullable` and `com.fasterxml.jackson.annotation.*` are prepended, since (1) and (3) reference
them in models where upstream would not.

## Swift

Upstream baseline: `swift5/*.mustache`.

- **`APIs.mustache`** — `Task` is written as `_Concurrency.Task`, because the API has a `Task`
  schema whose generated model shadows Swift's `Task` and breaks `Task.checkCancellation()`.
  `addCredential()` also returns `Self` and is no longer called from the initializer, so credentials
  are attached explicitly rather than on every request.

Generation also removes OpenAPI Generator's `\/` escape from Swift source strings. Swift does not
support that escape, so a schema validation pattern containing a forward slash otherwise makes the
generated package uncompilable.

## Python

Upstream baseline: `python/*.mustache`.

Packaging is defined by the hand-maintained `pyproject.toml`. It and both requirements files are excluded from generation, as is `setup.py`. Gradle stamps the manifest version from `sdk/versions.properties` when packaging, including snapshots.

## TypeScript

Upstream baseline: `typescript-fetch/apis.mustache` from the generator jar. The module uses `useSingleRequestParameter=false` with a custom public calling convention: path parameters and bodies are direct arguments, while query parameters form an operation-specific `Query` type. `Pick<Request, query keys>` reuses the request's field types and optionality. `operationParameters.mustache` renders the signature and `operationRequest.mustache` combines its arguments for the existing `Raw` method. Serialization, validation and response decoding remain upstream.

`QueryArguments<T>` makes the query object optional only when all its properties are optional. Required query fields keep both the object and those fields required. The method's final argument remains `initOverrides`; the query object contains only query parameters. `npm test` covers the public types and request behavior.

## Verifying a refork

Compilation depends on generation, so one invocation regenerates and rebuilds:

```bash
./gradlew :java-restclient:build :java-resttemplate:build
```

Then confirm against the previously generated sources:

- `toString` line count is unchanged — proves (5) survived
- no `_JsonNullable` occurrences — proves (3) survived
- `JsonNullable<@Nullable` appears — proves (4) survived
- `@Nullable` is in type position (`private @Nullable String x;`)

A mismatched Mustache section tag fails generation with
`Section close tag with mismatched open tag`, naming a line in the *rendered* partial rather than our
file, so check tag balance before generating.
