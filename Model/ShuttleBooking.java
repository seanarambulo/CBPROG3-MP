public class ShuttleBooking {

    private int shuttleBookingID;
    protected String ArrowsExpressLine;
    protected String Origin;
    protected String Destination;
    protected int lineNum;
    protected String date;
    protected String time;

    public void setShuttleBookingID(int shuttleBookingID){
        this.shuttleBookingID = shuttleBookingID;
    }

    public void setReservation(String ArrowsExpressLine){
        this.ArrowsExpressLine = ArrowsExpressLine;
    }

    public void setOrigin(String Origin){
        this.Origin = Origin;
    }

    public void setDestination(String Destination){
        this.Destination = Destination;
    }

    public void setLineNum(int lineNum){
        this.lineNum = lineNum;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setTime(String time){
        this.time = time;
    }

    public int getShuttleBookingID() {
        return shuttleBookingID;
    }

    public String getArrowsExpressLine() {
        return ArrowsExpressLine;
    }

    public String getOrigin() {
        return Origin;
    }

    public String getDestination() {
        return Destination;
    }

    public int getLineNum() {
        return lineNum;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }


}
