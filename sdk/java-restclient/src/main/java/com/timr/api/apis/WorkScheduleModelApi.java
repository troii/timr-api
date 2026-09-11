package com.timr.api.apis;

import com.timr.api.ApiClient;

import com.timr.api.models.Error;
import org.jspecify.annotations.Nullable;
import com.timr.api.models.SortDirection;
import java.net.URI;
import com.timr.api.models.WorkScheduleModel;
import com.timr.api.models.WorkScheduleModelSortColumn;
import com.timr.api.models.WorkScheduleModelsPage;

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
public class WorkScheduleModelApi {
    private ApiClient apiClient;

    public WorkScheduleModelApi() {
        this(new ApiClient());
    }

    public WorkScheduleModelApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Delete a Work Schedule Model
     * Deletes the Work Schedule Model. It cannot be deleted while it is still assigned to a User.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Work Schedule Model.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteWorkScheduleModelRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling deleteWorkScheduleModel", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        return apiClient.invokeAPI("/work-schedule-models/{id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Work Schedule Model
     * Deletes the Work Schedule Model. It cannot be deleted while it is still assigned to a User.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Work Schedule Model.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void deleteWorkScheduleModel( String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        deleteWorkScheduleModelRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Delete a Work Schedule Model
     * Deletes the Work Schedule Model. It cannot be deleted while it is still assigned to a User.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Work Schedule Model.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteWorkScheduleModelWithHttpInfo( String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return deleteWorkScheduleModelRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Delete a Work Schedule Model
     * Deletes the Work Schedule Model. It cannot be deleted while it is still assigned to a User.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Work Schedule Model.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteWorkScheduleModelWithResponseSpec(String id) throws RestClientResponseException {
        return deleteWorkScheduleModelRequestCreation(id);
    }

    /**
     * List Work Schedule Models
     * Lists the Work Schedule Models the authenticated user or API token can access.
     * <p><b>200</b> - Page of Work Schedule Models.
     * <p><b>400</b> - Bad Request
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return WorkScheduleModelsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchWorkScheduleModelsRequestCreation(@Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable WorkScheduleModelSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

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

        ParameterizedTypeReference<WorkScheduleModelsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/work-schedule-models", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Work Schedule Models
     * Lists the Work Schedule Models the authenticated user or API token can access.
     * <p><b>200</b> - Page of Work Schedule Models.
     * <p><b>400</b> - Bad Request
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return WorkScheduleModelsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public WorkScheduleModelsPage fetchWorkScheduleModels( String pageToken,  Integer limit,  SortDirection sortDirection,  WorkScheduleModelSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<WorkScheduleModelsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchWorkScheduleModelsRequestCreation(pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Work Schedule Models
     * Lists the Work Schedule Models the authenticated user or API token can access.
     * <p><b>200</b> - Page of Work Schedule Models.
     * <p><b>400</b> - Bad Request
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;WorkScheduleModelsPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkScheduleModelsPage> fetchWorkScheduleModelsWithHttpInfo( String pageToken,  Integer limit,  SortDirection sortDirection,  WorkScheduleModelSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<WorkScheduleModelsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchWorkScheduleModelsRequestCreation(pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Work Schedule Models
     * Lists the Work Schedule Models the authenticated user or API token can access.
     * <p><b>200</b> - Page of Work Schedule Models.
     * <p><b>400</b> - Bad Request
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchWorkScheduleModelsWithResponseSpec(@Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable WorkScheduleModelSortColumn sortBy) throws RestClientResponseException {
        return fetchWorkScheduleModelsRequestCreation(pageToken, limit, sortDirection, sortBy);
    }

    /**
     * Get a Work Schedule Model
     * Returns a single Work Schedule Model by its ID.
     * <p><b>200</b> - The requested Work Schedule Model.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Work Schedule Model.
     * @return WorkScheduleModel
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getWorkScheduleModelRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling getWorkScheduleModel", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<WorkScheduleModel> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/work-schedule-models/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Work Schedule Model
     * Returns a single Work Schedule Model by its ID.
     * <p><b>200</b> - The requested Work Schedule Model.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Work Schedule Model.
     * @return WorkScheduleModel
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public WorkScheduleModel getWorkScheduleModel( String id) throws RestClientResponseException {
        ParameterizedTypeReference<WorkScheduleModel> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getWorkScheduleModelRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Get a Work Schedule Model
     * Returns a single Work Schedule Model by its ID.
     * <p><b>200</b> - The requested Work Schedule Model.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Work Schedule Model.
     * @return ResponseEntity&lt;WorkScheduleModel&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkScheduleModel> getWorkScheduleModelWithHttpInfo( String id) throws RestClientResponseException {
        ParameterizedTypeReference<WorkScheduleModel> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getWorkScheduleModelRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get a Work Schedule Model
     * Returns a single Work Schedule Model by its ID.
     * <p><b>200</b> - The requested Work Schedule Model.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Work Schedule Model.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getWorkScheduleModelWithResponseSpec(String id) throws RestClientResponseException {
        return getWorkScheduleModelRequestCreation(id);
    }
}
