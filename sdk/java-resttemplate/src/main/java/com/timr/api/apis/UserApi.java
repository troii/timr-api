package com.timr.api.apis;

import com.timr.api.ApiClient;
import com.timr.api.BaseApi;

import com.timr.api.models.Error;
import java.time.LocalDate;
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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.26.0")
@Component("com.timr.api.apis.UserApi")
public class UserApi extends BaseApi {

    public UserApi() {
        super(new ApiClient());
    }

    @Autowired
    public UserApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Create a User
     * Creates a User from the data in the request body.
     * <p><b>201</b> - The created User.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param userCreate User entity (required)
     * @return User
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public User createUser(@jakarta.annotation.Nonnull UserCreate userCreate) throws RestClientException {
        return createUserWithHttpInfo(userCreate).getBody();
    }

    /**
     * Create a User
     * Creates a User from the data in the request body.
     * <p><b>201</b> - The created User.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param userCreate User entity (required)
     * @return ResponseEntity&lt;User&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<User> createUserWithHttpInfo(@jakarta.annotation.Nonnull UserCreate userCreate) throws RestClientException {
        Object localVarPostBody = userCreate;
        
        // verify the required parameter 'userCreate' is set
        if (userCreate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userCreate' when calling createUser");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<User> localReturnType = new ParameterizedTypeReference<User>() {};
        return apiClient.invokeAPI("/users", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List a User&#39;s Team leaderships
     * Lists the Teams the User leads.
     * <p><b>200</b> - Page of Teams the User leads.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User. (required)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to breadcrumbs)
     * @return TeamsPartialPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TeamsPartialPage fetchUserTeamLeaderships(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable TeamsSortColumn sortBy) throws RestClientException {
        return fetchUserTeamLeadershipsWithHttpInfo(id, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List a User&#39;s Team leaderships
     * Lists the Teams the User leads.
     * <p><b>200</b> - Page of Teams the User leads.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User. (required)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to breadcrumbs)
     * @return ResponseEntity&lt;TeamsPartialPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TeamsPartialPage> fetchUserTeamLeadershipsWithHttpInfo(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable TeamsSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling fetchUserTeamLeaderships");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_token", pageToken));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_direction", sortDirection));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_by", sortBy));
        

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<TeamsPartialPage> localReturnType = new ParameterizedTypeReference<TeamsPartialPage>() {};
        return apiClient.invokeAPI("/users/{id}/team-leaderships", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List a User&#39;s Team memberships
     * Lists the Teams the User is a member of.
     * <p><b>200</b> - Page of Teams the User is a member of.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User. (required)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to breadcrumbs)
     * @return TeamsPartialPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TeamsPartialPage fetchUserTeamMemberships(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable TeamsSortColumn sortBy) throws RestClientException {
        return fetchUserTeamMembershipsWithHttpInfo(id, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List a User&#39;s Team memberships
     * Lists the Teams the User is a member of.
     * <p><b>200</b> - Page of Teams the User is a member of.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User. (required)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to breadcrumbs)
     * @return ResponseEntity&lt;TeamsPartialPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TeamsPartialPage> fetchUserTeamMembershipsWithHttpInfo(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable TeamsSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling fetchUserTeamMemberships");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_token", pageToken));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_direction", sortDirection));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_by", sortBy));
        

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<TeamsPartialPage> localReturnType = new ParameterizedTypeReference<TeamsPartialPage>() {};
        return apiClient.invokeAPI("/users/{id}/team-memberships", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List Users
     * Lists the Users the authenticated user or API token can access.
     * <p><b>200</b> - Page of Users.
     * <p><b>400</b> - Bad Request
     * @param name Only return Users whose name contains this text. (optional)
     * @param entryDateFrom Only return Users whose entry date is on or after this day. (optional)
     * @param entryDateTo Only return Users whose entry date is on or before this day. (optional)
     * @param resignDateFrom Only return Users whose resignation date is on or after this day. (optional)
     * @param resignDateTo Only return Users whose resignation date is on or before this day. (optional)
     * @param resigned Only return Users who have resigned (true) or have not resigned (false). (optional)
     * @param employeeNumber Only return Users with this employee number. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to name)
     * @return UsersPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public UsersPage fetchUsers(@jakarta.annotation.Nullable String name, @jakarta.annotation.Nullable LocalDate entryDateFrom, @jakarta.annotation.Nullable LocalDate entryDateTo, @jakarta.annotation.Nullable LocalDate resignDateFrom, @jakarta.annotation.Nullable LocalDate resignDateTo, @jakarta.annotation.Nullable Boolean resigned, @jakarta.annotation.Nullable String employeeNumber, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable UsersSortColumn sortBy) throws RestClientException {
        return fetchUsersWithHttpInfo(name, entryDateFrom, entryDateTo, resignDateFrom, resignDateTo, resigned, employeeNumber, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List Users
     * Lists the Users the authenticated user or API token can access.
     * <p><b>200</b> - Page of Users.
     * <p><b>400</b> - Bad Request
     * @param name Only return Users whose name contains this text. (optional)
     * @param entryDateFrom Only return Users whose entry date is on or after this day. (optional)
     * @param entryDateTo Only return Users whose entry date is on or before this day. (optional)
     * @param resignDateFrom Only return Users whose resignation date is on or after this day. (optional)
     * @param resignDateTo Only return Users whose resignation date is on or before this day. (optional)
     * @param resigned Only return Users who have resigned (true) or have not resigned (false). (optional)
     * @param employeeNumber Only return Users with this employee number. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to name)
     * @return ResponseEntity&lt;UsersPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UsersPage> fetchUsersWithHttpInfo(@jakarta.annotation.Nullable String name, @jakarta.annotation.Nullable LocalDate entryDateFrom, @jakarta.annotation.Nullable LocalDate entryDateTo, @jakarta.annotation.Nullable LocalDate resignDateFrom, @jakarta.annotation.Nullable LocalDate resignDateTo, @jakarta.annotation.Nullable Boolean resigned, @jakarta.annotation.Nullable String employeeNumber, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable UsersSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "entry_date_from", entryDateFrom));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "entry_date_to", entryDateTo));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "resign_date_from", resignDateFrom));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "resign_date_to", resignDateTo));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "resigned", resigned));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "employee_number", employeeNumber));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_token", pageToken));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_direction", sortDirection));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_by", sortBy));
        

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<UsersPage> localReturnType = new ParameterizedTypeReference<UsersPage>() {};
        return apiClient.invokeAPI("/users", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a User
     * Returns a single User by its ID.
     * <p><b>200</b> - The requested User.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User. (required)
     * @return User
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public User getUser(@jakarta.annotation.Nonnull String id) throws RestClientException {
        return getUserWithHttpInfo(id).getBody();
    }

    /**
     * Get a User
     * Returns a single User by its ID.
     * <p><b>200</b> - The requested User.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User. (required)
     * @return ResponseEntity&lt;User&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<User> getUserWithHttpInfo(@jakarta.annotation.Nonnull String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getUser");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<User> localReturnType = new ParameterizedTypeReference<User>() {};
        return apiClient.invokeAPI("/users/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a User&#39;s Work Schedule Model
     * Returns the Work Schedule Model assigned to the User, with all durations expressed in minutes.
     * <p><b>200</b> - The Work Schedule Model assigned to the User.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User. (required)
     * @return WorkScheduleModel
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WorkScheduleModel getUserWorkScheduleModel(@jakarta.annotation.Nonnull String id) throws RestClientException {
        return getUserWorkScheduleModelWithHttpInfo(id).getBody();
    }

    /**
     * Get a User&#39;s Work Schedule Model
     * Returns the Work Schedule Model assigned to the User, with all durations expressed in minutes.
     * <p><b>200</b> - The Work Schedule Model assigned to the User.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User. (required)
     * @return ResponseEntity&lt;WorkScheduleModel&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkScheduleModel> getUserWorkScheduleModelWithHttpInfo(@jakarta.annotation.Nonnull String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getUserWorkScheduleModel");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<WorkScheduleModel> localReturnType = new ParameterizedTypeReference<WorkScheduleModel>() {};
        return apiClient.invokeAPI("/users/{id}/work-schedule-model", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
     * @param id ID of the User. (required)
     * @param userUpdate User entity (required)
     * @return User
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public User updateUser(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull UserUpdate userUpdate) throws RestClientException {
        return updateUserWithHttpInfo(id, userUpdate).getBody();
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
     * @param id ID of the User. (required)
     * @param userUpdate User entity (required)
     * @return ResponseEntity&lt;User&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<User> updateUserWithHttpInfo(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull UserUpdate userUpdate) throws RestClientException {
        Object localVarPostBody = userUpdate;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateUser");
        }
        
        // verify the required parameter 'userUpdate' is set
        if (userUpdate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userUpdate' when calling updateUser");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<User> localReturnType = new ParameterizedTypeReference<User>() {};
        return apiClient.invokeAPI("/users/{id}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    @Override
    public <T> ResponseEntity<T> invokeAPI(String url, HttpMethod method, Object request, ParameterizedTypeReference<T> returnType) throws RestClientException {
        String localVarPath = url.replace(apiClient.getBasePath(), "");
        Object localVarPostBody = request;

        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        return apiClient.invokeAPI(localVarPath, method, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, returnType);
    }
}
