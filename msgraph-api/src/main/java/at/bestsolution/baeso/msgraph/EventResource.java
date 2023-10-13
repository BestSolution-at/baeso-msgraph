package at.bestsolution.baeso.msgraph;

import java.util.Optional;
import java.util.function.Function;

import at.bestsolution.baeso.msgraph.model.Event;
import at.bestsolution.baeso.msgraph.model.EventAccept;
import at.bestsolution.baeso.msgraph.model.EventCancel;
import at.bestsolution.baeso.msgraph.model.EventDecline;
import at.bestsolution.baeso.msgraph.model.EventUpdate;
import at.bestsolution.baeso.msgraph.model.EventForward;
import at.bestsolution.baeso.msgraph.model.EventSnoozeReminder;
import at.bestsolution.baeso.msgraph.model.EventTentativelyAccept;

/**
 * <p>
 * An event in a <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/user?view=graph-rest-1.0">user</a>
 * calendar, or the default calendar of a Microsoft 365 group.
 * </p>
 * <p>
 * The maximum number of attendees included in an <strong>event</strong>, and
 * the maximum number of recipients in an
 * <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/eventmessage?view=graph-rest-1.0">eventMessage</a>
 * sent from an Exchange Online mailbox is 500. For more information,
 * see <a href=
 * "https://learn.microsoft.com/en-us/office365/servicedescriptions/exchange-online-service-description/exchange-online-limits#sending-limits">sending
 * limits</a>.
 * </p>
 * This resource supports:
 * <ul>
 * <li>Adding your own data to custom properties as <a href=
 * "https://learn.microsoft.com/en-us/graph/extensibility-overview">extensions</a>.</li>
 * <li>Subscribing to
 * <a href="https://learn.microsoft.com/en-us/graph/webhooks">change
 * notifications</a>.</li>
 * <li>Using
 * <a href="https://learn.microsoft.com/en-us/graph/delta-query-overview">delta
 * query</a> to track incremental additions, deletions, and updates, by
 * providing a delta function.</li>
 * </ul>
 * <strong>Note</strong>: There are a few minor differences in the way you can
 * interact with user calendars, group calendars, and their events:
 * <ul>
 * <li>You can organize only user calendars in a <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/calendargroup?view=graph-rest-1.0">calendarGroup</a>.</li>
 * <li>You can add <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/attachment?view=graph-rest-1.0">attachment</a>
 * objects to events in only user calendars, but not to events in group
 * calendars.</li>
 * <li>Outlook automatically accepts all meeting requests on behalf of groups.
 * You can <a href=
 * "https://learn.microsoft.com/en-us/graph/api/event-accept?view=graph-rest-1.0">accept</a>,
 * <a href=
 * "https://learn.microsoft.com/en-us/graph/api/event-tentativelyaccept?view=graph-rest-1.0">tentatively
 * accept</a>, or
 * <a href=
 * "https://learn.microsoft.com/en-us/graph/api/event-decline?view=graph-rest-1.0">decline</a>
 * meeting requests for user calendars only.</li>
 * <li>Outlook doesn't support reminders for group events. You can
 * <a href=
 * "https://learn.microsoft.com/en-us/graph/api/event-snoozereminder?view=graph-rest-1.0">snooze</a>
 * or
 * <a href=
 * "https://learn.microsoft.com/en-us/graph/api/event-dismissreminder?view=graph-rest-1.0">dismiss</a>
 * a
 * <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/reminder?view=graph-rest-1.0">reminder</a>
 * for user calendars only.</li>
 * </ul>
 */
public interface EventResource {

