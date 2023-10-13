package at.bestsolution.baeso.msgraph;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.model.Event;

/**
 * <p>
 * Represents a container for event resources. It can be a calendar for a user,
 * or the default calendar of a Microsoft 365 group.
 * </p>
 * <p>
 * <strong>Note</strong>: There are a few minor differences in the way you can
 * interact with user
 * calendars and group calendars:
 * </p>
 * <ul>
 * <li>You can organize only user calendars in a calendarGroup.</li>
 * <li>Outlook automatically accepts all meeting requests on behalf of groups.
 * You can accept, tentatively accept, or decline meeting requests for user
 * calendars only.</li>
 * <li>Outlook doesn't support reminders for group events. You can snooze or
 * dismiss a reminder for user calendars only.</li>
 * </ul>
 */
public interface CalendarResource {

    public EventsResource events();

    public default EventResource event(ID<Event> id) {
        return events().event(id);
    }

    public Stream<Event> view(LocalDate start, LocalDate end);

    public Stream<Event> view(LocalDateTime start, LocalDateTime end);
    // public Stream<Event> view(ID<Calendar> calendar, ChronoZonedDateTime<?>
    // start, ChronoZonedDateTime<?> end);

}
