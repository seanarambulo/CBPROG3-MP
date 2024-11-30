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

    public void AdminEditUserData(int userId) {
        view.AdminEditUserData(this, userId); // Pass the user ID to the view
    }    

    public void AdminCheckReservation(String LineName, String date, String time){
       
    }
    
}
