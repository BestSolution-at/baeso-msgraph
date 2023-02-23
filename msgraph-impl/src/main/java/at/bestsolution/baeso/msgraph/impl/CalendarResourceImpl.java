package at.bestsolution.baeso.msgraph.impl;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import at.bestsolution.baeso.msgraph.CalendarResource;
import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.model.CalendarImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventImpl;
import at.bestsolution.baeso.msgraph.impl.utils.PagingSpliterator;
import at.bestsolution.baeso.msgraph.impl.utils.QueryImpl;
import at.bestsolution.baeso.msgraph.impl.utils.QueryParam;
import at.bestsolution.baeso.msgraph.model.Calendar;
import at.bestsolution.baeso.msgraph.model.Event;
import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;

public class CalendarResourceImpl implements CalendarResource {
    private final String baseUrl;
    private final GraphClientImpl client;

    public CalendarResourceImpl(GraphClientImpl client, String idOrPrincipal) {
        this.client = client;
        this.baseUrl = String.format("https://graph.microsoft.com/v1.0/users/%s/calendars", idOrPrincipal);
    }

    @Override
    public CalendarQuery query() {
        return new CalendarQueryImpl(baseUrl, client);
    }

    @Override
    public Stream<Event> view(ID<Calendar> calendar, LocalDate start, LocalDate end) {
        return view(calendar, LocalDateTime.of(start, LocalTime.MIN), LocalDateTime.of(end, LocalTime.MAX));
    }

    @Override
    public Stream<Event> view(ID<Calendar> calendar, LocalDateTime start, LocalDateTime end) {
        List<QueryParam> parameters = new ArrayList<>(2);
        var startDateTime = ZonedDateTime.of(start, ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX"));
        var endDateTime = ZonedDateTime.of(end, ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX"));
        parameters.add(new QueryParam("startDateTime", startDateTime));
        parameters.add(new QueryParam("endDateTime", endDateTime));

        var uri = this.baseUrl + "/" + calendar.id + "/calendarView?" + QueryParam.toQueryString(parameters);
        var result = this.client.GET(uri);
        return StreamSupport.stream(new PagingSpliterator<>(client, result, EventImpl::new),false);
    }
    
    class CalendarQueryImpl extends QueryImpl<Calendar> implements CalendarQuery {

        public CalendarQueryImpl(String baseUrl, GraphClientImpl client) {
            super(baseUrl, client, CalendarImpl::new);
        }
    }
}
