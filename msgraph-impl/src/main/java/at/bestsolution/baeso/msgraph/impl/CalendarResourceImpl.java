package at.bestsolution.baeso.msgraph.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import at.bestsolution.baeso.msgraph.CalendarResource;
import at.bestsolution.baeso.msgraph.EventsResource;
import at.bestsolution.baeso.msgraph.impl.model.EventImpl;
import at.bestsolution.baeso.msgraph.impl.utils.PagingSpliterator;
import at.bestsolution.baeso.msgraph.impl.utils.QueryParam;
import at.bestsolution.baeso.msgraph.model.Event;

public class CalendarResourceImpl implements CalendarResource {
    private final String baseUrl;
    private final GraphClientImpl client;

    public CalendarResourceImpl(GraphClientImpl client, String baseUrl) {
        this.client = client;
        this.baseUrl = baseUrl;
    }

    @Override
    public Stream<Event> view(LocalDate start, LocalDate end) {
        return view(LocalDateTime.of(start, LocalTime.MIN), LocalDateTime.of(end, LocalTime.MAX));
    }

    @Override
    public Stream<Event> view(LocalDateTime start, LocalDateTime end) {
        List<QueryParam> parameters = new ArrayList<>(2);
        var startDateTime = ZonedDateTime.of(start, ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX"));
        var endDateTime = ZonedDateTime.of(end, ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX"));
        parameters.add(new QueryParam("startDateTime", startDateTime));
        parameters.add(new QueryParam("endDateTime", endDateTime));

        var uri = this.baseUrl + "/calendarView?" + QueryParam.toQueryString(parameters);
        var result = this.client.GET(uri);
        return StreamSupport.stream(new PagingSpliterator<>(client, result, EventImpl::new), false);
    }

    @Override
    public EventsResource events() {
        return new EventsResourceImpl(client, baseUrl + "/events");
    }

}
