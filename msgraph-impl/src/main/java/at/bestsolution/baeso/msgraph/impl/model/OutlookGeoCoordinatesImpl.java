package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.OutlookGeoCoordinates;
import jakarta.json.JsonObject;

public class OutlookGeoCoordinatesImpl extends BaseImpl implements OutlookGeoCoordinates {

    public OutlookGeoCoordinatesImpl(JsonObject object) {
        super(object);
    }

    @Override
    public double accuracy() {
        return JsonUtils.mapDouble(object, "accuracy");
    }

    @Override
    public double altitude() {
        return JsonUtils.mapDouble(object, "altitude");
    }

    @Override
    public double altitudeAccuracy() {
        return JsonUtils.mapDouble(object, "altitudeAccuracy");
    }

    @Override
    public double latitude() {
        return JsonUtils.mapDouble(object, "latitude");
    }

    @Override
    public double longitude() {
        return JsonUtils.mapDouble(object, "longitude");
    }
    
}