    /**
     * <p>
     * Get the properties and relationships of the specified event object.
     * </p>
     * <p>
     * Currently, this operation returns event bodies in only HTML format.
     * </p>
     * <p>
     * There are two scenarios where an app can get an event in another user's
     * calendar:
     * <ul>
     * <li>If the app has application permissions, or,</li>
     * <li>If the app has the appropriate delegated <a href=
     * "https://learn.microsoft.com/en-us/graph/api/event-get?view=graph-rest-1.0&tabs=http#permissions">permissions</a>
     * from one user, and
     * another user has shared a calendar with that user, or, has given delegated
     * access to that user. See <a href=
     * "https://learn.microsoft.com/en-us/graph/outlook-get-shared-events-calendars">details
     * and an example</a>.</li>
     * </ul>
     * </p>
     * <p>
     * Since the <strong>event</strong> resource supports <a href=
     * "https://learn.microsoft.com/en-us/graph/extensibility-overview">extensions</a>,
     * you can also use the <code>GET</code> operation to get custom properties and
     * extension
     * data in an <strong>event</strong> instance.
     * </p>
     * 
     * @return the event
     */
    public Optional<Event> get();

    /**
     * <p>
     * Removes the specified event from the containing calendar.
     * </p>
     * <p>
     * If the event is a meeting, deleting the event on the organizer's calendar
     * sends a cancellation message to the meeting attendees.
     * </p>
     * 
     */
    public void delete();

    /**
     * <p>
     * Note the following behaviors or recommendations when updating the
     * corresponding properties:
     * <ul>
     * <li>attendees property and meeting updates
     * <ul>
     * <li>An event update that includes only the <strong>attendees</strong>
     * property in the request body sends a meeting update to only the attendees
     * that have changed.</li>
     * <li>An event update that removes an attendee specified as a member of a
     * distribution list sends a meeting update to all the attendees.</li>
     * </ul>
     * </li>
     * <li>body property and online meetings
     * <p>
     * Before updating the body of an event that has been set up as an online
     * meeting, be sure to first get the <strong>body</strong> property, apply the
     * appropriate
     * changes to the content, and preserve the meeting blob for online meeting.
     * Inadvertently removing the meeting blob from the body would disable meeting
     * online.
     * </p>
     * </li>
     * <li><strong>end</strong> and <strong>start</strong> properties and their time
     * zones
     * <p>
     * When updating the time zone of the start or end time of an event, first
     * <a href=
     * "https://learn.microsoft.com/en-us/graph/api/outlookuser-supportedtimezones?view=graph-rest-1.0">find
     * the supported time zones</a> to make sure you set only time zones that have
     * been
     * configured for the user's mailbox server.
     * </p>
     * </li>
     * </ul>
     * </p>
     * 
     * @param update the update
     * @return the updated event
     */
    public Event update(EventUpdate update);

    /**
     * <p>
     * Note the following behaviors or recommendations when updating the
     * corresponding properties:
     * <ul>
     * <li>attendees property and meeting updates
     * <ul>
     * <li>An event update that includes only the <strong>attendees</strong>
     * property in the request body sends a meeting update to only the attendees
     * that have changed.</li>
     * <li>An event update that removes an attendee specified as a member of a
     * distribution list sends a meeting update to all the attendees.</li>
     * </ul>
     * </li>
     * <li>body property and online meetings
     * <p>
     * Before updating the body of an event that has been set up as an online
     * meeting, be sure to first get the <strong>body</strong> property, apply the
     * appropriate
     * changes to the content, and preserve the meeting blob for online meeting.
     * Inadvertently removing the meeting blob from the body would disable meeting
     * online.
     * </p>
     * </li>
     * <li><strong>end</strong> and <strong>start</strong> properties and their time
     * zones
     * <p>
     * When updating the time zone of the start or end time of an event, first
     * <a href=
     * "https://learn.microsoft.com/en-us/graph/api/outlookuser-supportedtimezones?view=graph-rest-1.0">find
     * the supported time zones</a> to make sure you set only time zones that have
     * been
     * configured for the user's mailbox server.
     * </p>
     * </li>
     * </ul>
     * </p>
     * 
     * @param update function to build the update
     * @return the updated event provider
     */
    public Event update(Function<EventUpdate.Builder, EventUpdate> update);

    /**
     * <p>
     * This action allows the organizer or attendee of a meeting <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>
     * to forward the meeting request to a new recipient.
     * </p>
     * <p>
     * If the meeting event is forwarded from an attendee's Microsoft 365 mailbox to
     * another recipient, this action also sends a message to notify the organizer
     * of the forwarding, and adds the recipient to the organizer's copy of the
     * meeting event. This convenience is not available when forwarding from an
     * Outlook.com account.
     * </p>
     * 
     * @param forward the forward info
     */
    public void forward(EventForward forward);

