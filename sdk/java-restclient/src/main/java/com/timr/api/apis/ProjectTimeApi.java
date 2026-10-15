package com.timr.api.apis;

import com.timr.api.ApiClient;

import com.timr.api.models.DeletedEntrySortColumn;
import com.timr.api.models.DeletedEntryWithMetadataPage;
import com.timr.api.models.Error;
import java.time.LocalDate;
import org.jspecify.annotations.Nullable;
import java.time.OffsetDateTime;
import com.timr.api.models.ProjectTime;
import com.timr.api.models.ProjectTimeCreate;
import com.timr.api.models.ProjectTimeStatus;
import com.timr.api.models.ProjectTimeUpdate;
import com.timr.api.models.ProjectTimesPage;
import com.timr.api.models.ProjectTimesSortColumn;
import com.timr.api.models.SortDirection;
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
public class ProjectTimeApi {
    private ApiClient apiClient;

    public ProjectTimeApi() {
        this(new ApiClient());
    }

    public ProjectTimeApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a Project Time
     * Creates a Project Time from the data in the request body.
     * <p><b>201</b> - The created Project Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param projectTimeCreate Project Time entity
     * @return ProjectTime
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createProjectTimeRequestCreation(ProjectTimeCreate projectTimeCreate) throws RestClientResponseException {
        Object postBody = projectTimeCreate;
        // verify the required parameter 'projectTimeCreate' is set
        if (projectTimeCreate == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectTimeCreate' when calling createProjectTime", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<ProjectTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/project-times", HttpMethod.POST, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Project Time
     * Creates a Project Time from the data in the request body.
     * <p><b>201</b> - The created Project Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param projectTimeCreate Project Time entity
     * @return ProjectTime
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ProjectTime createProjectTime(ProjectTimeCreate projectTimeCreate) throws RestClientResponseException {
        ParameterizedTypeReference<ProjectTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createProjectTimeRequestCreation(projectTimeCreate).body(localVarReturnType);
    }

    /**
     * Create a Project Time
     * Creates a Project Time from the data in the request body.
     * <p><b>201</b> - The created Project Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param projectTimeCreate Project Time entity
     * @return ResponseEntity&lt;ProjectTime&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProjectTime> createProjectTimeWithHttpInfo(ProjectTimeCreate projectTimeCreate) throws RestClientResponseException {
        ParameterizedTypeReference<ProjectTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createProjectTimeRequestCreation(projectTimeCreate).toEntity(localVarReturnType);
    }

    /**
     * Create a Project Time
     * Creates a Project Time from the data in the request body.
     * <p><b>201</b> - The created Project Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param projectTimeCreate Project Time entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createProjectTimeWithResponseSpec(ProjectTimeCreate projectTimeCreate) throws RestClientResponseException {
        return createProjectTimeRequestCreation(projectTimeCreate);
    }

    /**
     * Delete a Project Time
     * Deletes the Project Time.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Project Time.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteProjectTimeRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling deleteProjectTime", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        return apiClient.invokeAPI("/project-times/{id}", HttpMethod.DELETE, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Project Time
     * Deletes the Project Time.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Project Time.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void deleteProjectTime(String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        deleteProjectTimeRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Delete a Project Time
     * Deletes the Project Time.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Project Time.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteProjectTimeWithHttpInfo(String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return deleteProjectTimeRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Delete a Project Time
     * Deletes the Project Time.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Project Time.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteProjectTimeWithResponseSpec(String id) throws RestClientResponseException {
        return deleteProjectTimeRequestCreation(id);
    }

    /**
     * List deleted Project Times
     * Lists Project Times that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Project Times.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return DeletedEntryWithMetadataPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchDeletedProjectTimesRequestCreation(@Nullable OffsetDateTime lastModifiedAfter, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable DeletedEntrySortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "last_modified_after", lastModifiedAfter));
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

        ParameterizedTypeReference<DeletedEntryWithMetadataPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/project-times:deleted", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List deleted Project Times
     * Lists Project Times that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Project Times.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return DeletedEntryWithMetadataPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public DeletedEntryWithMetadataPage fetchDeletedProjectTimes(@Nullable OffsetDateTime lastModifiedAfter, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable DeletedEntrySortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<DeletedEntryWithMetadataPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchDeletedProjectTimesRequestCreation(lastModifiedAfter, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List deleted Project Times
     * Lists Project Times that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Project Times.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;DeletedEntryWithMetadataPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DeletedEntryWithMetadataPage> fetchDeletedProjectTimesWithHttpInfo(@Nullable OffsetDateTime lastModifiedAfter, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable DeletedEntrySortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<DeletedEntryWithMetadataPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchDeletedProjectTimesRequestCreation(lastModifiedAfter, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List deleted Project Times
     * Lists Project Times that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Project Times.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchDeletedProjectTimesWithResponseSpec(@Nullable OffsetDateTime lastModifiedAfter, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable DeletedEntrySortColumn sortBy) throws RestClientResponseException {
        return fetchDeletedProjectTimesRequestCreation(lastModifiedAfter, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * List Project Times
     * Lists the Project Times the authenticated user or API token can access.
     * <p><b>200</b> - Page of Project Times.
     * <p><b>400</b> - Bad Request
     * @param notes Only return entries whose notes contain this text.
     * @param startFrom Only return entries starting on or after this day.
     * @param startTo Only return entries starting on or before this day.
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param task Only return entries recorded on the Task with this ID.
     * @param traverseTaskTree Include entries recorded on the whole subtree of the given Task (true) or only on the Task itself (false).
     * @param billable Only return entries that are billable (true) or not billable (false).
     * @param statuses Only return entries in one of these statuses.
     * @param users Only return entries belonging to these users.
     * @param changed Only return entries that were changed by the user (true) or left unchanged (false).
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ProjectTimesPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchProjectTimesRequestCreation(@Nullable String notes, @Nullable LocalDate startFrom, @Nullable LocalDate startTo, @Nullable OffsetDateTime lastModifiedAfter, @Nullable String task, @Nullable Boolean traverseTaskTree, @Nullable Boolean billable, @Nullable List<ProjectTimeStatus> statuses, @Nullable List<String> users, @Nullable Boolean changed, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable ProjectTimesSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "notes", notes));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "start_from", startFrom));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "start_to", startTo));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "last_modified_after", lastModifiedAfter));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "task", task));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "traverse_task_tree", traverseTaskTree));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "billable", billable));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "statuses", statuses));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "users", users));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "changed", changed));
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

        ParameterizedTypeReference<ProjectTimesPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/project-times", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Project Times
     * Lists the Project Times the authenticated user or API token can access.
     * <p><b>200</b> - Page of Project Times.
     * <p><b>400</b> - Bad Request
     * @param notes Only return entries whose notes contain this text.
     * @param startFrom Only return entries starting on or after this day.
     * @param startTo Only return entries starting on or before this day.
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param task Only return entries recorded on the Task with this ID.
     * @param traverseTaskTree Include entries recorded on the whole subtree of the given Task (true) or only on the Task itself (false).
     * @param billable Only return entries that are billable (true) or not billable (false).
     * @param statuses Only return entries in one of these statuses.
     * @param users Only return entries belonging to these users.
     * @param changed Only return entries that were changed by the user (true) or left unchanged (false).
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ProjectTimesPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ProjectTimesPage fetchProjectTimes(@Nullable String notes, @Nullable LocalDate startFrom, @Nullable LocalDate startTo, @Nullable OffsetDateTime lastModifiedAfter, @Nullable String task, @Nullable Boolean traverseTaskTree, @Nullable Boolean billable, @Nullable List<ProjectTimeStatus> statuses, @Nullable List<String> users, @Nullable Boolean changed, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable ProjectTimesSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<ProjectTimesPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchProjectTimesRequestCreation(notes, startFrom, startTo, lastModifiedAfter, task, traverseTaskTree, billable, statuses, users, changed, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Project Times
     * Lists the Project Times the authenticated user or API token can access.
     * <p><b>200</b> - Page of Project Times.
     * <p><b>400</b> - Bad Request
     * @param notes Only return entries whose notes contain this text.
     * @param startFrom Only return entries starting on or after this day.
     * @param startTo Only return entries starting on or before this day.
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param task Only return entries recorded on the Task with this ID.
     * @param traverseTaskTree Include entries recorded on the whole subtree of the given Task (true) or only on the Task itself (false).
     * @param billable Only return entries that are billable (true) or not billable (false).
     * @param statuses Only return entries in one of these statuses.
     * @param users Only return entries belonging to these users.
     * @param changed Only return entries that were changed by the user (true) or left unchanged (false).
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;ProjectTimesPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProjectTimesPage> fetchProjectTimesWithHttpInfo(@Nullable String notes, @Nullable LocalDate startFrom, @Nullable LocalDate startTo, @Nullable OffsetDateTime lastModifiedAfter, @Nullable String task, @Nullable Boolean traverseTaskTree, @Nullable Boolean billable, @Nullable List<ProjectTimeStatus> statuses, @Nullable List<String> users, @Nullable Boolean changed, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable ProjectTimesSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<ProjectTimesPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchProjectTimesRequestCreation(notes, startFrom, startTo, lastModifiedAfter, task, traverseTaskTree, billable, statuses, users, changed, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Project Times
     * Lists the Project Times the authenticated user or API token can access.
     * <p><b>200</b> - Page of Project Times.
     * <p><b>400</b> - Bad Request
     * @param notes Only return entries whose notes contain this text.
     * @param startFrom Only return entries starting on or after this day.
     * @param startTo Only return entries starting on or before this day.
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param task Only return entries recorded on the Task with this ID.
     * @param traverseTaskTree Include entries recorded on the whole subtree of the given Task (true) or only on the Task itself (false).
     * @param billable Only return entries that are billable (true) or not billable (false).
     * @param statuses Only return entries in one of these statuses.
     * @param users Only return entries belonging to these users.
     * @param changed Only return entries that were changed by the user (true) or left unchanged (false).
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchProjectTimesWithResponseSpec(@Nullable String notes, @Nullable LocalDate startFrom, @Nullable LocalDate startTo, @Nullable OffsetDateTime lastModifiedAfter, @Nullable String task, @Nullable Boolean traverseTaskTree, @Nullable Boolean billable, @Nullable List<ProjectTimeStatus> statuses, @Nullable List<String> users, @Nullable Boolean changed, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable ProjectTimesSortColumn sortBy) throws RestClientResponseException {
        return fetchProjectTimesRequestCreation(notes, startFrom, startTo, lastModifiedAfter, task, traverseTaskTree, billable, statuses, users, changed, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * Get a Project Time
     * Returns a single Project Time by its ID.
     * <p><b>200</b> - The requested Project Time.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Project Time.
     * @return ProjectTime
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getProjectTimeRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling getProjectTime", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<ProjectTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/project-times/{id}", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Project Time
     * Returns a single Project Time by its ID.
     * <p><b>200</b> - The requested Project Time.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Project Time.
     * @return ProjectTime
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ProjectTime getProjectTime(String id) throws RestClientResponseException {
        ParameterizedTypeReference<ProjectTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getProjectTimeRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Get a Project Time
     * Returns a single Project Time by its ID.
     * <p><b>200</b> - The requested Project Time.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Project Time.
     * @return ResponseEntity&lt;ProjectTime&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProjectTime> getProjectTimeWithHttpInfo(String id) throws RestClientResponseException {
        ParameterizedTypeReference<ProjectTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getProjectTimeRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get a Project Time
     * Returns a single Project Time by its ID.
     * <p><b>200</b> - The requested Project Time.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Project Time.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getProjectTimeWithResponseSpec(String id) throws RestClientResponseException {
        return getProjectTimeRequestCreation(id);
    }

    /**
     * Update a Project Time
     * Updates the Project Time with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Project Time.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Project Time.
     * @param projectTimeUpdate Project Time entity
     * @return ProjectTime
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateProjectTimeRequestCreation(String id, ProjectTimeUpdate projectTimeUpdate) throws RestClientResponseException {
        Object postBody = projectTimeUpdate;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling updateProjectTime", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'projectTimeUpdate' is set
        if (projectTimeUpdate == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectTimeUpdate' when calling updateProjectTime", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<ProjectTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/project-times/{id}", HttpMethod.PATCH, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update a Project Time
     * Updates the Project Time with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Project Time.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Project Time.
     * @param projectTimeUpdate Project Time entity
     * @return ProjectTime
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ProjectTime updateProjectTime(String id, ProjectTimeUpdate projectTimeUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<ProjectTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateProjectTimeRequestCreation(id, projectTimeUpdate).body(localVarReturnType);
    }

    /**
     * Update a Project Time
     * Updates the Project Time with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Project Time.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Project Time.
     * @param projectTimeUpdate Project Time entity
     * @return ResponseEntity&lt;ProjectTime&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProjectTime> updateProjectTimeWithHttpInfo(String id, ProjectTimeUpdate projectTimeUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<ProjectTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateProjectTimeRequestCreation(id, projectTimeUpdate).toEntity(localVarReturnType);
    }

    /**
     * Update a Project Time
     * Updates the Project Time with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Project Time.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Project Time.
     * @param projectTimeUpdate Project Time entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateProjectTimeWithResponseSpec(String id, ProjectTimeUpdate projectTimeUpdate) throws RestClientResponseException {
        return updateProjectTimeRequestCreation(id, projectTimeUpdate);
    }
}
