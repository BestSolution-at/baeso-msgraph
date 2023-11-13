package at.bestsolution.baeso.msgraph.impl.model;

import at.bestsolution.baeso.msgraph.impl.utils.JsonUtils;
import at.bestsolution.baeso.msgraph.model.Location;
import at.bestsolution.baeso.msgraph.model.OutlookGeoCoordinates;
import at.bestsolution.baeso.msgraph.model.PhysicalAddress;
import jakarta.json.JsonObject;

public class LocationImpl extends BaseImpl implements Location {
    public LocationImpl(JsonObject object) {
        super(object);
    }

    @Override
    public PhysicalAddress address() {
        return JsonUtils.mapObject(object, "address", PhysicalAddressImpl::new);
    }

    @Override
    public OutlookGeoCoordinates coordinates() {
        return JsonUtils.mapObject(object, "coordinates", OutlookGeoCoordinatesImpl::new);
    }

    @Override
    public String displayName() {
        return object.getString("displayName", null);
    }

    @Override
    public String locationEmailAddress() {
        return object.getString("locationEmailAddress", null);
    }

    @Override
    public String locationUri() {
        return object.getString("locationUri", null);
    }

    @Override
    public LocationType locationType() {
        return JsonUtils.mapString(object, "locationType", LocationType::of);
    }

    @Override
    public String uniqueId() {
        return object.getString("uniqueId", null);
    }

    @Override
    public String uniqueIdType() {
        return object.getString("uniqueIdType", null);
    }
    
}
