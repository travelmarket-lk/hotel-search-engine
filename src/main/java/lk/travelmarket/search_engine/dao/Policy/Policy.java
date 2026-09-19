package lk.travelmarket.search_engine.dao.Policy;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import java.io.Serializable;

@Repository
@Entity
@Table(name = "Policy")

public class Policy implements Serializable {

    @Id
    @Column(name = "Policy_Id", nullable = false, length = 50)
    private String policyId;

    @Column(name = "Policy_Details", columnDefinition = "TEXT")
    private String policyDetails;


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

    public void setName(String name) {
        this.policyId = name;
    }
    
    public void setDescription(String description) {
        this.policyDetails = description;
    }
    
    public String getDescription() {
        return policyDetails;
    }

    public String getId() {
        return policyId;
    }
    
    public void setId(String id) {
        this.policyId = id;
    }

    public String getName() {
        return null;
    }
}
