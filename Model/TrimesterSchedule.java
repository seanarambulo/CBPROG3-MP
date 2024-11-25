public class TrimesterSchedule {

    protected int trimesterScheduleID;
    protected int shuttleBookingID;

    public TrimesterSchedule(int trimesterScheduleID, int shuttleBookingID) {
        this.trimesterScheduleID = trimesterScheduleID;
        this.shuttleBookingID = shuttleBookingID;
    }

    public void setTrimesterScheduleID(int trimesterScheduleID) {
        this.trimesterScheduleID = trimesterScheduleID;
    }

    public void setShuttleBookingID(int shuttleBookingID) {
        this.shuttleBookingID = shuttleBookingID;
    }

    public int getTrimesterScheduleID() {
        return trimesterScheduleID;
    }

    public int getShuttleBookingID() {
        return shuttleBookingID;
    }
}
