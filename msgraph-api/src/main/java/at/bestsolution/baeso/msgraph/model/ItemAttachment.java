package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;

/**
 * A contact, event, or message that's attached to a user <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>,
 * <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/message?view=graph-rest-1.0">message</a>,
 * or <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/post?view=graph-rest-1.0">post</a>..
 */
public interface ItemAttachment extends Attachment {
    /**
     * The attached message or event. Navigation property.
     * @return the value
     */
    OutlookItem item();

    public interface Builder {
        Builder contentType(String contentType);
        Builder id(String id);
        Builder isInline(boolean isInline);
        Builder lastModifiedDateTime(ZonedDateTime lastModifiedDateTime);
        Builder name(String name);
        Builder size(int size);

        Builder item(OutlookItem item);
        Builder withItem(OutlookItem.Builder builder);
    }
}
