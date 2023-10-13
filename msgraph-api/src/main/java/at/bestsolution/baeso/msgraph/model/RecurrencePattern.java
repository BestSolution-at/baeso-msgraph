package at.bestsolution.baeso.msgraph.model;

import java.time.DayOfWeek;
import java.util.List;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * <p>
 * Describes the frequency by which a recurring event repeats. This shared
 * object is used to define the recurrence of <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/accessreviewscheduledefinition?view=graph-rest-1.0">access
 * reviews</a>, <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/event?view=graph-rest-1.0">calendar
 * events</a>,
 * and <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/accesspackageassignment?view=graph-rest-1.0">access
 * package assignments</a> in Azure AD.
 * </p>
 * <p>
 * You can specify the recurrence pattern of a recurring event in one of 6 ways
 * depending on your scenario. For each pattern type, specify the amount of time
 * between occurrences. The actual occurrences of the recurring event always
 * follow this pattern falling within the date range that you specify for the
 * event. A recurring event is always defined by its
 * <strong>recurrencePattern</strong> (how
 * frequently the event repeats), and its <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/recurrencerange?view=graph-rest-1.0">recurrenceRange</a>
 * (over how long the
 * event repeats).
 * </p>
 * <p>
 * Use the <strong>type</strong> property to specify the different types of
 * <strong>recurrencePattern</strong>,
 * and the <strong>interval</strong> property to specify the time between
 * occurrences, which can
 * be in number of days, weeks, months, or years, depending on the
 * <strong>type</strong>. Note
 * which properties are required for each type, as described in the following
 * table.
 * </p>
 * <p>
 * <strong>Note</strong> Include only the properties that you need for a
 * recurrence pattern. Any
 * property that you include that does not have a supported value would result
 * in an error.
 * </p>
 */
public interface RecurrencePattern extends MsGraphData {
    public enum WeekIndex {
        FIRST("first"),
        SECOND("second"),
        THIRD("third"),
        FOURTH("fourth"),
        LAST("last");

        private final String value;

        WeekIndex(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

        public static WeekIndex of(String value) {
            return switch (value) {
                case "first" -> FIRST;
                case "second" -> SECOND;
                case "third" -> THIRD;
                case "fourth" -> FOURTH;
                case "last" -> LAST;
                default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
            };
        }
    }

    public enum RecurrencePatternType {
        /**
         * <p>
         * Event repeats based on the number of days specified by interval between
         * occurrences.
         * </p>
         * <p>
         * <strong>Sample:</strong>
         * <em>Repeat event every 3 days.</em>
         * </p>
         * <p>
         * <strong>Required properties: </strong>
         * type, interval
         * </p>
         */
        DAILY("daily"),
        /**
         * <p>
         * Event repeats on the same day or days of the week, based on the number of
         * weeks between each set of occurrences.
         * </p>
         * <p>
         * <strong>Sample:</strong>
         * <em>Repeat event Monday and Tuesday of every other week.</em>
         * </p>
         * <p>
         * <strong>Required properties: </strong>
         * type, interval, daysOfWeek, firstDayOfWeek
         * </p>
         * <p>
         * <strong>Note</strong>: For access reviews, only <strong>interval</strong> and
         * <strong>type</strong> properties are supported.
         * </p>
         */
        WEEKLY("weekly"),
        /**
         * <p>
         * Event repeats on the specified day of the month (e.g. the 15th), based on the
         * number of months between occurrences.
         * </p>
         * <p>
         * <strong>Sample:</strong>
         * <em>Repeat event quarterly (every 3 months) on the 15th.</em>
         * </p>
         * <p>
         * <strong>Required properties: </strong>
         * type, interval, dayOfMonth
         * </p>
         * <p>
         * <strong>Note</strong>: For access reviews, only <strong>interval</strong>,
         * <strong>dayOfMonth</strong>, and <strong>type</strong> properties are
         * supported.
         * </p>
         */
        ABSOLUTE_MONTHLY("absoluteMonthly"),
        /**
         * <p>
         * Event repeats on the specified day or days of the week, in the same relative
         * position in the month, based on the number of months between occurrences.
         * </p>
         * <p>
         * <strong>Sample:</strong>
         * <em>Repeat event on the second Thursday or Friday every three months.</em>
         * </p>
         * <p>
         * <strong>Required properties: </strong>
         * type, interval, daysOfWeek
         * </p>
         */
        RELATIVE_MONTHLY("relativeMonthly"),
        /**
         * <p>
         * Event repeats on the specified day and month, based on the number of years
         * between occurrences.
         * </p>
         * <p>
         * <strong>Sample:</strong>
         * <em>Repeat event on the 15th of March every 3 years.</em>
         * </p>
         * <p>
         * <strong>Required properties: </strong>
         * type, interval, dayOfMonth, month
         * </p>
         */
        ABSOLUTE_YEARLY("absoluteYearly"),
        /**
         * <p>
         * Event repeats on the specified day or days of the week, in the same relative
         * position in a specific month of the year, based on the number of years
         * between occurrences.
         * </p>
         * <p>
         * <strong>Sample:</strong>
         * <em>Repeat event on the second Thursday or Friday of every November every 3
         * years.</em>
         * </p>
         * <p>
         * <strong>Required properties: </strong>
         * type, interval, daysOfWeek, month
         * </p>
         */
        RELATIVE_YEARLY("relativeYearly");

