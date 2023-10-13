package at.bestsolution.baeso.msgraph.model;

import java.util.List;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * The permissions of a user with whom the calendar has been shared or delegated
 * in an Outlook client.
 */
public interface CalendarPermission extends MsGraphData {
    public enum CalendarRoleType {
        /**
         * Calendar isn't shared with the user.
         */
        NONE("none"),
        /**
         * User is a recipient who can view free/busy status of the owner on the
         * calendar.
         */
        FREE_BUSY_READ("freeBusyRead"),
        /**
         * User is a recipient who can view free/busy status, and titles and locations
         * of the events on the calendar.
         */
        LIMITED_READ("limitedRead"),
        /**
         * User is a recipient who can view all the details of the events on the
         * calendar, except for the owner's private events.
         */
        READ("read"),
        /**
         * User is a recipient who can view all the details (except for private events)
         * and edit events on the calendar.
         */
        WRITE("write"),
        /**
         * User is a delegate who has write access but can't view information of the
         * owner's private events on the calendar.
         */
        DELEGATE_WITHOUT_PRIVATE_EVENT_ACCESS("delegateWithoutPrivateEventAccess"),
        /**
         * User is a delegate who has write access and can view information of the
         * owner's private events on the calendar.
         */
        DELEGATE_WITH_PRIVATE_EVENT_ACCESS("delegateWithPrivateEventAccess"),
        /**
         * User has custom permissions to the calendar.
         */
        CUSTOM("custom");

        private final String value;

        CalendarRoleType(String value) {
            this.value = value;
        }

        /**
         * @return source value in REST-API
         */
        public String value() {
            return this.value;
        }

        /**
         * Convert from value in REST-API
         * 
         * @param value the value
         * @return the type
         * @throws IllegalArgumentException if value is not known
         */
        public static CalendarRoleType of(String value) {
            return switch (value) {
                case "none" -> NONE;
                case "freeBusyRead" -> FREE_BUSY_READ;
                case "limitedRead" -> LIMITED_READ;
                case "read" -> READ;
                case "write" -> WRITE;
                case "delegateWithoutPrivateEventAccess" -> DELEGATE_WITHOUT_PRIVATE_EVENT_ACCESS;
                case "delegateWithPrivateEventAccess" -> DELEGATE_WITH_PRIVATE_EVENT_ACCESS;
                case "custom" -> CUSTOM;
                default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
            };
        }
    }

    /**
     * List of allowed sharing or delegating permission levels for the calendar.
     * Possible values are: <code>none</code>, <code>freeBusyRead</code>,
     * <code>limitedRead</code>, <code>read</code>, <code>write</code>,
     * <code>delegateWithoutPrivateEventAccess</code>,
     * <code>delegateWithPrivateEventAccess</code>, <code>custom</code>.
     * 
     * @return the value
     */
    List<CalendarRoleType> allowedRoles();

    /**
     * Represents a share recipient or delegate who has access to the calendar. For
     * the "My Organization" share recipient, the <strong>address</strong> property
     * is null.
     * Read-only.
     * 
     * @return the value
     */
    EmailAddress emailAddress();

    /**
     * The unique identifier of the user (recipient or delegate) with whom the
     * calendar has been shared. Read-only.
     * 
     * @return the value
     */
    ID<CalendarPermission> id();

    /**
     * True if the user in context (recipient or delegate) is inside the same
     * organization as the calendar owner.
     * 
     * @return the value
     */
    boolean isInsideOrganization();

    /**
     * <code>True</code> if the user can be removed from the list of recipients or
     * delegates for
     * the specified calendar, <code>false</code> otherwise. The "My organization"
     * user
     * determines the permissions other people within your organization have to the
     * given calendar. You can't remove "My organization" as a share recipient to a
     * calendar.
     * 
     * @return the value
     */
    boolean isRemovable();

    /**
     * Current permission level of the calendar share recipient or delegate.
     * 
     * @return the value
     */
    CalendarRoleType role();
}
