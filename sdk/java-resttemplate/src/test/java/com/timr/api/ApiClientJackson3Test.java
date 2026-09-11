package com.timr.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.jupiter.api.Test;
import org.openapitools.jackson.nullable.JsonNullable;

import java.time.OffsetDateTime;
import java.text.DateFormat;
import java.lang.reflect.Modifier;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApiClientJackson3Test {

    private final tools.jackson.databind.json.JsonMapper mapper =
            ApiClient.createDefaultMapper(ApiClient.createDefaultDateFormat());

    @Test
    void exposesRestTemplateOnlyThroughConstructorInjection() throws Exception {
        var mapperFactory = ApiClient.class.getDeclaredMethod("createDefaultMapper", DateFormat.class);
        var restTemplateConstructor = ApiClient.class.getDeclaredConstructor(RestTemplate.class);

        assertFalse(Modifier.isPublic(mapperFactory.getModifiers()));
        assertTrue(Modifier.isPublic(restTemplateConstructor.getModifiers()));
        assertThrows(NoSuchMethodException.class, () -> ApiClient.class.getMethod("getRestTemplate"));
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

    static final class NullablePayload {
        @JsonProperty("value")
        public JsonNullable<String> value = JsonNullable.undefined();
    }

    static final class DateTimePayload {
        @JsonProperty("value")
        public OffsetDateTime value;
    }
}
