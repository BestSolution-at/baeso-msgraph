package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;
import java.util.List;

import at.bestsolution.baeso.msgraph.base.MsGraphData;
import at.bestsolution.baeso.msgraph.model.Event.OnlineMeetingProviderType;
import at.bestsolution.baeso.msgraph.model.Event.Sensitivity;
import at.bestsolution.baeso.msgraph.model.Event.ShowAs;

public interface EventUpdate extends MsGraphData {
    List<Attendee> attendees();
    ItemBody body();
    List<String> categories();
    ZonedDateTime end();
    boolean hideAttendees();
    boolean importance();
    boolean isAllDay();
    boolean isOnlineMeeting();
    boolean isReminderOn();
    Location location();
    List<Location> locations();
    OnlineMeetingProviderType onlineMeetingProvider();
    PatternedRecurrence recurrence();
    int reminderMinutesBeforeStart();
    boolean responseRequested();
    Sensitivity sensitivity();
    ShowAs showAs();
    ZonedDateTime start();
    String subject();

    public interface Builder {
        EventUpdate build();
        
        Builder attendees(List<Attendee> attendees);
        Builder body(ItemBody body);
        Builder categories(List<String> categories);
        Builder end(ZonedDateTime end);
        Builder hideAttendees(boolean hideAttendees);
        Builder importance(boolean importance);
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