        private final String value;

        RecurrencePatternType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

        public static RecurrencePatternType of(String value) {
            return switch (value) {
                case "daily" -> DAILY;
                case "weekly" -> WEEKLY;
                case "absoluteMonthly" -> ABSOLUTE_MONTHLY;
                case "relativeMonthly" -> RELATIVE_MONTHLY;
                case "absoluteYearly" -> ABSOLUTE_YEARLY;
                case "relativeYearly" -> RELATIVE_YEARLY;
                default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
            };
        }
    }

    /**
     * The day of the month on which the event occurs. Required if type is
     * <code>absoluteMonthly</code> or <code>absoluteYearly</code>.
     * 
     * @return the value
     */
    public int dayOfMonth();

    /**
     * <p>
     * A collection of the days of the week on which the event occurs. The possible
     * values are: <code>sunday</code>, <code>monday</code>, <code>tuesday</code>,
     * <code>wednesday</code>, <code>thursday</code>, <code>friday</code>,
     * <code>saturday</code>.
     * </p>
     * <p>
     * If <strong>type</strong> is <code>relativeMonthly</code> or
     * <code>relativeYearly</code>, and <code>daysOfWeek</code> specifies more
     * than one day, the event falls on the first day that satisfies the pattern.
     * </p>
     * <p>
     * Required if <strong>type</strong> is <code>weekly</code>,
     * <code>relativeMonthly</code>, or <code>relativeYearly</code>.
     * </p>
     * 
     * @return the value
     */
    public List<DayOfWeek> daysOfWeek();

    /**
     * The first day of the week. The possible values are: <code>sunday</code>,
     * <code>monday</code>, <code>tuesday</code>,
     * <code>wednesday</code>, <code>thursday</code>, <code>friday</code>,
     * <code>saturday</code>. Default is <code>sunday</code>. Required if
     * <strong>type</strong> is <code>weekly</code>.
     * 
     * @return the value
     */
    public DayOfWeek firstDayOfWeek();

    /**
     * Specifies on which instance of the allowed days specified in
     * <strong>daysOfWeek</strong> the
     * event occurs, counted from the first instance in the month. The possible
     * values are: <code>first</code>, <code>second</code>, <code>third</code>,
     * <code>fourth</code>, last. Default is <code>first</code>. Optional
     * and used if <strong>type</strong> is <code>relativeMonthly</code> or
     * <code>relativeYearly</code>.
     * 
     * @return the value
     */
    public WeekIndex index();

    /**
     * The number of units between occurrences, where units can be in days, weeks,
     * months, or years, depending on the <strong>type</strong>. Required.
     * 
     * @return the value
     */
    public int interval();

    /**
     * The month in which the event occurs. This is a number from 1 to 12.
     * 
     * @return the value
     */
    public int month();

    /**
     * The recurrence pattern type: <code>daily</code>, <code>weekly</code>,
     * <code>absoluteMonthly</code>, <code>relativeMonthly</code>,
     * <code>absoluteYearly</code>, <code>relativeYearly</code>. Required. For more
     * information, see <a href=
     * "https://learn.microsoft.com/en-us/graph/api/resources/recurrencepattern?view=graph-rest-1.0#values-of-type-property">values
     * of
     * type property</a>.
     * 
     * @return the value
     */
    public RecurrencePatternType type();

    public interface Builder {
        public RecurrencePattern build();

        public Builder dayOfMonth(int dayOfMonth);

        public Builder daysOfWeek(List<DayOfWeek> daysOfWeek);

        public Builder firstDayOfWeek(DayOfWeek firstDayOfWeek);

        public Builder index(WeekIndex index);

        public Builder interval(int interval);

        public Builder month(int month);

        public Builder type(RecurrencePatternType type);

    }
}
