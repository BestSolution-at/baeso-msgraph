package at.bestsolution.baeso.msgraph.model;

import java.time.LocalDate;

public interface RecurrenceRange {
    public enum RecurrenceRangeType {
        END_DATE("endDate"), 
        NO_END("noEnd"), 
        NUMBERED("numbered");

        private final String value;

        RecurrenceRangeType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

        public static RecurrenceRangeType of(String value) {
            return switch(value) {
                case "endDate" -> END_DATE;
                case "noEnd" -> NO_END;
                case "numbered" -> NUMBERED;
                default -> throw new IllegalArgumentException(String.format("Unknown value '%s'", value));
            };
        }
    }

    public LocalDate endDate();
    public int numberOfOccurrences();
    public String recurrenceTimeZone();
    public LocalDate startDate();
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
