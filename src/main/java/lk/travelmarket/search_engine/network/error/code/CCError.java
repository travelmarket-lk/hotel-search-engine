package lk.travelmarket.search_engine.network.error.code;

public interface CCError extends IError {

    CCError NO_ERROR = new E( 0, "");
    static CCError exceptionError(String message) {
        return new E(1, message);
    }

    public static final class E implements CCError {
        private final int code;
        private final String message;

        private E( int code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() { return this.code; }
        public String getMessage() { return this.message; }
        public String toString() { return this.message; }
    }
}
