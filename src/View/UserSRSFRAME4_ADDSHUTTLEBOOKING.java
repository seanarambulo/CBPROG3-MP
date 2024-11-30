package src.View;

import java.awt.*;
import java.awt.event.ActionListener;
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
        setDesignationTitle("Add Shuttle Booking", 25, 0, 0, 0);
        SwingUtilities.invokeLater(() -> initComponets());
    }
    public void initComponets() {

        Dimension buttonSize = new Dimension(400, 70);

        innerPanel.setLayout(null);
        int panelWidth = innerPanel.getWidth();
        int xPosition = (panelWidth - buttonSize.width) / 2;

        configureButton(jButton1, "Regular Reservation", e -> {
            this.dispose();
            controller.SRSFRAME7_REGULAR_userController();
        }, xPosition, 100, buttonSize);
        configureButton(jButton2, "Preset Reservation", e -> {
            this.dispose();
            controller.SRSFRAME8_PRESET_userController();
        }, xPosition, 200, buttonSize);
        configureButton(jButton3, "Irregular Reservation", e -> {
            this.dispose();
            controller.SRSFRAME9_IRREGULAR_userController();
        }, xPosition, 300, buttonSize);

        // Ensure the layout is set properly
        setVisible(true);
    }

    private void configureButton(JButton button, String text, ActionListener action, int x, int y, Dimension size) {
        button.setText(text);
        button.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        button.setForeground(new Color(108, 194, 162));
        button.setPreferredSize(size);
        button.addActionListener(action);
        button.setBounds(x, y, size.width, size.height);
        innerPanel.add(button);
    }
}
