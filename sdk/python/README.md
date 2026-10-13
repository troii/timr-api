# timr-api

Official Python client for the [timr](https://www.timr.com) API.

The timr API exposes the recordings a user makes — working times, project times and drive
logs — together with the master data they refer to: users, teams, tasks, cars, working time
types, work schedule models and holiday calendars.

**Full API reference: [developer.timr.com](https://developer.timr.com)**

## Requirements

Python 3.11+

## Installation

```sh
pip install timr-api
```

## Usage

```python
import os
import timr_api

configuration = timr_api.Configuration()
configuration.access_token = os.environ["TIMR_ACCESS_TOKEN"]

with timr_api.ApiClient(configuration) as api_client:
    cars = timr_api.CarApi(api_client).fetch_cars()
    for car in cars.data:
        print(f"{car.name} ({car.plate})")
```

`Configuration` defaults to `https://api.timr.com/v1`; pass `host=` to point at another
environment. See `timr_api/configuration.py` for the full set of parameters.

## Authentication

The API uses OAuth 2.0. Two flows are supported:

| Flow | Use for | Scopes |
| --- | --- | --- |
| `client_credentials` | server-to-server integrations acting as the client | `openid`, `timrclient` |
| `authorization_code` (with PKCE) | acting on behalf of a timr user | `openid`, `offline_access` |

Authorization endpoint: `https://system.timr.com/id/oauth2/authorize`

Obtain a token through your OAuth library of choice and assign it to
`configuration.access_token`.

## Support

[info@timr.com](mailto:info@timr.com)

## License

Apache License 2.0
