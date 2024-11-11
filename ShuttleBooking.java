public class ShuttleBooking {
    protected int presetID;
    protected String ArrowsExpressLine;
    protected int lineNum;
    protected String date;
    protected String time;

    public void setReservation(String ArrowsExpressLine, int lineNum, String date, String time) {
        this.ArrowsExpressLine = ArrowsExpressLine;
        this.lineNum = lineNum;
        this.date = date;
        this.time = time;
    }

    public void setReservationPreset(String ArrowsExpressLine, int lineNum, String date, String time, int presetID) {
        this.presetID = presetID;
        this.ArrowsExpressLine = ArrowsExpressLine;
        this.lineNum = lineNum;
        this.date = date;
        this.time = time;
    }

    public String getArrowsExpressLine() {
        return ArrowsExpressLine;
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
