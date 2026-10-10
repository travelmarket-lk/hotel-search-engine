package lk.travelmarket.search_engine.dto;

import jakarta.validation.Valid;

import java.util.List;

public class PolicyBulkRequestDto {

    @Valid
    private List<PolicyDto> created;

    @Valid
    private List<PolicyDto> updated;

    @Valid
    private List<String> deleted;

    public PolicyDto[] getCreated() {
        return created.toArray(new PolicyDto[0]);
    }

    public PolicyDto[] getUpdated() {
        return updated.toArray(new PolicyDto[0]);
    }

    public String[] getDeleted() {
        return deleted.toArray(new String[0]);
    }

    public PolicyDto[] getModified() {
        return updated.toArray(new PolicyDto[0]);
    }
}
