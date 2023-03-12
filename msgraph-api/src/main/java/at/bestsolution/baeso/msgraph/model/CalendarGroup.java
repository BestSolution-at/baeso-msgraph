package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.ID;

public interface CalendarGroup {
    public String name();
    public String changeKey();
    public String classId();
    public ID<CalendarGroup> id();
}
