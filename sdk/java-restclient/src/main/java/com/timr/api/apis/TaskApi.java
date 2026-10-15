package com.timr.api.apis;

import com.timr.api.ApiClient;

import com.timr.api.models.Error;
import java.time.LocalDate;
import org.jspecify.annotations.Nullable;
import com.timr.api.models.SortDirection;
import com.timr.api.models.Task;
import com.timr.api.models.TaskCreate;
import com.timr.api.models.TaskUpdate;
import com.timr.api.models.TasksPage;
import com.timr.api.models.TasksReducedPage;
import com.timr.api.models.TasksSortColumn;
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
public class TaskApi {
    private ApiClient apiClient;

    public TaskApi() {
        this(new ApiClient());
    }

    public TaskApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a Task
     * Creates a Task from the data in the request body.
     * <p><b>201</b> - The created Task.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskCreate Project Time entity
     * @return Task
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createTaskRequestCreation(TaskCreate taskCreate) throws RestClientResponseException {
        Object postBody = taskCreate;
        // verify the required parameter 'taskCreate' is set
        if (taskCreate == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskCreate' when calling createTask", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

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

        ParameterizedTypeReference<Task> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/tasks", HttpMethod.POST, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Task
     * Creates a Task from the data in the request body.
     * <p><b>201</b> - The created Task.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskCreate Project Time entity
     * @return Task
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public Task createTask(TaskCreate taskCreate) throws RestClientResponseException {
        ParameterizedTypeReference<Task> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createTaskRequestCreation(taskCreate).body(localVarReturnType);
    }

    /**
     * Create a Task
     * Creates a Task from the data in the request body.
     * <p><b>201</b> - The created Task.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskCreate Project Time entity
     * @return ResponseEntity&lt;Task&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Task> createTaskWithHttpInfo(TaskCreate taskCreate) throws RestClientResponseException {
        ParameterizedTypeReference<Task> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createTaskRequestCreation(taskCreate).toEntity(localVarReturnType);
    }

    /**
     * Create a Task
     * Creates a Task from the data in the request body.
     * <p><b>201</b> - The created Task.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param taskCreate Project Time entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createTaskWithResponseSpec(TaskCreate taskCreate) throws RestClientResponseException {
        return createTaskRequestCreation(taskCreate);
    }

    /**
     * Delete a Task
     * Deletes the Task together with all its subtasks. A Task that has recorded or running Project Times on itself or any of its subtasks can&#39;t be deleted; the request is answered with 409 and nothing is deleted.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Task.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteTaskRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling deleteTask", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

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
        return apiClient.invokeAPI("/tasks/{id}", HttpMethod.DELETE, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Task
     * Deletes the Task together with all its subtasks. A Task that has recorded or running Project Times on itself or any of its subtasks can&#39;t be deleted; the request is answered with 409 and nothing is deleted.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Task.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void deleteTask(String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        deleteTaskRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Delete a Task
     * Deletes the Task together with all its subtasks. A Task that has recorded or running Project Times on itself or any of its subtasks can&#39;t be deleted; the request is answered with 409 and nothing is deleted.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Task.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTaskWithHttpInfo(String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return deleteTaskRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Delete a Task
     * Deletes the Task together with all its subtasks. A Task that has recorded or running Project Times on itself or any of its subtasks can&#39;t be deleted; the request is answered with 409 and nothing is deleted.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Task.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteTaskWithResponseSpec(String id) throws RestClientResponseException {
        return deleteTaskRequestCreation(id);
    }

    /**
     * List Tasks
     * Lists the Tasks the authenticated user or API token can access.
     * <p><b>200</b> - Page of Tasks.
     * <p><b>400</b> - Bad Request
     * @param parentTaskId Only return Tasks whose parent is the Task with this ID.
     * @param traverseTaskTree Include Tasks from the whole subtree (true) or only direct children (false).
     * @param name Only return Users whose name contains this text.
     * @param bookable Only return entries that are billable (true) or not billable (false).
     * @param billable Only return entries that are billable (true) or not billable (false).
     * @param activeAt Only return Tasks that are active on this day.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return TasksPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchTasksRequestCreation(@Nullable String parentTaskId, @Nullable Boolean traverseTaskTree, @Nullable String name, @Nullable Boolean bookable, @Nullable Boolean billable, @Nullable LocalDate activeAt, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TasksSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

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
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<TasksPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/tasks", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Tasks
     * Lists the Tasks the authenticated user or API token can access.
     * <p><b>200</b> - Page of Tasks.
     * <p><b>400</b> - Bad Request
     * @param parentTaskId Only return Tasks whose parent is the Task with this ID.
     * @param traverseTaskTree Include Tasks from the whole subtree (true) or only direct children (false).
     * @param name Only return Users whose name contains this text.
     * @param bookable Only return entries that are billable (true) or not billable (false).
     * @param billable Only return entries that are billable (true) or not billable (false).
     * @param activeAt Only return Tasks that are active on this day.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return TasksPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public TasksPage fetchTasks(@Nullable String parentTaskId, @Nullable Boolean traverseTaskTree, @Nullable String name, @Nullable Boolean bookable, @Nullable Boolean billable, @Nullable LocalDate activeAt, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TasksSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<TasksPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchTasksRequestCreation(parentTaskId, traverseTaskTree, name, bookable, billable, activeAt, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Tasks
     * Lists the Tasks the authenticated user or API token can access.
     * <p><b>200</b> - Page of Tasks.
     * <p><b>400</b> - Bad Request
     * @param parentTaskId Only return Tasks whose parent is the Task with this ID.
     * @param traverseTaskTree Include Tasks from the whole subtree (true) or only direct children (false).
     * @param name Only return Users whose name contains this text.
     * @param bookable Only return entries that are billable (true) or not billable (false).
     * @param billable Only return entries that are billable (true) or not billable (false).
     * @param activeAt Only return Tasks that are active on this day.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;TasksPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TasksPage> fetchTasksWithHttpInfo(@Nullable String parentTaskId, @Nullable Boolean traverseTaskTree, @Nullable String name, @Nullable Boolean bookable, @Nullable Boolean billable, @Nullable LocalDate activeAt, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TasksSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<TasksPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchTasksRequestCreation(parentTaskId, traverseTaskTree, name, bookable, billable, activeAt, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Tasks
     * Lists the Tasks the authenticated user or API token can access.
     * <p><b>200</b> - Page of Tasks.
     * <p><b>400</b> - Bad Request
     * @param parentTaskId Only return Tasks whose parent is the Task with this ID.
     * @param traverseTaskTree Include Tasks from the whole subtree (true) or only direct children (false).
     * @param name Only return Users whose name contains this text.
     * @param bookable Only return entries that are billable (true) or not billable (false).
     * @param billable Only return entries that are billable (true) or not billable (false).
     * @param activeAt Only return Tasks that are active on this day.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchTasksWithResponseSpec(@Nullable String parentTaskId, @Nullable Boolean traverseTaskTree, @Nullable String name, @Nullable Boolean bookable, @Nullable Boolean billable, @Nullable LocalDate activeAt, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TasksSortColumn sortBy) throws RestClientResponseException {
        return fetchTasksRequestCreation(parentTaskId, traverseTaskTree, name, bookable, billable, activeAt, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * List a User&#39;s Tasks
     * Lists the Tasks the User is assigned to and may record on.
     * <p><b>200</b> - Page of Tasks the User is assigned to.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User.
     * @param parentTaskId Only return Tasks whose parent is the Task with this ID.
     * @param traverseTaskTree Include Tasks from the whole subtree (true) or only direct children (false).
     * @param name Only return Users whose name contains this text.
     * @param bookable Only return entries that are billable (true) or not billable (false).
     * @param billable Only return entries that are billable (true) or not billable (false).
     * @param activeAt Only return Tasks that are active on this day.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return TasksReducedPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchUserTasksRequestCreation(String id, @Nullable String parentTaskId, @Nullable Boolean traverseTaskTree, @Nullable String name, @Nullable Boolean bookable, @Nullable Boolean billable, @Nullable LocalDate activeAt, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TasksSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling fetchUserTasks", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

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
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<TasksReducedPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/users/{id}/tasks", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List a User&#39;s Tasks
     * Lists the Tasks the User is assigned to and may record on.
     * <p><b>200</b> - Page of Tasks the User is assigned to.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User.
     * @param parentTaskId Only return Tasks whose parent is the Task with this ID.
     * @param traverseTaskTree Include Tasks from the whole subtree (true) or only direct children (false).
     * @param name Only return Users whose name contains this text.
     * @param bookable Only return entries that are billable (true) or not billable (false).
     * @param billable Only return entries that are billable (true) or not billable (false).
     * @param activeAt Only return Tasks that are active on this day.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return TasksReducedPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public TasksReducedPage fetchUserTasks(String id, @Nullable String parentTaskId, @Nullable Boolean traverseTaskTree, @Nullable String name, @Nullable Boolean bookable, @Nullable Boolean billable, @Nullable LocalDate activeAt, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TasksSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<TasksReducedPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchUserTasksRequestCreation(id, parentTaskId, traverseTaskTree, name, bookable, billable, activeAt, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List a User&#39;s Tasks
     * Lists the Tasks the User is assigned to and may record on.
     * <p><b>200</b> - Page of Tasks the User is assigned to.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User.
     * @param parentTaskId Only return Tasks whose parent is the Task with this ID.
     * @param traverseTaskTree Include Tasks from the whole subtree (true) or only direct children (false).
     * @param name Only return Users whose name contains this text.
     * @param bookable Only return entries that are billable (true) or not billable (false).
     * @param billable Only return entries that are billable (true) or not billable (false).
     * @param activeAt Only return Tasks that are active on this day.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;TasksReducedPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TasksReducedPage> fetchUserTasksWithHttpInfo(String id, @Nullable String parentTaskId, @Nullable Boolean traverseTaskTree, @Nullable String name, @Nullable Boolean bookable, @Nullable Boolean billable, @Nullable LocalDate activeAt, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TasksSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<TasksReducedPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchUserTasksRequestCreation(id, parentTaskId, traverseTaskTree, name, bookable, billable, activeAt, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List a User&#39;s Tasks
     * Lists the Tasks the User is assigned to and may record on.
     * <p><b>200</b> - Page of Tasks the User is assigned to.
     * <p><b>400</b> - Bad Request
     * @param id ID of the User.
     * @param parentTaskId Only return Tasks whose parent is the Task with this ID.
     * @param traverseTaskTree Include Tasks from the whole subtree (true) or only direct children (false).
     * @param name Only return Users whose name contains this text.
     * @param bookable Only return entries that are billable (true) or not billable (false).
     * @param billable Only return entries that are billable (true) or not billable (false).
     * @param activeAt Only return Tasks that are active on this day.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchUserTasksWithResponseSpec(String id, @Nullable String parentTaskId, @Nullable Boolean traverseTaskTree, @Nullable String name, @Nullable Boolean bookable, @Nullable Boolean billable, @Nullable LocalDate activeAt, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable TasksSortColumn sortBy) throws RestClientResponseException {
        return fetchUserTasksRequestCreation(id, parentTaskId, traverseTaskTree, name, bookable, billable, activeAt, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * Get a Task
     * Returns a single Task by its ID.
     * <p><b>200</b> - The requested Task.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Task.
     * @return Task
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getTaskRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling getTask", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

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

        ParameterizedTypeReference<Task> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/tasks/{id}", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Task
     * Returns a single Task by its ID.
     * <p><b>200</b> - The requested Task.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Task.
     * @return Task
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public Task getTask(String id) throws RestClientResponseException {
        ParameterizedTypeReference<Task> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTaskRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Get a Task
     * Returns a single Task by its ID.
     * <p><b>200</b> - The requested Task.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Task.
     * @return ResponseEntity&lt;Task&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Task> getTaskWithHttpInfo(String id) throws RestClientResponseException {
        ParameterizedTypeReference<Task> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTaskRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get a Task
     * Returns a single Task by its ID.
     * <p><b>200</b> - The requested Task.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Task.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getTaskWithResponseSpec(String id) throws RestClientResponseException {
        return getTaskRequestCreation(id);
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
     * @param id ID of the Task.
     * @param taskUpdate Task entity
     * @return Task
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateTaskRequestCreation(String id, TaskUpdate taskUpdate) throws RestClientResponseException {
        Object postBody = taskUpdate;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling updateTask", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'taskUpdate' is set
        if (taskUpdate == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskUpdate' when calling updateTask", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

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

        ParameterizedTypeReference<Task> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/tasks/{id}", HttpMethod.PATCH, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
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
     * @param id ID of the Task.
     * @param taskUpdate Task entity
     * @return Task
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public Task updateTask(String id, TaskUpdate taskUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<Task> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateTaskRequestCreation(id, taskUpdate).body(localVarReturnType);
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
     * @param id ID of the Task.
     * @param taskUpdate Task entity
     * @return ResponseEntity&lt;Task&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Task> updateTaskWithHttpInfo(String id, TaskUpdate taskUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<Task> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateTaskRequestCreation(id, taskUpdate).toEntity(localVarReturnType);
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
     * @param id ID of the Task.
     * @param taskUpdate Task entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateTaskWithResponseSpec(String id, TaskUpdate taskUpdate) throws RestClientResponseException {
        return updateTaskRequestCreation(id, taskUpdate);
    }
}
