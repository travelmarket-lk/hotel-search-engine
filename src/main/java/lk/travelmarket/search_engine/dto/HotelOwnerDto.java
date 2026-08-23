package lk.travelmarket.search_engine.dto;

public class HotelOwnerDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private String nic;
    private String email;


    public HotelOwnerDto() {
    }

    public HotelOwnerDto(Long id, String name, String phoneNumber, String nic, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nic = nic;
        this.email = email;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
