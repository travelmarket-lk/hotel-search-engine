package lk.travelmarket.search_engine.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Reason is required and cannot be blank")
    @Size(max = 255, message = "Reason cannot exceed 255 characters")
    private String reason;

    @NotNull(message = "Start date is required")
    private Date startDate;

    @NotNull(message = "End date is required")
    private Date endDate;

}