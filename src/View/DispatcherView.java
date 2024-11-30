package src.View;

import java.util.ArrayList;
import src.Controller.DLSU_SRSDispatcher_controller;
import src.Model.ShuttleBookingView;

public class DispatcherView {

    public void DispatcherViewSRSFRAME1_MENU(DLSU_SRSDispatcher_controller Dcontroller){
        new DispatcherSRSFRAME1_MENU(Dcontroller);
    }
    public void DispatcherViewSRSFRAME2_CheckReservation(DLSU_SRSDispatcher_controller Dcontroller, ArrayList<ShuttleBookingView> shuttleBookings ){
        new DispatcherSRSFRAME2_CheckReservation(Dcontroller, shuttleBookings);
    }
}
