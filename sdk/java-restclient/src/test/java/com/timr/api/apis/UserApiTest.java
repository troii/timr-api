package com.timr.api.apis;

import com.timr.api.ApiClient;
import com.timr.api.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

class UserApiTest {

    private static final String BASE_PATH = "http://localhost:8081/";

    private MockRestServiceServer server;
    private UserApi userApi;

    @BeforeEach
    void setUp() {
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        server = MockRestServiceServer.bindTo(restTemplate).build();

        RestClient.Builder restClientBuilder = RestClient.builder(restTemplate);
        ApiClient apiClient = new ApiClient(restClientBuilder);
        apiClient.setBasePath(BASE_PATH);
        apiClient.getAuthentication().setAccessToken("dummyToken");

        userApi = new UserApi(apiClient);
    }

    @Test
    void getUser() {
        String id = "user123";
        String jsonResponse = """
                    {
                        "id": "user123",
                        "firstname": "John",
                        "lastname": "Doe",
                        "fullname": "John Doe",
                        "email": "john.doe@example.com",
                        "employee_number": "E123",
                        "external_id": "EXT123",
                        "login": "johndoe",
                        "entry_date": "2023-01-01",
                        "resign_date": null,
                        "work_schedule_model": {
                            "id": "schedule123",
                            "name": "Standard Schedule"
                        },
                        "holiday_calendar": {
                            "id": "calendar123",
                            "description": "Standard Holidays"
                        }
                    }
                """;

        server.expect(requestTo(BASE_PATH + "users/" + id))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(jsonResponse, MediaType.APPLICATION_JSON));

        User user = userApi.getUser(id);

        server.verify();

        assertNotNull(user);
        assertEquals("user123", user.getId());
        assertEquals("John", user.getFirstname());
        assertEquals("Doe", user.getLastname());
        assertEquals("John Doe", user.getFullname());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("E123", user.getEmployeeNumber());
        assertEquals("EXT123", user.getExternalId());
        assertEquals("johndoe", user.getLogin().orElse(null));
        assertEquals(LocalDate.parse("2023-01-01"), user.getEntryDate().orElse(null));
        assertNull(user.getResignDate().orElse(null));

        assertNotNull(user.getWorkScheduleModel().orElse(null));
        assertEquals("schedule123", user.getWorkScheduleModel().orElse(null).getId());
        assertEquals("Standard Schedule", user.getWorkScheduleModel().orElse(null).getName());

