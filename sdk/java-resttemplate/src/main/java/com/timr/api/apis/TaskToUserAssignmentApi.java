package com.timr.api.apis;

import com.timr.api.ApiClient;
import com.timr.api.BaseApi;

import com.timr.api.models.Error;
import com.timr.api.models.SortDirection;
import com.timr.api.models.TaskToUserAssignment;
import com.timr.api.models.TaskToUserAssignmentUpsert;
import com.timr.api.models.TaskToUserAssignmentsPage;
import com.timr.api.models.TaskToUserAssignmentsSortColumn;
import java.net.URI;

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
@Component("com.timr.api.apis.TaskToUserAssignmentApi")
public class TaskToUserAssignmentApi extends BaseApi {

    public TaskToUserAssignmentApi() {
        super(new ApiClient());
    }

    @Autowired
    public TaskToUserAssignmentApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Delete a Task to User Assignment
     * Removes the User&#39;s assignment to the Task.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param taskId ID of the Task. (required)
     * @param userId ID of the User. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteTaskToUserAssignment(@jakarta.annotation.Nonnull String taskId, @jakarta.annotation.Nonnull String userId) throws RestClientException {
        deleteTaskToUserAssignmentWithHttpInfo(taskId, userId);
    }

    /**
     * Delete a Task to User Assignment
     * Removes the User&#39;s assignment to the Task.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param taskId ID of the Task. (required)
     * @param userId ID of the User. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTaskToUserAssignmentWithHttpInfo(@jakarta.annotation.Nonnull String taskId, @jakarta.annotation.Nonnull String userId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'taskId' when calling deleteTaskToUserAssignment");
        }
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling deleteTaskToUserAssignment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("task_id", taskId);
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
        return apiClient.invokeAPI("/tasks/{task_id}/users/{user_id}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List Task to User Assignments
     * Lists the Users assigned to the Task, together with the budget and recording settings of each assignment.
     * <p><b>200</b> - Page of Task to User Assignments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task. (required)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to user_name)
     * @return TaskToUserAssignmentsPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TaskToUserAssignmentsPage fetchTaskToUserAssignments(@jakarta.annotation.Nonnull String taskId, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable TaskToUserAssignmentsSortColumn sortBy) throws RestClientException {
        return fetchTaskToUserAssignmentsWithHttpInfo(taskId, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List Task to User Assignments
     * Lists the Users assigned to the Task, together with the budget and recording settings of each assignment.
     * <p><b>200</b> - Page of Task to User Assignments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task. (required)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to user_name)
     * @return ResponseEntity&lt;TaskToUserAssignmentsPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TaskToUserAssignmentsPage> fetchTaskToUserAssignmentsWithHttpInfo(@jakarta.annotation.Nonnull String taskId, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable TaskToUserAssignmentsSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'taskId' when calling fetchTaskToUserAssignments");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("task_id", taskId);

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

        ParameterizedTypeReference<TaskToUserAssignmentsPage> localReturnType = new ParameterizedTypeReference<TaskToUserAssignmentsPage>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/users", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a Task to User Assignment
     * Returns the assignment of a single User to the Task.
     * <p><b>200</b> - The requested Task to User Assignment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task. (required)
     * @param userId ID of the User. (required)
     * @return TaskToUserAssignment
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TaskToUserAssignment getTaskToUserAssignment(@jakarta.annotation.Nonnull String taskId, @jakarta.annotation.Nonnull String userId) throws RestClientException {
        return getTaskToUserAssignmentWithHttpInfo(taskId, userId).getBody();
    }

    /**
     * Get a Task to User Assignment
     * Returns the assignment of a single User to the Task.
     * <p><b>200</b> - The requested Task to User Assignment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task. (required)
     * @param userId ID of the User. (required)
     * @return ResponseEntity&lt;TaskToUserAssignment&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TaskToUserAssignment> getTaskToUserAssignmentWithHttpInfo(@jakarta.annotation.Nonnull String taskId, @jakarta.annotation.Nonnull String userId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'taskId' when calling getTaskToUserAssignment");
        }
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling getTaskToUserAssignment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("task_id", taskId);
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

        ParameterizedTypeReference<TaskToUserAssignment> localReturnType = new ParameterizedTypeReference<TaskToUserAssignment>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/users/{user_id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Create or update a Task to User Assignment
     * Assigns the User to the Task, or updates the existing assignment. Returns 201 when the assignment is created and 200 when it already existed. On update, only the properties present in the request body change.
     * <p><b>200</b> - The updated Task to User Assignment.
     * <p><b>201</b> - The created Task to User Assignment.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskId ID of the Task. (required)
     * @param userId ID of the User. (required)
     * @param taskToUserAssignmentUpsert Task to User Assignment entity (required)
     * @return TaskToUserAssignment
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TaskToUserAssignment upsertTaskToUserAssignment(@jakarta.annotation.Nonnull String taskId, @jakarta.annotation.Nonnull String userId, @jakarta.annotation.Nonnull TaskToUserAssignmentUpsert taskToUserAssignmentUpsert) throws RestClientException {
        return upsertTaskToUserAssignmentWithHttpInfo(taskId, userId, taskToUserAssignmentUpsert).getBody();
    }

    /**
     * Create or update a Task to User Assignment
     * Assigns the User to the Task, or updates the existing assignment. Returns 201 when the assignment is created and 200 when it already existed. On update, only the properties present in the request body change.
     * <p><b>200</b> - The updated Task to User Assignment.
     * <p><b>201</b> - The created Task to User Assignment.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskId ID of the Task. (required)
     * @param userId ID of the User. (required)
     * @param taskToUserAssignmentUpsert Task to User Assignment entity (required)
     * @return ResponseEntity&lt;TaskToUserAssignment&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TaskToUserAssignment> upsertTaskToUserAssignmentWithHttpInfo(@jakarta.annotation.Nonnull String taskId, @jakarta.annotation.Nonnull String userId, @jakarta.annotation.Nonnull TaskToUserAssignmentUpsert taskToUserAssignmentUpsert) throws RestClientException {
        Object localVarPostBody = taskToUserAssignmentUpsert;
        
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'taskId' when calling upsertTaskToUserAssignment");
        }
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling upsertTaskToUserAssignment");
        }
        
        // verify the required parameter 'taskToUserAssignmentUpsert' is set
        if (taskToUserAssignmentUpsert == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'taskToUserAssignmentUpsert' when calling upsertTaskToUserAssignment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("task_id", taskId);
        uriVariables.put("user_id", userId);

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

        ParameterizedTypeReference<TaskToUserAssignment> localReturnType = new ParameterizedTypeReference<TaskToUserAssignment>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/users/{user_id}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
