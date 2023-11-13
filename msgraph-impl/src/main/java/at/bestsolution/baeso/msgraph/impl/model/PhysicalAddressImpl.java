package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.model.PhysicalAddress;
import jakarta.json.JsonObject;

public class PhysicalAddressImpl extends BaseImpl implements PhysicalAddress {

    public PhysicalAddressImpl(JsonObject object) {
        super(object);
    }

    @Override
    public String city() {
        return object.getString("city", null);
    }

    @Override
    public String countryOrRegion() {
        return object.getString("countryOrRegion", null);
    }

    @Override
    public String postalCode() {
        return object.getString("postalCode", null);
    }

    @Override
    public String state() {
        return object.getString("state", null);
    }

    @Override
    public String street() {
        return object.getString("street", null);
    }
    
}