    /**
     * <p>
     * This action allows the organizer or attendee of a meeting <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>
     * to forward the meeting request to a new recipient.
     * </p>
     * <p>
     * If the meeting event is forwarded from an attendee's Microsoft 365 mailbox to
     * another recipient, this action also sends a message to notify the organizer
     * of the forwarding, and adds the recipient to the organizer's copy of the
     * meeting event. This convenience is not available when forwarding from an
     * Outlook.com account.
     * </p>
     * 
     * @param forward the forward info provider
     */
    public void forward(Function<EventForward.Builder, EventForward> forward);

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
     * 
     * @param cancel the cancel info
     */
    public void cancel(EventCancel cancel);

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
     * 
     * @param cancel the cancel info provider
     */
    public void cancel(Function<EventCancel.Builder, EventCancel> cancel);

    /**
     * Accept the specified <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>
     * in a user <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/calendar?view=graph-rest-1.0">calendar</a>.
     * 
     * @param accept the accept info
     */
    public void accept(EventAccept accept);

    /**
     * Accept the specified <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>
     * in a user <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/calendar?view=graph-rest-1.0">calendar</a>.
     * 
     * @param accept the accept info provider
     */
    public void accept(Function<EventAccept.Builder, EventAccept> accept);

    /**
     * <p>
     * Tentatively accept the specified <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>
     * in a user <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/calendar?view=graph-rest-1.0">calendar</a>.
     * </p>
     * <p>
     * If the event allows proposals for new times, on responding tentative to the
     * event, an invitee can choose to suggest an alternative time by including the
     * <strong>proposedNewTime</strong> parameter. For more information on how to
     * propose a time, and
     * how to receive and accept a new time proposal, see <a href=
     * "https://learn.microsoft.com/en-us/graph/outlook-calendar-meeting-proposals">Propose
     * new meeting times</a>.
     * </p>
     * 
     * @param tentativelyAccept the accept action
     */
    public void tentativelyAccept(EventTentativelyAccept tentativelyAccept);

    /**
     * <p>
     * Tentatively accept the specified <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>
     * in a user <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/calendar?view=graph-rest-1.0">calendar</a>.
     * </p>
     * <p>
     * If the event allows proposals for new times, on responding tentative to the
     * event, an invitee can choose to suggest an alternative time by including the
     * <strong>proposedNewTime</strong> parameter. For more information on how to
     * propose a time, and
     * how to receive and accept a new time proposal, see <a href=
     * "https://learn.microsoft.com/en-us/graph/outlook-calendar-meeting-proposals">Propose
     * new meeting times</a>.
     * </p>
     * 
     * @param tentativelyAccept the accept provider
     */
    public void tentativelyAccept(Function<EventTentativelyAccept.Builder, EventTentativelyAccept> tentativelyAccept);

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
     * 
     * @param decline the info
     */
    public void decline(EventDecline decline);

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
     * 
     * @param decline the info provider
     */
    public void decline(Function<EventDecline.Builder, EventDecline> decline);

    /**
     * Dismiss a reminder that has been triggered for an <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>
     * in a user <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/calendar?view=graph-rest-1.0">calendar</a>.
     */
    public void dismissReminder();

    /**
     * Postpone a reminder for an <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>
     * in a user <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/calendar?view=graph-rest-1.0">calendar</a>
     * until a new time.
     * 
     * @param snoozeReminder the info
     */
    public void snoozeReminder(EventSnoozeReminder snoozeReminder);

    /**
     * Postpone a reminder for an <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>
     * in a user <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/calendar?view=graph-rest-1.0">calendar</a>
     * until a new time.
     * 
     * @param snoozeReminder the info provider
     */
    public void snoozeReminder(Function<EventSnoozeReminder.Builder, EventSnoozeReminder> snoozeReminder);

    // TBD delta()
}
