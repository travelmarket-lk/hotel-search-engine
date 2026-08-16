package lk.travelmarket.search_engine.dao.permission.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ApiServiceMethodId implements Serializable {

    private Integer serviceId;
    private Integer methodNo;

    // Default constructor
    public ApiServiceMethodId() {}

    public ApiServiceMethodId(Integer serviceId, Integer methodNo) {
        this.serviceId = serviceId;
        this.methodNo = methodNo;
    }

    // Override equals() and hashCode() for proper functionality in collections
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiServiceMethodId that = (ApiServiceMethodId) o;
        return Objects.equals(serviceId, that.serviceId) &&
                Objects.equals(methodNo, that.methodNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, methodNo);
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getMethodNo() {
        return methodNo;
    }

    public void setMethodNo(Integer methodNo) {
        this.methodNo = methodNo;
    }
}
