import java.util.List;

public class Admin {

    protected String adminID;
    protected String password;

    // set adminID
    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    // set setPassword
    public void setPassword(String password) {
        this.password = password;
    }

    // get password
    public String getPassword() {
        return password;
    }

    // get adminID
    public String getAdminID() {
        return adminID;
    }
    
    // Shuttle and Schedule Management
    public void addShuttleRoute(String routeName, String schedule, String driver) {
        // Implementation to add a shuttle route
    }

    public void editShuttleRoute(int routeId, String newRouteName, String newSchedule, String newDriver) {
        // Implementation to edit a shuttle route
    }

    public void deleteShuttleRoute(int routeId) {
        // Implementation to delete a shuttle route
    }

    public void modifyUserBooking(int bookingId, String newDetails) {
        // Implementation to modify a user booking
    }

    public void cancelUserBooking(int bookingId) {
        // Implementation to cancel a user booking
    }

    public boolean verifyUserReservation(String eaf, String reason) {
        // Implementation to verify a user's reservation based on their EAF or reason
        return true; // Simplified return value
    }

    // View Passenger Reservation Data
    public List<String> viewPassengerReservationData() {
        // Implementation to access and manage passenger reservation information
        return null; // Simplified return value
    }

    public void doSomething(){
        System.out.println("Git Success");
    }

}
