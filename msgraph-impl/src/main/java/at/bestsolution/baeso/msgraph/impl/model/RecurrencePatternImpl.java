package at.bestsolution.baeso.msgraph.impl.model;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonString;

import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.RecurrencePattern;

public class RecurrencePatternImpl implements RecurrencePattern {
    public final JsonObject object;

    public RecurrencePatternImpl(JsonObject object) {
        this.object = object;
    }

    @Override
    public int dayOfMonth() {
        return object.getInt("dayOfMonth");
    }

    @Override
    public List<DayOfWeek> daysOfWeek() {
        return object.getJsonArray("daysOfWeek")
            .stream()
            .map(JsonString.class::cast)
            .map(JsonString::getString)
            .map(String::toUpperCase)
            .map(DayOfWeek::valueOf)
            .collect(Collectors.toList());
    }

    @Override
    public DayOfWeek firstDayOfWeek() {
        return DayOfWeek.valueOf(object.getString("firstDayOfWeek").toUpperCase());
    }

    @Override
    public WeekIndex index() {
        return WeekIndex.of(object.getString("index"));
    }

    @Override
    public int interval() {
        return object.getInt("interval");
    }

    @Override
    public int month() {
        return object.getInt("month");
    }

    @Override
    public RecurrencePatternType type() {
        return RecurrencePatternType.of(object.getString("type"));
    }
    
    public static class RecurrencePatternBuilderImpl implements RecurrencePattern.Builder {
        private JsonObjectBuilder builder = Json.createObjectBuilder();

        @Override
        public RecurrencePattern build() {
            return new RecurrencePatternImpl(builder.build());
        }

        @Override
        public Builder dayOfMonth(int dayOfMonth) {
            builder.add("dayOfMonth", dayOfMonth);
            return this;
        }

        @Override
        public Builder daysOfWeek(List<DayOfWeek> daysOfWeek) {
            builder.add("daysOfWeek", daysOfWeek.stream()
                .map(w -> w.name().toLowerCase())
                .collect(JsonUtils.toStringArray())
            );
            return this;
        }

        @Override
        public Builder firstDayOfWeek(DayOfWeek firstDayOfWeek) {
            builder.add("firstDayOfWeek", firstDayOfWeek.name().toLowerCase());
            return this;
        }

        @Override
        public Builder index(WeekIndex index) {
            builder.add("index", index.value());
            return this;
        }

        @Override
        public Builder interval(int interval) {
            builder.add("interval", interval);
            return this;
        }

        @Override
        public Builder month(int month) {
            builder.add("month", month);
            return this;
        }

        @Override
        public Builder type(RecurrencePatternType type) {
            builder.add("type", type.value());
            return this;
        }

    }
}
