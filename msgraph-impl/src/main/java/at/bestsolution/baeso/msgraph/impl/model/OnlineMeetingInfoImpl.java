package at.bestsolution.baeso.msgraph.impl.model;

import java.util.List;

import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.OnlineMeetingInfo;
import at.bestsolution.baeso.msgraph.model.Phone;
import jakarta.json.JsonObject;

public class OnlineMeetingInfoImpl extends BaseImpl implements OnlineMeetingInfo {

    public OnlineMeetingInfoImpl(JsonObject object) {
        super(object);
    }

    @Override
    public String conferenceId() {
        return object.getString("conferenceId", null);
    }

    @Override
    public String joinUrl() {
        return object.getString("joinUrl", null);
    }

    @Override
    public List<Phone> phones() {
        return JsonUtils.mapObjects(object, "phones", PhoneImpl::new);
    }

    @Override
    public String quickDial() {
        return object.getString("quickDial", null);
    }

    @Override
    public List<String> tollFreeNumbers() {
        return JsonUtils.mapStrings(object, "tollFreeNumbers");
    }

    @Override
    public String tollNumber() {
        return object.getString("tollNumber", null);
    }
    
}
