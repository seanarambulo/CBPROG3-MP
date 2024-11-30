package src.View;

import java.awt.*;
import javax.swing.*;
import src.Controller.DLSU_SRSUser_controller;

public class UserSRSFRAME9_IRREGULAR extends FrameBackground {
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
    private DLSU_SRSUser_controller controller;

    public UserSRSFRAME9_IRREGULAR(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;
        setDesignationTitle("Irregular Booking Shuttle", 20, 0, 0, 0);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    public void initComponets() {
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

        innerPanel.revalidate();
        innerPanel.repaint();
    }
}
