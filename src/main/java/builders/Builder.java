package builders;

import java.time.LocalDate;

public interface Builder {
    void setId(Long id);

    void setBirthDate(LocalDate birthDate);

    void setName(String name);

    void setSurname(String surname);

    void setCityPer(String cityPer);

    void setCountryPer(String countryPer);

    void setDistrictPer(String districtPer);

    void setFlatPer(String flatPer);

    void setHomePer(String homePer);

    void setLiveFromPer(LocalDate liveFromPer);

    void setRegionPer(String regionPer);

    void setStreetPer(String streetPer);

    void setExpired(LocalDate expired);

    void setIssued(LocalDate issued);

    void setIssuedBy(String issuedBy);

    void setNumber(String number);

    void setSeries(String series);

    void setCityTemp(String cityTemp);

    void setCountryTemp(String countryTemp);

    void setDistrictTemp(String districtTemp);

    void setFlatTemp(String flatTemp);

    void setHomeTemp(String homeTemp);

    void setLiveFromTemp(LocalDate liveFromTemp);

    void setLiveToTemp(LocalDate liveToTemp);

    void setRegionTemp(String regionTemp);

    void setStreetTemp(String streetTemp);

    void setPhoneNumber(String phoneNumber);
}
