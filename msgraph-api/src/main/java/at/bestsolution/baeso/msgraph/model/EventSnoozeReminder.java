package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;

/**
 * Postpone a reminder for an <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>
 * in a user <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/calendar?view=graph-rest-1.0">calendar</a>
 * until a new time.
 */
public interface EventSnoozeReminder {
    /**
     * The new date and time to trigger the reminder.
     * 
     * @return the value
     */
    ZonedDateTime newReminderTime();

    public interface Builder {
        public EventSnoozeReminder build();
        Builder newReminderTime(ZonedDateTime newReminderTime);
    }
}
