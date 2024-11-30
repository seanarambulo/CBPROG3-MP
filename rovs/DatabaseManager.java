import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/shuttlesystem";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345678";

    private Connection connection;

    // Constructor to establish a connection
    public DatabaseManager() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        connection.setAutoCommit(true);
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
    public void insertIntoClassDays(int id, String dayName) throws SQLException {
        String sql = "INSERT INTO ClassDays (ClassDaysID, DayName) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, dayName);
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
    public void insertIntoStudent(int id, int trimester, String eaf, boolean isVerified, int classDaysId) throws SQLException {
        String sql = "INSERT INTO Student (StudentID, Trimester, EAF, isVerified, ClassDaysID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, trimester);
            pstmt.setString(3, eaf);
            pstmt.setBoolean(4, isVerified);
            pstmt.setInt(5, classDaysId);
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
            pstmt.setInt(6, shuttleScheduleId);
            pstmt.setInt(7, lineId);
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
    String studentSql = "SELECT * FROM Student WHERE StudentID = ?";

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
                                student.setTrimester(studentRs.getInt("Trimester"));
                                student.setEaf(studentRs.getString("EAF"));
                                student.setVerified(studentRs.getBoolean("isVerified"));
                                student.setClassDaysID(studentRs.getInt("ClassDaysID"));

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

// Method to fetch pending reservations
    public ArrayList<Reservation> getReservations( String LineName, String date, String time) throws SQLException {
        String sql = """
            SELECT b.ShuttleBookingID,b.Attendance, b.UserID, b.Destination, b.Date, t.Time
            FROM Booking b
            JOIN ArrowsExpressLine l ON b.LineID = l.LineID
            JOIN `Time` t ON t.TimeID = l.TimeID
            WHERE l.LineName = ? AND b.Date = ? AND t.Time = ? AND b.Attendance = 0
            """;

        ArrayList<Reservation> reservations = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, LineName);
            pstmt.setString(2, date);
            pstmt.setString(3, time);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Reservation reservation = new Reservation();
                    reservation.setbookingID(rs.getInt("ShuttleBookingID"));
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

    public ArrayList<Reservation> getReservations( String LineName, String date, String time, int Attandance) throws SQLException {
        String sql = """
            SELECT b.ShuttleBookingID,b.Attendance, b.UserID, b.Destination, b.Date, t.Time
            FROM Booking b
            JOIN ArrowsExpressLine l ON b.LineID = l.LineID
            JOIN `Time` t ON t.TimeID = l.TimeID
            WHERE l.LineName = ? AND b.Date = ? AND t.Time = ? AND b.Attendance = 0
            """;

        ArrayList<Reservation> reservations = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, LineName);
            pstmt.setString(2, date);
            pstmt.setString(3, time);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Reservation reservation = new Reservation();
                    reservation.setbookingID(rs.getInt("ShuttleBookingID"));
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
