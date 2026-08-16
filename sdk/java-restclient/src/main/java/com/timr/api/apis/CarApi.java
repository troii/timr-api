package com.timr.api.apis;

import com.timr.api.ApiClient;

import com.timr.api.models.Car;
import com.timr.api.models.CarCreate;
import com.timr.api.models.CarUpdate;
import com.timr.api.models.CarsPage;
import com.timr.api.models.CarsSortColumn;
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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.22.0")
public class CarApi {
    private ApiClient apiClient;

    public CarApi() {
        this(new ApiClient());
    }

    public CarApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a Car
     * Creates a Car from the data in the request body.
     * <p><b>201</b> - The created Car.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param carCreate Car entity
     * @return Car
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createCarRequestCreation(CarCreate carCreate) throws RestClientResponseException {
        Object postBody = carCreate;
        // verify the required parameter 'carCreate' is set
        if (carCreate == null) {
            throw new RestClientResponseException("Missing the required parameter 'carCreate' when calling createCar", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<Car> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/cars", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Car
     * Creates a Car from the data in the request body.
     * <p><b>201</b> - The created Car.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param carCreate Car entity
     * @return Car
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public Car createCar( CarCreate carCreate) throws RestClientResponseException {
        ParameterizedTypeReference<Car> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createCarRequestCreation(carCreate).body(localVarReturnType);
    }

    /**
     * Create a Car
     * Creates a Car from the data in the request body.
     * <p><b>201</b> - The created Car.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param carCreate Car entity
     * @return ResponseEntity&lt;Car&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Car> createCarWithHttpInfo( CarCreate carCreate) throws RestClientResponseException {
        ParameterizedTypeReference<Car> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createCarRequestCreation(carCreate).toEntity(localVarReturnType);
    }

    /**
     * Create a Car
     * Creates a Car from the data in the request body.
     * <p><b>201</b> - The created Car.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param carCreate Car entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createCarWithResponseSpec(CarCreate carCreate) throws RestClientResponseException {
        return createCarRequestCreation(carCreate);
    }

    /**
     * List Cars
     * Lists the Cars the authenticated user or API token can access.
     * <p><b>200</b> - Page of Cars.
     * <p><b>400</b> - Bad Request
     * @param nameOrPlate Only return Cars whose name or plate contains this text.
     * @param usable Only return Cars that are usable (true) or not usable (false).
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return CarsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchCarsRequestCreation(@Nullable String nameOrPlate, @Nullable Boolean usable, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable CarsSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name_or_plate", nameOrPlate));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "usable", usable));
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

        ParameterizedTypeReference<CarsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/cars", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Cars
     * Lists the Cars the authenticated user or API token can access.
     * <p><b>200</b> - Page of Cars.
     * <p><b>400</b> - Bad Request
     * @param nameOrPlate Only return Cars whose name or plate contains this text.
     * @param usable Only return Cars that are usable (true) or not usable (false).
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return CarsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public CarsPage fetchCars( String nameOrPlate,  Boolean usable,  String pageToken,  Integer limit,  SortDirection sortDirection,  CarsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<CarsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchCarsRequestCreation(nameOrPlate, usable, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Cars
     * Lists the Cars the authenticated user or API token can access.
     * <p><b>200</b> - Page of Cars.
     * <p><b>400</b> - Bad Request
     * @param nameOrPlate Only return Cars whose name or plate contains this text.
     * @param usable Only return Cars that are usable (true) or not usable (false).
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;CarsPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CarsPage> fetchCarsWithHttpInfo( String nameOrPlate,  Boolean usable,  String pageToken,  Integer limit,  SortDirection sortDirection,  CarsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<CarsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchCarsRequestCreation(nameOrPlate, usable, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Cars
     * Lists the Cars the authenticated user or API token can access.
     * <p><b>200</b> - Page of Cars.
     * <p><b>400</b> - Bad Request
     * @param nameOrPlate Only return Cars whose name or plate contains this text.
     * @param usable Only return Cars that are usable (true) or not usable (false).
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchCarsWithResponseSpec(@Nullable String nameOrPlate, @Nullable Boolean usable, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable CarsSortColumn sortBy) throws RestClientResponseException {
        return fetchCarsRequestCreation(nameOrPlate, usable, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * Get a Car
     * Returns a single Car by its ID.
     * <p><b>200</b> - The requested Car.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Car.
     * @return Car
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getCarRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling getCar", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<Car> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/cars/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Car
     * Returns a single Car by its ID.
     * <p><b>200</b> - The requested Car.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Car.
     * @return Car
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public Car getCar( String id) throws RestClientResponseException {
        ParameterizedTypeReference<Car> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getCarRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Get a Car
     * Returns a single Car by its ID.
     * <p><b>200</b> - The requested Car.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Car.
     * @return ResponseEntity&lt;Car&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Car> getCarWithHttpInfo( String id) throws RestClientResponseException {
        ParameterizedTypeReference<Car> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getCarRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get a Car
     * Returns a single Car by its ID.
     * <p><b>200</b> - The requested Car.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Car.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getCarWithResponseSpec(String id) throws RestClientResponseException {
        return getCarRequestCreation(id);
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
     * @param id ID of the Car.
     * @param carUpdate Car entity
     * @return Car
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateCarRequestCreation(String id, CarUpdate carUpdate) throws RestClientResponseException {
        Object postBody = carUpdate;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling updateCar", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'carUpdate' is set
        if (carUpdate == null) {
            throw new RestClientResponseException("Missing the required parameter 'carUpdate' when calling updateCar", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<Car> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/cars/{id}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
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
     * @param id ID of the Car.
     * @param carUpdate Car entity
     * @return Car
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public Car updateCar( String id,  CarUpdate carUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<Car> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateCarRequestCreation(id, carUpdate).body(localVarReturnType);
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
     * @param id ID of the Car.
     * @param carUpdate Car entity
     * @return ResponseEntity&lt;Car&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Car> updateCarWithHttpInfo( String id,  CarUpdate carUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<Car> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateCarRequestCreation(id, carUpdate).toEntity(localVarReturnType);
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
     * @param id ID of the Car.
     * @param carUpdate Car entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateCarWithResponseSpec(String id, CarUpdate carUpdate) throws RestClientResponseException {
        return updateCarRequestCreation(id, carUpdate);
    }
}
