package at.bestsolution.baeso.msgraph.impl;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import at.bestsolution.baeso.msgraph.CalendarGroupResource;
import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.model.CalendarGroupImpl;
import at.bestsolution.baeso.msgraph.impl.model.CalendarImpl;
import at.bestsolution.baeso.msgraph.impl.utils.PagingSpliterator;
import at.bestsolution.baeso.msgraph.impl.utils.QueryImpl;
import at.bestsolution.baeso.msgraph.model.Calendar;
import at.bestsolution.baeso.msgraph.model.CalendarGroup;

public class CalendarGroupResourceImpl implements CalendarGroupResource {
    private final String baseUrl;
    private final GraphClientImpl client;

    public CalendarGroupResourceImpl(GraphClientImpl client, String idOrPrincipal) {
        this.client = client;
        this.baseUrl = String.format("https://graph.microsoft.com/v1.0/users/%s/calendarGroups", idOrPrincipal);
    }

    @Override
    public CalendarGroupQuery query() {
        return new CalendarGroupQueryImpl(baseUrl, client);
    }

    public Stream<Calendar> calendars(ID<CalendarGroup> group) {
        var uri = this.baseUrl + "/" + group.id + "/calendars";
        var result = this.client.GET(uri);
        return StreamSupport.stream(new PagingSpliterator<>(client, result, CalendarImpl::new), false);
    }
 
    static class CalendarGroupQueryImpl extends QueryImpl<CalendarGroup> implements CalendarGroupQuery {

        public CalendarGroupQueryImpl(String baseUrl, GraphClientImpl client) {
            super(baseUrl, client, CalendarGroupImpl::new);
        }
    }
}
