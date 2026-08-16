package lk.travelmarket.search_engine.dao.permission;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lk.travelmarket.search_engine.dao.permission.id.AdmGroupPermissionId;

@Entity
@Table(name = "adm_group_permissions")
public class AdmGroupPermission {

    @EmbeddedId
    private AdmGroupPermissionId id;

    public AdmGroupPermissionId getId() {
        return id;
    }

    public void setId(AdmGroupPermissionId id) {
        this.id = id;
    }
}
