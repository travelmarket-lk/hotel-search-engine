package lk.travelmarket.search_engine.dto.criteria;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lk.travelmarket.search_engine.dao.Address;
import lk.travelmarket.search_engine.dao.facility.Facility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelCreationCriteria {

    @NotBlank(message = "Hotel name is required")
    @Size(max = 255, message = "Hotel name must not exceed 255 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;

    @Size(max = 500, message = "Location highlight must not exceed 500 characters")
    private String locationHighlight;

    @Min(value = 1, message = "Star rating must be at least 1")
    @Max(value = 5, message = "Star rating must not exceed 5")
    private Integer starRating;

    @Valid
    private Address address;

    @Valid
    private List<Facility> facilities;
}
