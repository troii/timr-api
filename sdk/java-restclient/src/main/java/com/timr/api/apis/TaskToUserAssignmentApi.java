package com.timr.api.apis;

import com.timr.api.ApiClient;

import com.timr.api.models.Error;
import org.jspecify.annotations.Nullable;
import com.timr.api.models.SortDirection;
import com.timr.api.models.TaskToUserAssignment;
import com.timr.api.models.TaskToUserAssignmentUpsert;
import com.timr.api.models.TaskToUserAssignmentsPage;
import com.timr.api.models.TaskToUserAssignmentsSortColumn;
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
public class TaskToUserAssignmentApi {
    private ApiClient apiClient;

    public TaskToUserAssignmentApi() {
        this(new ApiClient());
    }

    public TaskToUserAssignmentApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a Task to User Assignment
     * Removes the User&#39;s assignment to the Task.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteTaskToUserAssignmentRequestCreation(String taskId, String userId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskId' when calling deleteTaskToUserAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new RestClientResponseException("Missing the required parameter 'userId' when calling deleteTaskToUserAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("task_id", taskId);
        pathParams.put("user_id", userId);

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
        return apiClient.invokeAPI("/tasks/{task_id}/users/{user_id}", HttpMethod.DELETE, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Task to User Assignment
     * Removes the User&#39;s assignment to the Task.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void deleteTaskToUserAssignment(String taskId, String userId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        deleteTaskToUserAssignmentRequestCreation(taskId, userId).body(localVarReturnType);
    }

