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
import com.timr.api.models.WorkingTimeDateSpan;
import com.timr.api.models.WorkingTimeDateSpanCreate;
import com.timr.api.models.WorkingTimeDateSpanPage;
import com.timr.api.models.WorkingTimeDateSpanUpdate;
import com.timr.api.models.WorkingTimeDateSpansSortColumn;

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
@Component("com.timr.api.apis.WorkingTimeDateSpanApi")
public class WorkingTimeDateSpanApi extends BaseApi {

    public WorkingTimeDateSpanApi() {
        super(new ApiClient());
    }

    @Autowired
    public WorkingTimeDateSpanApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Create a Working Time Date Span
     * Creates a Working Time Date Span from the data in the request body, and the day-based Working Times it covers.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param workingTimeDateSpanCreate Working Time Date Span entity (required)
     * @return WorkingTimeDateSpan
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WorkingTimeDateSpan createWorkingTimeDateSpan(@jakarta.annotation.Nonnull WorkingTimeDateSpanCreate workingTimeDateSpanCreate) throws RestClientException {
        return createWorkingTimeDateSpanWithHttpInfo(workingTimeDateSpanCreate).getBody();
    }

    /**
     * Create a Working Time Date Span
     * Creates a Working Time Date Span from the data in the request body, and the day-based Working Times it covers.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param workingTimeDateSpanCreate Working Time Date Span entity (required)
     * @return ResponseEntity&lt;WorkingTimeDateSpan&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTimeDateSpan> createWorkingTimeDateSpanWithHttpInfo(@jakarta.annotation.Nonnull WorkingTimeDateSpanCreate workingTimeDateSpanCreate) throws RestClientException {
        Object localVarPostBody = workingTimeDateSpanCreate;
        
        // verify the required parameter 'workingTimeDateSpanCreate' is set
        if (workingTimeDateSpanCreate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'workingTimeDateSpanCreate' when calling createWorkingTimeDateSpan");
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

        ParameterizedTypeReference<WorkingTimeDateSpan> localReturnType = new ParameterizedTypeReference<WorkingTimeDateSpan>() {};
        return apiClient.invokeAPI("/working-time-date-spans", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a Working Time Date Span
     * Deletes the Working Time Date Span together with the Working Times it covers.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time Date Span. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteWorkingTimeDateSpan(@jakarta.annotation.Nonnull String id) throws RestClientException {
        deleteWorkingTimeDateSpanWithHttpInfo(id);
    }

    /**
     * Delete a Working Time Date Span
     * Deletes the Working Time Date Span together with the Working Times it covers.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time Date Span. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteWorkingTimeDateSpanWithHttpInfo(@jakarta.annotation.Nonnull String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteWorkingTimeDateSpan");
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
        return apiClient.invokeAPI("/working-time-date-spans/{id}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List deleted Working Time Date Spans
     * Lists Working Time Date Spans that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Working Time Date Spans.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to last_modified)
     * @return DeletedEntryWithMetadataPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DeletedEntryWithMetadataPage fetchDeletedWorkingTimeDateSpans(@jakarta.annotation.Nullable OffsetDateTime lastModifiedAfter, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable DeletedEntrySortColumn sortBy) throws RestClientException {
        return fetchDeletedWorkingTimeDateSpansWithHttpInfo(lastModifiedAfter, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List deleted Working Time Date Spans
     * Lists Working Time Date Spans that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Working Time Date Spans.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to last_modified)
     * @return ResponseEntity&lt;DeletedEntryWithMetadataPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DeletedEntryWithMetadataPage> fetchDeletedWorkingTimeDateSpansWithHttpInfo(@jakarta.annotation.Nullable OffsetDateTime lastModifiedAfter, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable DeletedEntrySortColumn sortBy) throws RestClientException {
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
        return apiClient.invokeAPI("/working-time-date-spans:deleted", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List Working Time Date Spans
     * Lists the Working Time Date Spans the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Time Date Spans.
     * <p><b>400</b> - Bad Request
     * @param from Only return Working Time Date Spans that end on or after this day. (optional)
     * @param to Only return entries starting on or before this day. (optional)
     * @param lastModifiedAfter Only return entries modified after this instant. (optional)
     * @param workingTimeTypes Only return entries of these Working Time Types. (optional)
     * @param users Only return entries belonging to these users. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to start)
     * @return WorkingTimeDateSpanPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WorkingTimeDateSpanPage fetchWorkingTimeDateSpans(@jakarta.annotation.Nullable LocalDate from, @jakarta.annotation.Nullable LocalDate to, @jakarta.annotation.Nullable OffsetDateTime lastModifiedAfter, @jakarta.annotation.Nullable List<String> workingTimeTypes, @jakarta.annotation.Nullable List<String> users, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable WorkingTimeDateSpansSortColumn sortBy) throws RestClientException {
        return fetchWorkingTimeDateSpansWithHttpInfo(from, to, lastModifiedAfter, workingTimeTypes, users, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List Working Time Date Spans
     * Lists the Working Time Date Spans the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Time Date Spans.
     * <p><b>400</b> - Bad Request
     * @param from Only return Working Time Date Spans that end on or after this day. (optional)
     * @param to Only return entries starting on or before this day. (optional)
     * @param lastModifiedAfter Only return entries modified after this instant. (optional)
     * @param workingTimeTypes Only return entries of these Working Time Types. (optional)
     * @param users Only return entries belonging to these users. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to start)
     * @return ResponseEntity&lt;WorkingTimeDateSpanPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTimeDateSpanPage> fetchWorkingTimeDateSpansWithHttpInfo(@jakarta.annotation.Nullable LocalDate from, @jakarta.annotation.Nullable LocalDate to, @jakarta.annotation.Nullable OffsetDateTime lastModifiedAfter, @jakarta.annotation.Nullable List<String> workingTimeTypes, @jakarta.annotation.Nullable List<String> users, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable WorkingTimeDateSpansSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "from", from));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "to", to));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "last_modified_after", lastModifiedAfter));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "working_time_types", workingTimeTypes));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "users", users));
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

        ParameterizedTypeReference<WorkingTimeDateSpanPage> localReturnType = new ParameterizedTypeReference<WorkingTimeDateSpanPage>() {};
        return apiClient.invokeAPI("/working-time-date-spans", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a Working Time Date Span
     * Returns a single Working Time Date Span by its ID.
     * <p><b>200</b> - The requested Working Time Date Span.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time Date Span. (required)
     * @return WorkingTimeDateSpan
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WorkingTimeDateSpan getWorkingTimeDateSpan(@jakarta.annotation.Nonnull String id) throws RestClientException {
        return getWorkingTimeDateSpanWithHttpInfo(id).getBody();
    }

    /**
     * Get a Working Time Date Span
     * Returns a single Working Time Date Span by its ID.
     * <p><b>200</b> - The requested Working Time Date Span.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time Date Span. (required)
     * @return ResponseEntity&lt;WorkingTimeDateSpan&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTimeDateSpan> getWorkingTimeDateSpanWithHttpInfo(@jakarta.annotation.Nonnull String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getWorkingTimeDateSpan");
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

        ParameterizedTypeReference<WorkingTimeDateSpan> localReturnType = new ParameterizedTypeReference<WorkingTimeDateSpan>() {};
        return apiClient.invokeAPI("/working-time-date-spans/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update a Working Time Date Span
     * Updates the Working Time Date Span with the fields present in the request body, and adjusts the Working Times it covers. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Working Time Date Span.
     * <p><b>204</b> - Empty response indicating that a date span got deleted. This can happen when it is updated to a day where no working hours can be booked.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Working Time Date Span. (required)
     * @param workingTimeDateSpanUpdate working time date span entity (required)
     * @return WorkingTimeDateSpan
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WorkingTimeDateSpan updateWorkingTimeDateSpan(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull WorkingTimeDateSpanUpdate workingTimeDateSpanUpdate) throws RestClientException {
        return updateWorkingTimeDateSpanWithHttpInfo(id, workingTimeDateSpanUpdate).getBody();
    }

    /**
     * Update a Working Time Date Span
     * Updates the Working Time Date Span with the fields present in the request body, and adjusts the Working Times it covers. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Working Time Date Span.
     * <p><b>204</b> - Empty response indicating that a date span got deleted. This can happen when it is updated to a day where no working hours can be booked.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Working Time Date Span. (required)
     * @param workingTimeDateSpanUpdate working time date span entity (required)
     * @return ResponseEntity&lt;WorkingTimeDateSpan&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTimeDateSpan> updateWorkingTimeDateSpanWithHttpInfo(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull WorkingTimeDateSpanUpdate workingTimeDateSpanUpdate) throws RestClientException {
        Object localVarPostBody = workingTimeDateSpanUpdate;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateWorkingTimeDateSpan");
        }
        
        // verify the required parameter 'workingTimeDateSpanUpdate' is set
        if (workingTimeDateSpanUpdate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'workingTimeDateSpanUpdate' when calling updateWorkingTimeDateSpan");
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

        ParameterizedTypeReference<WorkingTimeDateSpan> localReturnType = new ParameterizedTypeReference<WorkingTimeDateSpan>() {};
        return apiClient.invokeAPI("/working-time-date-spans/{id}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
