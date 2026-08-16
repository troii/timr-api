package com.timr.api;

import com.timr.api.apis.*;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class TimrAutoConfiguration {

    @Bean
    @ConditionalOnBean(ApiClient.class)
    public CarApi carApi(ApiClient apiClient) {
        return new CarApi(apiClient);
    }

    @Bean
    @ConditionalOnBean(ApiClient.class)
    public DriveLogApi driveLogApi(ApiClient apiClient) {
        return new DriveLogApi(apiClient);
    }

    @Bean
    @ConditionalOnBean(ApiClient.class)
    public DriveLogCategoryApi driveLogCategoryApi(ApiClient apiClient) {
        return new DriveLogCategoryApi(apiClient);
    }

    @Bean
    @ConditionalOnBean(ApiClient.class)
    public HolidayCalendarApi holidayCalendarApi(ApiClient apiClient) {
        return new HolidayCalendarApi(apiClient);
    }

    @Bean
    @ConditionalOnBean(ApiClient.class)
    public ProjectTimeApi projectTimeApi(ApiClient apiClient) {
        return new ProjectTimeApi(apiClient);
    }

    @Bean
    @ConditionalOnBean(ApiClient.class)
    public TaskApi taskApi(ApiClient apiClient) {
        return new TaskApi(apiClient);
    }

    @Bean
    @ConditionalOnBean(ApiClient.class)
    public TimeAccountApi timeAccountApi(ApiClient apiClient) {
        return new TimeAccountApi(apiClient);
    }

    @Bean
    @ConditionalOnBean(ApiClient.class)
    public TrackApi trackApi(ApiClient apiClient) {
        return new TrackApi(apiClient);
    }

    @Bean
    @ConditionalOnBean(ApiClient.class)
    public UserApi userApi(ApiClient apiClient) {
        return new UserApi(apiClient);
    }

    @Bean
    @ConditionalOnBean(ApiClient.class)
    public WorkingTimeApi workingTimeApi(ApiClient apiClient) {
        return new WorkingTimeApi(apiClient);
    }

    @Bean
    @ConditionalOnBean(ApiClient.class)
    public WorkingTimeDateSpanApi workingTimeDateSpanApi(ApiClient apiClient) {
        return new WorkingTimeDateSpanApi(apiClient);
    }

    @Bean
    @ConditionalOnBean(ApiClient.class)
    public WorkingTimeTypeApi workingTimeTypeApi(ApiClient apiClient) {
        return new WorkingTimeTypeApi(apiClient);
    }

    @Bean
    @ConditionalOnBean(ApiClient.class)
    public WorkScheduleModelApi workScheduleModelApi(ApiClient apiClient) {
        return new WorkScheduleModelApi(apiClient);
    }

}
