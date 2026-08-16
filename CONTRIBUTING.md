# Contributing

Thanks for taking the time. Feedback from real integrations is the most useful thing we can get, so
questions and observations are as welcome as patches.

## Where a change belongs

**The specification** — `spec/openapi.yaml` — is maintained together with the service and published
here with each release. Editing it here has no effect: the next release replaces the file. If an
endpoint behaves differently from how it is described, if a field is missing, or if something is
described ambiguously, please open an issue. Include the endpoint, what you expected and what you
observed; we will correct it at the source and it will arrive with the next release.

**The documentation site** in `site/`, and the prose in this repository, can be changed directly.

## Reporting a problem

Please open an issue with the endpoint involved, what you expected, and what happened instead,
including the request and the response with credentials and personal data removed.

Security issues should not be reported through public issues — write to
[security@timr.com](mailto:security@timr.com) instead.

## Pull requests

Build what you touched before opening one:

```bash
cd site && npm ci && npm run build
```

A pull request that touches the specification or the site builds the documentation, and attaches the
built site as an artifact you can download and open locally.

Keep the commit history readable: a focused change per commit, and a message that says why rather
than what. `AGENTS.md` documents the conventions of this repository in more detail.
