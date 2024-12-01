import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


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
    public void AdminMenu1Frame(){
        view.AdminMenu1Frame(this);
    }

    public void PickScheduleFrame(){
        view.PickScheduleFrame(this);
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


    public void updateAttendance(int shuttleBookingID) throws SQLException {
        dbManager.updateAttendance(shuttleBookingID);
    }

    public void VerifyRegistrationFrame() {
        try {
            view.VerifyRegistrationFrame(this, dbManager.getRegistration());
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

    
    
}
