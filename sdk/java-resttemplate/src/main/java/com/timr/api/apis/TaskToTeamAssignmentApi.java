package com.timr.api.apis;

import com.timr.api.ApiClient;
import com.timr.api.BaseApi;

import com.timr.api.models.Error;
import com.timr.api.models.SortDirection;
import com.timr.api.models.TaskToTeamAssignment;
import com.timr.api.models.TaskToTeamAssignmentsPage;
import com.timr.api.models.TaskToTeamAssignmentsSortColumn;
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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.22.0")
@Component("com.timr.api.apis.TaskToTeamAssignmentApi")
public class TaskToTeamAssignmentApi extends BaseApi {

    public TaskToTeamAssignmentApi() {
        super(new ApiClient());
    }

    @Autowired
    public TaskToTeamAssignmentApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Create a Task to Team Assignment
     * Assigns the Team to the Task. Returns 201 when the assignment is created and 200 when it already existed.
     * <p><b>200</b> - The updated Task to Team Assignment.
     * <p><b>201</b> - The created Task to Team Assignment.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskId ID of the Task. (required)
     * @param teamId ID of the Team. (required)
     * @return TaskToTeamAssignment
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TaskToTeamAssignment createTaskToTeamAssignment(String taskId, String teamId) throws RestClientException {
        return createTaskToTeamAssignmentWithHttpInfo(taskId, teamId).getBody();
    }

    /**
     * Create a Task to Team Assignment
     * Assigns the Team to the Task. Returns 201 when the assignment is created and 200 when it already existed.
     * <p><b>200</b> - The updated Task to Team Assignment.
     * <p><b>201</b> - The created Task to Team Assignment.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskId ID of the Task. (required)
     * @param teamId ID of the Team. (required)
     * @return ResponseEntity&lt;TaskToTeamAssignment&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TaskToTeamAssignment> createTaskToTeamAssignmentWithHttpInfo(String taskId, String teamId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'taskId' when calling createTaskToTeamAssignment");
        }
        
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'teamId' when calling createTaskToTeamAssignment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("task_id", taskId);
        uriVariables.put("team_id", teamId);

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

        ParameterizedTypeReference<TaskToTeamAssignment> localReturnType = new ParameterizedTypeReference<TaskToTeamAssignment>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/teams/{team_id}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a Task to Team Assignment
     * Removes the Team&#39;s assignment to the Task.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param taskId ID of the Task. (required)
     * @param teamId ID of the Team. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteTaskToTeamAssignment(String taskId, String teamId) throws RestClientException {
        deleteTaskToTeamAssignmentWithHttpInfo(taskId, teamId);
    }

    /**
     * Delete a Task to Team Assignment
     * Removes the Team&#39;s assignment to the Task.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param taskId ID of the Task. (required)
     * @param teamId ID of the Team. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTaskToTeamAssignmentWithHttpInfo(String taskId, String teamId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'taskId' when calling deleteTaskToTeamAssignment");
        }
        
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'teamId' when calling deleteTaskToTeamAssignment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("task_id", taskId);
        uriVariables.put("team_id", teamId);

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
        return apiClient.invokeAPI("/tasks/{task_id}/teams/{team_id}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List Task to Team Assignments
     * Lists the Teams assigned to the Task.
     * <p><b>200</b> - Page of Task to Team Assignments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task. (required)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to team_name)
     * @return TaskToTeamAssignmentsPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TaskToTeamAssignmentsPage fetchTaskToTeamAssignments(String taskId, String pageToken, Integer limit, SortDirection sortDirection, TaskToTeamAssignmentsSortColumn sortBy) throws RestClientException {
        return fetchTaskToTeamAssignmentsWithHttpInfo(taskId, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List Task to Team Assignments
     * Lists the Teams assigned to the Task.
     * <p><b>200</b> - Page of Task to Team Assignments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task. (required)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to team_name)
     * @return ResponseEntity&lt;TaskToTeamAssignmentsPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TaskToTeamAssignmentsPage> fetchTaskToTeamAssignmentsWithHttpInfo(String taskId, String pageToken, Integer limit, SortDirection sortDirection, TaskToTeamAssignmentsSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'taskId' when calling fetchTaskToTeamAssignments");
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

        ParameterizedTypeReference<TaskToTeamAssignmentsPage> localReturnType = new ParameterizedTypeReference<TaskToTeamAssignmentsPage>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/teams", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a Task to Team Assignment
     * Returns the assignment of a single Team to the Task.
     * <p><b>200</b> - The requested Task to Team Assignment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task. (required)
     * @param teamId ID of the Team. (required)
     * @return TaskToTeamAssignment
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TaskToTeamAssignment getTaskToTeamAssignment(String taskId, String teamId) throws RestClientException {
        return getTaskToTeamAssignmentWithHttpInfo(taskId, teamId).getBody();
    }

    /**
     * Get a Task to Team Assignment
     * Returns the assignment of a single Team to the Task.
     * <p><b>200</b> - The requested Task to Team Assignment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task. (required)
     * @param teamId ID of the Team. (required)
     * @return ResponseEntity&lt;TaskToTeamAssignment&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TaskToTeamAssignment> getTaskToTeamAssignmentWithHttpInfo(String taskId, String teamId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'taskId' when calling getTaskToTeamAssignment");
        }
        
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'teamId' when calling getTaskToTeamAssignment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("task_id", taskId);
        uriVariables.put("team_id", teamId);

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

        ParameterizedTypeReference<TaskToTeamAssignment> localReturnType = new ParameterizedTypeReference<TaskToTeamAssignment>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/teams/{team_id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        return apiClient.invokeAPI(localVarPath, method, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, returnType);
    }
}
