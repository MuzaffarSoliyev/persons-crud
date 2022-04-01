package dto;

public class PhoneCreateDTO {
    private String phoneNumber;
    private Long personId;

    public PhoneCreateDTO(String phoneNumber, Long personId) {
        this.phoneNumber = phoneNumber;
        this.personId = personId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
