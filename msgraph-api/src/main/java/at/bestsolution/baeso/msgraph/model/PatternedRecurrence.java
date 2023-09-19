package at.bestsolution.baeso.msgraph.model;

import java.util.function.Function;

public interface PatternedRecurrence {
    public RecurrencePattern pattern();
    public RecurrenceRange range();

    public interface Builder {
        public PatternedRecurrence build();
        public Builder pattern(RecurrencePattern pattern);
        public Builder withPattern(Function<RecurrencePattern.Builder, RecurrencePattern> builder);
        public Builder range(RecurrenceRange range);
        public Builder withRange(Function<RecurrenceRange.Builder, RecurrenceRange> builder);
    }
}
