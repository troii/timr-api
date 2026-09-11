package com.timr.api.apis;

import com.timr.api.ApiClient;
import com.timr.api.BaseApi;

import com.timr.api.models.Error;
import java.time.LocalDate;
import com.timr.api.models.SortDirection;
import com.timr.api.models.Task;
import com.timr.api.models.TaskCreate;
import com.timr.api.models.TaskUpdate;
import com.timr.api.models.TasksPage;
import com.timr.api.models.TasksReducedPage;
import com.timr.api.models.TasksSortColumn;
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
@Component("com.timr.api.apis.TaskApi")
public class TaskApi extends BaseApi {

    public TaskApi() {
        super(new ApiClient());
    }

    @Autowired
    public TaskApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Create a Task
     * Creates a Task from the data in the request body.
     * <p><b>201</b> - The created Task.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskCreate Project Time entity (required)
     * @return Task
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Task createTask(TaskCreate taskCreate) throws RestClientException {
        return createTaskWithHttpInfo(taskCreate).getBody();
    }

    /**
     * Create a Task
     * Creates a Task from the data in the request body.
     * <p><b>201</b> - The created Task.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskCreate Project Time entity (required)
     * @return ResponseEntity&lt;Task&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Task> createTaskWithHttpInfo(TaskCreate taskCreate) throws RestClientException {
        Object localVarPostBody = taskCreate;
        
        // verify the required parameter 'taskCreate' is set
        if (taskCreate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'taskCreate' when calling createTask");
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

        ParameterizedTypeReference<Task> localReturnType = new ParameterizedTypeReference<Task>() {};
        return apiClient.invokeAPI("/tasks", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List Tasks
     * Lists the Tasks the authenticated user or API token can access.
     * <p><b>200</b> - Page of Tasks.
     * <p><b>400</b> - Bad Request
     * @param parentTaskId Only return Tasks whose parent is the Task with this ID. (optional)
     * @param traverseTaskTree Include Tasks from the whole subtree (true) or only direct children (false). (optional, default to true)
     * @param name Only return Users whose name contains this text. (optional)
     * @param bookable Only return entries that are billable (true) or not billable (false). (optional)
     * @param billable Only return entries that are billable (true) or not billable (false). (optional)
     * @param activeAt Only return Tasks that are active on this day. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to breadcrumbs)
     * @return TasksPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TasksPage fetchTasks(String parentTaskId, Boolean traverseTaskTree, String name, Boolean bookable, Boolean billable, LocalDate activeAt, String pageToken, Integer limit, SortDirection sortDirection, TasksSortColumn sortBy) throws RestClientException {
        return fetchTasksWithHttpInfo(parentTaskId, traverseTaskTree, name, bookable, billable, activeAt, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List Tasks
     * Lists the Tasks the authenticated user or API token can access.
     * <p><b>200</b> - Page of Tasks.
     * <p><b>400</b> - Bad Request
     * @param parentTaskId Only return Tasks whose parent is the Task with this ID. (optional)
     * @param traverseTaskTree Include Tasks from the whole subtree (true) or only direct children (false). (optional, default to true)
     * @param name Only return Users whose name contains this text. (optional)
     * @param bookable Only return entries that are billable (true) or not billable (false). (optional)
     * @param billable Only return entries that are billable (true) or not billable (false). (optional)
     * @param activeAt Only return Tasks that are active on this day. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to breadcrumbs)
     * @return ResponseEntity&lt;TasksPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TasksPage> fetchTasksWithHttpInfo(String parentTaskId, Boolean traverseTaskTree, String name, Boolean bookable, Boolean billable, LocalDate activeAt, String pageToken, Integer limit, SortDirection sortDirection, TasksSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "parent_task_id", parentTaskId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "traverse_task_tree", traverseTaskTree));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "bookable", bookable));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "billable", billable));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "active_at", activeAt));
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

        ParameterizedTypeReference<TasksPage> localReturnType = new ParameterizedTypeReference<TasksPage>() {};
        return apiClient.invokeAPI("/tasks", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List a User&#39;s Tasks
     * Lists the Tasks the User is assigned to and may record on.
     * <p><b>200</b> - Page of Tasks the User is assigned to.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User. (required)
     * @param parentTaskId Only return Tasks whose parent is the Task with this ID. (optional)
     * @param traverseTaskTree Include Tasks from the whole subtree (true) or only direct children (false). (optional, default to true)
     * @param name Only return Users whose name contains this text. (optional)
     * @param bookable Only return entries that are billable (true) or not billable (false). (optional)
     * @param billable Only return entries that are billable (true) or not billable (false). (optional)
     * @param activeAt Only return Tasks that are active on this day. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to breadcrumbs)
     * @return TasksReducedPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TasksReducedPage fetchUserTasks(String id, String parentTaskId, Boolean traverseTaskTree, String name, Boolean bookable, Boolean billable, LocalDate activeAt, String pageToken, Integer limit, SortDirection sortDirection, TasksSortColumn sortBy) throws RestClientException {
        return fetchUserTasksWithHttpInfo(id, parentTaskId, traverseTaskTree, name, bookable, billable, activeAt, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List a User&#39;s Tasks
     * Lists the Tasks the User is assigned to and may record on.
     * <p><b>200</b> - Page of Tasks the User is assigned to.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User. (required)
     * @param parentTaskId Only return Tasks whose parent is the Task with this ID. (optional)
     * @param traverseTaskTree Include Tasks from the whole subtree (true) or only direct children (false). (optional, default to true)
     * @param name Only return Users whose name contains this text. (optional)
     * @param bookable Only return entries that are billable (true) or not billable (false). (optional)
     * @param billable Only return entries that are billable (true) or not billable (false). (optional)
     * @param activeAt Only return Tasks that are active on this day. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to breadcrumbs)
     * @return ResponseEntity&lt;TasksReducedPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TasksReducedPage> fetchUserTasksWithHttpInfo(String id, String parentTaskId, Boolean traverseTaskTree, String name, Boolean bookable, Boolean billable, LocalDate activeAt, String pageToken, Integer limit, SortDirection sortDirection, TasksSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling fetchUserTasks");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "parent_task_id", parentTaskId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "traverse_task_tree", traverseTaskTree));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "bookable", bookable));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "billable", billable));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "active_at", activeAt));
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

        ParameterizedTypeReference<TasksReducedPage> localReturnType = new ParameterizedTypeReference<TasksReducedPage>() {};
        return apiClient.invokeAPI("/users/{id}/tasks", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a Task
     * Returns a single Task by its ID.
     * <p><b>200</b> - The requested Task.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Task. (required)
     * @return Task
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Task getTask(String id) throws RestClientException {
        return getTaskWithHttpInfo(id).getBody();
    }

    /**
     * Get a Task
     * Returns a single Task by its ID.
     * <p><b>200</b> - The requested Task.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Task. (required)
     * @return ResponseEntity&lt;Task&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Task> getTaskWithHttpInfo(String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getTask");
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

        ParameterizedTypeReference<Task> localReturnType = new ParameterizedTypeReference<Task>() {};
        return apiClient.invokeAPI("/tasks/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update a Task
     * Updates the Task with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Task.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Task. (required)
     * @param taskUpdate Task entity (required)
     * @return Task
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Task updateTask(String id, TaskUpdate taskUpdate) throws RestClientException {
        return updateTaskWithHttpInfo(id, taskUpdate).getBody();
    }

    /**
     * Update a Task
     * Updates the Task with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Task.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Task. (required)
     * @param taskUpdate Task entity (required)
     * @return ResponseEntity&lt;Task&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Task> updateTaskWithHttpInfo(String id, TaskUpdate taskUpdate) throws RestClientException {
        Object localVarPostBody = taskUpdate;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateTask");
        }
        
        // verify the required parameter 'taskUpdate' is set
        if (taskUpdate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'taskUpdate' when calling updateTask");
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

        ParameterizedTypeReference<Task> localReturnType = new ParameterizedTypeReference<Task>() {};
        return apiClient.invokeAPI("/tasks/{id}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
