package lk.travelmarket.search_engine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlackoutsDto {

    private Long id;
    private Long hotelId;
    private Long roomId;
    private String reason;
    private Date startDate;
    private Date endDate;

}