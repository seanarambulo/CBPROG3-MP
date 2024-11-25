public class Student extends User {
    protected int studentDataID;

    public Student(String username, String password, String email, String name, String designation, String idNumber, int studentDataID) {
        super(username, password, email, name, designation, idNumber);
        this.studentDataID = studentDataID;
    }

    public void setStudentDataID(int studentDataID) {
        this.studentDataID = studentDataID;
    }

    public int getStudentDataID() {
        return studentDataID;
    }

    public void fetchStudentData() {
        StudentData studentData = new StudentData(studentDataID);
    }
}
