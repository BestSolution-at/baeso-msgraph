package at.bestsolution.baeso.msgraph.model;

import java.util.function.Function;

import at.bestsolution.baeso.msgraph.base.MsGraphData;

public interface PatternedRecurrence extends MsGraphData {
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
