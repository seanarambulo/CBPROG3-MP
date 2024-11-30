import java.sql.SQLException;

public class DLSU_SRSUser_controller {

    protected User Model;
    protected DatabaseManager dbManager;
    protected UserView view = new UserView();
    public DLSU_SRSUser_controller() {
        try {
            this.dbManager = new DatabaseManager();
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
    
    

}
