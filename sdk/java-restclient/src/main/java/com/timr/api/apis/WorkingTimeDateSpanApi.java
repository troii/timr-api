package com.timr.api.apis;

import com.timr.api.ApiClient;

import com.timr.api.models.DeletedEntrySortColumn;
import com.timr.api.models.DeletedEntryWithMetadataPage;
import com.timr.api.models.Error;
import java.time.LocalDate;
import org.jspecify.annotations.Nullable;
import java.time.OffsetDateTime;
import com.timr.api.models.SortDirection;
import java.net.URI;
import com.timr.api.models.WorkingTimeDateSpan;
import com.timr.api.models.WorkingTimeDateSpanCreate;
import com.timr.api.models.WorkingTimeDateSpanPage;
import com.timr.api.models.WorkingTimeDateSpanUpdate;
import com.timr.api.models.WorkingTimeDateSpansSortColumn;

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
public class WorkingTimeDateSpanApi {
    private ApiClient apiClient;

    public WorkingTimeDateSpanApi() {
        this(new ApiClient());
    }

    public WorkingTimeDateSpanApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a Working Time Date Span
     * Creates a Working Time Date Span from the data in the request body, and the day-based Working Times it covers.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param workingTimeDateSpanCreate Working Time Date Span entity
     * @return WorkingTimeDateSpan
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createWorkingTimeDateSpanRequestCreation(WorkingTimeDateSpanCreate workingTimeDateSpanCreate) throws RestClientResponseException {
        Object postBody = workingTimeDateSpanCreate;
        // verify the required parameter 'workingTimeDateSpanCreate' is set
        if (workingTimeDateSpanCreate == null) {
            throw new RestClientResponseException("Missing the required parameter 'workingTimeDateSpanCreate' when calling createWorkingTimeDateSpan", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
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

        ParameterizedTypeReference<WorkingTimeDateSpan> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/working-time-date-spans", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Working Time Date Span
     * Creates a Working Time Date Span from the data in the request body, and the day-based Working Times it covers.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param workingTimeDateSpanCreate Working Time Date Span entity
     * @return WorkingTimeDateSpan
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public WorkingTimeDateSpan createWorkingTimeDateSpan( WorkingTimeDateSpanCreate workingTimeDateSpanCreate) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTimeDateSpan> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createWorkingTimeDateSpanRequestCreation(workingTimeDateSpanCreate).body(localVarReturnType);
    }

    /**
     * Create a Working Time Date Span
     * Creates a Working Time Date Span from the data in the request body, and the day-based Working Times it covers.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param workingTimeDateSpanCreate Working Time Date Span entity
     * @return ResponseEntity&lt;WorkingTimeDateSpan&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTimeDateSpan> createWorkingTimeDateSpanWithHttpInfo( WorkingTimeDateSpanCreate workingTimeDateSpanCreate) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTimeDateSpan> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createWorkingTimeDateSpanRequestCreation(workingTimeDateSpanCreate).toEntity(localVarReturnType);
    }

    /**
     * Create a Working Time Date Span
     * Creates a Working Time Date Span from the data in the request body, and the day-based Working Times it covers.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param workingTimeDateSpanCreate Working Time Date Span entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createWorkingTimeDateSpanWithResponseSpec(WorkingTimeDateSpanCreate workingTimeDateSpanCreate) throws RestClientResponseException {
        return createWorkingTimeDateSpanRequestCreation(workingTimeDateSpanCreate);
    }

    /**
     * Delete a Working Time Date Span
     * Deletes the Working Time Date Span together with the Working Times it covers.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time Date Span.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteWorkingTimeDateSpanRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling deleteWorkingTimeDateSpan", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

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
        return apiClient.invokeAPI("/working-time-date-spans/{id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Working Time Date Span
     * Deletes the Working Time Date Span together with the Working Times it covers.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time Date Span.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void deleteWorkingTimeDateSpan( String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        deleteWorkingTimeDateSpanRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Delete a Working Time Date Span
     * Deletes the Working Time Date Span together with the Working Times it covers.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time Date Span.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteWorkingTimeDateSpanWithHttpInfo( String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return deleteWorkingTimeDateSpanRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Delete a Working Time Date Span
     * Deletes the Working Time Date Span together with the Working Times it covers.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time Date Span.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteWorkingTimeDateSpanWithResponseSpec(String id) throws RestClientResponseException {
        return deleteWorkingTimeDateSpanRequestCreation(id);
    }

    /**
     * List deleted Working Time Date Spans
     * Lists Working Time Date Spans that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Working Time Date Spans.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return DeletedEntryWithMetadataPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchDeletedWorkingTimeDateSpansRequestCreation(@Nullable OffsetDateTime lastModifiedAfter, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable DeletedEntrySortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "last_modified_after", lastModifiedAfter));
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

        ParameterizedTypeReference<DeletedEntryWithMetadataPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/working-time-date-spans:deleted", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List deleted Working Time Date Spans
     * Lists Working Time Date Spans that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Working Time Date Spans.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return DeletedEntryWithMetadataPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public DeletedEntryWithMetadataPage fetchDeletedWorkingTimeDateSpans( OffsetDateTime lastModifiedAfter,  String pageToken,  Integer limit,  SortDirection sortDirection,  DeletedEntrySortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<DeletedEntryWithMetadataPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchDeletedWorkingTimeDateSpansRequestCreation(lastModifiedAfter, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List deleted Working Time Date Spans
     * Lists Working Time Date Spans that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Working Time Date Spans.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;DeletedEntryWithMetadataPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DeletedEntryWithMetadataPage> fetchDeletedWorkingTimeDateSpansWithHttpInfo( OffsetDateTime lastModifiedAfter,  String pageToken,  Integer limit,  SortDirection sortDirection,  DeletedEntrySortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<DeletedEntryWithMetadataPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchDeletedWorkingTimeDateSpansRequestCreation(lastModifiedAfter, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List deleted Working Time Date Spans
     * Lists Working Time Date Spans that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Working Time Date Spans.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchDeletedWorkingTimeDateSpansWithResponseSpec(@Nullable OffsetDateTime lastModifiedAfter, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable DeletedEntrySortColumn sortBy) throws RestClientResponseException {
        return fetchDeletedWorkingTimeDateSpansRequestCreation(lastModifiedAfter, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * List Working Time Date Spans
     * Lists the Working Time Date Spans the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Time Date Spans.
     * <p><b>400</b> - Bad Request
     * @param from Only return Working Time Date Spans that end on or after this day.
     * @param to Only return entries starting on or before this day.
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param workingTimeTypes Only return entries of these Working Time Types.
     * @param users Only return entries belonging to these users.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return WorkingTimeDateSpanPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchWorkingTimeDateSpansRequestCreation(@Nullable LocalDate from, @Nullable LocalDate to, @Nullable OffsetDateTime lastModifiedAfter, @Nullable List<String> workingTimeTypes, @Nullable List<String> users, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable WorkingTimeDateSpansSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "from", from));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "to", to));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "last_modified_after", lastModifiedAfter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "working_time_types", workingTimeTypes));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "users", users));
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

        ParameterizedTypeReference<WorkingTimeDateSpanPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/working-time-date-spans", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Working Time Date Spans
     * Lists the Working Time Date Spans the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Time Date Spans.
     * <p><b>400</b> - Bad Request
     * @param from Only return Working Time Date Spans that end on or after this day.
     * @param to Only return entries starting on or before this day.
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param workingTimeTypes Only return entries of these Working Time Types.
     * @param users Only return entries belonging to these users.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return WorkingTimeDateSpanPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public WorkingTimeDateSpanPage fetchWorkingTimeDateSpans( LocalDate from,  LocalDate to,  OffsetDateTime lastModifiedAfter,  List<String> workingTimeTypes,  List<String> users,  String pageToken,  Integer limit,  SortDirection sortDirection,  WorkingTimeDateSpansSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTimeDateSpanPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchWorkingTimeDateSpansRequestCreation(from, to, lastModifiedAfter, workingTimeTypes, users, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Working Time Date Spans
     * Lists the Working Time Date Spans the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Time Date Spans.
     * <p><b>400</b> - Bad Request
     * @param from Only return Working Time Date Spans that end on or after this day.
     * @param to Only return entries starting on or before this day.
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param workingTimeTypes Only return entries of these Working Time Types.
     * @param users Only return entries belonging to these users.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;WorkingTimeDateSpanPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTimeDateSpanPage> fetchWorkingTimeDateSpansWithHttpInfo( LocalDate from,  LocalDate to,  OffsetDateTime lastModifiedAfter,  List<String> workingTimeTypes,  List<String> users,  String pageToken,  Integer limit,  SortDirection sortDirection,  WorkingTimeDateSpansSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTimeDateSpanPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchWorkingTimeDateSpansRequestCreation(from, to, lastModifiedAfter, workingTimeTypes, users, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Working Time Date Spans
     * Lists the Working Time Date Spans the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Time Date Spans.
     * <p><b>400</b> - Bad Request
     * @param from Only return Working Time Date Spans that end on or after this day.
     * @param to Only return entries starting on or before this day.
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param workingTimeTypes Only return entries of these Working Time Types.
     * @param users Only return entries belonging to these users.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchWorkingTimeDateSpansWithResponseSpec(@Nullable LocalDate from, @Nullable LocalDate to, @Nullable OffsetDateTime lastModifiedAfter, @Nullable List<String> workingTimeTypes, @Nullable List<String> users, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable WorkingTimeDateSpansSortColumn sortBy) throws RestClientResponseException {
        return fetchWorkingTimeDateSpansRequestCreation(from, to, lastModifiedAfter, workingTimeTypes, users, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * Get a Working Time Date Span
     * Returns a single Working Time Date Span by its ID.
     * <p><b>200</b> - The requested Working Time Date Span.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time Date Span.
     * @return WorkingTimeDateSpan
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getWorkingTimeDateSpanRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling getWorkingTimeDateSpan", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

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

        ParameterizedTypeReference<WorkingTimeDateSpan> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/working-time-date-spans/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Working Time Date Span
     * Returns a single Working Time Date Span by its ID.
     * <p><b>200</b> - The requested Working Time Date Span.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time Date Span.
     * @return WorkingTimeDateSpan
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public WorkingTimeDateSpan getWorkingTimeDateSpan( String id) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTimeDateSpan> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getWorkingTimeDateSpanRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Get a Working Time Date Span
     * Returns a single Working Time Date Span by its ID.
     * <p><b>200</b> - The requested Working Time Date Span.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time Date Span.
     * @return ResponseEntity&lt;WorkingTimeDateSpan&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTimeDateSpan> getWorkingTimeDateSpanWithHttpInfo( String id) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTimeDateSpan> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getWorkingTimeDateSpanRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get a Working Time Date Span
     * Returns a single Working Time Date Span by its ID.
     * <p><b>200</b> - The requested Working Time Date Span.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time Date Span.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getWorkingTimeDateSpanWithResponseSpec(String id) throws RestClientResponseException {
        return getWorkingTimeDateSpanRequestCreation(id);
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
     * @param id ID of the Working Time Date Span.
     * @param workingTimeDateSpanUpdate working time date span entity
     * @return WorkingTimeDateSpan
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateWorkingTimeDateSpanRequestCreation(String id, WorkingTimeDateSpanUpdate workingTimeDateSpanUpdate) throws RestClientResponseException {
        Object postBody = workingTimeDateSpanUpdate;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling updateWorkingTimeDateSpan", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'workingTimeDateSpanUpdate' is set
        if (workingTimeDateSpanUpdate == null) {
            throw new RestClientResponseException("Missing the required parameter 'workingTimeDateSpanUpdate' when calling updateWorkingTimeDateSpan", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
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

        ParameterizedTypeReference<WorkingTimeDateSpan> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/working-time-date-spans/{id}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
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
     * @param id ID of the Working Time Date Span.
     * @param workingTimeDateSpanUpdate working time date span entity
     * @return WorkingTimeDateSpan
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public WorkingTimeDateSpan updateWorkingTimeDateSpan( String id,  WorkingTimeDateSpanUpdate workingTimeDateSpanUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTimeDateSpan> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateWorkingTimeDateSpanRequestCreation(id, workingTimeDateSpanUpdate).body(localVarReturnType);
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
     * @param id ID of the Working Time Date Span.
     * @param workingTimeDateSpanUpdate working time date span entity
     * @return ResponseEntity&lt;WorkingTimeDateSpan&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTimeDateSpan> updateWorkingTimeDateSpanWithHttpInfo( String id,  WorkingTimeDateSpanUpdate workingTimeDateSpanUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTimeDateSpan> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateWorkingTimeDateSpanRequestCreation(id, workingTimeDateSpanUpdate).toEntity(localVarReturnType);
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
     * @param id ID of the Working Time Date Span.
     * @param workingTimeDateSpanUpdate working time date span entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateWorkingTimeDateSpanWithResponseSpec(String id, WorkingTimeDateSpanUpdate workingTimeDateSpanUpdate) throws RestClientResponseException {
        return updateWorkingTimeDateSpanRequestCreation(id, workingTimeDateSpanUpdate);
    }
}
