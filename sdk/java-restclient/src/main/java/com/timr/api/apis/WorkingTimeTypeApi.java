package com.timr.api.apis;

import com.timr.api.ApiClient;

import com.timr.api.models.DurationUnit;
import com.timr.api.models.Error;
import org.jspecify.annotations.Nullable;
import com.timr.api.models.RecordingModeUser;
import com.timr.api.models.SortDirection;
import java.net.URI;
import com.timr.api.models.WorkingTimeType;
import com.timr.api.models.WorkingTimeTypeCategory;
import com.timr.api.models.WorkingTimeTypeSubCategory;
import com.timr.api.models.WorkingTimeTypesPage;
import com.timr.api.models.WorkingTimeTypesSortColumn;

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
public class WorkingTimeTypeApi {
    private ApiClient apiClient;

    public WorkingTimeTypeApi() {
        this(new ApiClient());
    }

    public WorkingTimeTypeApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a Working Time Type
     * Deletes the Working Time Type. It cannot be deleted while Working Times still reference it.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time Type.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteWorkingTimeTypeRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling deleteWorkingTimeType", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        return apiClient.invokeAPI("/working-time-types/{id}", HttpMethod.DELETE, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Working Time Type
     * Deletes the Working Time Type. It cannot be deleted while Working Times still reference it.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time Type.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void deleteWorkingTimeType(String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        deleteWorkingTimeTypeRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Delete a Working Time Type
     * Deletes the Working Time Type. It cannot be deleted while Working Times still reference it.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time Type.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteWorkingTimeTypeWithHttpInfo(String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return deleteWorkingTimeTypeRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Delete a Working Time Type
     * Deletes the Working Time Type. It cannot be deleted while Working Times still reference it.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time Type.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteWorkingTimeTypeWithResponseSpec(String id) throws RestClientResponseException {
        return deleteWorkingTimeTypeRequestCreation(id);
    }

    /**
     * List Working Time Types
     * Lists the Working Time Types the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Time Types.
     * <p><b>400</b> - Bad Request
     * @param name Only return entries whose name contains this text.
     * @param shortName filter by short name
     * @param description filter by description
     * @param categories filter by WorkingTimeTypeCategory
     * @param subCategories filter by WorkingTimeTypeSubCategory
     * @param editUnits filter by WorkingTimeType&#39;s DurationUnit
     * @param archived Only return entries that are archived (true) or not archived (false).
     * @param recordingModes filter entries bAWS on their RecordingMode
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return WorkingTimeTypesPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchWorkingTimeTypesRequestCreation(@Nullable String name, @Nullable String shortName, @Nullable String description, @Nullable List<WorkingTimeTypeCategory> categories, @Nullable List<WorkingTimeTypeSubCategory> subCategories, @Nullable List<DurationUnit> editUnits, @Nullable Boolean archived, @Nullable List<RecordingModeUser> recordingModes, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable WorkingTimeTypesSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "short_name", shortName));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "description", description));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "categories", categories));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "sub_categories", subCategories));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "edit_units", editUnits));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "archived", archived));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase(Locale.ROOT)), "recording_modes", recordingModes));
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

        ParameterizedTypeReference<WorkingTimeTypesPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/working-time-types", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Working Time Types
     * Lists the Working Time Types the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Time Types.
     * <p><b>400</b> - Bad Request
     * @param name Only return entries whose name contains this text.
     * @param shortName filter by short name
     * @param description filter by description
     * @param categories filter by WorkingTimeTypeCategory
     * @param subCategories filter by WorkingTimeTypeSubCategory
     * @param editUnits filter by WorkingTimeType&#39;s DurationUnit
     * @param archived Only return entries that are archived (true) or not archived (false).
     * @param recordingModes filter entries bAWS on their RecordingMode
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return WorkingTimeTypesPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public WorkingTimeTypesPage fetchWorkingTimeTypes(@Nullable String name, @Nullable String shortName, @Nullable String description, @Nullable List<WorkingTimeTypeCategory> categories, @Nullable List<WorkingTimeTypeSubCategory> subCategories, @Nullable List<DurationUnit> editUnits, @Nullable Boolean archived, @Nullable List<RecordingModeUser> recordingModes, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable WorkingTimeTypesSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTimeTypesPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchWorkingTimeTypesRequestCreation(name, shortName, description, categories, subCategories, editUnits, archived, recordingModes, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Working Time Types
     * Lists the Working Time Types the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Time Types.
     * <p><b>400</b> - Bad Request
     * @param name Only return entries whose name contains this text.
     * @param shortName filter by short name
     * @param description filter by description
     * @param categories filter by WorkingTimeTypeCategory
     * @param subCategories filter by WorkingTimeTypeSubCategory
     * @param editUnits filter by WorkingTimeType&#39;s DurationUnit
     * @param archived Only return entries that are archived (true) or not archived (false).
     * @param recordingModes filter entries bAWS on their RecordingMode
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;WorkingTimeTypesPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTimeTypesPage> fetchWorkingTimeTypesWithHttpInfo(@Nullable String name, @Nullable String shortName, @Nullable String description, @Nullable List<WorkingTimeTypeCategory> categories, @Nullable List<WorkingTimeTypeSubCategory> subCategories, @Nullable List<DurationUnit> editUnits, @Nullable Boolean archived, @Nullable List<RecordingModeUser> recordingModes, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable WorkingTimeTypesSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTimeTypesPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchWorkingTimeTypesRequestCreation(name, shortName, description, categories, subCategories, editUnits, archived, recordingModes, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Working Time Types
     * Lists the Working Time Types the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Time Types.
     * <p><b>400</b> - Bad Request
     * @param name Only return entries whose name contains this text.
     * @param shortName filter by short name
     * @param description filter by description
     * @param categories filter by WorkingTimeTypeCategory
     * @param subCategories filter by WorkingTimeTypeSubCategory
     * @param editUnits filter by WorkingTimeType&#39;s DurationUnit
     * @param archived Only return entries that are archived (true) or not archived (false).
     * @param recordingModes filter entries bAWS on their RecordingMode
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchWorkingTimeTypesWithResponseSpec(@Nullable String name, @Nullable String shortName, @Nullable String description, @Nullable List<WorkingTimeTypeCategory> categories, @Nullable List<WorkingTimeTypeSubCategory> subCategories, @Nullable List<DurationUnit> editUnits, @Nullable Boolean archived, @Nullable List<RecordingModeUser> recordingModes, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable WorkingTimeTypesSortColumn sortBy) throws RestClientResponseException {
        return fetchWorkingTimeTypesRequestCreation(name, shortName, description, categories, subCategories, editUnits, archived, recordingModes, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * Get a Working Time Type
     * Returns a single Working Time Type by its ID.
     * <p><b>200</b> - The requested Working Time Type.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time Type.
     * @return WorkingTimeType
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getWorkingTimeTypeRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling getWorkingTimeType", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<WorkingTimeType> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/working-time-types/{id}", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Working Time Type
     * Returns a single Working Time Type by its ID.
     * <p><b>200</b> - The requested Working Time Type.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time Type.
     * @return WorkingTimeType
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public WorkingTimeType getWorkingTimeType(String id) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTimeType> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getWorkingTimeTypeRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Get a Working Time Type
     * Returns a single Working Time Type by its ID.
     * <p><b>200</b> - The requested Working Time Type.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time Type.
     * @return ResponseEntity&lt;WorkingTimeType&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTimeType> getWorkingTimeTypeWithHttpInfo(String id) throws RestClientResponseException {
        ParameterizedTypeReference<WorkingTimeType> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getWorkingTimeTypeRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get a Working Time Type
     * Returns a single Working Time Type by its ID.
     * <p><b>200</b> - The requested Working Time Type.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time Type.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getWorkingTimeTypeWithResponseSpec(String id) throws RestClientResponseException {
        return getWorkingTimeTypeRequestCreation(id);
    }
}
