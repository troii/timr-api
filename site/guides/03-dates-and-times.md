# Dates and times

Date-time values follow [RFC 3339](https://www.rfc-editor.org/rfc/rfc3339.html), the internet profile
of [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html), and always carry an explicit
UTC offset:

```
2021-07-16T09:30:00+02:00
```

Plain dates are `YYYY-MM-DD` and carry no time and no zone:

```
2021-07-16
```

## A date without a year

Something that recurs every year has no year to state, and those fields use the ISO 8601 month-day
form. The leading double hyphen is part of it — it is how ISO 8601 marks a representation with the
year omitted, and a value without it is rejected:

```
--05-20
```

`User.vacation_year_start` is the one field of this kind today: the month and day on which a user's
vacation year begins, which is the same date every year. Read it as a month and a day, not as a date
in the current year — the year it applies to depends on the period you are calculating.

## The offset carries meaning

On a recording — `start`, `end`, and the GPS `timestamp` — the offset is the one on the device the
entry was made on. It is not necessarily UTC, and it is not necessarily the account's time zone.

That makes it information, not formatting. A working time started at `08:00+02:00` was started at
eight in the morning where the person was. Convert it to UTC for storage and you can still show the
right instant, but you have lost what the clock on the wall said — which is usually the thing a
timesheet is about. Keep the offset you were given, and send back the offset that applies where the
recording happened.

Audit timestamps are different. `created`, `last_modified` and their kind are always UTC, and say
when the server acted. Do not infer a device time zone from them.

## Sending values

Send an explicit offset on every date-time you write. RFC 3339 requires one, and `Z` is accepted as
`+00:00`.

## Filtering by day

The filters that narrow a list to a period take plain dates and include both ends. `start_from` and
`start_to` on the recording lists select entries whose **start** falls on or after, and on or before,
the given day — so `start_from=2021-07-01&start_to=2021-07-31` returns everything that started in
July, including entries that run past midnight on the 31st.

Each filter says which property it applies to. `entry_date_from` and `resign_date_to` on the user
list work the same way against employment dates.

## Durations

Durations are **integer minutes**, never ISO 8601 durations. A working time, project time or drive
log carries a `duration` object rather than a bare number:

```json
{
  "duration": {
    "type": "minutes",
    "minutes": 42,
    "minutes_rounded": 45
  }
}
```

`minutes` is the net duration; `minutes_rounded` is the same value after the rounding rule the
account is configured with, which is what most reports and invoices are built on. Read whichever the
integration is meant to reflect, and do not recompute either from `start` and `end` — breaks are
already deducted from them.

`type` says how the duration is expressed. `minutes` is a measured stretch of time; `full_day` and
`half_day` are for absences booked by the day, where timr derives the minutes from the user's work
schedule rather than from a clock. You only send `duration_type` when the working time type is
recorded in days or half days.

Elsewhere, plain minute fields carry their unit in the name — `break_time_total_minutes`,
`target_duration_minutes`, `balance_total_minutes` — and are integers for the same reason.
