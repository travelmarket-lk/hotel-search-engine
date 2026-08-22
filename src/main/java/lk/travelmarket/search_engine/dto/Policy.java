package lk.travelmarket.search_engine.dto;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Policy")
public class Policy<Hotel> implements Serializable {

    @Id
    @Column(name = "Policy_Id", nullable = false, length = 50)
    private String policyId;

    @Column(name = "Policy_Details", columnDefinition = "TEXT")
    private String policyDetails;

    // Assuming you have a Hotel entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Hotel_Id", nullable = false)
    private Hotel hotel;

    public Policy() {
    }

    public Policy(String policyId, String policyDetails, Hotel hotel) {
        this.policyId = policyId;
        this.policyDetails = policyDetails;
        this.hotel = hotel;
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}