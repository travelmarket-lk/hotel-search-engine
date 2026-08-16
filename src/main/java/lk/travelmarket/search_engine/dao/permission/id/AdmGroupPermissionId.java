package lk.travelmarket.search_engine.dao.permission.id;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AdmGroupPermissionId implements Serializable {

    private Integer groupId;
    private String permissionCode;

    // Default constructor
    public AdmGroupPermissionId() {}

    public AdmGroupPermissionId(Integer groupId, String permissionCode) {
        this.groupId = groupId;
        this.permissionCode = permissionCode;
    }

    // Override equals() and hashCode() for proper functionality in collections
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdmGroupPermissionId that = (AdmGroupPermissionId) o;
        return Objects.equals(groupId, that.groupId) &&
                Objects.equals(permissionCode, that.permissionCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, permissionCode);
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }
}
