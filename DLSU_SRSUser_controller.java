public class DLSU_SRSUser_controller {

    protected User Model;
    protected UserView VIEW;
    protected ShuttleBooking shuttleBooking;

    public void setUser(User Model) {
        this.Model = Model;
    }

    public void setShuttleBooking(ShuttleBooking shuttleBooking) {
        this.shuttleBooking = shuttleBooking;
    }

    public void setUsername(String username) {
        Model.setUsername(username);
    }

    public void setPassword(String password) {
        Model.setPassword(password);
    }

    public void setEmail(String email) {
        Model.setEmail(email);
    }

    public void setName(String name) {
        Model.setName(name);
    }

    public void setDesignation(String designation) {
        Model.setDesignation(designation);
    }

    public void setIdNumber(String idNumber) {
        Model.setIdNumber(idNumber);
    }

    public void setVerified(boolean verified) {
        Model.setVerified(verified);
    }

    public void setStudentDataID(int studentDataID) {
        ((Student)Model).setStudentDataID(studentDataID);
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

    public void viewLogIn(){
        VIEW.SRSFRAME1();
    }

    /*public void register() {
        VIEW.registerv();
    }*/
}
