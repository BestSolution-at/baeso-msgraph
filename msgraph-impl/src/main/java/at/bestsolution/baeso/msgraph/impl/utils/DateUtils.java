package at.bestsolution.baeso.msgraph.impl.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class DateUtils {
    public static ZonedDateTime toZonedDateTime(JsonObject dateTimeTimeZone) {
        var dateTime = LocalDateTime.parse(dateTimeTimeZone.getString("dateTime"));
        var timeZone = ZoneId.of(dateTimeTimeZone.getString("timeZone"));
        return ZonedDateTime.of(dateTime.toLocalDate(), dateTime.toLocalTime(), timeZone);
    }

    public static JsonObject toDateTimeTimeZone(ZonedDateTime dateTime) {
        var builder = Json.createObjectBuilder();
        builder.add("dateTime", dateTime.toLocalDateTime().toString());
        builder.add("timeZone", dateTime.getZone().getId());
        return builder.build();
    }
}
