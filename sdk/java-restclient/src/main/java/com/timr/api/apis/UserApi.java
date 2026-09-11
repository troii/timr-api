package com.timr.api.apis;

import com.timr.api.ApiClient;

import com.timr.api.models.Error;
import java.time.LocalDate;
import org.jspecify.annotations.Nullable;
import com.timr.api.models.SortDirection;
import com.timr.api.models.TeamsPartialPage;
import com.timr.api.models.TeamsSortColumn;
import java.net.URI;
import com.timr.api.models.User;
import com.timr.api.models.UserCreate;
import com.timr.api.models.UserUpdate;
import com.timr.api.models.UsersPage;
import com.timr.api.models.UsersSortColumn;
import com.timr.api.models.WorkScheduleModel;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient.ResponseSpec;
import org.springframework.web.client.RestClientResponseException;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.22.0")
public class UserApi {
    private ApiClient apiClient;

    public UserApi() {
        this(new ApiClient());
    }

    public UserApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a User
     * Creates a User from the data in the request body.
     * <p><b>201</b> - The created User.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param userCreate User entity
     * @return User
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createUserRequestCreation(UserCreate userCreate) throws RestClientResponseException {
        Object postBody = userCreate;
        // verify the required parameter 'userCreate' is set
        if (userCreate == null) {
            throw new RestClientResponseException("Missing the required parameter 'userCreate' when calling createUser", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<User> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/users", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a User
     * Creates a User from the data in the request body.
     * <p><b>201</b> - The created User.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param userCreate User entity
     * @return User
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public User createUser( UserCreate userCreate) throws RestClientResponseException {
        ParameterizedTypeReference<User> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createUserRequestCreation(userCreate).body(localVarReturnType);
    }

    /**
     * Create a User
     * Creates a User from the data in the request body.
     * <p><b>201</b> - The created User.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param userCreate User entity
     * @return ResponseEntity&lt;User&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<User> createUserWithHttpInfo( UserCreate userCreate) throws RestClientResponseException {
        ParameterizedTypeReference<User> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createUserRequestCreation(userCreate).toEntity(localVarReturnType);
    }

    /**
     * Create a User
     * Creates a User from the data in the request body.
     * <p><b>201</b> - The created User.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param userCreate User entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createUserWithResponseSpec(UserCreate userCreate) throws RestClientResponseException {
        return createUserRequestCreation(userCreate);
    }

    /**
     * List a User&#39;s Team leaderships
     * Lists the Teams the User leads.
     * <p><b>200</b> - Page of Teams the User leads.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return TeamsPartialPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchUserTeamLeadershipsRequestCreation(String id, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TeamsSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling fetchUserTeamLeaderships", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_token", pageToken));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_direction", sortDirection));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_by", sortBy));

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<TeamsPartialPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/users/{id}/team-leaderships", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List a User&#39;s Team leaderships
     * Lists the Teams the User leads.
     * <p><b>200</b> - Page of Teams the User leads.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return TeamsPartialPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public TeamsPartialPage fetchUserTeamLeaderships( String id,  String pageToken,  Integer limit,  SortDirection sortDirection,  TeamsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<TeamsPartialPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchUserTeamLeadershipsRequestCreation(id, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List a User&#39;s Team leaderships
     * Lists the Teams the User leads.
     * <p><b>200</b> - Page of Teams the User leads.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;TeamsPartialPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TeamsPartialPage> fetchUserTeamLeadershipsWithHttpInfo( String id,  String pageToken,  Integer limit,  SortDirection sortDirection,  TeamsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<TeamsPartialPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchUserTeamLeadershipsRequestCreation(id, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List a User&#39;s Team leaderships
     * Lists the Teams the User leads.
     * <p><b>200</b> - Page of Teams the User leads.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchUserTeamLeadershipsWithResponseSpec(String id, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TeamsSortColumn sortBy) throws RestClientResponseException {
        return fetchUserTeamLeadershipsRequestCreation(id, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * List a User&#39;s Team memberships
     * Lists the Teams the User is a member of.
     * <p><b>200</b> - Page of Teams the User is a member of.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return TeamsPartialPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchUserTeamMembershipsRequestCreation(String id, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TeamsSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling fetchUserTeamMemberships", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_token", pageToken));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_direction", sortDirection));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_by", sortBy));

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<TeamsPartialPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/users/{id}/team-memberships", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List a User&#39;s Team memberships
     * Lists the Teams the User is a member of.
     * <p><b>200</b> - Page of Teams the User is a member of.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return TeamsPartialPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public TeamsPartialPage fetchUserTeamMemberships( String id,  String pageToken,  Integer limit,  SortDirection sortDirection,  TeamsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<TeamsPartialPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchUserTeamMembershipsRequestCreation(id, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List a User&#39;s Team memberships
     * Lists the Teams the User is a member of.
     * <p><b>200</b> - Page of Teams the User is a member of.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;TeamsPartialPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TeamsPartialPage> fetchUserTeamMembershipsWithHttpInfo( String id,  String pageToken,  Integer limit,  SortDirection sortDirection,  TeamsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<TeamsPartialPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchUserTeamMembershipsRequestCreation(id, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List a User&#39;s Team memberships
     * Lists the Teams the User is a member of.
     * <p><b>200</b> - Page of Teams the User is a member of.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchUserTeamMembershipsWithResponseSpec(String id, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TeamsSortColumn sortBy) throws RestClientResponseException {
        return fetchUserTeamMembershipsRequestCreation(id, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * List Users
     * Lists the Users the authenticated user or API token can access.
     * <p><b>200</b> - Page of Users.
     * <p><b>400</b> - Bad Request
     * @param name Only return Users whose name contains this text.
     * @param entryDateFrom Only return Users whose entry date is on or after this day.
     * @param entryDateTo Only return Users whose entry date is on or before this day.
     * @param resignDateFrom Only return Users whose resignation date is on or after this day.
     * @param resignDateTo Only return Users whose resignation date is on or before this day.
     * @param resigned Only return Users who have resigned (true) or have not resigned (false).
     * @param employeeNumber Only return Users with this employee number.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return UsersPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchUsersRequestCreation(@Nullable String name, @Nullable LocalDate entryDateFrom, @Nullable LocalDate entryDateTo, @Nullable LocalDate resignDateFrom, @Nullable LocalDate resignDateTo, @Nullable Boolean resigned, @Nullable String employeeNumber, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable UsersSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "entry_date_from", entryDateFrom));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "entry_date_to", entryDateTo));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "resign_date_from", resignDateFrom));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "resign_date_to", resignDateTo));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "resigned", resigned));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "employee_number", employeeNumber));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_token", pageToken));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_direction", sortDirection));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_by", sortBy));

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<UsersPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/users", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Users
     * Lists the Users the authenticated user or API token can access.
     * <p><b>200</b> - Page of Users.
     * <p><b>400</b> - Bad Request
     * @param name Only return Users whose name contains this text.
     * @param entryDateFrom Only return Users whose entry date is on or after this day.
     * @param entryDateTo Only return Users whose entry date is on or before this day.
     * @param resignDateFrom Only return Users whose resignation date is on or after this day.
     * @param resignDateTo Only return Users whose resignation date is on or before this day.
     * @param resigned Only return Users who have resigned (true) or have not resigned (false).
     * @param employeeNumber Only return Users with this employee number.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return UsersPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public UsersPage fetchUsers( String name,  LocalDate entryDateFrom,  LocalDate entryDateTo,  LocalDate resignDateFrom,  LocalDate resignDateTo,  Boolean resigned,  String employeeNumber,  String pageToken,  Integer limit,  SortDirection sortDirection,  UsersSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<UsersPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchUsersRequestCreation(name, entryDateFrom, entryDateTo, resignDateFrom, resignDateTo, resigned, employeeNumber, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Users
     * Lists the Users the authenticated user or API token can access.
     * <p><b>200</b> - Page of Users.
     * <p><b>400</b> - Bad Request
     * @param name Only return Users whose name contains this text.
     * @param entryDateFrom Only return Users whose entry date is on or after this day.
     * @param entryDateTo Only return Users whose entry date is on or before this day.
     * @param resignDateFrom Only return Users whose resignation date is on or after this day.
     * @param resignDateTo Only return Users whose resignation date is on or before this day.
     * @param resigned Only return Users who have resigned (true) or have not resigned (false).
     * @param employeeNumber Only return Users with this employee number.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;UsersPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UsersPage> fetchUsersWithHttpInfo( String name,  LocalDate entryDateFrom,  LocalDate entryDateTo,  LocalDate resignDateFrom,  LocalDate resignDateTo,  Boolean resigned,  String employeeNumber,  String pageToken,  Integer limit,  SortDirection sortDirection,  UsersSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<UsersPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchUsersRequestCreation(name, entryDateFrom, entryDateTo, resignDateFrom, resignDateTo, resigned, employeeNumber, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Users
     * Lists the Users the authenticated user or API token can access.
     * <p><b>200</b> - Page of Users.
     * <p><b>400</b> - Bad Request
     * @param name Only return Users whose name contains this text.
     * @param entryDateFrom Only return Users whose entry date is on or after this day.
     * @param entryDateTo Only return Users whose entry date is on or before this day.
     * @param resignDateFrom Only return Users whose resignation date is on or after this day.
     * @param resignDateTo Only return Users whose resignation date is on or before this day.
     * @param resigned Only return Users who have resigned (true) or have not resigned (false).
     * @param employeeNumber Only return Users with this employee number.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchUsersWithResponseSpec(@Nullable String name, @Nullable LocalDate entryDateFrom, @Nullable LocalDate entryDateTo, @Nullable LocalDate resignDateFrom, @Nullable LocalDate resignDateTo, @Nullable Boolean resigned, @Nullable String employeeNumber, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable UsersSortColumn sortBy) throws RestClientResponseException {
        return fetchUsersRequestCreation(name, entryDateFrom, entryDateTo, resignDateFrom, resignDateTo, resigned, employeeNumber, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * Get a User
     * Returns a single User by its ID.
     * <p><b>200</b> - The requested User.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User.
     * @return User
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getUserRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling getUser", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<User> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/users/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a User
     * Returns a single User by its ID.
     * <p><b>200</b> - The requested User.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User.
     * @return User
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public User getUser( String id) throws RestClientResponseException {
        ParameterizedTypeReference<User> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getUserRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Get a User
     * Returns a single User by its ID.
     * <p><b>200</b> - The requested User.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User.
     * @return ResponseEntity&lt;User&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<User> getUserWithHttpInfo( String id) throws RestClientResponseException {
        ParameterizedTypeReference<User> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getUserRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get a User
     * Returns a single User by its ID.
     * <p><b>200</b> - The requested User.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getUserWithResponseSpec(String id) throws RestClientResponseException {
        return getUserRequestCreation(id);
    }

    /**
     * Get a User&#39;s Work Schedule Model
     * Returns the Work Schedule Model assigned to the User, with all durations expressed in minutes.
     * <p><b>200</b> - The Work Schedule Model assigned to the User.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User.
     * @return WorkScheduleModel
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getUserWorkScheduleModelRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling getUserWorkScheduleModel", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<WorkScheduleModel> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/users/{id}/work-schedule-model", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a User&#39;s Work Schedule Model
     * Returns the Work Schedule Model assigned to the User, with all durations expressed in minutes.
     * <p><b>200</b> - The Work Schedule Model assigned to the User.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User.
     * @return WorkScheduleModel
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public WorkScheduleModel getUserWorkScheduleModel( String id) throws RestClientResponseException {
        ParameterizedTypeReference<WorkScheduleModel> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getUserWorkScheduleModelRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Get a User&#39;s Work Schedule Model
     * Returns the Work Schedule Model assigned to the User, with all durations expressed in minutes.
     * <p><b>200</b> - The Work Schedule Model assigned to the User.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User.
     * @return ResponseEntity&lt;WorkScheduleModel&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkScheduleModel> getUserWorkScheduleModelWithHttpInfo( String id) throws RestClientResponseException {
        ParameterizedTypeReference<WorkScheduleModel> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getUserWorkScheduleModelRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get a User&#39;s Work Schedule Model
     * Returns the Work Schedule Model assigned to the User, with all durations expressed in minutes.
     * <p><b>200</b> - The Work Schedule Model assigned to the User.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getUserWorkScheduleModelWithResponseSpec(String id) throws RestClientResponseException {
        return getUserWorkScheduleModelRequestCreation(id);
    }

    /**
     * Update a User
     * Updates the User with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated User.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the User.
     * @param userUpdate User entity
     * @return User
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateUserRequestCreation(String id, UserUpdate userUpdate) throws RestClientResponseException {
        Object postBody = userUpdate;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling updateUser", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'userUpdate' is set
        if (userUpdate == null) {
            throw new RestClientResponseException("Missing the required parameter 'userUpdate' when calling updateUser", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<User> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/users/{id}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update a User
     * Updates the User with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated User.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the User.
     * @param userUpdate User entity
     * @return User
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public User updateUser( String id,  UserUpdate userUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<User> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateUserRequestCreation(id, userUpdate).body(localVarReturnType);
    }

    /**
     * Update a User
     * Updates the User with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated User.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the User.
     * @param userUpdate User entity
     * @return ResponseEntity&lt;User&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<User> updateUserWithHttpInfo( String id,  UserUpdate userUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<User> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateUserRequestCreation(id, userUpdate).toEntity(localVarReturnType);
    }

    /**
     * Update a User
     * Updates the User with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated User.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the User.
     * @param userUpdate User entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateUserWithResponseSpec(String id, UserUpdate userUpdate) throws RestClientResponseException {
        return updateUserRequestCreation(id, userUpdate);
    }
}
