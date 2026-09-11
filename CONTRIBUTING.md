# Contributing

Thanks for taking the time. Feedback from real integrations is the most useful thing we can get, so
questions and observations are as welcome as patches.

## Where a change belongs

Most of this repository is generated, which decides where a fix has to be made.

**The specification** — `spec/openapi.yaml` — is maintained together with the service and published
here with each release. Editing it here has no effect: the next release replaces the file. If an
endpoint behaves differently from how it is described, if a field is missing, or if something is
described ambiguously, please open an issue. Include the endpoint, what you expected and what you
observed; we will correct it at the source and it will arrive with the next release.

**The SDKs** in `sdk/` are generated from the specification. Editing generated sources has the same
problem: the next regeneration overwrites them. What *is* worth changing:

- the generator configuration in each module's `build.gradle`
- a module's `openapi-overlay.yaml`, when one language needs something the others do not
- the Mustache templates in a module's `templates/`

If a generated client is awkward to use, an issue describing the awkwardness is more valuable than a
patch to the output — the fix belongs in the configuration or the template, so that it survives.

**The documentation site** in `site/`, and the prose in this repository, can be changed directly.

## Reporting a problem

Please open an issue with the endpoint or SDK involved, the version, what you expected, and what
happened instead. For an SDK, the language and version help; for the API, the request and the
response, with credentials and personal data removed.

Security issues should not be reported through public issues — write to
[security@timr.com](mailto:security@timr.com) instead.

## Pull requests

Run the checks before opening one. Generated sources are committed and CI fails on any difference,
so regenerate and include the result:

```bash
./gradlew openApiGenerate
```

Then build what you touched, as separate invocations from the generation step:

```bash
./gradlew :kotlin-okhttp:assemble
cd site && npm ci && npm run build
```

A pull request that touches the specification or the site builds the documentation, and attaches the
built site as an artifact you can download and open locally.

Keep the commit history readable: a focused change per commit, and a message that says why rather
than what. `AGENTS.md` documents the conventions of this repository in more detail.
