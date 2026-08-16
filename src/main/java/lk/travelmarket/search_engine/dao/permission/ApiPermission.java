package lk.travelmarket.search_engine.dao.permission;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "api_permissions")
public class ApiPermission {

    @Id
    @Column(length = 100)
    private String code; // Permission code as the primary key

    @Column(length = 100)
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
