package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.Phone;
import jakarta.json.JsonObject;

public class PhoneImpl extends BaseImpl implements Phone {

    public PhoneImpl(JsonObject object) {
        super(object);
    }

    @Override
    public String number() {
        return object.getString("number", null);
    }

    @Override
    public PhoneType type() {
        return JsonUtils.mapString(object, "type", PhoneType::of);
    }
    
}
