package com.timr.api.apis;

import com.timr.api.ApiClient;

import com.timr.api.models.DriveLogCategoriesPage;
import com.timr.api.models.DriveLogCategoriesSortColumn;
import com.timr.api.models.DriveLogCategory;
import com.timr.api.models.Error;
import org.jspecify.annotations.Nullable;
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
public class DriveLogCategoryApi {
    private ApiClient apiClient;

    public DriveLogCategoryApi() {
        this(new ApiClient());
    }

    public DriveLogCategoryApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List Drive Log Categories
     * Lists the Drive Log Categories the authenticated user or API token can access.
     * <p><b>200</b> - Page of Drive Log Categories.
     * <p><b>400</b> - Bad Request
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return DriveLogCategoriesPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchDriveLogCategoriesRequestCreation(@Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable DriveLogCategoriesSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

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

        ParameterizedTypeReference<DriveLogCategoriesPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/drive-log-categories", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Drive Log Categories
     * Lists the Drive Log Categories the authenticated user or API token can access.
     * <p><b>200</b> - Page of Drive Log Categories.
     * <p><b>400</b> - Bad Request
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return DriveLogCategoriesPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public DriveLogCategoriesPage fetchDriveLogCategories(@Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable DriveLogCategoriesSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<DriveLogCategoriesPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchDriveLogCategoriesRequestCreation(pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Drive Log Categories
     * Lists the Drive Log Categories the authenticated user or API token can access.
     * <p><b>200</b> - Page of Drive Log Categories.
     * <p><b>400</b> - Bad Request
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;DriveLogCategoriesPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DriveLogCategoriesPage> fetchDriveLogCategoriesWithHttpInfo(@Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable DriveLogCategoriesSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<DriveLogCategoriesPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchDriveLogCategoriesRequestCreation(pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Drive Log Categories
     * Lists the Drive Log Categories the authenticated user or API token can access.
     * <p><b>200</b> - Page of Drive Log Categories.
     * <p><b>400</b> - Bad Request
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchDriveLogCategoriesWithResponseSpec(@Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable DriveLogCategoriesSortColumn sortBy) throws RestClientResponseException {
        return fetchDriveLogCategoriesRequestCreation(pageToken, limit, sortDirection, sortBy);
    }

    /**
     * Get a Drive Log Category
     * Returns a single Drive Log Category by its ID.
     * <p><b>200</b> - The requested Drive Log Category.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Drive Log Category.
     * @return DriveLogCategory
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getDriveLogCategoryRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling getDriveLogCategory", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<DriveLogCategory> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/drive-log-categories/{id}", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Drive Log Category
     * Returns a single Drive Log Category by its ID.
     * <p><b>200</b> - The requested Drive Log Category.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Drive Log Category.
     * @return DriveLogCategory
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public DriveLogCategory getDriveLogCategory(String id) throws RestClientResponseException {
        ParameterizedTypeReference<DriveLogCategory> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getDriveLogCategoryRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Get a Drive Log Category
     * Returns a single Drive Log Category by its ID.
     * <p><b>200</b> - The requested Drive Log Category.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Drive Log Category.
     * @return ResponseEntity&lt;DriveLogCategory&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<DriveLogCategory> getDriveLogCategoryWithHttpInfo(String id) throws RestClientResponseException {
        ParameterizedTypeReference<DriveLogCategory> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getDriveLogCategoryRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get a Drive Log Category
     * Returns a single Drive Log Category by its ID.
     * <p><b>200</b> - The requested Drive Log Category.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Drive Log Category.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getDriveLogCategoryWithResponseSpec(String id) throws RestClientResponseException {
        return getDriveLogCategoryRequestCreation(id);
    }
}
