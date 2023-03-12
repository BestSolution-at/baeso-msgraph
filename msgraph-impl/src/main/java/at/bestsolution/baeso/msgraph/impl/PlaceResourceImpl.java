package at.bestsolution.baeso.msgraph.impl;

import at.bestsolution.baeso.msgraph.PlaceResource;
import at.bestsolution.baeso.msgraph.impl.model.PlaceImpl;
import at.bestsolution.baeso.msgraph.impl.utils.QueryImpl;
import at.bestsolution.baeso.msgraph.model.Place;

public class PlaceResourceImpl implements PlaceResource {

    @Override
    public PlaceQuery query() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }
    
    static class PlaceQueryImpl extends QueryImpl<Place> implements PlaceQuery {

		public PlaceQueryImpl(String baseUrl, GraphClientImpl client) {
			super(baseUrl, client, PlaceImpl::new);
		}
	}
}
