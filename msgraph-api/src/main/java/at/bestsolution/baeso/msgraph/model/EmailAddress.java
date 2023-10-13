package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * The name and email address of a contact or message recipient.
 */
public interface EmailAddress extends MsGraphData {
    /**
     * The email address of the person or entity.
     * 
     * @return the value
     */
    String address();

    /**
     * The display name of the person or entity.
     * 
     * @return the value
     */
    String name();

    public interface Builder {
        public EmailAddress build();

        public Builder name(String name);

        public Builder address(String address);
    }
}
