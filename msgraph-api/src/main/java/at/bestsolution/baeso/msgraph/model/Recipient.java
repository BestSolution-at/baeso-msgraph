package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

public interface Recipient extends MsGraphData {
    EmailAddress emailAddress();

    public interface Builder {
        public Builder emailAddress(EmailAddress address);
    }
}
