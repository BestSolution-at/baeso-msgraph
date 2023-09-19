package at.bestsolution.baeso.msgraph;

import at.bestsolution.baeso.msgraph.base.Query;
import at.bestsolution.baeso.msgraph.model.CalendarPermission;

public interface CalendarPermissions {
    public interface CalendarPermissionQuery extends Query<CalendarPermission> {

    }

    public CalendarPermissionQuery query();
}
