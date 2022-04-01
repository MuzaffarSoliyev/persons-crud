package dao;

import db.DataBaseConnection;
import dto.PersonReadDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    private DataBaseConnection dataBaseConnection = new DataBaseConnection();

    private static final String SELECT_ALL_PERSONS = "select p.id as id,  p.birthdate as birthdate, p.name as name, p.surname as surname, " +
            "pa.city as city_per, pa.country as country_per, pa.district as district_per, pa.flat as flat_per, pa.home as home_per, pa.livefrom as livefrom_per, pa.region as region_per, pa.street as street_per, " +
            "ps.expired as expired, ps.issued as issued, ps.issuedby as issuedby, ps.number as number, ps.series as series, " +
            "t.city as city_temp, t.country as country_temp, t.district as district_temp, t.flat as flat_temp, t.home as home_temp, t.livefrom as livefrom_temp, t.liveto as liveto_temp, t.region as region_temp, t.street as street_temp, " +
            "ph.number as phone_number " +
            "from person p " +
            "join permanentaddress pa on p.id = pa.person_id " +
            "join passport ps on p.id = ps.person_id " +
            "join temporaryaddress t on p.id = t.person_id " +
            "join phone ph on p.id = ph.person_id;";

    public List<PersonReadDTO> selectAllPersons() {
        List<PersonReadDTO> personReadDTOS = new ArrayList<>();
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PERSONS);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                LocalDate birthDate = LocalDate.parse(resultSet.getString("birthdate"));
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");

                String cityPer = resultSet.getString("city_per");
                String countryPer = resultSet.getString("country_per");
                String districtPer = resultSet.getString("district_per");
                String flatPer = resultSet.getString("flat_per");
                String homePer = resultSet.getString("home_per");
                LocalDate liveFromPer = LocalDate.parse(resultSet.getString("livefrom_per"));
                String regionPer = resultSet.getString("region_per");
                String streetPer = resultSet.getString("street_per");

                LocalDate expired = LocalDate.parse(resultSet.getString("expired"));
                LocalDate issued = LocalDate.parse(resultSet.getString("issued"));
                String issuedBy = resultSet.getString("issuedby");
                String number = resultSet.getString("number");
                String series = resultSet.getString("series");

                String cityTemp = resultSet.getString("city_temp");
                String countryTemp = resultSet.getString("country_temp");
                String districtTemp = resultSet.getString("district_temp");
                String flatTemp = resultSet.getString("flat_temp");
                String homeTemp = resultSet.getString("home_temp");
                LocalDate liveFromTemp = LocalDate.parse(resultSet.getString("livefrom_temp"));
                LocalDate liveToTemp = LocalDate.parse(resultSet.getString("liveto_temp"));
                String regionTemp = resultSet.getString("region_temp");
                String streetTemp = resultSet.getString("street_temp");

                String phoneNumber = resultSet.getString("phone_number");
                personReadDTOS.add(new PersonReadDTO(id, birthDate, name, surname, cityPer, countryPer, districtPer, flatPer, homePer, liveFromPer, regionPer, streetPer, expired, issued, issuedBy, number,
                        series, cityTemp, countryTemp, districtTemp, flatTemp, homeTemp, liveFromTemp,liveToTemp, regionTemp, streetTemp, phoneNumber));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personReadDTOS;
    }

}
