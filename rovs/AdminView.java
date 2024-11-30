
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
}
