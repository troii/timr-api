package com.timr.api.app;

import com.timr.api.TimrAutoConfiguration;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

class AutoConfigurationImportsTest {

    /**
     * Spring Boot only applies the auto-configuration if this file names it. The context test above
     * registers the class by hand, so it passes either way — this is what proves consumers get it.
     */
    @Test
    void autoConfigurationIsRegistered() throws Exception {
        try (InputStream imports = getClass().getClassLoader().getResourceAsStream(
                "META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports")) {
            assertThat(imports).as("AutoConfiguration.imports is missing from the jar").isNotNull();
            assertThat(new String(imports.readAllBytes(), StandardCharsets.UTF_8).lines())
                    .contains(TimrAutoConfiguration.class.getName());
        }
    }
}
