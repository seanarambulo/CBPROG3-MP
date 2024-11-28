package src.Model;

public class ShuttleTrip {
    private int shuttleBookingID;
    private int TripNum;
    
    public void setShuttleBookingID(int shuttleBookingID) {
        this.shuttleBookingID = shuttleBookingID;
    }

    public void setTripNum(int TripNum) {
        this.TripNum = TripNum;
    }

    public int getShuttleBookingID() {
        return shuttleBookingID;
    }

    public int getTripNum() {
        return TripNum;
    }
}
