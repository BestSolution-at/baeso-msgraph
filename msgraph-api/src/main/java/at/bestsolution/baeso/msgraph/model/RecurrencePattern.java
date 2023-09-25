package at.bestsolution.baeso.msgraph.model;

import java.time.DayOfWeek;
import java.util.List;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

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
            return switch(value) {
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
        DAILY("daily"), 
        WEEKLY("weekly"), 
        ABSOLUTE_MONTHLY("absoluteMonthly"), 
        RELATIVE_MONTHLY("relativeMonthly"), 
        ABSOLUTE_YEARLY("absoluteYearly"), 
        RELATIVE_YEARLY("relativeYearly");

        private final String value;

        RecurrencePatternType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

        public static RecurrencePatternType of(String value) {
            return switch(value) {
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

    public int dayOfMonth();
    public List<DayOfWeek> daysOfWeek();
    public DayOfWeek firstDayOfWeek();
    public WeekIndex index();
    public int interval();
    public int month();
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
