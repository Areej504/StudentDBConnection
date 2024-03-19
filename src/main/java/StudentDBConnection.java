import java.sql.*;
/**
 * This class creates a connection to the Students Database in PostgreSQL16 and
 * performs various functions to update and query the database.
 * @author Areej Mahmoud 101218260
 */

public class StudentDBConnection{
    Connection conn;
    public StudentDBConnection(Connection conn) {
        this.conn = conn;
    }

    /**
     * Retrieves and displays all records from the students table.
     */
    public void getAllStudents() throws SQLException {
        // Create statement
        Statement stmt = conn.createStatement(); // Execute SQL query
        String SQL = "SELECT * FROM students";
        ResultSet rs = stmt.executeQuery(SQL); // Process the result set
        while(rs.next()){
            int id = rs.getInt("student_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            String enrolDate = rs.getString("enrollment_date");
            System.out.println(id+" "+firstName+" "+lastName+" "+email+" "+enrolDate);
        }
        // Close resources
        rs.close();
        stmt.close();

    }

    /**
     * Inserts a new student record into the students table.
     * @param first_name student's first name
     * @param last_name student's last name
     * @param email the email of the student
     * @param enrollment_date the student's enrollment date
     */
    public void addStudent(String first_name,String last_name,String email,String enrollment_date){
        String insertSQL = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            Date date = Date.valueOf(enrollment_date);//converting string into sql date
            pstmt.setDate(4, date);
            pstmt.executeUpdate();
            System.out.println("Data inserted using PreparedStatement.");
        }catch(SQLException se){
            se.printStackTrace();
        }
    }

    /**
     * Updates the email address for a student with the specified student_id.
     * @param student_id
     * @param new_email
     */
    public void updateStudentEmail(int student_id,String new_email){
        String updateSQL = "UPDATE students\n" +
                "SET email = ?\n" +
                "WHERE student_id = ?;";
        try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setString(1, new_email);
            pstmt.setInt(2, student_id);
            pstmt.executeUpdate();
            System.out.println("Data updated using PreparedStatement.");
        }catch(SQLException se){
            se.printStackTrace();
        }

    }

    /**
     * Deletes the record of the student with the specified student_id.
     * @param student_id
     */
    public void deleteStudent(int student_id){
        String deleteSQL = "DELETE FROM students\n" +
                "WHERE student_id = ?;";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, student_id);
            pstmt.executeUpdate();
            System.out.println("Data deleted using PreparedStatement.");
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
    public static void main(String[] args){
        String url = "jdbc:postgresql://localhost:5432/Students";
        String user = "postgres";
        String password = "24AreejSQL";
        try {
            // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");
            // Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to PostgreSQL successfully!");
                StudentDBConnection students = new StudentDBConnection(conn);
                //students.getAllStudents();
                //students.addStudent("Jimmy", "Neutron", "jim.neutron@example.com", "2023-09-03");
                //students.updateStudentEmail(4, "jim_neutron22@example.com");
                //students.deleteStudent(4);
            } else {
                System.out.println("Failed to establish connection.");
            }
            //Close the connection
            conn.close();
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
