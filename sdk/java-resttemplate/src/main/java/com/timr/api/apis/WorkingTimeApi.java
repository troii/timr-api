package com.timr.api.apis;

import com.timr.api.ApiClient;
import com.timr.api.BaseApi;

import com.timr.api.models.DeletedEntrySortColumn;
import com.timr.api.models.DeletedEntryWithMetadataPage;
import com.timr.api.models.Error;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import com.timr.api.models.SortDirection;
import java.net.URI;
import com.timr.api.models.WorkingTime;
import com.timr.api.models.WorkingTimeCreate;
import com.timr.api.models.WorkingTimeStatus;
import com.timr.api.models.WorkingTimeTypeCategory;
import com.timr.api.models.WorkingTimeUpdate;
import com.timr.api.models.WorkingTimesPage;
import com.timr.api.models.WorkingTimesSortColumn;

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
@Component("com.timr.api.apis.WorkingTimeApi")
public class WorkingTimeApi extends BaseApi {

    public WorkingTimeApi() {
        super(new ApiClient());
    }

    @Autowired
    public WorkingTimeApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Create a Working Time
     * Creates a Working Time from the data in the request body.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param workingTimeCreate Working Time entity (required)
     * @return WorkingTime
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WorkingTime createWorkingTime(WorkingTimeCreate workingTimeCreate) throws RestClientException {
        return createWorkingTimeWithHttpInfo(workingTimeCreate).getBody();
    }

