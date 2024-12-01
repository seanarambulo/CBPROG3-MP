package src.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/shuttlesystem";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "kyss092722SMDA";

    private Connection connection;

    // Constructor to establish a connection
    public DatabaseManager() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        connection.setAutoCommit(true);
    }
    
    public void updateIrregAttendance(int shuttleBookingID) throws SQLException {
        String sql = "UPDATE irregshuttlebooking SET isApproved = TRUE WHERE IrregShuttleBookingID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, shuttleBookingID);
            pstmt.executeUpdate();
        }
    }
    public void updateAttendance(int shuttleBookingID) throws SQLException {
        String sql = "UPDATE Booking SET Attendance = TRUE WHERE ShuttleBookingID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, shuttleBookingID);
            pstmt.executeUpdate();
        }
    }
    
    // Method to insert into the Designation table
    public void insertIntoDesignation(int id, String type) throws SQLException {
        String sql = "INSERT INTO Designation (DesignationID, DesignationType) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, type);
            pstmt.executeUpdate();
        }
    }

    // Method to insert into the ClassDays table
    public void insertIntoClassDays(int id, int dayName) throws SQLException {
        String sql = "INSERT INTO ClassDays (ClassDaysID, DayName) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, dayName);
            pstmt.executeUpdate();
        }
    }

    // Method to insert into the ArrowsExpressLine table
    public void insertIntoArrowsExpressLine(int id, String lineName) throws SQLException {
        String sql = "INSERT INTO ArrowsExpressLine (LineID, LineName) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, lineName);
            pstmt.executeUpdate();
        }
    }

    // Method to insert into the Admin table
    public void insertIntoAdmin(int id, String password) throws SQLException {
        String sql = "INSERT INTO Admin (AdminID, Password) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        }
    }

    // Method to insert into the Dispatcher table
    public void insertIntoDispatcher(int id, String password) throws SQLException {
        String sql = "INSERT INTO Dispatcher (DispatcherID, Password) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        }
    }

    // Method to insert into the Time table
    public void insertIntoTime(int id, String time) throws SQLException {
        String sql = "INSERT INTO Time (TimeID, Time) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, time);
            pstmt.executeUpdate();
        }
    }

    // Method to insert into the User table
    public void insertIntoUser(int id, String username, String password, String email, int designationId) throws SQLException {
        String sql = "INSERT INTO User (UserID, UserName, Password, Email, DesignationID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.setString(4, email);
            pstmt.setInt(5, designationId);
            pstmt.executeUpdate();
        }
    }

    // Method to insert into the Student table
    public void insertIntoStudent(int id, int trimester, String eaf, boolean isVerified) throws SQLException {
        String sql = "INSERT INTO Student (StudentID, Trimester, EAF, isVerified, ClassDaysID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, trimester);
            pstmt.setString(3, eaf);
            pstmt.setBoolean(4, isVerified);
            pstmt.executeUpdate();
        }
    }

    // Method to insert into the Booking table
    public void insertIntoBooking(int id, boolean attendance, String origin, String destination, String date, int shuttleScheduleId, int lineId) throws SQLException {
        String sql = "INSERT INTO Booking (ShuttleBookingID, Attendance, Origin, Destination, Date, ShuttleScheduleID, LineID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setBoolean(2, attendance);
            pstmt.setString(3, origin);
            pstmt.setString(4, destination);
            pstmt.setString(5, date);
            pstmt.setInt(6, lineId);
            pstmt.executeUpdate();
        }
    }

    // Add more methods for other tables as needed...
    public User getUserByCredentials(String username, String password) throws SQLException {
        String sql = "SELECT * FROM User WHERE UserName = ? AND Password = ?";
        User user = null;

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setUserID(rs.getInt("UserID"));
                    user.setUserName(rs.getString("UserName"));
                    user.setPassword(rs.getString("Password"));
                    user.setEmail(rs.getString("Email"));
                    user.setDesignationID(rs.getInt("DesignationID"));
                }
            }
        }

        return user;
    }
    
    public int getDesignationID(int userID, String password) throws SQLException {
        String sql = "SELECT DesignationID FROM User WHERE UserID = ? AND Password = ?";
        int designationID = -1; // Default value if no user is found

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userID);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    designationID = rs.getInt("DesignationID");
                }
            }
        }

        return designationID;
    }

    public User getUserByID(int userID, String password) throws SQLException {

        String userSql = "SELECT * FROM User WHERE UserID = ? AND Password = ?";
        String studentSql = "SELECT * FROM user U, Student S, ClassDays C, Days D WHERE U.UserID = S.StudentID  AND C.StudentID = S.StudentID AND C.DaysID = D.DaysID AND S.StudentID = ?";

        User user = null;
        
        try (PreparedStatement userStmt = connection.prepareStatement(userSql)) {
            userStmt.setInt(1, userID);
            userStmt.setString(2, password);

            try (ResultSet userRs = userStmt.executeQuery()) {
                if (userRs.next()) {
                    int designationID = userRs.getInt("DesignationID");

                    // Check if the user is a Student
                    if (designationID == 1) { // Assuming 1 is Student's designation
                        try (PreparedStatement studentStmt = connection.prepareStatement(studentSql)) {
                            studentStmt.setInt(1, userID);

                            try (ResultSet studentRs = studentStmt.executeQuery()) {
                                if (studentRs.next()) {
                                    Student student = new Student();
                                    // Populate common User fields
                                    student.setUserID(userRs.getInt("UserID"));
                                    student.setUserName(userRs.getString("UserName"));
                                    student.setPassword(userRs.getString("Password"));
                                    student.setEmail(userRs.getString("Email"));
                                    student.setDesignationID(userRs.getInt("DesignationID"));

                                    // Populate Student-specific fields
                                    student.setTrimesterID(studentRs.getInt("Trimester"));
                                    student.setEAF(studentRs.getString("EAF"));
                                    student.setIsVerified(studentRs.getBoolean("isVerified"));
                                    student.setClassDay(studentRs.getString("DayName"));

                                    user = student;
                                }
                            }
                        }
                    } else {
                        // Normal User
                        user = new User();
                        user.setUserID(userRs.getInt("UserID"));
                        user.setUserName(userRs.getString("UserName"));
                        user.setPassword(userRs.getString("Password"));
                        user.setEmail(userRs.getString("Email"));
                        user.setDesignationID(userRs.getInt("DesignationID"));
                    }
                }
            }
        }

        return user;
    }

    public void RegisterUser(int userID, String userName, String password, String email, int designationID) throws SQLException {
        // SQL query to insert new user
        String sql = "INSERT INTO User (UserID, UserName, Password, Email, DesignationID) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            // Set the parameters for the query
            pstmt.setInt(1, userID);          // Set UserID
            pstmt.setString(2, userName);     // Set Username
            pstmt.setString(3, password);     // Set Password
            pstmt.setString(4, email);        // Set Email
            pstmt.setInt(5, designationID);   // Set DesignationID (from ComboBox selection)

            // Execute the update (insert new user)
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User registered successfully.");
            } else {
                System.out.println("Failed to register the user.");
            }
        }
    }


    // Method for User to update User Data
    public void updateUserData(int userID, String newUsername, String newEmail, String newPassword) throws SQLException {
        // SQL query to update user data
        String sql = "UPDATE User SET UserName = ?, Email = ?, Password = ? WHERE UserID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            // Set the parameters for the update query
            pstmt.setString(1, newUsername);   // Set new username
            pstmt.setString(2, newEmail);      // Set new email
            pstmt.setString(3, newPassword);   // Set new password
            pstmt.setInt(4, userID);           // Specify which user to update
            pstmt.executeUpdate();
        }
    }

    // Method for Admin to update User Data

    public void adminUpdateUserData(int userID, String newUsername, String newEmail) throws SQLException {
        // SQL query to update user data
        String sql = "UPDATE User SET UserName = ?, Email = ? WHERE UserID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            // Set the parameters for the update query
            pstmt.setString(1, newUsername);   // Set new username
            pstmt.setString(2, newEmail);      // Set new email
            pstmt.setInt(3, userID);           // Specify which user to update
            pstmt.executeUpdate();
        }
    }

    // Method to check if a user exists based on user ID
    public boolean checkIfUserExists(int userId) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE user_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // If count > 0, user exists
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex; // Rethrow the exception after logging it
        }
        return false; // Default to false if no user found or any error occurs
    }


