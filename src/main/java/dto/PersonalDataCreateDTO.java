package dto;

import java.time.LocalDate;

public class PersonalDataCreateDTO {
    private LocalDate birthDate;
    private String name;
    private String surname;

    public PersonalDataCreateDTO(LocalDate birthDate, String name, String surname) {
        this.birthDate = birthDate;
        this.name = name;
        this.surname = surname;
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
