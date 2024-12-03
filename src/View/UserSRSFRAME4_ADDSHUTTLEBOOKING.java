
import java.awt.*;
import javax.swing.*;


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

    @Override
    public void initComponets() {

        Dimension buttonSize = new Dimension(400, 70);
        Font buttonFont = new Font("Helvetica Neue", Font.BOLD, 18);
        Color buttonColor = new Color(108, 194, 162);

        innerPanel.setLayout(null);
        int panelWidth = innerPanel.getWidth();
        int xPosition = (panelWidth - buttonSize.width) / 2;
        int yPosition = 100; // Starting y position
        int yOffset = 100; // Vertical space between buttons

        configureButton("Regular Reservation", buttonFont, buttonColor, xPosition, yPosition, buttonSize, e -> {
            this.dispose();
            controller.SRSFRAME7_REGULAR_userController();
        });
        yPosition+=yOffset;
        configureButton("Preset Reservation", buttonFont, buttonColor, xPosition, yPosition, buttonSize, e -> {
           
        });
        yPosition+=yOffset;
        configureButton("Irregular Reservation", buttonFont, buttonColor, xPosition, yPosition, buttonSize, e -> {
            this.dispose();
            controller.SRSFRAME9_IRREGULAR_userController();
        });
        

        createButton("BACK", (panelWidth - 150) / 2 , 380, 150, 30, e -> handleBackAction());

        // Ensure the layout is set properly
        setVisible(true);
    }

    private void handleBackAction() {
        this.dispose();
        controller.SRSFRAME3_USERINTERFACE_userController();
    }
}
