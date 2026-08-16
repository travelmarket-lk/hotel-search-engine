package lk.travelmarket.search_engine.network.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import lk.travelmarket.search_engine.network.Reference;
import lk.travelmarket.search_engine.network.error.ErrorInfo;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import lk.travelmarket.search_engine.network.error.code.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@JsonInclude( JsonInclude.Include.NON_NULL)
public class CCResponsePack<T> extends ErrorInfo {

    private List<T> data;
    private Map<String, String> metaData;
    private Reference reference;

    public CCResponsePack() {

    }

    public CCResponsePack(List<T> returnData) {
        super("");
        this.data = returnData;
    }

    public CCResponsePack(List<T> returnData, Map<String, String> metaData) {
        super("");
        this.data = returnData;
        this.metaData = metaData;
    }

    public CCResponsePack(Status status, String shortText, List<T> returnData) {
        super(status,shortText);
        this.data = returnData;
    }

    public CCResponsePack(ErrorLayer errorLayer, String shortText, Exception e) {
        super(errorLayer,shortText, e);
    }

    public CCResponsePack(ErrorLayer errorLayer, ErrorSource errorSource, String shortText, Exception exception) {
        super( errorLayer, errorSource , shortText , exception);
    }
}
