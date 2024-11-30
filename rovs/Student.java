public class Student extends User {
    private int trimester;
    private String eaf;
    private boolean isVerified;
    private int classDaysID;

    // Getters and Setters
    public int getTrimester() {
        return trimester;
    }

    public void setTrimester(int trimester) {
        this.trimester = trimester;
    }

    public String getEaf() {
        return eaf;
    }

    public void setEaf(String eaf) {
        this.eaf = eaf;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public int getClassDaysID() {
        return classDaysID;
    }

    public void setClassDaysID(int classDaysID) {
        this.classDaysID = classDaysID;
    }

    @Override
    public String toString() {
        return super.toString() + // Reuse User's toString method
               ", Student{" +
               "trimester=" + trimester +
               ", eaf='" + eaf + '\'' +
               ", isVerified=" + isVerified +
               ", classDaysID=" + classDaysID +
               '}';
    }
}
