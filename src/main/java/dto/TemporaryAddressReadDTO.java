package dto;

import java.time.LocalDate;

public class TemporaryAddressReadDTO {
    private Long id;
    private String cityTemp;
    private String countryTemp;
    private String districtTemp;
    private String flatTemp;
    private String homeTemp;
    private LocalDate liveFromTemp;
    private LocalDate liveToTemp;
    private String regionTemp;
    private String streetTemp;
    private Long person_id;

    public TemporaryAddressReadDTO(Long id, String cityTemp, String countryTemp, String districtTemp, String flatTemp, String homeTemp, LocalDate liveFromTemp, LocalDate liveToTemp, String regionTemp, String streetTemp, Long person_id) {
        this.id = id;
        this.cityTemp = cityTemp;
        this.countryTemp = countryTemp;
        this.districtTemp = districtTemp;
        this.flatTemp = flatTemp;
        this.homeTemp = homeTemp;
        this.liveFromTemp = liveFromTemp;
        this.liveToTemp = liveToTemp;
        this.regionTemp = regionTemp;
        this.streetTemp = streetTemp;
        this.person_id = person_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityTemp() {
        return cityTemp;
    }

    public void setCityTemp(String cityTemp) {
        this.cityTemp = cityTemp;
    }

    public String getCountryTemp() {
        return countryTemp;
    }

    public void setCountryTemp(String countryTemp) {
        this.countryTemp = countryTemp;
    }

    public String getDistrictTemp() {
        return districtTemp;
    }

    public void setDistrictTemp(String districtTemp) {
        this.districtTemp = districtTemp;
    }

    public String getFlatTemp() {
        return flatTemp;
    }

    public void setFlatTemp(String flatTemp) {
        this.flatTemp = flatTemp;
    }

    public String getHomeTemp() {
        return homeTemp;
    }

    public void setHomeTemp(String homeTemp) {
        this.homeTemp = homeTemp;
    }

    public LocalDate getLiveFromTemp() {
        return liveFromTemp;
    }

    public void setLiveFromTemp(LocalDate liveFromTemp) {
        this.liveFromTemp = liveFromTemp;
    }

    public LocalDate getLiveToTemp() {
        return liveToTemp;
    }

    public void setLiveToTemp(LocalDate liveToTemp) {
        this.liveToTemp = liveToTemp;
    }

    public String getRegionTemp() {
        return regionTemp;
    }

    public void setRegionTemp(String regionTemp) {
        this.regionTemp = regionTemp;
    }

    public String getStreetTemp() {
        return streetTemp;
    }

    public void setStreetTemp(String streetTemp) {
        this.streetTemp = streetTemp;
    }

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }
}
