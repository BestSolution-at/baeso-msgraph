package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;
import java.util.List;

import at.bestsolution.baeso.msgraph.base.MsGraphData;
import at.bestsolution.baeso.msgraph.model.Event.OnlineMeetingProviderType;
import at.bestsolution.baeso.msgraph.model.Event.Sensitivity;
import at.bestsolution.baeso.msgraph.model.Event.ShowAs;

/**
 * Update an event
 */
public interface EventUpdate extends MsGraphData {
    /**
     * The collection of attendees for the event.
     * 
     * @return the value
     */
    List<Attendee> attendees();

    /**
     * The body of the message associated with the event.
     * 
     * @return the value
     */
    ItemBody body();

    /**
     * The categories associated with the event.
     * 
     * @return the value
     */
    List<String> categories();

    /**
     * The date, time, and time zone that the event ends.
     * 
     * @return the value
     */
    ZonedDateTime end();

    /**
     * When set to true, each attendee only sees themselves in the meeting request
     * and meeting <strong>Tracking</strong> list. Default is <code>false</code>.
     * 
     * @return the value
     */
    boolean hideAttendees();

    /**
     * The importance of the event. The possible values are: <code>low</code>,
     * <code>normal</code>, <code>high</code>.
     * 
     * @return the value
     */
    Event.Importance importance();

    /**
     * Set to true if the event lasts all day.
     * 
     * @return the value
     */
    boolean isAllDay();

    /**
     * <code>True</code> if this event has online meeting information,
     * <code>false</code> otherwise. Default is false. Optional.
     * 
     * @return the value
     */
    boolean isOnlineMeeting();

    /**
     * Set to true if an alert is set to remind the user of the event.
     * 
     * @return the value
     */
    boolean isReminderOn();

    /**
     * The location of the event.
     * 
     * @return the value
     */
    Location location();

    /**
     * The locations where the event is held or attended from. The
     * <strong>location</strong> and
     * <strong>locations</strong> properties always correspond with each other. If
     * you update the
     * <strong>location</strong> property, any prior locations in the
     * <strong>locations</strong> collection would be
     * removed and replaced by the new <code>location</code> value.
     * 
     * @return the value
     */
    List<Location> locations();

    /**
     * Represents the online meeting service provider. The possible values are
     * <code>teamsForBusiness</code>, <code>skypeForBusiness</code>, and
     * <code>skypeForConsumer</code>. Optional.
     * 
     * @return the value
     */
    OnlineMeetingProviderType onlineMeetingProvider();

    /**
     * The recurrence pattern for the event.
     * 
     * @return the value
     */
    PatternedRecurrence recurrence();

    /**
     * The number of minutes before the event start time that the reminder alert
     * occurs.
     * 
     * @return the value
     */
    int reminderMinutesBeforeStart();

    /**
     * Set to true if the sender would like a response when the event is accepted or
     * declined.
     * 
     * @return the value
     */
    boolean responseRequested();

    /**
     * The possible values are: <code>normal</code>, <code>personal</code>,
     * <code>private</code>, <code>confidential</code>.
     * 
     * @return the value
     */
    Sensitivity sensitivity();

    /**
     * The status to show. The possible values are: <code>free</code>,
     * <code>tentative</code>, <code>busy</code>,
     * <code>oof</coode>, <code>workingElsewhere</code>, <code>unknown</code>.
     * 
     * @return the value
     */
    ShowAs showAs();

    /**
     * The start date, time, and time zone of the event.
     * 
     * @return the value
     */
    ZonedDateTime start();

    /**
     * The text of the event's subject line.
     * 
     * @return the value
     */
    String subject();

    public interface Builder {
        EventUpdate build();

        Builder attendees(List<Attendee> attendees);

        Builder body(ItemBody body);

        Builder categories(List<String> categories);

        Builder end(ZonedDateTime end);

        Builder hideAttendees(boolean hideAttendees);

        Builder importance(Event.Importance importance);

        Builder isAllDay(boolean isAllDay);

        Builder isOnlineMeeting(boolean isOnlineMeeting);

        Builder isReminderOn(boolean isReminderOn);

        Builder location(Location location);

        Builder locations(List<Location> locations);

        Builder onlineMeetingProvider(OnlineMeetingProviderType onlineMeetingProvider);

        Builder recurrence(PatternedRecurrence recurrence);

        Builder reminderMinutesBeforeStart(int reminderMinutesBeforeStart);

        Builder responseRequested(boolean responseRequested);

        Builder sensitivity(Sensitivity sensitivity);

        Builder showAs(ShowAs showAs);

        Builder start(ZonedDateTime start);

        Builder subject(String subject);
    }
}
