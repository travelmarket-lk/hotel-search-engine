package lk.travelmarket.search_engine.dto.criteria;

import lk.travelmarket.search_engine.dao.Address;
import lk.travelmarket.search_engine.dao.facility.Facility;
import lk.travelmarket.search_engine.dto.facility.FacilityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelCreationCriteria {

    private String name;
    private String description;
    private String locationHighlight;
    private Integer starRating;

    private Address address;
    private List<Facility> facilities;
}
