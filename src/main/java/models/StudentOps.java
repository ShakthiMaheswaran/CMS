package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

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

    // Retrieve Student
    // By Year and Dept...
    public ArrayList<Student> getStudents(int year, String dept){

        ArrayList<Student> students = new ArrayList<Student>();
        // 1. SQL with structural placeholders (?)
        String query =  "SELECT * FROM student\n" +
                        "WHERE year = ? AND dept = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, year);
            preparedStatement.setString(2, dept);

           try (ResultSet rs = preparedStatement.executeQuery()) {
               while(rs.next()){
                   students.add(new Student(
                           rs.getString("roll_no"),
                           rs.getString("name"),
                           rs.getInt("year"),
                           rs.getString("dept")));
               }
           }

        } catch (SQLException e) {
            System.err.println("Failed to fetch student records!");
            e.printStackTrace();
        }

        return students;
    }

    //By Roll No
    public Student getStudent(String rollno){

        Student student ;
        // 1. SQL with structural placeholders (?)
        String query =  "SELECT * FROM student\n" +
                        "WHERE roll_no = ? ;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, rollno);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()){
                    student = new Student(
                            rs.getString("roll_no"),
                            rs.getString("name"),
                            rs.getInt("year"),
                            rs.getString("dept"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Failed to fetch student records!");
            e.printStackTrace();
        }

        return null;
    }

    //By only year
    public ArrayList<Student> getStudents(int year){

        ArrayList<Student> students = new ArrayList<Student>();
        // 1. SQL with structural placeholders (?)
        String query =  "SELECT * FROM student\n" +
                        "WHERE year = ? ;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, year);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while(rs.next()){
                    students.add(new Student(
                            rs.getString("roll_no"),
                            rs.getString("name"),
                            rs.getInt("year"),
                            rs.getString("dept")));
                }
            }

        } catch (SQLException e) {
            System.err.println("Failed to fetch student records!");
            e.printStackTrace();
        }

        return students;
    }

    //By only Dept
    public ArrayList<Student> getStudents(String dept){

        ArrayList<Student> students = new ArrayList<Student>();
        // 1. SQL with structural placeholders (?)
        String query =  "SELECT * FROM student\n" +
                        "WHERE dept = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, dept);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while(rs.next()){
                    students.add(new Student(
                            rs.getString("roll_no"),
                            rs.getString("name"),
                            rs.getInt("year"),
                            rs.getString("dept")));
                }
            }

        } catch (SQLException e) {
            System.err.println("Failed to fetch student records!");
            e.printStackTrace();
        }

        return students;
    }


    //Modify Student
    public boolean modify(){
        // need to do a lot of things like
        //1.check what part of the data modified then call exsote methode to update
        // need more method for update

        return false;
    }

    //For Drop Student need to approach
    //1. remove entire record
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
