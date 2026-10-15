package com.timr.api.apis;

import com.timr.api.ApiClient;
import com.timr.api.BaseApi;

import com.timr.api.models.Error;
import com.timr.api.models.Waypoint;

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
@Component("com.timr.api.apis.TrackApi")
public class TrackApi extends BaseApi {

    public TrackApi() {
        super(new ApiClient());
    }

    @Autowired
    public TrackApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Create a Drive Log&#39;s Track
     * Stores a Track for the Drive Log from the waypoints in the request body. A Drive Log holds at most one Track.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id drive log id (required)
     * @param waypoint Working Time Date Span entity (required)
     * @return List&lt;Waypoint&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Waypoint> createTrack(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull List<Waypoint> waypoint) throws RestClientException {
        return createTrackWithHttpInfo(id, waypoint).getBody();
    }

    /**
     * Create a Drive Log&#39;s Track
     * Stores a Track for the Drive Log from the waypoints in the request body. A Drive Log holds at most one Track.
     * <p><b>201</b> - The created Working Time.
     * <p><b>400</b> - Bad Request
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id drive log id (required)
     * @param waypoint Working Time Date Span entity (required)
     * @return ResponseEntity&lt;List&lt;Waypoint&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Waypoint>> createTrackWithHttpInfo(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull List<Waypoint> waypoint) throws RestClientException {
        Object localVarPostBody = waypoint;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling createTrack");
        }
        
        // verify the required parameter 'waypoint' is set
        if (waypoint == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'waypoint' when calling createTrack");
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

        ParameterizedTypeReference<List<Waypoint>> localReturnType = new ParameterizedTypeReference<List<Waypoint>>() {};
        return apiClient.invokeAPI("/drive-logs/{id}/track", HttpMethod.POST, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a Drive Log&#39;s Track
     * Deletes the Drive Log&#39;s Track. The Drive Log itself is kept.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id drive log id (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteTrack(@jakarta.annotation.Nonnull String id) throws RestClientException {
        deleteTrackWithHttpInfo(id);
    }

    /**
     * Delete a Drive Log&#39;s Track
     * Deletes the Drive Log&#39;s Track. The Drive Log itself is kept.
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>409</b> - Conflict
     * @param id drive log id (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTrackWithHttpInfo(@jakarta.annotation.Nonnull String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteTrack");
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
        return apiClient.invokeAPI("/drive-logs/{id}/track", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a Drive Log&#39;s Track
     * Returns the recorded Track of the Drive Log. Responds with 404 when no Track was recorded.
     * <p><b>200</b> - The Track of the Drive Log.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id drive log id (required)
     * @return List&lt;Waypoint&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Waypoint> getTrack(@jakarta.annotation.Nonnull String id) throws RestClientException {
        return getTrackWithHttpInfo(id).getBody();
    }

    /**
     * Get a Drive Log&#39;s Track
     * Returns the recorded Track of the Drive Log. Responds with 404 when no Track was recorded.
     * <p><b>200</b> - The Track of the Drive Log.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param id drive log id (required)
     * @return ResponseEntity&lt;List&lt;Waypoint&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Waypoint>> getTrackWithHttpInfo(@jakarta.annotation.Nonnull String id) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getTrack");
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

        ParameterizedTypeReference<List<Waypoint>> localReturnType = new ParameterizedTypeReference<List<Waypoint>>() {};
        return apiClient.invokeAPI("/drive-logs/{id}/track", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Replace a Drive Log&#39;s Track
     * Replaces the Drive Log&#39;s Track with the waypoints in the request body.
     * <p><b>200</b> - The updated Working Time Date Span.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id drive log id (required)
     * @param waypoint working time date span entity (required)
     * @return List&lt;Waypoint&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Waypoint> updateTrack(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull List<Waypoint> waypoint) throws RestClientException {
        return updateTrackWithHttpInfo(id, waypoint).getBody();
    }

    /**
     * Replace a Drive Log&#39;s Track
     * Replaces the Drive Log&#39;s Track with the waypoints in the request body.
     * <p><b>200</b> - The updated Working Time Date Span.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>409</b> - Conflict
     * <p><b>422</b> - Unprocessable Content
     * @param id drive log id (required)
     * @param waypoint working time date span entity (required)
     * @return ResponseEntity&lt;List&lt;Waypoint&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Waypoint>> updateTrackWithHttpInfo(@jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull List<Waypoint> waypoint) throws RestClientException {
        Object localVarPostBody = waypoint;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateTrack");
        }
        
        // verify the required parameter 'waypoint' is set
        if (waypoint == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'waypoint' when calling updateTrack");
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

        ParameterizedTypeReference<List<Waypoint>> localReturnType = new ParameterizedTypeReference<List<Waypoint>>() {};
        return apiClient.invokeAPI("/drive-logs/{id}/track", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
