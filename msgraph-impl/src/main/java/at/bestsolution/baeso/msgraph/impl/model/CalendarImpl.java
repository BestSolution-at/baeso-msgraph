package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.model.Calendar;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class CalendarImpl implements Calendar {
    public final JsonObject object;

    public CalendarImpl(JsonObject object) {
        this.object = object;
    }

    @Override
    public ID<Calendar> id() {
        return ID.of(object.getString("id"));
    }

    @Override
    public String name() {
        return object.getString("name");
    }

    @Override
    public boolean canEdit() {
        return object.getBoolean("canEdit", true);
    }

    @Override
    public boolean canShare() {
        return object.getBoolean("canShare", true);
    }

    public static class CalendarBuilderImpl implements Calendar.Builder {
        private JsonObjectBuilder builder = Json.createObjectBuilder();

        @Override
        public Builder name(String name) {
            builder.add("name", name);
            return this;
        }

        @Override
        public Calendar build() {            
            return new CalendarImpl(builder.build());
        }
    }
}
