package src.Model;

public class Trimester {

    protected int trimesterID;
    protected String schoolyear;
    protected int termNumber;

    public Trimester(String schoolyear, int termNumber) {
        this.schoolyear = schoolyear;
        this.termNumber = termNumber;
    }

    public void setSchoolyear(String schoolyear) {
        this.schoolyear = schoolyear;
    }

    public void setTermNumber(int termNumber) {
        this.termNumber = termNumber;
    }

    public String getSchoolyear() {
        return schoolyear;
    }

    public int getTermNumber() {
        return termNumber;
    }


}
