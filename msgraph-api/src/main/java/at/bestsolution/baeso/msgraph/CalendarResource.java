package at.bestsolution.baeso.msgraph;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.model.Event;

public interface CalendarResource {

    public EventsResource events();
    
    public default EventResource event(ID<Event> id) {
        return events().event(id);
    }

    public Stream<Event> view(LocalDate start, LocalDate end);
    public Stream<Event> view(LocalDateTime start, LocalDateTime end);
    // public Stream<Event> view(ID<Calendar> calendar, ChronoZonedDateTime<?> start, ChronoZonedDateTime<?> end);
    
}
