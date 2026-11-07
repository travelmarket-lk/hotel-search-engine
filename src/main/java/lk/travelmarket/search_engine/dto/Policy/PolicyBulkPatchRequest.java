package lk.travelmarket.search_engine.dto.Policy;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PolicyBulkPatchRequest {

    private List<PolicyItemRequest> created = new ArrayList<>();
    private List<PolicyItemRequest> modified = new ArrayList<>();
    private List<Long> deleted = new ArrayList<>();


}