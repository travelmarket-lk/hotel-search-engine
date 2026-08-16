package lk.travelmarket.search_engine.network.commons;


import com.fasterxml.jackson.annotation.JsonInclude;
import lk.travelmarket.search_engine.network.Reference;
import lk.travelmarket.search_engine.network.error.ErrorInfo;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import lk.travelmarket.search_engine.network.error.code.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class CCResponse<T> extends ErrorInfo {

    private T data;
    private Map<String, String> metaData;

    private Reference reference;

    public CCResponse(T returnData) {
        super("");
        this.data = returnData;
    }

    public CCResponse(T returnData, Map<String, String> metaData) {
        super("");
        this.data = returnData;
        this.metaData = metaData;
    }

    public CCResponse(Status status, String shortText, T returnData) {
        super(status, shortText);
        this.data = returnData;
    }

    public CCResponse(T returnData , HttpStatus httpStatus) {
        super(httpStatus);
        this.data = returnData;
    }

    public CCResponse(Status status, String shortText, Exception exception) {
        super(status, shortText);
    }

    public CCResponse(ErrorLayer errorLayer, ErrorSource errorSource, String shortText, Exception exception) {
        super( errorLayer, errorSource , shortText , exception);
    }
}
