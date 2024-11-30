import java.awt.*;
import javax.swing.*;

public class RegistrationFrame {

    private JTextField FullNameTF3;
    private JTextField FullNameTF4;
    private JTextField FullNameTF5;
    private JTextField FullNameTF6;
    private JPasswordField FullNameTF7;
    private JLabel FullNameLabel2;
    private JLabel FullNameLabel3;
    private JLabel FullNameLabel4;
    private JLabel FullNameLabel5;
    private JLabel FullNameLabel6;
    private JLabel FullNameLabel7;
    private JComboBox<String> DesignationComboBox;
    private JLabel DesignationTitle;
    private JButton SubmitButton;

    public  RegistrationFrame(DLSU_SRSUser_controller Ucontroller){
        JFrame frame = new JFrame("DLSU SRS User Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(810, 530);
        frame.setResizable(false); // Make the frame non-resizable
        frame.setLayout(new BorderLayout());

        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(new Color(108, 194, 162));
        outerPanel.setLayout(new GridBagLayout()); // Use GridBagLayout to center innerPanel
        outerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(new Color(53, 95, 79));
        innerPanel.setLayout(new GridBagLayout());
        innerPanel.setPreferredSize(new Dimension(710, 430)); // Set preferred size to make the panel larger
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        DesignationTitle = new JLabel("DLSU SRS User Registration");
        DesignationTitle.setFont(new Font("Baskerville", Font.PLAIN, 36));
        DesignationTitle.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        innerPanel.add(DesignationTitle, gbc);

        FullNameLabel2 = new JLabel("Full Name:");
        FullNameLabel2.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        FullNameLabel2.setForeground(Color.WHITE);
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(FullNameLabel2, gbc);

        FullNameTF3 = new JTextField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(FullNameTF3, gbc);

        FullNameLabel3 = new JLabel("Email:");
        FullNameLabel3.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        FullNameLabel3.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(FullNameLabel3, gbc);

        FullNameTF4 = new JTextField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(FullNameTF4, gbc);

        FullNameLabel4 = new JLabel("ID Number:");
        FullNameLabel4.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        FullNameLabel4.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(FullNameLabel4, gbc);

        FullNameTF5 = new JTextField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(FullNameTF5, gbc);

        FullNameLabel5 = new JLabel("Username:");
        FullNameLabel5.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        FullNameLabel5.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(FullNameLabel5, gbc);

        FullNameTF6 = new JTextField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(FullNameTF6, gbc);

        FullNameLabel6 = new JLabel("Password:");
        FullNameLabel6.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        FullNameLabel6.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(FullNameLabel6, gbc);

        FullNameTF7 = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(FullNameTF7, gbc);

        FullNameLabel7 = new JLabel("Designation:");
        FullNameLabel7.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        FullNameLabel7.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(FullNameLabel7, gbc);

        DesignationComboBox = new JComboBox<>(new String[]{"Option 1", "Option 2", "Option 3"});
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(DesignationComboBox, gbc);

        SubmitButton = new JButton("Submit");
        SubmitButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        innerPanel.add(SubmitButton, gbc);

        GridBagConstraints outerGbc = new GridBagConstraints();
        outerGbc.gridx = 0;
        outerGbc.gridy = 0;
        outerGbc.anchor = GridBagConstraints.CENTER;
        outerPanel.add(innerPanel, outerGbc);

        frame.getContentPane().add(outerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
