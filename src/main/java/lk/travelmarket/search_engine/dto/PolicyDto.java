package lk.travelmarket.search_engine.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
public class PolicyDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String policyId;
    private String policyDetails;

    public PolicyDto() {
    }

}