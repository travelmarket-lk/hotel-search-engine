package lk.travelmarket.search_engine.dao.permission;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lk.travelmarket.search_engine.dao.permission.id.ApiServiceMethodId;

@Entity
@Table(name = "api_service_methods")
public class ApiServiceMethod {

    @EmbeddedId
    private ApiServiceMethodId id;

    @Column(length = 10)
    private String method;

    @Column(length = 100)
    private String resourcePath;

    @Column(length = 100)
    private String description;

    public ApiServiceMethodId getId() {
        return id;
    }

    public void setId(ApiServiceMethodId id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
