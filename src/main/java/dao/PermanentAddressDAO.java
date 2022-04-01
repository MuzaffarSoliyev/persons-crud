package dao;

import db.DataBaseConnection;
import dto.PermanentAddressCreateDTO;
import dto.PermanentAddressReadDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PermanentAddressDAO {
    private static final String INSERT_DATA = "INSERT INTO permanentaddress" + " (city, country, district, flat, home, livefrom, region, street, person_id) VALUES" +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ADDRESS_BY_ID = "SELECT id, city, country, district, flat, home, livefrom, region, street, person_id FROM permanentaddress WHERE person_id=?;";
    private static final String SELECT_ALL_DATA = "SELECT * from permanentaddress;";
    private static final String DELETE_BY_ID = "DELETE FROM permanentaddress WHERE person_id=?;";
    private static final String UPDATE_BY_ID = "UPDATE permanentaddress set city = ?, country = ?, district = ?, flat = ?, home = ?, livefrom = ?, region = ?, street = ? WHERE person_id=?;";
    private DataBaseConnection dataBaseConnection = new DataBaseConnection();

    public void insertPermanentAddress(PermanentAddressCreateDTO permanentAddressCreateDTO) {
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DATA);
        ) {
            preparedStatement.setString(1, permanentAddressCreateDTO.getCityPer());
            preparedStatement.setString(2, permanentAddressCreateDTO.getCountryPer());
            preparedStatement.setString(3, permanentAddressCreateDTO.getDistrictPer());
            preparedStatement.setString(4, permanentAddressCreateDTO.getFlatPer());
            preparedStatement.setString(5, permanentAddressCreateDTO.getHomePer());
            preparedStatement.setDate(6, Date.valueOf(permanentAddressCreateDTO.getLiveFromPer()));
            preparedStatement.setString(7, permanentAddressCreateDTO.getRegionPer());
            preparedStatement.setString(8, permanentAddressCreateDTO.getStreetPer());
            preparedStatement.setLong(9, permanentAddressCreateDTO.getPersonId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PermanentAddressReadDTO> selectPermanentAddress() {
        List<PermanentAddressReadDTO> permanentAddressReadDTOS = new ArrayList<>();
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
                String region = resultSet.getString("region");
                String street = resultSet.getString("street");
                Long person_id = resultSet.getLong("person_id");
                permanentAddressReadDTOS.add(new PermanentAddressReadDTO(id, city, country, district, flat, home, liveFrom, region, street, person_id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return permanentAddressReadDTOS;
    }

    public PermanentAddressReadDTO selectPermanentAddressById(Long personId) {
        PermanentAddressReadDTO permanentAddressReadDTO = null;
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
                String region = resultSet.getString("region");
                String street = resultSet.getString("street");
                Long person_id = resultSet.getLong("person_id");
                permanentAddressReadDTO = new PermanentAddressReadDTO(id, city, country, district, flat, home, liveFrom, region, street, person_id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return permanentAddressReadDTO;
    }

    public boolean deletePermanentAddress(Long id) {
        boolean rowDeleted = false;
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        ) {
            preparedStatement.setLong(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
        }
        return rowDeleted;
    }

    public boolean updatePermanentAddress(PermanentAddressCreateDTO permanentAddressCreateDTO){
        boolean rowUpdated = false;
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
        ) {
            preparedStatement.setString(1, permanentAddressCreateDTO.getCityPer());
            preparedStatement.setString(2, permanentAddressCreateDTO.getCountryPer());
            preparedStatement.setString(3, permanentAddressCreateDTO.getDistrictPer());
            preparedStatement.setString(4, permanentAddressCreateDTO.getFlatPer());
            preparedStatement.setString(5, permanentAddressCreateDTO.getHomePer());
            preparedStatement.setDate(6, Date.valueOf(permanentAddressCreateDTO.getLiveFromPer()));
            preparedStatement.setString(7, permanentAddressCreateDTO.getRegionPer());
            preparedStatement.setString(8, permanentAddressCreateDTO.getStreetPer());
            preparedStatement.setLong(9, permanentAddressCreateDTO.getPersonId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
        }
        return rowUpdated;
    }

}
