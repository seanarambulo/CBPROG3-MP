package src.View;

import java.util.ArrayList;

import src.Controller.DLSU_SRSUser_controller;
import src.Model.IrregReservation;
import src.Model.ShuttleBookingView;

public class UserView {
   
    public void SRS_LOGIN(){
        new SRS_LOGIN();
    }

    public void UserSRSFRAME1_REGISTRATION(DLSU_SRSUser_controller controller){
        new UserSRSFRAME1_REGISTRATION(controller);
    }

    public void UserSRSFRAME2_VERIFY ( int studentID){
        new UserSRSFRAME2_VERIFY( studentID);
    }

    public void UserSRSFRAME3_USERINTERFACE(DLSU_SRSUser_controller controller){
        new UserSRSFRAME3_USERINTERFACE(controller);
    }

    public void UserSRSFRAME4_ADDSHUTTLEBOOKING(DLSU_SRSUser_controller controller){
        new UserSRSFRAME4_ADDSHUTTLEBOOKING(controller);
    }

    public void UserSRSFRAME5_VIEWSHUTTLEBOOKING(DLSU_SRSUser_controller controller,ArrayList<ShuttleBookingView> shuttleBookings){
        new UserSRSFRAME5_VIEWSHUTTLEBOOKING(controller,shuttleBookings);
    }
    
    public void UserSRSFRAME6_EDITSHUTTLEBOOKING(DLSU_SRSUser_controller controller){
        new UserSRSFRAME6_EDITSHUTTLEBOOKING(controller);
    }

    public void UserSRSFRAME7_REGULAR(DLSU_SRSUser_controller controller){
        new UserSRSFRAME7_REGULAR(controller);
    }
    public void UserSRSFRAME8_REGULAR(DLSU_SRSUser_controller controller, ShuttleBookingView booking){
        new UserSRSFRAME8_REGULAR(controller,booking);
    }
    public void UserSRSFRAME8_IRREGULAR(DLSU_SRSUser_controller controller, IrregReservation booking){
        new UserSRSFRAME8_IRREGULAR(controller,booking);
    }
  

    public void UserSRSFRAME9_IRREGULAR(DLSU_SRSUser_controller controller){
        new UserSRSFRAME9_IRREGULAR(controller);
    }

    public void UserSRSFRAME11_EDITUSERDATA(DLSU_SRSUser_controller controller){
        new EditUserData(controller);
    }
}

