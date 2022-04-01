package dao;

import db.DataBaseConnection;
import dto.PassportCreateDTO;
import dto.PassportReadDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PassportDAO {
    private static final String INSERT_DATA = "INSERT INTO passport" + " (expired, issued, issuedby, number, series, person_id) VALUES" +
            " (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_PASSPORT_BY_ID = "SELECT id, expired, issued, issuedby, number, series, person_id FROM passport WHERE person_id=?;";
    private static final String SELECT_ALL_DATA = "SELECT * from passport;";
    private static final String DELETE_BY_ID = "DELETE FROM passport WHERE person_id=?;";
    private static final String UPDATE_BY_ID = "UPDATE passport set expired = ?, issued = ?, issuedby = ?, number = ?, series = ? WHERE person_id=?;";
    private DataBaseConnection dataBaseConnection = new DataBaseConnection();

    public void insertPassport(PassportCreateDTO passportCreateDTO) {
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DATA);
        ) {
            preparedStatement.setDate(1, Date.valueOf(passportCreateDTO.getExpired()));
            preparedStatement.setDate(2, Date.valueOf(passportCreateDTO.getIssued()));
            preparedStatement.setString(3, passportCreateDTO.getIssuedBy());
            preparedStatement.setString(4, passportCreateDTO.getNumber());
            preparedStatement.setString(5, passportCreateDTO.getSeries());
            preparedStatement.setLong(6, passportCreateDTO.getPersonId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PassportReadDTO> selectPassport() {
        List<PassportReadDTO> passportReadDTOS = new ArrayList<>();
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DATA);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                LocalDate expired = LocalDate.parse(resultSet.getString("expired"));
                LocalDate issued = LocalDate.parse(resultSet.getString("issued"));
                String issuedBy = resultSet.getString("issuedby");
                String number = resultSet.getString("number");
                String series = resultSet.getString("series");
                Long person_id = resultSet.getLong("person_id");
                passportReadDTOS.add(new PassportReadDTO(id, expired, issued, issuedBy, number, series, person_id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passportReadDTOS;
    }

    public PassportReadDTO selectPassportById(Long personId) {
        PassportReadDTO passportReadDTO = null;
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PASSPORT_BY_ID);
        ) {
            preparedStatement.setLong(1, personId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                LocalDate expired = LocalDate.parse(resultSet.getString("expired"));
                LocalDate issued = LocalDate.parse(resultSet.getString("issued"));
                String issuedBy = resultSet.getString("issuedby");
                String number = resultSet.getString("number");
                String series = resultSet.getString("series");
                Long person_id = resultSet.getLong("person_id");
                passportReadDTO = new PassportReadDTO(id, expired, issued, issuedBy, number, series, person_id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passportReadDTO;
    }

    public boolean deletePassport(Long id) {
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

    public boolean updatePassport(PassportCreateDTO passportCreateDTO) {
        boolean rowUpdated = false;
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
        ) {
            preparedStatement.setDate(1, Date.valueOf(passportCreateDTO.getExpired()));
            preparedStatement.setDate(2, Date.valueOf(passportCreateDTO.getIssued()));
            preparedStatement.setString(3, passportCreateDTO.getIssuedBy());
            preparedStatement.setString(4, passportCreateDTO.getNumber());
            preparedStatement.setString(5, passportCreateDTO.getSeries());
            preparedStatement.setLong(6, passportCreateDTO.getPersonId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}
