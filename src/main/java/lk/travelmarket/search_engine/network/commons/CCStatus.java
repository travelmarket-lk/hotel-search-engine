package lk.travelmarket.search_engine.network.commons;

public enum CCStatus {

    ACTIVE( 1000),
    INACTIVE( 5000);

    private Integer id;

    CCStatus(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
