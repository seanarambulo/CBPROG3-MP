import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DispatcherMenu1Frame {

    private JLabel titleLabel;
    private JLabel lineLabel;
    private JComboBox<String> lineComboBox;
    private JLabel dateLabel;
    private JComboBox<String> dateComboBox;
    private JLabel designationTitle;
    private JButton submitButton;
    private JButton backButton;
    private JComboBox<String> timeComboBox;
    private JLabel timeLabel;

    private ArrayList<String> lineList;
    private ArrayList<String> dateList;
    private ArrayList<String> timeList;

    public DispatcherMenu1Frame(DLSU_SRSDispatcher_controller Dcontroller) {
        initComponents(Dcontroller);
    }

    private void initComponents(DLSU_SRSDispatcher_controller Dcontroller) {
        // Initialize ArrayLists for ComboBox items
        lineList = new ArrayList<>();
        dateList = new ArrayList<>();
        timeList = new ArrayList<>();

        // Populate Line and Time lists
        lineList.add("Line 1");
        lineList.add("PASEO<-->DLSU-LC");
        lineList.add("Line 3");

        timeList.add("10:00 AM");
        timeList.add("12:00 PM");
        timeList.add("6:00 PM");

        // Populate Date list (3 weeks ahead, excluding Sundays)
        populateDateComboBox();

        // Convert ArrayLists to ComboBox items
        lineComboBox = new JComboBox<>(lineList.toArray(new String[0]));
        dateComboBox = new JComboBox<>(dateList.toArray(new String[0]));
        timeComboBox = new JComboBox<>(timeList.toArray(new String[0]));

        JFrame frame = new JFrame("Dispatcher Menu");
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

        designationTitle = new JLabel("DLSU Shuttle Reservation");
        designationTitle.setFont(new Font("Baskerville", Font.PLAIN, 36));
        designationTitle.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        innerPanel.add(designationTitle, gbc);

        titleLabel = new JLabel("Dispatcher Menu");
        titleLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        innerPanel.add(titleLabel, gbc);

        lineLabel = new JLabel("Line:");
        lineLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lineLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(lineLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(lineComboBox, gbc);

        dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        dateLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(dateLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(dateComboBox, gbc);

        timeLabel = new JLabel("Time:");
        timeLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        timeLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(timeLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(timeComboBox, gbc);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(submitButton, gbc);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(backButton, gbc);

        // Add ActionListener to Submit Button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Dcontroller.DispatcherCheckReservation((String) lineComboBox.getSelectedItem(),
                        (String) dateComboBox.getSelectedItem(),
                        (String) timeComboBox.getSelectedItem());
            }
        });

        // Add ActionListener to Back Button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current frame
                System.out.println("Back button clicked. Returning to the previous menu.");
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

    private void populateDateComboBox() {
        // Formatter for the dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Get today's date
        LocalDate today = LocalDate.now();

        // Iterate through the next 21 days
        for (int i = 0; i < 21; i++) {
            LocalDate date = today.plusDays(i);
            // Check if the day is not Sunday
            if (!date.getDayOfWeek().name().equals("SUNDAY")) {
                dateList.add(date.format(formatter));
            }
        }
    }
}
