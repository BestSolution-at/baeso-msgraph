package at.bestsolution.baeso.msgraph.model;

import java.time.ZonedDateTime;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

public interface TimeSlot extends MsGraphData {
    ZonedDateTime end();
    ZonedDateTime start();
}
