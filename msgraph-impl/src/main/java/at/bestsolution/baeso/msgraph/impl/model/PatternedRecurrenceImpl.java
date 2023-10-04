package at.bestsolution.baeso.msgraph.impl.model;

import java.util.function.Function;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

import at.bestsolution.baeso.msgraph.model.PatternedRecurrence;
import at.bestsolution.baeso.msgraph.model.RecurrencePattern;
import at.bestsolution.baeso.msgraph.model.RecurrenceRange;

public class PatternedRecurrenceImpl implements PatternedRecurrence {
    public final JsonObject object;

    public PatternedRecurrenceImpl(JsonObject object) {
        this.object = object;
    }

    @Override
    public RecurrencePattern pattern() {
        return new RecurrencePatternImpl(object.getJsonObject("pattern"));
    }

    @Override
    public RecurrenceRange range() {
        return new RecurrenceRangeImpl(object.getJsonObject("range"));
    }
    
    public static class PatternedRecurrenceBuilderImpl implements PatternedRecurrence.Builder {
        private JsonObjectBuilder builder = Json.createObjectBuilder();

        @Override
        public PatternedRecurrence build() {
            return new PatternedRecurrenceImpl(builder.build());
        }

        @Override
        public Builder pattern(RecurrencePattern pattern) {
            builder.add("pattern", ((RecurrencePatternImpl)pattern).object);
            return this;
        }

        @Override
        public Builder withPattern(Function<RecurrencePattern.Builder, RecurrencePattern> builder) {
            return pattern(builder.apply(new RecurrencePatternImpl.RecurrencePatternBuilderImpl()));
        }

        @Override
        public Builder range(RecurrenceRange range) {
            builder.add("range", ((RecurrenceRangeImpl)range).object);
            return this;
        }

        @Override
        public Builder withRange(Function<RecurrenceRange.Builder, RecurrenceRange> builder) {
            return range(builder.apply(new RecurrenceRangeImpl.RecurrenceRangeBuilderImpl()));
        }
    }
}
