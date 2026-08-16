# Identifiers

Every entry the API returns is identified by an `id`, and identifiers are **opaque strings**. Their
format is not part of this contract: do not parse them, derive meaning from them, sort by them, or
assume how long they are. Store them as text, and pass them back unchanged.

```json
{
  "id": "7e05c860-2793-4e0b-938e-5a5641fc981c",
  "external_id": "PAY-2026-00417"
}
```

## Your own identifiers

Fields named `external_id` are yours. They hold the identifier an object has in your system — a
payroll number, a row key, a ticket reference — and timr only stores and returns them. You decide
the format, and you decide whether to set one at all.

They are how you recognise your own records when they come back: write your identifier when you
create the entry, and every later read carries it.

Note that no endpoint filters by `external_id` — you cannot ask timr for the entry with a given one.
An integration that needs to look entries up by its own identifier has to keep the mapping, or fetch
the page it expects and match on the way through.
