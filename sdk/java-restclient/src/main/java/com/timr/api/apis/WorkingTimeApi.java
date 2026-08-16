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
import com.timr.api.models.WorkingTime;
import com.timr.api.models.WorkingTimeCreate;
import com.timr.api.models.WorkingTimeStatus;
import com.timr.api.models.WorkingTimeTypeCategory;
import com.timr.api.models.WorkingTimeUpdate;
import com.timr.api.models.WorkingTimesPage;
import com.timr.api.models.WorkingTimesSortColumn;

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
public class WorkingTimeApi {
    private ApiClient apiClient;

    public WorkingTimeApi() {
        this(new ApiClient());
    }

    public WorkingTimeApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a Working Time
     * Creates a Working Time from the data in the request body.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param workingTimeCreate Working Time entity
     * @return WorkingTime
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createWorkingTimeRequestCreation(WorkingTimeCreate workingTimeCreate) throws RestClientResponseException {
        Object postBody = workingTimeCreate;
        // verify the required parameter 'workingTimeCreate' is set
        if (workingTimeCreate == null) {
            throw new RestClientResponseException("Missing the required parameter 'workingTimeCreate' when calling createWorkingTime", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<WorkingTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/working-times", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Working Time
     * Creates a Working Time from the data in the request body.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param workingTimeCreate Working Time entity
     * @return WorkingTime
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public WorkingTime createWorkingTime( WorkingTimeCreate workingTimeCreate) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createWorkingTimeRequestCreation(workingTimeCreate).body(localVarReturnType);
    }

    /**
     * Create a Working Time
     * Creates a Working Time from the data in the request body.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param workingTimeCreate Working Time entity
     * @return ResponseEntity&lt;WorkingTime&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTime> createWorkingTimeWithHttpInfo( WorkingTimeCreate workingTimeCreate) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createWorkingTimeRequestCreation(workingTimeCreate).toEntity(localVarReturnType);
    }

    /**
     * Create a Working Time
     * Creates a Working Time from the data in the request body.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param workingTimeCreate Working Time entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createWorkingTimeWithResponseSpec(WorkingTimeCreate workingTimeCreate) throws RestClientResponseException {
        return createWorkingTimeRequestCreation(workingTimeCreate);
    }

    /**
     * Delete a Working Time
     * Deletes the Working Time.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteWorkingTimeRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling deleteWorkingTime", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        return apiClient.invokeAPI("/working-times/{id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Working Time
     * Deletes the Working Time.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void deleteWorkingTime( String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        deleteWorkingTimeRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Delete a Working Time
     * Deletes the Working Time.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteWorkingTimeWithHttpInfo( String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return deleteWorkingTimeRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Delete a Working Time
     * Deletes the Working Time.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteWorkingTimeWithResponseSpec(String id) throws RestClientResponseException {
        return deleteWorkingTimeRequestCreation(id);
    }

    /**
     * List deleted Working Times
     * Lists Working Times that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Working Times.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return DeletedEntryWithMetadataPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchDeletedWorkingTimesRequestCreation(@Nullable OffsetDateTime lastModifiedAfter, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable DeletedEntrySortColumn sortBy) throws RestClientResponseException {
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
        return apiClient.invokeAPI("/working-times:deleted", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List deleted Working Times
     * Lists Working Times that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Working Times.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return DeletedEntryWithMetadataPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public DeletedEntryWithMetadataPage fetchDeletedWorkingTimes( OffsetDateTime lastModifiedAfter,  String pageToken,  Integer limit,  SortDirection sortDirection,  DeletedEntrySortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<DeletedEntryWithMetadataPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchDeletedWorkingTimesRequestCreation(lastModifiedAfter, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List deleted Working Times
     * Lists Working Times that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Working Times.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;DeletedEntryWithMetadataPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DeletedEntryWithMetadataPage> fetchDeletedWorkingTimesWithHttpInfo( OffsetDateTime lastModifiedAfter,  String pageToken,  Integer limit,  SortDirection sortDirection,  DeletedEntrySortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<DeletedEntryWithMetadataPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchDeletedWorkingTimesRequestCreation(lastModifiedAfter, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List deleted Working Times
     * Lists Working Times that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Working Times.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchDeletedWorkingTimesWithResponseSpec(@Nullable OffsetDateTime lastModifiedAfter, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable DeletedEntrySortColumn sortBy) throws RestClientResponseException {
        return fetchDeletedWorkingTimesRequestCreation(lastModifiedAfter, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * List Working Times
     * Lists the Working Times the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Times.
     * <p><b>400</b> - Bad Request
     * @param notes Only return entries whose notes contain this text.
     * @param startFrom Only return entries starting on or after this day.
     * @param startTo Only return entries starting on or before this day.
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param workingTimeTypes Only return entries of these Working Time Types.
     * @param workingTimeTypeCategories Only return entries whose Working Time Type is in one of these categories.
     * @param statuses Only return entries in one of these statuses.
     * @param users Only return entries belonging to these users.
     * @param changed Only return entries that were changed by the user (true) or left unchanged (false).
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return WorkingTimesPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchWorkingTimesRequestCreation(@Nullable String notes, @Nullable LocalDate startFrom, @Nullable LocalDate startTo, @Nullable OffsetDateTime lastModifiedAfter, @Nullable List<String> workingTimeTypes, @Nullable List<WorkingTimeTypeCategory> workingTimeTypeCategories, @Nullable List<WorkingTimeStatus> statuses, @Nullable List<String> users, @Nullable Boolean changed, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable WorkingTimesSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "notes", notes));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "start_from", startFrom));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "start_to", startTo));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "last_modified_after", lastModifiedAfter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "working_time_types", workingTimeTypes));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "working_time_type_categories", workingTimeTypeCategories));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "statuses", statuses));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "users", users));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "changed", changed));
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

        ParameterizedTypeReference<WorkingTimesPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/working-times", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Working Times
     * Lists the Working Times the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Times.
     * <p><b>400</b> - Bad Request
     * @param notes Only return entries whose notes contain this text.
     * @param startFrom Only return entries starting on or after this day.
     * @param startTo Only return entries starting on or before this day.
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param workingTimeTypes Only return entries of these Working Time Types.
     * @param workingTimeTypeCategories Only return entries whose Working Time Type is in one of these categories.
     * @param statuses Only return entries in one of these statuses.
     * @param users Only return entries belonging to these users.
     * @param changed Only return entries that were changed by the user (true) or left unchanged (false).
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return WorkingTimesPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public WorkingTimesPage fetchWorkingTimes( String notes,  LocalDate startFrom,  LocalDate startTo,  OffsetDateTime lastModifiedAfter,  List<String> workingTimeTypes,  List<WorkingTimeTypeCategory> workingTimeTypeCategories,  List<WorkingTimeStatus> statuses,  List<String> users,  Boolean changed,  String pageToken,  Integer limit,  SortDirection sortDirection,  WorkingTimesSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTimesPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchWorkingTimesRequestCreation(notes, startFrom, startTo, lastModifiedAfter, workingTimeTypes, workingTimeTypeCategories, statuses, users, changed, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Working Times
     * Lists the Working Times the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Times.
     * <p><b>400</b> - Bad Request
     * @param notes Only return entries whose notes contain this text.
     * @param startFrom Only return entries starting on or after this day.
     * @param startTo Only return entries starting on or before this day.
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param workingTimeTypes Only return entries of these Working Time Types.
     * @param workingTimeTypeCategories Only return entries whose Working Time Type is in one of these categories.
     * @param statuses Only return entries in one of these statuses.
     * @param users Only return entries belonging to these users.
     * @param changed Only return entries that were changed by the user (true) or left unchanged (false).
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;WorkingTimesPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTimesPage> fetchWorkingTimesWithHttpInfo( String notes,  LocalDate startFrom,  LocalDate startTo,  OffsetDateTime lastModifiedAfter,  List<String> workingTimeTypes,  List<WorkingTimeTypeCategory> workingTimeTypeCategories,  List<WorkingTimeStatus> statuses,  List<String> users,  Boolean changed,  String pageToken,  Integer limit,  SortDirection sortDirection,  WorkingTimesSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTimesPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchWorkingTimesRequestCreation(notes, startFrom, startTo, lastModifiedAfter, workingTimeTypes, workingTimeTypeCategories, statuses, users, changed, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Working Times
     * Lists the Working Times the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Times.
     * <p><b>400</b> - Bad Request
     * @param notes Only return entries whose notes contain this text.
     * @param startFrom Only return entries starting on or after this day.
     * @param startTo Only return entries starting on or before this day.
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param workingTimeTypes Only return entries of these Working Time Types.
     * @param workingTimeTypeCategories Only return entries whose Working Time Type is in one of these categories.
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
    public ResponseSpec fetchWorkingTimesWithResponseSpec(@Nullable String notes, @Nullable LocalDate startFrom, @Nullable LocalDate startTo, @Nullable OffsetDateTime lastModifiedAfter, @Nullable List<String> workingTimeTypes, @Nullable List<WorkingTimeTypeCategory> workingTimeTypeCategories, @Nullable List<WorkingTimeStatus> statuses, @Nullable List<String> users, @Nullable Boolean changed, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable WorkingTimesSortColumn sortBy) throws RestClientResponseException {
        return fetchWorkingTimesRequestCreation(notes, startFrom, startTo, lastModifiedAfter, workingTimeTypes, workingTimeTypeCategories, statuses, users, changed, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * Get a Working Time
     * Returns a single Working Time by its ID.
     * <p><b>200</b> - The requested Working Time.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time.
     * @return WorkingTime
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getWorkingTimeRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling getWorkingTime", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<WorkingTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/working-times/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Working Time
     * Returns a single Working Time by its ID.
     * <p><b>200</b> - The requested Working Time.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time.
     * @return WorkingTime
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public WorkingTime getWorkingTime( String id) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getWorkingTimeRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Get a Working Time
     * Returns a single Working Time by its ID.
     * <p><b>200</b> - The requested Working Time.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time.
     * @return ResponseEntity&lt;WorkingTime&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTime> getWorkingTimeWithHttpInfo( String id) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getWorkingTimeRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get a Working Time
     * Returns a single Working Time by its ID.
     * <p><b>200</b> - The requested Working Time.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getWorkingTimeWithResponseSpec(String id) throws RestClientResponseException {
        return getWorkingTimeRequestCreation(id);
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
     * @param id ID of the Working Time.
     * @param workingTimeUpdate Working Time entity
     * @return WorkingTime
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateWorkingTimeRequestCreation(String id, WorkingTimeUpdate workingTimeUpdate) throws RestClientResponseException {
        Object postBody = workingTimeUpdate;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling updateWorkingTime", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'workingTimeUpdate' is set
        if (workingTimeUpdate == null) {
            throw new RestClientResponseException("Missing the required parameter 'workingTimeUpdate' when calling updateWorkingTime", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<WorkingTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/working-times/{id}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
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
     * @param id ID of the Working Time.
     * @param workingTimeUpdate Working Time entity
     * @return WorkingTime
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public WorkingTime updateWorkingTime( String id,  WorkingTimeUpdate workingTimeUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateWorkingTimeRequestCreation(id, workingTimeUpdate).body(localVarReturnType);
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
     * @param id ID of the Working Time.
     * @param workingTimeUpdate Working Time entity
     * @return ResponseEntity&lt;WorkingTime&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTime> updateWorkingTimeWithHttpInfo( String id,  WorkingTimeUpdate workingTimeUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTime> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateWorkingTimeRequestCreation(id, workingTimeUpdate).toEntity(localVarReturnType);
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
     * @param id ID of the Working Time.
     * @param workingTimeUpdate Working Time entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateWorkingTimeWithResponseSpec(String id, WorkingTimeUpdate workingTimeUpdate) throws RestClientResponseException {
        return updateWorkingTimeRequestCreation(id, workingTimeUpdate);
    }
}
