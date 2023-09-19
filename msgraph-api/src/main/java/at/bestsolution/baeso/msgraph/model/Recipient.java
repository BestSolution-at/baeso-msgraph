package at.bestsolution.baeso.msgraph.model;

public interface Recipient {
    EmailAddress emailAddress();

    public interface Builder {
        public Builder emailAddress(EmailAddress address);
    }
}
