

public class ShuttleBookingDatabase extends ShuttleBooking {
    
    protected int arrowsExpressLineNum;
    protected int shuttleScheduleID;

    public void setArrowsExpressLineNum(int arrowsExpressLineNum) {
        this.arrowsExpressLineNum = arrowsExpressLineNum;
    }

    public void setShuttleScheduleID(int shuttleScheduleID) {
        this.shuttleScheduleID = shuttleScheduleID;
    }

    public int getArrowsExpressLineNum() {
        return arrowsExpressLineNum;
    }

    public int getShuttleScheduleID() {
        return shuttleScheduleID;
    }

}
