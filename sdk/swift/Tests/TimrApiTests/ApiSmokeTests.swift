import Foundation
import XCTest
@testable import TimrApi

final class ApiSmokeTests: XCTestCase {
    func testAuthenticatedRequestTargetsEndpointAndFixtureDecodes() throws {
        TimrAPI.basePath = "https://example.test/v1"
        TimrAPI.customHeaders = ["Authorization": "Bearer token-abc"]
        defer {
            TimrAPI.basePath = "https://api.timr.com/v1"
            TimrAPI.customHeaders = [:]
        }

        let request = UserAPI.getUserWithRequestBuilder(id: "user123")
        let fixture = URL(fileURLWithPath: #file)
            .deletingLastPathComponent()
            .deletingLastPathComponent()
            .deletingLastPathComponent()
            .deletingLastPathComponent()
            .appendingPathComponent("test-fixtures/user.json")
        let user = try CodableHelper.jsonDecoder.decode(User.self, from: Data(contentsOf: fixture))

        XCTAssertEqual(request.method, "GET")
        XCTAssertEqual(request.URLString, "https://example.test/v1/users/user123")
        XCTAssertEqual(request.headers["Authorization"], "Bearer token-abc")
        XCTAssertEqual(user.id, "user123")
        XCTAssertEqual(user.fullname, "John Doe")
    }
}
