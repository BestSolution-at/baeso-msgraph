package at.bestsolution.baeso.msgraph.model;

public interface EmailAddress {
    String address();
    String name();

    public interface Builder {
        public EmailAddress build();
        public Builder name(String name);
        public Builder address(String address);
    }
}
