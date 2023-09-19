package at.bestsolution.baeso.msgraph.impl;

import java.util.Optional;

import at.bestsolution.baeso.msgraph.EventResource;
import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.model.EventImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventUpdateImpl;
import at.bestsolution.baeso.msgraph.impl.utils.QueryImpl;
import at.bestsolution.baeso.msgraph.model.Event;
import at.bestsolution.baeso.msgraph.model.EventUpdate;

public class EventResourceImpl implements EventResource {
    private final GraphClientImpl client;
    private final String baseUrl;

    public EventResourceImpl(GraphClientImpl client, String baseUrl) {
        this.client = client;
        this.baseUrl = baseUrl + "/events";
    }

    @Override
    public Optional<Event> get(ID<Event> id) {
        var result = this.client.GET(baseUrl + "/" + id.id);
        return Optional.of(new EventImpl(result));
    }

    @Override
    public Event create(Event event) {
        var result = this.client.POST(this.baseUrl, ((EventImpl)event).object);
        return new EventImpl(result);
    }

    @Override
    public void delete(ID<Event> event) {
        this.client.DELETE(this.baseUrl+"/"+ event.id);
    }

    @Override
    public Event update(ID<Event> event, EventUpdate update) {
        return new EventImpl(this.client.PATCH(baseUrl+"/"+event.id, ((EventUpdateImpl)update).object));
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
