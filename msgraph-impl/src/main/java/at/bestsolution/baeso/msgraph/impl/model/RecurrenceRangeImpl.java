package at.bestsolution.baeso.msgraph.impl.model;

import java.time.LocalDate;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

import at.bestsolution.baeso.msgraph.model.RecurrenceRange;

public class RecurrenceRangeImpl implements RecurrenceRange {
    public final JsonObject object;

    public RecurrenceRangeImpl(JsonObject object) {
        this.object = object;
    }

    @Override
    public LocalDate endDate() {
        return LocalDate.parse(object.getString("endDate"));
    }

    @Override
    public int numberOfOccurrences() {
        return object.getInt("numberOfOccurrences");
    }

    @Override
    public String recurrenceTimeZone() {
        return object.getString("recurrenceTimeZone");
    }

    @Override
    public LocalDate startDate() {
        return LocalDate.parse(object.getString("startDate"));
    }

    @Override
    public RecurrenceRangeType type() {
        return RecurrenceRangeType.of(object.getString("type"));
    }
    
    public static class RecurrenceRangeBuilderImpl implements RecurrenceRange.Builder {
        private JsonObjectBuilder builder = Json.createObjectBuilder();

        @Override
        public RecurrenceRange build() {
            return new RecurrenceRangeImpl(builder.build());
        }

        @Override
        public Builder endDate(LocalDate endDate) {
            builder.add("endDate", endDate.toString());
            return this;
        }

        @Override
        public Builder numberOfOccurrences(int numberOfOccurrences) {
            builder.add("numberOfOccurrences", numberOfOccurrences);
            return this;
        }

        @Override
        public Builder recurrenceTimeZone(String recurrenceTimeZone) {
            builder.add("recurrenceTimeZone", recurrenceTimeZone);
            return this;
        }

        @Override
        public Builder startDate(LocalDate startDate) {
            builder.add("startDate", startDate.toString());
            return this;
        }

        @Override
        public Builder type(RecurrenceRangeType type) {
            builder.add("type", type.value());
            return this;
        }

    }
}
