package src.View;

import java.awt.*;
import javax.swing.*;
import src.Controller.DLSU_SRSUser_controller;

public class UserSRSFRAME9_IRREGULAR {
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

    private UserSRSFRAME9_IRREGULAR(DLSU_SRSUser_controller controller) {
        JFrame frame = new JFrame("Irregular Booking Shuttle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(810, 530);
        frame.setResizable(false); // Make the frame non-resizable
        frame.setLayout(new BorderLayout());

        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(new Color(108, 194, 162));
        outerPanel.setLayout(null); // Use null layout for absolute positioning
        outerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(new Color(53, 95, 79));
        innerPanel.setLayout(null); // Use null layout for absolute positioning
        innerPanel.setPreferredSize(new Dimension(710, 430)); // Set preferred size to make the panel larger

        designationTitle = new JLabel("Irregular Booking Shuttle");
        designationTitle.setFont(new Font("Baskerville", Font.PLAIN, 36));
        designationTitle.setForeground(Color.WHITE);
        designationTitle.setHorizontalAlignment(JLabel.CENTER);
        designationTitle.setBounds(150, 20, 500, 50);
        innerPanel.add(designationTitle);

        lineLabel = new JLabel("Line:");
        lineLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lineLabel.setForeground(Color.WHITE);
        lineLabel.setBounds(150, 100, 100, 30);
        innerPanel.add(lineLabel);

        lineComboBox = new JComboBox<>(new String[]{"Line 1", "Line 2", "Line 3"});
        lineComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lineComboBox.setBounds(300, 100, 200, 30);
        innerPanel.add(lineComboBox);

        dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setBounds(150, 150, 100, 30);
        innerPanel.add(dateLabel);

        dateComboBox = new JComboBox<>(new String[]{"2024-11-16", "2024-11-17", "2024-11-18"});
        dateComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        dateComboBox.setBounds(300, 150, 200, 30);
        innerPanel.add(dateComboBox);

        timeLabel = new JLabel("Time:");
        timeLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setBounds(150, 200, 100, 30);
        innerPanel.add(timeLabel);

        timeComboBox = new JComboBox<>(new String[]{"8:00 AM", "12:00 PM", "6:00 PM"});
        timeComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        timeComboBox.setBounds(300, 200, 200, 30);
        innerPanel.add(timeComboBox);

        reasonLabel = new JLabel("Reason:");
        reasonLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        reasonLabel.setForeground(Color.WHITE);
        reasonLabel.setBounds(150, 250, 100, 30);
        innerPanel.add(reasonLabel);

        reasonTextArea = new JTextArea(5, 20); // Set the JTextArea to be taller
        reasonTextArea.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        reasonTextArea.setLineWrap(true);
        reasonTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(reasonTextArea);
        scrollPane.setBounds(300, 250, 200, 100);
        innerPanel.add(scrollPane);

        submitButton = new JButton("Back");
        submitButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        submitButton.setBounds(150, 400, 100, 30);
        innerPanel.add(submitButton);

        backButton = new JButton("Submit");
        backButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        backButton.setBounds(300, 400, 100, 30);
        innerPanel.add(backButton);

        outerPanel.add(innerPanel);
        frame.getContentPane().add(outerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
