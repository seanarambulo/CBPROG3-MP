package src.View;

import java.util.ArrayList;
import src.Controller.DLSU_SRSAdmin_controller;
import src.Model.*;

public class AdminView {

    public void ViewAdminSRSFRAME1_ADMINMENU(DLSU_SRSAdmin_controller Acontroller) {
        new AdminSRSFRAME1_ADMINMENU(Acontroller);
    }

    public void ViewAdminSRSFRAME2_VERIFYREGISTRATIONS(DLSU_SRSAdmin_controller Acontroller, ArrayList<ShuttleBookingView> reservations) {
        new AdminSRSFRAME2_VERIFYREGISTRATIONS(Acontroller, reservations);
    }   

    public void ViewAdminSRSFRAME3_VIEWRESERVATIONS(DLSU_SRSAdmin_controller Acontroller) {
        new AdminSRSFRAME3_VIEWRESERVATIONS(Acontroller);
    }

    public void ViewAdminSRSFRAME4_VIEWSHUTTLEROUTES(DLSU_SRSAdmin_controller Acontroller) {
        new AdminSRSFRAME4_VIEWSHUTTLEROUTES(Acontroller);
    }    

    public void ViewAdminSRSFRAME5_VERIFYRESERVATIONS(DLSU_SRSAdmin_controller Acontroller, ArrayList<Student> students) {
        new AdminSRSFRAME5_VERIFYRESERVATION(Acontroller, students);
    }

    public void ViewAdminSRSFRAME6_EDITUSERDATA(DLSU_SRSAdmin_controller Acontroller, int userId) {
        new AdminSRSFRAME6_EDITUSERDATA(Acontroller, userId);
    }

    public void AdminCheckReservation(DLSU_SRSAdmin_controller Acontroller, ArrayList<ShuttleBookingView> reservations) {
        new AdminCheckReservation(Acontroller, reservations);
    }

}
