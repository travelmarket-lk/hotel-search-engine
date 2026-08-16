package lk.travelmarket.search_engine.network.error.code;

public interface APIError extends IError {

    APIError NO_ERROR = new E( 0, "");
    APIError ERR_DEFAULT_VALIDATION_ERROR = new E(1, "Validation Error");

    public static final class E implements APIError {
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
