package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.ID;

public interface Team {
    public ID<Team> id();
    public String displayName();
}
