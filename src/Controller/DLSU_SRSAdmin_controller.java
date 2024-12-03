package src.Controller;

import java.sql.SQLException;
import java.util.ArrayList;

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
    public ArrayList<String> getTimesForLine(String LineName) {
        return dbManager.getTimesForLine(LineName);
    }
    public void updateIrregAttendance(int shuttleBookingID) throws SQLException {
        dbManager.updateIrregAttendance(shuttleBookingID);
    }

    public void updateAttendance(int shuttleBookingID) throws SQLException {
        dbManager.updateAttendance(shuttleBookingID);
    }

    public void AdminCheckReservation(String LineName, String date, String time){
        try {
            view.AdminCheckReservation(this,dbManager.getReservations(LineName, date, time));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void VerifyReservationFrame() {
        view.ViewAdminSRSFRAME3_VIEWRESERVATIONS(this);
    }

    

    public void adminUpdateUserData(int userID, String username, String email) {
        try {
            dbManager.adminUpdateUserData(userID, username, email);
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

    public boolean checkIfUserExists(int userID) throws SQLException{
        try {
            return dbManager.checkIfUserExists(userID);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }// or any default value you prefer
    }

    public void AdminSRSFRAME1_Menu_AdminController(){
        view.ViewAdminSRSFRAME1_ADMINMENU(this);
    }

    public void AdminSRSFRAME2_VERIFYREGISTRATIONS_adminController() throws SQLException {
        view.ViewAdminSRSFRAME2_VERIFYREGISTRATIONS(this, dbManager.getRegistration());
    }
    public void ADMINSRSFRAME_VIEWSHUTTLEROUTES(String lineName){
       
            view.ADMINSRSFRAME_VIEWSHUTTLEROUTES(this, dbManager.getTimesForLine(lineName));
        
    }
    public void AdminSRSFRAME3_VIEWRESERVATIONS_adminController(){
        view.ViewAdminSRSFRAME3_VIEWRESERVATIONS(this);
    }
    public void deleteLineTime(String lineName, String time){
        try {
            dbManager.deleteLineTime(lineName, time);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean checkTimeExists(String time){

            return dbManager.checkTimeExists(time);
       
    }
    public void insertIntoTime(String time){
        
            try {
                dbManager.insertIntoTime(time);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        
    }
    public void insertLineTime(String lineName, String time){
        
            dbManager.insertLineTime(lineName, time);
        
    }
    public void AdminSRSFRAME5_VERIFYRESERVATION_adminController() throws SQLException{
        view.ViewAdminSRSFRAME5_VERIFYRESERVATIONS(this, dbManager.getIrregularReservations());
    }

    public void AdminSRSFRAME6_EDITUSERDATA_adminController(int userID){
        view.ViewAdminSRSFRAME6_EDITUSERDATA(this, userID);
    }

}
