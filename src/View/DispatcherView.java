
import java.util.ArrayList;


public class DispatcherView {

    public void DispatcherViewSRSFRAME1_MENU(DLSU_SRSDispatcher_controller Dcontroller){
        new DispatcherSRSFRAME1_MENU(Dcontroller);
    }
    public void DispatcherViewSRSFRAME2_CheckReservation(DLSU_SRSDispatcher_controller Dcontroller, ArrayList<ShuttleBookingView> shuttleBookings ){
        new DispatcherSRSFRAME2_CheckReservation(Dcontroller, shuttleBookings);
    }
}
