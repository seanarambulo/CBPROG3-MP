package src.Controller;

import src.Model.*;
import src.View.*;
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

    public int getUserID() {
       return Model.getUserID();
    }




    public void DispatcherMenu1Frame(){
        view.DispatcherMenu1Frame(this);
    }

    

    public void DispatcherCheckReservation(){
        view.DispatcherCheckReservation(this);
    }
}
