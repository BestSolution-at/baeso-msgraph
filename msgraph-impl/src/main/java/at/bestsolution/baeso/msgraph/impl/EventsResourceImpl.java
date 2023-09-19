package at.bestsolution.baeso.msgraph.impl;

import at.bestsolution.baeso.msgraph.EventResource;
import at.bestsolution.baeso.msgraph.EventsResource;
import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.model.EventImpl;
import at.bestsolution.baeso.msgraph.impl.utils.QueryImpl;
import at.bestsolution.baeso.msgraph.model.Event;

public class EventsResourceImpl implements EventsResource {
    private final String baseUrl;
    private final GraphClientImpl client;

    public EventsResourceImpl(GraphClientImpl client, String baseUrl) {
        this.client = client;
        this.baseUrl = baseUrl;
    }

    @Override
    public Event create(Event event) {
        var result = this.client.POST(this.baseUrl, ((EventImpl)event).object);
        return new EventImpl(result);
    }

    @Override
    public EventResource event(ID<Event> id) {
        return new EventResourceImpl(client, baseUrl + "/" + id.id);
    }

    @Override
    public EventQuery query() {
        return new EventQueryImpl(baseUrl, client);
    }

    static class EventQueryImpl extends QueryImpl<Event> implements EventQuery {
        public EventQueryImpl(String baseUrl, GraphClientImpl client) {
            super(baseUrl, client, EventImpl::new);
        }
    }

}
