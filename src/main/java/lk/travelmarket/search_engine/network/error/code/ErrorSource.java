package lk.travelmarket.search_engine.network.error.code;

public enum ErrorSource {

    CLIENT_ERROR(4),
    SERVER_ERROR(5),
    PACKAGE_ERROR(6);

    public final int code;

    private ErrorSource(int code) { this.code = code; }
}
