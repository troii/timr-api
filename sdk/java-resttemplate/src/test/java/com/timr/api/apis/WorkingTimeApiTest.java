package com.timr.api.apis;

import com.timr.api.ApiClient;
import com.timr.api.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

class WorkingTimeApiTest {

    private static final String BASE_PATH = "http://localhost:8081/";

    private MockRestServiceServer server;
    private WorkingTimeApi workingTimeApi;

    @BeforeEach
    void setUp() {
        var restTemplate = new RestTemplate();
        server = MockRestServiceServer.bindTo(restTemplate).build();

        ApiClient apiClient = new ApiClient(restTemplate);
        apiClient.setBasePath(BASE_PATH);
        apiClient.getAuthentication().setAccessToken("dummyToken");
        workingTimeApi = new WorkingTimeApi(apiClient);
    }

    @Test
    void getWorkingTime1() {
        String id = "123";
        String jsonResponse = """
                    {
                        "id": "123",
                        "start": "2023-10-10T10:00:00Z",
                        "end": "2023-10-10T18:00:00Z",
                        "break_time_total_minutes": 60,
                        "break_times": [],
                        "duration": null,
                        "changed": true,
                        "notes": "Worked on project",
                        "user": { "id": "user123" },
                        "working_time_type": { "id": "type123" },
                        "working_time_date_span": null,
                        "start_location": null,
                        "end_location": null,
                        "start_platform": null,
                        "end_platform": null,
                        "last_modified": "2023-10-10T18:00:00Z",
                        "last_modified_by": { "id": "user123" },
                        "status": "changeable",
                        "metadata": null
                    }
                """;

        server.expect(requestTo(BASE_PATH + "working-times/" + id))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(jsonResponse, MediaType.APPLICATION_JSON));

        WorkingTime workingTime = workingTimeApi.getWorkingTime(id);

        server.verify();

