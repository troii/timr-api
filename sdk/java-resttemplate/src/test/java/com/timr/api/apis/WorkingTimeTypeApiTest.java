package com.timr.api.apis;

import com.timr.api.ApiClient;
import com.timr.api.models.DurationUnit;
import com.timr.api.models.RecordingModeUser;
import com.timr.api.models.WorkingTimeTypeCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

class WorkingTimeTypeApiTest {

    private static final String BASE_PATH = "http://localhost:8080/";

    private MockRestServiceServer server;
    private WorkingTimeTypeApi workingTimeTypeApi;

    @BeforeEach
    void setUp() {
        var restTemplate = new RestTemplate();
        server = MockRestServiceServer.bindTo(restTemplate).build();

        ApiClient apiClient = new ApiClient(restTemplate);
        apiClient.setBasePath(BASE_PATH);
        apiClient.getAuthentication().setAccessToken("dummyToken");
        workingTimeTypeApi = new WorkingTimeTypeApi(apiClient);
    }

    @Test
    void getWorkingTimeTypes() {
        //given
        server.expect(requestTo(BASE_PATH + "working-time-types"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("""
                        {
                           "next_page_token": "string",
                           "data": [
                             {
                               "id": "id",
                               "name": "example",
                               "short_name": "exmpl",
                               "description": "attendance type",
                               "external_id": "external id",
                               "edit_unit": "minutes",
                               "category": "attendance_time",
                               "sub_category": "present",
                               "recording_mode_user": "not_allowed",
                               "archived": true
                             }
                           ]
                         }
                        """, MediaType.APPLICATION_JSON));

        // when
        var workingTimes = workingTimeTypeApi.fetchWorkingTimeTypes(null, null, null, null, null, null, null, null, null, null, null, null);

        // then
        server.verify();
        var workingTimeType = workingTimes.getData().get(0);
        assertEquals("id", workingTimeType.getId());
        assertEquals("example", workingTimeType.getName());
        assertEquals("exmpl", workingTimeType.getShortName());
        assertEquals("attendance type", workingTimeType.getDescription());
        assertEquals("external id", workingTimeType.getExternalId());
        assertEquals(true, workingTimeType.getArchived());
    }

    @Test
    void getWorkingTimeType() {
        //given
        server.expect(requestTo(BASE_PATH + "working-time-types/id"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("""
                        {
                               "id": "id",
                               "name": "example",
                               "short_name": "exmpl",
                               "description": "attendance type",
                               "external_id": "external id",
                               "edit_unit": "days",
                               "category": "paid_time_off",
                               "recording_mode_user": "by_request",
                               "archived": false
                         }
                        """, MediaType.APPLICATION_JSON));

        // when
        var workingTimeType = workingTimeTypeApi.getWorkingTimeType("id");

        // then
        server.verify();

        assertNotNull(workingTimeType);
        assertEquals("id", workingTimeType.getId());
        assertEquals("example", workingTimeType.getName());
        assertEquals("exmpl", workingTimeType.getShortName());
        assertEquals("attendance type", workingTimeType.getDescription());
        assertEquals("external id", workingTimeType.getExternalId());
        assertEquals(DurationUnit.DAYS, workingTimeType.getEditUnit());
        assertEquals(WorkingTimeTypeCategory.PAID_TIME_OFF, workingTimeType.getCategory());
        assertEquals(RecordingModeUser.BY_REQUEST, workingTimeType.getRecordingModeUser());
        assertFalse(workingTimeType.getArchived());
    }

}
