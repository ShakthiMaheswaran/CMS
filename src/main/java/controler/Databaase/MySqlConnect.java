package controler.Databaase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnect {

    // 1. Define database configuration constants
    private static final String URL = "jdbc:mysql://localhost:3306/CMS";
    private static final String USER = "shakthi";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        System.out.println("Connecting to database...");

        // 2. Establish connection using Try-With-Resources
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            System.out.println("Connection successful!");

            // 3. (Optional) Run a simple test query
            String query = "SELECT VERSION();";
            try (ResultSet resultSet = statement.executeQuery(query)) {
                if (resultSet.next()) {
                    String serverVersion = resultSet.getString(1);
                    System.out.println("MySQL Server Version: " + serverVersion);
                }
            }

        } catch (SQLException e) {
            System.err.println("Database connection error occurred!");
            e.printStackTrace();
        }
    }
}
