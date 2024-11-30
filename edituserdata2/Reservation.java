public class Reservation {
    private int bookingID;
    private boolean attendance;
    private int userID;
    private String destination;
    private String date;
    private String time;

    public Reservation(){

    }
    // Getters and setters
    public int getbookingID() {
        return bookingID;
    }

    public void setbookingID(int bookingID) {
        this.bookingID = bookingID;
    }
    public boolean getAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "attendance=" + attendance +
                ", userID=" + userID +
                ", destination='" + destination + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
