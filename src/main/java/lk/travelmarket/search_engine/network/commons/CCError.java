package lk.travelmarket.search_engine.network.commons;

public class CCError<T> {

  private CCErrorStatus status;
  private String message;
  private T data;

  public CCError() {}

  public CCError(CCErrorStatus status) {
    this.status = status;
  }

  public CCError(String message) {
    this.message = message;
  }

  public CCError(CCErrorStatus status, String message) {
    this.status = status;
    this.message = message;
  }

  public CCErrorStatus getStatus() {
    return status;
  }

  public void setStatus(CCErrorStatus status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
