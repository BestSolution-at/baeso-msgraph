package at.bestsolution.baeso.msgraph.model;

import java.time.LocalDate;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

/**
 * <p>
 * Describes a date range over which a recurring event. This shared object is
 * used to define the recurrence of access reviews, calendar events, and access
 * package assignments in Azure AD.
 * </p>
 * <p>
 * You can specify the date range for a recurring event in one of 3 ways
 * depending on your scenario. While you must always specify a
 * <strong>startDate</strong> value
 * for the date range, you can specify a recurring event that ends by a specific
 * date, or that doesn't end, or that ends after a specific number of
 * occurrences. Note that the actual occurrences within the date range always
 * follow the recurrence pattern that you specify for the recurring event. A
 * recurring event is always defined by its <a href=
 * "https://learn.microsoft.com/en-us/graph/api/resources/recurrencepattern?view=graph-rest-1.0">recurrencePattern</a>
 * (how frequently
 * the event repeats), and its <strong>recurrenceRange</strong> (for how long
 * the event repeats).
 * </p>
 */
public interface RecurrenceRange extends MsGraphData {
    public enum RecurrenceRangeType {
        /**
         * <p>
         * Event repeats on all the days that fit the corresponding recurrence pattern
         * between the <strong>startDate</strong> and <strong>endDate</strong>
         * inclusive.
         * </p>
         * <p>
         * <strong>Sample: </strong>
         * <em>Repeat event in the date range between June 1, 2017 and June 15,
         * 2017.</em>
         * </p>
         * <p>
         * <strong>Required properties: </strong>
         * type, startDate, endDate
         * </p>
         */
        END_DATE("endDate"),
        /**
         * <p>
         * Event repeats on all the days that fit the corresponding recurrence pattern
         * beginning on the <strong>startDate</strong>.
         * </p>
         * <p>
         * <strong>Sample: </strong>
         * <em>Repeat event in the date range starting on June 1, 2017
         * indefinitely.</em>
         * </p>
         * <p>
         * <strong>Required properties: </strong>
         * type, startDate
         * </p>
         */
        NO_END("noEnd"),
        /**
         * <p>
         * Event repeats for the <strong>numberOfOccurrences</strong> based on the
         * recurrence pattern beginning on the <strong>startDate</strong>.
         * </p>
         * <p>
         * <strong>Sample: </strong>
         * <em>Repeat event in the date range starting on June 1, 2017, for 10
         * occurrences.</em>
         * </p>
         * <p>
         * <strong>Required properties: </strong>
         * type, startDate, numberOfOccurrences
         * </p>
         */
        NUMBERED("numbered");

        private final String value;

        RecurrenceRangeType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

        public static RecurrenceRangeType of(String value) {
            return switch (value) {
                case "endDate" -> END_DATE;
                case "noEnd" -> NO_END;
                case "numbered" -> NUMBERED;
                default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
            };
        }
    }

    /**
     * The date to stop applying the recurrence pattern. Depending on the recurrence
     * pattern of the event, the last occurrence of the meeting may not be this
     * date. Required if <strong>type</strong> is <code>endDate</code>.
     * 
     * @return the value
     */
    public LocalDate endDate();

    /**
     * The number of times to repeat the event. Required and must be positive if
     * <strong>type</strong> is <code>numbered</code>.
     * 
     * @return the value
     */
    public int numberOfOccurrences();

    /**
     * Time zone for the <strong>startDate</strong> and <strong>endDate</strong>
     * properties. Optional. If not
     * specified, the time zone of the event is used.
     * 
     * @return the value
     */
    public String recurrenceTimeZone();

    /**
     * The date to start applying the recurrence pattern. The first occurrence of
     * the meeting may be this date or later, depending on the recurrence pattern of
     * the event. Must be the same value as the <strong>start</strong> property of
     * the recurring
     * event. Required.
     * 
     * @return the value
     */
    public LocalDate startDate();

    /**
     * The recurrence range. The possible values are: <code>endDate</code>,
     * <code>noEnd</code>, <code>numbered</code>. Required.
     * 
     * @return the value
     */
    public RecurrenceRangeType type();

    public interface Builder {
        public RecurrenceRange build();

        public Builder endDate(LocalDate endDate);

        public Builder numberOfOccurrences(int numberOfOccurrences);

        public Builder recurrenceTimeZone(String recurrenceTimeZone);

        public Builder startDate(LocalDate startDate);

        public Builder type(RecurrenceRangeType type);
    }
}
