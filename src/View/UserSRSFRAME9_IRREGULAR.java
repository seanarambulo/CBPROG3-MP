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

        createLabel("Line:", 150, 100, new Dimension(100, 30), new Font("Helvetica Neue", Font.PLAIN, 20), Color.WHITE);
        lineComboBox = new JComboBox<>(new String[]{"Line 1", "Line 2", "Line 3"});
        lineComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lineComboBox.setBounds(300, 100, 200, 30);
        innerPanel.add(lineComboBox);

        createLabel("Date:", 150, 150, new Dimension(100, 30), new Font("Helvetica Neue", Font.PLAIN, 20), Color.WHITE);
        dateComboBox = new JComboBox<>(new String[]{"2024-11-16", "2024-11-17", "2024-11-18"});
        dateComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        dateComboBox.setBounds(300, 150, 200, 30);
        innerPanel.add(dateComboBox);

        createLabel("Time:", 150, 200, new Dimension(100, 30), new Font("Helvetica Neue", Font.PLAIN, 20), Color.WHITE);
        timeComboBox = new JComboBox<>(new String[]{"8:00 AM", "12:00 PM", "6:00 PM"});
        timeComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        timeComboBox.setBounds(300, 200, 200, 30);
        innerPanel.add(timeComboBox);

        createLabel("Reason:", 150, 250, new Dimension(100, 30), new Font("Helvetica Neue", Font.PLAIN, 20), Color.WHITE);
        reasonTextArea = new JTextArea(5, 20);
        reasonTextArea.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        reasonTextArea.setLineWrap(true);
        reasonTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(reasonTextArea);
        scrollPane.setBounds(300, 250, 200, 100);
        innerPanel.add(scrollPane);

        createButton("Back", 150, 400, 100, 30, e -> handleBackAction());
        createButton("Submit", 300, 400, 100, 30, e -> handleSubmitAction());

        innerPanel.revalidate();
        innerPanel.repaint();
    }

    private void handleBackAction() {
        // Handle back action
    }

    private void handleSubmitAction() {
        // Handle submit action
    }
}
