package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * <p>
 * You can add related content to a user event, message, or post in the form of
 * an attachment.
 * </p>
 * <p>
 * Events in group calendars do not support attachments.
 * </p>
 * <strong>attachment</strong> is the base resource for the following derived
 * types of attachments:
 * 
 * <ul>
 * <li>A file (<a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/fileattachment?view=graph-rest-1.0">fileAttachment</a>
 * resource)</li>
 * <li>An item (contact, event or message, represented by an <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/itemattachment?view=graph-rest-1.0">itemAttachment</a>
 * resource)</li>
 * <li>A link to a file (<a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/referenceattachment?view=graph-rest-1.0">referenceAttachment</a>
 * resource)</li>
 * </ul>
 * <p>
 * Note: If you're attaching a file to a group post, or attaching an item to an
 * event, message, or group post, limit the size of the attachment to 3 MB.
 * </p>
 * <p>
 * If you're attaching a file under 3 MB, you can <a href=
 * "https://learn.microsoft.com/en-us/graph/api/event-post-attachments?view=graph-rest-1.0">add
 * the file attachment to a
 * user event</a>, <a href=
 * "https://learn.microsoft.com/en-us/graph/api/message-post-attachments?view=graph-rest-1.0">to
 * a message</a>, or <a href=
 * "https://learn.microsoft.com/en-us/graph/api/post-post-attachments?view=graph-rest-1.0">to
 * a group post</a>.
 * </p>
 * <p>
 * If you're attaching a file between 3 MB and 150 MB to an event or message,
 * you can <a href=
 * "https://learn.microsoft.com/en-us/graph/api/attachment-createuploadsession?view=graph-rest-1.0">create
 * an upload session</a> and iteratively upload ranges of the file to
 * attach it. See <a href=
 * "https://learn.microsoft.com/en-us/graph/outlook-large-attachments">attach
 * large files to Outlook messages</a> for an example.
 * </p>
 */
public interface Attachment extends MsGraphData {
    /**
     * The MIME type.
     * 
     * @return the value
     */
    String contentType();

    /**
     * Id Read-only.
     * 
     * @return the value
     */
    String id();

    /**
     * <code>true</code> if the attachment is an inline attachment; otherwise,
     * <code>false</code>.
     * 
     * @return the value
     */
    boolean isInline();

    /**
     * The Timestamp type represents date and time information using ISO 8601 format
     * and is always in UTC time. For example, midnight UTC on Jan 1, 2014 is
     * <code>2014-01-01T00:00:00Z</code>
     * 
     * @return the value
     */
    ZonedDateTime lastModifiedDateTime();

    /**
     * The attachment's file name.
     * 
     * @return the value
     */
    String name();

    /**
     * The length of the attachment in bytes.
     * 
     * @return the value
     */
    int size();
}
