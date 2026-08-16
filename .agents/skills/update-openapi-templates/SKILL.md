---
name: update-openapi-templates
description: Reconcile the custom OpenAPI Generator Mustache templates in sdk/java-restclient and sdk/java-resttemplate against upstream after a generator version bump, then regenerate and verify. Use when the openapi-generator version changes, when generation fails with a Mustache parse error, or when checking whether our templates have drifted from upstream.
---

# Update OpenAPI Generator templates

Four SDK modules override generator templates. When the generator version is bumped, upstream
changes must be reconciled into those overrides.

Our deliberate divergences are recorded in `sdk/custom-template-changes.md`. **Read it first** — it is
the list of things a reconciliation must preserve, and each entry says what breaks if it is lost.

## Overridden templates

```
sdk/java-restclient/templates/     (java, library restclient)
sdk/java-resttemplate/templates/   (java, library resttemplate)
sdk/swift/templates/               (swift5)
sdk/python/templates/              (python)
```

Reconcile each against the upstream directory for **its own** generator.

## Steps

### 1 — Identify the versions

```bash
git log --oneline -10 -- gradle/libs.versions.toml
grep -n 'openapi' gradle/libs.versions.toml
```

### 2 — Extract the upstream templates for the version we run

Take them from the generator jar, not GitHub, so they match the running version exactly:

```bash
V=7.22.0
JAR=$(find ~/.gradle/caches/modules-2/files-2.1/org.openapitools/openapi-generator/$V \
  -name "openapi-generator-$V.jar" ! -name '*sources*' | head -1)
unzip -o "$JAR" 'Java/*' -d /tmp/upstream-$V
```

### 3 — Diff against the *library-specific* baseline

The `java` generator resolves `pojo.mustache` per library. Diffing against the generic
`Java/pojo.mustache` gives plausible but wrong results — it lacks the JSpecify type-position wiring
these libraries use, and reconciling against it silently drops nullability annotations.

| Module | Baseline |
| --- | --- |
| `sdk/java-restclient` | `Java/libraries/restclient/pojo.mustache` |
| `sdk/java-resttemplate` | `Java/libraries/resttemplate/pojo.mustache` |

The two differ from each other — reconcile each module separately.

Our copies follow upstream formatting. If a diff is unreadable because of indentation noise, compare
whitespace-insensitively (`diff -uwB`) to find the semantic changes.

### 4 — Reconcile

Prefer re-forking from the upstream baseline and re-applying the divergences in
`sdk/custom-template-changes.md` over hand-patching our copy. Re-forking picks up upstream fixes that
are dormant for our spec today (they render nothing now, but will if the spec grows into them);
hand-patching only ever finds what you already went looking for.

Classify each upstream change:

- **Cosmetic / structural** — take it as-is.
- **Touches `required` / `isNullable` / `x-is-jackson-optional-nullable`** — re-apply through the
  polarity swap in change (1) of `custom-template-changes.md`.
- **New upstream behaviour we do not customise** — take it, and do not document it.
- **Superseded by one of our divergences** — skip, and check the divergence still reads correctly
  against the new upstream code.

### 5 — Check tag balance before generating

A mismatched section tag fails generation with `Section close tag with mismatched open tag`, naming a
line in the *rendered* partial rather than in the file at fault. Verify balance directly:

```bash
python3 - sdk/java-restclient/templates/pojo.mustache <<'PY'
import re, sys
stack = []
for m in re.finditer(r'\{\{([#^/])([^}]+)\}\}', open(sys.argv[1]).read()):
    kind, name = m.group(1), m.group(2).strip()
    if kind in '#^':
        stack.append(name)
    else:
        assert stack and stack[-1] == name, f"close {name} vs open {stack[-1] if stack else None}"
        stack.pop()
assert not stack, f"unclosed: {stack}"
print("balanced")
PY
```

### 6 — Regenerate and build

Compilation depends on generation, so a build regenerates first:

```bash
source "$HOME/.sdkman/bin/sdkman-init.sh" && sdk env && \
  ./gradlew :java-restclient:build :java-resttemplate:build
```

### 7 — Verify against the previous output

Copy the generated models aside *before* regenerating, then compare. Whitespace will move when
upstream reformats; what matters is that these hold:

- `toString` line count unchanged — the `x-log` privacy allow-list survived
- no `_JsonNullable` occurrences — the public API shape survived
- `JsonNullable<@Nullable` present — JSpecify annotates the value, not the wrapper
- `@Nullable` in type position (`private @Nullable String x;`)
- no `@jakarta.annotation.Nullable` / `Nonnull` left in models

The `toString` check is the important one: losing it is invisible in a build and starts writing
personal data to logs.

### 8 — Update the documentation

Revise `sdk/custom-template-changes.md` so it describes only what still differs from upstream. Drop
entries that upstream has absorbed.

### 9 — Commit

Commit the templates, the regenerated sources and the documentation together:

```
Update OpenAPI generator templates to v<NEW_VERSION>
```
