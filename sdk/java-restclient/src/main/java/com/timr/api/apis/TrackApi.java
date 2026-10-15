package com.timr.api.apis;

import com.timr.api.ApiClient;

import com.timr.api.models.Error;
import com.timr.api.models.Waypoint;

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
public class TrackApi {
    private ApiClient apiClient;

    public TrackApi() {
        this(new ApiClient());
    }

    public TrackApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a Drive Log&#39;s Track
     * Stores a Track for the Drive Log from the waypoints in the request body. A Drive Log holds at most one Track.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id drive log id
     * @param waypoint Working Time Date Span entity
     * @return List&lt;Waypoint&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createTrackRequestCreation(String id, List<Waypoint> waypoint) throws RestClientResponseException {
        Object postBody = waypoint;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling createTrack", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'waypoint' is set
        if (waypoint == null) {
            throw new RestClientResponseException("Missing the required parameter 'waypoint' when calling createTrack", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<List<Waypoint>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/drive-logs/{id}/track", HttpMethod.POST, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a Drive Log&#39;s Track
     * Stores a Track for the Drive Log from the waypoints in the request body. A Drive Log holds at most one Track.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id drive log id
     * @param waypoint Working Time Date Span entity
     * @return List&lt;Waypoint&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public List<Waypoint> createTrack(String id, List<Waypoint> waypoint) throws RestClientResponseException {
        ParameterizedTypeReference<List<Waypoint>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createTrackRequestCreation(id, waypoint).body(localVarReturnType);
    }

    /**
     * Create a Drive Log&#39;s Track
     * Stores a Track for the Drive Log from the waypoints in the request body. A Drive Log holds at most one Track.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id drive log id
     * @param waypoint Working Time Date Span entity
     * @return ResponseEntity&lt;List&lt;Waypoint&gt;&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Waypoint>> createTrackWithHttpInfo(String id, List<Waypoint> waypoint) throws RestClientResponseException {
        ParameterizedTypeReference<List<Waypoint>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createTrackRequestCreation(id, waypoint).toEntity(localVarReturnType);
    }

    /**
     * Create a Drive Log&#39;s Track
     * Stores a Track for the Drive Log from the waypoints in the request body. A Drive Log holds at most one Track.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id drive log id
     * @param waypoint Working Time Date Span entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createTrackWithResponseSpec(String id, List<Waypoint> waypoint) throws RestClientResponseException {
        return createTrackRequestCreation(id, waypoint);
    }

    /**
     * Delete a Drive Log&#39;s Track
     * Deletes the Drive Log&#39;s Track. The Drive Log itself is kept.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id drive log id
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteTrackRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling deleteTrack", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<>();
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
        return apiClient.invokeAPI("/drive-logs/{id}/track", HttpMethod.DELETE, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Drive Log&#39;s Track
     * Deletes the Drive Log&#39;s Track. The Drive Log itself is kept.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id drive log id
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void deleteTrack(String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        deleteTrackRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Delete a Drive Log&#39;s Track
     * Deletes the Drive Log&#39;s Track. The Drive Log itself is kept.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id drive log id
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTrackWithHttpInfo(String id) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return deleteTrackRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Delete a Drive Log&#39;s Track
     * Deletes the Drive Log&#39;s Track. The Drive Log itself is kept.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id drive log id
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteTrackWithResponseSpec(String id) throws RestClientResponseException {
        return deleteTrackRequestCreation(id);
    }

    /**
     * Get a Drive Log&#39;s Track
     * Returns the recorded Track of the Drive Log. Responds with 404 when no Track was recorded.
     * <p><b>200</b> - The Track of the Drive Log.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id drive log id
     * @return List&lt;Waypoint&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getTrackRequestCreation(String id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling getTrack", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<List<Waypoint>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/drive-logs/{id}/track", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Drive Log&#39;s Track
     * Returns the recorded Track of the Drive Log. Responds with 404 when no Track was recorded.
     * <p><b>200</b> - The Track of the Drive Log.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id drive log id
     * @return List&lt;Waypoint&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public List<Waypoint> getTrack(String id) throws RestClientResponseException {
        ParameterizedTypeReference<List<Waypoint>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTrackRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Get a Drive Log&#39;s Track
     * Returns the recorded Track of the Drive Log. Responds with 404 when no Track was recorded.
     * <p><b>200</b> - The Track of the Drive Log.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id drive log id
     * @return ResponseEntity&lt;List&lt;Waypoint&gt;&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Waypoint>> getTrackWithHttpInfo(String id) throws RestClientResponseException {
        ParameterizedTypeReference<List<Waypoint>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTrackRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get a Drive Log&#39;s Track
     * Returns the recorded Track of the Drive Log. Responds with 404 when no Track was recorded.
     * <p><b>200</b> - The Track of the Drive Log.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id drive log id
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getTrackWithResponseSpec(String id) throws RestClientResponseException {
        return getTrackRequestCreation(id);
    }

    /**
     * Replace a Drive Log&#39;s Track
     * Replaces the Drive Log&#39;s Track with the waypoints in the request body.
     * <p><b>200</b> - The updated Working Time Date Span.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id drive log id
     * @param waypoint working time date span entity
     * @return List&lt;Waypoint&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateTrackRequestCreation(String id, List<Waypoint> waypoint) throws RestClientResponseException {
        Object postBody = waypoint;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling updateTrack", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'waypoint' is set
        if (waypoint == null) {
            throw new RestClientResponseException("Missing the required parameter 'waypoint' when calling updateTrack", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "OAuth2", "OAuth2" };

        ParameterizedTypeReference<List<Waypoint>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/drive-logs/{id}/track", HttpMethod.PUT, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Replace a Drive Log&#39;s Track
     * Replaces the Drive Log&#39;s Track with the waypoints in the request body.
     * <p><b>200</b> - The updated Working Time Date Span.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id drive log id
     * @param waypoint working time date span entity
     * @return List&lt;Waypoint&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public List<Waypoint> updateTrack(String id, List<Waypoint> waypoint) throws RestClientResponseException {
        ParameterizedTypeReference<List<Waypoint>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateTrackRequestCreation(id, waypoint).body(localVarReturnType);
    }

    /**
     * Replace a Drive Log&#39;s Track
     * Replaces the Drive Log&#39;s Track with the waypoints in the request body.
     * <p><b>200</b> - The updated Working Time Date Span.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id drive log id
     * @param waypoint working time date span entity
     * @return ResponseEntity&lt;List&lt;Waypoint&gt;&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Waypoint>> updateTrackWithHttpInfo(String id, List<Waypoint> waypoint) throws RestClientResponseException {
        ParameterizedTypeReference<List<Waypoint>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return updateTrackRequestCreation(id, waypoint).toEntity(localVarReturnType);
    }

    /**
     * Replace a Drive Log&#39;s Track
     * Replaces the Drive Log&#39;s Track with the waypoints in the request body.
     * <p><b>200</b> - The updated Working Time Date Span.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id drive log id
     * @param waypoint working time date span entity
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec updateTrackWithResponseSpec(String id, List<Waypoint> waypoint) throws RestClientResponseException {
        return updateTrackRequestCreation(id, waypoint);
    }
}
