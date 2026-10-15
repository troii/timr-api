package com.timr.api.apis;

import com.timr.api.ApiClient;

import com.timr.api.models.Error;
import com.timr.api.models.HolidayCalendarPartial;
import com.timr.api.models.HolidayCalendarsPage;
import com.timr.api.models.HolidayCalendarsSortColumn;
import com.timr.api.models.HolidaysPage;
import com.timr.api.models.HolidaysSortColumn;
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
public class HolidayCalendarApi {
    private ApiClient apiClient;

    public HolidayCalendarApi() {
        this(new ApiClient());
    }

    public HolidayCalendarApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List Holiday Calendars
     * Lists the Holiday Calendars the authenticated user or API token can access.
     * <p><b>200</b> - Page of Holiday Calendars.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return HolidayCalendarsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchHolidayCalendarsRequestCreation(@Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable HolidayCalendarsSortColumn sortBy) throws RestClientResponseException {
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

        ParameterizedTypeReference<HolidayCalendarsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/holiday-calendars", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Holiday Calendars
     * Lists the Holiday Calendars the authenticated user or API token can access.
     * <p><b>200</b> - Page of Holiday Calendars.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return HolidayCalendarsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public HolidayCalendarsPage fetchHolidayCalendars(@Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable HolidayCalendarsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<HolidayCalendarsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchHolidayCalendarsRequestCreation(pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Holiday Calendars
     * Lists the Holiday Calendars the authenticated user or API token can access.
     * <p><b>200</b> - Page of Holiday Calendars.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;HolidayCalendarsPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<HolidayCalendarsPage> fetchHolidayCalendarsWithHttpInfo(@Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable HolidayCalendarsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<HolidayCalendarsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchHolidayCalendarsRequestCreation(pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Holiday Calendars
     * Lists the Holiday Calendars the authenticated user or API token can access.
     * <p><b>200</b> - Page of Holiday Calendars.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchHolidayCalendarsWithResponseSpec(@Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable HolidayCalendarsSortColumn sortBy) throws RestClientResponseException {
        return fetchHolidayCalendarsRequestCreation(pageToken, limit, sortDirection, sortBy);
    }

    /**
     * List Holidays
     * Lists the Holidays in the Holiday Calendar.
     * <p><b>200</b> - Page of Holidays in the Holiday Calendar.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Holiday Calendar.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return HolidaysPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchHolidaysRequestCreation(String id, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable HolidaysSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling fetchHolidays", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

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

        ParameterizedTypeReference<HolidaysPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/holiday-calendars/{id}/holidays", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Holidays
     * Lists the Holidays in the Holiday Calendar.
     * <p><b>200</b> - Page of Holidays in the Holiday Calendar.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Holiday Calendar.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return HolidaysPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public HolidaysPage fetchHolidays(String id, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable HolidaysSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<HolidaysPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchHolidaysRequestCreation(id, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Holidays
     * Lists the Holidays in the Holiday Calendar.
     * <p><b>200</b> - Page of Holidays in the Holiday Calendar.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Holiday Calendar.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;HolidaysPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<HolidaysPage> fetchHolidaysWithHttpInfo(String id, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable HolidaysSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<HolidaysPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchHolidaysRequestCreation(id, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Holidays
     * Lists the Holidays in the Holiday Calendar.
     * <p><b>200</b> - Page of Holidays in the Holiday Calendar.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Holiday Calendar.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchHolidaysWithResponseSpec(String id, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable HolidaysSortColumn sortBy) throws RestClientResponseException {
        return fetchHolidaysRequestCreation(id, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * Get a Holiday Calendar
     * Returns a single Holiday Calendar by its ID.
     * <p><b>200</b> - The requested Holiday Calendar.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Holiday Calendar.
     * @return HolidayCalendarPartial
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getHolidayCalendarRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling getHolidayCalendar", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<HolidayCalendarPartial> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/holiday-calendars/{id}", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Holiday Calendar
     * Returns a single Holiday Calendar by its ID.
     * <p><b>200</b> - The requested Holiday Calendar.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Holiday Calendar.
     * @return HolidayCalendarPartial
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public HolidayCalendarPartial getHolidayCalendar(String id) throws RestClientResponseException {
        ParameterizedTypeReference<HolidayCalendarPartial> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getHolidayCalendarRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Get a Holiday Calendar
     * Returns a single Holiday Calendar by its ID.
     * <p><b>200</b> - The requested Holiday Calendar.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Holiday Calendar.
     * @return ResponseEntity&lt;HolidayCalendarPartial&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<HolidayCalendarPartial> getHolidayCalendarWithHttpInfo(String id) throws RestClientResponseException {
        ParameterizedTypeReference<HolidayCalendarPartial> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getHolidayCalendarRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get a Holiday Calendar
     * Returns a single Holiday Calendar by its ID.
     * <p><b>200</b> - The requested Holiday Calendar.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id ID of the Holiday Calendar.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getHolidayCalendarWithResponseSpec(String id) throws RestClientResponseException {
        return getHolidayCalendarRequestCreation(id);
    }
}
