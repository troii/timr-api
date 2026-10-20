---
name: write-openapi-release-notes
description: Write consumer-facing release notes for a timr OpenAPI contract release from the specification diff, following the previous GitHub release. Use for spec release notes and backfilling existing GitHub releases; SDK package releases have their own versioning and publication flow.
---

# Write OpenAPI release notes

Write English notes for API consumers from the difference between two released contracts. Read `VERSIONING.md`, the current release workflow, and the previous contract release before drafting. The contract version comes from `spec/openapi.yaml`; SDK versions and backend software versions are independent.

## Establish the comparison

Resolve the target to an exact merged commit and verify its `info.version`. Find the preceding stable bare-version release reachable from that commit, excluding SDK module tags, drafts and prereleases. Inspect its stored GitHub release notes to preserve the established editorial style.

Compare `spec/openapi.yaml` at those two refs, including referenced schemas and responses. Use a YAML parser to inspect their complete definitions. Commit messages and generated SDK diffs can corroborate the contract but cannot establish API behavior. Never edit the specification here.

For a publication request, check existing tags, releases and release runs first. Reuse completed work; never move an existing release tag. `VERSIONING.md` requires the API to serve the announced behavior before publishing. Resolve any actual availability uncertainty rather than claiming a rollout from the spec alone.

## Write for integration authors

Lead with the changed capability. Group related endpoints into compact sections; use method/path headings or `http` blocks with the actual contract paths, including the `/v1` server prefix when showing a request. Explain what an integration can now do and the constraints that affect it.

Include the success responses and meaningful failure cases, naming which operations they apply to. Do not imply that every endpoint shares a response code merely because one does. Show a short request or response example when the interaction needs one; keep examples consistent with required fields, nullability and formats.

Prioritize non-obvious consumer behavior: pagination, inherited versus direct results, synchronization effects, temporary URLs, authentication boundaries, permissions, mutability and upload completion. State limits only as precisely as the contract supports. An additive change can be described as backward compatible only after checking the rest of the diff for removals or altered behavior.

Mention generated SDK operations only when useful, using their contract `operationId` or noting language-specific naming. Say that SDK packages are published separately unless registry publication has actually been verified. Keep generator changes, implementation history, CI logs, internal work-item references and unrelated dependency updates out of contract notes.

Rely on GitHub's built-in release comparison feature; do not append a manual comparison footer. Follow the previous release's level of detail; a small correction needs less prose than a new multi-step API.

## Save, verify and publish within scope

Publish the notes on the corresponding GitHub Release. Use GitHub's release history and comparison links; do not duplicate release notes in `site/guides/`.

For a backfill, inspect the existing body and preserve correct consumer guidance. Compare each release with its own predecessor. For the initial release, describe the tagged contract as the baseline without inventing a preceding release. Update release text without moving tags or changing release dates.

Verify every endpoint, field, status and behavioral claim against the tagged contracts. Confirm that no implementation-only changes have slipped into the notes.

Preparing notes does not authorize a tag push or GitHub release write. Follow the user's existing authorization and repository approval rules. For an approved publication, use a real Markdown body file and read the stored title and full body back afterwards. The current contract workflow preserves an existing GitHub release; inspect the workflow at the release commit before choosing the publication sequence so it cannot replace the authored notes with its placeholder.

A bare contract tag publishes the contract release. Module/version tags publish SDK packages and require their own scope and authorization. Report the verified release URL and workflow outcome; do not describe a queued run as a completed release.
