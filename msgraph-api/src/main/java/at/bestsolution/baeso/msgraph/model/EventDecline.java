package at.bestsolution.baeso.msgraph.model;

/**
 * <p>
 * Decline invitation to the specified <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>
 * in a user <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/calendar?view=graph-rest-1.0">calendar</a>.
 * </p>
 * <p>
 * If the event allows proposals for new times, on declining the event, an
 * invitee can choose to suggest an alternative time by including the
 * <strong>proposedNewTime</strong> parameter. For more information on how to
 * propose a time, and
 * how to receive and accept a new time proposal, see <a href=
 * "https://learn.microsoft.com/en-us/graph/outlook-calendar-meeting-proposals">Propose
 * new meeting times</a>.
 * </p>
 */
public interface EventDecline {
    /**
     * Text included in the response. Optional.
     * 
     * @return the value
     */
    String comment();

    /**
     * An alternate date/time proposed by an invitee for a meeting request to start
     * and end. Valid only for events that allow new time proposals. Setting this
     * parameter requires setting <strong>sendResponse</strong> to
     * <code>true</code>. Optional.
     * 
     * @return the value
     */
    TimeSlot proposedNewTime();

    /**
     * <code>true</code> if a response is to be sent to the organizer; otherwise,
     * <code>false</code>. Optional. Default is <code>true</code>.
     * 
     * @return the value
     */
    boolean sendResponse();

    public interface Builder {
        public EventDecline build();
        Builder comment(String comment);
        Builder proposedNewTime(TimeSlot proposedNewTime);
        Builder sendResponse(boolean sendResponse);
    }
}
