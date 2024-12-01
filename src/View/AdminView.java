package src.View;

import java.util.ArrayList;
import src.Controller.DLSU_SRSAdmin_controller;
import src.Model.*;

public class AdminView {

    public void ViewAdminSRSFRAME1_ADMINMENU(DLSU_SRSAdmin_controller Acontroller) {
        new AdminSRSFRAME1_ADMINMENU(Acontroller);
    }

    public void ViewAdminSRSFRAME2_VERIFYREGISTRATIONS(DLSU_SRSAdmin_controller Acontroller) {
        //new AdminSRSFRAME2_VERIFYREGISTRATIONS(Acontroller);
    }   

    public void ViewAdminSRSFRAME3_VIEWRESERVATIONS(DLSU_SRSAdmin_controller Acontroller, ArrayList<ShuttleBookingView> reservations) {
        //new AdminSRSFRAME3_VIEWRESERVATIONS(Acontroller, reservations);
    }

    public void ViewAdminSRSFRAME4_VIEWSHUTTLEROUTES(DLSU_SRSAdmin_controller Acontroller) {
        new AdminSRSFRAME4_VIEWSHUTTLEROUTES(Acontroller);
    }    

    public void ViewAdminSRSFRAME5_VERIFYRESERVATIONS(DLSU_SRSAdmin_controller Acontroller, ArrayList<ShuttleBookingView> reservations) {
        new AdminSRSFRAME5_VERIFYRESERVATION(Acontroller, reservations);
    }

    public void ViewAdminSRSFRAME6_EDITADMINDATA(DLSU_SRSAdmin_controller Acontroller) {
        //new AdminSRSFRAME6_EDITADMINDATA(Acontroller);
    }

    public void ViewAdminSRSFRAME7_EDITUSERDATA(DLSU_SRSAdmin_controller Acontroller, int userId) {
        new AdminSRSFRAME7_EDITUSERDATA(Acontroller, userId);
    }

}
