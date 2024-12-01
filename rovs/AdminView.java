
import java.util.ArrayList;

public class AdminView {

    public void AdminMenu1Frame(DLSU_SRSAdmin_controller Acontroller) {
        new AdminMenu1Frame(Acontroller);
    }

    public void AdminCheckReservation(DLSU_SRSAdmin_controller Acontroller, ArrayList<Reservation> reservations){
        new AdminCheckReservation(Acontroller, reservations);
    }
    

    public void PickScheduleFrame(DLSU_SRSAdmin_controller Acontroller){
        new PickScheduleFrame(Acontroller);
    }

    public void VerifyReservationFrame(DLSU_SRSAdmin_controller Acontroller, ArrayList<IrregReservation> reservations) {
        new VerifyReservationFrame(Acontroller, reservations);
    }

    public void VerifyRegistrationFrame(DLSU_SRSAdmin_controller dlsu_SRSAdmin_controller, ArrayList<Student> students) {
        new VerifyRegistrationFrame(dlsu_SRSAdmin_controller,students);
    }

    

    
}
