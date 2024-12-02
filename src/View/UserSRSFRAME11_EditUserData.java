package src.View;

import java.awt.*;
import javax.swing.*;
import src.Controller.DLSU_SRSUser_controller;

public class UserSRSFRAME11_EditUserData extends FrameBackground {

    private JTextField EmailTF;
    private JTextField UsernameTF;
    private JPasswordField PasswordTF;
    private JLabel EmailLabel;
    private JLabel UsernameLabel;
    private JLabel PasswordLabel;
    private JButton SubmitButton;
    private JButton BackButton;
    private DLSU_SRSUser_controller controller;

    public UserSRSFRAME11_EditUserData(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;
        setDesignationTitle("Edit User Data", 20, 0, 0, 0);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    protected void initComponets() {
        
        setLayout(null);

        int buttonWidth = 320;
        int buttonHeight = 30;
        int buttonX = (innerPanel.getWidth() - buttonWidth) / 2;
        int buttonY = 100;

        EmailLabel = createLabel("Email:", buttonX, buttonY, new Dimension(buttonWidth, buttonHeight), new Font("Helvetica Neue", Font.PLAIN, 20), Color.WHITE);

        EmailTF = createTextField(buttonX, buttonY + buttonHeight, buttonWidth, buttonHeight);

        UsernameLabel = createLabel("Username:", buttonX, buttonY + 2 * buttonHeight, new Dimension(buttonWidth, buttonHeight), new Font("Helvetica Neue", Font.PLAIN, 20), Color.WHITE);

        UsernameTF = createTextField(buttonX, buttonY + 3 * buttonHeight, buttonWidth, buttonHeight);

        PasswordLabel = createLabel("Password:", buttonX, buttonY + 4 * buttonHeight, new Dimension(buttonWidth, buttonHeight), new Font("Helvetica Neue", Font.PLAIN, 20), Color.WHITE);

        PasswordTF = createPasswordField(buttonX, buttonY + 5 * buttonHeight, buttonWidth, buttonHeight);

        BackButton = configureButton("Back", new Font("Helvetica Neue", Font.PLAIN, 20), Color.BLACK, buttonX, buttonY + 6 * buttonHeight, new Dimension(buttonWidth / 2, buttonHeight), e -> {
            // Add action for Back button
        });
        add(BackButton);

        SubmitButton = configureButton("Update", new Font("Helvetica Neue", Font.PLAIN, 20), Color.BLACK, buttonX + buttonWidth / 2 + 10, buttonY + 6 * buttonHeight, new Dimension(buttonWidth / 2, buttonHeight), e -> {
            // Add action for Submit button
        });
        add(SubmitButton);
    }
}
