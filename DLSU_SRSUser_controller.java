public class DLSU_SRSUser_controller {

    protected User user;
    protected ShuttleBooking shuttleBooking;

    public void setUser(User user) {
        this.user = user;
    }

    public void setShuttleBooking(ShuttleBooking shuttleBooking) {
        this.shuttleBooking = shuttleBooking;
    }

    public void setUsername(String username) {
        user.setUsername(username);
    }

    public void setPassword(String password) {
        user.setPassword(password);
    }

    public void setEmail(String email) {
        user.setEmail(email);
    }

    public void setName(String name) {
        user.setName(name);
    }

    public void setDesignation(String designation) {
        user.setDesignation(designation);
    }

    public void setIdNumber(String idNumber) {
        user.setIdNumber(idNumber);
    }

    public void setVerified(boolean verified) {
        user.setVerified(verified);
    }

    public void setEAF(String EAF) {
        ((Student)user).setEAF(EAF);
    }

    public void setReservation(int shuttleBookingID, String ArrowsExpressLine, int lineNum, String date, String time) {
        shuttleBooking.setShuttleBookingID(shuttleBookingID);
        shuttleBooking.setReservation(ArrowsExpressLine);
        shuttleBooking.setLineNum(lineNum);
        shuttleBooking.setDate(date);
        shuttleBooking.setTime(time);
    }

    public void setReservationPreset(int presetID, String ArrowsExpressLine, int lineNum, String date, String time) {
        ((ShuttleBookingPreset)shuttleBooking).setPresetID(presetID);
        shuttleBooking.setReservation(ArrowsExpressLine);
        shuttleBooking.setLineNum(lineNum);
        shuttleBooking.setDate(date);
        shuttleBooking.setTime(time);
    }

    /*public void register() {
        VIEW.registerv();
    }*/
}
