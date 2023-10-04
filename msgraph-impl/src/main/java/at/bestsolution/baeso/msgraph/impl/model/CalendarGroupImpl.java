package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.model.CalendarGroup;
import jakarta.json.JsonObject;

public class CalendarGroupImpl implements CalendarGroup {
    private final JsonObject object;

    public CalendarGroupImpl(JsonObject object) {
        this.object = object;
    }

    @Override
    public String name() {
        return object.getString("name");
    }

    @Override
    public String changeKey() {
        return object.getString("changeKey");
    }

    @Override
    public String classId() {
        return object.getString("classId");
    }

    @Override
    public ID<CalendarGroup> id() {
        return ID.of(object.getString("id"));
    }
    
}
