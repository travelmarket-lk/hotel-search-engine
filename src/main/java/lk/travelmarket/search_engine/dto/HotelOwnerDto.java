package lk.travelmarket.search_engine.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(
        name = "HotelOwner",
        description = "Hotel Owner registration resource"
)
public class HotelOwnerDto {

    @Schema(
            description = "Unique identifier",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            description = "Name of the hotel owner",
            example = "John Perera"
    )
    @NotBlank
    private String name;

    @Schema(
            description = "Phone number of the hotel owner",
            example = "0771234567"
    )
    @NotBlank
    private String phoneNumber;

    @Schema(
            description = "National Identity Card number",
            example = "200012345678"
    )
    @NotBlank
    private String nic;

    @Schema(
            description = "Email address of the hotel owner",
            example = "john@gmail.com"
    )
    @NotBlank
    @Email
    private String email;


    public HotelOwnerDto() {
    }

    public HotelOwnerDto(
            Long id,
            String name,
            String phoneNumber,
            String nic,
            String email) {

        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nic = nic;
        this.email = email;
    }
}