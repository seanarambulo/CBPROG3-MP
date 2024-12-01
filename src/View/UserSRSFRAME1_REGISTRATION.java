package src.View;

import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;
import src.Controller.DLSU_SRSUser_controller;

public class UserSRSFRAME1_REGISTRATION extends FrameBackground {

    private final JPasswordField PasswordTF  = new JPasswordField(20);
    private final JComboBox<String> DesignationComboBox = new JComboBox<>(new String[]{"Student", "Employee"});
    private DLSU_SRSUser_controller controller;
    public UserSRSFRAME1_REGISTRATION(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;
        setDesignationTitle("User Registration", 10, 0, 0, 0);
        
        SwingUtilities.invokeLater(() -> initComponets());
    }

	public static boolean isEmail(String input){
        return input.endsWith("@dlsu.edu.ph");
    }

    public static boolean isString(String input){
		return input.matches("\\D+");
	}

    @Override
    public void initComponets() {
        
        innerPanel.setLayout(null);
        createLabel("Full Name:", 50, 80, new Dimension(150, 30), new Font("Helvetica Neue", Font.PLAIN, 20), Color.WHITE);
        JTextField FullNameTF = createTextField(210, 80, 300, 30);

        createLabel("Email:", 50, 120, new Dimension(150, 30), new Font("Helvetica Neue", Font.PLAIN, 20), Color.WHITE);
        JTextField EmailTF = createTextField(210, 120, 300, 30);

        createLabel("ID Number:", 50, 160, new Dimension(150, 30), new Font("Helvetica Neue", Font.PLAIN, 20), Color.WHITE);
        JTextField UserIDTF = createTextField(210, 160, 300, 30);

        createLabel("Password:", 50, 200, new Dimension(150, 30), new Font("Helvetica Neue", Font.PLAIN, 20), Color.WHITE);
        PasswordTF.setBounds(210, 200, 300, 30);
        innerPanel.add(PasswordTF);

        createLabel("Designation:", 50, 240, new Dimension(150, 30), new Font("Helvetica Neue", Font.PLAIN, 20), Color.WHITE);
        DesignationComboBox.setBounds(210, 240, 300, 30);
        innerPanel.add(DesignationComboBox);

        configureButton("Submit", new Font("Helvetica Neue", Font.PLAIN, 20), Color.BLACK, 210, 280, new Dimension(300, 50), e -> {
            String FullName = FullNameTF.getText();
            String Email = EmailTF.getText();
            String StringUserID = UserIDTF.getText();
            String Password = new String(PasswordTF.getPassword());
            String Designation = (String) DesignationComboBox.getSelectedItem();

            if (FullName.isEmpty() || Email.isEmpty() || StringUserID.isEmpty() || Password.isEmpty()) {
                JOptionPane.showMessageDialog(outerPanel, "Please input in all fields.");
            } else if (!isString(FullName)) {
                JOptionPane.showMessageDialog(outerPanel, "Full name cannot contain numbers.");
            } else if (!isEmail(Email)) {
                JOptionPane.showMessageDialog(outerPanel, "Please input a valid DLSU email.");
            } else if (!StringUserID.chars().allMatch(Character::isDigit)) {
                JOptionPane.showMessageDialog(outerPanel, "Please input a valid ID.");
            } else if (Password.length() != 8) {
                JOptionPane.showMessageDialog(outerPanel, "Password must be 8 digits long.");
            } else {
                int UserID = Integer.parseInt(UserIDTF.getText());
                if (Designation.equals("Student")) {
                    this.dispose();
                    try {
                        controller.insertIntoUser(UserID, FullName, Password, Email, 4);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                     new UserSRSFRAME2_VERIFY(UserID);
                } else {
                    JOptionPane.showMessageDialog(outerPanel, "Account successfully registered");
                    this.dispose();
                    try {
                        controller.insertIntoUser(UserID, FullName, Password, Email, 3);
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    new SRS_LOGIN();
                }
            }
        });

        setVisible(true);
    }
}
