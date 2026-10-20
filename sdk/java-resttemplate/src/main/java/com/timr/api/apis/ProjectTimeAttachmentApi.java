package com.timr.api.apis;

import com.timr.api.ApiClient;
import com.timr.api.BaseApi;

import com.timr.api.models.Attachment;
import com.timr.api.models.AttachmentMetadata;
import com.timr.api.models.AttachmentUploadResponse;
import com.timr.api.models.AttachmentsPage;
import com.timr.api.models.AttachmentsSortColumn;
import com.timr.api.models.Error;
import com.timr.api.models.SortDirection;
import java.net.URI;
import java.util.UUID;

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
@Component("com.timr.api.apis.ProjectTimeAttachmentApi")
public class ProjectTimeAttachmentApi extends BaseApi {

    public ProjectTimeAttachmentApi() {
        super(new ApiClient());
    }

    @Autowired
    public ProjectTimeAttachmentApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Upload a Project Time Attachment
     * Registers the upload of a single file to a running or completed Project Time and returns a pre-signed URL to upload it to. Upload the file with a PUT request to &#x60;upload.url&#x60;, sending exactly the headers in &#x60;upload.headers&#x60;, before &#x60;upload.expires_at&#x60;. The attachment is only returned by the other endpoints once its upload has completed. Uploads that are not completed are discarded automatically. Only images can be uploaded, and the size of a file and the number of attachments per Project Time are limited. 
     * <p><b>201</b> - The registered upload with the URL to upload the file to.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time. (required)
     * @param attachmentMetadata Metadata of the file to upload. (required)
     * @return AttachmentUploadResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AttachmentUploadResponse createProjectTimeAttachment(@jakarta.annotation.Nonnull String projectTimeId, @jakarta.annotation.Nonnull AttachmentMetadata attachmentMetadata) throws RestClientException {
        return createProjectTimeAttachmentWithHttpInfo(projectTimeId, attachmentMetadata).getBody();
    }