        assertNotNull(workingTime);
        assertEquals("123", workingTime.getId());
        assertEquals(OffsetDateTime.parse("2023-10-10T10:00:00Z"), workingTime.getStart());
        assertEquals(OffsetDateTime.parse("2023-10-10T18:00:00Z"), workingTime.getEnd());
        assertEquals(60, workingTime.getBreakTimeTotalMinutes());
        assertTrue(workingTime.getBreakTimes().isEmpty());
        assertTrue(workingTime.getChanged());
        assertEquals("Worked on project", workingTime.getNotes());
        assertEquals("user123", workingTime.getUser().getId());
        assertEquals("type123", workingTime.getWorkingTimeType().getId());
        assertEquals(OffsetDateTime.parse("2023-10-10T18:00:00Z"), workingTime.getLastModified());
        assertEquals("user123", workingTime.getLastModifiedBy().getId());
        assertEquals(WorkingTimeStatus.CHANGEABLE, workingTime.getStatus());
    }

    @Test
    void getWorkingTime2() {
        String id = "123";
        String jsonResponse = """
                    {
                        "id": "123",
                        "start": "2023-10-10T10:00:00Z",
                        "end": "2023-10-10T18:00:00Z",
                        "break_time_total_minutes": 60,
                        "break_times": [
                            {
                                "type": "manual",
                                "start" : "2023-10-10T12:00:00Z",
                                "end" : "2023-10-10T12:30:00Z",
                                "duration_minutes": 30
                            },
                            {
                                "type": "automatic",
                                "start" : "2023-10-10T14:00:00Z",
                                "end" : "2023-10-10T15:00:00Z",
                                "duration_minutes": 60
                            }
                        ],
                        "duration": null,
                        "changed": true,
                        "notes": "Worked on project",
                        "user": { "id": "user123" },
                        "working_time_type": { "id": "type123" },
                        "working_time_date_span": null,
                        "start_location": {
                            "lat": 12.34,
                            "lon": 56.78,
                            "timestamp": "2023-10-10T12:00:00Z",
                            "formatted_address": "Example street 123"
                        },
                        "end_location": {
                            "lat": 98.76,
                            "lon": 55.77,
                            "timestamp": "2023-10-10T12:00:00Z",
                            "formatted_address": "Marina"
                        },
                        "start_platform": "timr_api",
                        "end_platform": "timr_api",
                        "last_modified": "2023-10-10T18:00:00Z",
                        "last_modified_by": { "id": "user123" },
                        "status": "changeable"
                    }
                """;

        server.expect(requestTo(BASE_PATH + "working-times/" + id))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(jsonResponse, MediaType.APPLICATION_JSON));

        WorkingTime workingTime = workingTimeApi.getWorkingTime(id);

        assertNotNull(workingTime);
        assertEquals("123", workingTime.getId());
        assertEquals(OffsetDateTime.parse("2023-10-10T10:00:00Z"), workingTime.getStart());
        assertEquals(OffsetDateTime.parse("2023-10-10T18:00:00Z"), workingTime.getEnd());
        assertEquals(60, workingTime.getBreakTimeTotalMinutes());

        assertFalse(workingTime.getBreakTimes().isEmpty());
        assertEquals(BreakTimeType.MANUAL, workingTime.getBreakTimes().get(0).getType());
        BreakTimeManual manualModel = (BreakTimeManual) workingTime.getBreakTimes().get(0);
        assertEquals(OffsetDateTime.parse("2023-10-10T12:00:00Z"), manualModel.getStart().get());
        assertEquals(OffsetDateTime.parse("2023-10-10T12:30:00Z"), manualModel.getEnd().get());
        assertEquals(30, manualModel.getDurationMinutes());
        assertEquals(BreakTimeType.AUTOMATIC, workingTime.getBreakTimes().get(1).getType());
        BreakTimeAutomatic automaticModel = (BreakTimeAutomatic) workingTime.getBreakTimes().get(1);
        assertEquals(OffsetDateTime.parse("2023-10-10T14:00:00Z"), automaticModel.getStart());
        assertEquals(OffsetDateTime.parse("2023-10-10T15:00:00Z"), automaticModel.getEnd());
        assertEquals(60, automaticModel.getDurationMinutes());

        assertTrue(workingTime.getChanged());
        assertEquals("Worked on project", workingTime.getNotes());
        assertEquals("user123", workingTime.getUser().getId());
        assertEquals("type123", workingTime.getWorkingTimeType().getId());

        assertEquals(12.34f, workingTime.getStartLocation().getLat());
        assertEquals(56.78f, workingTime.getStartLocation().getLon());
        assertEquals(OffsetDateTime.parse("2023-10-10T12:00:00Z"), workingTime.getStartLocation().getTimestamp().get());
        assertEquals("Example street 123", workingTime.getStartLocation().getFormattedAddress().get());
        assertNotNull(workingTime.getEndLocation());
        assertEquals(98.76f, workingTime.getEndLocation().getLat());
        assertEquals(55.77f, workingTime.getEndLocation().getLon());
        assertEquals(OffsetDateTime.parse("2023-10-10T12:00:00Z"), workingTime.getEndLocation().getTimestamp().get());
        assertEquals("Marina", workingTime.getEndLocation().getFormattedAddress().get());
        assertEquals(Platform.TIMR_API, workingTime.getStartPlatform());
        assertEquals(Platform.TIMR_API, workingTime.getEndPlatform());
        assertEquals(OffsetDateTime.parse("2023-10-10T18:00:00Z"), workingTime.getLastModified());
        assertEquals("user123", workingTime.getLastModifiedBy().getId());
        assertEquals(WorkingTimeStatus.CHANGEABLE, workingTime.getStatus());
        assertEquals(JsonNullable.undefined(), workingTime.getMetadata());

        server.verify();
    }


    @Test
    void deserializesRfc3339DateTimeWithOffsetAndFraction() {
        // RFC3339 permits a numeric UTC offset and fractional seconds (not just a trailing "Z").
        // Verify both are parsed to the correct instant.
        String jsonResponse = """
                    {
                        "id": "123",
                        "start": "2023-10-10T12:00:00.123+02:00",
                        "end": "2023-10-10T20:30:45-04:30",
                        "break_time_total_minutes": 60,
                        "break_times": [],
                        "changed": true,
                        "user": { "id": "user123" },
                        "working_time_type": { "id": "type123" },
                        "last_modified": "2023-10-10T18:00:00Z",
                        "status": "changeable"
                    }
                """;

        server.expect(requestTo(BASE_PATH + "working-times/123"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(jsonResponse, MediaType.APPLICATION_JSON));

        WorkingTime workingTime = workingTimeApi.getWorkingTime("123");

        server.verify();
        // Preserve the wire offsets while parsing the same instants correctly.
        assertEquals(OffsetDateTime.parse("2023-10-10T12:00:00.123+02:00"), workingTime.getStart());
        assertEquals(OffsetDateTime.parse("2023-10-10T12:00:00.123+02:00").toInstant(), workingTime.getStart().toInstant());
        assertEquals(OffsetDateTime.parse("2023-10-10T20:30:45-04:30"), workingTime.getEnd());
    }

    @Test
    void serializesRfc3339DateTimeWithNonUtcOffset() {
        // A date-time carrying a non-UTC offset must be serialized as a valid RFC3339 string.
        WorkingTimeCreate workingTimeCreate = new WorkingTimeCreate()
                .start(OffsetDateTime.parse("2023-10-10T12:00:00+02:00"))
                .end(OffsetDateTime.parse("2023-10-10T18:00:00Z"))
                .breakTimes(new ArrayList<>())
                .changed(true)
                .workingTimeTypeId("typeId")
                .status(WorkingTimeStatus.CHANGEABLE)
                .userId("userId");

        server.expect(requestTo(BASE_PATH + "working-times"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(jsonPath("$.start").value("2023-10-10T12:00:00+02:00"))
                .andExpect(jsonPath("$.end").value("2023-10-10T18:00:00Z"))
                .andRespond(withSuccess("""
                        {
                               "id": "id",
                               "start": "2023-10-10T12:00:00+02:00",
                               "end": "2023-10-10T18:00:00Z",
                               "break_times": [],
                               "changed": true,
                               "working_time_type": { "id" : "typeId" },
                               "status": "changeable",
                               "user": {"id": "userId" }
                         }
                        """, MediaType.APPLICATION_JSON));

        WorkingTime workingTime = workingTimeApi.createWorkingTime(workingTimeCreate);

        server.verify();
        assertEquals(OffsetDateTime.parse("2023-10-10T12:00:00+02:00").toInstant(), workingTime.getStart().toInstant());
    }

    @Test
    void createWorkingTime() {
        // given
        WorkingTimeCreate workingTimeCreate = new WorkingTimeCreate()
                .start(OffsetDateTime.parse("2023-10-10T10:00:00Z"))
                .end(OffsetDateTime.parse("2023-10-10T18:00:00Z"))
                .breakTimes(new ArrayList<>())
                .durationType(DurationType.FULL_DAY)
                .changed(true)
                .notes("Test notes")
                .workingTimeTypeId("typeId")
                .status(WorkingTimeStatus.CHANGEABLE)
                .metadata(Map.of("key", "value"))
                .userId("userId");

        server.expect(requestTo(BASE_PATH + "working-times"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(jsonPath("$.start").value("2023-10-10T10:00:00Z"))
                .andExpect(jsonPath("$.end").value("2023-10-10T18:00:00Z"))
                .andExpect(jsonPath("$.break_times").isEmpty())
                .andExpect(jsonPath("$.duration_type").value("full_day"))
                .andExpect(jsonPath("$.changed").value(true))
                .andExpect(jsonPath("$.notes").value("Test notes"))
                .andExpect(jsonPath("$.working_time_type_id").value("typeId"))
                .andExpect(jsonPath("$.start_location").doesNotExist())
                .andExpect(jsonPath("$.end_location").doesNotExist())
                .andExpect(jsonPath("$.status").value("changeable"))
                .andExpect(jsonPath("$.metadata.key").value("value"))
                .andExpect(jsonPath("$.user_id").value("userId"))
                .andExpect(jsonPath("$.status").value("changeable"))
                .andRespond(withSuccess("""
                        {
                               "id": "id",
                               "start": "2023-10-10T10:00:00Z",
                               "end": "2023-10-10T18:00:00Z",
                               "break_times": [],
                               "duration": {
                                    "type": "full_day",
                                    "minutes": 480
                               },
                               "changed": true,
                               "notes": "Test notes",
                               "working_time_type": { "id" : "typeId" },
                               "start_location": {},
                               "end_location": {},
                               "status": "changeable",
                               "metadata": {"key": "value"},
                               "user": {"id": "userId" }
                         }
                        """, MediaType.APPLICATION_JSON));

        // when
        WorkingTime workingTime = workingTimeApi.createWorkingTime(workingTimeCreate);

        // then
        server.verify();

        assertNotNull(workingTime);
        assertEquals("id", workingTime.getId());
        assertEquals(OffsetDateTime.parse("2023-10-10T10:00:00Z"), workingTime.getStart());
        assertEquals(OffsetDateTime.parse("2023-10-10T18:00:00Z"), workingTime.getEnd());
        assertEquals(0, workingTime.getBreakTimes().size());
        assertEquals(DurationType.FULL_DAY, workingTime.getDuration().getType());
        assertTrue(workingTime.getChanged());
        assertEquals("Test notes", workingTime.getNotes());
        assertEquals("typeId", workingTime.getWorkingTimeType().getId());
        assertNotNull(workingTime.getStartLocation());
        assertNotNull(workingTime.getEndLocation());
        assertEquals(WorkingTimeStatus.CHANGEABLE, workingTime.getStatus());
        assertEquals(JsonNullable.of(Map.of("key", "value")), workingTime.getMetadata());
        assertEquals("userId", workingTime.getUser().getId());

        // todo breaktimes
    }

    @Test
    void updateWorkingTime() {
        // given
        var breakTimeManual = new BreakTimeManual()
                .durationMinutes(30)
                .start(OffsetDateTime.parse("2023-10-10T12:00:00Z"))
                .end(OffsetDateTime.parse("2023-10-10T12:30:00Z"));

        WorkingTimeUpdate workingTimeUpdate = new WorkingTimeUpdate()
                .start(OffsetDateTime.parse("2023-10-10T10:00:00Z"))
                .end(OffsetDateTime.parse("2023-10-10T18:00:00Z"))
                .breakTimes(List.of(breakTimeManual))
                .notes("Test notes")
                .workingTimeTypeId("typeId")
                .status(WorkingTimeStatus.CHANGEABLE)
                .metadata(Map.of("key", "value"));

        server.expect(requestTo(BASE_PATH + "working-times/123"))
                .andExpect(method(HttpMethod.PATCH))
                .andExpect(jsonPath("$.start").value("2023-10-10T10:00:00Z"))
                .andExpect(jsonPath("$.end").value("2023-10-10T18:00:00Z"))
                .andExpect(jsonPath("$.break_times[0].type").value("manual"))
                .andExpect(jsonPath("$.break_times[0].start").value("2023-10-10T12:00:00Z"))
                .andExpect(jsonPath("$.break_times[0].end").value("2023-10-10T12:30:00Z"))
                .andExpect(jsonPath("$.break_times[0].duration_minutes").value(30))
                .andExpect(jsonPath("$.notes").value("Test notes"))
                .andExpect(jsonPath("$.working_time_type_id").value("typeId"))
                .andExpect(jsonPath("$.status").value("changeable"))
                .andExpect(jsonPath("$.metadata.key").value("value"))
                .andRespond(withSuccess("""
                        {
                                "id": "123",
                                "start": "2023-10-10T10:00:00Z",
                                "end": "2023-10-10T18:00:00Z",
                                "break_time_total_minutes": 60,
                                "break_times": [
                                    {
                                        "type": "manual",
                                        "start" : "2023-10-10T12:00:00Z",
                                        "end" : "2023-10-10T12:30:00Z",
                                        "duration_minutes": 30
                                    }
                                ],
                               "duration": {
                                    "type": "full_day",
                                    "minutes": 480
                               },
                               "changed": true,
                               "notes": "Test notes",
                               "working_time_type": { "id" : "typeId" },
                               "start_location": {},
                               "end_location": {},
                               "status": "changeable",
                               "metadata": {"key": "value"},
                               "user": {"id": "userId" }
                         }
                        """, MediaType.APPLICATION_JSON));

        // when
        WorkingTime workingTime = workingTimeApi.updateWorkingTime("123", workingTimeUpdate);

        // then
        server.verify();

        assertNotNull(workingTime);
        assertEquals("123", workingTime.getId());
        assertEquals(OffsetDateTime.parse("2023-10-10T10:00:00Z"), workingTime.getStart());
        assertEquals(OffsetDateTime.parse("2023-10-10T18:00:00Z"), workingTime.getEnd());
        assertEquals(60, workingTime.getBreakTimeTotalMinutes());
        assertFalse(workingTime.getBreakTimes().isEmpty());
        assertEquals(BreakTimeType.MANUAL, workingTime.getBreakTimes().get(0).getType());
        BreakTimeManual manualModel = (BreakTimeManual) workingTime.getBreakTimes().get(0);
        assertEquals(OffsetDateTime.parse("2023-10-10T12:00:00Z"), manualModel.getStart().get());
        assertEquals(OffsetDateTime.parse("2023-10-10T12:30:00Z"), manualModel.getEnd().get());
        assertEquals(30, manualModel.getDurationMinutes());
        assertEquals(DurationType.FULL_DAY, workingTime.getDuration().getType());
        assertEquals(480, workingTime.getDuration().getMinutes());
        assertTrue(workingTime.getChanged());
        assertEquals("Test notes", workingTime.getNotes());
        assertEquals("typeId", workingTime.getWorkingTimeType().getId());
        assertNotNull(workingTime.getStartLocation());
        assertNotNull(workingTime.getEndLocation());
        assertEquals(WorkingTimeStatus.CHANGEABLE, workingTime.getStatus());
        assertEquals(JsonNullable.of(Map.of("key", "value")), workingTime.getMetadata());
        assertEquals("userId", workingTime.getUser().getId());
    }

}
