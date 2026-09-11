package com.timr.api.apis;

import com.timr.api.ApiClient;

import com.timr.api.models.Error;
import org.jspecify.annotations.Nullable;
import com.timr.api.models.SortDirection;
import com.timr.api.models.Team;
import com.timr.api.models.TeamCreate;
import com.timr.api.models.TeamUpdate;
import com.timr.api.models.TeamsPage;
import com.timr.api.models.TeamsSortColumn;
import java.net.URI;
import com.timr.api.models.UserPartial;
import com.timr.api.models.UsersPartialPage;
import com.timr.api.models.UsersSortColumn;

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
public class TeamApi {
    private ApiClient apiClient;

    public TeamApi() {
        this(new ApiClient());
    }

    public TeamApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Add a Team Leader
     * Adds the User to the Team as a leader. Returns 201 when the leadership is created and 200 when it already existed.
     * <p><b>200</b> - The Team Leader, which was already assigned.
     * <p><b>201</b> - The newly assigned Team Leader.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return UserPartial
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec addTeamLeaderRequestCreation(String teamId, String userId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new RestClientResponseException("Missing the required parameter 'teamId' when calling addTeamLeader", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new RestClientResponseException("Missing the required parameter 'userId' when calling addTeamLeader", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("team_id", teamId);
        pathParams.put("user_id", userId);

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

        ParameterizedTypeReference<UserPartial> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/teams/{team_id}/leaders/{user_id}", HttpMethod.PUT, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Add a Team Leader
     * Adds the User to the Team as a leader. Returns 201 when the leadership is created and 200 when it already existed.
     * <p><b>200</b> - The Team Leader, which was already assigned.
     * <p><b>201</b> - The newly assigned Team Leader.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return UserPartial
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public UserPartial addTeamLeader( String teamId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<UserPartial> localVarReturnType = new ParameterizedTypeReference<>() {};
        return addTeamLeaderRequestCreation(teamId, userId).body(localVarReturnType);
    }

    /**
     * Add a Team Leader
     * Adds the User to the Team as a leader. Returns 201 when the leadership is created and 200 when it already existed.
     * <p><b>200</b> - The Team Leader, which was already assigned.
     * <p><b>201</b> - The newly assigned Team Leader.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return ResponseEntity&lt;UserPartial&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UserPartial> addTeamLeaderWithHttpInfo( String teamId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<UserPartial> localVarReturnType = new ParameterizedTypeReference<>() {};
        return addTeamLeaderRequestCreation(teamId, userId).toEntity(localVarReturnType);
    }

    /**
     * Add a Team Leader
     * Adds the User to the Team as a leader. Returns 201 when the leadership is created and 200 when it already existed.
     * <p><b>200</b> - The Team Leader, which was already assigned.
     * <p><b>201</b> - The newly assigned Team Leader.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec addTeamLeaderWithResponseSpec(String teamId, String userId) throws RestClientResponseException {
        return addTeamLeaderRequestCreation(teamId, userId);
    }

    /**
     * Add a Team Member
     * Adds the User to the Team as a member. Returns 201 when the membership is created and 200 when it already existed.
     * <p><b>200</b> - The Team Member, which was already assigned.
     * <p><b>201</b> - The newly assigned Team Member.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return UserPartial
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec addTeamMemberRequestCreation(String teamId, String userId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new RestClientResponseException("Missing the required parameter 'teamId' when calling addTeamMember", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new RestClientResponseException("Missing the required parameter 'userId' when calling addTeamMember", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("team_id", teamId);
        pathParams.put("user_id", userId);

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

        ParameterizedTypeReference<UserPartial> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/teams/{team_id}/members/{user_id}", HttpMethod.PUT, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Add a Team Member
     * Adds the User to the Team as a member. Returns 201 when the membership is created and 200 when it already existed.
     * <p><b>200</b> - The Team Member, which was already assigned.
     * <p><b>201</b> - The newly assigned Team Member.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return UserPartial
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public UserPartial addTeamMember( String teamId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<UserPartial> localVarReturnType = new ParameterizedTypeReference<>() {};
        return addTeamMemberRequestCreation(teamId, userId).body(localVarReturnType);
    }

    /**
     * Add a Team Member
     * Adds the User to the Team as a member. Returns 201 when the membership is created and 200 when it already existed.
     * <p><b>200</b> - The Team Member, which was already assigned.
     * <p><b>201</b> - The newly assigned Team Member.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return ResponseEntity&lt;UserPartial&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UserPartial> addTeamMemberWithHttpInfo( String teamId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<UserPartial> localVarReturnType = new ParameterizedTypeReference<>() {};
        return addTeamMemberRequestCreation(teamId, userId).toEntity(localVarReturnType);
    }

    /**
     * Add a Team Member
     * Adds the User to the Team as a member. Returns 201 when the membership is created and 200 when it already existed.
     * <p><b>200</b> - The Team Member, which was already assigned.
     * <p><b>201</b> - The newly assigned Team Member.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec addTeamMemberWithResponseSpec(String teamId, String userId) throws RestClientResponseException {
        return addTeamMemberRequestCreation(teamId, userId);
    }

    /**
     * Create a Team
     * Creates a Team from the data in the request body.
     * <p><b>201</b> - The created Team.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamCreate Team entity
     * @return Team
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createTeamRequestCreation(TeamCreate teamCreate) throws RestClientResponseException {
        Object postBody = teamCreate;
        // verify the required parameter 'teamCreate' is set
        if (teamCreate == null) {
            throw new RestClientResponseException("Missing the required parameter 'teamCreate' when calling createTeam", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<Team> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/teams", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Team
     * Creates a Team from the data in the request body.
     * <p><b>201</b> - The created Team.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamCreate Team entity
     * @return Team
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public Team createTeam( TeamCreate teamCreate) throws RestClientResponseException {
        ParameterizedTypeReference<Team> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createTeamRequestCreation(teamCreate).body(localVarReturnType);
    }

    /**
     * Create a Team
     * Creates a Team from the data in the request body.
     * <p><b>201</b> - The created Team.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamCreate Team entity
     * @return ResponseEntity&lt;Team&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Team> createTeamWithHttpInfo( TeamCreate teamCreate) throws RestClientResponseException {
        ParameterizedTypeReference<Team> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createTeamRequestCreation(teamCreate).toEntity(localVarReturnType);
    }

    /**
     * Create a Team
     * Creates a Team from the data in the request body.
     * <p><b>201</b> - The created Team.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamCreate Team entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createTeamWithResponseSpec(TeamCreate teamCreate) throws RestClientResponseException {
        return createTeamRequestCreation(teamCreate);
    }

    /**
     * Delete a Team
     * Deletes the Team. Members and leaders are unassigned, the Users themselves are not deleted.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Team.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteTeamRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling deleteTeam", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/problem+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/teams/{id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Team
     * Deletes the Team. Members and leaders are unassigned, the Users themselves are not deleted.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Team.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void deleteTeam( String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        deleteTeamRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Delete a Team
     * Deletes the Team. Members and leaders are unassigned, the Users themselves are not deleted.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Team.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTeamWithHttpInfo( String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return deleteTeamRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Delete a Team
     * Deletes the Team. Members and leaders are unassigned, the Users themselves are not deleted.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Team.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteTeamWithResponseSpec(String id) throws RestClientResponseException {
        return deleteTeamRequestCreation(id);
    }

    /**
     * List Team Leaders
     * Lists the Users who lead the Team.
     * <p><b>200</b> - Page of Team Leaders.
     * <p><b>400</b> - Bad Request
     * @param id ID of the Team.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return UsersPartialPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchTeamLeadersRequestCreation(String id, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable UsersSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling fetchTeamLeaders", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<UsersPartialPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/teams/{id}/leaders", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Team Leaders
     * Lists the Users who lead the Team.
     * <p><b>200</b> - Page of Team Leaders.
     * <p><b>400</b> - Bad Request
     * @param id ID of the Team.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return UsersPartialPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public UsersPartialPage fetchTeamLeaders( String id,  String pageToken,  Integer limit,  SortDirection sortDirection,  UsersSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<UsersPartialPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchTeamLeadersRequestCreation(id, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Team Leaders
     * Lists the Users who lead the Team.
     * <p><b>200</b> - Page of Team Leaders.
     * <p><b>400</b> - Bad Request
     * @param id ID of the Team.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;UsersPartialPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UsersPartialPage> fetchTeamLeadersWithHttpInfo( String id,  String pageToken,  Integer limit,  SortDirection sortDirection,  UsersSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<UsersPartialPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchTeamLeadersRequestCreation(id, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Team Leaders
     * Lists the Users who lead the Team.
     * <p><b>200</b> - Page of Team Leaders.
     * <p><b>400</b> - Bad Request
     * @param id ID of the Team.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchTeamLeadersWithResponseSpec(String id, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable UsersSortColumn sortBy) throws RestClientResponseException {
        return fetchTeamLeadersRequestCreation(id, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * List Team Members
     * Lists the Users who are members of the Team.
     * <p><b>200</b> - Page of Team Members.
     * <p><b>400</b> - Bad Request
     * @param id ID of the Team.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return UsersPartialPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchTeamMembersRequestCreation(String id, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable UsersSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling fetchTeamMembers", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<UsersPartialPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/teams/{id}/members", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Team Members
     * Lists the Users who are members of the Team.
     * <p><b>200</b> - Page of Team Members.
     * <p><b>400</b> - Bad Request
     * @param id ID of the Team.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return UsersPartialPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public UsersPartialPage fetchTeamMembers( String id,  String pageToken,  Integer limit,  SortDirection sortDirection,  UsersSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<UsersPartialPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchTeamMembersRequestCreation(id, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Team Members
     * Lists the Users who are members of the Team.
     * <p><b>200</b> - Page of Team Members.
     * <p><b>400</b> - Bad Request
     * @param id ID of the Team.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;UsersPartialPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UsersPartialPage> fetchTeamMembersWithHttpInfo( String id,  String pageToken,  Integer limit,  SortDirection sortDirection,  UsersSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<UsersPartialPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchTeamMembersRequestCreation(id, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Team Members
     * Lists the Users who are members of the Team.
     * <p><b>200</b> - Page of Team Members.
     * <p><b>400</b> - Bad Request
     * @param id ID of the Team.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchTeamMembersWithResponseSpec(String id, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable UsersSortColumn sortBy) throws RestClientResponseException {
        return fetchTeamMembersRequestCreation(id, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * List Teams
     * Lists the Teams the authenticated user or API token can access.
     * <p><b>200</b> - Page of Teams.
     * <p><b>400</b> - Bad Request
     * @param name Only return Teams whose name matches this value in any segment of the breadcrumbs path.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return TeamsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchTeamsRequestCreation(@Nullable String name, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TeamsSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
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

        ParameterizedTypeReference<TeamsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/teams", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Teams
     * Lists the Teams the authenticated user or API token can access.
     * <p><b>200</b> - Page of Teams.
     * <p><b>400</b> - Bad Request
     * @param name Only return Teams whose name matches this value in any segment of the breadcrumbs path.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return TeamsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public TeamsPage fetchTeams( String name,  String pageToken,  Integer limit,  SortDirection sortDirection,  TeamsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<TeamsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchTeamsRequestCreation(name, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Teams
     * Lists the Teams the authenticated user or API token can access.
     * <p><b>200</b> - Page of Teams.
     * <p><b>400</b> - Bad Request
     * @param name Only return Teams whose name matches this value in any segment of the breadcrumbs path.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;TeamsPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TeamsPage> fetchTeamsWithHttpInfo( String name,  String pageToken,  Integer limit,  SortDirection sortDirection,  TeamsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<TeamsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchTeamsRequestCreation(name, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Teams
     * Lists the Teams the authenticated user or API token can access.
     * <p><b>200</b> - Page of Teams.
     * <p><b>400</b> - Bad Request
     * @param name Only return Teams whose name matches this value in any segment of the breadcrumbs path.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchTeamsWithResponseSpec(@Nullable String name, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TeamsSortColumn sortBy) throws RestClientResponseException {
        return fetchTeamsRequestCreation(name, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * Get a Team
     * Returns a single Team by its ID.
     * <p><b>200</b> - The requested Team.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Team.
     * @return Team
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getTeamRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling getTeam", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<Team> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/teams/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Team
     * Returns a single Team by its ID.
     * <p><b>200</b> - The requested Team.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Team.
     * @return Team
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public Team getTeam( String id) throws RestClientResponseException {
        ParameterizedTypeReference<Team> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTeamRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Get a Team
     * Returns a single Team by its ID.
     * <p><b>200</b> - The requested Team.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Team.
     * @return ResponseEntity&lt;Team&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Team> getTeamWithHttpInfo( String id) throws RestClientResponseException {
        ParameterizedTypeReference<Team> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTeamRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get a Team
     * Returns a single Team by its ID.
     * <p><b>200</b> - The requested Team.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Team.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getTeamWithResponseSpec(String id) throws RestClientResponseException {
        return getTeamRequestCreation(id);
    }

    /**
     * Get a Team Leader
     * Returns the leadership of a single User in the Team.
     * <p><b>200</b> - The requested Team Leader.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return UserPartial
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getTeamLeaderRequestCreation(String teamId, String userId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new RestClientResponseException("Missing the required parameter 'teamId' when calling getTeamLeader", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new RestClientResponseException("Missing the required parameter 'userId' when calling getTeamLeader", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("team_id", teamId);
        pathParams.put("user_id", userId);

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

        ParameterizedTypeReference<UserPartial> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/teams/{team_id}/leaders/{user_id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Team Leader
     * Returns the leadership of a single User in the Team.
     * <p><b>200</b> - The requested Team Leader.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return UserPartial
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public UserPartial getTeamLeader( String teamId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<UserPartial> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTeamLeaderRequestCreation(teamId, userId).body(localVarReturnType);
    }

    /**
     * Get a Team Leader
     * Returns the leadership of a single User in the Team.
     * <p><b>200</b> - The requested Team Leader.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return ResponseEntity&lt;UserPartial&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UserPartial> getTeamLeaderWithHttpInfo( String teamId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<UserPartial> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTeamLeaderRequestCreation(teamId, userId).toEntity(localVarReturnType);
    }

    /**
     * Get a Team Leader
     * Returns the leadership of a single User in the Team.
     * <p><b>200</b> - The requested Team Leader.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getTeamLeaderWithResponseSpec(String teamId, String userId) throws RestClientResponseException {
        return getTeamLeaderRequestCreation(teamId, userId);
    }

    /**
     * Get a Team Member
     * Returns the membership of a single User in the Team.
     * <p><b>200</b> - The requested Team Member.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return UserPartial
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getTeamMemberRequestCreation(String teamId, String userId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new RestClientResponseException("Missing the required parameter 'teamId' when calling getTeamMember", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new RestClientResponseException("Missing the required parameter 'userId' when calling getTeamMember", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("team_id", teamId);
        pathParams.put("user_id", userId);

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

        ParameterizedTypeReference<UserPartial> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/teams/{team_id}/members/{user_id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Team Member
     * Returns the membership of a single User in the Team.
     * <p><b>200</b> - The requested Team Member.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return UserPartial
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public UserPartial getTeamMember( String teamId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<UserPartial> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTeamMemberRequestCreation(teamId, userId).body(localVarReturnType);
    }

    /**
     * Get a Team Member
     * Returns the membership of a single User in the Team.
     * <p><b>200</b> - The requested Team Member.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return ResponseEntity&lt;UserPartial&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UserPartial> getTeamMemberWithHttpInfo( String teamId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<UserPartial> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTeamMemberRequestCreation(teamId, userId).toEntity(localVarReturnType);
    }

    /**
     * Get a Team Member
     * Returns the membership of a single User in the Team.
     * <p><b>200</b> - The requested Team Member.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getTeamMemberWithResponseSpec(String teamId, String userId) throws RestClientResponseException {
        return getTeamMemberRequestCreation(teamId, userId);
    }

    /**
     * Remove a Team Leader
     * Removes the User&#39;s leadership of the Team. The User itself is not deleted.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec removeTeamLeaderRequestCreation(String teamId, String userId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new RestClientResponseException("Missing the required parameter 'teamId' when calling removeTeamLeader", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new RestClientResponseException("Missing the required parameter 'userId' when calling removeTeamLeader", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("team_id", teamId);
        pathParams.put("user_id", userId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/problem+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/teams/{team_id}/leaders/{user_id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Remove a Team Leader
     * Removes the User&#39;s leadership of the Team. The User itself is not deleted.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void removeTeamLeader( String teamId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        removeTeamLeaderRequestCreation(teamId, userId).body(localVarReturnType);
    }

    /**
     * Remove a Team Leader
     * Removes the User&#39;s leadership of the Team. The User itself is not deleted.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> removeTeamLeaderWithHttpInfo( String teamId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return removeTeamLeaderRequestCreation(teamId, userId).toEntity(localVarReturnType);
    }

    /**
     * Remove a Team Leader
     * Removes the User&#39;s leadership of the Team. The User itself is not deleted.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec removeTeamLeaderWithResponseSpec(String teamId, String userId) throws RestClientResponseException {
        return removeTeamLeaderRequestCreation(teamId, userId);
    }

    /**
     * Remove a Team Member
     * Removes the User&#39;s membership in the Team. The User itself is not deleted.
     * <p><b>204</b> - Removed. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec removeTeamMemberRequestCreation(String teamId, String userId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new RestClientResponseException("Missing the required parameter 'teamId' when calling removeTeamMember", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new RestClientResponseException("Missing the required parameter 'userId' when calling removeTeamMember", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("team_id", teamId);
        pathParams.put("user_id", userId);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/problem+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/teams/{team_id}/members/{user_id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Remove a Team Member
     * Removes the User&#39;s membership in the Team. The User itself is not deleted.
     * <p><b>204</b> - Removed. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void removeTeamMember( String teamId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        removeTeamMemberRequestCreation(teamId, userId).body(localVarReturnType);
    }

    /**
     * Remove a Team Member
     * Removes the User&#39;s membership in the Team. The User itself is not deleted.
     * <p><b>204</b> - Removed. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> removeTeamMemberWithHttpInfo( String teamId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return removeTeamMemberRequestCreation(teamId, userId).toEntity(localVarReturnType);
    }

    /**
     * Remove a Team Member
     * Removes the User&#39;s membership in the Team. The User itself is not deleted.
     * <p><b>204</b> - Removed. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param teamId ID of the Team.
     * @param userId ID of the User.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec removeTeamMemberWithResponseSpec(String teamId, String userId) throws RestClientResponseException {
        return removeTeamMemberRequestCreation(teamId, userId);
    }

    /**
     * Update a Team
     * Updates the Team with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Team.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Team.
     * @param teamUpdate Team entity
     * @return Team
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateTeamRequestCreation(String id, TeamUpdate teamUpdate) throws RestClientResponseException {
        Object postBody = teamUpdate;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling updateTeam", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'teamUpdate' is set
        if (teamUpdate == null) {
            throw new RestClientResponseException("Missing the required parameter 'teamUpdate' when calling updateTeam", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<Team> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/teams/{id}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update a Team
     * Updates the Team with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Team.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Team.
     * @param teamUpdate Team entity
     * @return Team
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public Team updateTeam( String id,  TeamUpdate teamUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<Team> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateTeamRequestCreation(id, teamUpdate).body(localVarReturnType);
    }

    /**
     * Update a Team
     * Updates the Team with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Team.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Team.
     * @param teamUpdate Team entity
     * @return ResponseEntity&lt;Team&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Team> updateTeamWithHttpInfo( String id,  TeamUpdate teamUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<Team> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateTeamRequestCreation(id, teamUpdate).toEntity(localVarReturnType);
    }

    /**
     * Update a Team
     * Updates the Team with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Team.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Team.
     * @param teamUpdate Team entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateTeamWithResponseSpec(String id, TeamUpdate teamUpdate) throws RestClientResponseException {
        return updateTeamRequestCreation(id, teamUpdate);
    }
}
