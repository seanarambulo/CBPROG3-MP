package src;

import javax.swing.SwingUtilities;

import src.Controller.DLSU_SRSUser_controller;
import src.View.SRS_LOGIN;

public class DLSU_SRS {
//database
    public static void main(String args[]){
    /*DLSU_SRSUser_controller ctr = new DLSU_SRSUser_controller();
        ctr.insertBooking(false,"paseo","laguna", "2024-12-23", 2, 12340006, 1, "pasado cutie", false);
*/
        
        SwingUtilities.invokeLater(() -> {
            new SRS_LOGIN();
        });
   
    }
}
