package dao;

import db.DataBaseConnection;
import dto.PassportReadDTO;
import dto.PhoneCreateDTO;
import dto.PhoneReadDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAO {
    private static final String INSERT_DATA = "INSERT INTO phone" + " (number, person_id) VALUES" +
            " (?, ?);";
    private static final String SELECT_ADDRESS_BY_ID = "SELECT id, number, person_id FROM phone WHERE person_id=?;";
    private static final String SELECT_ALL_DATA = "SELECT * from phone;";
    private static final String DELETE_BY_ID = "DELETE FROM phone WHERE person_id=?;";
    private static final String UPDATE_BY_ID = "UPDATE phone set number = ? WHERE person_id=?;";
    private DataBaseConnection dataBaseConnection = new DataBaseConnection();

    public void insertPhone(PhoneCreateDTO phoneCreateDTO){
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DATA);
        ) {
            preparedStatement.setString(1, phoneCreateDTO.getPhoneNumber());
            preparedStatement.setLong(2, phoneCreateDTO.getPersonId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PhoneReadDTO> selectPhone(){
        List<PhoneReadDTO> phoneReadDTOS = new ArrayList<>();
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DATA);
        ){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String phoneNumber = resultSet.getString("number");
                Long person_id = resultSet.getLong("person_id");
                phoneReadDTOS.add(new PhoneReadDTO(id, phoneNumber, person_id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phoneReadDTOS;
    }

    public PhoneReadDTO selectPhoneById(Long personId){
        PhoneReadDTO phoneReadDTO = null;
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADDRESS_BY_ID);
        ){
            preparedStatement.setLong(1, personId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String phoneNumber = resultSet.getString("number");
                Long person_id = resultSet.getLong("person_id");
                phoneReadDTO = new PhoneReadDTO(id, phoneNumber, person_id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phoneReadDTO;
    }

    public boolean deletePhone(Long id){
        boolean rowDeleted = false;
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        ){
            preparedStatement.setLong(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean updatePhone(PhoneCreateDTO phoneCreateDTO){
        boolean rowUpdated = false;
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
        ){
            preparedStatement.setString(1, phoneCreateDTO.getPhoneNumber());
            preparedStatement.setLong(2, phoneCreateDTO.getPersonId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}
