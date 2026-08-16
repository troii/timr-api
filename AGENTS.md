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

Everything a tool needs on top of the contract belongs in an overlay, not in the specification: the
try-it console settings live in `spec/overlay.yaml`, applied to the contract by the site build.

## Overlays

Overlays are [OpenAPI Overlay 1.0](https://spec.openapis.org/overlay/v1.0.0) documents. The site
applies `spec/overlay.yaml` with bump-cli through `site/scripts/compose-spec.mjs`.

**An action whose target matches nothing fails the build.** This is deliberate and stricter than the
specification allows, which asks only that such an action be skipped — and a silently skipped action
is how an overlay drifts away from the contract it patches. bump-cli reports it as a warning and
exits successfully, so the site build turns that warning into an error itself. When a specification
sync breaks an overlay, repoint the action; do not delete it without establishing what its target
became.

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

