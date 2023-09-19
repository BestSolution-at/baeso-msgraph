package at.bestsolution.baeso.msgraph;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.Query;
import at.bestsolution.baeso.msgraph.model.Event;

public interface EventsResource {
        public interface EventQuery extends Query<Event> {

    }

    public EventQuery query();

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

    public EventResource event(ID<Event> id);
}
