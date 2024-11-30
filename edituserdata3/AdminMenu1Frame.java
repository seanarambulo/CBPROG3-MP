import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu1Frame {

    private JLabel DesignationTitle;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6; // New button for "Edit User Data"

    public AdminMenu1Frame(DLSU_SRSAdmin_controller Acontroller) {
        initComponents(Acontroller);
    }

    private void initComponents(DLSU_SRSAdmin_controller Acontroller) {
        JFrame frame = new JFrame("Admin Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(810, 530);
        frame.setResizable(false); // Make the frame non-resizable
        frame.setLayout(null); // Set layout to null for manual positioning

        // Create the outer panel (light green)
        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(new Color(108, 194, 162));
        outerPanel.setBounds(0, 0, 810, 530); // Cover the whole frame
        frame.add(outerPanel);
        outerPanel.setLayout(null);

        // Create and add the inner panel (dark green)
        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(new Color(53, 95, 79)); // Dark green background
        innerPanel.setBounds(50, 35, 710, 430); // Set bounds for the inner panel
        innerPanel.setLayout(null); // No layout manager for manual positioning
        outerPanel.add(innerPanel);

        // Create and add the title label
        DesignationTitle = new JLabel("Admin Menu");
        DesignationTitle.setFont(new Font("Baskerville", Font.PLAIN, 36));
        DesignationTitle.setForeground(Color.WHITE);
        DesignationTitle.setHorizontalAlignment(JLabel.CENTER);
        DesignationTitle.setBounds(130, 12, 450, 50); // Position and size of the title
        innerPanel.add(DesignationTitle);

        // Set the size for the buttons (smaller size)
        int buttonWidth = 320;
        int buttonHeight = 50;
        int buttonX = (innerPanel.getWidth() - buttonWidth) / 2; // Center horizontally
        int buttonY = 67; // Starting Y position for buttons

        // Button 1
        jButton1 = new JButton("Verify Registrations");
        jButton1.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        jButton1.setForeground(new Color(108, 194, 162));
        jButton1.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        innerPanel.add(jButton1);

        // Button 2
        jButton2 = new JButton("View Reservations");
        jButton2.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        jButton2.setForeground(new Color(108, 194, 162));
        jButton2.setBounds(buttonX, buttonY + 60, buttonWidth, buttonHeight); // Adjusted Y position
        innerPanel.add(jButton2);

        // Button 3
        jButton3 = new JButton("View Shuttle Routes");
        jButton3.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        jButton3.setForeground(new Color(108, 194, 162));
        jButton3.setBounds(buttonX, buttonY + 120, buttonWidth, buttonHeight); // Adjusted Y position
        innerPanel.add(jButton3);

        // Button 4
        jButton4 = new JButton("Verify Reservations");
        jButton4.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        jButton4.setForeground(new Color(108, 194, 162));
        jButton4.setBounds(buttonX, buttonY + 180, buttonWidth, buttonHeight); // Adjusted Y position
        innerPanel.add(jButton4);

        // Button 5
        jButton5 = new JButton("Edit Admin Data");
        jButton5.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        jButton5.setForeground(new Color(108, 194, 162));
        jButton5.setBounds(buttonX, buttonY + 240, buttonWidth, buttonHeight); // Adjusted Y position
        innerPanel.add(jButton5);

        // Button 6 (New "Edit User Data" button)
        jButton6 = new JButton("Edit User Data");
        jButton6.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        jButton6.setForeground(new Color(108, 194, 162));
        jButton6.setBounds(buttonX, buttonY + 300, buttonWidth, buttonHeight); // Adjusted Y position
        innerPanel.add(jButton6);

        // Action for Button 6 (Edit User Data)
        jButton6.addActionListener(e -> {
            // Show JOptionPane to get user ID input
            String userId = JOptionPane.showInputDialog(frame, "Enter User ID:", "Edit User Data", JOptionPane.PLAIN_MESSAGE);
            if (userId != null && !userId.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "User ID entered: " + userId, "User ID Confirmation", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                Acontroller.AdminEditUserData();
            } else {
                // Handle if no input or user cancels
                JOptionPane.showMessageDialog(frame, "No User ID entered.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
}
