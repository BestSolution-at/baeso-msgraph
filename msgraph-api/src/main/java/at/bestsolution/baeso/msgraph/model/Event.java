package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;

import at.bestsolution.baeso.msgraph.base.ID;

public interface Event {
    /**
     * Unique identifier for the event. By default, this value changes when the item 
     * is moved from one container (such as a folder or calendar) to another. 
     * 
     * To change this behavior, use the <code>Prefer: IdType="ImmutableId"</code> header. 
     * See Get immutable identifiers for Outlook resources for more information. 
     * Case-sensitive and read-only.
     * @return value
     */
    ID<Event> id();
    /**
     * The start date, time in the local time zone
     * @return value
     */
    ZonedDateTime start();
    /** 
     * the end date, time in the local time zone 
     * @return value
     */
    ZonedDateTime end();
    /** 
     * The text of the event's subject line. 
     * @return value
     */
    String subject();
    /**
     * <code>true</code> if the meeting organizer allows invitees to propose a new time 
     * when responding; otherwise, <code>false</code>
     * @return value
     */
    boolean allowNewTimeProposals();
    /**
     * The body of the message associated with the event. It can be in HTML or text format.
     * @return value
     */
    ItemBody body();
    /**
     * The preview of the message associated with the event. It is in text format.
     * @return value
     */
    //String bodyPreview();
    // List<String> categories();
    // String changeKey;
    // ZonedDateTime createdDateTime();
    // boolean hasAttachments();
    // boolean hideAttendees();
    // ID<Event> iCalUId();
    // String importance();
    // boolean isAllDay();
    // boolean isCancelled();
    // boolean isDraft();
    // boolean isOnlineMeeting();
    // boolean isOrganizer();
    // boolean isReminderOn();
    // ZonedDateTime lastModifiedDateTime();
    
    public interface Builder {
        public Event build();
        public Builder start(ZonedDateTime start);
        public Builder end(ZonedDateTime end);
        public Builder subject(String subject);
        public Builder allowNewTimeProposals(boolean allowNewTimeProposals);
        // public Builder body();
    }
}
