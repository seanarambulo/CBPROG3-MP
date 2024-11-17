import java.awt.*;
import javax.swing.*;

public class UserView {
    
    public void SRSFRAME1(){
        // Create the frame
        JFrame frame = new JFrame("DLSU Shuttle Reservation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(810, 530);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(108, 194, 168)); // Background color
        
        // Panel for the main content
        JPanel panel = new JPanel();
        panel.setBounds(40, 30, 710, 430);
        panel.setBackground(new Color(31, 95, 79)); // Dark green background
        panel.setLayout(null);

        // Title Label
        JLabel titleLabel = new JLabel("DLSU Shuttle Reservation", SwingConstants.CENTER);
        titleLabel.setBounds(50, 30, 600, 50);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 48));
        panel.add(titleLabel);

        // Username Label and Field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(80, 120, 80, 20);
        usernameLabel.setForeground(Color.WHITE);
        panel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(160, 120, 460, 25);
        panel.add(usernameField);

        // Password Label and Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(80, 160, 80, 20);
        passwordLabel.setForeground(Color.WHITE);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(160, 160, 460, 25);
        panel.add(passwordField);

        // Login Button
        JButton loginButton = new JButton("Log In");
        loginButton.setBounds(330, 210, 80, 30);
        loginButton.setBackground(new Color(220, 248, 232)); // Light green
        panel.add(loginButton);

        // Register Link
        JLabel registerLabel = new JLabel("Not yet verified?");
        registerLabel.setBounds(265, 250, 100, 20);
        registerLabel.setForeground(Color.WHITE);
        panel.add(registerLabel);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(365, 245, 100, 30);
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(new Color(220, 248, 232)); // Light green text
        panel.add(registerButton);

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);

    }
}
