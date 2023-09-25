package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.Calendar;
import at.bestsolution.baeso.msgraph.model.EmailAddress;

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

    @Override
    public boolean canViewPrivateItems() {
        return object.getBoolean("canViewPrivateItems");
    }

    @Override
    public String changeKey() {
        return object.getString("changeKey");
    }

    @Override
    public Color color() {
        return Color.of(object.getString("color"));
    }

    @Override
    public OnlineMeetingProviderType defaultOnlineMeetingProvider() {
        return OnlineMeetingProviderType.of(object.getString("defaultOnlineMeetingProvider"));
    }

    @Override
    public String hexColor() {
        return object.getString("hexColor");
    }

    @Override
    public boolean isDefaultCalendar() {
        return object.getBoolean("isDefaultCalendar");
    }

    @Override
    public boolean isRemovable() {
        return object.getBoolean("isRemovable");
    }

    @Override
    public boolean isTallyingResponses() {
        return object.getBoolean("isTallyingResponses");
    }

    @Override
    public EmailAddress owner() {
        return new EmailAddressImpl(object.getJsonObject("owner"));
    }

    @Override
    public String toString() {
        return JsonUtils.stringify(object, true);
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
