import java.sql.SQLException;


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


    public void DispatcherMenu1Frame(){
        view.DispatcherMenu1Frame(this);
    }

    

    public void DispatcherCheckReservation(String LineName, String date, String time){
        try {
            view.DispatcherCheckReservation(this,dbManager.getReservations( LineName, date, time));
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
    }

    public void updateAttendance(int shuttleBookingID) throws SQLException {
        dbManager.updateAttendance(shuttleBookingID);
    }

    
}
