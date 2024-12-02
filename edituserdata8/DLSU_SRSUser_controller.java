import java.sql.SQLException;

public class DLSU_SRSUser_controller {

    protected User Model;
    protected DatabaseManager dbManager;
    protected UserView view = new UserView();
    public DLSU_SRSUser_controller(int username, String password){
        try {
            this.dbManager = new DatabaseManager();
            this.Model = dbManager.getUserByID(username, password);
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
    public void UserMenu1Frame(){
        view.UserMenu1Frame(this);
    }

    public void registrationFrame(){
        view.registrationFrame(this);
    }

    public void updateUserData(String username, String email, String password){
        try {
            dbManager.updateUserData(Model.getUserID(), username, email, password);
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    public void EditUserData(){
        view.EditUserData(this);
    }
    

}
