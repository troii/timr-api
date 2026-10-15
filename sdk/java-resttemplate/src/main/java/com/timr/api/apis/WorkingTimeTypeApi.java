package com.timr.api.apis;

import com.timr.api.ApiClient;
import com.timr.api.BaseApi;

import com.timr.api.models.DurationUnit;
import com.timr.api.models.Error;
import com.timr.api.models.RecordingModeUser;
import com.timr.api.models.SortDirection;
import java.net.URI;
import com.timr.api.models.WorkingTimeType;
import com.timr.api.models.WorkingTimeTypeCategory;
import com.timr.api.models.WorkingTimeTypeSubCategory;
import com.timr.api.models.WorkingTimeTypesPage;
import com.timr.api.models.WorkingTimeTypesSortColumn;

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
@Component("com.timr.api.apis.WorkingTimeTypeApi")
public class WorkingTimeTypeApi extends BaseApi {

    public WorkingTimeTypeApi() {
        super(new ApiClient());
    }

    @Autowired
    public WorkingTimeTypeApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Delete a Working Time Type
     * Deletes the Working Time Type. It cannot be deleted while Working Times still reference it.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time Type. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteWorkingTimeType(@jakarta.annotation.Nonnull String id) throws RestClientException {
        deleteWorkingTimeTypeWithHttpInfo(id);
    }

    /**
     * Delete a Working Time Type
     * Deletes the Working Time Type. It cannot be deleted while Working Times still reference it.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Working Time Type. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteWorkingTimeTypeWithHttpInfo(@jakarta.annotation.Nonnull String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteWorkingTimeType");
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
        return apiClient.invokeAPI("/working-time-types/{id}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List Working Time Types
     * Lists the Working Time Types the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Time Types.
     * <p><b>400</b> - Bad Request
     * @param name Only return entries whose name contains this text. (optional)
     * @param shortName filter by short name (optional)
     * @param description filter by description (optional)
     * @param categories filter by WorkingTimeTypeCategory (optional)
     * @param subCategories filter by WorkingTimeTypeSubCategory (optional)
     * @param editUnits filter by WorkingTimeType&#39;s DurationUnit (optional)
     * @param archived Only return entries that are archived (true) or not archived (false). (optional)
     * @param recordingModes filter entries bAWS on their RecordingMode (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to name)
     * @return WorkingTimeTypesPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WorkingTimeTypesPage fetchWorkingTimeTypes(@jakarta.annotation.Nullable String name, @jakarta.annotation.Nullable String shortName, @jakarta.annotation.Nullable String description, @jakarta.annotation.Nullable List<WorkingTimeTypeCategory> categories, @jakarta.annotation.Nullable List<WorkingTimeTypeSubCategory> subCategories, @jakarta.annotation.Nullable List<DurationUnit> editUnits, @jakarta.annotation.Nullable Boolean archived, @jakarta.annotation.Nullable List<RecordingModeUser> recordingModes, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable WorkingTimeTypesSortColumn sortBy) throws RestClientException {
        return fetchWorkingTimeTypesWithHttpInfo(name, shortName, description, categories, subCategories, editUnits, archived, recordingModes, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List Working Time Types
     * Lists the Working Time Types the authenticated user or API token can access.
     * <p><b>200</b> - Page of Working Time Types.
     * <p><b>400</b> - Bad Request
     * @param name Only return entries whose name contains this text. (optional)
     * @param shortName filter by short name (optional)
     * @param description filter by description (optional)
     * @param categories filter by WorkingTimeTypeCategory (optional)
     * @param subCategories filter by WorkingTimeTypeSubCategory (optional)
     * @param editUnits filter by WorkingTimeType&#39;s DurationUnit (optional)
     * @param archived Only return entries that are archived (true) or not archived (false). (optional)
     * @param recordingModes filter entries bAWS on their RecordingMode (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to name)
     * @return ResponseEntity&lt;WorkingTimeTypesPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTimeTypesPage> fetchWorkingTimeTypesWithHttpInfo(@jakarta.annotation.Nullable String name, @jakarta.annotation.Nullable String shortName, @jakarta.annotation.Nullable String description, @jakarta.annotation.Nullable List<WorkingTimeTypeCategory> categories, @jakarta.annotation.Nullable List<WorkingTimeTypeSubCategory> subCategories, @jakarta.annotation.Nullable List<DurationUnit> editUnits, @jakarta.annotation.Nullable Boolean archived, @jakarta.annotation.Nullable List<RecordingModeUser> recordingModes, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable WorkingTimeTypesSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

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
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<WorkingTimeTypesPage> localReturnType = new ParameterizedTypeReference<WorkingTimeTypesPage>() {};
        return apiClient.invokeAPI("/working-time-types", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a Working Time Type
     * Returns a single Working Time Type by its ID.
     * <p><b>200</b> - The requested Working Time Type.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time Type. (required)
     * @return WorkingTimeType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WorkingTimeType getWorkingTimeType(@jakarta.annotation.Nonnull String id) throws RestClientException {
        return getWorkingTimeTypeWithHttpInfo(id).getBody();
    }

    /**
     * Get a Working Time Type
     * Returns a single Working Time Type by its ID.
     * <p><b>200</b> - The requested Working Time Type.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Working Time Type. (required)
     * @return ResponseEntity&lt;WorkingTimeType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkingTimeType> getWorkingTimeTypeWithHttpInfo(@jakarta.annotation.Nonnull String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getWorkingTimeType");
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

        ParameterizedTypeReference<WorkingTimeType> localReturnType = new ParameterizedTypeReference<WorkingTimeType>() {};
        return apiClient.invokeAPI("/working-time-types/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        return apiClient.invokeAPI(localVarPath, method, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, returnType);
    }
}
