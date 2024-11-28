package test;

import java.util.Scanner;
import javax.swing.SwingUtilities;
import src.Controller.*;
import src.View.*;

public class UserSRSFRAME_test {
    public static void main(String[] args) {
        DLSU_SRSUser_controller controller = new DLSU_SRSUser_controller();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Test Num: ");
        int UserFrameNum = sc.nextInt();

        switch (UserFrameNum) {
            case 1 -> SwingUtilities.invokeLater(() -> {
                new UserSRSFRAME1_REGISTRATION(controller);
            });
            case 2 -> SwingUtilities.invokeLater(() -> {
                new UserSRSFRAME2_VERIFY(controller);
            });
        }


    }
    
}
