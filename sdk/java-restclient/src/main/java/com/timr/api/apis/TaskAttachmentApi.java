package com.timr.api.apis;

import com.timr.api.ApiClient;

import com.timr.api.models.Attachment;
import com.timr.api.models.AttachmentMetadata;
import com.timr.api.models.AttachmentUploadResponse;
import com.timr.api.models.AttachmentsPage;
import com.timr.api.models.AttachmentsSortColumn;
import com.timr.api.models.Error;
import org.jspecify.annotations.Nullable;
import com.timr.api.models.SortDirection;
import java.net.URI;
import java.util.UUID;

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
public class TaskAttachmentApi {
    private ApiClient apiClient;

    public TaskAttachmentApi() {
        this(new ApiClient());
    }

    public TaskAttachmentApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Upload a Task Attachment
     * Registers the upload of a single file to the Task and returns a pre-signed URL to upload it to. Upload the file with a PUT request to &#x60;upload.url&#x60;, sending exactly the headers in &#x60;upload.headers&#x60;, before &#x60;upload.expires_at&#x60;. The attachment is only returned by the other endpoints once its upload has completed. Uploads that are not completed are discarded automatically. The size of a file and the number of attachments per Task are limited. 
     * <p><b>201</b> - The registered upload with the URL to upload the file to.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param attachmentMetadata Metadata of the file to upload.
     * @return AttachmentUploadResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createTaskAttachmentRequestCreation(String taskId, AttachmentMetadata attachmentMetadata) throws RestClientResponseException {
        Object postBody = attachmentMetadata;
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskId' when calling createTaskAttachment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'attachmentMetadata' is set
        if (attachmentMetadata == null) {
            throw new RestClientResponseException("Missing the required parameter 'attachmentMetadata' when calling createTaskAttachment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("task_id", taskId);

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

        ParameterizedTypeReference<AttachmentUploadResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/attachments", HttpMethod.POST, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Upload a Task Attachment
     * Registers the upload of a single file to the Task and returns a pre-signed URL to upload it to. Upload the file with a PUT request to &#x60;upload.url&#x60;, sending exactly the headers in &#x60;upload.headers&#x60;, before &#x60;upload.expires_at&#x60;. The attachment is only returned by the other endpoints once its upload has completed. Uploads that are not completed are discarded automatically. The size of a file and the number of attachments per Task are limited. 
     * <p><b>201</b> - The registered upload with the URL to upload the file to.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param attachmentMetadata Metadata of the file to upload.
     * @return AttachmentUploadResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public AttachmentUploadResponse createTaskAttachment(String taskId, AttachmentMetadata attachmentMetadata) throws RestClientResponseException {
        ParameterizedTypeReference<AttachmentUploadResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createTaskAttachmentRequestCreation(taskId, attachmentMetadata).body(localVarReturnType);
    }

    /**
     * Upload a Task Attachment
     * Registers the upload of a single file to the Task and returns a pre-signed URL to upload it to. Upload the file with a PUT request to &#x60;upload.url&#x60;, sending exactly the headers in &#x60;upload.headers&#x60;, before &#x60;upload.expires_at&#x60;. The attachment is only returned by the other endpoints once its upload has completed. Uploads that are not completed are discarded automatically. The size of a file and the number of attachments per Task are limited. 
     * <p><b>201</b> - The registered upload with the URL to upload the file to.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param attachmentMetadata Metadata of the file to upload.
     * @return ResponseEntity&lt;AttachmentUploadResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AttachmentUploadResponse> createTaskAttachmentWithHttpInfo(String taskId, AttachmentMetadata attachmentMetadata) throws RestClientResponseException {
        ParameterizedTypeReference<AttachmentUploadResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createTaskAttachmentRequestCreation(taskId, attachmentMetadata).toEntity(localVarReturnType);
    }

    /**
     * Upload a Task Attachment
     * Registers the upload of a single file to the Task and returns a pre-signed URL to upload it to. Upload the file with a PUT request to &#x60;upload.url&#x60;, sending exactly the headers in &#x60;upload.headers&#x60;, before &#x60;upload.expires_at&#x60;. The attachment is only returned by the other endpoints once its upload has completed. Uploads that are not completed are discarded automatically. The size of a file and the number of attachments per Task are limited. 
     * <p><b>201</b> - The registered upload with the URL to upload the file to.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param attachmentMetadata Metadata of the file to upload.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createTaskAttachmentWithResponseSpec(String taskId, AttachmentMetadata attachmentMetadata) throws RestClientResponseException {
        return createTaskAttachmentRequestCreation(taskId, attachmentMetadata);
    }

    /**
     * Delete a Task Attachment
     * Deletes a single attachment of the Task. Only attachments whose upload has completed and that are attached directly to the Task are found; an attachment of a parent Task has to be deleted on the parent Task itself. 
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param attachmentId ID of the Task Attachment.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteTaskAttachmentRequestCreation(String taskId, UUID attachmentId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskId' when calling deleteTaskAttachment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'attachmentId' is set
        if (attachmentId == null) {
            throw new RestClientResponseException("Missing the required parameter 'attachmentId' when calling deleteTaskAttachment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("task_id", taskId);
        pathParams.put("attachment_id", attachmentId);

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
        return apiClient.invokeAPI("/tasks/{task_id}/attachments/{attachment_id}", HttpMethod.DELETE, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Task Attachment
     * Deletes a single attachment of the Task. Only attachments whose upload has completed and that are attached directly to the Task are found; an attachment of a parent Task has to be deleted on the parent Task itself. 
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param attachmentId ID of the Task Attachment.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void deleteTaskAttachment(String taskId, UUID attachmentId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        deleteTaskAttachmentRequestCreation(taskId, attachmentId).body(localVarReturnType);
    }

    /**
     * Delete a Task Attachment
     * Deletes a single attachment of the Task. Only attachments whose upload has completed and that are attached directly to the Task are found; an attachment of a parent Task has to be deleted on the parent Task itself. 
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param attachmentId ID of the Task Attachment.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTaskAttachmentWithHttpInfo(String taskId, UUID attachmentId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return deleteTaskAttachmentRequestCreation(taskId, attachmentId).toEntity(localVarReturnType);
    }

    /**
     * Delete a Task Attachment
     * Deletes a single attachment of the Task. Only attachments whose upload has completed and that are attached directly to the Task are found; an attachment of a parent Task has to be deleted on the parent Task itself. 
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param attachmentId ID of the Task Attachment.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteTaskAttachmentWithResponseSpec(String taskId, UUID attachmentId) throws RestClientResponseException {
        return deleteTaskAttachmentRequestCreation(taskId, attachmentId);
    }

    /**
     * List Task Attachments
     * Lists the attachments whose upload has completed. Only attachments attached directly to the Task are returned; attachments of parent Tasks are not included and have to be fetched from the parent Task itself. 
     * <p><b>200</b> - Page of Task Attachments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return AttachmentsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchTaskAttachmentsRequestCreation(String taskId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable AttachmentsSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskId' when calling fetchTaskAttachments", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("task_id", taskId);

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

        ParameterizedTypeReference<AttachmentsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/attachments", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Task Attachments
     * Lists the attachments whose upload has completed. Only attachments attached directly to the Task are returned; attachments of parent Tasks are not included and have to be fetched from the parent Task itself. 
     * <p><b>200</b> - Page of Task Attachments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return AttachmentsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public AttachmentsPage fetchTaskAttachments(String taskId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable AttachmentsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<AttachmentsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchTaskAttachmentsRequestCreation(taskId, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Task Attachments
     * Lists the attachments whose upload has completed. Only attachments attached directly to the Task are returned; attachments of parent Tasks are not included and have to be fetched from the parent Task itself. 
     * <p><b>200</b> - Page of Task Attachments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;AttachmentsPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AttachmentsPage> fetchTaskAttachmentsWithHttpInfo(String taskId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable AttachmentsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<AttachmentsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchTaskAttachmentsRequestCreation(taskId, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Task Attachments
     * Lists the attachments whose upload has completed. Only attachments attached directly to the Task are returned; attachments of parent Tasks are not included and have to be fetched from the parent Task itself. 
     * <p><b>200</b> - Page of Task Attachments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchTaskAttachmentsWithResponseSpec(String taskId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable AttachmentsSortColumn sortBy) throws RestClientResponseException {
        return fetchTaskAttachmentsRequestCreation(taskId, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * Get a Task Attachment
     * Returns a single attachment of the Task. Only attachments whose upload has completed and that are attached directly to the Task are found; an attachment of a parent Task has to be fetched from the parent Task itself. 
     * <p><b>200</b> - The requested Task Attachment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param attachmentId ID of the Task Attachment.
     * @return Attachment
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getTaskAttachmentRequestCreation(String taskId, UUID attachmentId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new RestClientResponseException("Missing the required parameter 'taskId' when calling getTaskAttachment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'attachmentId' is set
        if (attachmentId == null) {
            throw new RestClientResponseException("Missing the required parameter 'attachmentId' when calling getTaskAttachment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("task_id", taskId);
        pathParams.put("attachment_id", attachmentId);

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

        ParameterizedTypeReference<Attachment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/tasks/{task_id}/attachments/{attachment_id}", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Task Attachment
     * Returns a single attachment of the Task. Only attachments whose upload has completed and that are attached directly to the Task are found; an attachment of a parent Task has to be fetched from the parent Task itself. 
     * <p><b>200</b> - The requested Task Attachment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param attachmentId ID of the Task Attachment.
     * @return Attachment
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public Attachment getTaskAttachment(String taskId, UUID attachmentId) throws RestClientResponseException {
        ParameterizedTypeReference<Attachment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTaskAttachmentRequestCreation(taskId, attachmentId).body(localVarReturnType);
    }

    /**
     * Get a Task Attachment
     * Returns a single attachment of the Task. Only attachments whose upload has completed and that are attached directly to the Task are found; an attachment of a parent Task has to be fetched from the parent Task itself. 
     * <p><b>200</b> - The requested Task Attachment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param attachmentId ID of the Task Attachment.
     * @return ResponseEntity&lt;Attachment&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Attachment> getTaskAttachmentWithHttpInfo(String taskId, UUID attachmentId) throws RestClientResponseException {
        ParameterizedTypeReference<Attachment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getTaskAttachmentRequestCreation(taskId, attachmentId).toEntity(localVarReturnType);
    }

    /**
     * Get a Task Attachment
     * Returns a single attachment of the Task. Only attachments whose upload has completed and that are attached directly to the Task are found; an attachment of a parent Task has to be fetched from the parent Task itself. 
     * <p><b>200</b> - The requested Task Attachment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param taskId ID of the Task.
     * @param attachmentId ID of the Task Attachment.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getTaskAttachmentWithResponseSpec(String taskId, UUID attachmentId) throws RestClientResponseException {
        return getTaskAttachmentRequestCreation(taskId, attachmentId);
    }
}
