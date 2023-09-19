package at.bestsolution.baeso.msgraph.model;

public interface FileAttachment extends Attachment {
    String contentBytes();
    String contentId();
    String contentLocation();
}
