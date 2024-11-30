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
        setDesignationTitle("Add Shuttle Booking", 25, 0, 0, 0);
        SwingUtilities.invokeLater(() -> initComponets());
    }
    public void initComponets() {

        Dimension buttonSize = new Dimension(400, 70);
        Font buttonFont = new Font("Helvetica Neue", Font.BOLD, 18);
        Color buttonColor = new Color(108, 194, 162);

        innerPanel.setLayout(null);
        int panelWidth = innerPanel.getWidth();
        int xPosition = (panelWidth - buttonSize.width) / 2;

        configureButton("Regular Reservation", buttonFont, buttonColor, xPosition, 100, buttonSize, e -> {
            this.dispose();
            controller.SRSFRAME7_REGULAR_userController();
        });
        configureButton("Preset Reservation", buttonFont, buttonColor, xPosition, 200, buttonSize, e -> {
            this.dispose();
            controller.SRSFRAME8_PRESET_userController();
        });
        configureButton("Irregular Reservation", buttonFont, buttonColor, xPosition, 300, buttonSize, e -> {
            this.dispose();
            controller.SRSFRAME9_IRREGULAR_userController();
        });

        // Ensure the layout is set properly
        setVisible(true);
    }

}
