package at.bestsolution.baeso.msgraph;

import java.util.Optional;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.Query;
import at.bestsolution.baeso.msgraph.model.Event;
import at.bestsolution.baeso.msgraph.model.EventUpdate;

/**
 * <p>
 * An event in a <a href="https://learn.microsoft.com/en-us/graph/api/resources/user?view=graph-rest-1.0">user</a> 
 * calendar, or the default calendar of a Microsoft 365 group.
 * </p>
 * <p>
 * The maximum number of attendees included in an <strong>event</strong>, and the maximum number of recipients in an 
 * <a href="https://learn.microsoft.com/en-us/graph/api/resources/eventmessage?view=graph-rest-1.0">eventMessage</a> 
 * sent from an Exchange Online mailbox is 500. For more information, 
 * see <a href="https://learn.microsoft.com/en-us/office365/servicedescriptions/exchange-online-service-description/exchange-online-limits#sending-limits">sending limits</a>.
 * </p>
 * This resource supports:
 * <ul>
 * <li>Adding your own data to custom properties as <a href="https://learn.microsoft.com/en-us/graph/extensibility-overview">extensions</a>.</li>
 * <li>Subscribing to <a href="https://learn.microsoft.com/en-us/graph/webhooks">change notifications</a>.</li>
 * <li>Using <a href="https://learn.microsoft.com/en-us/graph/delta-query-overview">delta query</a> to track incremental additions, deletions, and updates, by providing a delta function.</li>
 * </ul>
 * <strong>Note</strong>: There are a few minor differences in the way you can interact with user calendars, group calendars, and their events:
 * <ul>
 * <li>You can organize only user calendars in a <a href="https://learn.microsoft.com/en-us/graph/api/resources/calendargroup?view=graph-rest-1.0">calendarGroup</a>.</li>
 * <li>You can add <a href="https://learn.microsoft.com/en-us/graph/api/resources/attachment?view=graph-rest-1.0">attachment</a> objects to events in only user calendars, but not to events in group calendars.</li>
 * <li>Outlook automatically accepts all meeting requests on behalf of groups. 
 * You can <a href="https://learn.microsoft.com/en-us/graph/api/event-accept?view=graph-rest-1.0">accept</a>, 
 * <a href="https://learn.microsoft.com/en-us/graph/api/event-tentativelyaccept?view=graph-rest-1.0">tentatively accept</a>, or 
 * <a href="https://learn.microsoft.com/en-us/graph/api/event-decline?view=graph-rest-1.0">decline</a> meeting requests for user calendars only.</li>
 * <li>Outlook doesn't support reminders for group events. You can 
 * <a href="https://learn.microsoft.com/en-us/graph/api/event-snoozereminder?view=graph-rest-1.0">snooze</a> or 
 * <a href="https://learn.microsoft.com/en-us/graph/api/event-dismissreminder?view=graph-rest-1.0">dismiss</a> a 
 * <a href="https://learn.microsoft.com/en-us/graph/api/resources/reminder?view=graph-rest-1.0">reminder</a> for user calendars only.</li>
 * </ul>
 */
public interface EventResource {
    public interface EventQuery extends Query<Event> {

    }

    public EventQuery query();

    public Optional<Event> get(ID<Event> id);
    public Event create(Event event);
    public void delete(ID<Event> event);
    public Event update(ID<Event> event, EventUpdate update);
}
