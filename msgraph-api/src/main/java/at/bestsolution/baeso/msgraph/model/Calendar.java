package at.bestsolution.baeso.msgraph.model;

import at.bestsolution.baeso.msgraph.base.ID;

public interface Calendar {
    public ID<Calendar> id();
    // allowedOnlineMeetingProviders
    public String name();
    public boolean canEdit();
    public boolean canShare();
    // canViewPrivateItems
    // changeKey
    // color
    // defaultOnlineMeetingProvider
    // hexColor
    // isDefaultCalendar
    // isRemovable
    // isTallyingResponses
    // owner

    public interface Builder {
        public Calendar build();

        public Builder name(String name);
    }
}
