package dao;

import db.DataBaseConnection;
import dto.PassportReadDTO;
import dto.TemporaryAddressCreateDTO;
import dto.TemporaryAddressReadDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TemporaryAddressDAO {
    private static final String INSERT_DATA = "INSERT INTO temporaryaddress" + " (city, country, district, flat, home, livefrom, liveto, region, street, person_id) VALUES" +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ADDRESS_BY_ID = "SELECT id, city, country, district, flat, home, livefrom, liveto, region, street, person_id FROM temporaryaddress WHERE person_id=?;";
    private static final String SELECT_ALL_DATA = "SELECT * from temporaryaddress;";
    private static final String DELETE_BY_ID = "DELETE FROM temporaryaddress WHERE person_id=?;";
    private static final String UPDATE_BY_ID = "UPDATE temporaryaddress set city = ?, country = ?, district = ?, flat = ?, home = ?, livefrom = ?, liveto = ?, region = ?, street = ? WHERE person_id=?;";
    private DataBaseConnection dataBaseConnection = new DataBaseConnection();

    public void insertPermanentAddress(TemporaryAddressCreateDTO temporaryAddressCreateDTO) {
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DATA);
        ) {
            preparedStatement.setString(1, temporaryAddressCreateDTO.getCityTemp());
            preparedStatement.setString(2, temporaryAddressCreateDTO.getCountryTemp());
            preparedStatement.setString(3, temporaryAddressCreateDTO.getDistrictTemp());
            preparedStatement.setString(4, temporaryAddressCreateDTO.getFlatTemp());
            preparedStatement.setString(5, temporaryAddressCreateDTO.getHomeTemp());
            preparedStatement.setDate(6, Date.valueOf(temporaryAddressCreateDTO.getLiveFromTemp()));
            preparedStatement.setDate(7, Date.valueOf(temporaryAddressCreateDTO.getLiveToTemp()));
            preparedStatement.setString(8, temporaryAddressCreateDTO.getRegionTemp());
            preparedStatement.setString(9, temporaryAddressCreateDTO.getStreetTemp());
            preparedStatement.setLong(10, temporaryAddressCreateDTO.getPersonId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TemporaryAddressReadDTO> selectTemporaryAddress() {
        List<TemporaryAddressReadDTO> temporaryAddressReadDTOS = new ArrayList<>();
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DATA);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String city = resultSet.getString("city");
                String country = resultSet.getString("country");
                String district = resultSet.getString("district");
                String flat = resultSet.getString("flat");
                String home = resultSet.getString("home");
                LocalDate liveFrom = LocalDate.parse(resultSet.getString("livefrom"));
                LocalDate liveTo = LocalDate.parse(resultSet.getString("liveto"));
                String region = resultSet.getString("region");
                String street = resultSet.getString("street");
                Long person_id = resultSet.getLong("person_id");
                temporaryAddressReadDTOS.add(new TemporaryAddressReadDTO(id, city, country, district, flat, home, liveFrom, liveTo, region, street, person_id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temporaryAddressReadDTOS;
    }

    public TemporaryAddressReadDTO selectTemporaryAddressById(Long personId) {
        TemporaryAddressReadDTO temporaryAddressReadDTO = null;
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADDRESS_BY_ID);
        ) {
            preparedStatement.setLong(1, personId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String city = resultSet.getString("city");
                String country = resultSet.getString("country");
                String district = resultSet.getString("district");
                String flat = resultSet.getString("flat");
                String home = resultSet.getString("home");
                LocalDate liveFrom = LocalDate.parse(resultSet.getString("livefrom"));
                LocalDate liveTo = LocalDate.parse(resultSet.getString("liveto"));
                String region = resultSet.getString("region");
                String street = resultSet.getString("street");
                Long person_id = resultSet.getLong("person_id");
                temporaryAddressReadDTO = new TemporaryAddressReadDTO(id, city, country, district, flat, home, liveFrom, liveTo, region, street, person_id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temporaryAddressReadDTO;
    }

    public boolean deleteTemporaryAddress(Long id) {
        boolean rowDeleted = false;
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        ) {
            preparedStatement.setLong(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean updatePassport(TemporaryAddressCreateDTO temporaryAddressCreateDTO) {
        boolean rowUpdated = false;
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
        ) {
            preparedStatement.setString(1, temporaryAddressCreateDTO.getCityTemp());
            preparedStatement.setString(2, temporaryAddressCreateDTO.getCountryTemp());
            preparedStatement.setString(3, temporaryAddressCreateDTO.getDistrictTemp());
            preparedStatement.setString(4, temporaryAddressCreateDTO.getFlatTemp());
            preparedStatement.setString(5, temporaryAddressCreateDTO.getHomeTemp());
            preparedStatement.setDate(6, Date.valueOf(temporaryAddressCreateDTO.getLiveFromTemp()));
            preparedStatement.setDate(7, Date.valueOf(temporaryAddressCreateDTO.getLiveToTemp()));
            preparedStatement.setString(8, temporaryAddressCreateDTO.getRegionTemp());
            preparedStatement.setString(9, temporaryAddressCreateDTO.getStreetTemp());
            preparedStatement.setLong(10, temporaryAddressCreateDTO.getPersonId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}
