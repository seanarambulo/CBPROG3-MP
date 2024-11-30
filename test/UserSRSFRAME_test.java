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
            case 3 -> SwingUtilities.invokeLater(() -> {
                new UserSRSFRAME3_USERINTERFACE(controller);
            });
            case 4 -> SwingUtilities.invokeLater(() -> {
                new UserSRSFRAME4_ADDSHUTTLEBOOKING(controller);
            });
            case 5 -> SwingUtilities.invokeLater(() -> {
                new UserSRSFRAME5_VIEWSHUTTLEBOOKING(controller);
            });
            case 6 -> SwingUtilities.invokeLater(() -> {
                new UserSRSFRAME6_EDITSHUTTLEBOOKING(controller);
            });
            case 7 -> SwingUtilities.invokeLater(() -> {
                new UserSRSFRAME7_REGULAR(controller);
            });
            case 8 -> SwingUtilities.invokeLater(() -> {
                new UserSRSFRAME8_PRESET(controller);
            });
            case 9 -> SwingUtilities.invokeLater(() -> {
                // new UserSRSFRAME9_IRREGULAR(controller);
            });
            case 10 -> SwingUtilities.invokeLater(() -> {
                // new UserSRSFRAME10_EDITUSERDATA(controller);
            });
            default -> System.out.println("Invalid Test Num");
        }

    }
    
}
