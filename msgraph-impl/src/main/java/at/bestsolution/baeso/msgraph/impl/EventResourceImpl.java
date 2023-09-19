package at.bestsolution.baeso.msgraph.impl;

import java.util.Optional;

import at.bestsolution.baeso.msgraph.EventResource;
import at.bestsolution.baeso.msgraph.impl.model.EventAcceptImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventCancelImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventForwardImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventUpdateImpl;
import at.bestsolution.baeso.msgraph.model.Event;
import at.bestsolution.baeso.msgraph.model.EventAccept;
import at.bestsolution.baeso.msgraph.model.EventCancel;
import at.bestsolution.baeso.msgraph.model.EventForward;
import at.bestsolution.baeso.msgraph.model.EventUpdate;

public class EventResourceImpl implements EventResource {
    private final GraphClientImpl client;
    private final String baseUrl;

    public EventResourceImpl(GraphClientImpl client, String baseUrl) {
        this.client = client;
        this.baseUrl = baseUrl;
    }

    @Override
    public Optional<Event> get() {
        var result = this.client.GET(baseUrl);
        return Optional.of(new EventImpl(result));
    }

    @Override
    public void delete() {
        this.client.DELETE(this.baseUrl);
    }

    @Override
    public Event update(EventUpdate update) {
        return new EventImpl(this.client.PATCH(baseUrl, ((EventUpdateImpl) update).object));
    }

    @Override
    public void forward(EventForward forward) {
        client.POST(baseUrl + "/forward", ((EventForwardImpl) forward).object);
    }

    @Override
    public void cancel(EventCancel cancel) {
        client.POST(baseUrl + "/cancel", ((EventCancelImpl) cancel).object);
    }

    @Override
    public void accept(EventAccept accept) {
        client.POST(baseUrl + "/accept", ((EventAcceptImpl) accept).object);
    }

}
