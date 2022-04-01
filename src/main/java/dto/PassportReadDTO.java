package dto;

import java.time.LocalDate;

public class PassportReadDTO {
    private Long id;
    private LocalDate expired;
    private LocalDate issued;
    private String issuedBy;
    private String number;
    private String series;
    private Long person_id;

    public PassportReadDTO(Long id, LocalDate expired, LocalDate issued, String issuedBy, String number, String series, Long person_id) {
        this.id = id;
        this.expired = expired;
        this.issued = issued;
        this.issuedBy = issuedBy;
        this.number = number;
        this.series = series;
        this.person_id = person_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }
}
