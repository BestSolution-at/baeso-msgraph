package at.bestsolution.baeso.msgraph;

import at.bestsolution.baeso.msgraph.base.Query;
import at.bestsolution.baeso.msgraph.model.Place;

public interface PlaceResource {
    public interface PlaceQuery extends Query<Place> {
		
	}

    public PlaceQuery query();
}
