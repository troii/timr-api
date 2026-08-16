# Pagination

List endpoints are cursor paginated. Ask for a page, and the response tells you how to get the next
one.

```http
GET /v1/working-times?limit=100 HTTP/1.1
```

```json
{
  "data": [ ... ],
  "next_page_token": "eyJpZCI6IjAxSFEzRjhYSzJSN1dZNU40TTZWVDlaQlFEIn0"
}
```

Pass that token back as `page_token` to continue, and keep going until `next_page_token` is `null`:

```http
GET /v1/working-times?limit=100&page_token=eyJpZCI6IjAxSFEzRjhYSzJSN1dZNU40TTZWVDlaQlFEIn0 HTTP/1.1
```

The `Link` header points at the same next page, if you would rather follow it than build the URL.

## What to expect

`limit` sizes the page. It defaults to 20, and values above 500 are capped at 500 rather than
rejected — so asking for a thousand gives you five hundred, not an error.

**There is no total count.** A cursor cannot know one without counting the whole result, so nothing
in the response tells you how many entries match. Do not build a page-number UI on top of this;
iterate until the token is `null`, or show a "load more" affordance.

Keep the other query parameters identical while you page. The token encodes where you stopped in a
particular result, and changing the filter underneath it makes the continuation meaningless.

An empty first page means nothing matched — or that the entries exist but the authenticated user or
client is not permitted to see them.