    /**
     * Create a Working Time
     * Creates a Working Time from the data in the request body.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param workingTimeCreate Working Time entity (required)
     * @return ResponseEntity&lt;WorkingTime&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTime> createWorkingTimeWithHttpInfo(WorkingTimeCreate workingTimeCreate) throws RestClientException {
        Object localVarPostBody = workingTimeCreate;
        
        // verify the required parameter 'workingTimeCreate' is set
        if (workingTimeCreate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'workingTimeCreate' when calling createWorkingTime");
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

        ParameterizedTypeReference<WorkingTime> localReturnType = new ParameterizedTypeReference<WorkingTime>() {};
        return apiClient.invokeAPI("/working-times", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a Working Time
     * Deletes the Working Time.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteWorkingTime(String id) throws RestClientException {
        deleteWorkingTimeWithHttpInfo(id);
    }

    /**
     * Delete a Working Time
     * Deletes the Working Time.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteWorkingTimeWithHttpInfo(String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteWorkingTime");
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
        return apiClient.invokeAPI("/working-times/{id}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List deleted Working Times
     * Lists Working Times that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Working Times.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to last_modified)
     * @return DeletedEntryWithMetadataPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DeletedEntryWithMetadataPage fetchDeletedWorkingTimes(OffsetDateTime lastModifiedAfter, String pageToken, Integer limit, SortDirection sortDirection, DeletedEntrySortColumn sortBy) throws RestClientException {
        return fetchDeletedWorkingTimesWithHttpInfo(lastModifiedAfter, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List deleted Working Times
     * Lists Working Times that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Working Times.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to last_modified)
     * @return ResponseEntity&lt;DeletedEntryWithMetadataPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DeletedEntryWithMetadataPage> fetchDeletedWorkingTimesWithHttpInfo(OffsetDateTime lastModifiedAfter, String pageToken, Integer limit, SortDirection sortDirection, DeletedEntrySortColumn sortBy) throws RestClientException {
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
        return apiClient.invokeAPI("/working-times:deleted", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List Working Times
     * Lists the Working Times the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Times.
     * <p><b>400</b> - Bad Request
     * @param notes Only return entries whose notes contain this text. (optional)
     * @param startFrom Only return entries starting on or after this day. (optional)
     * @param startTo Only return entries starting on or before this day. (optional)
     * @param lastModifiedAfter Only return entries modified after this instant. (optional)
     * @param workingTimeTypes Only return entries of these Working Time Types. (optional)
     * @param workingTimeTypeCategories Only return entries whose Working Time Type is in one of these categories. (optional)
     * @param statuses Only return entries in one of these statuses. (optional)
     * @param users Only return entries belonging to these users. (optional)
     * @param changed Only return entries that were changed by the user (true) or left unchanged (false). (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to start)
     * @return WorkingTimesPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WorkingTimesPage fetchWorkingTimes(String notes, LocalDate startFrom, LocalDate startTo, OffsetDateTime lastModifiedAfter, List<String> workingTimeTypes, List<WorkingTimeTypeCategory> workingTimeTypeCategories, List<WorkingTimeStatus> statuses, List<String> users, Boolean changed, String pageToken, Integer limit, SortDirection sortDirection, WorkingTimesSortColumn sortBy) throws RestClientException {
        return fetchWorkingTimesWithHttpInfo(notes, startFrom, startTo, lastModifiedAfter, workingTimeTypes, workingTimeTypeCategories, statuses, users, changed, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List Working Times
     * Lists the Working Times the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Times.
     * <p><b>400</b> - Bad Request
     * @param notes Only return entries whose notes contain this text. (optional)
     * @param startFrom Only return entries starting on or after this day. (optional)
     * @param startTo Only return entries starting on or before this day. (optional)
     * @param lastModifiedAfter Only return entries modified after this instant. (optional)
     * @param workingTimeTypes Only return entries of these Working Time Types. (optional)
     * @param workingTimeTypeCategories Only return entries whose Working Time Type is in one of these categories. (optional)
     * @param statuses Only return entries in one of these statuses. (optional)
     * @param users Only return entries belonging to these users. (optional)
     * @param changed Only return entries that were changed by the user (true) or left unchanged (false). (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to start)
     * @return ResponseEntity&lt;WorkingTimesPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTimesPage> fetchWorkingTimesWithHttpInfo(String notes, LocalDate startFrom, LocalDate startTo, OffsetDateTime lastModifiedAfter, List<String> workingTimeTypes, List<WorkingTimeTypeCategory> workingTimeTypeCategories, List<WorkingTimeStatus> statuses, List<String> users, Boolean changed, String pageToken, Integer limit, SortDirection sortDirection, WorkingTimesSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "notes", notes));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "start_from", startFrom));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "start_to", startTo));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "last_modified_after", lastModifiedAfter));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "working_time_types", workingTimeTypes));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "working_time_type_categories", workingTimeTypeCategories));
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

        ParameterizedTypeReference<WorkingTimesPage> localReturnType = new ParameterizedTypeReference<WorkingTimesPage>() {};
        return apiClient.invokeAPI("/working-times", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a Working Time
     * Returns a single Working Time by its ID.
     * <p><b>200</b> - The requested Working Time.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time. (required)
     * @return WorkingTime
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WorkingTime getWorkingTime(String id) throws RestClientException {
        return getWorkingTimeWithHttpInfo(id).getBody();
    }

    /**
     * Get a Working Time
     * Returns a single Working Time by its ID.
     * <p><b>200</b> - The requested Working Time.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time. (required)
     * @return ResponseEntity&lt;WorkingTime&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTime> getWorkingTimeWithHttpInfo(String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getWorkingTime");
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

        ParameterizedTypeReference<WorkingTime> localReturnType = new ParameterizedTypeReference<WorkingTime>() {};
        return apiClient.invokeAPI("/working-times/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update a Working Time
     * Updates the Working Time with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Working Time.
     * <p><b>302</b> - No Working Time was created because the working time type requires a request (recordingMode BY_REQUEST); a Working Time Request was created instead. The Location header points to the created Working Time Request. 
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Working Time. (required)
     * @param workingTimeUpdate Working Time entity (required)
     * @return WorkingTime
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WorkingTime updateWorkingTime(String id, WorkingTimeUpdate workingTimeUpdate) throws RestClientException {
        return updateWorkingTimeWithHttpInfo(id, workingTimeUpdate).getBody();
    }

    /**
     * Update a Working Time
     * Updates the Working Time with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Working Time.
     * <p><b>302</b> - No Working Time was created because the working time type requires a request (recordingMode BY_REQUEST); a Working Time Request was created instead. The Location header points to the created Working Time Request. 
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Working Time. (required)
     * @param workingTimeUpdate Working Time entity (required)
     * @return ResponseEntity&lt;WorkingTime&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTime> updateWorkingTimeWithHttpInfo(String id, WorkingTimeUpdate workingTimeUpdate) throws RestClientException {
        Object localVarPostBody = workingTimeUpdate;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateWorkingTime");
        }
        
        // verify the required parameter 'workingTimeUpdate' is set
        if (workingTimeUpdate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'workingTimeUpdate' when calling updateWorkingTime");
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

        ParameterizedTypeReference<WorkingTime> localReturnType = new ParameterizedTypeReference<WorkingTime>() {};
        return apiClient.invokeAPI("/working-times/{id}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
