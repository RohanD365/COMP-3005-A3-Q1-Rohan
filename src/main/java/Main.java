import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {

    public void getAllStudents() {
        try {
            String url = "jdbc:postgresql://localhost:5432/Student Information";
            String user = "postgres";
            String password = "Alpha2022";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeQuery("SELECT * FROM students ORDER BY student_id");
            ResultSet resultSet = statement.getResultSet();

            //Will get all the information for the students and output it
            while (resultSet.next()) {
                int studentId = resultSet.getInt("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String enrollmentDate = resultSet.getString("enrollment_date");

                System.out.println("Student ID: " + studentId);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Email: " + email);
                System.out.println("Enrollment Date: " + enrollmentDate);
                System.out.println();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void addStudent(String first_name, String last_name, String email, String enrollment_date) {
        try {
            String url = "jdbc:postgresql://localhost:5432/Student Information";
            String user = "postgres";
            String password = "Alpha2022";
            //SQL Query
            String sql = "INSERT INTO students (first_name, last_name, email, enrollment_date) " + "VALUES ('" + first_name + "', '" + last_name + "', '" + email + "', '" + enrollment_date + "')";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void updateStudentEmail(int student_id, String new_email) {
        try {
            String url = "jdbc:postgresql://localhost:5432/Student Information";
            String user = "postgres";
            String password = "Alpha2022";
            //SQL Query
            String sql = "UPDATE students SET email = '" + new_email + "' WHERE student_id = " + student_id;

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void deleteStudent(int student_id) {
        try {
            String url = "jdbc:postgresql://localhost:5432/Student Information";
            String user = "postgres";
            String password = "Alpha2022";
            // SQL Query
            String sql = "DELETE FROM students WHERE student_id = " + student_id;

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/Student Information";
        String user = "postgres";
        String password = "Alpha2022";

        try {
            Class.forName("org.postgresql.Driver");
            // Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to PostgreSQL successfully!");
                System.out.println("");
            } else {
                System.out.println("Failed to establish connection.");
            }
            conn.close();
        }
        //Error handling to check for any exceptions
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        Main database = new Main();

        System.out.println("getAllStudents(): Retrieves and displays all records from the students table.");
        System.out.println();
        database.getAllStudents();

        System.out.println("addStudent(): Inserts a new student record into the students table");
        database.addStudent("Alex", "White", "alex.white@example.com", "2023-09-03");

        System.out.println();
        System.out.println("updateStudentEmail(): Updates the email address for a student with the specified student_id");
        database.updateStudentEmail(1, "john.doe@gmail.com");

        System.out.println();
        System.out.println("deleteStudent(): Deletes the record of the student with the specified student_id");
        database.deleteStudent(2);

    }
}

