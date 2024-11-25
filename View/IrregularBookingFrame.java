import javax.swing.*;
import java.awt.*;

public class IrregularBookingFrame{

    private JLabel designationTitle;
    private JLabel lineLabel;
    private JComboBox<String> lineComboBox;
    private JLabel dateLabel;
    private JComboBox<String> dateComboBox;
    private JLabel timeLabel;
    private JComboBox<String> timeComboBox;
    private JLabel reasonLabel;
    private JTextArea reasonTextArea;
    private JButton submitButton;
    private JButton backButton;

    public IrregularBookingFrame() {
        initComponents();
    }

    private void initComponents() {
        JFrame frame = new JFrame("Irregular Booking Shuttle");
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

        designationTitle = new JLabel("Irregular Booking Shuttle");
        designationTitle.setFont(new Font("Baskerville", Font.PLAIN, 36));
        designationTitle.setForeground(Color.WHITE);
        designationTitle.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        innerPanel.add(designationTitle, gbc);

        lineLabel = new JLabel("Line:");
        lineLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lineLabel.setForeground(Color.WHITE);
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(lineLabel, gbc);

        lineComboBox = new JComboBox<>(new String[]{"Line 1", "Line 2", "Line 3"});
        lineComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(lineComboBox, gbc);

        dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        dateLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(dateLabel, gbc);

        dateComboBox = new JComboBox<>(new String[]{"2024-11-16", "2024-11-17", "2024-11-18"});
        dateComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(dateComboBox, gbc);

        timeLabel = new JLabel("Time:");
        timeLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        timeLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(timeLabel, gbc);

        timeComboBox = new JComboBox<>(new String[]{"8:00 AM", "12:00 PM", "6:00 PM"});
        timeComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(timeComboBox, gbc);

        reasonLabel = new JLabel("Reason:");
        reasonLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        reasonLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(reasonLabel, gbc);

        reasonTextArea = new JTextArea(5, 20); // Set the JTextArea to be taller
        reasonTextArea.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        reasonTextArea.setLineWrap(true);
        reasonTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(reasonTextArea);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(scrollPane, gbc);

        submitButton = new JButton("Back");
        submitButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(submitButton, gbc);

        backButton = new JButton("Submit");
        backButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(backButton, gbc);

        GridBagConstraints outerGbc = new GridBagConstraints();
        outerGbc.gridx = 0;
        outerGbc.gridy = 0;
        outerGbc.anchor = GridBagConstraints.CENTER;
        outerPanel.add(innerPanel, outerGbc);

        frame.getContentPane().add(outerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(IrregularBookingFrame::new);
    }
}
