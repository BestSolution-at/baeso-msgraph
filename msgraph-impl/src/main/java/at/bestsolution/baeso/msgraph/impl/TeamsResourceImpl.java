package at.bestsolution.baeso.msgraph.impl;

import at.bestsolution.baeso.msgraph.TeamResource;
import at.bestsolution.baeso.msgraph.TeamsResource;
import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.impl.model.TeamImpl;
import at.bestsolution.baeso.msgraph.impl.utils.QueryImpl;
import at.bestsolution.baeso.msgraph.model.Team;

public class TeamsResourceImpl implements TeamsResource {
    private final String baseUrl = "https://graph.microsoft.com/v1.0/teams";
    private final GraphClientImpl client;

    public TeamsResourceImpl(GraphClientImpl client) {
        this.client = client;
    }

    @Override
    public TeamQuery query() {
        return new TeamQueryImpl(baseUrl, client);
    }

    @Override
    public TeamResource team(ID<Team> team) {
        return new TeamResourceImpl(client, baseUrl + "/" + team.id);
    }

    static class TeamQueryImpl extends QueryImpl<Team> implements TeamQuery {

        public TeamQueryImpl(String baseUrl, GraphClientImpl client) {
            super(baseUrl, client, TeamImpl::new);
        }
    }
}
