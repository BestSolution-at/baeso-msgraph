package at.bestsolution.baeso.msgraph;

import java.util.stream.Stream;

import at.bestsolution.baeso.msgraph.base.ID;
import at.bestsolution.baeso.msgraph.base.Query;
import at.bestsolution.baeso.msgraph.model.Calendar;
import at.bestsolution.baeso.msgraph.model.CalendarGroup;

public interface CalendarGroupResource {
    public interface CalendarGroupQuery extends Query<CalendarGroup> {

    }

    public Stream<Calendar> calendars(ID<CalendarGroup> group);

    public CalendarGroupQuery query();
}
