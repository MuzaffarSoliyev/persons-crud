package builders;

import dto.PersonDTO;
import dto.PersonReadDTO;

import java.time.LocalDate;

public class PersonDTOBuilder implements Builder {
    private Long id;
    private LocalDate birthDate;
    private String name;
    private String surname;

    private String cityPer;
    private String countryPer;
    private String districtPer;
    private String flatPer;
    private String homePer;
    private LocalDate liveFromPer;
    private String regionPer;
    private String streetPer;

    private LocalDate expired;
    private LocalDate issued;
    private String issuedBy;
    private String number;
    private String series;

    private String cityTemp;
    private String countryTemp;
    private String districtTemp;
    private String flatTemp;
    private String homeTemp;
    private LocalDate liveFromTemp;
    private LocalDate liveToTemp;
    private String regionTemp;
    private String streetTemp;
    private String phoneNumber;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public void setCityPer(String cityPer) {
        this.cityPer = cityPer;
    }

    @Override
    public void setCountryPer(String countryPer) {
        this.countryPer = countryPer;
    }

    @Override
    public void setDistrictPer(String districtPer) {
        this.districtPer = districtPer;
    }

    @Override
    public void setFlatPer(String flatPer) {
        this.flatPer = flatPer;
    }

    @Override
    public void setHomePer(String homePer) {
        this.homePer = homePer;
    }

    @Override
    public void setLiveFromPer(LocalDate liveFromPer) {
        this.liveFromPer = liveFromPer;
    }

    @Override
    public void setRegionPer(String regionPer) {
        this.regionPer = regionPer;
    }

    @Override
    public void setStreetPer(String streetPer) {
        this.streetPer = streetPer;
    }

    @Override
    public void setExpired(LocalDate expired) {
        this.expired = expired;
    }

    @Override
    public void setIssued(LocalDate issued) {
        this.issued = issued;
    }

    @Override
    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public void setCityTemp(String cityTemp) {
        this.cityTemp = cityTemp;
    }

    @Override
    public void setCountryTemp(String countryTemp) {
        this.countryTemp = countryTemp;
    }

    @Override
    public void setDistrictTemp(String districtTemp) {
        this.districtPer = districtPer;
    }

    @Override
    public void setFlatTemp(String flatTemp) {
        this.flatTemp = flatTemp;
    }

    @Override
    public void setHomeTemp(String homeTemp) {
        this.homeTemp = homeTemp;
    }

    @Override
    public void setLiveFromTemp(LocalDate liveFromTemp) {
        this.liveFromTemp = liveFromTemp;
    }

    @Override
    public void setLiveToTemp(LocalDate liveToTemp) {
        this.liveToTemp = liveToTemp;
    }

    @Override
    public void setRegionTemp(String regionTemp) {
        this.regionTemp = regionTemp;
    }

    @Override
    public void setStreetTemp(String streetTemp) {
        this.streetTemp = streetTemp;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PersonDTO getPersonDTO(){
        return new PersonDTO(birthDate, name, surname, cityPer, countryPer, districtPer, flatPer, homePer, liveFromPer, regionPer, streetPer, expired, issued, issuedBy, number, series, cityTemp, countryTemp, districtTemp, flatTemp, homeTemp, liveFromTemp, liveToTemp, regionTemp, streetTemp, phoneNumber);
    }

    public PersonReadDTO getPersonReadDTO(){
        return new PersonReadDTO(id, birthDate, name, surname, cityPer, countryPer, districtPer, flatPer, homePer, liveFromPer, regionPer, streetPer, expired, issued, issuedBy, number, series, cityTemp, countryTemp, districtTemp, flatTemp, homeTemp, liveFromTemp, liveToTemp, regionTemp, streetTemp, phoneNumber);
    }
}
