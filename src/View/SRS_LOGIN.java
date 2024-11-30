package src.View;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;
import src.Controller.*;
import src.Model.*;

public class SRS_LOGIN extends FrameBackground {
    // Class level variable declarations
    private final JLabel usernameLabel = new JLabel("Username:");
    private final JTextField usernameField = new JTextField();
    private final JLabel passwordLabel = new JLabel("Password:");
    private final JPasswordField passwordField = new JPasswordField();
    private final JButton loginButton = new JButton("Log In");
    private final JLabel registerLabel = new JLabel("Not yet Registered?");
    private final JButton registerButton = new JButton("Register");

    public SRS_LOGIN() {
        super();
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    public void initComponets() {
        
        setDesignationTitle("DLSU Shuttle Reservation");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username Label and Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        usernameLabel.setForeground(Color.WHITE);
        innerPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        innerPanel.add(usernameField, gbc);

        // Password Label and Field
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        passwordLabel.setForeground(Color.WHITE);
        innerPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        innerPanel.add(passwordField, gbc);

        // Login Button
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        loginButton.setBackground(new Color(220, 248, 232)); // Light green
        loginButton.setName("loginButton");
        loginButton.addActionListener(e -> {
            String usernameText = usernameField.getText(); // Get text from the field
            String password = new String(passwordField.getPassword());

            try {
                if (usernameText.isEmpty() || password.isEmpty()) {
                    if (usernameText.isEmpty() && password.isEmpty()) {
                        JOptionPane.showMessageDialog(outerPanel, "Please enter a username and password.");
                    } else if (usernameText.isEmpty()) {
                        JOptionPane.showMessageDialog(outerPanel, "Please enter a username.");
                    } else {
                        JOptionPane.showMessageDialog(outerPanel, "Please enter a password.");
                    }
                } else {
                    // Parse usernameText to an integer
                    int username = Integer.parseInt(usernameText);

                    // Assuming the method getDesignationID(int, String) exists in DatabaseManager
                    DatabaseManager dbManager = new DatabaseManager();
                    int tempID = dbManager.getDesignationID(username, password);

                    // Check if tempID is valid and proceed
                    if (tempID != -1) {
                        DLSU_SRSUser_controller Ucontroller;
                        switch (tempID) {
                            case 1 -> {
                                DLSU_SRSDispatcher_controller Dcontroller = new DLSU_SRSDispatcher_controller(username, password);
                                this.dispose();
                                Dcontroller.DispatcherMenu1Frame();
                            }
                            case 2 -> {
                                // Add logic for case 2 if needed
                            }
                            case 3 -> {
                                Ucontroller = new DLSU_SRSUser_controller(username, password);  
                                this.dispose();
                                Ucontroller.SRSFRAME3_USERINTERFACE_userController(); 
                            }
                            case 4 -> {
                                Ucontroller = new DLSU_SRSUser_controller(username, password);        
                                this.dispose();
                                Ucontroller.SRSFRAME3_USERINTERFACE_userController();
                            }
                            default -> JOptionPane.showMessageDialog(outerPanel, "Invalid designation ID.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(outerPanel, "Invalid username or password.");
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(outerPanel, "UserID must be a number.");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(outerPanel, "An error occurred while accessing the database.");
            }
        });
        innerPanel.add(loginButton, gbc);

        // Register Link
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        registerLabel.setForeground(Color.WHITE);
        innerPanel.add(registerLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(new Color(220, 248, 232)); // Light green text
        registerButton.setName("registerButton");
        registerButton.addActionListener(e -> {
            Ucontroller = new DLSU_SRSUser_controller();
            this.dispose();
            Ucontroller.registrationFrame();
        });
        innerPanel.add(registerButton, gbc);

        // Add innerPanel to frame
        innerPanel.revalidate();
        innerPanel.repaint();
        innerPanel.setVisible(true);
    }
}
