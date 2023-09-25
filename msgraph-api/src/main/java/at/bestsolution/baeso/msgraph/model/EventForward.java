package at.bestsolution.baeso.msgraph.model;

import java.util.List;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

public interface EventForward extends MsGraphData {
    String comment();
    List<Recipient> toRecipients();

    public interface Builder {
        public EventForward build();
        Builder comment(String comment);
        Builder toRecipients(List<Recipient> toRecipients);
    }
}
