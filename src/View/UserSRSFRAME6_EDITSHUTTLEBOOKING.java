package src.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import src.Controller.DLSU_SRSUser_controller;
import src.Model.ShuttleBookingView;

public class UserSRSFRAME6_EDITSHUTTLEBOOKING extends FrameBackground {
    
    private DefaultTableModel tableModel;
    private JLabel lineLabel;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JLabel originLabel;
    private JLabel originValueLabel;
    private JLabel destinationLabel;
    private JComboBox<String> lineComboBox;
    private JComboBox<String> dateComboBox;
    private JComboBox<String> timeComboBox;
    private JComboBox<String> destinationBox;
    private DLSU_SRSUser_controller controller;

    private int selectedRow;
    private ShuttleBookingView selectedReservation;

    public UserSRSFRAME6_EDITSHUTTLEBOOKING(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;
        this.selectedReservation = controller.getShuttleBookingView();
        SwingUtilities.invokeLater(() -> initComponets());
    }
    
    @Override
    public void initComponets(){
        String[] shuttleLines = {"MNL<->LAG"};
        String[] destinations = {"MNL", "LAG"};
        String[] dates = {"2021-10-01", "2021-10-02", "2021-10-03", "2021-10-04", "2021-10-05"};
        String[] LagunaDepartureTimes = {"5:45", "6:15", "7:00", "8:00", "9:00", "11:00", "1:00", "2:30", "3:30", "5:10", "6:15", "7:45"};
        String[] ManilaDepartureTimes = {"6:00", "7:30", "9:30", "11:00", "1:00", "2:30", "3:30", "5:10", "6:15", "7:45"};
    
        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(new Color(108, 194, 162));
        outerPanel.setLayout(new GridBagLayout()); // Use GridBagLayout to center innerPanel
        outerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(new Color(53, 95, 79));
        innerPanel.setLayout(null);
        innerPanel.setPreferredSize(new Dimension(600, 400)); // Set preferred size to make the panel larger

        lineLabel = new JLabel("Shuttle Line:");
        lineLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lineLabel.setForeground(Color.WHITE);
        lineLabel.setBounds(50, 50, 150, 30);
        innerPanel.add(lineLabel);

        lineComboBox = new JComboBox<>(shuttleLines);
        lineComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lineComboBox.setBounds(200, 50, 200, 30);
        innerPanel.add(lineComboBox);

        dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setBounds(50, 100, 150, 30);
        innerPanel.add(dateLabel);

        dateComboBox = new JComboBox<>(dates);
        dateComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        dateComboBox.setBounds(200, 100, 200, 30);
        innerPanel.add(dateComboBox);

        timeLabel = new JLabel("Time:");
        timeLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setBounds(50, 150, 150, 30);
        innerPanel.add(timeLabel);

        timeComboBox = new JComboBox<>();
        timeComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        timeComboBox.setBounds(200, 150, 200, 30);
        innerPanel.add(timeComboBox);

        originLabel = new JLabel("Origin:");
        originLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        originLabel.setForeground(Color.WHITE);
        originLabel.setBounds(50, 200, 150, 30);
        innerPanel.add(originLabel);

        originValueLabel = new JLabel(selectedReservation.getOrigin());
        originValueLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        originValueLabel.setForeground(Color.WHITE);
        originValueLabel.setBounds(200, 200, 200, 30);
        innerPanel.add(originValueLabel);

        destinationLabel = new JLabel("Destination:");
        destinationLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        destinationLabel.setForeground(Color.WHITE);
        destinationLabel.setBounds(50, 250, 150, 30);
        innerPanel.add(destinationLabel);
    
        destinationBox = new JComboBox<>(destinations);
        destinationBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        destinationBox.setBounds(200, 250, 200, 30);
        innerPanel.add(destinationBox);

        // Set initial values from selectedReservation
        lineComboBox.setSelectedItem(selectedReservation.getArrowsExpressLine());
        dateComboBox.setSelectedItem(selectedReservation.getDate());
        destinationBox.setSelectedItem(selectedReservation.getDestination());
        updateTimeComboBox(timeComboBox, LagunaDepartureTimes, ManilaDepartureTimes);
        timeComboBox.setSelectedItem(selectedReservation.getTime());

        // Add ActionListener to destinationBox to update the origin label
        destinationBox.addActionListener(e -> {
            String selectedDestination = (String) destinationBox.getSelectedItem();
            if ("MNL".equals(selectedDestination)) {
                originValueLabel.setText("LAG");
            } else if ("LAG".equals(selectedDestination)) {
                originValueLabel.setText("MNL");
            }
            updateTimeComboBox(timeComboBox, LagunaDepartureTimes, ManilaDepartureTimes);
        });

        int result = JOptionPane.showConfirmDialog(null, innerPanel, "Edit Reservation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            // Update the table model with the new values
            tableModel.setValueAt(lineComboBox.getSelectedItem(), selectedRow, 1);
            tableModel.setValueAt(dateComboBox.getSelectedItem(), selectedRow, 2);
            tableModel.setValueAt(timeComboBox.getSelectedItem(), selectedRow, 3);
            tableModel.setValueAt(originValueLabel.getText(), selectedRow, 4);
            tableModel.setValueAt(destinationBox.getSelectedItem(), selectedRow, 5);
        }
    }
    
    private void updateTimeComboBox(JComboBox<String> timeComboBox, String[] LagunaDepartureTimes, String[] ManilaDepartureTimes) {
        switch (originValueLabel.getText()) {
            case "LAG" -> timeComboBox.setModel(new DefaultComboBoxModel<>(LagunaDepartureTimes));
            case "MNL" -> timeComboBox.setModel(new DefaultComboBoxModel<>(ManilaDepartureTimes));
            default -> timeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{}));
        }
    }
}