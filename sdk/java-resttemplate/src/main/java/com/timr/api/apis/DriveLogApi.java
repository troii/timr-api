package com.timr.api.apis;

import com.timr.api.ApiClient;
import com.timr.api.BaseApi;

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
import java.time.OffsetDateTime;
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
@Component("com.timr.api.apis.DriveLogApi")
public class DriveLogApi extends BaseApi {

    public DriveLogApi() {
        super(new ApiClient());
    }

    @Autowired
    public DriveLogApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Create a Drive Log
     * Creates a Drive Log from the data in the request body.
     * <p><b>201</b> - The created Drive Log.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param driveLogCreate Drive Log entity (required)
     * @return DriveLog
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DriveLog createDriveLog(DriveLogCreate driveLogCreate) throws RestClientException {
        return createDriveLogWithHttpInfo(driveLogCreate).getBody();
    }

    /**
     * Create a Drive Log
     * Creates a Drive Log from the data in the request body.
     * <p><b>201</b> - The created Drive Log.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param driveLogCreate Drive Log entity (required)
     * @return ResponseEntity&lt;DriveLog&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DriveLog> createDriveLogWithHttpInfo(DriveLogCreate driveLogCreate) throws RestClientException {
        Object localVarPostBody = driveLogCreate;
        
        // verify the required parameter 'driveLogCreate' is set
        if (driveLogCreate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'driveLogCreate' when calling createDriveLog");
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

        ParameterizedTypeReference<DriveLog> localReturnType = new ParameterizedTypeReference<DriveLog>() {};
        return apiClient.invokeAPI("/drive-logs", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a Drive Log
     * Deletes the Drive Log, including its Track.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Drive Log. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteDriveLog(String id) throws RestClientException {
        deleteDriveLogWithHttpInfo(id);
    }

    /**
     * Delete a Drive Log
     * Deletes the Drive Log, including its Track.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Drive Log. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteDriveLogWithHttpInfo(String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteDriveLog");
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
        return apiClient.invokeAPI("/drive-logs/{id}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List deleted Drive Logs
     * Lists Drive Logs that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Drive Logs.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to last_modified)
     * @return DeletedEntryPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DeletedEntryPage fetchDeletedDriveLogs(OffsetDateTime lastModifiedAfter, String pageToken, Integer limit, SortDirection sortDirection, DeletedEntrySortColumn sortBy) throws RestClientException {
        return fetchDeletedDriveLogsWithHttpInfo(lastModifiedAfter, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List deleted Drive Logs
     * Lists Drive Logs that were deleted, so a client holding a local copy can reconcile.
     * <p><b>200</b> - Page of deleted Drive Logs.
     * <p><b>400</b> - Bad Request
     * @param lastModifiedAfter Only return entries modified after this instant. (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to last_modified)
     * @return ResponseEntity&lt;DeletedEntryPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DeletedEntryPage> fetchDeletedDriveLogsWithHttpInfo(OffsetDateTime lastModifiedAfter, String pageToken, Integer limit, SortDirection sortDirection, DeletedEntrySortColumn sortBy) throws RestClientException {
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

        ParameterizedTypeReference<DeletedEntryPage> localReturnType = new ParameterizedTypeReference<DeletedEntryPage>() {};
        return apiClient.invokeAPI("/drive-logs:deleted", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List Drive Logs
     * Lists the Drive Logs the authenticated user or API token can access.
     * <p><b>200</b> - Page of Drive Logs.
     * <p><b>400</b> - Bad Request
     * @param startFrom Only return entries starting on or after this day. (optional)
     * @param startTo Only return entries starting on or before this day. (optional)
     * @param lastModifiedAfter Only return entries modified after this instant. (optional)
     * @param cars Only return entries recorded for these Cars. (optional)
     * @param driveLogCategories Only return entries in these Drive Log Categories. (optional)
     * @param statuses Only return entries in one of these statuses. (optional)
     * @param users Only return entries belonging to these users. (optional)
     * @param details Only return Drive Logs whose route, purpose or visited contains this text. (optional)
     * @param changed Only return entries that were changed by the user (true) or left unchanged (false). (optional)
     * @param hasTrack Only return Drive Logs that have a Track (true) or have none (false). (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to start)
     * @return DriveLogsPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DriveLogsPage fetchDriveLogs(LocalDate startFrom, LocalDate startTo, OffsetDateTime lastModifiedAfter, List<String> cars, List<String> driveLogCategories, List<DriveLogStatus> statuses, List<String> users, String details, Boolean changed, Boolean hasTrack, String pageToken, Integer limit, SortDirection sortDirection, DriveLogsSortColumn sortBy) throws RestClientException {
        return fetchDriveLogsWithHttpInfo(startFrom, startTo, lastModifiedAfter, cars, driveLogCategories, statuses, users, details, changed, hasTrack, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List Drive Logs
     * Lists the Drive Logs the authenticated user or API token can access.
     * <p><b>200</b> - Page of Drive Logs.
     * <p><b>400</b> - Bad Request
     * @param startFrom Only return entries starting on or after this day. (optional)
     * @param startTo Only return entries starting on or before this day. (optional)
     * @param lastModifiedAfter Only return entries modified after this instant. (optional)
     * @param cars Only return entries recorded for these Cars. (optional)
     * @param driveLogCategories Only return entries in these Drive Log Categories. (optional)
     * @param statuses Only return entries in one of these statuses. (optional)
     * @param users Only return entries belonging to these users. (optional)
     * @param details Only return Drive Logs whose route, purpose or visited contains this text. (optional)
     * @param changed Only return entries that were changed by the user (true) or left unchanged (false). (optional)
     * @param hasTrack Only return Drive Logs that have a Track (true) or have none (false). (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to start)
     * @return ResponseEntity&lt;DriveLogsPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DriveLogsPage> fetchDriveLogsWithHttpInfo(LocalDate startFrom, LocalDate startTo, OffsetDateTime lastModifiedAfter, List<String> cars, List<String> driveLogCategories, List<DriveLogStatus> statuses, List<String> users, String details, Boolean changed, Boolean hasTrack, String pageToken, Integer limit, SortDirection sortDirection, DriveLogsSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "start_from", startFrom));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "start_to", startTo));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "last_modified_after", lastModifiedAfter));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "cars", cars));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "drive_log_categories", driveLogCategories));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "statuses", statuses));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "users", users));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "details", details));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "changed", changed));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "has_track", hasTrack));
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

        ParameterizedTypeReference<DriveLogsPage> localReturnType = new ParameterizedTypeReference<DriveLogsPage>() {};
        return apiClient.invokeAPI("/drive-logs", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a Drive Log
     * Returns a single Drive Log by its ID.
     * <p><b>200</b> - The requested Drive Log.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Drive Log. (required)
     * @return DriveLog
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DriveLog getDriveLog(String id) throws RestClientException {
        return getDriveLogWithHttpInfo(id).getBody();
    }

    /**
     * Get a Drive Log
     * Returns a single Drive Log by its ID.
     * <p><b>200</b> - The requested Drive Log.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Drive Log. (required)
     * @return ResponseEntity&lt;DriveLog&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DriveLog> getDriveLogWithHttpInfo(String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getDriveLog");
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

        ParameterizedTypeReference<DriveLog> localReturnType = new ParameterizedTypeReference<DriveLog>() {};
        return apiClient.invokeAPI("/drive-logs/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
     * @param id ID of the Drive Log. (required)
     * @param driveLogUpdate Drive Log entity (required)
     * @return DriveLog
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DriveLog updateDriveLog(String id, DriveLogUpdate driveLogUpdate) throws RestClientException {
        return updateDriveLogWithHttpInfo(id, driveLogUpdate).getBody();
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
     * @param id ID of the Drive Log. (required)
     * @param driveLogUpdate Drive Log entity (required)
     * @return ResponseEntity&lt;DriveLog&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DriveLog> updateDriveLogWithHttpInfo(String id, DriveLogUpdate driveLogUpdate) throws RestClientException {
        Object localVarPostBody = driveLogUpdate;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateDriveLog");
        }
        
        // verify the required parameter 'driveLogUpdate' is set
        if (driveLogUpdate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'driveLogUpdate' when calling updateDriveLog");
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

        ParameterizedTypeReference<DriveLog> localReturnType = new ParameterizedTypeReference<DriveLog>() {};
        return apiClient.invokeAPI("/drive-logs/{id}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
