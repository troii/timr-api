package com.timr.api.apis;

import com.timr.api.ApiClient;
import com.timr.api.BaseApi;

import com.timr.api.models.Error;
import com.timr.api.models.SortDirection;
import java.net.URI;
import com.timr.api.models.WorkScheduleModel;
import com.timr.api.models.WorkScheduleModelSortColumn;
import com.timr.api.models.WorkScheduleModelsPage;

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
@Component("com.timr.api.apis.WorkScheduleModelApi")
public class WorkScheduleModelApi extends BaseApi {

    public WorkScheduleModelApi() {
        super(new ApiClient());
    }

    @Autowired
    public WorkScheduleModelApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Delete a Work Schedule Model
     * Deletes the Work Schedule Model. It cannot be deleted while it is still assigned to a User.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Work Schedule Model. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteWorkScheduleModel(@jakarta.annotation.Nonnull String id) throws RestClientException {
        deleteWorkScheduleModelWithHttpInfo(id);
    }

    /**
     * Delete a Work Schedule Model
     * Deletes the Work Schedule Model. It cannot be deleted while it is still assigned to a User.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id ID of the Work Schedule Model. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteWorkScheduleModelWithHttpInfo(@jakarta.annotation.Nonnull String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteWorkScheduleModel");
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
        return apiClient.invokeAPI("/work-schedule-models/{id}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List Work Schedule Models
     * Lists the Work Schedule Models the authenticated user or API token can access.
     * <p><b>200</b> - Page of Work Schedule Models.
     * <p><b>400</b> - Bad Request
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to name)
     * @return WorkScheduleModelsPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WorkScheduleModelsPage fetchWorkScheduleModels(@jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable WorkScheduleModelSortColumn sortBy) throws RestClientException {
        return fetchWorkScheduleModelsWithHttpInfo(pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List Work Schedule Models
     * Lists the Work Schedule Models the authenticated user or API token can access.
     * <p><b>200</b> - Page of Work Schedule Models.
     * <p><b>400</b> - Bad Request
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to name)
     * @return ResponseEntity&lt;WorkScheduleModelsPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkScheduleModelsPage> fetchWorkScheduleModelsWithHttpInfo(@jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable WorkScheduleModelSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

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

        ParameterizedTypeReference<WorkScheduleModelsPage> localReturnType = new ParameterizedTypeReference<WorkScheduleModelsPage>() {};
        return apiClient.invokeAPI("/work-schedule-models", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a Work Schedule Model
     * Returns a single Work Schedule Model by its ID.
     * <p><b>200</b> - The requested Work Schedule Model.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Work Schedule Model. (required)
     * @return WorkScheduleModel
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WorkScheduleModel getWorkScheduleModel(@jakarta.annotation.Nonnull String id) throws RestClientException {
        return getWorkScheduleModelWithHttpInfo(id).getBody();
    }

    /**
     * Get a Work Schedule Model
     * Returns a single Work Schedule Model by its ID.
     * <p><b>200</b> - The requested Work Schedule Model.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Work Schedule Model. (required)
     * @return ResponseEntity&lt;WorkScheduleModel&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WorkScheduleModel> getWorkScheduleModelWithHttpInfo(@jakarta.annotation.Nonnull String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getWorkScheduleModel");
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

        ParameterizedTypeReference<WorkScheduleModel> localReturnType = new ParameterizedTypeReference<WorkScheduleModel>() {};
        return apiClient.invokeAPI("/work-schedule-models/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
