
public class User {
    
    protected int userID;
    protected String password;
    protected String email;
    protected String userName;
    protected int designationID;

    public User(){
        
    }

    public User(int userID, String password, String email, String userName, int designation) {
        this.userID = userID;
        this.password = password;
        this.email = email;
        this.userName = userName;
        this.designationID = designation;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDesignationID(int designationID) {
        this.designationID = designationID;
    }

    public int getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public int getDesignationID() {
        return designationID;
    }


}

