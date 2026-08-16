# Custom OpenAPI Generator templates

The Java, Swift and Python SDK modules override some of the generator's Mustache templates. This
file records only what **differs** from upstream, so a version bump can be reconciled by diffing our
copy against the matching upstream file and checking each difference below still applies.

Generator version: **7.22.0** (`libs.plugins.openapi`).

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

`projectName` is `Timr`, which is what makes the generated API class read `TimrAPI`. Upstream ties
the Swift module, the SwiftPM package and the pod name to that same property, which would make them
`Timr` too, so three overrides pull the packaging identity back to `TimrApi`:

- **`Package.swift.mustache`** and **`Podspec.mustache`** — these read `{{moduleName}}` where
  upstream reads `{{projectName}}`, and nothing else differs. `moduleName` is passed through
  `additionalProperties` in `build.gradle`, so both names stay single-sourced there rather than
  baked into a template. (`configOptions` does *not* reach the template context for this generator;
  `additionalProperties` does.)
- The generator names the podspec file after `projectName` in *code*, not in a template, so
  `openApiGenerate` is finalized by a `renamePodspec` task that moves `Timr.podspec` to
  `TimrApi.podspec`. CocoaPods requires the filename to match the pod name.

Neither file is frozen, so the pod version keeps tracking `info.version` from the specification.
`Package.swift` carries no version at all — SwiftPM resolves versions from git tags.

- **`APIs.mustache`** — `Task` is written as `_Concurrency.Task`, because the API has a `Task`
  schema whose generated model shadows Swift's `Task` and breaks `Task.checkCancellation()`.
  `addCredential()` also returns `Self` and is no longer called from the initializer, so credentials
  are attached explicitly rather than on every request.

## Python

Upstream baseline: `python/*.mustache`.

- **`setup.mustache`** — `PYTHON_REQUIRES` is `>= 3.9`. Upstream hardcodes `>= 3.10` there while
  `pyproject.mustache` hardcodes `>=3.9`, so the two shipped files contradict each other and neither
  is configurable. The generated code is 3.9-compatible — no PEP 604 unions, `typing_extensions.Self`
  rather than `typing.Self` — so 3.9 is the truthful bound.

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
