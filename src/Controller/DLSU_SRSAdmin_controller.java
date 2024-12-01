package src.Controller;

import java.util.ArrayList;
import java.sql.SQLException;
import src.Model.*;
import src.View.*;

public class DLSU_SRSAdmin_controller {

    protected User Model = null;
    protected DatabaseManager dbManager;
    protected AdminView view = new AdminView();

    public DLSU_SRSAdmin_controller(int userID, String password) {
        try {
            this.dbManager = new DatabaseManager();
            this.Model = dbManager.getUserByID(userID, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public void updateIrregAttendance(int shuttleBookingID) throws SQLException {
        dbManager.updateIrregAttendance(shuttleBookingID);
    }

    public boolean checkIfUserExists(int userId) throws SQLException {
        try {
            // Now check if the user exists using the parsed ID
            return dbManager.checkIfUserExists(userId); // Assuming checkIfUserExists is a method in your DatabaseManager
        } catch (NumberFormatException ex) {
            // If user ID is not a valid integer, return false
            return false;
        }
    }

    public void adminUpdateUserData(int userId, String username, String email) {
        try {
            dbManager.adminUpdateUserData(userId, username, email); // Use the passed user ID
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AdminCheckReservation(String LineName, String date, String time){
        try {
            view.AdminCheckReservation(this,dbManager.getReservations( LineName, date, time));
        } catch (SQLException e) {
            e.printStackTrace();
        }   
    }

    public void VerifyReservationFrame() {
        try {
            view.VerifyReservationFrame(this, dbManager.getIrregularReservations());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateVerification(int userID) {
        try {
            dbManager.updateVerification(userID);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void updateAttendance(int shuttleBookingID) throws SQLException {
        dbManager.updateAttendance(shuttleBookingID);
    }

    public void AdminSRSFRAME1_Menu_AdminController(){
        view.ViewAdminSRSFRAME1_ADMINMENU(this);
    }

    public void AdminSRSFRAME2_VERIFYREGISTRATIONS_adminController(){
        view.ViewAdminSRSFRAME2_VERIFYREGISTRATIONS(this);
    }

    public void AdminSRSFRAME3_VIEWRESERVATIONS_adminController(ArrayList<ShuttleBookingView> reservations){
        view.ViewAdminSRSFRAME3_VIEWRESERVATIONS(this, reservations);
    }

    public void AdminSRSFRAME4_VIEWSHUTTLEROUTES_adminController(){ 
        view.ViewAdminSRSFRAME4_VIEWSHUTTLEROUTES(this);   
    }

    public void AdminSRSFRAME5_VERIFYRESERVATION_adminController(ArrayList<ShuttleBookingView> reservations){
        view.ViewAdminSRSFRAME5_VERIFYRESERVATIONS(this, reservations);
    }

    public void AdminSRSFRAME6_EDITADMINDATA_adminController(){
        view.ViewAdminSRSFRAME6_EDITADMINDATA(this);
    }

    public void AdminSRSFRAME7_EDITUSERDATA_adminController(int userID){
        view.ViewAdminSRSFRAME7_EDITUSERDATA(this, userID);
    }

}
