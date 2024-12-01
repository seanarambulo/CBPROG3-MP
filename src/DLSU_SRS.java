package src;

import javax.swing.SwingUtilities;
import src.View.SRS_LOGIN;

public class DLSU_SRS {
//database
    public static void main(String args[]){

        SwingUtilities.invokeLater(() -> {
            new SRS_LOGIN();
        });
    }

}
