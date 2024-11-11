import java.util.List;

public class UserManagement {
    protected String username;
    protected String password;
    protected String email;
    protected String name;
    protected String designation;
    protected String EAF;
    protected String idNumber;
    protected boolean isVerified;
    protected List<String> reservations;

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

    public void setEAF(String EAF) {
        this.EAF = EAF;
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

    public String getEAF() {
        return EAF;
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

