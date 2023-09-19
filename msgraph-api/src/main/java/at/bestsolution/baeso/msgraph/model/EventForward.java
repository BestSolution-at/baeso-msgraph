package at.bestsolution.baeso.msgraph.model;

import java.util.List;

public interface EventForward {
    String comment();
    List<Recipient> toRecipients();

    public interface Builder {
        public EventForward build();
        Builder comment(String comment);
        Builder toRecipients(List<Recipient> toRecipients);
    }
}
