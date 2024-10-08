package at.bestsolution.baeso.msgraph;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.Query;
import at.bestsolution.baeso.msgraph.model.Team;

public interface TeamsResource {
    public interface TeamQuery extends Query<Team> {
		
	}

    public TeamResource team(ID<Team> team);

    public TeamQuery query();
}
