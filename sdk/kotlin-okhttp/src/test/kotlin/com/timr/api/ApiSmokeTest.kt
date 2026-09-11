package com.timr.api

import com.timr.api.apis.UserApi
import com.timr.api.infrastructure.ApiClient
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Path

class ApiSmokeTest {

    private lateinit var server: MockWebServer

    @BeforeEach
    fun startServer() {
        server = MockWebServer()
        server.start()
        ApiClient.accessToken = "token-abc"
    }

    @AfterEach
    fun stopServer() {
        ApiClient.accessToken = null
        server.shutdown()
    }

    @Test
    fun `authenticated request reaches the endpoint and decodes its response`() = runBlocking {
        server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .addHeader("Content-Type", "application/json")
                .setBody(Files.readString(Path.of("..", "test-fixtures", "user.json")))
        )

        val user = UserApi(server.url("/").toString()).getUser("user123")

        assertEquals("user123", user.id)
        assertEquals("John Doe", user.fullname)

        val request = server.takeRequest()
        assertEquals("GET", request.method)
        assertEquals("/users/user123", request.path)
        assertEquals("Bearer token-abc", request.getHeader("Authorization")?.trim())
    }
}
