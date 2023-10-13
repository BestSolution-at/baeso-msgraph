package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * <p>
 * This action allows the organizer of a meeting to send a cancellation message
 * and cancel the event.
 * </p>
 * <p>
 * The action moves the event to the Deleted Items folder. The organizer can
 * also cancel an occurrence of a recurring meeting by providing the occurrence
 * event ID. An attendee calling this action gets an error (HTTP 400 Bad
 * Request), with the following error message:
 * </p>
 * <p>
 * "Your request can't be completed. You need to be an organizer to cancel a
 * meeting."
 * </p>
 * <p>
 * This action differs from <a href=
 * "https://learn.microsoft.com/en-us/graph/api/event-delete?view=graph-rest-1.0">Delete</a>
 * in that <strong>Cancel</strong> is available to only the
 * organizer, and lets the organizer send a custom message to the attendees
 * about the cancellation.
 * </p>
 */
public interface EventCancel extends MsGraphData {
    /**
     * A comment about the cancellation sent to all the attendees. Optional.
     * 
     * @return value
     */
    String comment();

    public interface Builder {
        public EventCancel build();

        Builder comment(String comment);
    }
}
