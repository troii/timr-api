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
@Component("com.timr.api.apis.TaskAttachmentApi")
public class TaskAttachmentApi extends BaseApi {

    public TaskAttachmentApi() {
        super(new ApiClient());
    }

    @Autowired
    public TaskAttachmentApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Upload a Task Attachment
     * Registers the upload of a single file to the Task and returns a pre-signed URL to upload it to. Upload the file with a PUT request to &#x60;upload.url&#x60;, sending exactly the headers in &#x60;upload.headers&#x60;, before &#x60;upload.expires_at&#x60;. The attachment is only returned by the other endpoints once its upload has completed. Uploads that are not completed are discarded automatically. The size of a file and the number of attachments per Task are limited. 
     * <p><b>201</b> - The registered upload with the URL to upload the file to.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task. (required)
     * @param attachmentMetadata Metadata of the file to upload. (required)
     * @return AttachmentUploadResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AttachmentUploadResponse createTaskAttachment(@jakarta.annotation.Nonnull String taskId, @jakarta.annotation.Nonnull AttachmentMetadata attachmentMetadata) throws RestClientException {
        return createTaskAttachmentWithHttpInfo(taskId, attachmentMetadata).getBody();
    }

    /**
     * Upload a Task Attachment
     * Registers the upload of a single file to the Task and returns a pre-signed URL to upload it to. Upload the file with a PUT request to &#x60;upload.url&#x60;, sending exactly the headers in &#x60;upload.headers&#x60;, before &#x60;upload.expires_at&#x60;. The attachment is only returned by the other endpoints once its upload has completed. Uploads that are not completed are discarded automatically. The size of a file and the number of attachments per Task are limited. 
     * <p><b>201</b> - The registered upload with the URL to upload the file to.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task. (required)
     * @param attachmentMetadata Metadata of the file to upload. (required)
     * @return ResponseEntity&lt;AttachmentUploadResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AttachmentUploadResponse> createTaskAttachmentWithHttpInfo(@jakarta.annotation.Nonnull String taskId, @jakarta.annotation.Nonnull AttachmentMetadata attachmentMetadata) throws RestClientException {
        Object localVarPostBody = attachmentMetadata;
        
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'taskId' when calling createTaskAttachment");
        }
        
        // verify the required parameter 'attachmentMetadata' is set
        if (attachmentMetadata == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'attachmentMetadata' when calling createTaskAttachment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("task_id", taskId);

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
        return apiClient.invokeAPI("/tasks/{task_id}/attachments", HttpMethod.POST, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a Task Attachment
     * Deletes a single attachment of the Task. Only attachments whose upload has completed and that are attached directly to the Task are found; an attachment of a parent Task has to be deleted on the parent Task itself. 
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task. (required)
     * @param attachmentId ID of the Task Attachment. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteTaskAttachment(@jakarta.annotation.Nonnull String taskId, @jakarta.annotation.Nonnull UUID attachmentId) throws RestClientException {
        deleteTaskAttachmentWithHttpInfo(taskId, attachmentId);
    }

    /**
     * Delete a Task Attachment
     * Deletes a single attachment of the Task. Only attachments whose upload has completed and that are attached directly to the Task are found; an attachment of a parent Task has to be deleted on the parent Task itself. 
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task. (required)
     * @param attachmentId ID of the Task Attachment. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTaskAttachmentWithHttpInfo(@jakarta.annotation.Nonnull String taskId, @jakarta.annotation.Nonnull UUID attachmentId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'taskId' when calling deleteTaskAttachment");
        }
        
        // verify the required parameter 'attachmentId' is set
        if (attachmentId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'attachmentId' when calling deleteTaskAttachment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("task_id", taskId);
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
        return apiClient.invokeAPI("/tasks/{task_id}/attachments/{attachment_id}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List Task Attachments
     * Lists the attachments whose upload has completed. Only attachments attached directly to the Task are returned; attachments of parent Tasks are not included and have to be fetched from the parent Task itself. 
     * <p><b>200</b> - Page of Task Attachments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task. (required)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to uploaded_at)
     * @return AttachmentsPage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AttachmentsPage fetchTaskAttachments(@jakarta.annotation.Nonnull String taskId, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable AttachmentsSortColumn sortBy) throws RestClientException {
        return fetchTaskAttachmentsWithHttpInfo(taskId, pageToken, limit, sortDirection, sortBy).getBody();
    }

    /**
     * List Task Attachments
     * Lists the attachments whose upload has completed. Only attachments attached directly to the Task are returned; attachments of parent Tasks are not included and have to be fetched from the parent Task itself. 
     * <p><b>200</b> - Page of Task Attachments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task. (required)
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response. (optional)
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500. (optional, default to 20)
     * @param sortDirection Direction to sort the entries in. (optional, default to asc)
     * @param sortBy Property to sort the entries by. (optional, default to uploaded_at)
     * @return ResponseEntity&lt;AttachmentsPage&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AttachmentsPage> fetchTaskAttachmentsWithHttpInfo(@jakarta.annotation.Nonnull String taskId, @jakarta.annotation.Nullable String pageToken, @jakarta.annotation.Nullable Integer limit, @jakarta.annotation.Nullable SortDirection sortDirection, @jakarta.annotation.Nullable AttachmentsSortColumn sortBy) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'taskId' when calling fetchTaskAttachments");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("task_id", taskId);

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
        return apiClient.invokeAPI("/tasks/{task_id}/attachments", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a Task Attachment
     * Returns a single attachment of the Task. Only attachments whose upload has completed and that are attached directly to the Task are found; an attachment of a parent Task has to be fetched from the parent Task itself. 
     * <p><b>200</b> - The requested Task Attachment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task. (required)
     * @param attachmentId ID of the Task Attachment. (required)
     * @return Attachment
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Attachment getTaskAttachment(@jakarta.annotation.Nonnull String taskId, @jakarta.annotation.Nonnull UUID attachmentId) throws RestClientException {
        return getTaskAttachmentWithHttpInfo(taskId, attachmentId).getBody();
    }

    /**
     * Get a Task Attachment
     * Returns a single attachment of the Task. Only attachments whose upload has completed and that are attached directly to the Task are found; an attachment of a parent Task has to be fetched from the parent Task itself. 
     * <p><b>200</b> - The requested Task Attachment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task. (required)
     * @param attachmentId ID of the Task Attachment. (required)
     * @return ResponseEntity&lt;Attachment&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Attachment> getTaskAttachmentWithHttpInfo(@jakarta.annotation.Nonnull String taskId, @jakarta.annotation.Nonnull UUID attachmentId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'taskId' when calling getTaskAttachment");
        }
        
        // verify the required parameter 'attachmentId' is set
        if (attachmentId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'attachmentId' when calling getTaskAttachment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("task_id", taskId);
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
        return apiClient.invokeAPI("/tasks/{task_id}/attachments/{attachment_id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
