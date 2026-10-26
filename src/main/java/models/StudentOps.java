package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class StudentOps {
    //Crud opes on students


    public StudentOps() {
        initConnection();

        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    // Making the connection to DB
    // 1. Define database configuration constants
    private static final String URL = "jdbc:mysql://localhost:3306/CMS";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private Connection connection;

    private void initConnection(){
        System.out.println("Connecting to database...");

        // 2. Establish connection using Try-With-Resources
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
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

    //New Student
    public boolean addStudent(Student st) {
        // 1. SQL with structural placeholders (?)
        String query = "INSERT INTO student (roll_no, name, year, dept) VALUES (?, ?, ?, ?);";

        // 2. Use PreparedStatement to safely process input parameters
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // 3. Map your object parameters to the placeholders
            preparedStatement.setString(1, st.getRollNo());
            preparedStatement.setString(2, st.getName());
            preparedStatement.setInt(3, st.getYear());
            preparedStatement.setString(4, st.getDept());

            // 4. executeUpdate returns the number of rows inserted (should be 1)
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Student record added successfully!");
                return true;
            }

        } catch (SQLException e) {
            System.err.println("Failed to insert student record!");
            e.printStackTrace();
        }

        return false;
    }

    // Retriveiw Student
    public Student getStudent(){
        return new Student("","");
    }

    //Modify Student
    public boolean modify(){
        // need to do a lot of things like
        //1.check what part of the data modified then call exsate methode to update
        // need more method for update

        return false;
    }

    //For Drop Student need to approach
    //1. remove entaire record
    //2. make him inactive
    //only adding the remove of the record
    public boolean removeStudent(){

        return false;
    }

    private void close() {
        System.out.println("Shutdown hook triggered...");
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
