package src.Model;

public class ShuttleBooking {

    private int userID;
    private int shuttleBookingID;
    protected boolean attendance;
    protected String Origin;
    protected String Destination;
    protected String date;
    
    public ShuttleBooking(){
        
    }

    public ShuttleBooking(int shuttleBookingID, String Origin, String Destination, String date){
        this.shuttleBookingID = shuttleBookingID;
        this.Origin = Origin;
        this.Destination = Destination;
        this.date = date;
    }

    public void setUserID(int userID){
        this.userID = userID;
    }
    
    public void setShuttleBookingID(int shuttleBookingID){
        this.shuttleBookingID = shuttleBookingID;
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

    public int getShuttleBookingID(){
        return shuttleBookingID;
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
