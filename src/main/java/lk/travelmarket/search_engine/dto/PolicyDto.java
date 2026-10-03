package lk.travelmarket.search_engine.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyDto {
    private String name;
    private String description;

    @NotBlank(message = "Policy name is required")
    @Size(min = 3, max = 100, message = "Policy name must be between 3 and 100 characters")
    public String getPolicyName() {
        return name;
    }

    @NotBlank(message = "Policy description is required")
    @Size(min = 100, max = 500, message = "Policy description must be between 100 and 500 characters")
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
