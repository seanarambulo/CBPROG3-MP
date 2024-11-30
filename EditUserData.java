import javax.swing.*;
import java.awt.*;

public class EditUserData {

    private JTextField EmailTF;
    private JTextField UsernameTF;
    private JPasswordField PasswordTF;
    private JLabel EmailLabel;
    private JLabel UsernameLabel;
    private JLabel PasswordLabel;
    private JLabel TitleLabel;
    private JButton SubmitButton;
    private JButton BackButton;

    public EditUserData() {
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

        // Password Label and TextField
        PasswordLabel = new JLabel("Password:");
        PasswordLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        PasswordLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 12, 10, 10); // More space between label and text field
        innerPanel.add(PasswordLabel, gbc);

        PasswordTF = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        innerPanel.add(PasswordTF, gbc);

        // Back Button (added on the left side of Update button)
        BackButton = new JButton("Back");
        BackButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(40, 0, 20, 10); // Space for Back button
        innerPanel.add(BackButton, gbc);

        // Submit Button (Update)
        SubmitButton = new JButton("Update");
        SubmitButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(40, 10, 20, 0); // Space for Submit button
        innerPanel.add(SubmitButton, gbc);

        // Adding innerPanel to outerPanel
        outerPanel.add(innerPanel);
        frame.add(outerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EditUserData::new);
    }
}
