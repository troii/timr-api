package com.timr.api.apis;

import com.timr.api.ApiClient;
import com.timr.api.BaseApi;

import com.timr.api.models.DeletedEntrySortColumn;
import com.timr.api.models.DeletedEntryWithMetadataPage;
import com.timr.api.models.Error;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import com.timr.api.models.ProjectTime;
import com.timr.api.models.ProjectTimeCreate;
import com.timr.api.models.ProjectTimeStatus;
import com.timr.api.models.ProjectTimeUpdate;
import com.timr.api.models.ProjectTimesPage;
import com.timr.api.models.ProjectTimesSortColumn;
import com.timr.api.models.SortDirection;
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
@Component("com.timr.api.apis.ProjectTimeApi")
public class ProjectTimeApi extends BaseApi {

    public ProjectTimeApi() {
        super(new ApiClient());
    }

    @Autowired
    public ProjectTimeApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Create a Project Time
     * Creates a Project Time from the data in the request body.
     * <p><b>201</b> - The created Project Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param projectTimeCreate Project Time entity (required)
     * @return ProjectTime
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ProjectTime createProjectTime(ProjectTimeCreate projectTimeCreate) throws RestClientException {
        return createProjectTimeWithHttpInfo(projectTimeCreate).getBody();
    }

    /**
     * Create a Project Time
     * Creates a Project Time from the data in the request body.
     * <p><b>201</b> - The created Project Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param projectTimeCreate Project Time entity (required)
     * @return ResponseEntity&lt;ProjectTime&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProjectTime> createProjectTimeWithHttpInfo(ProjectTimeCreate projectTimeCreate) throws RestClientException {
        Object localVarPostBody = projectTimeCreate;
        
        // verify the required parameter 'projectTimeCreate' is set
        if (projectTimeCreate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'projectTimeCreate' when calling createProjectTime");
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

        ParameterizedTypeReference<ProjectTime> localReturnType = new ParameterizedTypeReference<ProjectTime>() {};
        return apiClient.invokeAPI("/project-times", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a Project Time
     * Deletes the Project Time.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Project Time. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteProjectTime(String id) throws RestClientException {
        deleteProjectTimeWithHttpInfo(id);
    }

    /**
     * Delete a Project Time
     * Deletes the Project Time.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Project Time. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteProjectTimeWithHttpInfo(String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteProjectTime");
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
        return apiClient.invokeAPI("/project-times/{id}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List deleted Project Times
     * Lists Project Times that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Project Times.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to last_modified)
     * @return DeletedEntryWithMetadataPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DeletedEntryWithMetadataPage fetchDeletedProjectTimes(OffsetDateTime lastModifiedAfter, String pageToken, Integer limit, SortDirection sortDirection, DeletedEntrySortColumn sortBy) throws RestClientException {
        return fetchDeletedProjectTimesWithHttpInfo(lastModifiedAfter, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List deleted Project Times
     * Lists Project Times that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Project Times.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to last_modified)
     * @return ResponseEntity&lt;DeletedEntryWithMetadataPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DeletedEntryWithMetadataPage> fetchDeletedProjectTimesWithHttpInfo(OffsetDateTime lastModifiedAfter, String pageToken, Integer limit, SortDirection sortDirection, DeletedEntrySortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "last_modified_after", lastModifiedAfter));
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

        ParameterizedTypeReference<DeletedEntryWithMetadataPage> localReturnType = new ParameterizedTypeReference<DeletedEntryWithMetadataPage>() {};
        return apiClient.invokeAPI("/project-times:deleted", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List Project Times
     * Lists the Project Times the authenticated user or API token can access.
     * <p><b>200</b> - Page of Project Times.
     * <p><b>400</b> - Bad Request
     * @param notes Only return entries whose notes contain this text. (optional)
     * @param startFrom Only return entries starting on or after this day. (optional)
     * @param startTo Only return entries starting on or before this day. (optional)
     * @param lastModifiedAfter Only return entries modified after this instant. (optional)
     * @param task Only return entries recorded on the Task with this ID. (optional)
     * @param traverseTaskTree Include entries recorded on the whole subtree of the given Task (true) or only on the Task itself (false). (optional, default to true)
     * @param billable Only return entries that are billable (true) or not billable (false). (optional)
     * @param statuses Only return entries in one of these statuses. (optional)
     * @param users Only return entries belonging to these users. (optional)
     * @param changed Only return entries that were changed by the user (true) or left unchanged (false). (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to start)
     * @return ProjectTimesPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ProjectTimesPage fetchProjectTimes(String notes, LocalDate startFrom, LocalDate startTo, OffsetDateTime lastModifiedAfter, String task, Boolean traverseTaskTree, Boolean billable, List<ProjectTimeStatus> statuses, List<String> users, Boolean changed, String pageToken, Integer limit, SortDirection sortDirection, ProjectTimesSortColumn sortBy) throws RestClientException {
        return fetchProjectTimesWithHttpInfo(notes, startFrom, startTo, lastModifiedAfter, task, traverseTaskTree, billable, statuses, users, changed, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List Project Times
     * Lists the Project Times the authenticated user or API token can access.
     * <p><b>200</b> - Page of Project Times.
     * <p><b>400</b> - Bad Request
     * @param notes Only return entries whose notes contain this text. (optional)
     * @param startFrom Only return entries starting on or after this day. (optional)
     * @param startTo Only return entries starting on or before this day. (optional)
     * @param lastModifiedAfter Only return entries modified after this instant. (optional)
     * @param task Only return entries recorded on the Task with this ID. (optional)
     * @param traverseTaskTree Include entries recorded on the whole subtree of the given Task (true) or only on the Task itself (false). (optional, default to true)
     * @param billable Only return entries that are billable (true) or not billable (false). (optional)
     * @param statuses Only return entries in one of these statuses. (optional)
     * @param users Only return entries belonging to these users. (optional)
     * @param changed Only return entries that were changed by the user (true) or left unchanged (false). (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to start)
     * @return ResponseEntity&lt;ProjectTimesPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProjectTimesPage> fetchProjectTimesWithHttpInfo(String notes, LocalDate startFrom, LocalDate startTo, OffsetDateTime lastModifiedAfter, String task, Boolean traverseTaskTree, Boolean billable, List<ProjectTimeStatus> statuses, List<String> users, Boolean changed, String pageToken, Integer limit, SortDirection sortDirection, ProjectTimesSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

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
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<ProjectTimesPage> localReturnType = new ParameterizedTypeReference<ProjectTimesPage>() {};
        return apiClient.invokeAPI("/project-times", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a Project Time
     * Returns a single Project Time by its ID.
     * <p><b>200</b> - The requested Project Time.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Project Time. (required)
     * @return ProjectTime
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ProjectTime getProjectTime(String id) throws RestClientException {
        return getProjectTimeWithHttpInfo(id).getBody();
    }

    /**
     * Get a Project Time
     * Returns a single Project Time by its ID.
     * <p><b>200</b> - The requested Project Time.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Project Time. (required)
     * @return ResponseEntity&lt;ProjectTime&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProjectTime> getProjectTimeWithHttpInfo(String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getProjectTime");
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

        ParameterizedTypeReference<ProjectTime> localReturnType = new ParameterizedTypeReference<ProjectTime>() {};
        return apiClient.invokeAPI("/project-times/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
     * @param id ID of the Project Time. (required)
     * @param projectTimeUpdate Project Time entity (required)
     * @return ProjectTime
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ProjectTime updateProjectTime(String id, ProjectTimeUpdate projectTimeUpdate) throws RestClientException {
        return updateProjectTimeWithHttpInfo(id, projectTimeUpdate).getBody();
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
     * @param id ID of the Project Time. (required)
     * @param projectTimeUpdate Project Time entity (required)
     * @return ResponseEntity&lt;ProjectTime&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProjectTime> updateProjectTimeWithHttpInfo(String id, ProjectTimeUpdate projectTimeUpdate) throws RestClientException {
        Object localVarPostBody = projectTimeUpdate;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateProjectTime");
        }
        
        // verify the required parameter 'projectTimeUpdate' is set
        if (projectTimeUpdate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'projectTimeUpdate' when calling updateProjectTime");
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

        ParameterizedTypeReference<ProjectTime> localReturnType = new ParameterizedTypeReference<ProjectTime>() {};
        return apiClient.invokeAPI("/project-times/{id}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
