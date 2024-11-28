package src.View;

import java.awt.*;
import javax.swing.*;
import src.Controller.DLSU_SRSUser_controller;

public class UserSRSFRAME4_ADDSHUTTLEBOOKING extends FrameBackground{
    
    private final JButton jButton1 = new JButton("Regular Reservation");
    private final JButton jButton2 = new JButton("Preset Reservation");
    private final JButton jButton3 = new JButton("Irregular Reservation");
    private final DLSU_SRSUser_controller controller;

    public UserSRSFRAME4_ADDSHUTTLEBOOKING(DLSU_SRSUser_controller controller){
        super();
        this.controller = controller;
        SwingUtilities.invokeLater(() -> initComponets());
    }
    public void initComponets() {

        Dimension buttonSize = new Dimension(300, 50);

        jButton1.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        jButton1.setForeground(new Color(108, 194, 162));
        jButton1.setPreferredSize(buttonSize);
        jButton1.addActionListener(e -> controller.SRSFRAME7_REGULAR_userController());
        innerGbc.gridy = 1;
        innerGbc.gridwidth = 2;
        innerPanel.add(jButton1, innerGbc);

        
        jButton2.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        jButton2.setForeground(new Color(108, 194, 162));
        jButton2.setPreferredSize(buttonSize);
        jButton2.addActionListener(e -> controller.SRSFRAME8_PRESET_userController());
        innerGbc.gridy = 2;
        innerGbc.gridwidth = 2;
        innerPanel.add(jButton2, innerGbc);

        jButton3.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        jButton3.setForeground(new Color(108, 194, 162));
        jButton3.setPreferredSize(buttonSize);
        jButton3.addActionListener(e -> controller.SRSFRAME9_IRREGULAR_userController());
        innerGbc.gridy = 3;
        innerGbc.gridwidth = 2;
        innerPanel.add(jButton3, innerGbc);

        getContentPane().add(outerPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
