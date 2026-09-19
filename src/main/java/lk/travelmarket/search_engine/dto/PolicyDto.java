package lk.travelmarket.search_engine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyDto {
    private String name;
    private String description;

    public String getPolicyName() {
        return name;
    }

    public String getPolicyDescription() {
        return description;
    }

    public void setField1(String arg1) {
        this.name = arg1;
    }

    public void setField2(String arg2) {
        this.description = arg2;
    }


    public void setField3(String arg3) {
        this.name = arg3;
    }

    public void setPolicyId(String policyId) {
    }

    public void setPolicyDescription(String policyDetails) {
    }

    public void setPolicyName(String name) {
    }
}
