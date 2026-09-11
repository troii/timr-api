from pathlib import Path
from unittest.mock import Mock

from timr_api.api.user_api import UserApi
from timr_api.api_client import ApiClient
from timr_api.configuration import Configuration


def test_authenticated_request_reaches_endpoint_and_decodes_response() -> None:
    configuration = Configuration(host="https://example.test/v1", access_token="token-abc")
    client = ApiClient(configuration)
    response = Mock(
        status=200,
        reason="OK",
        data=(Path(__file__).parents[2] / "test-fixtures" / "user.json").read_bytes(),
        headers={"content-type": "application/json"},
    )
    client.rest_client.request = Mock(return_value=response)

    user = UserApi(client).get_user("user123")

    assert user.id == "user123"
    assert user.fullname == "John Doe"
    client.rest_client.request.assert_called_once()
    method, url = client.rest_client.request.call_args.args[:2]
    headers = client.rest_client.request.call_args.kwargs["headers"]
    assert method == "GET"
    assert url == "https://example.test/v1/users/user123"
    assert headers["Authorization"] == "Bearer token-abc"
