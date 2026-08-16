package lk.travelmarket.search_engine.network.commons;

public enum CCErrorStatus {

    SUCCESS( 1000),
    ERROR( 5000);

    private Integer id;

    CCErrorStatus(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
