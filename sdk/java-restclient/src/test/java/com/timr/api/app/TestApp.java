package com.timr.api.app;

import com.timr.api.ApiClient;
import com.timr.api.TimrAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(TimrAutoConfiguration.class)
public class TestApp {

    @Bean
    public ApiClient apiClient() {
        return new ApiClient();
    }

}
