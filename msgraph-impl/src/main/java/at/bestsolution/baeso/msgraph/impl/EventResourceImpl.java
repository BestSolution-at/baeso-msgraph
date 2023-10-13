package at.bestsolution.baeso.msgraph.impl;

import java.util.Optional;
import java.util.function.Function;

import at.bestsolution.baeso.msgraph.EventResource;
import at.bestsolution.baeso.msgraph.impl.model.EventAcceptImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventCancelImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventDeclineImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventForwardImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventSnoozeReminderImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventTentativelyAcceptImpl;
import at.bestsolution.baeso.msgraph.impl.model.EventUpdateImpl;
import at.bestsolution.baeso.msgraph.model.Event;
import at.bestsolution.baeso.msgraph.model.EventAccept;
import at.bestsolution.baeso.msgraph.model.EventCancel;
import at.bestsolution.baeso.msgraph.model.EventDecline;
import at.bestsolution.baeso.msgraph.model.EventForward;
import at.bestsolution.baeso.msgraph.model.EventSnoozeReminder;
import at.bestsolution.baeso.msgraph.model.EventTentativelyAccept;
import at.bestsolution.baeso.msgraph.model.EventUpdate;
import at.bestsolution.baeso.msgraph.model.EventUpdate.Builder;

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
    public Event update(Function<Builder, EventUpdate> update) {
        return update( update.apply(new EventUpdateImpl.EventUpdateBuilderImpl()) );
    }

    @Override
    public void forward(EventForward forward) {
        client.POST_VOID(baseUrl + "/forward", ((EventForwardImpl) forward).object);
    }

    @Override
    public void forward(Function<EventForward.Builder, EventForward> forward) {
        forward(forward.apply(new EventForwardImpl.EventForwardBuilderImpl()));
    }

    @Override
    public void cancel(EventCancel cancel) {
        client.POST_VOID(baseUrl + "/cancel", ((EventCancelImpl) cancel).object);
    }

    @Override
    public void cancel(Function<EventCancel.Builder, EventCancel> cancel) {
        cancel(cancel.apply(new EventCancelImpl.EventCancelBuilderImpl()));
    }

    @Override
    public void accept(EventAccept accept) {
        client.POST(baseUrl + "/accept", ((EventAcceptImpl) accept).object);
    }

    @Override
    public void accept(Function<EventAccept.Builder, EventAccept> accept) {
        accept(accept.apply(new EventAcceptImpl.EventAcceptBuilderImpl()));
    }

    @Override
    public void decline(EventDecline decline) {
        client.POST_VOID(baseUrl + "/decline", ((EventDeclineImpl)decline).object);
    }

    @Override
    public void decline(Function<EventDecline.Builder, EventDecline> decline) {
        decline(decline.apply(new EventDeclineImpl.EventDeclineBuilderImpl()));
    }

    @Override
    public void dismissReminder() {
        client.POST_VOID(baseUrl + "/dismissReminder");
    }

    @Override
    public void snoozeReminder(EventSnoozeReminder snoozeReminder) {
        client.POST_VOID(baseUrl + "/snoozeReminder", ((EventSnoozeReminderImpl)snoozeReminder).object);
    }

    @Override
    public void snoozeReminder(Function<EventSnoozeReminder.Builder, EventSnoozeReminder> snoozeReminder) {
        snoozeReminder(snoozeReminder.apply(new EventSnoozeReminderImpl.EventSnoozeReminderBuilderImpl()));
    }

    @Override
    public void tentativelyAccept(EventTentativelyAccept tentativelyAccept) {
        client.POST_VOID(baseUrl + "/tentativelyAccept", ((EventTentativelyAcceptImpl)tentativelyAccept).object);
    }

    @Override
    public void tentativelyAccept(Function<EventTentativelyAccept.Builder, EventTentativelyAccept> tentativelyAccept) {
        tentativelyAccept(tentativelyAccept.apply(new EventTentativelyAcceptImpl.EventTentativelyAcceptBuilderImpl()));
    }
}
