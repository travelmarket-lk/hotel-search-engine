package lk.travelmarket.search_engine.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData {

    @JsonProperty( "status")
    private Status status;

    @JsonProperty( "status")
    private String id;

    public ResponseData() {}
}
