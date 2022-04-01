package dto;

import java.time.LocalDate;

public class PassportCreateDTO {
    private LocalDate expired;
    private LocalDate issued;
    private String issuedBy;
    private String number;
    private String series;
    private Long personId;

    public PassportCreateDTO(LocalDate expired, LocalDate issued, String issuedBy, String number, String series, Long personId) {
        this.expired = expired;
        this.issued = issued;
        this.issuedBy = issuedBy;
        this.number = number;
        this.series = series;
        this.personId = personId;
    }

    public LocalDate getExpired() {
        return expired;
    }

    public void setExpired(LocalDate expired) {
        this.expired = expired;
    }

    public LocalDate getIssued() {
        return issued;
    }

    public void setIssued(LocalDate issued) {
        this.issued = issued;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
