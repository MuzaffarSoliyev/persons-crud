package dto;

import java.time.LocalDate;

public class PermanentAddressCreateDTO {
    private String cityPer;
    private String countryPer;
    private String districtPer;
    private String flatPer;
    private String homePer;
    private LocalDate liveFromPer;
    private String regionPer;
    private String streetPer;
    private Long personId;


    public PermanentAddressCreateDTO(String cityPer, String countryPer, String districtPer, String flatPer, String homePer, LocalDate liveFromPer, String regionPer, String streetPer, Long personId) {
        this.cityPer = cityPer;
        this.countryPer = countryPer;
        this.districtPer = districtPer;
        this.flatPer = flatPer;
        this.homePer = homePer;
        this.liveFromPer = liveFromPer;
        this.regionPer = regionPer;
        this.streetPer = streetPer;
        this.personId = personId;
    }

    public String getCityPer() {
        return cityPer;
    }

    public void setCityPer(String cityPer) {
        this.cityPer = cityPer;
    }

    public String getCountryPer() {
        return countryPer;
    }

    public void setCountryPer(String countryPer) {
        this.countryPer = countryPer;
    }

    public String getDistrictPer() {
        return districtPer;
    }

    public void setDistrictPer(String districtPer) {
        this.districtPer = districtPer;
    }

    public String getFlatPer() {
        return flatPer;
    }

    public void setFlatPer(String flatPer) {
        this.flatPer = flatPer;
    }

    public String getHomePer() {
        return homePer;
    }

    public void setHomePer(String homePer) {
        this.homePer = homePer;
    }

    public LocalDate getLiveFromPer() {
        return liveFromPer;
    }

    public void setLiveFromPer(LocalDate liveFromPer) {
        this.liveFromPer = liveFromPer;
    }

    public String getRegionPer() {
        return regionPer;
    }

    public void setRegionPer(String regionPer) {
        this.regionPer = regionPer;
    }

    public String getStreetPer() {
        return streetPer;
    }

    public void setStreetPer(String streetPer) {
        this.streetPer = streetPer;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
