package src.Model;

public class ShuttleBookingView extends ShuttleBooking {
    
    protected String arrowsExpressLine;
    protected String time;

    public ShuttleBookingView(){

    }

    public ShuttleBookingView(int shuttleBookingID, String Origin, String Destination, String date, String arrowsExpressLine, String time){
        super(shuttleBookingID, Origin, Destination, date);
        this.arrowsExpressLine = arrowsExpressLine;
        this.time = time;
    }

    public void setArrowsExpressLine(String arrowsExpressLine) {
        this.arrowsExpressLine = arrowsExpressLine;
    }

    public String getArrowsExpressLine() {
        return arrowsExpressLine;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
