package at.bestsolution.baeso.msgraph;

import java.util.Optional;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.Query;
import at.bestsolution.baeso.msgraph.model.Event;
import at.bestsolution.baeso.msgraph.model.EventAccept;
import at.bestsolution.baeso.msgraph.model.EventCancel;
import at.bestsolution.baeso.msgraph.model.EventUpdate;
import at.bestsolution.baeso.msgraph.model.EventForward;

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
    public interface EventQuery extends Query<Event> {

    }

    public EventQuery query();

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
     * @param id the event id
     * @return the event
     */
    public Optional<Event> get(ID<Event> id);

    /**
     * <p>
     * Create an event in the user's default calendar or specified calendar.
     * </p>
     * <p>
     * By default, the <strong>allowNewTimeProposals</strong> property is set to
     * true when an event
     * is created, which means invitees can propose a different date/time for the
     * event. See <a href=
     * "https://learn.microsoft.com/en-us/graph/outlook-calendar-meeting-proposals">Propose
     * new meeting times</a> for more information on how to propose a
     * time, and how to receive and accept a new time proposal.
     * </p>
     * <p>
     * You can specify the time zone for each of the start and end times of the
     * event as part of their values, because the <strong>start</strong> and
     * <strong>end</strong> properties are of
     * dateTimeTimeZone type. First find the supported time zones to make sure you
     * set only time zones that have been configured for the user's mailbox server.
     * </p>
     * <p>
     * When an event is sent, the server sends invitations to all the attendees.
     * </p>
     * <p>
     * <strong>Setting the location in an event</strong>
     * </p>
     * <p>
     * An Exchange administrator can set up a mailbox and an email address for a
     * resource such as a meeting room, or equipment like a projector. Users can
     * then invite the resource as an attendee to a meeting. On behalf of the
     * resource, the server accepts or rejects the meeting request based on the
     * free/busy schedule of the resource. If the server accepts a meeting for the
     * resource, it creates an event for the meeting in the resource's calendar. If
     * the meeting is rescheduled, the server automatically updates the event in the
     * resource's calendar.
     * </p>
     * <p>
     * Another advantage of setting up a mailbox for a resource is to control
     * scheduling of the resource, for example, only executives or their delegates
     * can book a private meeting room.
     * </p>
     * <p>
     * If you're organizing an event that involves a meeting location:
     * <ol>
     * <li>Set the <strong>location</strong> property of the <strong>event</strong>
     * accordingly.</li>
     * <li>Set the optional <strong>locationEmailAddress</strong> property if the
     * meeting location has an email address.</li>
     * </ol>
     * </p>
     * <p>
     * Additionally, if the meeting location has been set up as a resource, or if
     * the event involves some equipment that has been set up as a resource:
     * <ol>
     * <li>Invite the resource as an <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/attendee?view=graph-rest-1.0">attendee</a>.</li>
     * <li>Set the attendee <strong>type</strong> property as resource.</li>
     * <li>Set the attendee <strong>emailAddress</strong> as the resource email
     * address.</li>
     * </ol>
     * </p>
     * 
     * @param event the event
     * @return the created event
     */
    public Event create(Event event);

    /**
     * <p>
     * Removes the specified event from the containing calendar.
     * </p>
     * <p>
     * If the event is a meeting, deleting the event on the organizer's calendar
     * sends a cancellation message to the meeting attendees.
     * </p>
     * 
     * @param event the event id
     */
    public void delete(ID<Event> event);

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
     * @param event  event id
     * @param update the update
     * @return the updated event
     */
    public Event update(ID<Event> event, EventUpdate update);

    // delta()
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
     * @param event   the event id
     * @param forward the forward info
     */
    public void forward(ID<Event> event, EventForward forward);

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
     * @param event  the event id
     * @param cancel the cancel info
     */
    public void cancel(ID<Event> event, EventCancel cancel);

    /**
     * Accept the specified <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>
     * in a user <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/calendar?view=graph-rest-1.0">calendar</a>.
     * 
     * @param event  the event id
     * @param accept the accept info
     */
    public void accept(ID<Event> event, EventAccept accept);
}
