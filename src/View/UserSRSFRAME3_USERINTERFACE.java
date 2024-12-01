package src.View;

import java.awt.*;
import javax.swing.*;
import src.Controller.DLSU_SRSUser_controller;

public class UserSRSFRAME3_USERINTERFACE extends FrameBackground {
        
    private final JButton jButton1 = new JButton("Add Reservation");
    private final JButton jButton2 = new JButton("View Reservation");
    private final JButton jButton3 = new JButton("Edit Reservation");
    private final JButton jButton4 = new JButton("Edit User Data");
    private final JButton jButton5 = new JButton("Log Out");
    private final DLSU_SRSUser_controller controller;

    public UserSRSFRAME3_USERINTERFACE(DLSU_SRSUser_controller controller){
        super();
        this.controller = controller;
        setDesignationTitle("Welcome " + controller.getUserName_userController(), 15, 0, 0, 0);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    public void initComponets() {
        
        Dimension buttonSize = new Dimension(300, 50);
        Font buttonFont = new Font("Helvetica Neue", Font.BOLD, 18);
        Color buttonColor = new Color(108, 194, 162);

        innerPanel.setLayout(null);
        int panelWidth = innerPanel.getWidth();
        int xPosition = (panelWidth - buttonSize.width) / 2;
        int yPosition = 100; // Starting y position
        int yOffset = 60; // Vertical space between buttons
    
        configureButton("Add Reservation", buttonFont, buttonColor, xPosition, yPosition, buttonSize, e -> {
            try {
                this.dispose();
                controller.SRSFRAME4_ADDSHUTTLEBOOKING_userController();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    
        yPosition += yOffset;
        configureButton("View Reservation", buttonFont, buttonColor, xPosition, yPosition, buttonSize, e -> {
            try {
                this.dispose();
                controller.SRSFRAME5_VIEWSHUTTLEBOOKING_userController();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    
        yPosition += yOffset;
        configureButton("Edit Reservation", buttonFont, buttonColor, xPosition, yPosition, buttonSize, e -> {
            try {
                this.dispose();
                controller.SRSFRAME6_EDITSHUTTLEBOOKING_userController(this.controller);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    
        yPosition += yOffset;
        configureButton("Edit User Data", buttonFont, buttonColor, xPosition, yPosition, buttonSize, e -> {
            try {
                this.dispose();
                controller.SRSFRAME10_EDITUSERDATA_userController();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    
        yPosition += yOffset;
        configureButton("Log Out", buttonFont, buttonColor, xPosition, yPosition, buttonSize, e -> {
            try {
                this.dispose();
                controller.SRS_VIEW_userController();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    
        getContentPane().add(outerPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
