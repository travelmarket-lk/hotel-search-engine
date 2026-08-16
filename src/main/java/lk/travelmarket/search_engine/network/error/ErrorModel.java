package lk.travelmarket.search_engine.network.error;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorModel {

    @JsonProperty
    private String type;

    @JsonProperty
    private String title;

    @JsonProperty
    private String detail;

    @JsonProperty
    private String path;

    @JsonProperty
    private String message;

    public ErrorModel () {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
