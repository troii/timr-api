package com.timr.api.app;

import com.timr.api.ApiClient;
import com.timr.api.TimrAutoConfiguration;
import com.timr.api.apis.CarApi;
import com.timr.api.apis.DriveLogApi;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TimrAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(TimrAutoConfiguration.class));

    @Test
    void testCarApiBeanCreation() {
        this.contextRunner.withUserConfiguration(ApiClientConfiguration.class)
                .run(context -> {
                    assertThat(context).hasSingleBean(CarApi.class);
                });
    }

    @Test
    void testDriveLogApiBeanCreation() {
        this.contextRunner.withUserConfiguration(ApiClientConfiguration.class)
                .run(context -> {
                    assertThat(context).hasSingleBean(DriveLogApi.class);
                });
    }


    @Configuration
    static class ApiClientConfiguration {
        @Bean
        public ApiClient apiClient() {
            return new ApiClient();
        }
    }
}
