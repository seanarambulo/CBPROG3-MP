package src.Controller;

import src.Model.*;
import src.View.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class DLSU_SRSDispatcher_controller {

    protected User Model = null;
    protected DatabaseManager dbManager;
    protected DispatcherView view = new DispatcherView();

    public DLSU_SRSDispatcher_controller(int userID, String password) {
        try {
            this.dbManager = new DatabaseManager();
            this.Model = dbManager.getUserByID(userID, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public void DispatcherMenu1Frame_Menu_DispatcherController(){
        view.DispatcherViewSRSFRAME1_MENU(this);
    }

    public void DispatcherViewSRSFRAME2_CheckReservation_DispatchController(String LineName, String date, String time){
        try {
            view.DispatcherViewSRSFRAME2_CheckReservation(this,dbManager.getReservations( LineName, date, time));
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
    }

    public ArrayList<String> getTimesForLine(String LineName) {
        return dbManager.getTimesForLine(LineName);
    }
    
    public void updateAttendance(int shuttleBookingID) throws SQLException {
        dbManager.updateAttendance(shuttleBookingID);
    }
}
