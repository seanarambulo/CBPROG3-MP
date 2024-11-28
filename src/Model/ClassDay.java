package src.Model;

public class ClassDay {
    protected int classDayID;
    protected String dayName;

    public void setClassDayID(int classDayID) {
        this.classDayID = classDayID;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public int getClassDayID() {
        return classDayID;
    }

    public String getDayName() {
        return dayName;
    }
}