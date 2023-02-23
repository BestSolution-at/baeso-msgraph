package at.bestsolution.baeso.msgraph.impl.utils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public record QueryParam(String name, String value) {
    public static String toQueryString(List<QueryParam> parameters) {
        return parameters.stream()
            .map(q -> q.name() + "=" + URLEncoder.encode(q.value(), StandardCharsets.UTF_8) )
            .collect(Collectors.joining("&"));
    }
}
