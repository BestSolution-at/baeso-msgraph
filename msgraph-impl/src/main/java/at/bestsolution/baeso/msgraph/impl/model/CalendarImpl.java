package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.model.Calendar;
import javax.json.JsonObject;

public class CalendarImpl implements Calendar {
    private final JsonObject object;

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
}
