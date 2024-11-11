import java.util.List;

public class DLSU_SRSAdmin_controller {

    private Admin admin;

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void addShuttleRoute(String ArrowsExpressLine, int lineNum) {
        admin.addShuttleRoute(ArrowsExpressLine, lineNum);
    }

    public void editShuttleRoute(String ArrowsExpressLine, int lineNum) {
        admin.editShuttleRoute(ArrowsExpressLine, lineNum);
    }

    public void deleteShuttleRoute(String ArrowsExpressLine, int lineNum) {
        admin.deleteShuttleRoute(ArrowsExpressLine, lineNum);
    }

    public void modifyUserBooking(int userShuttleBookingID, String ArrowsExpressLine, int lineNum, String date, String time) {
        admin.modifyUserBooking(userShuttleBookingID, ArrowsExpressLine, lineNum, date, time);
    }

    public void cancelUserBooking(int userShuttleBookingID) {
        admin.cancelUserBooking(userShuttleBookingID);
    }

    public boolean verifyUserReservation(String eaf, String reason) {
        return admin.verifyUserReservation(eaf, reason);
    }

    public List<String> viewPassengerReservationData() {
        return admin.viewPassengerReservationData();
    }

    public Admin getAdmin() {
        return admin;
    }

}
