package at.bestsolution.baeso.msgraph;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.util.stream.Stream;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.Query;
import at.bestsolution.baeso.msgraph.model.Calendar;
import at.bestsolution.baeso.msgraph.model.Event;

public interface CalendarResource {
	public interface CalendarQuery extends Query<Calendar> {

    }

    public CalendarQuery query();

    public Stream<Event> view(ID<Calendar> calendar, LocalDate start, LocalDate end);
    public Stream<Event> view(ID<Calendar> calendar, LocalDateTime start, LocalDateTime end);
    // public Stream<Event> view(ID<Calendar> calendar, ChronoZonedDateTime<?> start, ChronoZonedDateTime<?> end);
}