    /**
     * Delete a Task to User Assignment
     * Removes the User&#39;s assignment to the Task.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTaskToUserAssignmentWithHttpInfo(String taskId, String userId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return deleteTaskToUserAssignmentRequestCreation(taskId, userId).toEntity(localVarReturnType);
    }

    /**
     * Delete a Task to User Assignment
     * Removes the User&#39;s assignment to the Task.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteTaskToUserAssignmentWithResponseSpec(String taskId, String userId) throws RestClientResponseException {
        return deleteTaskToUserAssignmentRequestCreation(taskId, userId);
    }

    /**
     * List Task to User Assignments
     * Lists the Users assigned to the Task, together with the budget and recording settings of each assignment.
     * <p><b>200</b> - Page of Task to User Assignments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return TaskToUserAssignmentsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchTaskToUserAssignmentsRequestCreation(String taskId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TaskToUserAssignmentsSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskId' when calling fetchTaskToUserAssignments", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<TaskToUserAssignmentsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/users", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Task to User Assignments
     * Lists the Users assigned to the Task, together with the budget and recording settings of each assignment.
     * <p><b>200</b> - Page of Task to User Assignments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return TaskToUserAssignmentsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public TaskToUserAssignmentsPage fetchTaskToUserAssignments(String taskId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TaskToUserAssignmentsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToUserAssignmentsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchTaskToUserAssignmentsRequestCreation(taskId, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Task to User Assignments
     * Lists the Users assigned to the Task, together with the budget and recording settings of each assignment.
     * <p><b>200</b> - Page of Task to User Assignments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;TaskToUserAssignmentsPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TaskToUserAssignmentsPage> fetchTaskToUserAssignmentsWithHttpInfo(String taskId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TaskToUserAssignmentsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToUserAssignmentsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchTaskToUserAssignmentsRequestCreation(taskId, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Task to User Assignments
     * Lists the Users assigned to the Task, together with the budget and recording settings of each assignment.
     * <p><b>200</b> - Page of Task to User Assignments.
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
    public ResponseSpec fetchTaskToUserAssignmentsWithResponseSpec(String taskId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TaskToUserAssignmentsSortColumn sortBy) throws RestClientResponseException {
        return fetchTaskToUserAssignmentsRequestCreation(taskId, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * Get a Task to User Assignment
     * Returns the assignment of a single User to the Task.
     * <p><b>200</b> - The requested Task to User Assignment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @return TaskToUserAssignment
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getTaskToUserAssignmentRequestCreation(String taskId, String userId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskId' when calling getTaskToUserAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new RestClientResponseException("Missing the required parameter 'userId' when calling getTaskToUserAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("task_id", taskId);
        pathParams.put("user_id", userId);

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

        ParameterizedTypeReference<TaskToUserAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/users/{user_id}", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Task to User Assignment
     * Returns the assignment of a single User to the Task.
     * <p><b>200</b> - The requested Task to User Assignment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @return TaskToUserAssignment
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public TaskToUserAssignment getTaskToUserAssignment(String taskId, String userId) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToUserAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTaskToUserAssignmentRequestCreation(taskId, userId).body(localVarReturnType);
    }

    /**
     * Get a Task to User Assignment
     * Returns the assignment of a single User to the Task.
     * <p><b>200</b> - The requested Task to User Assignment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @return ResponseEntity&lt;TaskToUserAssignment&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TaskToUserAssignment> getTaskToUserAssignmentWithHttpInfo(String taskId, String userId) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToUserAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTaskToUserAssignmentRequestCreation(taskId, userId).toEntity(localVarReturnType);
    }

    /**
     * Get a Task to User Assignment
     * Returns the assignment of a single User to the Task.
     * <p><b>200</b> - The requested Task to User Assignment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getTaskToUserAssignmentWithResponseSpec(String taskId, String userId) throws RestClientResponseException {
        return getTaskToUserAssignmentRequestCreation(taskId, userId);
    }

    /**
     * Create or update a Task to User Assignment
     * Assigns the User to the Task, or updates the existing assignment. Returns 201 when the assignment is created and 200 when it already existed. On update, only the properties present in the request body change.
     * <p><b>200</b> - The updated Task to User Assignment.
     * <p><b>201</b> - The created Task to User Assignment.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @param taskToUserAssignmentUpsert Task to User Assignment entity
     * @return TaskToUserAssignment
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec upsertTaskToUserAssignmentRequestCreation(String taskId, String userId, TaskToUserAssignmentUpsert taskToUserAssignmentUpsert) throws RestClientResponseException {
        Object postBody = taskToUserAssignmentUpsert;
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskId' when calling upsertTaskToUserAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new RestClientResponseException("Missing the required parameter 'userId' when calling upsertTaskToUserAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'taskToUserAssignmentUpsert' is set
        if (taskToUserAssignmentUpsert == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskToUserAssignmentUpsert' when calling upsertTaskToUserAssignment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("task_id", taskId);
        pathParams.put("user_id", userId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<>();
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

        ParameterizedTypeReference<TaskToUserAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/users/{user_id}", HttpMethod.PUT, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create or update a Task to User Assignment
     * Assigns the User to the Task, or updates the existing assignment. Returns 201 when the assignment is created and 200 when it already existed. On update, only the properties present in the request body change.
     * <p><b>200</b> - The updated Task to User Assignment.
     * <p><b>201</b> - The created Task to User Assignment.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @param taskToUserAssignmentUpsert Task to User Assignment entity
     * @return TaskToUserAssignment
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public TaskToUserAssignment upsertTaskToUserAssignment(String taskId, String userId, TaskToUserAssignmentUpsert taskToUserAssignmentUpsert) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToUserAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return upsertTaskToUserAssignmentRequestCreation(taskId, userId, taskToUserAssignmentUpsert).body(localVarReturnType);
    }

    /**
     * Create or update a Task to User Assignment
     * Assigns the User to the Task, or updates the existing assignment. Returns 201 when the assignment is created and 200 when it already existed. On update, only the properties present in the request body change.
     * <p><b>200</b> - The updated Task to User Assignment.
     * <p><b>201</b> - The created Task to User Assignment.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @param taskToUserAssignmentUpsert Task to User Assignment entity
     * @return ResponseEntity&lt;TaskToUserAssignment&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TaskToUserAssignment> upsertTaskToUserAssignmentWithHttpInfo(String taskId, String userId, TaskToUserAssignmentUpsert taskToUserAssignmentUpsert) throws RestClientResponseException {
        ParameterizedTypeReference<TaskToUserAssignment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return upsertTaskToUserAssignmentRequestCreation(taskId, userId, taskToUserAssignmentUpsert).toEntity(localVarReturnType);
    }

    /**
     * Create or update a Task to User Assignment
     * Assigns the User to the Task, or updates the existing assignment. Returns 201 when the assignment is created and 200 when it already existed. On update, only the properties present in the request body change.
     * <p><b>200</b> - The updated Task to User Assignment.
     * <p><b>201</b> - The created Task to User Assignment.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskId ID of the Task.
     * @param userId ID of the User.
     * @param taskToUserAssignmentUpsert Task to User Assignment entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec upsertTaskToUserAssignmentWithResponseSpec(String taskId, String userId, TaskToUserAssignmentUpsert taskToUserAssignmentUpsert) throws RestClientResponseException {
        return upsertTaskToUserAssignmentRequestCreation(taskId, userId, taskToUserAssignmentUpsert);
    }
}
