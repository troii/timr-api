# timr API — TypeScript SDK

TypeScript client for the [timr REST API](https://developer.timr.com), with typed requests and responses using `fetch`.

## Install

```sh
npm install timr-api
```

## Quickstart

Obtain an OAuth2 access token using the [authentication guide](https://developer.timr.com), then pass it with the `Bearer` prefix:

```ts
import { UserApi, WorkingTimeApi, WorkingTimeStatus } from 'timr-api';

const config = {
  accessToken: 'Bearer YOUR_ACCESS_TOKEN',
};

async function main() {
  const user = await new UserApi(config).getUser('USER_ID');
  console.log(user);

  const workingTime = await new WorkingTimeApi(config).createWorkingTime({
    userId: user.id,
    workingTimeTypeId: 'WORKING_TIME_TYPE_ID',
    start: new Date('2026-10-09T09:00:00+02:00'),
    end: new Date('2026-10-09T17:00:00+02:00'),
    changed: false,
    status: WorkingTimeStatus.Changeable,
    notes: 'Office work',
  });
  console.log(workingTime);
}

main().catch(console.error);
```

The client uses `https://api.timr.com/v1` by default. Obtain and refresh tokens in your application; the SDK sends the configured token with each request.

Pass options directly to an API constructor. An `accessToken` callback can read your current token on
each request. Existing callers can continue passing a `Configuration` instance.

`getUser` sends a GET request; `createWorkingTime` sends a POST request with the object as its body. Replace the user and working time type IDs with values from your account. This example uses a working time type recorded in hours.

Pass query filters by name: `new UserApi(config).fetchUsers({ pageToken: 'PAGE_TOKEN', limit: 10 })`.

## API reference

See the [API reference and guides](https://developer.timr.com) for endpoints, request fields, pagination and authentication. Types are included for editor completion.

## Module formats

The package provides native ESM and CommonJS with matching TypeScript declarations. Use the package
entry point in both formats; generated files under `dist/` are not public import paths.

```js
// CommonJS
const { UserApi } = require('timr-api');
```

The ESM `import` form is shown in the quickstart. Browser bundlers resolve the ESM entry point too.

## License

[Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0).
