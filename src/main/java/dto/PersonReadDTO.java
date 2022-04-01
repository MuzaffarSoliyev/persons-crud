package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonReadDTO {
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
}
