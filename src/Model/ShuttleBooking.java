package src.Model;

public class ShuttleBooking {

    private int userID;
    private int shuttleBookingID;
    protected int arrowsExpressLinelineNum;
    protected int shuttleScheduleID;
    protected boolean attendance;
    protected String Origin;
    protected String Destination;
    protected String date;
    
    public void setUserID(int userID){
        this.userID = userID;
    }

    public void setShuttleBookingID(int shuttleBookingID){
        this.shuttleBookingID = shuttleBookingID;
    }

    public void setArrowsExpressLineNum(int arrowsExpressLineNum){
        this.arrowsExpressLinelineNum = arrowsExpressLineNum;
    }

    public void setShuttleScheduleID(int shuttleScheduleID){
        this.shuttleScheduleID = shuttleScheduleID;
    }
    
    public void setAttendance(boolean attendance){
        this.attendance = attendance;
    }

    public void setOrigin(String Origin){
        this.Origin = Origin;
    }

    public void setDestination(String Destination){
        this.Destination = Destination;
    }

    public void setDate(String date){
        this.date = date;
    }

    public int getUserID(){
        return userID;
    }

    public int getShuttleBookingID() {
        return shuttleBookingID;
    }

    public int getArrowsExpressLineNum() {
        return arrowsExpressLinelineNum;
    }

    public int getShuttleScheduleID() {
        return shuttleScheduleID;
    }

    public boolean getAttendance(){
        return attendance;
    }

    public String getOrigin() {
        return Origin;
    }

    public String getDestination() {
        return Destination;
    }

    public String getDate() {
        return date;
    }

}
