package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;

public interface TimeSlot {
    ZonedDateTime end();
    ZonedDateTime start();
}
