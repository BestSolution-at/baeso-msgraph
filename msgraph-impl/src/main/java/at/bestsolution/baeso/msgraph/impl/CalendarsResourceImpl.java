package at.bestsolution.baeso.msgraph.impl;

import at.bestsolution.baeso.msgraph.CalendarResource;
import at.bestsolution.baeso.msgraph.CalendarsResource;
import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.model.CalendarImpl;
import at.bestsolution.baeso.msgraph.impl.utils.QueryImpl;
import at.bestsolution.baeso.msgraph.model.Calendar;

public class CalendarsResourceImpl implements CalendarsResource {
	private final GraphClientImpl client;
	private final String baseUrl;

    public CalendarsResourceImpl(GraphClientImpl client, String baseUrl) {
        this.client = client;
        this.baseUrl = baseUrl;
    }

    @Override
    public CalendarResource calendar(ID<Calendar> id) {
        return new CalendarResourceImpl(client, baseUrl + "/" + id.id);
    }
    
    @Override
    public Calendar create(Calendar calendar) {
        var uri = this.baseUrl;
        var result = this.client.POST(uri, ((CalendarImpl)calendar).object);
        return new CalendarImpl(result);
    }

    @Override
    public CalendarQuery query() {
        return new CalendarQueryImpl(baseUrl, client);
    }

    static class CalendarQueryImpl extends QueryImpl<Calendar> implements CalendarQuery {

        public CalendarQueryImpl(String baseUrl, GraphClientImpl client) {
            super(baseUrl, client, CalendarImpl::new);
        }
    }

}
