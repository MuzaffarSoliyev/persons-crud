package dao;

import db.DataBaseConnection;
import dto.PersonReadDTO;
import dto.PersonalDataCreateDTO;
import dto.PersonalDataReadDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonalDataDAO {
    private static final String INSERT_DATA = "INSERT INTO person" + " (birthdate, name, surname) VALUES" + " (?, ?, ?) RETURNING id;";
    private static final String SELECT_BY_ID = "SELECT id, birthdate, name, surname FROM person WHERE id=?;";
    private static final String SELECT_ALL_DATA = "SELECT * FROM person;";
    private static final String DELETE_BY_ID = "DELETE FROM person WHERE id=?;";
    private static final String UPDATE_BY_ID = "UPDATE person set birthdate=?, name=?, surname=? WHERE id=?;";
    private DataBaseConnection dataBaseConnection = new DataBaseConnection();

    public Long insertPersonalData(PersonalDataCreateDTO personalDataCreateDTO) {
        Long id = null;
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DATA);
        ) {
            preparedStatement.setDate(1, Date.valueOf(personalDataCreateDTO.getBirthDate()));
            preparedStatement.setString(2, personalDataCreateDTO.getName());
            preparedStatement.setString(3, personalDataCreateDTO.getSurname());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getLong("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public List<PersonalDataReadDTO> selectPersonalData() {
        List<PersonalDataReadDTO> personalDataReadDTOS = new ArrayList<>();
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DATA);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                LocalDate birthDate = LocalDate.parse(resultSet.getString("birthdate"));
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                personalDataReadDTOS.add(new PersonalDataReadDTO(id, birthDate, name, surname));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personalDataReadDTOS;
    }

    public PersonalDataReadDTO selectPersonalDataById(Long id) {
        PersonalDataReadDTO personalDataReadDTO = null;
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
        ) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long person_id = resultSet.getLong("id");
                LocalDate birthDate = LocalDate.parse(resultSet.getString("birthdate"));
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                personalDataReadDTO = new PersonalDataReadDTO(person_id, birthDate, name, surname);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personalDataReadDTO;
    }

    public boolean deletePersonalData(Long id) {
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

    public boolean updatePersonalData(PersonalDataReadDTO personalDataReadDTO) {
        boolean rowUpdated = false;
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
        ) {
            preparedStatement.setDate(1, Date.valueOf(personalDataReadDTO.getBirthDate()));
            preparedStatement.setString(2, personalDataReadDTO.getName());
            preparedStatement.setString(3, personalDataReadDTO.getSurname());
            preparedStatement.setLong(4, personalDataReadDTO.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}
