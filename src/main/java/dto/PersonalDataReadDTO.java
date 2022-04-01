package dto;

import java.time.LocalDate;

public class PersonalDataReadDTO {
    private Long id;
    private LocalDate birthDate;
    private String name;
    private String surname;

    public PersonalDataReadDTO(Long id, LocalDate birthDate, String name, String surname) {
        this.id = id;
        this.birthDate = birthDate;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
