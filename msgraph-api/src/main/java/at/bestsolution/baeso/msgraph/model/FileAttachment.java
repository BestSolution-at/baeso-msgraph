package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;

/**
 * <p>
 * A file (such as a text file or Word document) attached to a user <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>,
 * <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/message?view=graph-rest-1.0">message</a>,
 * or <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/post?view=graph-rest-1.0">post</a>.
 * </p>
 * <p>
 * When creating a file attachment, include the following in the request body:
 * </p>
 * <ul>
 * <li>"@odata.type": "#microsoft.graph.fileAttachment"</li>
 * <li>The required properties <strong>name</strong> and
 * <strong>contentBytes</strong>.</li>
 * </ul>
 */
public interface FileAttachment extends Attachment {
    /**
     * The base64-encoded contents of the file.
     * 
     * @return the value
     */
    String contentBytes();

    /**
     * The ID of the attachment in the Exchange store.
     * 
     * @return the value
     */
    String contentId();

    /**
     * Don't use this property as it isn't supported.
     * 
     * @return the value
     */
    String contentLocation();

    public interface Builder {
        public FileAttachment build();
        
        Builder contentType(String contentType);
        Builder id(String id);
        Builder isInline(boolean isInline);
        Builder lastModifiedDateTime(ZonedDateTime lastModifiedDateTime);
        Builder name(String name);
        Builder size(int size);

        Builder contentBytes(String contentBytes);
        Builder contentId(String contentId);
        Builder contentLocation(String contentLocation);
    }
}
