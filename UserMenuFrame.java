import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenuFrame {

    private JLabel DesignationTitle;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;

    public UserMenuFrame() {
        initComponents();
    }

    private void initComponents() {
        JFrame frame = new JFrame("User Menu");
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

        DesignationTitle = new JLabel("DLSU Shuttle Reservation");
        DesignationTitle.setFont(new Font("Baskerville", Font.PLAIN, 36));
        DesignationTitle.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        innerPanel.add(DesignationTitle, gbc);

        Dimension buttonSize = new Dimension(300, 50);

        jButton1 = new JButton("Add Reservation");
        jButton1.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        jButton1.setForeground(new Color(108, 194, 162));
        jButton1.setPreferredSize(buttonSize);
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        innerPanel.add(jButton1, gbc);

        jButton2 = new JButton("View Reservation");
        jButton2.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        jButton2.setForeground(new Color(108, 194, 162));
        jButton2.setPreferredSize(buttonSize);
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        innerPanel.add(jButton2, gbc);

        jButton3 = new JButton("Edit Reservation");
        jButton3.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        jButton3.setForeground(new Color(108, 194, 162));
        jButton3.setPreferredSize(buttonSize);
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        innerPanel.add(jButton3, gbc);

        jButton4 = new JButton("Edit User Data");
        jButton4.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        jButton4.setForeground(new Color(108, 194, 162));
        jButton4.setPreferredSize(buttonSize);
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        innerPanel.add(jButton4, gbc);

        // Action listener for the "Edit User Data" button
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the EditUserData frame
                new EditUserData(); // This will open the EditUserData window
            }
        });

        GridBagConstraints outerGbc = new GridBagConstraints();
        outerGbc.gridx = 0;
        outerGbc.gridy = 0;
        outerGbc.anchor = GridBagConstraints.CENTER;
        outerPanel.add(innerPanel, outerGbc);

        frame.getContentPane().add(outerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserMenuFrame::new);
    }
}
