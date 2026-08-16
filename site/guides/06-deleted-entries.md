# Deleted entries

An integration that keeps its own copy of timr data faces a problem the ordinary list endpoints
cannot solve: an entry that was deleted simply stops appearing, and nothing tells you it was ever
there.

Endpoints ending in `:deleted` close that gap. They list the entries that were deleted, so you can
remove them from your copy too:

```http
GET /v1/working-times:deleted HTTP/1.1
```

They return the `id`, along with `last_modified` and `last_modified_by` recording when the deletion
happened and who made it — not the original content, which is gone. Match the `id` against what you
hold and drop it.

## Reconciling

A sync that only ever adds and updates will drift. A complete pass is:

1. Fetch what changed since your last run from the ordinary list endpoint.
2. Fetch the deletions from the matching `:deleted` endpoint for the same period.
3. Apply both, and record when you ran.

Deleted entries are paginated and sorted like every other list, so the same rules apply — page until
`next_page_token` is `null`, and keep your filters identical while you do.
