package lk.travelmarket.search_engine.network.error;

import lk.travelmarket.search_engine.network.error.code.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ErrorInfo {

    private Status status;
    private ErrorSource errorSource;
    private ErrorLayer errorLayer;
    private APIError apiError;
    private CCError ewsError;
    private IError errorCode;
    private String shortText;
    private List<String> errorList = new ArrayList<>();
    private Exception exception;
    private HttpStatus httpStatus;

    public ErrorInfo () {}
    public ErrorInfo ( String shortText) {
        this.status = Status.SUCCESS;
        this.shortText = shortText;
    }
    public ErrorInfo ( HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ErrorInfo ( Status status, String shortText) {
        this.status = status;
        this.shortText = shortText;
    }

    public ErrorInfo ( ErrorLayer errorLayer, String shortText, Exception e) {
        this.errorLayer = errorLayer;
        this.shortText = shortText;
        this.exception = e;
    }

    public ErrorInfo ( ErrorLayer errorLayer, ErrorSource errorSource, String shortText, Exception e) {
        this.status = Status.ERROR;
        this.errorLayer = errorLayer;
        this.errorSource = errorSource;
        this.shortText = shortText;
        this.exception = e;
    }

    public boolean _isSuccess() {
        return this.status == Status.SUCCESS;
    }

    public boolean _isWarning() {
        return this.status == Status.WARNING;
    }

    public boolean _isError() {
        return this.status == Status.ERROR;
    }

    public HttpStatus getHttpStatus() {
        if ( this.httpStatus != null ) {
            return this.httpStatus;
        } else if ( this._isWarning() ) {
            return HttpStatus.PRECONDITION_REQUIRED;
        } else if ( this._isError() ) {
            return this.errorSource == ErrorSource.SERVER_ERROR ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.BAD_REQUEST;
        } else {
            return HttpStatus.OK;
        }
    }
}
