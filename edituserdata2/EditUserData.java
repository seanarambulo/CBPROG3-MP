import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditUserData {

    private JTextField EmailTF;
    private JTextField UsernameTF;
    private JPasswordField PasswordTF;
    private JLabel EmailLabel;
    private JLabel UsernameLabel;
    private JLabel PasswordLabel;
    private JLabel TitleLabel;
    private JButton UpdateButton;
    private JButton BackButton;

    private DLSU_SRSUser_controller controller;

    public EditUserData(DLSU_SRSUser_controller controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        JFrame frame = new JFrame("Edit User Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(810, 530);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(new Color(108, 194, 162));
        outerPanel.setLayout(new GridBagLayout());
        outerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(new Color(53, 95, 79));
        innerPanel.setLayout(new GridBagLayout());
        innerPanel.setPreferredSize(new Dimension(710, 430));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 20, 15, 20);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title Label
        TitleLabel = new JLabel("Edit User Data");
        TitleLabel.setFont(new Font("Baskerville", Font.PLAIN, 36));
        TitleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(40, 87, 30, 0);
        innerPanel.add(TitleLabel, gbc);

        // Email Label and TextField
        EmailLabel = new JLabel("Email:");
        EmailLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        EmailLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 12, 10, 10);
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
        gbc.insets = new Insets(20, 12, 10, 10);
        innerPanel.add(UsernameLabel, gbc);

        UsernameTF = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        innerPanel.add(UsernameTF, gbc);

        // Password Label and TextField
        PasswordLabel = new JLabel("Password:");
        PasswordLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        PasswordLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 12, 10, 10);
        innerPanel.add(PasswordLabel, gbc);

        PasswordTF = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        innerPanel.add(PasswordTF, gbc);

        // Back Button
        BackButton = new JButton("Back");
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current frame
                new UserMenu1Frame(controller); // Navigate back to UserMenu1Frame
            }
        });
        gbc.gridx = 0; // Place in the first column
        gbc.gridy = 4; // Same row as the Update button
        gbc.gridwidth = 1; // Individual button
        gbc.insets = new Insets(30, 0, 10, 10); // Add right padding for spacing
        innerPanel.add(BackButton, gbc);

        // Update Button
        UpdateButton = new JButton("Update");
        UpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = EmailTF.getText().trim();
                String username = UsernameTF.getText().trim();
                String password = new String(PasswordTF.getPassword()).trim();

                // Check if any field is empty
                if (email.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Please fill in all fields before Update.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    // If all fields are filled, proceed with submission
                    controller.updateUserData(username, email, password);
                    frame.dispose(); // Close the current frame
                    controller.UserMenu1Frame(); // Navigate back to UserMenu1Frame
                }
            }
        });
        gbc.gridx = 1; // Place in the second column
        gbc.gridy = 4; // Same row as the Back button
        gbc.gridwidth = 1; // Individual button
        gbc.insets = new Insets(30, 10, 10, 0); // Add left padding for spacing
        innerPanel.add(UpdateButton, gbc);


        // Adding innerPanel to outerPanel
        outerPanel.add(innerPanel);
        frame.add(outerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
