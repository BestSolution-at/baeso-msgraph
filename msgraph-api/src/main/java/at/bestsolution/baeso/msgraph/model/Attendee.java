package at.bestsolution.baeso.msgraph.model;

import java.util.function.Function;

/**
 * An event attendee that can be a person or resource such as a meeting room or
 * equipment, that has been set up as a resource on the Exchange server for the
 * tenant.
 */
public interface Attendee extends AttendeeBase {

    /**
     * An alternate date/time proposed by the attendee for a meeting request to
     * start and end. If the attendee hasn't proposed another time, then this
     * property isn't included in a response of a GET event.
     * 
     * @return the value
     */
    TimeSlot proposedNewTime();

    /**
     * The attendee's response (none, accepted, declined, etc.) for the event and
     * date-time that the response was sent.
     * 
     * @return the value
     */
    ResponseStatus status();

    public interface Builder {
        public Builder type(Type type);

        public Builder emailAddress(EmailAddress address);
        public Builder withEmailAddress(Function<EmailAddress.Builder, EmailAddress> builder);

        public Builder proposedNewTime(TimeSlot proposedNewTime);
        public Builder withProposedNewTime(Function<TimeSlot.Builder, TimeSlot> builder);

        public Builder status(ResponseStatus status);
        public Builder withStatus(Function<ResponseStatus.Builder, ResponseStatus> builder);

        public Attendee build();
    }
}
