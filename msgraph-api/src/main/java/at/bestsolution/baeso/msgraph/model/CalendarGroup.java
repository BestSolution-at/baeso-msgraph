package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * A group of user calendars.
 */
public interface CalendarGroup extends MsGraphData {
    /**
     * The group name.
     * 
     * @return the value
     */
    String name();

    /**
     * Identifies the version of the calendar group. Every time the calendar group
     * is changed, ChangeKey changes as well. This allows Exchange to apply changes
     * to the correct version of the object. Read-only.
     * 
     * @return the value
     */
    String changeKey();

    /**
     * The class identifier. Read-only.
     * 
     * @return the value
     */
    String classId();

    /**
     * The group's unique identifier. Read-only.
     * 
     * @return the value
     */
    ID<CalendarGroup> id();

    public interface Builder {
        public CalendarGroup build();
        Builder name(String name);
        Builder changeKey(String changeKey);
        Builder classId(String classId);
    }
}
