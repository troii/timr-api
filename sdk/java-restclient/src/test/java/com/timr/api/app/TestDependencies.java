package com.timr.api.app;

import com.timr.api.ApiClient;
import com.timr.api.TimrAutoConfiguration;
import com.timr.api.apis.UserApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = TestApp.class)
@ContextConfiguration(classes = {TimrAutoConfiguration.class})
class TestDependencies {

    @Autowired(required = false)
    private ApiClient apiClient;

    @Autowired(required = false)
    private UserApi userApi;

    @Test
    void test() {
        assertThat(apiClient).isNotNull();
        assertThat(userApi).isNotNull();
    }
}
