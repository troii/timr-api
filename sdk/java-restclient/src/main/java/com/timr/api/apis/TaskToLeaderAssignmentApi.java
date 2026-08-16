package com.timr.api.apis;

import com.timr.api.ApiClient;

import com.timr.api.models.Error;
import org.jspecify.annotations.Nullable;
import com.timr.api.models.SortDirection;
import com.timr.api.models.TaskToLeaderAssignment;
import com.timr.api.models.TaskToLeaderAssignmentsPage;
import com.timr.api.models.TaskToLeaderAssignmentsSortColumn;
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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.22.0")
public class TaskToLeaderAssignmentApi {
    private ApiClient apiClient;

    public TaskToLeaderAssignmentApi() {
        this(new ApiClient());
    }

    public TaskToLeaderAssignmentApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a Task to Leader Assignment
     * Assigns the User to the Task as a leader. Returns 201 when the assignment is created and 200 when it already existed.
     * <p><b>200</b> - The Task to Leader Assignment, which already existed.
     * <p><b>201</b> - The created Task to Leader Assignment.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @return TaskToLeaderAssignment
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createTaskToLeaderAssignmentRequestCreation(String taskId, String userId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskId' when calling createTaskToLeaderAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new RestClientResponseException("Missing the required parameter 'userId' when calling createTaskToLeaderAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("task_id", taskId);
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

        ParameterizedTypeReference<TaskToLeaderAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/leaders/{user_id}", HttpMethod.PUT, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Task to Leader Assignment
     * Assigns the User to the Task as a leader. Returns 201 when the assignment is created and 200 when it already existed.
     * <p><b>200</b> - The Task to Leader Assignment, which already existed.
     * <p><b>201</b> - The created Task to Leader Assignment.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @return TaskToLeaderAssignment
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public TaskToLeaderAssignment createTaskToLeaderAssignment( String taskId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToLeaderAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createTaskToLeaderAssignmentRequestCreation(taskId, userId).body(localVarReturnType);
    }

    /**
     * Create a Task to Leader Assignment
     * Assigns the User to the Task as a leader. Returns 201 when the assignment is created and 200 when it already existed.
     * <p><b>200</b> - The Task to Leader Assignment, which already existed.
     * <p><b>201</b> - The created Task to Leader Assignment.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @return ResponseEntity&lt;TaskToLeaderAssignment&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TaskToLeaderAssignment> createTaskToLeaderAssignmentWithHttpInfo( String taskId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToLeaderAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createTaskToLeaderAssignmentRequestCreation(taskId, userId).toEntity(localVarReturnType);
    }

    /**
     * Create a Task to Leader Assignment
     * Assigns the User to the Task as a leader. Returns 201 when the assignment is created and 200 when it already existed.
     * <p><b>200</b> - The Task to Leader Assignment, which already existed.
     * <p><b>201</b> - The created Task to Leader Assignment.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createTaskToLeaderAssignmentWithResponseSpec(String taskId, String userId) throws RestClientResponseException {
        return createTaskToLeaderAssignmentRequestCreation(taskId, userId);
    }

    /**
     * Delete a Task to Leader Assignment
     * Removes the User&#39;s leader assignment to the Task.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteTaskToLeaderAssignmentRequestCreation(String taskId, String userId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskId' when calling deleteTaskToLeaderAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new RestClientResponseException("Missing the required parameter 'userId' when calling deleteTaskToLeaderAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("task_id", taskId);
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
        return apiClient.invokeAPI("/tasks/{task_id}/leaders/{user_id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Task to Leader Assignment
     * Removes the User&#39;s leader assignment to the Task.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void deleteTaskToLeaderAssignment( String taskId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        deleteTaskToLeaderAssignmentRequestCreation(taskId, userId).body(localVarReturnType);
    }

    /**
     * Delete a Task to Leader Assignment
     * Removes the User&#39;s leader assignment to the Task.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTaskToLeaderAssignmentWithHttpInfo( String taskId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return deleteTaskToLeaderAssignmentRequestCreation(taskId, userId).toEntity(localVarReturnType);
    }

    /**
     * Delete a Task to Leader Assignment
     * Removes the User&#39;s leader assignment to the Task.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteTaskToLeaderAssignmentWithResponseSpec(String taskId, String userId) throws RestClientResponseException {
        return deleteTaskToLeaderAssignmentRequestCreation(taskId, userId);
    }

    /**
     * List Task to Leader Assignments
     * Lists the Users assigned to the Task as leaders.
     * <p><b>200</b> - Page of Task to Leader Assignments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return TaskToLeaderAssignmentsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchTaskToLeaderAssignmentsRequestCreation(String taskId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TaskToLeaderAssignmentsSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskId' when calling fetchTaskToLeaderAssignments", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("task_id", taskId);

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

        ParameterizedTypeReference<TaskToLeaderAssignmentsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/leaders", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Task to Leader Assignments
     * Lists the Users assigned to the Task as leaders.
     * <p><b>200</b> - Page of Task to Leader Assignments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return TaskToLeaderAssignmentsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public TaskToLeaderAssignmentsPage fetchTaskToLeaderAssignments( String taskId,  String pageToken,  Integer limit,  SortDirection sortDirection,  TaskToLeaderAssignmentsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToLeaderAssignmentsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchTaskToLeaderAssignmentsRequestCreation(taskId, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Task to Leader Assignments
     * Lists the Users assigned to the Task as leaders.
     * <p><b>200</b> - Page of Task to Leader Assignments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;TaskToLeaderAssignmentsPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TaskToLeaderAssignmentsPage> fetchTaskToLeaderAssignmentsWithHttpInfo( String taskId,  String pageToken,  Integer limit,  SortDirection sortDirection,  TaskToLeaderAssignmentsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToLeaderAssignmentsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchTaskToLeaderAssignmentsRequestCreation(taskId, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Task to Leader Assignments
     * Lists the Users assigned to the Task as leaders.
     * <p><b>200</b> - Page of Task to Leader Assignments.
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
    public ResponseSpec fetchTaskToLeaderAssignmentsWithResponseSpec(String taskId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TaskToLeaderAssignmentsSortColumn sortBy) throws RestClientResponseException {
        return fetchTaskToLeaderAssignmentsRequestCreation(taskId, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * Get a Task to Leader Assignment
     * Returns the leader assignment of a single User to the Task.
     * <p><b>200</b> - The requested Task to Leader Assignment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @return TaskToLeaderAssignment
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getTaskToLeaderAssignmentRequestCreation(String taskId, String userId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskId' when calling getTaskToLeaderAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new RestClientResponseException("Missing the required parameter 'userId' when calling getTaskToLeaderAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("task_id", taskId);
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

        ParameterizedTypeReference<TaskToLeaderAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/leaders/{user_id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Task to Leader Assignment
     * Returns the leader assignment of a single User to the Task.
     * <p><b>200</b> - The requested Task to Leader Assignment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @return TaskToLeaderAssignment
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public TaskToLeaderAssignment getTaskToLeaderAssignment( String taskId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToLeaderAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTaskToLeaderAssignmentRequestCreation(taskId, userId).body(localVarReturnType);
    }

    /**
     * Get a Task to Leader Assignment
     * Returns the leader assignment of a single User to the Task.
     * <p><b>200</b> - The requested Task to Leader Assignment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @return ResponseEntity&lt;TaskToLeaderAssignment&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TaskToLeaderAssignment> getTaskToLeaderAssignmentWithHttpInfo( String taskId,  String userId) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToLeaderAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTaskToLeaderAssignmentRequestCreation(taskId, userId).toEntity(localVarReturnType);
    }

    /**
     * Get a Task to Leader Assignment
     * Returns the leader assignment of a single User to the Task.
     * <p><b>200</b> - The requested Task to Leader Assignment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getTaskToLeaderAssignmentWithResponseSpec(String taskId, String userId) throws RestClientResponseException {
        return getTaskToLeaderAssignmentRequestCreation(taskId, userId);
    }
}
