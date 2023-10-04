package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.model.Place;
import jakarta.json.JsonObject;

public class PlaceImpl implements Place {
    private JsonObject object;
	
	public PlaceImpl(JsonObject object) {
		this.object = object;
	}

    @Override
    public String displayName() {
        return object.getString("displayName");
    }

    @Override
    public ID<Place> id() {
        return ID.of(object.getString("id"));
    }

    @Override
    public String phone() {
        return object.getString("phone");
    }

}
