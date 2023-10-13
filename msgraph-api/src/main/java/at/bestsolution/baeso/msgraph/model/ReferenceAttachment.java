package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;

/**
 * A link to a file (such as a text file or Word document) on a OneDrive for
 * Business cloud drive or other supported storage locations, attached to an
 * event, message, or post.
 */
public interface ReferenceAttachment extends Attachment {
    public interface Builder {
        public ReferenceAttachment build();
        Builder contentType(String contentType);
        Builder id(String id);
        Builder isInline(boolean isInline);
        Builder lastModifiedDateTime(ZonedDateTime lastModifiedDateTime);
        Builder name(String name);
        Builder size(int size);
    }
}
