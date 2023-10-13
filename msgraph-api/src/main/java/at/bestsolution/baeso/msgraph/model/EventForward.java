package at.bestsolution.baeso.msgraph.model;

import java.util.List;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * <p>
 * This action allows the organizer or attendee of a meeting event to forward
 * the meeting request to a new recipient.
 * </p>
 * <p>
 * If the meeting event is forwarded from an attendee's Microsoft 365 mailbox to
 * another recipient, this action also sends a message to notify the organizer
 * of the forwarding, and adds the recipient to the organizer's copy of the
 * meeting event. This convenience is not available when forwarding from an
 * Outlook.com account.
 * </p>
 */
public interface EventForward extends MsGraphData {
    String comment();

    List<Recipient> toRecipients();

    public interface Builder {
        public EventForward build();

        Builder comment(String comment);

        Builder toRecipients(List<Recipient> toRecipients);
    }
}
