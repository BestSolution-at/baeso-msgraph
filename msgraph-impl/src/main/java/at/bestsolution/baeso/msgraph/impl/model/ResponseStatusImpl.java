package at.bestsolution.baeso.msgraph.impl.model;

import java.time.ZonedDateTime;

import at.bestsolution.baeso.msgraph.model.ResponseStatus;
import jakarta.json.JsonObject;

public class ResponseStatusImpl extends BaseImpl implements ResponseStatus {

    public ResponseStatusImpl(JsonObject object) {
        super(object);
    }

    @Override
    public Response response() {
        return Response.of(object.getString("response"));
    }

    @Override
    public ZonedDateTime time() {
        return ZonedDateTime.parse(object.getString("time"));
    }
    
    public static class ResponseStatusBuilderImpl extends BaseBuilderImpl implements ResponseStatus.Builder {

        @Override
        public ResponseStatus build() {
            return new ResponseStatusImpl(builder.build());
        }

        @Override
        public Builder response(Response response) {
            builder.add("response", response.value());
            return this;
        }

        @Override
        public Builder time(ZonedDateTime time) {
            builder.add("time", time.toString());
            return this;
        }

    }
}
