package dto;

public class PhoneReadDTO {
    private Long id;
    private String phoneNumber;
    private Long person_id;

    public PhoneReadDTO(Long id, String phoneNumber, Long person_id) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.person_id = person_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }
}
