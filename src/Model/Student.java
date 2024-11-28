package src.Model;

public class Student extends User {

    protected int trimesterID;
    protected boolean isVerified;
    protected String EAF;
    protected int classDayID;
    
    public Student(){
        
    }

    public Student(int userID, String password, String email, String userName, int designation, int trimesterID, boolean isVerified, String EAF, int classDaysID){
        super(userID, password, email, userName, designation);
        this.trimesterID = trimesterID; 
        this.isVerified = isVerified;
        this.EAF = EAF;
        this.classDayID = classDaysID;
    }

    public void setTrimesterID(int trimesterID){
        this.trimesterID = trimesterID;
    }

    public void setIsVerified(boolean isVerified){
        this.isVerified = isVerified;
    }

    public void setEAF (String EAF) {
        this.EAF = EAF;
    }

    public void setClassDayID(int classDayID){
        this.classDayID = classDayID;
    }

    public int getTrimesterID(){
        return trimesterID;
    }

    public boolean getIsVerified(){
        return isVerified;
    }

    public String getEAF(){
        return EAF;
    }

    public int getClassDayID(){
        return classDayID;
    }

}
