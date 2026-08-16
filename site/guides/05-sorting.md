# Sorting

Pass `sort_by` to choose the property and `sort_direction` to choose the direction, `asc` or `dsc`:

```http
GET /v1/working-times?sort_by=start&sort_direction=dsc HTTP/1.1
```

Which properties an endpoint can sort by is part of its own description in the reference — they
differ, because they describe different things.

## Order is stable across pages

Every sort ends with the entry `id` as a tiebreaker. Without one, entries sharing a value could come
back in a different order on each request, and a cursor walking through them could show an entry
twice or skip it entirely. With one, the order is total, and paging through a large result is safe.

The tiebreaker is applied for you; you never pass it.

Sorting by `id` yourself is not meaningful — identifiers are opaque and their order says nothing
about the entries. Sort by a property that means something, such as `start` or `last_modified`.
