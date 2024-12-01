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
        try {
            //view.ViewAdminSRSFRAME2_VERIFYREGISTRATIONS(this, dbManager.getIrregularReservations());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void VerifyRegistrationFrame() {
        try {
            view.ViewAdminSRSFRAME2_VERIFYREGISTRATIONS(this, dbManager.getRegistration());
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void AdminSRSFRAME3_VIEWRESERVATIONS_adminController(){
        view.ViewAdminSRSFRAME3_VIEWRESERVATIONS(this);
    }

    public void AdminSRSFRAME4_VIEWSHUTTLEROUTES_adminController(){ 
        view.ViewAdminSRSFRAME4_VIEWSHUTTLEROUTES(this);   
    }

    public void AdminSRSFRAME5_VERIFYRESERVATION_adminController() throws SQLException{
        view.ViewAdminSRSFRAME5_VERIFYRESERVATION(this, dbManager.getIrregularReservations());
    }

    public void AdminSRSFRAME6_EDITADMINDATA_adminController(){
        view.ViewAdminSRSFRAME6_EDITADMINDATA(this);
    }

    public void AdminSRSFRAME7_EDITUSERDATA_adminController(int userID){
        view.ViewAdminSRSFRAME7_EDITUSERDATA(this, userID);
    }

}
