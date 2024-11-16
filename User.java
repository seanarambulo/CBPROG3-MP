
public class User {
    protected String username;
    protected String password;
    protected String email;
    protected String name;
    protected String designation;
    protected String idNumber;
    protected boolean isVerified;

    public User(String username, String password, String email, String name, String designation, String idNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.designation = designation;
        this.idNumber = idNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void userRegistration(){
        // Code for User Registration
    }

    public void profileManagement(){
        // Code for Profile Management
    }

    public void viewReservation(){
        // Code for Viewing Reservation
    }

    public void editReservation(){
        // Code for Editing Reservation
    }

}

