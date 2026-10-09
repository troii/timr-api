# TimrApi

Official Swift client for the [timr](https://www.timr.com) API.

The timr API exposes the recordings a user makes — working times, project times and drive
logs — together with the master data they refer to: users, teams, tasks, cars, working time
types, work schedule models and holiday calendars.

**Full API reference: [developer.timr.com](https://developer.timr.com)**

## Installation

### Swift Package Manager

Requires Swift 5.5 or newer. The async methods require iOS 13, macOS 10.15, tvOS 13 or watchOS 6.

```swift
.package(url: "https://github.com/troii/timr-api-swift", from: "1.0.0")
```

### CocoaPods

```ruby
pod 'TimrApi', :git => 'https://github.com/troii/timr-api-swift.git', :tag => '1.0.0'
```

## Usage

The generated client is `TimrAPI`. Requests are `async`/`await` and run through Alamofire.

```swift
import TimrApi

TimrAPI.customHeaders = ["Authorization": "Bearer \(accessToken)"]

let cars = try await CarAPI.fetchCars()
for car in cars.data {
    print("\(car.name) (\(car.plate))")
}
```

`TimrAPI.basePath` defaults to `https://api.timr.com/v1`; set it to point at another
environment.

## Authentication

The API uses OAuth 2.0. Two flows are supported:

| Flow | Use for | Scopes |
| --- | --- | --- |
| `client_credentials` | server-to-server integrations acting as the client | `openid`, `timrclient` |
| `authorization_code` (with PKCE) | acting on behalf of a timr user | `openid`, `offline_access` |

Authorization endpoint: `https://system.timr.com/id/oauth2/authorize`

## Support

[info@timr.com](mailto:info@timr.com)

## License

Apache License 2.0
