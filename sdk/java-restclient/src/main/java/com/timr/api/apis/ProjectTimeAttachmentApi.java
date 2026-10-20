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
public class ProjectTimeAttachmentApi {
    private ApiClient apiClient;

    public ProjectTimeAttachmentApi() {
        this(new ApiClient());
    }

    public ProjectTimeAttachmentApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Upload a Project Time Attachment
     * Registers the upload of a single file to a running or completed Project Time and returns a pre-signed URL to upload it to. Upload the file with a PUT request to &#x60;upload.url&#x60;, sending exactly the headers in &#x60;upload.headers&#x60;, before &#x60;upload.expires_at&#x60;. The attachment is only returned by the other endpoints once its upload has completed. Uploads that are not completed are discarded automatically. Only images can be uploaded, and the size of a file and the number of attachments per Project Time are limited. 
     * <p><b>201</b> - The registered upload with the URL to upload the file to.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time.
     * @param attachmentMetadata Metadata of the file to upload.
     * @return AttachmentUploadResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createProjectTimeAttachmentRequestCreation(String projectTimeId, AttachmentMetadata attachmentMetadata) throws RestClientResponseException {
        Object postBody = attachmentMetadata;
        // verify the required parameter 'projectTimeId' is set
        if (projectTimeId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectTimeId' when calling createProjectTimeAttachment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'attachmentMetadata' is set
        if (attachmentMetadata == null) {
            throw new RestClientResponseException("Missing the required parameter 'attachmentMetadata' when calling createProjectTimeAttachment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("project_time_id", projectTimeId);

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
        return apiClient.invokeAPI("/project-times/{project_time_id}/attachments", HttpMethod.POST, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Upload a Project Time Attachment
     * Registers the upload of a single file to a running or completed Project Time and returns a pre-signed URL to upload it to. Upload the file with a PUT request to &#x60;upload.url&#x60;, sending exactly the headers in &#x60;upload.headers&#x60;, before &#x60;upload.expires_at&#x60;. The attachment is only returned by the other endpoints once its upload has completed. Uploads that are not completed are discarded automatically. Only images can be uploaded, and the size of a file and the number of attachments per Project Time are limited. 
     * <p><b>201</b> - The registered upload with the URL to upload the file to.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time.
     * @param attachmentMetadata Metadata of the file to upload.
     * @return AttachmentUploadResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public AttachmentUploadResponse createProjectTimeAttachment(String projectTimeId, AttachmentMetadata attachmentMetadata) throws RestClientResponseException {
        ParameterizedTypeReference<AttachmentUploadResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createProjectTimeAttachmentRequestCreation(projectTimeId, attachmentMetadata).body(localVarReturnType);
    }

    /**
     * Upload a Project Time Attachment
     * Registers the upload of a single file to a running or completed Project Time and returns a pre-signed URL to upload it to. Upload the file with a PUT request to &#x60;upload.url&#x60;, sending exactly the headers in &#x60;upload.headers&#x60;, before &#x60;upload.expires_at&#x60;. The attachment is only returned by the other endpoints once its upload has completed. Uploads that are not completed are discarded automatically. Only images can be uploaded, and the size of a file and the number of attachments per Project Time are limited. 
     * <p><b>201</b> - The registered upload with the URL to upload the file to.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time.
     * @param attachmentMetadata Metadata of the file to upload.
     * @return ResponseEntity&lt;AttachmentUploadResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AttachmentUploadResponse> createProjectTimeAttachmentWithHttpInfo(String projectTimeId, AttachmentMetadata attachmentMetadata) throws RestClientResponseException {
        ParameterizedTypeReference<AttachmentUploadResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return createProjectTimeAttachmentRequestCreation(projectTimeId, attachmentMetadata).toEntity(localVarReturnType);
    }

    /**
     * Upload a Project Time Attachment
     * Registers the upload of a single file to a running or completed Project Time and returns a pre-signed URL to upload it to. Upload the file with a PUT request to &#x60;upload.url&#x60;, sending exactly the headers in &#x60;upload.headers&#x60;, before &#x60;upload.expires_at&#x60;. The attachment is only returned by the other endpoints once its upload has completed. Uploads that are not completed are discarded automatically. Only images can be uploaded, and the size of a file and the number of attachments per Project Time are limited. 
     * <p><b>201</b> - The registered upload with the URL to upload the file to.
     * <p><b>400</b> - Bad Request
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time.
     * @param attachmentMetadata Metadata of the file to upload.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec createProjectTimeAttachmentWithResponseSpec(String projectTimeId, AttachmentMetadata attachmentMetadata) throws RestClientResponseException {
        return createProjectTimeAttachmentRequestCreation(projectTimeId, attachmentMetadata);
    }

    /**
     * Delete a Project Time Attachment
     * Deletes a single attachment of a running or completed Project Time. Only attachments whose upload has completed are found. Attachments of a completed Project Time can only be deleted while its status is &#x60;changeable&#x60;. 
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>422</b> - Unprocessable Content
     * @param projectTimeId ID of the Project Time.
     * @param attachmentId ID of the Project Time Attachment.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteProjectTimeAttachmentRequestCreation(String projectTimeId, UUID attachmentId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectTimeId' is set
        if (projectTimeId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectTimeId' when calling deleteProjectTimeAttachment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'attachmentId' is set
        if (attachmentId == null) {
            throw new RestClientResponseException("Missing the required parameter 'attachmentId' when calling deleteProjectTimeAttachment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("project_time_id", projectTimeId);
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
        return apiClient.invokeAPI("/project-times/{project_time_id}/attachments/{attachment_id}", HttpMethod.DELETE, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a Project Time Attachment
     * Deletes a single attachment of a running or completed Project Time. Only attachments whose upload has completed are found. Attachments of a completed Project Time can only be deleted while its status is &#x60;changeable&#x60;. 
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>422</b> - Unprocessable Content
     * @param projectTimeId ID of the Project Time.
     * @param attachmentId ID of the Project Time Attachment.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public void deleteProjectTimeAttachment(String projectTimeId, UUID attachmentId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        deleteProjectTimeAttachmentRequestCreation(projectTimeId, attachmentId).body(localVarReturnType);
    }

    /**
     * Delete a Project Time Attachment
     * Deletes a single attachment of a running or completed Project Time. Only attachments whose upload has completed are found. Attachments of a completed Project Time can only be deleted while its status is &#x60;changeable&#x60;. 
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>422</b> - Unprocessable Content
     * @param projectTimeId ID of the Project Time.
     * @param attachmentId ID of the Project Time Attachment.
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteProjectTimeAttachmentWithHttpInfo(String projectTimeId, UUID attachmentId) throws RestClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<>() {};
        return deleteProjectTimeAttachmentRequestCreation(projectTimeId, attachmentId).toEntity(localVarReturnType);
    }

    /**
     * Delete a Project Time Attachment
     * Deletes a single attachment of a running or completed Project Time. Only attachments whose upload has completed are found. Attachments of a completed Project Time can only be deleted while its status is &#x60;changeable&#x60;. 
     * <p><b>204</b> - Deleted. No content is returned.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>422</b> - Unprocessable Content
     * @param projectTimeId ID of the Project Time.
     * @param attachmentId ID of the Project Time Attachment.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec deleteProjectTimeAttachmentWithResponseSpec(String projectTimeId, UUID attachmentId) throws RestClientResponseException {
        return deleteProjectTimeAttachmentRequestCreation(projectTimeId, attachmentId);
    }

    /**
     * List Project Time Attachments
     * Lists the attachments of a running or completed Project Time whose upload has completed. 
     * <p><b>200</b> - Page of Project Time Attachments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return AttachmentsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec fetchProjectTimeAttachmentsRequestCreation(String projectTimeId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable AttachmentsSortColumn sortBy) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectTimeId' is set
        if (projectTimeId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectTimeId' when calling fetchProjectTimeAttachments", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("project_time_id", projectTimeId);

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
        return apiClient.invokeAPI("/project-times/{project_time_id}/attachments", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Project Time Attachments
     * Lists the attachments of a running or completed Project Time whose upload has completed. 
     * <p><b>200</b> - Page of Project Time Attachments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return AttachmentsPage
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public AttachmentsPage fetchProjectTimeAttachments(String projectTimeId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable AttachmentsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<AttachmentsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchProjectTimeAttachmentsRequestCreation(projectTimeId, pageToken, limit, sortDirection, sortBy).body(localVarReturnType);
    }

    /**
     * List Project Time Attachments
     * Lists the attachments of a running or completed Project Time whose upload has completed. 
     * <p><b>200</b> - Page of Project Time Attachments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseEntity&lt;AttachmentsPage&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AttachmentsPage> fetchProjectTimeAttachmentsWithHttpInfo(String projectTimeId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable AttachmentsSortColumn sortBy) throws RestClientResponseException {
        ParameterizedTypeReference<AttachmentsPage> localVarReturnType = new ParameterizedTypeReference<>() {};
        return fetchProjectTimeAttachmentsRequestCreation(projectTimeId, pageToken, limit, sortDirection, sortBy).toEntity(localVarReturnType);
    }

    /**
     * List Project Time Attachments
     * Lists the attachments of a running or completed Project Time whose upload has completed. 
     * <p><b>200</b> - Page of Project Time Attachments.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time.
     * @param pageToken Token identifying the page to return. Take it from the &#39;next_page_token&#39; field of the previous response.
     * @param limit Maximum number of entries per page. Values above 500 are capped at 500.
     * @param sortDirection Direction to sort the entries in.
     * @param sortBy Property to sort the entries by.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec fetchProjectTimeAttachmentsWithResponseSpec(String projectTimeId, @Nullable String pageToken, @Nullable Integer limit, @Nullable SortDirection sortDirection, @Nullable AttachmentsSortColumn sortBy) throws RestClientResponseException {
        return fetchProjectTimeAttachmentsRequestCreation(projectTimeId, pageToken, limit, sortDirection, sortBy);
    }

    /**
     * Get a Project Time Attachment
     * Returns a single attachment of a running or completed Project Time. Only attachments whose upload has completed are found. 
     * <p><b>200</b> - The requested Project Time Attachment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time.
     * @param attachmentId ID of the Project Time Attachment.
     * @return Attachment
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getProjectTimeAttachmentRequestCreation(String projectTimeId, UUID attachmentId) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'projectTimeId' is set
        if (projectTimeId == null) {
            throw new RestClientResponseException("Missing the required parameter 'projectTimeId' when calling getProjectTimeAttachment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'attachmentId' is set
        if (attachmentId == null) {
            throw new RestClientResponseException("Missing the required parameter 'attachmentId' when calling getProjectTimeAttachment", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("project_time_id", projectTimeId);
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
        return apiClient.invokeAPI("/project-times/{project_time_id}/attachments/{attachment_id}", HttpMethod.GET, pathParams, localVarQueryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get a Project Time Attachment
     * Returns a single attachment of a running or completed Project Time. Only attachments whose upload has completed are found. 
     * <p><b>200</b> - The requested Project Time Attachment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time.
     * @param attachmentId ID of the Project Time Attachment.
     * @return Attachment
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public Attachment getProjectTimeAttachment(String projectTimeId, UUID attachmentId) throws RestClientResponseException {
        ParameterizedTypeReference<Attachment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getProjectTimeAttachmentRequestCreation(projectTimeId, attachmentId).body(localVarReturnType);
    }

    /**
     * Get a Project Time Attachment
     * Returns a single attachment of a running or completed Project Time. Only attachments whose upload has completed are found. 
     * <p><b>200</b> - The requested Project Time Attachment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time.
     * @param attachmentId ID of the Project Time Attachment.
     * @return ResponseEntity&lt;Attachment&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Attachment> getProjectTimeAttachmentWithHttpInfo(String projectTimeId, UUID attachmentId) throws RestClientResponseException {
        ParameterizedTypeReference<Attachment> localVarReturnType = new ParameterizedTypeReference<>() {};
        return getProjectTimeAttachmentRequestCreation(projectTimeId, attachmentId).toEntity(localVarReturnType);
    }

    /**
     * Get a Project Time Attachment
     * Returns a single attachment of a running or completed Project Time. Only attachments whose upload has completed are found. 
     * <p><b>200</b> - The requested Project Time Attachment.
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param projectTimeId ID of the Project Time.
     * @param attachmentId ID of the Project Time Attachment.
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getProjectTimeAttachmentWithResponseSpec(String projectTimeId, UUID attachmentId) throws RestClientResponseException {
        return getProjectTimeAttachmentRequestCreation(projectTimeId, attachmentId);
    }
}
