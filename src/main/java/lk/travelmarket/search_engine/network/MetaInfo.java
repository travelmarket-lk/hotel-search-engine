package lk.travelmarket.search_engine.network;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetaInfo {

    private int totalCount;

    public MetaInfo() {
        this.totalCount = 0;
    }

    public MetaInfo(int totalCount) {
        this.totalCount = totalCount;
    }
}
