package src.View;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;
import src.Controller.DLSU_SRSAdmin_controller;

public class AdminSRSFRAME3_VIEWRESERVATIONS extends FrameBackground {

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
    private DLSU_SRSAdmin_controller Acontroller;

    private ArrayList<String> lineList;
    private ArrayList<String> dateList;
    private ArrayList<String> timeList;

    public AdminSRSFRAME3_VIEWRESERVATIONS(DLSU_SRSAdmin_controller Acontroller) {
        super();
        this.Acontroller = Acontroller;
        initComponets();
    }

    @Override
    protected void initComponets() {
        // Initialize ArrayLists for ComboBox items
        lineList = new ArrayList<>();
        dateList = new ArrayList<>();
        timeList = new ArrayList<>();

        // Populate Line list
        lineList.add("DLSU-MNL<-->DLSU-LC");
        lineList.add("PASEO<-->LAGUNA");
        lineList.add("Line 3");

        // Populate Date list (3 weeks ahead, excluding Sundays)
        populateDateComboBox();

        // Convert ArrayLists to ComboBox items
        lineComboBox = new JComboBox<>(lineList.toArray(new String[0]));
        dateComboBox = new JComboBox<>(dateList.toArray(new String[0]));
        timeComboBox = new JComboBox<>();

        // Add ActionListener to Line ComboBox to update Time ComboBox
        lineComboBox.addActionListener(e -> updateTimeComboBox());

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
        submitButton.addActionListener(e -> {
            frame.dispose();
            Acontroller.AdminCheckReservation((String) lineComboBox.getSelectedItem(),
                    (String) dateComboBox.getSelectedItem(),
                    (String) timeComboBox.getSelectedItem());
        });

        // Add ActionListener to Back Button
        backButton.addActionListener(e -> {
            frame.dispose(); // Close the current frame
            System.out.println("Back button clicked. Returning to the previous menu.");
        });

        GridBagConstraints outerGbc = new GridBagConstraints();
        outerGbc.gridx = 0;
        outerGbc.gridy = 0;
        outerGbc.anchor = GridBagConstraints.CENTER;
        outerPanel.add(innerPanel, outerGbc);

        frame.getContentPane().add(outerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void updateTimeComboBox() {
        String selectedLine = (String) lineComboBox.getSelectedItem();
        if (selectedLine != null) {
            timeList = Acontroller.getTimesForLine(selectedLine); // Fetch times dynamically
            timeComboBox.removeAllItems(); // Clear existing items
            for (String time : timeList) {
                timeComboBox.addItem(time); // Add new items
            }
        }
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
