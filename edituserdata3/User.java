public class User {
    private int userID;
    private String userName;
    private String password;
    private String email;
    private int designationID;

    // Getters and Setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDesignationID() {
        return designationID;
    }

    public void setDesignationID(int designationID) {
        this.designationID = designationID;
    }

    @Override
    public String toString() {
        return "User{" +
               "userID=" + userID +
               ", userName='" + userName + '\'' +
               ", email='" + email + '\'' +
               ", designationID=" + designationID +
               '}';
    }
}
