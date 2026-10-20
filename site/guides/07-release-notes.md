# Release notes

## 1.2.0

### Task and Project Time attachments

List, retrieve, upload and delete files attached to Tasks and running or completed Project Times.
The generated SDKs include APIs and models for both attachment types.

To upload a file, register its metadata with the attachment endpoint, then send the file with a
`PUT` request to the returned `upload.url` before `upload.expires_at`. Send every header returned in
`upload.headers` with its exact value. The storage request needs no additional authentication.
Only completed uploads appear in attachment results; incomplete uploads are discarded automatically.
Project Time uploads accept images only. File sizes and attachment counts are limited.

Download URLs are temporary. Fetch the attachment again to obtain a fresh URL, and handle a null
`download` value. Task attachment results include only files attached directly to that Task; fetch
parent Task attachments separately.

Adding or deleting a Project Time attachment does not update the Project Time's `last_modified`.
Synchronize attachments separately from queries using `last_modified_after`. Attachments of a
completed Project Time can only be deleted while its status is `changeable`.

This contract update is additive; existing endpoints and models are unchanged.
