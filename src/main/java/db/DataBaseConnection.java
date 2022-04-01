package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    private String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
    private String jdbcUsername = "postgres";
    private String jdbcPassword = "admin";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
