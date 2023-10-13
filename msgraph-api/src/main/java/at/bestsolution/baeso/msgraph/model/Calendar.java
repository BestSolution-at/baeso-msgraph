package at.bestsolution.baeso.msgraph.model;

import java.util.List;
import java.util.function.Function;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * <p>
 * Represents a container for <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">event</a>
 * resources. It can be a calendar for a user,
 * or the default calendar of a Microsoft 365 <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/group?view=graph-rest-1.0">group</a>.
 * </p>
 */
public interface Calendar extends MsGraphData {
    /**
     * Color of the calendar
     */
    public enum Color {
        AUTO("auto"),
        LIGHT_BLUE("lightBlue"),
        LIGHT_GREEN("lightGreen"),
        LIGHT_ORANGE("lightOrange"),
        LIGHT_GRAY("lightGray"),
        LIGHT_YELLOW("lightYellow"),
        LIGHT_TEAL("lightTeal"),
        LIGHT_PINK("lightPink"),
        LIGHT_BROWN("lightBrown"),
        LIGHT_RED("lightRed"),
        MAX_COLOR("maxColor");

        private final String value;

        Color(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

        public static Color of(String value) {
            return switch (value) {
                case "auto" -> AUTO;
                case "lightBlue" -> LIGHT_BLUE;
                case "lightGreen" -> LIGHT_GREEN;
                case "lightOrange" -> LIGHT_ORANGE;
                case "lightGray" -> LIGHT_GRAY;
                case "lightYellow" -> LIGHT_YELLOW;
                case "lightTeal" -> LIGHT_TEAL;
                case "lightPink" -> LIGHT_PINK;
                case "lightBrown" -> LIGHT_BROWN;
                case "lightRed" -> LIGHT_RED;
                case "maxColor" -> MAX_COLOR;
                default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
            };
        }
    }

    public enum OnlineMeetingProviderType {
        UNKNOWN("unknown"),
        SKYPE_FOR_BUSINESS("skypeForBusiness"),
        SKYPE_FOR_CONSUMER("skypeForConsumer"),
        TEAMS_FOR_BUSINESS("teamsForBusiness");

        private final String value;

        OnlineMeetingProviderType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

        public static OnlineMeetingProviderType of(String value) {
            return switch (value) {
                case "unknown" -> UNKNOWN;
                case "skypeForBusiness" -> SKYPE_FOR_BUSINESS;
                case "skypeForConsumer" -> SKYPE_FOR_CONSUMER;
                case "teamsForBusiness" -> TEAMS_FOR_BUSINESS;
                default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
            };
        }
    }

    /**
     * The calendar's unique identifier. Read-only.
     * 
     * @return value
     */
    ID<Calendar> id();

    /**
     * The calendar name.
     * 
     * @return value
     */
    String name();

    /**
     * <code>true</code> if the user can write to the calendar, <code>false</code>
     * otherwise. This property is <code>true</code>‚ for the user who created the
     * calendar. This property is also <code>true</code> for a user who has been
     * shared a calendar and granted write access.
     * 
     * @return
     */
    boolean canEdit();

    /**
     * <code>true</code> if the user has the permission to share the calendar,
     * <code>false</code> otherwise. Only the user who created the calendar can
     * share it.
     * 
     * @return value
     */
    boolean canShare();

    /**
     * <code>true</code> if the user can read calendar items that have been marked
     * private, <code>false</code> otherwise.
     * 
     * @return value
     */
    boolean canViewPrivateItems();

    /**
     * Identifies the version of the calendar object. Every time the calendar is
     * changed, changeKey changes as well. This allows Exchange to apply changes to
     * the correct version of the object. Read-only.
     * 
     * @return value
     */
    String changeKey();

    /**
     * Specifies the color theme to distinguish the calendar from other calendars in
     * a UI. The property values are: <code>auto</code>, <code>lightBlue</code>,
     * <code>lightGreen</code>, <code>lightOrange</code>, <code>lightGray</code>,
     * <code>lightYellow</code>, <code>lightTeal</code>, <code>lightPink</code>,
     * <code>lightBrown</code>, <code>lightRed</code>, <code>maxColor</code>.
     * 
     * @return value
     */
    Color color();

    /**
     * The default online meeting provider for meetings sent from this calendar.
     * Possible values are: <code>unknown</code>, <code>skypeForBusiness</code>,
     * <code>skypeForConsumer</code>, <code>teamsForBusiness</code>.
     * 
     * @return value
     */
    OnlineMeetingProviderType defaultOnlineMeetingProvider();

    /**
     * The calendar color, expressed in a hex color code of three hexadecimal
     * values, each ranging from 00 to FF and representing the red, green, or blue
     * components of the color in the RGB color space. If the user has never
     * explicitly set a color for the calendar, this property is empty. Read-only.
     * 
     * @return value
     */
    String hexColor();

    /**
     * <code>true</code> if this is the default calendar where new events are
     * created by default, <code>false</code> otherwise.
     * 
     * @return value
     */
    boolean isDefaultCalendar();

    /**
     * Indicates whether this user calendar can be deleted from the user mailbox.
     * 
     * @return value
     */
    boolean isRemovable();

    /**
     * Indicates whether this user calendar supports tracking of meeting responses.
     * Only meeting invites sent from users' primary calendars support tracking of
     * meeting responses.
     * 
     * @return value
     */
    boolean isTallyingResponses();

    /**
     * If set, this represents the user who created or added the calendar. For a
     * calendar that the user created or added, the <strong>owner</strong> property
     * is set to the user. For a calendar shared with the user, the
     * <strong>owner</strong> property is set to the person who shared that calendar
     * with the user.
     * 
     * @return value
     */
    EmailAddress owner();

    /**
     * Represent the online meeting service providers that can be used to create
     * online meetings in this calendar. Possible values are: <code>unknown</code>,
     * <code>skypeForBusiness</code>, <code>skypeForConsumer</code>,
     * <code>teamsForBusiness</code>.
     * 
     * @return the value
     */
    List<OnlineMeetingProviderType> allowedOnlineMeetingProviders();

    public interface Builder {
        public Calendar build();

        Builder name(String name);

        Builder canEdit(boolean canEdit);

        Builder canShare(boolean canShare);

        Builder canViewPrivateItems(boolean canViewPrivateItems);

//        Builder changeKey(String changeKey);

        Builder color(Color color);

        Builder defaultOnlineMeetingProvider(OnlineMeetingProviderType defaultOnlineMeetingProvider);

//        Builder hexColor(String hexColor);

        Builder isDefaultCalendar(boolean isDefaultCalendar);

        Builder isRemovable(boolean isRemovable);

        Builder isTallyingResponses(boolean isTallyingResponses);

//        Builder owner(EmailAddress owner);

//        Builder withOwner(Function<EmailAddress.Builder, EmailAddress> builder);
    }
}
