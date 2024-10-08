package at.bestsolution.baeso.msgraph.impl.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import at.bestsolution.baeso.msgraph.base.Query;
import at.bestsolution.baeso.msgraph.impl.GraphClientImpl;
import jakarta.json.JsonObject;

public class QueryImpl<T> implements Query<T> {
    private final String baseUrl;
    private final GraphClientImpl client;
    private final Function<JsonObject, T> factory;
    protected final List<QueryParam> queryParmeters = new ArrayList<>();
    private final boolean supportPaging;

    public QueryImpl(String baseUrl, GraphClientImpl client, Function<JsonObject, T> factory) {
        this.baseUrl = baseUrl;
        this.client = client;
        this.factory = factory;
        this.supportPaging = true;
    }

    public QueryImpl(String baseUrl, GraphClientImpl client, Function<JsonObject, T> factory, boolean supportPaging) {
        this.baseUrl = baseUrl;
        this.client = client;
        this.factory = factory;
        this.supportPaging = supportPaging;
    }

    @Override
    public Stream<T> stream() {
        return stream(20);
    }

    @Override
    public Stream<T> stream(int pageSize) {
        if( supportPaging ) {
            queryParmeters.add(new QueryParam("$top", Integer.toString(pageSize)));
            // queryParmeters.add(new QueryParam("$count", "true")); 
        }

        var uri = queryParmeters.isEmpty() ? baseUrl : baseUrl + "?" + QueryParam.toQueryString(queryParmeters);
        
        System.err.println(uri);
        var result = client.GET(uri);
        var array = result.getJsonArray("value");
			
        //Json.createWriterFactory(Map.of(JsonGenerator.PRETTY_PRINTING, true)).createWriter(System.err).write(result);
        
        if( array.size() == 0 ) {
            return Stream.empty();
        }

        if( ! supportPaging ) {
            return array.getValuesAs(JsonObject.class).stream().map(factory);
        }
        
        return StreamSupport.stream(new PagingSpliterator<>(client, result, factory), false);
    }
}
