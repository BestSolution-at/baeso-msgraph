package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * Represents a time slot for a meeting.
 */
public interface TimeSlot extends MsGraphData {
    /**
     * The date, time, and time zone that a period ends.
     * 
     * @return the value
     */
    ZonedDateTime end();

    /**
     * The date, time, and time zone that a period begins.
     * @return the value
     */
    ZonedDateTime start();

    public interface Builder {
        public TimeSlot build();
        Builder end(ZonedDateTime end);
        Builder start(ZonedDateTime start);
    }
}
