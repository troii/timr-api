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
     * Returns all of the User&#39;s account balances as of the specified date. The calculation starts from the **most recent balance before or on the specified date**. If the specified date is itself a balance date, the stored balance is returned unchanged.  If the specified date does not fall on a balance date, timr uses the **most recent balance before the specified date** as the starting point and recalculates the account balances up to the requested date using the recorded actual times and the applicable target working time.  **Important:** The target working time is calculated using the User&#39;s **currently assigned Work Schedule Model**, not necessarily the model that was assigned on the requested historical date.  If the User&#39;s Work Schedule Model has changed, this endpoint should therefore only be used with dates **on or after the most recent Work Schedule Model change**. Requests for earlier dates may return incorrect target working times and therefore incorrect account balances.  &#x60;last_balance_date&#x60; identifies the balance entry preceding the returned period, including when the requested date is itself a balance date. It is null for the initialization date itself.
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
     * Returns all of the User&#39;s account balances as of the specified date. The calculation starts from the **most recent balance before or on the specified date**. If the specified date is itself a balance date, the stored balance is returned unchanged.  If the specified date does not fall on a balance date, timr uses the **most recent balance before the specified date** as the starting point and recalculates the account balances up to the requested date using the recorded actual times and the applicable target working time.  **Important:** The target working time is calculated using the User&#39;s **currently assigned Work Schedule Model**, not necessarily the model that was assigned on the requested historical date.  If the User&#39;s Work Schedule Model has changed, this endpoint should therefore only be used with dates **on or after the most recent Work Schedule Model change**. Requests for earlier dates may return incorrect target working times and therefore incorrect account balances.  &#x60;last_balance_date&#x60; identifies the balance entry preceding the returned period, including when the requested date is itself a balance date. It is null for the initialization date itself.
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
     * Returns all of the User&#39;s account balances as of the specified date. The calculation starts from the **most recent balance before or on the specified date**. If the specified date is itself a balance date, the stored balance is returned unchanged.  If the specified date does not fall on a balance date, timr uses the **most recent balance before the specified date** as the starting point and recalculates the account balances up to the requested date using the recorded actual times and the applicable target working time.  **Important:** The target working time is calculated using the User&#39;s **currently assigned Work Schedule Model**, not necessarily the model that was assigned on the requested historical date.  If the User&#39;s Work Schedule Model has changed, this endpoint should therefore only be used with dates **on or after the most recent Work Schedule Model change**. Requests for earlier dates may return incorrect target working times and therefore incorrect account balances.  &#x60;last_balance_date&#x60; identifies the balance entry preceding the returned period, including when the requested date is itself a balance date. It is null for the initialization date itself.
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
     * Returns all of the User&#39;s account balances as of the specified date. The calculation starts from the **most recent balance before or on the specified date**. If the specified date is itself a balance date, the stored balance is returned unchanged.  If the specified date does not fall on a balance date, timr uses the **most recent balance before the specified date** as the starting point and recalculates the account balances up to the requested date using the recorded actual times and the applicable target working time.  **Important:** The target working time is calculated using the User&#39;s **currently assigned Work Schedule Model**, not necessarily the model that was assigned on the requested historical date.  If the User&#39;s Work Schedule Model has changed, this endpoint should therefore only be used with dates **on or after the most recent Work Schedule Model change**. Requests for earlier dates may return incorrect target working times and therefore incorrect account balances.  &#x60;last_balance_date&#x60; identifies the balance entry preceding the returned period, including when the requested date is itself a balance date. It is null for the initialization date itself.
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
}
