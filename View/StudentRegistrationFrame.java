import java.awt.*;
import javax.swing.*;

public class StudentRegistrationFrame {

    private JFrame frame;
    private JLabel DesignationTitle;
    private JLabel FullNameLabel3;
    private JButton jButton2;
    private JButton jButton3;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox4;
    private JCheckBox jCheckBox5;
    private JCheckBox jCheckBox7;
    private JCheckBox jCheckBox8;

    private void initialize() {
        // Main frame
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setTitle("DLSU Shuttle Reservation");

        // Outer panel with light green background
        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(new Color(108, 194, 162));
        outerPanel.setLayout(new GridBagLayout());
        outerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Inner panel with dark green background
        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(new Color(53, 95, 79));
        innerPanel.setLayout(null); // Using null layout for precise positioning
        innerPanel.setPreferredSize(new Dimension(710, 430));

        // Label: DLSU Shuttle Reservation
        DesignationTitle = new JLabel("DLSU Shuttle Reservation");
        DesignationTitle.setFont(new Font("Baskerville", Font.PLAIN, 36));
        DesignationTitle.setForeground(Color.WHITE);
        DesignationTitle.setBounds(180, 20, 400, 40);
        innerPanel.add(DesignationTitle);

        // Submit EAF label
        FullNameLabel3 = new JLabel("Submit EAF:");
        FullNameLabel3.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        FullNameLabel3.setForeground(Color.WHITE);
        FullNameLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        FullNameLabel3.setBounds(50, 100, 140, 40);
        innerPanel.add(FullNameLabel3);

        // Select file button
        jButton2 = new JButton("Select a File");
        jButton2.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        jButton2.setForeground(new Color(102, 102, 102));
        jButton2.setBounds(200, 100, 380, 40);
        innerPanel.add(jButton2);

        // Checkboxes for days (with white background)
        jCheckBox3 = createCheckbox("Monday", 100, 160);
        jCheckBox4 = createCheckbox("Tuesday", 100, 200);
        jCheckBox5 = createCheckbox("Wednesday", 100, 240);
        jCheckBox7 = createCheckbox("Thursday", 400, 160);
        jCheckBox8 = createCheckbox("Friday", 400, 200);
        jCheckBox2 = createCheckbox("Saturday", 400, 240);

        innerPanel.add(jCheckBox3);
        innerPanel.add(jCheckBox4);
        innerPanel.add(jCheckBox5);
        innerPanel.add(jCheckBox7);
        innerPanel.add(jCheckBox8);
        innerPanel.add(jCheckBox2);

        // Submit button
        jButton3 = new JButton("Submit");
        jButton3.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        jButton3.setForeground(new Color(108, 194, 162));
        jButton3.setBounds(260, 300, 190, 40);
        innerPanel.add(jButton3);

        // Add inner panel to outer panel
        outerPanel.add(innerPanel);

        // Add outer panel to frame
        frame.add(outerPanel);
        frame.setLocationRelativeTo(null); // Center the frame on screen
        frame.setVisible(true);
    }

    private JCheckBox createCheckbox(String text, int x, int y) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        checkBox.setForeground(new Color(108, 194, 162));
        checkBox.setBackground(Color.WHITE);
        checkBox.setBounds(x, y, 130, 30);
        return checkBox;
    }

}
