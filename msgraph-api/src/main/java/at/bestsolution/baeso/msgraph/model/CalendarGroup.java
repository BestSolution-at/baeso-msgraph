package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.MsGraphData;

public interface CalendarGroup extends MsGraphData {
    public String name();
    public String changeKey();
    public String classId();
    public ID<CalendarGroup> id();
}
