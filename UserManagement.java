public class UserManagement {
    protected String username;
    protected String password;
    protected String email;
    protected String name;
    protected String designation;
    protected String eaf;
    protected String idNumber;
    protected boolean isVerified;

    // User Registration
    public void createUserAccount(String username, String password, String email);
    public boolean verifyUserAccount(String username, String verificationCode);

    // Profile Management
    public void updateUserDetails(String username, String name, String password, String designation, String eaf, String idNumber, String email);

    // Edit Reservation
    public void createReservation(String username, String reservationDetails);
    public void modifyReservation(String reservationId, String newDetails);
    public void cancelReservation(String reservationId);

    // View Reservation
    public String viewCurrentReservations(String username);
    public String viewPastReservations(String username);
}
