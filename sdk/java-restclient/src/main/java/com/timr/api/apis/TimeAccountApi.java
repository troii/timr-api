package com.timr.api.apis;

import com.timr.api.ApiClient;

import com.timr.api.models.Accounts;
import com.timr.api.models.Error;
import java.time.LocalDate;

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
public class TimeAccountApi {
    private ApiClient apiClient;

    public TimeAccountApi() {
        this(new ApiClient());
    }

    public TimeAccountApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get a User&#39;s accounts
     * Returns all of the User&#39;s account balances as of the given day, including overtime and surcharge accounts.
     * <p><b>200</b> - The User&#39;s account balances on the given day.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User.
     * @param date Day to return the balances for.
     * @return Accounts
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getUserAccountsRequestCreation(String id, LocalDate date) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling getUserAccounts", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'date' is set
        if (date == null) {
            throw new RestClientResponseException("Missing the required parameter 'date' when calling getUserAccounts", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);
        pathParams.put("date", date);

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

        ParameterizedTypeReference<Accounts> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/users/{id}/accounts/{date}", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a User&#39;s accounts
     * Returns all of the User&#39;s account balances as of the given day, including overtime and surcharge accounts.
     * <p><b>200</b> - The User&#39;s account balances on the given day.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User.
     * @param date Day to return the balances for.
     * @return Accounts
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public Accounts getUserAccounts(String id, LocalDate date) throws RestClientResponseException {
        ParameterizedTypeReference<Accounts> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getUserAccountsRequestCreation(id, date).body(localVarReturnType);
    }

    /**
     * Get a User&#39;s accounts
     * Returns all of the User&#39;s account balances as of the given day, including overtime and surcharge accounts.
     * <p><b>200</b> - The User&#39;s account balances on the given day.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User.
     * @param date Day to return the balances for.
     * @return ResponseEntity&lt;Accounts&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Accounts> getUserAccountsWithHttpInfo(String id, LocalDate date) throws RestClientResponseException {
        ParameterizedTypeReference<Accounts> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getUserAccountsRequestCreation(id, date).toEntity(localVarReturnType);
    }

    /**
     * Get a User&#39;s accounts
     * Returns all of the User&#39;s account balances as of the given day, including overtime and surcharge accounts.
     * <p><b>200</b> - The User&#39;s account balances on the given day.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User.
     * @param date Day to return the balances for.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getUserAccountsWithResponseSpec(String id, LocalDate date) throws RestClientResponseException {
        return getUserAccountsRequestCreation(id, date);
    }

    /**
     * Get a User&#39;s working time accounts
     * Returns the User&#39;s working time account balances as of the given day.
     * <p><b>200</b> - The User&#39;s working time account balances on the given day.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User.
     * @param date Day to return the balances for.
     * @return Accounts
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getUserWorkingTimeAccountsRequestCreation(String id, LocalDate date) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling getUserWorkingTimeAccounts", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'date' is set
        if (date == null) {
            throw new RestClientResponseException("Missing the required parameter 'date' when calling getUserWorkingTimeAccounts", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);
        pathParams.put("date", date);

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

        ParameterizedTypeReference<Accounts> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/users/{id}/working-time-accounts/{date}", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a User&#39;s working time accounts
     * Returns the User&#39;s working time account balances as of the given day.
     * <p><b>200</b> - The User&#39;s working time account balances on the given day.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User.
     * @param date Day to return the balances for.
     * @return Accounts
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public Accounts getUserWorkingTimeAccounts(String id, LocalDate date) throws RestClientResponseException {
        ParameterizedTypeReference<Accounts> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getUserWorkingTimeAccountsRequestCreation(id, date).body(localVarReturnType);
    }

    /**
     * Get a User&#39;s working time accounts
     * Returns the User&#39;s working time account balances as of the given day.
     * <p><b>200</b> - The User&#39;s working time account balances on the given day.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User.
     * @param date Day to return the balances for.
     * @return ResponseEntity&lt;Accounts&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Accounts> getUserWorkingTimeAccountsWithHttpInfo(String id, LocalDate date) throws RestClientResponseException {
        ParameterizedTypeReference<Accounts> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getUserWorkingTimeAccountsRequestCreation(id, date).toEntity(localVarReturnType);
    }

    /**
     * Get a User&#39;s working time accounts
     * Returns the User&#39;s working time account balances as of the given day.
     * <p><b>200</b> - The User&#39;s working time account balances on the given day.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User.
     * @param date Day to return the balances for.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getUserWorkingTimeAccountsWithResponseSpec(String id, LocalDate date) throws RestClientResponseException {
        return getUserWorkingTimeAccountsRequestCreation(id, date);
    }
}
