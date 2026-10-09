# Versioning

Three numbers describe this API. They move at different rates, so they are kept apart.

## The path version

`/v1/` in the server URL is the compatibility boundary. It changes only when the contract breaks, and a
new path version does not retire the old one: both stay served while integrations depend on them.

## The specification version

`info.version` is the version of the published contract — what the documentation shows and what a
release note attaches to. It is not a build number and does not track the software behind the API.

Under a stable path version it moves semantically: **minor** for anything additive (an endpoint, a
field, an enum value), **patch** for a correction that leaves the shape alone (a description, an
example). A break is not a major bump; it is a new path version.

A version is published only once the API serves what it describes. Anything a release announces can
be called the day it is published.

Every release ships release notes as a guide, in the same navigation as the rest of the documentation.
They are written against the difference between two releases, not from memory: the difference says
what changed, the notes say what is worth acting on.

## SDK versions

Each SDK carries its own semantic version, describing its own surface rather than the contract's. A
generator upgrade that renames methods, a language baseline that drops a runtime, or a package rename
breaks callers while the contract stands still, and a version derived from the contract has no field
left to say so.

An SDK bumps **major** when its surface breaks, including when it moves to a new path version;
**minor** when regenerating against a new contract adds to it; **patch** for generator, template or
packaging fixes. Majors may move together on a new path version and may drift apart afterwards.
Versions are declared in `sdk/versions.properties`; `sdk/bump-versions.sh minor` carries the whole set
through a contract change, `patch <sdk>` moves the clients a fix belongs to, and a major stays a hand
edit.

Which contract an SDK was generated from is recorded by the commit that built it: specification and
SDKs live in this repository at one revision. The `User-Agent` names the SDK and its version —
`timr-sdk-python/3.1.0` — and nothing else.

## Publishing

A release is a tag. A bare version — `1.4.0` — releases the contract and is the GitHub release to
watch for API changes. A module tag — `java-restclient/1.2.0` or `dotnet/1.2.0` — publishes that one SDK
at that version and nothing else. A `swift/<version>` tag exports the Swift SDK to its dedicated
repository under the bare `<version>` tag used by SwiftPM and CocoaPods Git dependencies.
A `python/<version>` tag publishes the Python wheel and source distribution to PyPI.

## Release types

A contract update regenerates every SDK. A contract release is accompanied by new releases of the
SDKs. An SDK release does not imply a
contract release.

| Change | Version affected | Published |
| --- | --- | --- |
| The contract changes | specification minor or patch, SDK minor | documentation, release notes, SDKs |
| A guide or the site changes | none | documentation |
| A generator, template or packaging fix | SDK patch | the SDKs concerned |