    /**
     * Upload a Project Time Attachment
     * Registers the upload of a single file to a running or completed Project Time and returns a pre-signed URL to upload it to. Upload the file with a PUT request to &#x60;upload.url&#x60;, sending exactly the headers in &#x60;upload.headers&#x60;, before &#x60;upload.expires_at&#x60;. The attachment is only returned by the other endpoints once its upload has completed. Uploads that are not completed are discarded automatically. Only images can be uploaded, and the size of a file and the number of attachments per Project Time are limited. 
     * <p><b>201</b> - The registered upload with the URL to upload the file to.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time. (required)
     * @param attachmentMetadata Metadata of the file to upload. (required)
     * @return ResponseEntity&lt;AttachmentUploadResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AttachmentUploadResponse> createProjectTimeAttachmentWithHttpInfo(@jakarta.annotation.Nonnull String projectTimeId, @jakarta.annotation.Nonnull AttachmentMetadata attachmentMetadata) throws RestClientException {
        Object localVarPostBody = attachmentMetadata;
        
        // verify the required parameter 'projectTimeId' is set
        if (projectTimeId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'projectTimeId' when calling createProjectTimeAttachment");
        }
        
        // verify the required parameter 'attachmentMetadata' is set
        if (attachmentMetadata == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'attachmentMetadata' when calling createProjectTimeAttachment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("project_time_id", projectTimeId);

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

        ParameterizedTypeReference<AttachmentUploadResponse> localReturnType = new ParameterizedTypeReference<AttachmentUploadResponse>() {};
        return apiClient.invokeAPI("/project-times/{project_time_id}/attachments", HttpMethod.POST, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a Project Time Attachment
     * Deletes a single attachment of a running or completed Project Time. Only attachments whose upload has completed are found. Attachments of a completed Project Time can only be deleted while its status is &#x60;changeable&#x60;. 
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>422</b> - Unprocessable Content
     * @param projectTimeId ID of the Project Time. (required)
     * @param attachmentId ID of the Project Time Attachment. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteProjectTimeAttachment(@jakarta.annotation.Nonnull String projectTimeId, @jakarta.annotation.Nonnull UUID attachmentId) throws RestClientException {
        deleteProjectTimeAttachmentWithHttpInfo(projectTimeId, attachmentId);
    }

    /**
     * Delete a Project Time Attachment
     * Deletes a single attachment of a running or completed Project Time. Only attachments whose upload has completed are found. Attachments of a completed Project Time can only be deleted while its status is &#x60;changeable&#x60;. 
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>422</b> - Unprocessable Content
     * @param projectTimeId ID of the Project Time. (required)
     * @param attachmentId ID of the Project Time Attachment. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteProjectTimeAttachmentWithHttpInfo(@jakarta.annotation.Nonnull String projectTimeId, @jakarta.annotation.Nonnull UUID attachmentId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'projectTimeId' is set
        if (projectTimeId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'projectTimeId' when calling deleteProjectTimeAttachment");
        }
        
        // verify the required parameter 'attachmentId' is set
        if (attachmentId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'attachmentId' when calling deleteProjectTimeAttachment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("project_time_id", projectTimeId);
        uriVariables.put("attachment_id", attachmentId);

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
        return apiClient.invokeAPI("/project-times/{project_time_id}/attachments/{attachment_id}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List Project Time Attachments
     * Lists the attachments of a running or completed Project Time whose upload has completed. 
     * <p><b>200</b> - Page of Project Time Attachments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time. (required)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to uploaded_at)
     * @return AttachmentsPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AttachmentsPage fetchProjectTimeAttachments(@jakarta.annotation.Nonnull String projectTimeId, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable AttachmentsSortColumn sortBy) throws RestClientException {
        return fetchProjectTimeAttachmentsWithHttpInfo(projectTimeId, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List Project Time Attachments
     * Lists the attachments of a running or completed Project Time whose upload has completed. 
     * <p><b>200</b> - Page of Project Time Attachments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time. (required)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to uploaded_at)
     * @return ResponseEntity&lt;AttachmentsPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AttachmentsPage> fetchProjectTimeAttachmentsWithHttpInfo(@jakarta.annotation.Nonnull String projectTimeId, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable AttachmentsSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'projectTimeId' is set
        if (projectTimeId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'projectTimeId' when calling fetchProjectTimeAttachments");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("project_time_id", projectTimeId);

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

        ParameterizedTypeReference<AttachmentsPage> localReturnType = new ParameterizedTypeReference<AttachmentsPage>() {};
        return apiClient.invokeAPI("/project-times/{project_time_id}/attachments", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a Project Time Attachment
     * Returns a single attachment of a running or completed Project Time. Only attachments whose upload has completed are found. 
     * <p><b>200</b> - The requested Project Time Attachment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time. (required)
     * @param attachmentId ID of the Project Time Attachment. (required)
     * @return Attachment
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Attachment getProjectTimeAttachment(@jakarta.annotation.Nonnull String projectTimeId, @jakarta.annotation.Nonnull UUID attachmentId) throws RestClientException {
        return getProjectTimeAttachmentWithHttpInfo(projectTimeId, attachmentId).getBody();
    }

    /**
     * Get a Project Time Attachment
     * Returns a single attachment of a running or completed Project Time. Only attachments whose upload has completed are found. 
     * <p><b>200</b> - The requested Project Time Attachment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time. (required)
     * @param attachmentId ID of the Project Time Attachment. (required)
     * @return ResponseEntity&lt;Attachment&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Attachment> getProjectTimeAttachmentWithHttpInfo(@jakarta.annotation.Nonnull String projectTimeId, @jakarta.annotation.Nonnull UUID attachmentId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'projectTimeId' is set
        if (projectTimeId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'projectTimeId' when calling getProjectTimeAttachment");
        }
        
        // verify the required parameter 'attachmentId' is set
        if (attachmentId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'attachmentId' when calling getProjectTimeAttachment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("project_time_id", projectTimeId);
        uriVariables.put("attachment_id", attachmentId);

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

        ParameterizedTypeReference<Attachment> localReturnType = new ParameterizedTypeReference<Attachment>() {};
        return apiClient.invokeAPI("/project-times/{project_time_id}/attachments/{attachment_id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
