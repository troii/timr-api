package com.timr.api.apis;

import com.timr.api.ApiClient;

import com.timr.api.models.Error;
import org.jspecify.annotations.Nullable;
import com.timr.api.models.SortDirection;
import com.timr.api.models.TaskToTeamAssignment;
import com.timr.api.models.TaskToTeamAssignmentsPage;
import com.timr.api.models.TaskToTeamAssignmentsSortColumn;
import java.net.URI;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.26.0")
public class TaskToTeamAssignmentApi {
    private ApiClient apiClient;

    public TaskToTeamAssignmentApi() {
        this(new ApiClient());
    }

    public TaskToTeamAssignmentApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a Task to Team Assignment
     * Assigns the Team to the Task. Returns 201 when the assignment is created and 200 when it already existed.
     * <p><b>200</b> - The updated Task to Team Assignment.
     * <p><b>201</b> - The created Task to Team Assignment.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskId ID of the Task.
     * @param teamId ID of the Team.
     * @return TaskToTeamAssignment
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createTaskToTeamAssignmentRequestCreation(String taskId, String teamId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskId' when calling createTaskToTeamAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new RestClientResponseException("Missing the required parameter 'teamId' when calling createTaskToTeamAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("task_id", taskId);
        pathParams.put("team_id", teamId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<>();
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

        ParameterizedTypeReference<TaskToTeamAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/teams/{team_id}", HttpMethod.PUT, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Task to Team Assignment
     * Assigns the Team to the Task. Returns 201 when the assignment is created and 200 when it already existed.
     * <p><b>200</b> - The updated Task to Team Assignment.
     * <p><b>201</b> - The created Task to Team Assignment.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskId ID of the Task.
     * @param teamId ID of the Team.
     * @return TaskToTeamAssignment
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public TaskToTeamAssignment createTaskToTeamAssignment(String taskId, String teamId) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToTeamAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createTaskToTeamAssignmentRequestCreation(taskId, teamId).body(localVarReturnType);
    }

    /**
     * Create a Task to Team Assignment
     * Assigns the Team to the Task. Returns 201 when the assignment is created and 200 when it already existed.
     * <p><b>200</b> - The updated Task to Team Assignment.
     * <p><b>201</b> - The created Task to Team Assignment.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskId ID of the Task.
     * @param teamId ID of the Team.
     * @return ResponseEntity&lt;TaskToTeamAssignment&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TaskToTeamAssignment> createTaskToTeamAssignmentWithHttpInfo(String taskId, String teamId) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToTeamAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createTaskToTeamAssignmentRequestCreation(taskId, teamId).toEntity(localVarReturnType);
    }

    /**
     * Create a Task to Team Assignment
     * Assigns the Team to the Task. Returns 201 when the assignment is created and 200 when it already existed.
     * <p><b>200</b> - The updated Task to Team Assignment.
     * <p><b>201</b> - The created Task to Team Assignment.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskId ID of the Task.
     * @param teamId ID of the Team.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createTaskToTeamAssignmentWithResponseSpec(String taskId, String teamId) throws RestClientResponseException {
        return createTaskToTeamAssignmentRequestCreation(taskId, teamId);
    }

    /**
     * Delete a Task to Team Assignment
     * Removes the Team&#39;s assignment to the Task.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param taskId ID of the Task.
     * @param teamId ID of the Team.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteTaskToTeamAssignmentRequestCreation(String taskId, String teamId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskId' when calling deleteTaskToTeamAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new RestClientResponseException("Missing the required parameter 'teamId' when calling deleteTaskToTeamAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("task_id", taskId);
        pathParams.put("team_id", teamId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<>();
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
        return apiClient.invokeAPI("/tasks/{task_id}/teams/{team_id}", HttpMethod.DELETE, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Task to Team Assignment
     * Removes the Team&#39;s assignment to the Task.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param taskId ID of the Task.
     * @param teamId ID of the Team.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void deleteTaskToTeamAssignment(String taskId, String teamId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        deleteTaskToTeamAssignmentRequestCreation(taskId, teamId).body(localVarReturnType);
    }

    /**
     * Delete a Task to Team Assignment
     * Removes the Team&#39;s assignment to the Task.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param taskId ID of the Task.
     * @param teamId ID of the Team.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTaskToTeamAssignmentWithHttpInfo(String taskId, String teamId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return deleteTaskToTeamAssignmentRequestCreation(taskId, teamId).toEntity(localVarReturnType);
    }

    /**
     * Delete a Task to Team Assignment
     * Removes the Team&#39;s assignment to the Task.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param taskId ID of the Task.
     * @param teamId ID of the Team.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteTaskToTeamAssignmentWithResponseSpec(String taskId, String teamId) throws RestClientResponseException {
        return deleteTaskToTeamAssignmentRequestCreation(taskId, teamId);
    }

    /**
     * List Task to Team Assignments
     * Lists the Teams assigned to the Task.
     * <p><b>200</b> - Page of Task to Team Assignments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return TaskToTeamAssignmentsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchTaskToTeamAssignmentsRequestCreation(String taskId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TaskToTeamAssignmentsSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskId' when calling fetchTaskToTeamAssignments", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("task_id", taskId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_token", pageToken));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_direction", sortDirection));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "sort_by", sortBy));

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<TaskToTeamAssignmentsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/teams", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Task to Team Assignments
     * Lists the Teams assigned to the Task.
     * <p><b>200</b> - Page of Task to Team Assignments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return TaskToTeamAssignmentsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public TaskToTeamAssignmentsPage fetchTaskToTeamAssignments(String taskId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TaskToTeamAssignmentsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToTeamAssignmentsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchTaskToTeamAssignmentsRequestCreation(taskId, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Task to Team Assignments
     * Lists the Teams assigned to the Task.
     * <p><b>200</b> - Page of Task to Team Assignments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;TaskToTeamAssignmentsPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TaskToTeamAssignmentsPage> fetchTaskToTeamAssignmentsWithHttpInfo(String taskId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TaskToTeamAssignmentsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToTeamAssignmentsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchTaskToTeamAssignmentsRequestCreation(taskId, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Task to Team Assignments
     * Lists the Teams assigned to the Task.
     * <p><b>200</b> - Page of Task to Team Assignments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchTaskToTeamAssignmentsWithResponseSpec(String taskId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TaskToTeamAssignmentsSortColumn sortBy) throws RestClientResponseException {
        return fetchTaskToTeamAssignmentsRequestCreation(taskId, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * Get a Task to Team Assignment
     * Returns the assignment of a single Team to the Task.
     * <p><b>200</b> - The requested Task to Team Assignment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param teamId ID of the Team.
     * @return TaskToTeamAssignment
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getTaskToTeamAssignmentRequestCreation(String taskId, String teamId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskId' when calling getTaskToTeamAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new RestClientResponseException("Missing the required parameter 'teamId' when calling getTaskToTeamAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("task_id", taskId);
        pathParams.put("team_id", teamId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<>();
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

        ParameterizedTypeReference<TaskToTeamAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/teams/{team_id}", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Task to Team Assignment
     * Returns the assignment of a single Team to the Task.
     * <p><b>200</b> - The requested Task to Team Assignment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param teamId ID of the Team.
     * @return TaskToTeamAssignment
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public TaskToTeamAssignment getTaskToTeamAssignment(String taskId, String teamId) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToTeamAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTaskToTeamAssignmentRequestCreation(taskId, teamId).body(localVarReturnType);
    }

    /**
     * Get a Task to Team Assignment
     * Returns the assignment of a single Team to the Task.
     * <p><b>200</b> - The requested Task to Team Assignment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param teamId ID of the Team.
     * @return ResponseEntity&lt;TaskToTeamAssignment&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TaskToTeamAssignment> getTaskToTeamAssignmentWithHttpInfo(String taskId, String teamId) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToTeamAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTaskToTeamAssignmentRequestCreation(taskId, teamId).toEntity(localVarReturnType);
    }

    /**
     * Get a Task to Team Assignment
     * Returns the assignment of a single Team to the Task.
     * <p><b>200</b> - The requested Task to Team Assignment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param teamId ID of the Team.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getTaskToTeamAssignmentWithResponseSpec(String taskId, String teamId) throws RestClientResponseException {
        return getTaskToTeamAssignmentRequestCreation(taskId, teamId);
    }
}
