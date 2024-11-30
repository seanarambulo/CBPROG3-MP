package src.View;

import java.util.ArrayList;

import src.Controller.DLSU_SRSDispatcher_controller;
import src.Model.ShuttleBookingView;

public class DispatcherView {

    public void DispatcherMenu1Frame(DLSU_SRSDispatcher_controller Dcontroller){
        new DispatcherMenu1Frame(Dcontroller);
    }
    public void DispatcherCheckReservation(DLSU_SRSDispatcher_controller Dcontroller, ArrayList<ShuttleBookingView> shuttleBookings ){
        new DispatcherCheckReservation(Dcontroller, shuttleBookings);
    }
}
