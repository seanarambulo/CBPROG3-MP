package src.View;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;
import src.Controller.*;
import src.Model.*;

public class SRS_LOGIN extends FrameBackground {
    // Class level variable declarations
    private final JButton loginButton = new JButton("Log In");
    private final JButton registerButton = new JButton("Register");
    private DLSU_SRSUser_controller Ucontroller;

    public SRS_LOGIN() {
        super();
        setDesignationTitle("DLSU Shuttle Reservation", 50,0,0,0);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    public void initComponets() {
        
        innerPanel.setLayout(null); // Use absolute positioning

        // Username Label and Field
        createLabel("Username:", 80, 120, new Dimension(80, 20), new Font("Arial", Font.PLAIN, 12), Color.WHITE);
        JTextField usernameField = createTextField(160, 120, 460, 25);
        innerPanel.add(usernameField); // Add the usernameField to the panel

        // Password Label and Field
        createLabel("Password:", 80, 160, new Dimension(80, 20), new Font("Arial", Font.PLAIN, 12), Color.WHITE);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(160, 160, 460, 25);
        innerPanel.add(passwordField);

        // Login Button
        loginButton.setBounds(330, 210, 80, 30);
        loginButton.setBackground(new Color(220, 248, 232)); // Light green
        loginButton.setName("loginButton");
        loginButton.addActionListener(e -> {
            String usernameText = usernameField.getText();//"20000002";
             // Get text from the field
            String password = new String(passwordField.getPassword());//"password2";
             // Get text from the field

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
                        switch (tempID) {
                            case 1 -> {
                                DLSU_SRSAdmin_controller Acontroller = new DLSU_SRSAdmin_controller(username, password);
                                this.dispose();
                                Acontroller.AdminSRSFRAME1_Menu_AdminController();
                            }
                            case 2 -> {
                                DLSU_SRSDispatcher_controller Dcontroller = new DLSU_SRSDispatcher_controller(username, password);
                                this.dispose();
                                Dcontroller.DispatcherMenu1Frame_Menu_DispatcherController();                                
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
        createLabel("Not yet Registered?", 235, 260, new Dimension(120, 20), new Font("Arial", Font.PLAIN, 12), Color.WHITE);
        registerButton.setBounds(365, 256, 100, 30);
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(new Color(220, 248, 232)); // Light green text
        registerButton.setName("registerButton");
        registerButton.addActionListener(e -> {
            this.dispose();
            Ucontroller = new DLSU_SRSUser_controller();
            Ucontroller.SRS1FRAME_REGISTRATION_userController();
        });
        innerPanel.add(registerButton);

        // Add innerPanel to frame
        innerPanel.revalidate();
        innerPanel.repaint();
        innerPanel.setVisible(true);
    }
}
