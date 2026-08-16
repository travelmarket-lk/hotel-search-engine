package lk.travelmarket.search_engine.dao.permission.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ApiMethodPermissionId implements Serializable {

    private Integer serviceId;
    private Integer methodNo;

    // Default constructor
    public ApiMethodPermissionId() {}

    public ApiMethodPermissionId(Integer serviceId, Integer methodNo, String permissionCode) {
        this.serviceId = serviceId;
        this.methodNo = methodNo;
    }

    // Getters and setters

    // Override equals() and hashCode() for proper functionality in collections
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiMethodPermissionId that = (ApiMethodPermissionId) o;
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
