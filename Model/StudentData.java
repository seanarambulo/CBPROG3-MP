public class StudentData {
    protected int studentDataID;
    protected int trimesterID;
    protected int idNumber;
    protected String EAF;
    protected int classDays;

    public StudentData(int studentDataID){
        this.studentDataID = studentDataID;
    }

    public void setTrimesterID(int trimesterID){
        this.trimesterID = trimesterID;
    }

    public void setIdNumber(int idNumber){
        this.idNumber = idNumber;
    }

    public void setEAF (String EAF) {
        this.EAF = EAF;
    }

    public int getTrimesterID(){
        return this.trimesterID;
    }

    public int getIdNumber(){
        return this.idNumber;
    }

    public String getEAF(){
        return this.EAF;
    }

    public void setClassDays(int classDays){
        this.classDays = classDays;
    }

    public int getClassDays(){
        return this.classDays;
    }
    
}
