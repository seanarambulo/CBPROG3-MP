import java.awt.*;
import javax.swing.*;

public class UserView {
    
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("DLSU Shuttle Reservation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(108, 194, 168)); // Background color
        
        // Panel for the main content
        JPanel panel = new JPanel();
        panel.setBounds(40, 30, 300, 200);
        panel.setBackground(new Color(31, 95, 79)); // Dark green background
        panel.setLayout(null);

        // Title Label
        JLabel titleLabel = new JLabel("DLSU Shuttle Reservation");
        titleLabel.setBounds(50, 10, 200, 20);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(titleLabel);

        // Username Label and Field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 50, 80, 20);
        usernameLabel.setForeground(Color.WHITE);
        panel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(110, 50, 150, 25);
        panel.add(usernameField);

        // Password Label and Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 90, 80, 20);
        passwordLabel.setForeground(Color.WHITE);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(110, 90, 150, 25);
        panel.add(passwordField);

        // Login Button
        JButton loginButton = new JButton("Log In");
        loginButton.setBounds(110, 130, 80, 30);
        loginButton.setBackground(new Color(220, 248, 232)); // Light green
        panel.add(loginButton);

        // Register Link
        JLabel registerLabel = new JLabel("Not yet verified?");
        registerLabel.setBounds(40, 170, 100, 20);
        registerLabel.setForeground(Color.WHITE);
        panel.add(registerLabel);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(150, 165, 100, 30);
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(new Color(220, 248, 232)); // Light green text
        panel.add(registerButton);

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);

        //Add View
    }
}
