package com.timr.api.apis;

import com.timr.api.ApiClient;
import com.timr.api.BaseApi;

import com.timr.api.models.Car;
import com.timr.api.models.CarCreate;
import com.timr.api.models.CarUpdate;
import com.timr.api.models.CarsPage;
import com.timr.api.models.CarsSortColumn;
import com.timr.api.models.Error;
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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.26.0")
@Component("com.timr.api.apis.CarApi")
public class CarApi extends BaseApi {

    public CarApi() {
        super(new ApiClient());
    }

    @Autowired
    public CarApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Create a Car
     * Creates a Car from the data in the request body.
     * <p><b>201</b> - The created Car.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param carCreate Car entity (required)
     * @return Car
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Car createCar(@jakarta.annotation.Nonnull CarCreate carCreate) throws RestClientException {
        return createCarWithHttpInfo(carCreate).getBody();
    }

    /**
     * Create a Car
     * Creates a Car from the data in the request body.
     * <p><b>201</b> - The created Car.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param carCreate Car entity (required)
     * @return ResponseEntity&lt;Car&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Car> createCarWithHttpInfo(@jakarta.annotation.Nonnull CarCreate carCreate) throws RestClientException {
        Object localVarPostBody = carCreate;
        
        // verify the required parameter 'carCreate' is set
        if (carCreate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'carCreate' when calling createCar");
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

        ParameterizedTypeReference<Car> localReturnType = new ParameterizedTypeReference<Car>() {};
        return apiClient.invokeAPI("/cars", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List Cars
     * Lists the Cars the authenticated user or API token can access.
     * <p><b>200</b> - Page of Cars.
     * <p><b>400</b> - Bad Request
     * @param nameOrPlate Only return Cars whose name or plate contains this text. (optional)
     * @param usable Only return Cars that are usable (true) or not usable (false). (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to name)
     * @return CarsPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CarsPage fetchCars(@jakarta.annotation.Nullable String nameOrPlate, @jakarta.annotation.Nullable Boolean usable, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable CarsSortColumn sortBy) throws RestClientException {
        return fetchCarsWithHttpInfo(nameOrPlate, usable, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List Cars
     * Lists the Cars the authenticated user or API token can access.
     * <p><b>200</b> - Page of Cars.
     * <p><b>400</b> - Bad Request
     * @param nameOrPlate Only return Cars whose name or plate contains this text. (optional)
     * @param usable Only return Cars that are usable (true) or not usable (false). (optional)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to name)
     * @return ResponseEntity&lt;CarsPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CarsPage> fetchCarsWithHttpInfo(@jakarta.annotation.Nullable String nameOrPlate, @jakarta.annotation.Nullable Boolean usable, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable CarsSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "name_or_plate", nameOrPlate));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "usable", usable));
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

        ParameterizedTypeReference<CarsPage> localReturnType = new ParameterizedTypeReference<CarsPage>() {};
        return apiClient.invokeAPI("/cars", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a Car
     * Returns a single Car by its ID.
     * <p><b>200</b> - The requested Car.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Car. (required)
     * @return Car
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Car getCar(@jakarta.annotation.Nonnull String id) throws RestClientException {
        return getCarWithHttpInfo(id).getBody();
    }

    /**
     * Get a Car
     * Returns a single Car by its ID.
     * <p><b>200</b> - The requested Car.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Car. (required)
     * @return ResponseEntity&lt;Car&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Car> getCarWithHttpInfo(@jakarta.annotation.Nonnull String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getCar");
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

        ParameterizedTypeReference<Car> localReturnType = new ParameterizedTypeReference<Car>() {};
        return apiClient.invokeAPI("/cars/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update a Car
     * Updates the Car with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Car.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Car. (required)
     * @param carUpdate Car entity (required)
     * @return Car
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Car updateCar(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull CarUpdate carUpdate) throws RestClientException {
        return updateCarWithHttpInfo(id, carUpdate).getBody();
    }

    /**
     * Update a Car
     * Updates the Car with the fields present in the request body. Fields that are omitted stay unchanged.
     * <p><b>200</b> - The updated Car.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id ID of the Car. (required)
     * @param carUpdate Car entity (required)
     * @return ResponseEntity&lt;Car&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Car> updateCarWithHttpInfo(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull CarUpdate carUpdate) throws RestClientException {
        Object localVarPostBody = carUpdate;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateCar");
        }
        
        // verify the required parameter 'carUpdate' is set
        if (carUpdate == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'carUpdate' when calling updateCar");
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

        ParameterizedTypeReference<Car> localReturnType = new ParameterizedTypeReference<Car>() {};
        return apiClient.invokeAPI("/cars/{id}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
