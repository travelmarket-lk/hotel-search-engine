package lk.travelmarket.search_engine.network;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class Error {

    private long code;
    private String message;
    private String details;
    private List<String> errors;

    public Error() {}
}
