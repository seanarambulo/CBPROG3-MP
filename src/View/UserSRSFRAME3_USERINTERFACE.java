package src.View;

import java.awt.*;
import javax.swing.*;
import src.Controller.DLSU_SRSUser_controller;

public class UserSRSFRAME3_USERINTERFACE extends FrameBackground {
        
    private final JButton jButton1 = new JButton("Add Reservation");
    private final JButton jButton2 = new JButton("View Reservation");
    private final JButton jButton3 = new JButton("Edit Reservation");
    private final JButton jButton4 = new JButton("Edit User Data");
    private final DLSU_SRSUser_controller controller;

    public UserSRSFRAME3_USERINTERFACE(DLSU_SRSUser_controller controller){
        super();
        this.controller = controller;
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    public void initComponets() {

        setDesignationTitle("Welcome " + controller.getUserName_userController());

        Dimension buttonSize = new Dimension(300, 50);

        jButton1.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        jButton1.setForeground(new Color(108, 194, 162));
        jButton1.setPreferredSize(buttonSize);
        jButton1.addActionListener(e -> {
            try {
                this.dispose();
                controller.SRSFRAME4_ADDSHUTTLEBOOKING_userController();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        innerGbc.gridy = 1;
        innerGbc.gridwidth = 2;
        innerPanel.add(jButton1, innerGbc);

        jButton2.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        jButton2.setForeground(new Color(108, 194, 162));
        jButton2.setPreferredSize(buttonSize);
        jButton2.addActionListener(e -> {
                try {
                    this.dispose();
                    controller.SRSFRAME5_VIEWSHUTTLEBOOKING_userController();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        );
        innerGbc.gridy = 2;
        innerGbc.gridwidth = 2;
        innerPanel.add(jButton2, innerGbc);

        jButton3.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        jButton3.setForeground(new Color(108, 194, 162));
        jButton3.setPreferredSize(buttonSize);
        jButton3.addActionListener(e -> {
                try {
                    this.dispose();
                    controller.SRSFRAME6_EDITSHUTTLEBOOKING_userController();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }      
        );
        innerGbc.gridy = 3;
        innerGbc.gridwidth = 2;
        innerPanel.add(jButton3, innerGbc);

        jButton4.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        jButton4.setForeground(new Color(108, 194, 162));
        jButton4.setPreferredSize(buttonSize);
        jButton4.addActionListener(e -> {
            try {
                this.dispose();
                controller.SRSFRAME10_EDITUSERDATA_userController();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        innerGbc.gridy = 4;
        innerGbc.gridwidth = 2;
        innerPanel.add(jButton4, innerGbc);

        getContentPane().add(outerPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
