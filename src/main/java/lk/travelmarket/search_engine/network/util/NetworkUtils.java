package lk.travelmarket.search_engine.network.util;

import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.network.error.ErrorInfo;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import jakarta.annotation.Resources;
import org.springframework.http.ResponseEntity;

public class NetworkUtils {

    public NetworkUtils() {

    }

    public static ResponseEntity wrap(CCResponse data) {
        try {
            if (data != null && data.getData() != null && (data.getData().getClass() == Resources.class)) {
                Resources resources = (Resources) data.getData();
                if (resources != null) {
                    return new ResponseEntity(new CCResponseWrapper(data), data.getHttpStatus());
                }
            }

            return new ResponseEntity(new CCResponseWrapper(data), data.getHttpStatus());
        } catch (Exception var2) {
            return wrap(var2, "Error while wrappping final response");
        }
    }

    public static ResponseEntity wrap(Exception e, String message) {
        ErrorInfo error = new ErrorInfo( ErrorLayer.API_LAYER , message, e);
        return new ResponseEntity(new CCResponseWrapper(error), error.getHttpStatus());
    }

    public static ResponseEntity wrap(ErrorSource errorSource, Exception e, String message) {
        ErrorInfo error = new ErrorInfo( ErrorLayer.API_LAYER, errorSource , message, e);
        return new ResponseEntity(new CCResponseWrapper(error), error.getHttpStatus());
    }

    public static ResponseEntity wrap(CCResponsePack responsePack) {
        try {
            CCResponseWrapper responseWrapper = new CCResponseWrapper(responsePack);
            return new ResponseEntity(responseWrapper, responsePack.getHttpStatus());
        } catch (Exception var2) {
            return wrap(var2, "Error while wrappping final response");
        }
    }
}