// Method to fetch pending reservations
    public ArrayList<ShuttleBookingView> getReservations(String LineName, String date, String time) throws SQLException {
        String sql = """
            SELECT b.ShuttleBookingID,b.Attendance, b.UserID, b.Destination, b.Date, t.Time
            FROM Booking b
            JOIN ArrowsExpressLine l ON b.LineID = l.LineID
            JOIN `Time` t ON t.TimeID = l.TimeID
            WHERE l.LineName = ? AND b.Date = ? AND t.Time = ? AND b.Attendance = 0
            """;

        ArrayList<ShuttleBookingView> reservations = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, LineName);
            pstmt.setString(2, date);
            pstmt.setString(3, time);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ShuttleBookingView reservation = new ShuttleBookingView();
                    reservation.setShuttleBookingID(rs.getInt("ShuttleBookingID"));
                    reservation.setAttendance(rs.getBoolean("Attendance"));
                    reservation.setUserID(rs.getInt("UserID"));
                    reservation.setDestination(rs.getString("Destination"));
                    reservation.setDate(rs.getString("Date"));
                    reservation.setTime(rs.getString("Time"));
                    reservations.add(reservation);
                }
            }
        }

        return reservations;
    }

    public ArrayList<ShuttleBookingView> getReservations( String LineName, String date, String time, int Attandance) throws SQLException {
        String sql = """
            SELECT b.ShuttleBookingID,b.Attendance, b.UserID, b.Destination, b.Date, t.Time
            FROM Booking b
            JOIN ArrowsExpressLine l ON b.LineID = l.LineID
            JOIN `Time` t ON t.TimeID = l.TimeID
            WHERE l.LineName = ? AND b.Date = ? AND t.Time = ? AND b.Attendance = 0
            """;

        ArrayList<ShuttleBookingView> reservations = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, LineName);
            pstmt.setString(2, date);
            pstmt.setString(3, time);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ShuttleBookingView reservation = new ShuttleBookingView();
                    reservation.setShuttleBookingID(rs.getInt("ShuttleBookingID"));
                    reservation.setAttendance(rs.getBoolean("Attendance"));
                    reservation.setUserID(rs.getInt("UserID"));
                    reservation.setDestination(rs.getString("Destination"));
                    reservation.setDate(rs.getString("Date"));
                    reservation.setTime(rs.getString("Time"));
                    reservations.add(reservation);
                }
            }
        }

        return reservations;
    }

    public ArrayList<ShuttleBookingView> getReservations(int userID) throws SQLException {
        String sql = """
            SELECT b.ShuttleBookingID,b.Attendance, b.UserID, b.Destination, b.Date, t.Time
            FROM Booking b
            JOIN ArrowsExpressLine l ON b.LineID = l.LineID
            JOIN `Time` t ON t.TimeID = l.TimeID
            WHERE UserID = ? AND b.Attendance = 0
            """;

        ArrayList<ShuttleBookingView> reservations = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
           

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ShuttleBookingView reservation = new ShuttleBookingView();
                    reservation.setShuttleBookingID(rs.getInt("ShuttleBookingID"));
                    reservation.setAttendance(rs.getBoolean("Attendance"));
                    reservation.setUserID(rs.getInt("UserID"));
                    reservation.setDestination(rs.getString("Destination"));
                    reservation.setDate(rs.getString("Date"));
                    reservation.setTime(rs.getString("Time"));
                    reservations.add(reservation);
                }
            }
        }

        return reservations;
    }

    // Method to close the connection
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public ArrayList<Student> getRegistration() throws SQLException {
        String sql = """
            SELECT S.StudentID, S.Trimester, S.EAF, D.DayName, S.isVerified
            FROM User U, Student S, ClassDays C, Days D
            WHERE U.UserID = S.StudentID 
              AND C.StudentID = S.StudentID 
              AND C.DaysID = D.DaysID AND S.isVerified = 0
        """;
    
        ArrayList<Student> students = new ArrayList<>();
    
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setUserID(rs.getInt("StudentID"));
                student.setTrimesterID(rs.getInt("Trimester"));
                student.setEAF(rs.getString("EAF"));
                student.setClassDay(rs.getString("DayName"));
                student.setIsVerified(rs.getBoolean("isVerified"));
    
                students.add(student);
            }
        }
        return students;
    }

    public void updateVerification(int userID) throws SQLException {
        String query = "UPDATE Student SET isVerified = TRUE WHERE StudentID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();
           
        } catch (SQLException e) {
            System.err.println("Error updating verification for StudentID: " + userID);
            throw e;
        }
    }
    
    public ArrayList<IrregReservation> getIrregularReservations() throws SQLException {
        String sql = """
            SELECT IR.IrregShuttleBookingID, B.Destination, B.Date, T.Time, IR.Reason, B.UserID, IR.isApproved
            FROM irregshuttlebooking IR
            JOIN booking B ON IR.IrregShuttleBookingID = B.ShuttleBookingID
            JOIN time T ON T.TimeID = B.TimeID
            WHERE IR.isApproved = 0
        """;
    
        ArrayList<IrregReservation> irregularReservations = new ArrayList<>();
    
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                IrregReservation irregReservation = new IrregReservation();
                irregReservation.setShuttleBookingID(rs.getInt("IrregShuttleBookingID"));
                irregReservation.setDestination(rs.getString("Destination"));
                irregReservation.setDate(rs.getString("Date"));
                irregReservation.setTime(rs.getString("Time"));
                irregReservation.setReason(rs.getString("Reason"));
                irregReservation.setUserID(rs.getInt("UserID"));
                irregReservation.setApproved(rs.getBoolean("isApproved"));
                irregularReservations.add(irregReservation);
            }
        }
    
        return irregularReservations;
    }


    // Main method for testing
    

    /*public static void main(String[] args) {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            String username = "student1";
            String password = "studentpass";
    
            User user = dbManager.getUserByCredentials(username, password);
            if (user != null) {
                System.out.println("Login successful!");
                System.out.println("User details: " + user);
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}

