import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class LogInClass {

    // Class-level variable declarations
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel registerLabel;
    private JButton registerButton;
    private JPanel panel;
    private JLabel titleLabel;
    private JFrame frame;
  

    public LogInClass() {
        LogIn();
    }

    private void LogIn() {
        // Create the frame
        frame = new JFrame("DLSU Shuttle Reservation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(810, 530);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(108, 194, 168)); // Background color

        // Panel for the main content
        panel = new JPanel();
        panel.setBounds(40, 30, 710, 430);
        panel.setBackground(new Color(31, 95, 79)); // Dark green background
        panel.setLayout(null);

        // Title Label
        titleLabel = new JLabel("DLSU Shuttle Reservation", SwingConstants.CENTER);
        titleLabel.setBounds(50, 30, 600, 50);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 48));
        panel.add(titleLabel);

        // Username Label and Field
        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(80, 120, 80, 20);
        usernameLabel.setForeground(Color.WHITE);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(160, 120, 460, 25);
        panel.add(usernameField);

        // Password Label and Field
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(80, 160, 80, 20);
        passwordLabel.setForeground(Color.WHITE);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(160, 160, 460, 25);
        panel.add(passwordField);

        // Login Button
        loginButton = new JButton("Log In");
        loginButton.setBounds(330, 210, 80, 30);
        loginButton.setBackground(new Color(220, 248, 232)); // Light green
        loginButton.setName("loginButton");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameText = usernameField.getText(); // Get text from the field / Holds UserID
                String password = new String(passwordField.getPassword());
        
                try {
                    if (usernameText.isEmpty() || password.isEmpty()) {
                        if (usernameText.isEmpty() && password.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Please enter a username and password.");
                        } else if (usernameText.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Please enter a username.");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Please enter a password.");
                        }
                    } else {
                        // Parse usernameText to an integer
                        int username = Integer.parseInt(usernameText);
        
                        // Assuming the method getDesignationID(int, String) exists in DatabaseManager
                        DatabaseManager dbManager = new DatabaseManager();
                        int tempID = dbManager.getDesignationID(username, password);
        
                        // Check if tempID is valid and proceed
                        if (tempID != -1) {
                            DLSU_SRSUser_controller Ucontroller = null;
                            switch (tempID) {
                                case 1:
                                    DLSU_SRSAdmin_controller Acontroller = new DLSU_SRSAdmin_controller(username, password);
                                    frame.dispose();
                                    Acontroller.AdminMenu1Frame();
                                    break;
                                case 2:
                                    DLSU_SRSDispatcher_controller Dcontroller = new DLSU_SRSDispatcher_controller(username, password);
                                    frame.dispose();
                                    Dcontroller.DispatcherMenu1Frame();
                                    break;
                                case 3:
                                Ucontroller = new DLSU_SRSUser_controller(username, password);
                                frame.dispose();
                                Ucontroller.UserMenu1Frame();
                                    break;
                                case 4:
                                    Ucontroller = new DLSU_SRSUser_controller(username, password);
                                    frame.dispose();
                                    Ucontroller.UserMenu1Frame();
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(frame, "Invalid designation ID.");
                                    break;
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Invalid username or password.");
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Username must be a number.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "An error occurred while accessing the database.");
                }
            }
        });
        
        panel.add(loginButton);

        // Register Link
        registerLabel = new JLabel("Not yet verified?");
        registerLabel.setBounds(265, 250, 100, 20);
        registerLabel.setForeground(Color.WHITE);
        panel.add(registerLabel);

        registerButton = new JButton("Register");
        registerButton.setBounds(365, 245, 100, 30);
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(new Color(220, 248, 232)); // Light green text
        registerButton.setName("registerButton");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
            }
        });
        panel.add(registerButton);

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }

    
}


