package lk.travelmarket.search_engine.network.error;


import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.commons.util.StringUtils;
import lk.travelmarket.search_engine.network.error.code.APIError;
import lk.travelmarket.search_engine.network.error.code.CCError;
import lk.travelmarket.search_engine.network.error.code.IError;
import lk.travelmarket.search_engine.network.Error;

import java.util.ArrayList;
import java.util.List;

public class ErrorUtil {

    private static final String API_ERROR_CODE = "API Error Code : ";
    private static final String EWS_ERROR_CODE = "TBX Error Code : ";
    private static final String ERROR_CODE_SEPERATOR = " - ";

    public ErrorUtil () {
    }

    public static CCResponseWrapper fillErrorInfo(ErrorInfo errorInfo, CCResponseWrapper responseWrapper) {
        responseWrapper.setStatusCode( (long) errorInfo.getStatus().code);
        if( errorInfo._isSuccess()) {
            setStatusMessage(errorInfo, responseWrapper);
            return responseWrapper;
        } else {
            if( errorInfo._isWarning()) {
                setStatusMessage( errorInfo, responseWrapper);
                if( errorInfo.getErrorList() != null && errorInfo.getErrorList().size() > 0 ) {
                    if( responseWrapper.getErrors() == null) {
                        Error error = new Error();
                        responseWrapper.setError( error);
                    }

                    responseWrapper.getErrors().addAll( errorInfo.getErrorList());
                }
            }
            else if (errorInfo._isError())
            {
                setStatusMessage( errorInfo, responseWrapper);
                if( errorInfo.getErrorList() != null && errorInfo.getErrorList().size() > 0 ) {
                    if( responseWrapper.getErrors() == null) {
                        Error error = new Error();
                        responseWrapper.setError( error);
                    }

                    responseWrapper.getErrors().addAll( errorInfo.getErrorList());
                }
            }

            if( errorInfo.getErrorLayer() != null && errorInfo.getErrorSource() != null ) {
                mapErrorCode( errorInfo, responseWrapper);
                return responseWrapper;
            } else {
                return responseWrapper;
            }
        }
    }

    private static void setStatusMessage( ErrorInfo errorInfo, CCResponseWrapper ewsResponseWrapper) {
        if(StringUtils.isNotNullOrEmpty( errorInfo.getShortText())) {
            ewsResponseWrapper.setStatusMessage( errorInfo.getShortText());
        }
    }

    private static void mapErrorCode( ErrorInfo errorInfo, CCResponseWrapper responseWrapper) {
        long errorCode = ( long ) errorInfo.getErrorSource().code;
        errorCode = errorCode * 10L + ( long ) errorInfo.getErrorLayer().code;
        if( errorInfo.getApiError() == null && errorInfo.getEwsError() == null && errorInfo.getException() != null ) {
            Exception ex = errorInfo.getException();
            CCError error = CCError.exceptionError(ex.getMessage());
            errorInfo.setEwsError( error );
        }

        errorCode = errorCode * 10000L + ( long ) ( errorInfo.getApiError() == null ? 0 : errorInfo.getApiError().getCode());
        errorCode = errorCode * 10000L + ( long ) ( errorInfo.getEwsError() == null ? 0 : errorInfo.getEwsError().getCode());
        errorCode = errorCode * 10000L + ( long ) ( errorInfo.getErrorCode() == null ? 0 : errorInfo.getErrorCode().getCode());

        List<String> errors = new ArrayList<>(2);
        if( errorInfo.getApiError() != null && errorInfo.getApiError().getCode() > 0 ) {
            addErrorDescription( (APIError) errorInfo.getApiError(), errors);
        }

        if( errorInfo.getEwsError() != null && errorInfo.getEwsError().getCode() > 0 ) {
            addErrorDescription( (CCError) errorInfo.getEwsError(), errors);
        }

        if( errorInfo.getErrorCode() != null && errorInfo.getErrorCode().getCode() > 0 ) {
            addErrorDescription( (IError) errorInfo.getErrorCode(), errors);
        }

        responseWrapper.setErrors( errors);
        responseWrapper.setErrorCode( errorCode );
        responseWrapper.setErrorMessage( errorInfo.getShortText());

        if( errorInfo.getErrorList() != null && errorInfo.getErrorList().size() > 0) {
            responseWrapper.getErrors().addAll( errorInfo.getErrorList());
        }
    }

    private static void addErrorDescription(IError errorCode , List<String> errors) {
        String errorType = errorCode != null && errorCode instanceof APIError ? " API Error Code : " : "EWS Error code";
        errors.add( errorType + errorCode.getCode() + " - " + errorCode.getMessage());
    }

    private static void addErrorDescription(APIError errorCode , List<String> errors) {
        errors.add( "API Error Code" + errorCode.getCode() + " - " + errorCode.getMessage());
    }

    private static void addErrorDescription(CCError errorCode , List<String> errors) {
        errors.add( "TBX Error Code" + errorCode.getCode() + " - " + errorCode.getMessage());
    }
}
