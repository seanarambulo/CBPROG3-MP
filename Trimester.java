public class Trimester {
    protected int trimesterID;
    protected String schoolyear;
    protected int termNumber;

    public void settrimesterID(int trimesterID) {
        this.trimesterID = trimesterID;
    }

    public void setSchoolyear(String schoolyear) {
        this.schoolyear = schoolyear;
    }

    public void setTermNumber(int termNumber) {
        this.termNumber = termNumber;
    }

    public int getTrimesterID() {
        return trimesterID;
    }

    public String getSchoolyear() {
        return schoolyear;
    }

    public int getTermNumber() {
        return termNumber;
    }


}