        assertNotNull(user.getHolidayCalendar().orElse(null));
        assertEquals("calendar123", user.getHolidayCalendar().orElse(null).getId());
        assertEquals("Standard Holidays", user.getHolidayCalendar().orElse(null).getDescription());
    }

    @Test
    void fetchUsers() {
        String jsonResponse = """
                    {
                        "next_page_token": "token123",
                        "data": [
                            {
                                "id": "user123",
                                "firstname": "John",
                                "lastname": "Doe",
                                "fullname": "John Doe",
                                "email": "john.doe@example.com",
                                "employee_number": "E123",
                                "external_id": "EXT123",
                                "login": "johndoe",
                                "entry_date": "2023-01-01",
                                "resign_date": null,
                                "work_schedule_model": {
                                    "id": "schedule123",
                                    "name": "Standard Schedule"
                                },
                                "holiday_calendar": {
                                    "id": "calendar123",
                                    "description": "Standard Holidays"
                                }
                            }
                        ]
                    }
                """;

        server.expect(requestTo(BASE_PATH + "users?name=John&entry_date_from=2023-01-01&entry_date_to=2023-12-31&resign_date_from=2023-01-01&resign_date_to=2023-12-31&resigned=false&employee_number=E123&page_token=token123&limit=10&sort_direction=asc&sort_by=name"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(jsonResponse, MediaType.APPLICATION_JSON));

        UsersPage usersPage = userApi.fetchUsers("John",
                LocalDate.parse("2023-01-01"),
                LocalDate.parse("2023-12-31"),
                LocalDate.parse("2023-01-01"),
                LocalDate.parse("2023-12-31"),
                false,
                "E123",
                "token123",
                10,
                SortDirection.ASC,
                UsersSortColumn.NAME);

        server.verify();

        assertNotNull(usersPage);
        assertEquals("token123", usersPage.getNextPageToken());

        List<User> users = usersPage.getData();
        assertNotNull(users);
        assertEquals(1, users.size());

        User user = users.get(0);
        assertNotNull(user);
        assertEquals("user123", user.getId());
        assertEquals("John", user.getFirstname());
        assertEquals("Doe", user.getLastname());
        assertEquals("John Doe", user.getFullname());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("E123", user.getEmployeeNumber());
        assertEquals("EXT123", user.getExternalId());
        assertEquals("johndoe", user.getLogin().orElse(null));
        assertEquals(LocalDate.parse("2023-01-01"), user.getEntryDate().orElse(null));
        assertNull(user.getResignDate().orElse(null));

        assertNotNull(user.getWorkScheduleModel().orElse(null));
        assertEquals("schedule123", user.getWorkScheduleModel().orElse(null).getId());
        assertEquals("Standard Schedule", user.getWorkScheduleModel().orElse(null).getName());

        assertNotNull(user.getHolidayCalendar().orElse(null));
        assertEquals("calendar123", user.getHolidayCalendar().orElse(null).getId());
        assertEquals("Standard Holidays", user.getHolidayCalendar().orElse(null).getDescription());
    }

    @Test
    void createUser() {
        // given
        UserCreate userCreate = new UserCreate()
                .login("johndoe")
                .firstname("John")
                .lastname("Doe")
                .email("john.doe@example.com")
                .entryDate(LocalDate.parse("2023-01-01"))
                .resignDate(null)
                .employeeNumber("E123")
                .externalId("EXT123")
                .authProvider("provider")
                .authIdentifier("identifier");

        server.expect(requestTo(BASE_PATH + "users"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(jsonPath("$.login").value("johndoe"))
                .andExpect(jsonPath("$.firstname").value("John"))
                .andExpect(jsonPath("$.lastname").value("Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$.entry_date").value("2023-01-01"))
                .andExpect(jsonPath("$.resign_date").doesNotExist())
                .andExpect(jsonPath("$.employee_number").value("E123"))
                .andExpect(jsonPath("$.external_id").value("EXT123"))
                .andExpect(jsonPath("$.auth_provider").value("provider"))
                .andExpect(jsonPath("$.auth_identifier").value("identifier"))
                .andRespond(withSuccess("""
                            {
                                "id": "user123",
                                "login": "johndoe",
                                "firstname": "John",
                                "lastname": "Doe",
                                "email": "john.doe@example.com",
                                "entry_date": "2023-01-01",
                                "resign_date": null,
                                "employee_number": "E123",
                                "external_id": "EXT123"
                            }
                        """, MediaType.APPLICATION_JSON));

        User user = userApi.createUser(userCreate);

        server.verify();

        assertNotNull(user);
        assertEquals("user123", user.getId());
        assertEquals("johndoe", user.getLogin().get());
        assertEquals("John", user.getFirstname());
        assertEquals("Doe", user.getLastname());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals(LocalDate.parse("2023-01-01"), user.getEntryDate().orElse(null));
        assertNull(user.getResignDate().orElse(null));
        assertEquals("E123", user.getEmployeeNumber());
        assertEquals("EXT123", user.getExternalId());
    }

    @Test
    void updateUser() {
        // given
        UserUpdate userUpdate = new UserUpdate()
                .login("johndoe")
                .firstname("John")
                .lastname("Doe")
                .email("john.doe@example.com");

        server.expect(requestTo(BASE_PATH + "users/user123"))
                .andExpect(method(HttpMethod.PATCH))
                .andExpect(jsonPath("$.login").value("johndoe"))
                .andExpect(jsonPath("$.firstname").value("John"))
                .andExpect(jsonPath("$.lastname").value("Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$.entry_date").doesNotExist())
                .andExpect(jsonPath("$.resign_date").doesNotExist())
                .andExpect(jsonPath("$.employee_number").doesNotExist())
                .andRespond(withSuccess("""
                            {
                                "id": "user123",
                                "login": "johndoe",
                                "firstname": "John",
                                "lastname": "Doe",
                                "email": "john.doe@example.com",
                                "entry_date": "2023-01-01",
                                "resign_date": null,
                                "employee_number": "E123",
                                "external_id": "EXT123"
                            }
                        """, MediaType.APPLICATION_JSON));

        // when
        User user = userApi.updateUser("user123", userUpdate);

        // then
        server.verify();

        assertNotNull(user);
        assertEquals("user123", user.getId());
        assertEquals("johndoe", user.getLogin().get());
        assertEquals("John", user.getFirstname());
        assertEquals("Doe", user.getLastname());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals(LocalDate.parse("2023-01-01"), user.getEntryDate().orElse(null));
        assertNull(user.getResignDate().orElse(null));
        assertEquals("E123", user.getEmployeeNumber());
        assertEquals("EXT123", user.getExternalId());
    }

}
