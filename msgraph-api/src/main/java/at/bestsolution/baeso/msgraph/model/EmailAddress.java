package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

public interface EmailAddress extends MsGraphData {
    String address();
    String name();

    public interface Builder {
        public EmailAddress build();
        public Builder name(String name);
        public Builder address(String address);
    }
}
