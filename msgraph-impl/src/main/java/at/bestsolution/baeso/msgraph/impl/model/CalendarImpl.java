package at.bestsolution.baeso.msgraph.impl.model;

import java.util.List;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.Calendar;
import at.bestsolution.baeso.msgraph.model.EmailAddress;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class CalendarImpl implements Calendar, JSONSerializable {
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

    @Override
    public String toJson() {
        return JsonUtils.stringify(object, false);
    }

    @Override
    public List<OnlineMeetingProviderType> allowedOnlineMeetingProviders() {
        throw new UnsupportedOperationException();
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

        @Override
        public Builder canEdit(boolean canEdit) {
            builder.add("canEdit", canEdit);
            return this;
        }

        @Override
        public Builder canShare(boolean canShare) {
            builder.add("canShare", canShare);
            return this;
        }

        @Override
        public Builder canViewPrivateItems(boolean canViewPrivateItems) {
            builder.add("canViewPrivateItems", canViewPrivateItems);
            return this;
        }

        @Override
        public Builder color(Color color) {
            builder.add("color", color.value());
            return this;
        }

        @Override
        public Builder defaultOnlineMeetingProvider(OnlineMeetingProviderType defaultOnlineMeetingProvider) {
            builder.add("defaultOnlineMeetingProvider", defaultOnlineMeetingProvider.value());
            return this;
        }

        @Override
        public Builder isDefaultCalendar(boolean isDefaultCalendar) {
            builder.add("isDefaultCalendar", isDefaultCalendar);
            return this;
        }

        @Override
        public Builder isRemovable(boolean isRemovable) {
            builder.add("isRemovable", isRemovable);
            return this;
        }

        @Override
        public Builder isTallyingResponses(boolean isTallyingResponses) {
            builder.add("isTallyingResponses", isTallyingResponses);
            return this;
        }
    }

}
