package com.timr.api.apis;

import com.timr.api.ApiClient;
import com.timr.api.BaseApi;

import com.timr.api.models.Accounts;
import com.timr.api.models.Error;
import java.time.LocalDate;

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
@Component("com.timr.api.apis.TimeAccountApi")
public class TimeAccountApi extends BaseApi {

    public TimeAccountApi() {
        super(new ApiClient());
    }

    @Autowired
    public TimeAccountApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Get a User&#39;s accounts
     * Returns all of the User&#39;s account balances as of the specified date. The calculation starts from the **most recent balance before or on the specified date**. If the specified date is itself a balance date, the stored balance is returned unchanged.  If the specified date does not fall on a balance date, timr uses the **most recent balance before the specified date** as the starting point and recalculates the account balances up to the requested date using the recorded actual times and the applicable target working time.  **Important:** The target working time is calculated using the User&#39;s **currently assigned Work Schedule Model**, not necessarily the model that was assigned on the requested historical date.  If the User&#39;s Work Schedule Model has changed, this endpoint should therefore only be used with dates **on or after the most recent Work Schedule Model change**. Requests for earlier dates may return incorrect target working times and therefore incorrect account balances.  &#x60;last_balance_date&#x60; identifies the balance entry preceding the returned period, including when the requested date is itself a balance date. It is null for the initialization date itself.
     * <p><b>200</b> - The User&#39;s account balances on the given day.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User. (required)
     * @param date Day to return the balances for. (required)
     * @return Accounts
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Accounts getUserAccounts(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull LocalDate date) throws RestClientException {
        return getUserAccountsWithHttpInfo(id, date).getBody();
    }

    /**
     * Get a User&#39;s accounts
     * Returns all of the User&#39;s account balances as of the specified date. The calculation starts from the **most recent balance before or on the specified date**. If the specified date is itself a balance date, the stored balance is returned unchanged.  If the specified date does not fall on a balance date, timr uses the **most recent balance before the specified date** as the starting point and recalculates the account balances up to the requested date using the recorded actual times and the applicable target working time.  **Important:** The target working time is calculated using the User&#39;s **currently assigned Work Schedule Model**, not necessarily the model that was assigned on the requested historical date.  If the User&#39;s Work Schedule Model has changed, this endpoint should therefore only be used with dates **on or after the most recent Work Schedule Model change**. Requests for earlier dates may return incorrect target working times and therefore incorrect account balances.  &#x60;last_balance_date&#x60; identifies the balance entry preceding the returned period, including when the requested date is itself a balance date. It is null for the initialization date itself.
     * <p><b>200</b> - The User&#39;s account balances on the given day.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the User. (required)
     * @param date Day to return the balances for. (required)
     * @return ResponseEntity&lt;Accounts&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Accounts> getUserAccountsWithHttpInfo(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull LocalDate date) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getUserAccounts");
        }
        
        // verify the required parameter 'date' is set
        if (date == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'date' when calling getUserAccounts");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("date", date);

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

        ParameterizedTypeReference<Accounts> localReturnType = new ParameterizedTypeReference<Accounts>() {};
        return apiClient.invokeAPI("/users/{id}/accounts/{date}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
