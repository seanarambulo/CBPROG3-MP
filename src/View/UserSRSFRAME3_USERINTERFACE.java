package src.View;

import java.awt.*;
import java.awt.event.ActionListener;
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

        initializeButton(jButton1, buttonFont, buttonColor, buttonSize, e -> {
            try {
                this.dispose();
                controller.SRSFRAME4_ADDSHUTTLEBOOKING_userController();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        initializeButton(jButton2, buttonFont, buttonColor, buttonSize, e -> {
            try {
                this.dispose();
                controller.SRSFRAME5_VIEWSHUTTLEBOOKING_userController();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        initializeButton(jButton3, buttonFont, buttonColor, buttonSize, e -> {
            try {
                this.dispose();
                controller.SRSFRAME6_EDITSHUTTLEBOOKING_userController();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        initializeButton(jButton4, buttonFont, buttonColor, buttonSize, e -> {
            try {
                this.dispose();
                controller.SRSFRAME10_EDITUSERDATA_userController();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        initializeButton(jButton5, buttonFont, buttonColor, buttonSize, e -> {
            try {
                this.dispose();
                controller.SRS_VIEW_userController();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        innerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); // Reduce top and bottom padding
        gbc.gridx = 0;
        gbc.gridy = 1; // Start from row 1 to shift buttons down
        gbc.anchor = GridBagConstraints.CENTER; // Center align buttons
        innerPanel.add(jButton1, gbc);

        gbc.gridy++;
        innerPanel.add(jButton2, gbc);

        gbc.gridy++;
        innerPanel.add(jButton3, gbc);

        gbc.gridy++;
        innerPanel.add(jButton4, gbc);

        gbc.gridy++;
        innerPanel.add(jButton5, gbc);

        getContentPane().add(outerPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void initializeButton(JButton button, Font font, Color color, Dimension size, ActionListener actionListener) {
        button.setFont(font);
        button.setForeground(color);
        button.setPreferredSize(size);
        button.setMinimumSize(size);
        button.setMaximumSize(size);
        button.setSize(size);
        button.addActionListener(actionListener);
    }
}
