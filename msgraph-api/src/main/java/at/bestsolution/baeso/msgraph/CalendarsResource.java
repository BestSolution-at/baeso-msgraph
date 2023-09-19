package at.bestsolution.baeso.msgraph;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.Query;
import at.bestsolution.baeso.msgraph.model.Calendar;

public interface CalendarsResource {
    public interface CalendarQuery extends Query<Calendar> {

    }

    public CalendarQuery query();
    
    public Calendar create(Calendar calendar);
    public CalendarResource calendar(ID<Calendar> id);
}
