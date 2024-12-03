
public class TrimesterSchedule {

    protected int trimesterID;
    protected int shuttleScheduleID;

    public TrimesterSchedule(int trimesterID, int shuttleScheduleID) {
        this.trimesterID = trimesterID;
        this.shuttleScheduleID = shuttleScheduleID;
    }

    public void setTrimesterID(int trimesterID) {
        this.trimesterID = trimesterID;
    }

    public void setShuttleScheduleID(int shuttleScheduleID) {
        this.shuttleScheduleID = shuttleScheduleID;
    }

    public int getTrimesterID() {
        return trimesterID;
    }

    public int getShuttleScheduleID() {
        return shuttleScheduleID;
    }

}
