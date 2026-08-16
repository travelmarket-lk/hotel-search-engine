package lk.travelmarket.search_engine.network.error.code;

public enum ErrorLayer {

    API_LAYER(0),
    HSL_LAYER(1);

    public final int code;

    private ErrorLayer( int code) { this.code = code; }
}
