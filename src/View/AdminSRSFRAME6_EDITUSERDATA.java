
import java.awt.*;
import javax.swing.*;


public class AdminSRSFRAME6_EDITUSERDATA extends FrameBackground {

    private JTextField EmailTF;
    private JTextField UsernameTF;
    private JLabel EmailLabel;
    private JLabel UsernameLabel;
    private JButton UpdateButton;
    private JButton BackButton;

    private DLSU_SRSAdmin_controller controller;
    private int userID;

    public AdminSRSFRAME6_EDITUSERDATA(DLSU_SRSAdmin_controller controller, int userID) {
        this.controller = controller;
        this.userID = userID;
        setDesignationTitle("Edit User Data", 20, 0, 0, 0);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    protected void initComponets() {
        
        innerPanel.setLayout(null);
        int panelWidth = innerPanel.getWidth();
        
        // Email Label and TextField
        EmailLabel = createLabel("Email:", (panelWidth - 200) / 2, 100, new Dimension(200, 30), new Font("Helvetica Neue", Font.PLAIN, 20), Color.WHITE);
        EmailTF = createTextField((panelWidth - 200) / 2, 150, 200, 30);

        // Username Label and TextField
        UsernameLabel = createLabel("Username:", (panelWidth - 200) / 2, 200, new Dimension(200, 30), new Font("Helvetica Neue", Font.PLAIN, 20), Color.WHITE);
        UsernameTF = createTextField((panelWidth - 200) / 2, 250, 200, 30);

        // Back Button
        BackButton = configureButton("Back", new Font("Helvetica Neue", Font.PLAIN, 20), Color.BLACK, (panelWidth - 200) / 2, 300, new Dimension(100, 30), e -> {
            this.dispose();
            controller.AdminSRSFRAME1_Menu_AdminController();
        });

        // Update Button
        UpdateButton = configureButton("Update", new Font("Helvetica Neue", Font.PLAIN, 20), Color.BLACK, (panelWidth - 200) / 2 + 100, 300, new Dimension(100, 30), e -> {
            String email = EmailTF.getText().trim();
            String username = UsernameTF.getText().trim();

            if (email.isEmpty() || username.isEmpty()) {
                JOptionPane.showMessageDialog(
                    null,
                    "Please fill in all fields before Update.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            } else {
                controller.adminUpdateUserData(userID, username, email);
                this.dispose();
                controller.AdminSRSFRAME1_Menu_AdminController();
            }
        });
    }
}
