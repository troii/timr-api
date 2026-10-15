package com.timr.api.apis;

import com.timr.api.ApiClient;
import com.timr.api.BaseApi;

import com.timr.api.models.Error;
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
@Component("com.timr.api.apis.TeamApi")
public class TeamApi extends BaseApi {

    public TeamApi() {
        super(new ApiClient());
    }

    @Autowired
    public TeamApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Add a Team Leader
     * Adds the User to the Team as a leader. Returns 201 when the leadership is created and 200 when it already existed.
     * <p><b>200</b> - The Team Leader, which was already assigned.
     * <p><b>201</b> - The newly assigned Team Leader.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamId ID of the Team. (required)
     * @param userId ID of the User. (required)
     * @return UserPartial
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public UserPartial addTeamLeader(@jakarta.annotation.Nonnull String teamId, @jakarta.annotation.Nonnull String userId) throws RestClientException {
        return addTeamLeaderWithHttpInfo(teamId, userId).getBody();
    }

    /**
     * Add a Team Leader
     * Adds the User to the Team as a leader. Returns 201 when the leadership is created and 200 when it already existed.
     * <p><b>200</b> - The Team Leader, which was already assigned.
     * <p><b>201</b> - The newly assigned Team Leader.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamId ID of the Team. (required)
     * @param userId ID of the User. (required)
     * @return ResponseEntity&lt;UserPartial&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UserPartial> addTeamLeaderWithHttpInfo(@jakarta.annotation.Nonnull String teamId, @jakarta.annotation.Nonnull String userId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'teamId' when calling addTeamLeader");
        }
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling addTeamLeader");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("team_id", teamId);
        uriVariables.put("user_id", userId);

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

        ParameterizedTypeReference<UserPartial> localReturnType = new ParameterizedTypeReference<UserPartial>() {};
        return apiClient.invokeAPI("/teams/{team_id}/leaders/{user_id}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Add a Team Member
     * Adds the User to the Team as a member. Returns 201 when the membership is created and 200 when it already existed.
     * <p><b>200</b> - The Team Member, which was already assigned.
     * <p><b>201</b> - The newly assigned Team Member.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamId ID of the Team. (required)
     * @param userId ID of the User. (required)
     * @return UserPartial
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public UserPartial addTeamMember(@jakarta.annotation.Nonnull String teamId, @jakarta.annotation.Nonnull String userId) throws RestClientException {
        return addTeamMemberWithHttpInfo(teamId, userId).getBody();
    }

    /**
     * Add a Team Member
     * Adds the User to the Team as a member. Returns 201 when the membership is created and 200 when it already existed.
     * <p><b>200</b> - The Team Member, which was already assigned.
     * <p><b>201</b> - The newly assigned Team Member.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamId ID of the Team. (required)
     * @param userId ID of the User. (required)
     * @return ResponseEntity&lt;UserPartial&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UserPartial> addTeamMemberWithHttpInfo(@jakarta.annotation.Nonnull String teamId, @jakarta.annotation.Nonnull String userId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'teamId' when calling addTeamMember");
        }
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling addTeamMember");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("team_id", teamId);
        uriVariables.put("user_id", userId);

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

        ParameterizedTypeReference<UserPartial> localReturnType = new ParameterizedTypeReference<UserPartial>() {};
        return apiClient.invokeAPI("/teams/{team_id}/members/{user_id}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Create a Team
     * Creates a Team from the data in the request body.
     * <p><b>201</b> - The created Team.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamCreate Team entity (required)
     * @return Team
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Team createTeam(@jakarta.annotation.Nonnull TeamCreate teamCreate) throws RestClientException {
        return createTeamWithHttpInfo(teamCreate).getBody();
    }

    /**
     * Create a Team
     * Creates a Team from the data in the request body.
     * <p><b>201</b> - The created Team.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param teamCreate Team entity (required)
     * @return ResponseEntity&lt;Team&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Team> createTeamWithHttpInfo(@jakarta.annotation.Nonnull TeamCreate teamCreate) throws RestClientException {
        Object localVarPostBody = teamCreate;
        
        // verify the required parameter 'teamCreate' is set
        if (teamCreate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'teamCreate' when calling createTeam");
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

        ParameterizedTypeReference<Team> localReturnType = new ParameterizedTypeReference<Team>() {};
        return apiClient.invokeAPI("/teams", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a Team
     * Deletes the Team. Members and leaders are unassigned, the Users themselves are not deleted.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Team. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteTeam(@jakarta.annotation.Nonnull String id) throws RestClientException {
        deleteTeamWithHttpInfo(id);
    }

    /**
     * Delete a Team
     * Deletes the Team. Members and leaders are unassigned, the Users themselves are not deleted.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Team. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTeamWithHttpInfo(@jakarta.annotation.Nonnull String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteTeam");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/problem+json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/teams/{id}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List Team Leaders
     * Lists the Users who lead the Team.
     * <p><b>200</b> - Page of Team Leaders.
     * <p><b>400</b> - Bad Request
     * @param id ID of the Team. (required)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to name)
     * @return UsersPartialPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public UsersPartialPage fetchTeamLeaders(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable UsersSortColumn sortBy) throws RestClientException {
        return fetchTeamLeadersWithHttpInfo(id, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List Team Leaders
     * Lists the Users who lead the Team.
     * <p><b>200</b> - Page of Team Leaders.
     * <p><b>400</b> - Bad Request
     * @param id ID of the Team. (required)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to name)
     * @return ResponseEntity&lt;UsersPartialPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UsersPartialPage> fetchTeamLeadersWithHttpInfo(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable UsersSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling fetchTeamLeaders");
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

        ParameterizedTypeReference<UsersPartialPage> localReturnType = new ParameterizedTypeReference<UsersPartialPage>() {};
        return apiClient.invokeAPI("/teams/{id}/leaders", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List Team Members
     * Lists the Users who are members of the Team.
     * <p><b>200</b> - Page of Team Members.
     * <p><b>400</b> - Bad Request
     * @param id ID of the Team. (required)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to name)
     * @return UsersPartialPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public UsersPartialPage fetchTeamMembers(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable UsersSortColumn sortBy) throws RestClientException {
        return fetchTeamMembersWithHttpInfo(id, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List Team Members
     * Lists the Users who are members of the Team.
     * <p><b>200</b> - Page of Team Members.
     * <p><b>400</b> - Bad Request
     * @param id ID of the Team. (required)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to name)
     * @return ResponseEntity&lt;UsersPartialPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UsersPartialPage> fetchTeamMembersWithHttpInfo(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable UsersSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling fetchTeamMembers");
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

        ParameterizedTypeReference<UsersPartialPage> localReturnType = new ParameterizedTypeReference<UsersPartialPage>() {};
        return apiClient.invokeAPI("/teams/{id}/members", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List Teams
     * Lists the Teams the authenticated user or API token can access.
     * <p><b>200</b> - Page of Teams.
     * <p><b>400</b> - Bad Request
     * @param name Only return Teams whose name matches this value in any segment of the breadcrumbs path. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to breadcrumbs)
     * @return TeamsPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TeamsPage fetchTeams(@jakarta.annotation.Nullable String name, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable TeamsSortColumn sortBy) throws RestClientException {
        return fetchTeamsWithHttpInfo(name, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List Teams
     * Lists the Teams the authenticated user or API token can access.
     * <p><b>200</b> - Page of Teams.
     * <p><b>400</b> - Bad Request
     * @param name Only return Teams whose name matches this value in any segment of the breadcrumbs path. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to breadcrumbs)
     * @return ResponseEntity&lt;TeamsPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TeamsPage> fetchTeamsWithHttpInfo(@jakarta.annotation.Nullable String name, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable TeamsSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
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

        ParameterizedTypeReference<TeamsPage> localReturnType = new ParameterizedTypeReference<TeamsPage>() {};
        return apiClient.invokeAPI("/teams", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a Team
     * Returns a single Team by its ID.
     * <p><b>200</b> - The requested Team.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Team. (required)
     * @return Team
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Team getTeam(@jakarta.annotation.Nonnull String id) throws RestClientException {
        return getTeamWithHttpInfo(id).getBody();
    }

    /**
     * Get a Team
     * Returns a single Team by its ID.
     * <p><b>200</b> - The requested Team.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Team. (required)
     * @return ResponseEntity&lt;Team&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Team> getTeamWithHttpInfo(@jakarta.annotation.Nonnull String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getTeam");
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

        ParameterizedTypeReference<Team> localReturnType = new ParameterizedTypeReference<Team>() {};
        return apiClient.invokeAPI("/teams/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a Team Leader
     * Returns the leadership of a single User in the Team.
     * <p><b>200</b> - The requested Team Leader.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param teamId ID of the Team. (required)
     * @param userId ID of the User. (required)
     * @return UserPartial
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public UserPartial getTeamLeader(@jakarta.annotation.Nonnull String teamId, @jakarta.annotation.Nonnull String userId) throws RestClientException {
        return getTeamLeaderWithHttpInfo(teamId, userId).getBody();
    }

    /**
     * Get a Team Leader
     * Returns the leadership of a single User in the Team.
     * <p><b>200</b> - The requested Team Leader.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param teamId ID of the Team. (required)
     * @param userId ID of the User. (required)
     * @return ResponseEntity&lt;UserPartial&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UserPartial> getTeamLeaderWithHttpInfo(@jakarta.annotation.Nonnull String teamId, @jakarta.annotation.Nonnull String userId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'teamId' when calling getTeamLeader");
        }
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling getTeamLeader");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("team_id", teamId);
        uriVariables.put("user_id", userId);

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

        ParameterizedTypeReference<UserPartial> localReturnType = new ParameterizedTypeReference<UserPartial>() {};
        return apiClient.invokeAPI("/teams/{team_id}/leaders/{user_id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a Team Member
     * Returns the membership of a single User in the Team.
     * <p><b>200</b> - The requested Team Member.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param teamId ID of the Team. (required)
     * @param userId ID of the User. (required)
     * @return UserPartial
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public UserPartial getTeamMember(@jakarta.annotation.Nonnull String teamId, @jakarta.annotation.Nonnull String userId) throws RestClientException {
        return getTeamMemberWithHttpInfo(teamId, userId).getBody();
    }

    /**
     * Get a Team Member
     * Returns the membership of a single User in the Team.
     * <p><b>200</b> - The requested Team Member.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param teamId ID of the Team. (required)
     * @param userId ID of the User. (required)
     * @return ResponseEntity&lt;UserPartial&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UserPartial> getTeamMemberWithHttpInfo(@jakarta.annotation.Nonnull String teamId, @jakarta.annotation.Nonnull String userId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'teamId' when calling getTeamMember");
        }
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling getTeamMember");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("team_id", teamId);
        uriVariables.put("user_id", userId);

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

        ParameterizedTypeReference<UserPartial> localReturnType = new ParameterizedTypeReference<UserPartial>() {};
        return apiClient.invokeAPI("/teams/{team_id}/members/{user_id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Remove a Team Leader
     * Removes the User&#39;s leadership of the Team. The User itself is not deleted.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param teamId ID of the Team. (required)
     * @param userId ID of the User. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void removeTeamLeader(@jakarta.annotation.Nonnull String teamId, @jakarta.annotation.Nonnull String userId) throws RestClientException {
        removeTeamLeaderWithHttpInfo(teamId, userId);
    }

    /**
     * Remove a Team Leader
     * Removes the User&#39;s leadership of the Team. The User itself is not deleted.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param teamId ID of the Team. (required)
     * @param userId ID of the User. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> removeTeamLeaderWithHttpInfo(@jakarta.annotation.Nonnull String teamId, @jakarta.annotation.Nonnull String userId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'teamId' when calling removeTeamLeader");
        }
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling removeTeamLeader");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("team_id", teamId);
        uriVariables.put("user_id", userId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/problem+json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/teams/{team_id}/leaders/{user_id}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Remove a Team Member
     * Removes the User&#39;s membership in the Team. The User itself is not deleted.
     * <p><b>204</b> - Removed. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param teamId ID of the Team. (required)
     * @param userId ID of the User. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void removeTeamMember(@jakarta.annotation.Nonnull String teamId, @jakarta.annotation.Nonnull String userId) throws RestClientException {
        removeTeamMemberWithHttpInfo(teamId, userId);
    }

    /**
     * Remove a Team Member
     * Removes the User&#39;s membership in the Team. The User itself is not deleted.
     * <p><b>204</b> - Removed. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param teamId ID of the Team. (required)
     * @param userId ID of the User. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> removeTeamMemberWithHttpInfo(@jakarta.annotation.Nonnull String teamId, @jakarta.annotation.Nonnull String userId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'teamId' when calling removeTeamMember");
        }
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling removeTeamMember");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("team_id", teamId);
        uriVariables.put("user_id", userId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/problem+json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/teams/{team_id}/members/{user_id}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
     * @param id ID of the Team. (required)
     * @param teamUpdate Team entity (required)
     * @return Team
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Team updateTeam(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull TeamUpdate teamUpdate) throws RestClientException {
        return updateTeamWithHttpInfo(id, teamUpdate).getBody();
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
     * @param id ID of the Team. (required)
     * @param teamUpdate Team entity (required)
     * @return ResponseEntity&lt;Team&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Team> updateTeamWithHttpInfo(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull TeamUpdate teamUpdate) throws RestClientException {
        Object localVarPostBody = teamUpdate;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateTeam");
        }
        
        // verify the required parameter 'teamUpdate' is set
        if (teamUpdate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'teamUpdate' when calling updateTeam");
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

        ParameterizedTypeReference<Team> localReturnType = new ParameterizedTypeReference<Team>() {};
        return apiClient.invokeAPI("/teams/{id}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
