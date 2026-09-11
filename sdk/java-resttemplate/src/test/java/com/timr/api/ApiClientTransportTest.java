package com.timr.api;

import org.junit.jupiter.api.Test;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

class ApiClientTransportTest {

    /**
     * The contract has PATCH operations, and the JDK's HttpURLConnection — what a plain
     * {@code new RestTemplate()} uses — refuses that method outright. The default client therefore has
     * to be built on the Apache factory, or every PATCH call fails for consumers.
     */
    @Test
    void theSharedFactoryCanSendPatchAndIsSharedAcrossClients() {
        assertThat(ApiClient.sharedRequestFactory())
                .isInstanceOf(HttpComponentsClientHttpRequestFactory.class)
                .isSameAs(ApiClient.sharedRequestFactory());
    }

    @Test
    void defaultClientUsesTheSharedFactory() throws Exception {
        assertThat(restTemplateOf(new ApiClient()).getRequestFactory())
                .isSameAs(ApiClient.sharedRequestFactory());
    }

    @Test
    void userAgentCarriesTheClientVersion() {
        assertThat(new ApiClient().defaultHeaders.getFirst("User-Agent"))
                .startsWith("timr-api-resttemplate/");
    }

    /** The RestTemplate is deliberately not exposed, see ApiClientJackson3Test. */
    private static RestTemplate restTemplateOf(ApiClient client) throws Exception {
        Field field = ApiClient.class.getDeclaredField("restTemplate");
        field.setAccessible(true);
        return (RestTemplate) field.get(client);
    }
}
