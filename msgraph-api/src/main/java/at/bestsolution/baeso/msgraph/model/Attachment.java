package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

public interface Attachment extends MsGraphData {
    String contentType();
    String id();
    boolean isInline();
    ZonedDateTime lastModifiedDateTime();
    String name();
    int size();
}
