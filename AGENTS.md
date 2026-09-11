# timr-api

Guidance for coding agents working in this repository. See `README.md` for what the repository is
and how it is published.

## Keep the README current

`README.md` describes the layout and the publishing flow, and it is what a reader meets first. A
change that adds or moves a directory, retires a file, or alters how anything is published is not
finished until the README says so.

## The specification is read-only here

`spec/openapi.yaml` is maintained together with the service and republished here with every release,
which overwrites the file. Editing it in this repository has no effect and no lifetime; a contract
problem is raised as an issue and corrected at the source.

Everything a generator needs on top of the contract belongs in an overlay, not in the specification:
try-it console settings, environment-specific servers, and generator capabilities such as `x-parent`.
Whether a generator can express inheritance is a property of that generator — the Java modules ask
for it in their own overlay, while Kotlin cannot extend a final data class and flattens instead.

## Overlays

Overlays are [OpenAPI Overlay 1.0](https://spec.openapis.org/overlay/v1.0.0) documents. The format is
what the two builds share; each applies it with the tool native to its own toolchain, because there
is no implementation that serves both. The documentation site applies `spec/overlay.yaml` with
bump-cli through `site/scripts/compose-spec.mjs`. SDK generation applies `sdk/overlay.yaml` to every module and `sdk/<module>/openapi-overlay.yaml` to one, in that order, through `ApplyOpenApiOverlaysTask` — OpenAPI Generator has no overlay support of its own, and its normalizer only offers a fixed set of rules.

**An action whose target matches nothing fails the build, on both sides.** This is deliberate and
stricter than the specification allows, which asks only that such an action be skipped — and a
silently skipped action is how an overlay drifts away from the contract it patches. bump-cli reports
it as a warning and exits successfully, so the site build turns that warning into an error itself.
When a specification sync breaks an overlay, repoint the action; do not delete it without
establishing what its target became.

`x-log` is an allow-list: a field is absent from generated `toString` output unless it is named
there, and `x-log-count` records a collection's size instead of its contents. Adding a field is a
deliberate decision about what may reach a log, not a formality.

## The documentation site

The site is one page: the Scalar reference, with the guides folded into it. A guide is a Markdown
file in `site/guides/`, named `NN-slug.md` so the order is explicit, and starting with a level one
heading that names it. `scripts/compose-spec.mjs` turns each into a tag carrying prose but no
operations and groups it under `Guides` ahead of the API, which is what keeps guides and endpoints in
a single navigation. Add a guide by adding the file; nothing else needs to change.

Only the published copy of the specification carries the guides. Never write prose into
`spec/openapi.yaml` to get it on the site.

A pull request builds the site and attaches it as an artifact; it is not deployed, because the OAuth2
console only completes its flow on a redirect URI registered with the authorization server, and a
preview URL is not one.

## Generated sources are committed

Regenerate and commit whenever the specification or an overlay changes; CI fails on any drift.

```bash
./gradlew openApiGenerate
```

Generation is wired into the build: every task that reads the generated sources declares a dependency
on `openApiGenerate`, so `./gradlew build` regenerates first and a single invocation is fine. This is
what makes a green build meaningful — before the dependency existed, `build` compiled the *previous*
generation's output and passed even when the current templates or specification did not.

Gradle modules are named after their directories under `sdk/`:

```bash
./gradlew :kotlin-okhttp:assemble
```

Each SDK carries its own version in `sdk/versions.properties`; `VERSIONING.md` says when which one
moves.

## Custom generator templates

The Java modules override generator templates under `sdk/java-*/templates`. Every deliberate
divergence from upstream is recorded in `sdk/custom-template-changes.md` — read it before touching a
template, and keep it accurate afterwards.

Two things there are easy to break silently: `toString` is an `x-log` allow-list that keeps personal
data out of logs, and the `java` generator resolves `pojo.mustache` **per library**, so the upstream
baseline is `Java/libraries/<library>/pojo.mustache`, not `Java/pojo.mustache`.

Use the `update-openapi-templates` skill when the generator version changes.

## Skills

Reusable agent workflows live in `.agents/skills/<skill-name>/SKILL.md` — the single source of truth.
Claude Code picks them up through a symlink:

```
.claude/commands/<skill-name>.md -> ../../.agents/skills/<skill-name>/SKILL.md
```

When adding a skill, create the `SKILL.md` (with `name:` and `description:` frontmatter) and the
symlink. Never duplicate the content.
