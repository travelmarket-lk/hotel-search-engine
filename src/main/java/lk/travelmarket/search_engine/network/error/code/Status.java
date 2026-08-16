package lk.travelmarket.search_engine.network.error.code;

public enum Status {

    SUCCESS(1),
    WARNING(0),
    ERROR(-1);

    public final int code;

    private Status( int code) { this.code = code; }

}
