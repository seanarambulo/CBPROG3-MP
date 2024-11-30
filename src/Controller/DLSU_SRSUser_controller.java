package src.Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import src.Model.*;
import src.View.*;

public class DLSU_SRSUser_controller {

    protected User userModel;
    protected DatabaseManager dbm;
    protected UserView userView = new UserView();
    protected ShuttleBookingView selectedReservation = new ShuttleBookingView();

    public DLSU_SRSUser_controller() {
        // blank constructor
    }

    public DLSU_SRSUser_controller(int userID, String password) throws SQLException {
        try {
            dbm = new DatabaseManager();
            userModel = dbm.getUserByID(userID, password);
            if (userModel == null) {
                JOptionPane.showMessageDialog(null, "User not found with the given credentials", "Error", JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException("User not found with the given credentials");
            }
        } catch (SQLException e) {
            Logger.getLogger(DLSU_SRSUser_controller.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException("Failed to initialize DatabaseManager", e);
        }
    }

    public void setUserModel(User userModel) {
        this.userModel = userModel;
    }
    
    public void setUserView(UserView userView) {
        this.userView = userView;
    }
    
    public void setUserID_userController(int userID) {
        userModel.setUserID(userID);
    }
    
    public void setPassword_userController(String password) {
        userModel.setPassword(password);
    }
    
    public void setEmail_userController(String email) {
        userModel.setEmail(email);
    }
    
    public void setUserName_userController(String userName) {
        userModel.setUserName(userName);
    }
    
    public void setDesignation_userController(int designationID) {
        userModel.setDesignationID(designationID);
    }
    
    public void setTrimester_userController(int trimesterID) {
        if (userModel instanceof Student student) {
            student.setTrimesterID(trimesterID);
        } else {
            throw new IllegalArgumentException("User model is not an instance of Student");
        }
    }
    
    public void setIsVerified_userController(boolean isVerified) {
        if (userModel instanceof Student student) {
            student.setIsVerified(isVerified);
        } else {
            throw new IllegalArgumentException("User model is not an instance of Student");
        }
    }
    
    public void setEAF_userController(String EAF) {
        if (userModel instanceof Student student) {
            student.setEAF(EAF);
        } else {
            throw new IllegalArgumentException("User model is not an instance of Student");
        }
    }
    
    public void setClassDay_userController(int classDayID) {
        if (userModel instanceof Student student) {
            student.setClassDayID(classDayID);
        } else {
            throw new IllegalArgumentException("User model is not an instance of Student");
        }
    }
    
    public void insertIntoDesignation(int id, String type) throws SQLException {
        try {
            dbm.insertIntoDesignation(id, type);
        } catch (SQLException e) {
            Logger.getLogger(DLSU_SRSUser_controller.class.getName()).log(Level.SEVERE, null, e);
            throw e; // Rethrow the exception after logging it
        }
    }
    
    // Method to insert into the ClassDays table
    public void insertIntoClassDays(int id, String dayName) throws SQLException {
        try {
            dbm.insertIntoClassDays(id, dayName);
        } catch (SQLException e) {
            Logger.getLogger(DLSU_SRSUser_controller.class.getName()).log(Level.SEVERE, null, e);
            throw e; // Rethrow the exception after logging it
        }
    }
    
    // Method to insert into the ArrowsExpressLine table
    public void insertIntoArrowsExpressLine(int id, String lineName) throws SQLException {
        try {
            dbm.insertIntoArrowsExpressLine(id, lineName);
        } catch (SQLException e) {
            Logger.getLogger(DLSU_SRSUser_controller.class.getName()).log(Level.SEVERE, null, e);
            throw e; // Rethrow the exception after logging it
        }
    }
    
    // Method to insert into the Admin table
    public void insertIntoAdmin(int id, String password) throws SQLException {
        try {
            dbm.insertIntoAdmin(id, password);
        } catch (SQLException e) {
            Logger.getLogger(DLSU_SRSUser_controller.class.getName()).log(Level.SEVERE, null, e);
            throw e; // Rethrow the exception after logging it
        }
    }
    
    // Method to insert into the Dispatcher table
    public void insertIntoDispatcher(int id, String password) throws SQLException {
        try {
            dbm.insertIntoDispatcher(id, password);
        } catch (SQLException e) {
            Logger.getLogger(DLSU_SRSUser_controller.class.getName()).log(Level.SEVERE, null, e);
            throw e; // Rethrow the exception after logging it
        }
    }
    
    // Method to insert into the Time table
    public void insertIntoTime(int id, String time) throws SQLException {
        try {
            dbm.insertIntoTime(id, time);
        } catch (SQLException e) {
            Logger.getLogger(DLSU_SRSUser_controller.class.getName()).log(Level.SEVERE, null, e);
            throw e; // Rethrow the exception after logging it
        }
    }
    
    // Method to insert into the User table
    public void insertIntoUser(int id, String username, String password, String email, int designationId) throws SQLException {
        try {
            dbm.insertIntoUser(id, username, password, email, designationId);
        } catch (SQLException e) {
            Logger.getLogger(DLSU_SRSUser_controller.class.getName()).log(Level.SEVERE, null, e);
            throw e; // Rethrow the exception after logging it
        }
    }
    
    // Method to insert into the Student table
    public void insertIntoStudent(int id, int trimester, String eaf, boolean isVerified, int classDaysId) throws SQLException {
        try {
            dbm.insertIntoStudent(id, trimester, eaf, isVerified, classDaysId);
        } catch (SQLException e) {
            Logger.getLogger(DLSU_SRSUser_controller.class.getName()).log(Level.SEVERE, null, e);
            throw e; // Rethrow the exception after logging it
        }
    }
    
    // Method to insert into the Booking table
    public void insertIntoBooking(int id, boolean attendance, String origin, String destination, String date, int shuttleScheduleId, int lineId) throws SQLException {
        try {
            dbm.insertIntoBooking(id, attendance, origin, destination, date, shuttleScheduleId, lineId);
        } catch (SQLException e) {
            Logger.getLogger(DLSU_SRSUser_controller.class.getName()).log(Level.SEVERE, null, e);
            throw e; // Rethrow the exception after logging it
        }
    }
    
    // Add more methods for other tables as needed...
    public User getUserByCredentials(String username, String password) throws SQLException {
        try {
            return dbm.getUserByCredentials(username, password);
        } catch (SQLException e) {
            Logger.getLogger(DLSU_SRSUser_controller.class.getName()).log(Level.SEVERE, null, e);
            throw e; // Rethrow the exception after logging it
        }
    }
    
    public int getDesignationID(int userID, String password) throws SQLException {
        try {
            return dbm.getDesignationID(userID, password);
        } catch (SQLException e) {
            Logger.getLogger(DLSU_SRSUser_controller.class.getName()).log(Level.SEVERE, null, e);
            throw e; // Rethrow the exception after logging it
        }
    }
    
    public User getUserByID(int userID, String password) throws SQLException {
        try {
            return dbm.getUserByID(userID, password);
        } catch (SQLException e) {
            Logger.getLogger(DLSU_SRSUser_controller.class.getName()).log(Level.SEVERE, null, e);
            throw e; // Rethrow the exception after logging it
        }
    }
    
    public ArrayList<ShuttleBookingView> ReservationsList() throws SQLException {
        try {
            return dbm.ReservationsList();
        } catch (SQLException e) {
            Logger.getLogger(DLSU_SRSUser_controller.class.getName()).log(Level.SEVERE, null, e);
            throw e; // Rethrow the exception after logging it
        }
    }
    
    // Method to close the connection
    public void close() throws SQLException {
        try {
            dbm.close();
        } catch (SQLException e) {
            Logger.getLogger(DLSU_SRSUser_controller.class.getName()).log(Level.SEVERE, null, e);
            throw e; // Rethrow the exception after logging it
        }
    }
    
    public int getUserID_userController() {
        return userModel.getUserID();
    }
    
    public String getPassword_userController() {
        return userModel.getPassword();
    }
    
    public String getEmail_userController() {
        return userModel.getEmail();
    }
    
    public String getUserName_userController() {
        return userModel.getUserName();
    }
    
    public int getDesignation_userController() {
        return userModel.getDesignationID();
    }
    
    public int getTrimesterID_userController() {
        return ((Student) userModel).getTrimesterID();
    }
    
    public boolean getIsVerified_userController() {
        return ((Student) userModel).getIsVerified();
    }
    
    public String getEAF_userController() {
        return ((Student) userModel).getEAF();
    }
    
    public int getClassDayID_userController() {
        return ((Student) userModel).getClassDayID();
    }

    public void SRS_VIEW_userController() {
        userView.SRS_LOGIN();
    }

    public void SRS1FRAME_REGISTRATION_userController() {
        userView.UserSRSFRAME1_REGISTRATION(this);
    }
    
    public void SRS2FRAME_VERIFY_userController() {
        userView.UserSRSFRAME2_VERIFY(this);
    }
    
    public void SRSFRAME3_USERINTERFACE_userController() {
        userView.UserSRSFRAME3_USERINTERFACE(this);
    }
    
    public void SRSFRAME4_ADDSHUTTLEBOOKING_userController() {
        userView.UserSRSFRAME4_ADDSHUTTLEBOOKING(this);
    }
    
    public void SRSFRAME5_VIEWSHUTTLEBOOKING_userController() {
        userView.UserSRSFRAME5_VIEWSHUTTLEBOOKING(this);
    }
    
    public void SRSFRAME6_EDITSHUTTLEBOOKING_userController() {
        userView.UserSRSFRAME6_EDITSHUTTLEBOOKING(this);
    }
    
    public void SRSFRAME7_REGULAR_userController() {
        userView.UserSRSFRAME7_REGULAR(this);
    }
    
    public void SRSFRAME8_PRESET_userController() {
        userView.UserSRSFRAME8_PRESET(this);
    }
    
    public void SRSFRAME9_IRREGULAR_userController() {
        userView.UserSRSFRAME9_IRREGULAR(this);
    }
    
    public void SRSFRAME10_EDITUSERDATA_userController() {
        userView.UserSRSFRAME10_EDITUSERDATA(this);
    }

    public void setShuttleBookingView(ShuttleBookingView selectedReservation) {
        this.selectedReservation = selectedReservation;
    }

    public ShuttleBookingView getShuttleBookingView() {
        return selectedReservation;
    }
}
