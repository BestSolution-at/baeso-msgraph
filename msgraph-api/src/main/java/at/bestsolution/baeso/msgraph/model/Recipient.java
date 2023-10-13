package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * Represents information about a user in the sending or receiving end of an
 * event, message or group post.
 */
public interface Recipient extends MsGraphData {
    /**
     * The recipient's email address.
     * 
     * @return the value
     */
    EmailAddress emailAddress();
}
