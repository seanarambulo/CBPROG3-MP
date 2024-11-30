import java.sql.SQLException;


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


    public void AdminMenu1Frame(){
        view.AdminMenu1Frame(this);
    }

    public void adminUpdateUserData(String username, String email){
        try {
            dbManager.adminUpdateUserData(Model.getUserID(), username, email);
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    public void AdminEditUserData(){
        view.AdminEditUserData(this);
    }

    public void AdminCheckReservation(String LineName, String date, String time){
       
    }

    

    
}
