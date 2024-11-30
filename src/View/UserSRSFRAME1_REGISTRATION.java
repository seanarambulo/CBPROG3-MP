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
    private final JComboBox<String> DesignationComboBox = new JComboBox<>(new String[]{"Student", "Employee"});
    private final JButton SubmitButton = new JButton("Submit");
    private DLSU_SRSUser_controller controller;

    public UserSRSFRAME1_REGISTRATION(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;
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
        setDesignationTitle("User Registration");

        FullNameLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        FullNameLabel.setForeground(Color.WHITE);
        innerGbc.gridx = 0;
        innerGbc.gridy = 1;
        innerGbc.gridwidth = 1;
        innerGbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(FullNameLabel, innerGbc);

        innerGbc.gridx = 1;
        innerGbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(FullNameTF, innerGbc);

        EmailLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        EmailLabel.setForeground(Color.WHITE);
        innerGbc.gridx = 0;
        innerGbc.gridy = 2;
        innerGbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(EmailLabel, innerGbc);

        innerGbc.gridx = 1;
        innerGbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(EmailTF, innerGbc);

        UserIDLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        UserIDLabel.setForeground(Color.WHITE);
        innerGbc.gridx = 0;
        innerGbc.gridy = 3;
        innerGbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(UserIDLabel, innerGbc);

        innerGbc.gridx = 1;
        innerGbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(UserIDTF, innerGbc);

        PasswordLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        PasswordLabel.setForeground(Color.WHITE);
        innerGbc.gridx = 0;
        innerGbc.gridy = 4;
        innerGbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(PasswordLabel, innerGbc);

        innerGbc.gridx = 1;
        innerGbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(PasswordTF, innerGbc);

        DesignationLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        DesignationLabel.setForeground(Color.WHITE);
        innerGbc.gridx = 0;
        innerGbc.gridy = 5;
        innerGbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(DesignationLabel, innerGbc);

        innerGbc.gridx = 1;
        innerGbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(DesignationComboBox, innerGbc);

        SubmitButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        innerGbc.gridx = 0;
        innerGbc.gridy = 6;
        innerGbc.gridwidth = 2;
        innerGbc.anchor = GridBagConstraints.CENTER;
        SubmitButton.addActionListener(e -> {
            String FullName = FullNameTF.getText();
            String Email = EmailTF.getText();
            String StringUserID = UserIDTF.getText();
            String Password = PasswordTF.getPassword();
            String Designation = (String) DesignationComboBox.getSelectedItem();

           if (FullName.isEmpty() || Email.isEmpty() || StringUserID.isEmpty() || Password.isEmpty()) {
                JOptionPane.showMessageDialog(outerPanel, "Please input in all fields.");
           } else if (!isString(FullName)) {
                JOptionPane.showMessageDialog(outerPanel, "Full name cannot contain numbers.");
           } else if (!isEmail(Email)) {
                JOptionPane.showMessageDialog(outerPanel, "Please input a valid DLSU email.");
           } else if (!StringUserID.isDigit()) {
                JOptionPane.showMessageDialog(outerPanel, "Please input a valid ID.");
           } else {
                int UserID = Integer.parseInt(UserIDTF.getText()); //change UserID into int
                    if (Designation.equals("Student")){ // User is Student
                        // input SQL input query?
                        this.dispose();
                        controller.SRS2FRAME_VERIFY_userController();
                    } else { // User is Employee
                        // input SQL input query
                        JOptionPane.showMessageDialog(outerPanel, "Account successfully registered");
                        this.dispose();
                        new SRS_LOGIN();
                    }
                }
            }

});
        innerPanel.add(SubmitButton, innerGbc);
        setVisible(true);
    }
}
