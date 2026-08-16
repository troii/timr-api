package com.timr.api.apis;

import com.timr.api.ApiClient;

import com.timr.api.models.DeletedEntryPage;
import com.timr.api.models.DeletedEntrySortColumn;
import com.timr.api.models.DriveLog;
import com.timr.api.models.DriveLogCreate;
import com.timr.api.models.DriveLogStatus;
import com.timr.api.models.DriveLogUpdate;
import com.timr.api.models.DriveLogsPage;
import com.timr.api.models.DriveLogsSortColumn;
import com.timr.api.models.Error;
import java.time.LocalDate;
import org.jspecify.annotations.Nullable;
import java.time.OffsetDateTime;
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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.22.0")
public class DriveLogApi {
    private ApiClient apiClient;

    public DriveLogApi() {
        this(new ApiClient());
    }

    public DriveLogApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a Drive Log
     * Creates a Drive Log from the data in the request body.
     * <p><b>201</b> - The created Drive Log.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param driveLogCreate Drive Log entity
     * @return DriveLog
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createDriveLogRequestCreation(DriveLogCreate driveLogCreate) throws RestClientResponseException {
        Object postBody = driveLogCreate;
        // verify the required parameter 'driveLogCreate' is set
        if (driveLogCreate == null) {
            throw new RestClientResponseException("Missing the required parameter 'driveLogCreate' when calling createDriveLog", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<DriveLog> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/drive-logs", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Drive Log
     * Creates a Drive Log from the data in the request body.
     * <p><b>201</b> - The created Drive Log.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param driveLogCreate Drive Log entity
     * @return DriveLog
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public DriveLog createDriveLog( DriveLogCreate driveLogCreate) throws RestClientResponseException {
        ParameterizedTypeReference<DriveLog> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createDriveLogRequestCreation(driveLogCreate).body(localVarReturnType);
    }

    /**
     * Create a Drive Log
     * Creates a Drive Log from the data in the request body.
     * <p><b>201</b> - The created Drive Log.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param driveLogCreate Drive Log entity
     * @return ResponseEntity&lt;DriveLog&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DriveLog> createDriveLogWithHttpInfo( DriveLogCreate driveLogCreate) throws RestClientResponseException {
        ParameterizedTypeReference<DriveLog> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createDriveLogRequestCreation(driveLogCreate).toEntity(localVarReturnType);
    }

    /**
     * Create a Drive Log
     * Creates a Drive Log from the data in the request body.
     * <p><b>201</b> - The created Drive Log.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param driveLogCreate Drive Log entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createDriveLogWithResponseSpec(DriveLogCreate driveLogCreate) throws RestClientResponseException {
        return createDriveLogRequestCreation(driveLogCreate);
    }

    /**
     * Delete a Drive Log
     * Deletes the Drive Log, including its Track.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Drive Log.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteDriveLogRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling deleteDriveLog", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        return apiClient.invokeAPI("/drive-logs/{id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Drive Log
     * Deletes the Drive Log, including its Track.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Drive Log.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void deleteDriveLog( String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        deleteDriveLogRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Delete a Drive Log
     * Deletes the Drive Log, including its Track.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Drive Log.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteDriveLogWithHttpInfo( String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return deleteDriveLogRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Delete a Drive Log
     * Deletes the Drive Log, including its Track.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Drive Log.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteDriveLogWithResponseSpec(String id) throws RestClientResponseException {
        return deleteDriveLogRequestCreation(id);
    }

    /**
     * List deleted Drive Logs
     * Lists Drive Logs that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Drive Logs.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return DeletedEntryPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchDeletedDriveLogsRequestCreation(@Nullable OffsetDateTime lastModifiedAfter, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable DeletedEntrySortColumn sortBy) throws RestClientResponseException {
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

        ParameterizedTypeReference<DeletedEntryPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/drive-logs:deleted", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List deleted Drive Logs
     * Lists Drive Logs that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Drive Logs.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return DeletedEntryPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public DeletedEntryPage fetchDeletedDriveLogs( OffsetDateTime lastModifiedAfter,  String pageToken,  Integer limit,  SortDirection sortDirection,  DeletedEntrySortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<DeletedEntryPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchDeletedDriveLogsRequestCreation(lastModifiedAfter, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List deleted Drive Logs
     * Lists Drive Logs that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Drive Logs.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;DeletedEntryPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DeletedEntryPage> fetchDeletedDriveLogsWithHttpInfo( OffsetDateTime lastModifiedAfter,  String pageToken,  Integer limit,  SortDirection sortDirection,  DeletedEntrySortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<DeletedEntryPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchDeletedDriveLogsRequestCreation(lastModifiedAfter, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List deleted Drive Logs
     * Lists Drive Logs that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Drive Logs.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchDeletedDriveLogsWithResponseSpec(@Nullable OffsetDateTime lastModifiedAfter, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable DeletedEntrySortColumn sortBy) throws RestClientResponseException {
        return fetchDeletedDriveLogsRequestCreation(lastModifiedAfter, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * List Drive Logs
     * Lists the Drive Logs the authenticated user or API token can access.
     * <p><b>200</b> - Page of Drive Logs.
     * <p><b>400</b> - Bad Request
     * @param startFrom Only return entries starting on or after this day.
     * @param startTo Only return entries starting on or before this day.
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param cars Only return entries recorded for these Cars.
     * @param driveLogCategories Only return entries in these Drive Log Categories.
     * @param statuses Only return entries in one of these statuses.
     * @param users Only return entries belonging to these users.
     * @param details Only return Drive Logs whose route, purpose or visited contains this text.
     * @param changed Only return entries that were changed by the user (true) or left unchanged (false).
     * @param hasTrack Only return Drive Logs that have a Track (true) or have none (false).
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return DriveLogsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchDriveLogsRequestCreation(@Nullable LocalDate startFrom, @Nullable LocalDate startTo, @Nullable OffsetDateTime lastModifiedAfter, @Nullable List<String> cars, @Nullable List<String> driveLogCategories, @Nullable List<DriveLogStatus> statuses, @Nullable List<String> users, @Nullable String details, @Nullable Boolean changed, @Nullable Boolean hasTrack, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable DriveLogsSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "start_from", startFrom));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "start_to", startTo));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "last_modified_after", lastModifiedAfter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "cars", cars));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "drive_log_categories", driveLogCategories));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "statuses", statuses));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "users", users));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "details", details));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "changed", changed));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "has_track", hasTrack));
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

        ParameterizedTypeReference<DriveLogsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/drive-logs", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Drive Logs
     * Lists the Drive Logs the authenticated user or API token can access.
     * <p><b>200</b> - Page of Drive Logs.
     * <p><b>400</b> - Bad Request
     * @param startFrom Only return entries starting on or after this day.
     * @param startTo Only return entries starting on or before this day.
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param cars Only return entries recorded for these Cars.
     * @param driveLogCategories Only return entries in these Drive Log Categories.
     * @param statuses Only return entries in one of these statuses.
     * @param users Only return entries belonging to these users.
     * @param details Only return Drive Logs whose route, purpose or visited contains this text.
     * @param changed Only return entries that were changed by the user (true) or left unchanged (false).
     * @param hasTrack Only return Drive Logs that have a Track (true) or have none (false).
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return DriveLogsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public DriveLogsPage fetchDriveLogs( LocalDate startFrom,  LocalDate startTo,  OffsetDateTime lastModifiedAfter,  List<String> cars,  List<String> driveLogCategories,  List<DriveLogStatus> statuses,  List<String> users,  String details,  Boolean changed,  Boolean hasTrack,  String pageToken,  Integer limit,  SortDirection sortDirection,  DriveLogsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<DriveLogsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchDriveLogsRequestCreation(startFrom, startTo, lastModifiedAfter, cars, driveLogCategories, statuses, users, details, changed, hasTrack, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Drive Logs
     * Lists the Drive Logs the authenticated user or API token can access.
     * <p><b>200</b> - Page of Drive Logs.
     * <p><b>400</b> - Bad Request
     * @param startFrom Only return entries starting on or after this day.
     * @param startTo Only return entries starting on or before this day.
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param cars Only return entries recorded for these Cars.
     * @param driveLogCategories Only return entries in these Drive Log Categories.
     * @param statuses Only return entries in one of these statuses.
     * @param users Only return entries belonging to these users.
     * @param details Only return Drive Logs whose route, purpose or visited contains this text.
     * @param changed Only return entries that were changed by the user (true) or left unchanged (false).
     * @param hasTrack Only return Drive Logs that have a Track (true) or have none (false).
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;DriveLogsPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DriveLogsPage> fetchDriveLogsWithHttpInfo( LocalDate startFrom,  LocalDate startTo,  OffsetDateTime lastModifiedAfter,  List<String> cars,  List<String> driveLogCategories,  List<DriveLogStatus> statuses,  List<String> users,  String details,  Boolean changed,  Boolean hasTrack,  String pageToken,  Integer limit,  SortDirection sortDirection,  DriveLogsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<DriveLogsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchDriveLogsRequestCreation(startFrom, startTo, lastModifiedAfter, cars, driveLogCategories, statuses, users, details, changed, hasTrack, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Drive Logs
     * Lists the Drive Logs the authenticated user or API token can access.
     * <p><b>200</b> - Page of Drive Logs.
     * <p><b>400</b> - Bad Request
     * @param startFrom Only return entries starting on or after this day.
     * @param startTo Only return entries starting on or before this day.
     * @param lastModifiedAfter Only return entries modified after this instant.
     * @param cars Only return entries recorded for these Cars.
     * @param driveLogCategories Only return entries in these Drive Log Categories.
     * @param statuses Only return entries in one of these statuses.
     * @param users Only return entries belonging to these users.
     * @param details Only return Drive Logs whose route, purpose or visited contains this text.
     * @param changed Only return entries that were changed by the user (true) or left unchanged (false).
     * @param hasTrack Only return Drive Logs that have a Track (true) or have none (false).
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchDriveLogsWithResponseSpec(@Nullable LocalDate startFrom, @Nullable LocalDate startTo, @Nullable OffsetDateTime lastModifiedAfter, @Nullable List<String> cars, @Nullable List<String> driveLogCategories, @Nullable List<DriveLogStatus> statuses, @Nullable List<String> users, @Nullable String details, @Nullable Boolean changed, @Nullable Boolean hasTrack, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable DriveLogsSortColumn sortBy) throws RestClientResponseException {
        return fetchDriveLogsRequestCreation(startFrom, startTo, lastModifiedAfter, cars, driveLogCategories, statuses, users, details, changed, hasTrack, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * Get a Drive Log
     * Returns a single Drive Log by its ID.
     * <p><b>200</b> - The requested Drive Log.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Drive Log.
     * @return DriveLog
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getDriveLogRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling getDriveLog", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<DriveLog> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/drive-logs/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Drive Log
     * Returns a single Drive Log by its ID.
     * <p><b>200</b> - The requested Drive Log.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Drive Log.
     * @return DriveLog
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public DriveLog getDriveLog( String id) throws RestClientResponseException {
        ParameterizedTypeReference<DriveLog> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getDriveLogRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Get a Drive Log
     * Returns a single Drive Log by its ID.
     * <p><b>200</b> - The requested Drive Log.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Drive Log.
     * @return ResponseEntity&lt;DriveLog&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DriveLog> getDriveLogWithHttpInfo( String id) throws RestClientResponseException {
        ParameterizedTypeReference<DriveLog> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getDriveLogRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get a Drive Log
     * Returns a single Drive Log by its ID.
     * <p><b>200</b> - The requested Drive Log.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Drive Log.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getDriveLogWithResponseSpec(String id) throws RestClientResponseException {
        return getDriveLogRequestCreation(id);
    }

    /**
     * Update a Drive Log
     * Updates the Drive Log with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Drive Log.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Drive Log.
     * @param driveLogUpdate Drive Log entity
     * @return DriveLog
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateDriveLogRequestCreation(String id, DriveLogUpdate driveLogUpdate) throws RestClientResponseException {
        Object postBody = driveLogUpdate;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling updateDriveLog", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'driveLogUpdate' is set
        if (driveLogUpdate == null) {
            throw new RestClientResponseException("Missing the required parameter 'driveLogUpdate' when calling updateDriveLog", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<DriveLog> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/drive-logs/{id}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update a Drive Log
     * Updates the Drive Log with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Drive Log.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Drive Log.
     * @param driveLogUpdate Drive Log entity
     * @return DriveLog
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public DriveLog updateDriveLog( String id,  DriveLogUpdate driveLogUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<DriveLog> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateDriveLogRequestCreation(id, driveLogUpdate).body(localVarReturnType);
    }

    /**
     * Update a Drive Log
     * Updates the Drive Log with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Drive Log.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Drive Log.
     * @param driveLogUpdate Drive Log entity
     * @return ResponseEntity&lt;DriveLog&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DriveLog> updateDriveLogWithHttpInfo( String id,  DriveLogUpdate driveLogUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<DriveLog> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateDriveLogRequestCreation(id, driveLogUpdate).toEntity(localVarReturnType);
    }

    /**
     * Update a Drive Log
     * Updates the Drive Log with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Drive Log.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Drive Log.
     * @param driveLogUpdate Drive Log entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateDriveLogWithResponseSpec(String id, DriveLogUpdate driveLogUpdate) throws RestClientResponseException {
        return updateDriveLogRequestCreation(id, driveLogUpdate);
    }
}
