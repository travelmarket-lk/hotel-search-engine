package lk.travelmarket.search_engine.dao.permission;

import jakarta.persistence.*;
import lk.travelmarket.search_engine.dao.permission.id.ApiMethodPermissionId;

@Entity
@Table(name = "api_method_permissions")
public class ApiMethodPermission {

    @EmbeddedId
    private ApiMethodPermissionId id;

    @Column(length = 100)
    private String permissionCode;

    @OneToOne
    @MapsId("id") // Mapping the composite key of ApiMethodPermissionId
    @JoinColumns({
            @JoinColumn(name = "service_id", referencedColumnName = "serviceId"),
            @JoinColumn(name = "method_no", referencedColumnName = "methodNo")
    })
    private ApiServiceMethod apiServiceMethod;

    public ApiMethodPermissionId getId() {
        return id;
    }

    public void setId(ApiMethodPermissionId id) {
        this.id = id;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public ApiServiceMethod getApiServiceMethod() {
        return apiServiceMethod;
    }

    public void setApiServiceMethod(ApiServiceMethod apiServiceMethod) {
        this.apiServiceMethod = apiServiceMethod;
    }
}
