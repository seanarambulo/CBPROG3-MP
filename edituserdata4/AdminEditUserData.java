import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminEditUserData {

    private JTextField EmailTF;
    private JTextField UsernameTF;
    private JLabel EmailLabel;
    private JLabel UsernameLabel;
    private JLabel TitleLabel;
    private JButton UpdateButton;
    private JButton BackButton;

    private DLSU_SRSAdmin_controller controller;
    private int userID;

    public AdminEditUserData(DLSU_SRSAdmin_controller controller, int userID) {
    this.controller = controller;
    this.userID = userID;
    initComponents();
    }


    private void initComponents() {
        JFrame frame = new JFrame("Edit User Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(810, 430);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(new Color(108, 194, 162));
        outerPanel.setLayout(new GridBagLayout());
        outerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(new Color(53, 95, 79));
        innerPanel.setLayout(new GridBagLayout());
        innerPanel.setPreferredSize(new Dimension(710, 330)); // Adjusted height
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 20, 15, 20); // More space between components
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title Label
        TitleLabel = new JLabel("Edit User Data");
        TitleLabel.setFont(new Font("Baskerville", Font.PLAIN, 36));
        TitleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(40, 87, 30, 0); // Adjust margin for title
        innerPanel.add(TitleLabel, gbc);

        // Email Label and TextField
        EmailLabel = new JLabel("Email:");
        EmailLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        EmailLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 12, 10, 10); // More space between label and text field
        innerPanel.add(EmailLabel, gbc);

        EmailTF = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        innerPanel.add(EmailTF, gbc);

        // Username Label and TextField
        UsernameLabel = new JLabel("Username:");
        UsernameLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        UsernameLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 12, 10, 10); // More space between label and text field
        innerPanel.add(UsernameLabel, gbc);

        UsernameTF = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        innerPanel.add(UsernameTF, gbc);

        // Back Button
        BackButton = new JButton("Back");
        BackButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current frame
                controller.AdminMenu1Frame(); // Navigate back to AdminMenu1Frame
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(40, 0, 20, 10); // Space above and below the button, space between buttons
        innerPanel.add(BackButton, gbc);

        // Update Button
        UpdateButton = new JButton("Update");
        UpdateButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        UpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = EmailTF.getText().trim();
                String username = UsernameTF.getText().trim();

                // Check if any field is empty
                if (email.isEmpty() || username.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Please fill in all fields before Update.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    // If all fields are filled, proceed with submission
                    controller.adminUpdateUserData(userID, username, email);
                    frame.dispose(); // Close the current frame
                    controller.AdminMenu1Frame(); // Navigate back to AdminMenu1Frame
                }
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(40, 10, 20, 0); // Adjust space to the right of Update button
        innerPanel.add(UpdateButton, gbc);

        // Adding innerPanel to outerPanel
        outerPanel.add(innerPanel);
        frame.add(outerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

}
