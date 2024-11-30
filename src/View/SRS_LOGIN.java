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
        setDesignationTitle("DLSU Shuttle Reservation", 50,0,0,0);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    public void initComponets() {
        
        innerPanel.setLayout(null); // Use absolute positioning

        // Username Label and Field
        usernameLabel.setBounds(80, 120, 80, 20);
        usernameLabel.setForeground(Color.WHITE);
        innerPanel.add(usernameLabel);

        usernameField.setBounds(160, 120, 460, 25);
        innerPanel.add(usernameField);

        // Password Label and Field
        passwordLabel.setBounds(80, 160, 80, 20);
        passwordLabel.setForeground(Color.WHITE);
        innerPanel.add(passwordLabel);

        passwordField.setBounds(160, 160, 460, 25);
        innerPanel.add(passwordField);

        // Login Button
        loginButton.setBounds(330, 210, 80, 30);
        loginButton.setBackground(new Color(220, 248, 232)); // Light green
        loginButton.setName("loginButton");
        loginButton.addActionListener(e -> {
            String usernameText = "12300002"; //usernameField.getText(); // Get text from the field
            String password = "b2b4de62";//new String(passwordField.getPassword());

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
        innerPanel.add(loginButton);

        // Register Link
        registerLabel.setBounds(235, 260, 120, 20);
        registerLabel.setForeground(Color.WHITE);
        innerPanel.add(registerLabel);

        registerButton.setBounds(365, 256, 100, 30);
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(new Color(220, 248, 232)); // Light green text
        registerButton.setName("registerButton");
        registerButton.addActionListener(e -> {
            this.dispose();
        });
        innerPanel.add(registerButton);

        // Add innerPanel to frame
        innerPanel.revalidate();
        innerPanel.repaint();
        innerPanel.setVisible(true);
    }
}
