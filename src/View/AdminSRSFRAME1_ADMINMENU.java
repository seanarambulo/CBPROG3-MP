package src.View;

import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import src.Controller.DLSU_SRSAdmin_controller;

public class AdminSRSFRAME1_ADMINMENU extends FrameBackground {

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private DLSU_SRSAdmin_controller Acontroller;

    public AdminSRSFRAME1_ADMINMENU(DLSU_SRSAdmin_controller Acontroller) {
        super();
        this.Acontroller = Acontroller;
        setDesignationTitle("Admin Menu", 10, 0, 0, 0);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    protected void initComponets() {
        
        innerPanel.setLayout(null);
        int buttonWidth = 320;
        int buttonHeight = 50;
        int buttonX = (innerPanel.getWidth() - buttonWidth) / 2;
        int buttonY = 67;

        // Button 1
        jButton1 = configureButton("Verify Registrations", new Font("Helvetica Neue", Font.BOLD, 14), new Color(108, 194, 162), buttonX, buttonY, new Dimension(buttonWidth, buttonHeight), e -> {
            try {
                Acontroller.AdminSRSFRAME2_VERIFYREGISTRATIONS_adminController();
            } catch (SQLException ex) {
                Logger.getLogger(AdminSRSFRAME1_ADMINMENU.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "An error occurred while verifying registrations.", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });
        innerPanel.add(jButton1);

        // Button 2
        jButton2 = configureButton("View Reservations", new Font("Helvetica Neue", Font.BOLD, 14), new Color(108, 194, 162), buttonX, buttonY + 60, new Dimension(buttonWidth, buttonHeight), e -> {
            Acontroller.AdminSRSFRAME3_VIEWRESERVATIONS_adminController();
        });
        innerPanel.add(jButton2);

        // Button 3
        jButton3 = configureButton("View Shuttle Routes", new Font("Helvetica Neue", Font.BOLD, 14), new Color(108, 194, 162), buttonX, buttonY + 120, new Dimension(buttonWidth, buttonHeight), e -> {
            Acontroller.AdminSRSFRAME4_VIEWSHUTTLEROUTES_adminController();
        });
        innerPanel.add(jButton3);

        // Button 4
        jButton4 = configureButton("Verify Reservations", new Font("Helvetica Neue", Font.BOLD, 14), new Color(108, 194, 162), buttonX, buttonY + 180, new Dimension(buttonWidth, buttonHeight), e -> {
            try {
                Acontroller.AdminSRSFRAME5_VERIFYRESERVATION_adminController();
            } catch (SQLException ex) {
                Logger.getLogger(AdminSRSFRAME1_ADMINMENU.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "An error occurred while verifying reservations.", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });
        innerPanel.add(jButton4);

        // Button 6 (New "Edit User Data" button)
        jButton6 = configureButton("Edit User Data", new Font("Helvetica Neue", Font.BOLD, 14), new Color(108, 194, 162), buttonX, buttonY + 240, new Dimension(buttonWidth, buttonHeight), e -> {
            String userId = JOptionPane.showInputDialog(this, "Enter User ID:", "Edit User Data", JOptionPane.PLAIN_MESSAGE);
            if (userId != null && !userId.isEmpty()) {
                try {
                    int userIdInt = Integer.parseInt(userId);
                    boolean userExists = Acontroller.checkIfUserExists(userIdInt);

                    if (userExists) {
                        JOptionPane.showMessageDialog(this, "User ID entered: " + userIdInt, "User ID Confirmation", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        Acontroller.AdminSRSFRAME6_EDITUSERDATA_adminController(userIdInt);
                    } else {
                        JOptionPane.showMessageDialog(this, "User ID not found in the database.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid User ID. Please enter a valid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "An error occurred while accessing the database.", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "No User ID entered.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        innerPanel.add(jButton6);
    }
}
