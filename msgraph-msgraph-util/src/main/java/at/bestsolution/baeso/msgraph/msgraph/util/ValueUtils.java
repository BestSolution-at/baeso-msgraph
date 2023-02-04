package at.bestsolution.baeso.msgraph.msgraph.util;

import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.microsoft.graph.models.DateTimeTimeZone;

public class ValueUtils {
	public static DateTimeTimeZone fromDatetime(ChronoZonedDateTime<? extends ChronoLocalDate> dateTime) {
		var utc = dateTime.withZoneSameInstant(ZoneId.of("Z"));
		var result = new DateTimeTimeZone();
		result.dateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(utc);
		result.timeZone = "Etc/GMT";
		return result;
	}
}
