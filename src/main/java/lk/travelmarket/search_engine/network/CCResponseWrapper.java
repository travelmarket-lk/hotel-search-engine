package lk.travelmarket.search_engine.network;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.network.error.ErrorInfo;
import lk.travelmarket.search_engine.network.error.ErrorUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.CollectionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@JsonInclude( JsonInclude.Include.NON_NULL)

public class CCResponseWrapper<T> {

    @JsonProperty( "version")
    private String version;

    @JsonProperty( "status")
    private Status status;

    @JsonProperty( "error")
    private Error error;

    @JsonProperty( "reference")
    private Reference reference;

    @JsonProperty( "data")
    private List<T> data;

    @JsonProperty( "metaInfo")
    private MetaInfo metaInfo;


    public CCResponseWrapper() {
        this.reference = null;
        this.data = null;
        this.setVersion("v1.0");
        this.status = new Status();
        this.metaInfo = new MetaInfo();
    }

    public CCResponseWrapper(CCResponse<T> response) {
        this.reference = null;
        this.data = null;
        this.data = new ArrayList<>();
        if( response != null && response.getData() != null) {
            this.data.add( response.getData() );
        }

        if( response != null && response.getReference() != null) {
            this.reference = response.getReference();
        }
        this.setVersion("v1.0");
        if( response != null ) {
            ErrorUtil.fillErrorInfo( response, this);
        }
    }

    public CCResponseWrapper(CCResponsePack<T> response) {
        this.reference = null;
        this.data = null;
        this.metaInfo = new MetaInfo( 0);
        this.data = new ArrayList<>();
        if( response != null && response.getData() != null) {
            this.data.addAll( response.getData() );
        }

        if( response != null && response.getReference() != null) {
            this.reference = response.getReference();
        }

        if( response != null && response.getMetaData() != null) {
            if( response.getMetaData().containsKey("totalCount")) {
                this.metaInfo.setTotalCount( Integer.parseInt( response.getMetaData().get("totalCount") ));
            }
        }

        this.setVersion("v1.0");
        if( response != null ) {
            ErrorUtil.fillErrorInfo( response, this);
        }
    }

    public CCResponseWrapper(ErrorInfo errorInfo) {
        this();
        ErrorUtil.fillErrorInfo( errorInfo, this);
    }

    public CCResponseWrapper(CCResponse<T> response, CollectionModel resources) {
        this.reference = null;
        this.data = null;
        this.data = new ArrayList<>();
        if( resources.getContent() != null) {
            this.data = ( List ) resources.getContent().stream().collect( Collectors.toList());
        }
        if( response != null && response.getData() != null) {
            this.reference = response.getReference();
        }

        this.setVersion("v1.0");
        ErrorUtil.fillErrorInfo( response, null);
    }

    public CCResponseWrapper(int statsCode) {
        this();
        this.setStatusCode( statsCode );
    }

    public CCResponseWrapper(int statsCode, List<T> data) {
        this(statsCode);
        this.setData( data );
    }

    public CCResponseWrapper(int statsCode, long errorCode) {
        this(statsCode);
        this.setErrorCode( errorCode );
    }

    public CCResponseWrapper(int statsCode, long errorCode, String errorMsg) {
        this(statsCode, errorCode);
        this.setErrorMessage( errorMsg );
    }

    @JsonIgnore
    public void setStatusCode( long code) {
        if( this.status == null ) {
            this.status = new Status();
        }

        this.status.setCode( Math.toIntExact(code));
        if( code == 1L) {
            this.status.setMessage( "SUCCESS");
        }
        else if( code == 0L) {
            this.status.setMessage( "WARNING");
        }
        else if( code == -1L) {
            this.status.setMessage( "ERROR");
        }
        else {
            this.status.setMessage( (String) null);
        }
    }

    @JsonIgnore
    public void setStatusMessage( String message) {
        if( this.status != null) {
            this.status.setMessage( message);
        }
    }

    public List<String> getErrors() {
        return this.error == null ? null : this.error.getErrors();
    }

    public void setErrors( List<String> errors) {
        this._getError().setErrors( errors);
    }

    private Error _getError() {
        if( this.error == null ){
            this.error = new Error();
        }

        return this.error;
    }

    public void setErrorCode( long code) {
        this._getError().setCode( code );
    }

    public void setErrorMessage( String message) {
        this._getError().setMessage( message );
    }
}
