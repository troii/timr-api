package com.timr.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.jupiter.api.Test;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestClient;

import java.time.OffsetDateTime;
import java.text.DateFormat;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

class ApiClientJackson3Test {

    private final tools.jackson.databind.json.JsonMapper mapper =
            ApiClient.createDefaultMapper(ApiClient.createDefaultDateFormat());

    @Test
    void doesNotExposeMapperOrRestClient() throws Exception {
        var mapperFactory = ApiClient.class.getDeclaredMethod("createDefaultMapper", DateFormat.class);

        assertFalse(Modifier.isPublic(mapperFactory.getModifiers()));
        assertThrows(NoSuchMethodException.class, () -> ApiClient.class.getMethod("getRestClient"));
    }

    @Test
    void preservesJsonNullableUndefinedNullAndValueStates() throws Exception {
        var undefined = mapper.readValue("{}", NullablePayload.class);
        var explicitNull = mapper.readValue("{\"value\":null}", NullablePayload.class);
        var present = mapper.readValue("{\"value\":\"timr\"}", NullablePayload.class);

        assertFalse(undefined.value.isPresent());
        assertTrue(explicitNull.value.isPresent());
        assertNull(explicitNull.value.get());
        assertEquals("timr", present.value.get());

        assertEquals("{}", mapper.writeValueAsString(undefined));
        assertEquals("{\"value\":null}", mapper.writeValueAsString(explicitNull));
        assertEquals("{\"value\":\"timr\"}", mapper.writeValueAsString(present));
    }

    @Test
    void preservesRfc3339OffsetWhenReadingAndWriting() throws Exception {
        var input = "2023-10-10T12:00:00.123+02:00";

        var payload = mapper.readValue("{\"value\":\"" + input + "\"}", DateTimePayload.class);

        assertEquals(OffsetDateTime.parse(input), payload.value);
        assertEquals("{\"value\":\"" + input + "\"}", mapper.writeValueAsString(payload));
    }

    @Test
    void usesTheConfiguredRestClientBuilderAndJackson3Converter() {
        var builder = RestClient.builder();
        var server = MockRestServiceServer.bindTo(builder).build();
        var client = new ApiClient(builder);
        client.setBasePath("https://example.test");
        var input = "2023-10-10T12:00:00.123+02:00";

        server.expect(requestTo("https://example.test/value"))
                .andRespond(withSuccess("{\"value\":\"" + input + "\"}", MediaType.APPLICATION_JSON));

        var response = client.invokeAPI(
                "/value",
                HttpMethod.GET,
                Map.of(),
                new LinkedMultiValueMap<>(),
                null,
                new HttpHeaders(),
                new LinkedMultiValueMap<>(),
                new LinkedMultiValueMap<>(),
                List.of(MediaType.APPLICATION_JSON),
                null,
                new String[0],
                new ParameterizedTypeReference<DateTimePayload>() {});
        var payload = response.body(DateTimePayload.class);

        assertEquals(OffsetDateTime.parse(input), payload.value);
        server.verify();
    }

    static final class NullablePayload {
        @JsonProperty("value")
        public JsonNullable<String> value = JsonNullable.undefined();
    }

    static final class DateTimePayload {
        @JsonProperty("value")
        public OffsetDateTime value;
    }
}
