package src.View;

import java.awt.*;
import javax.swing.*;
import src.Controller.DLSU_SRSUser_controller;

public class UserSRSFRAME7_REGULAR extends FrameBackground {
    // UI components
    private JComboBox<String> lineComboBox;
    private JComboBox<String> dateComboBox;
    private JComboBox<String> timeComboBox;
    private JLabel lineLabel;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private DLSU_SRSUser_controller controller;

    public UserSRSFRAME7_REGULAR(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;
        setDesignationTitle("Add Reservation", 30, 0, 0, 0);
        SwingUtilities.invokeLater(() -> {
            initComponets();
        });
    }

    @Override
    public void initComponets() {
        innerPanel.setLayout(null);

        int panelWidth = innerPanel.getWidth();

        // Line Label and ComboBox
        lineLabel = new JLabel("Line:");
        lineLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        lineLabel.setBounds((panelWidth - 80) / 2 - 200, 100, 80, 40); // Adjusted vertically
        innerPanel.add(lineLabel);

        lineComboBox = new JComboBox<>(new String[]{"Line 1", "Line 2", "Line 3"});
        lineComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        lineComboBox.setBounds((panelWidth - 400) / 2 + 80, 100, 400, 50); // Wider and centered horizontally
        lineComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setVerticalAlignment(SwingConstants.CENTER);
                return label;
            }
        });
        innerPanel.add(lineComboBox);

        // Date Label and ComboBox
        dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        dateLabel.setBounds((panelWidth - 80) / 2 - 200, 180, 80, 40); // Adjusted vertically
        innerPanel.add(dateLabel);

        dateComboBox = new JComboBox<>(new String[]{"2024-11-16", "2024-11-17", "2024-11-18"});
        dateComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        dateComboBox.setBounds((panelWidth - 400) / 2 + 80, 180, 400, 50); // Wider and centered horizontally
        dateComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setVerticalAlignment(SwingConstants.CENTER);
                return label;
            }
        });
        innerPanel.add(dateComboBox);

        // Time Label and ComboBox
        timeLabel = new JLabel("Time:");
        timeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        timeLabel.setBounds((panelWidth - 80) / 2 - 200, 260, 80, 40); // Adjusted vertically
        innerPanel.add(timeLabel);

        timeComboBox = new JComboBox<>(new String[]{"8:00 AM", "12:00 PM", "6:00 PM"});
        timeComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        timeComboBox.setBounds((panelWidth - 400) / 2 + 80, 260, 400, 50); // Wider and centered horizontally
        timeComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setVerticalAlignment(SwingConstants.CENTER);
                return label;
            }
        });
        innerPanel.add(timeComboBox);

        // Submit Button
        createButton("SUBMIT", (panelWidth - 150) / 2 - 80, 350, 150, 50, e -> handleSubmitAction()); // Adjusted vertically

        // Back Button
        createButton("BACK", (panelWidth - 150) / 2 + 80, 350, 150, 50, e -> handleBackAction()); // Adjusted vertically

        innerPanel.revalidate();
        innerPanel.repaint();
    }

    private void handleSubmitAction() {
        String line = (String) lineComboBox.getSelectedItem();
        String date = (String) dateComboBox.getSelectedItem();
        String time = (String) timeComboBox.getSelectedItem();

        JOptionPane.showMessageDialog(this,
                "Reservation added:\nLine: " + line + "\nDate: " + date + "\nTime: " + time,
                "Reservation Confirmation",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleBackAction() {
        this.dispose();
        controller.SRSFRAME4_ADDSHUTTLEBOOKING_userController();
        // You can close this frame or perform other actions here
    }
}
