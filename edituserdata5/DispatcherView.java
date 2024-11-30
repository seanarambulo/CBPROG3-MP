import java.util.ArrayList;

public class DispatcherView {

    public void DispatcherMenu1Frame(DLSU_SRSDispatcher_controller Dcontroller){
        new DispatcherMenu1Frame(Dcontroller);
    }
    public void DispatcherCheckReservation(DLSU_SRSDispatcher_controller Dcontroller,ArrayList<Reservation> reservations){
        new DispatcherCheckReservation(Dcontroller,reservations);
    }
}
