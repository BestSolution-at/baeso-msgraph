package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;

public interface Attachment {
    String contentType();
    String id();
    boolean isInline();
    ZonedDateTime lastModifiedDateTime();
    String name();
    int size();
}
