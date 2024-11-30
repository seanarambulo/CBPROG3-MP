package src.View;

import java.awt.*;
import javax.swing.*;
import src.Controller.DLSU_SRSUser_controller;

public class UserSRSFRAME1_REGISTRATION extends FrameBackground {

    private final JTextField FullNameTF = new JTextField(20);
    private final JTextField EmailTF = new JTextField(20);
    private final JTextField UserIDTF = new JTextField(20);
    private final JPasswordField PasswordTF  = new JPasswordField(20);
    private final JLabel FullNameLabel = new JLabel("Full Name:");
    private final JLabel EmailLabel = new JLabel("Email:");
    private final JLabel UserIDLabel = new JLabel("ID Number:");
    private final JLabel PasswordLabel = new JLabel("Password:");
    private final JLabel DesignationLabel = new JLabel("Designation:");
    private final JComboBox<String> DesignationComboBox = new JComboBox<>(new String[]{"Option 1", "Option 2", "Option 3"});
    private final JButton SubmitButton = new JButton("Submit");
    private DLSU_SRSUser_controller controller;

    public UserSRSFRAME1_REGISTRATION(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    public void initComponets() {
        setDesignationTitle("User Registration");

        FullNameLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        FullNameLabel.setForeground(Color.WHITE);
        FullNameLabel.setBounds(50, 60, 150, 30); // Set bounds for absolute positioning
        innerPanel.add(FullNameLabel);

        FullNameTF.setBounds(210, 60, 300, 30); // Set bounds for absolute positioning
        innerPanel.add(FullNameTF);

        EmailLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        EmailLabel.setForeground(Color.WHITE);
        EmailLabel.setBounds(50, 100, 150, 30); // Set bounds for absolute positioning
        innerPanel.add(EmailLabel);

        EmailTF.setBounds(210, 100, 300, 30); // Set bounds for absolute positioning
        innerPanel.add(EmailTF);

        UserIDLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        UserIDLabel.setForeground(Color.WHITE);
        UserIDLabel.setBounds(50, 140, 150, 30); // Set bounds for absolute positioning
        innerPanel.add(UserIDLabel);

        UserIDTF.setBounds(210, 140, 300, 30); // Set bounds for absolute positioning
        innerPanel.add(UserIDTF);

        PasswordLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        PasswordLabel.setForeground(Color.WHITE);
        PasswordLabel.setBounds(50, 180, 150, 30); // Set bounds for absolute positioning
        innerPanel.add(PasswordLabel);

        PasswordTF.setBounds(210, 180, 300, 30); // Set bounds for absolute positioning
        innerPanel.add(PasswordTF);

        DesignationLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        DesignationLabel.setForeground(Color.WHITE);
        DesignationLabel.setBounds(50, 220, 150, 30); // Set bounds for absolute positioning
        innerPanel.add(DesignationLabel);

        DesignationComboBox.setBounds(210, 220, 300, 30); // Set bounds for absolute positioning
        innerPanel.add(DesignationComboBox);

        SubmitButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        SubmitButton.setBounds(210, 260, 300, 50); // Set bounds for absolute positioning
        SubmitButton.addActionListener(e -> controller.SRS2FRAME_VERIFY_userController());
        innerPanel.add(SubmitButton);

        setVisible(true);
    }
}
