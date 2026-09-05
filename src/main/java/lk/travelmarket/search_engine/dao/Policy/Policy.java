package lk.travelmarket.search_engine.dao.Policy;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Policy")

public class Policy implements Serializable {

    @Id
    @Column(name = "Policy_Id", nullable = false, length = 50)
    private String policyId;

    @Column(name = "Policy_Details", columnDefinition = "TEXT")
    private String policyDetails;


//    @ManyToOne
//    public Policy;

    public Policy() {
    }

    public Policy(String policyId, String policyDetails) {
        this.policyId = policyId;
        this.policyDetails = policyDetails;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyDetails() {
        return policyDetails;
    }

    public void setPolicyDetails(String policyDetails) {
        this.policyDetails = policyDetails;
    }
}
