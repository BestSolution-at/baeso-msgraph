package at.bestsolution.baeso.msgraph.model;

import java.util.function.Function;

public interface Attendee extends AttendeeBase {
    
    // Optional<TimeSlot> proposedNewTime();
    // ResponseStatus status();
    
    public interface Builder {
        public Builder type(Type type);
        public Builder emailAddress(EmailAddress address);
        public Builder withEmailAddress( Function<EmailAddress.Builder, EmailAddress> builder);
        public Attendee build();
    }
}
