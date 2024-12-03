
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


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
    private JButton saveButton;
    private JButton cancelButton;

    private int selectedRow;
    private ShuttleBookingView selectedReservation;

    public UserSRSFRAME6_EDITSHUTTLEBOOKING(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;
        this.selectedReservation = controller.getShuttleBookingView();
        setDesignationTitle("Shuttle Line", 30,0,0,0);
        SwingUtilities.invokeLater(() -> initComponets());
    }
    
    @Override
    public void initComponets() {

        innerPanel.setLayout(null);
        String[] shuttleLines = {"MNL<->LAG"};
        String[] destinations = {"MNL", "LAG"};
        String[] dates = {"2021-10-01", "2021-10-02", "2021-10-03", "2021-10-04", "2021-10-05"};
        String[] LagunaDepartureTimes = {"5:45", "6:15", "7:00", "8:00", "9:00", "11:00", "1:00", "2:30", "3:30", "5:10", "6:15", "7:45"};
        String[] ManilaDepartureTimes = {"6:00", "7:30", "9:30", "11:00", "1:00", "2:30", "3:30", "5:10", "6:15", "7:45"};
    
        Dimension size = new Dimension(150, 30);
        Font font = new Font("Helvetica Neue", Font.PLAIN, 20);
        int panelWidth = innerPanel.getWidth();
        int xPosition = (panelWidth - 350) / 2; // Adjusted to center the components
        int yPosition = 130; // Starting y position, shifted downward
        int yOffset = 60; // Vertical space between components

        lineLabel = createLabel("Line:", xPosition, yPosition, size, font, Color.WHITE);
        lineComboBox = new JComboBox<>(shuttleLines);
        lineComboBox.setFont(font);
        lineComboBox.setBounds(xPosition + 150, yPosition, 200, 30);
        innerPanel.add(lineLabel);
        innerPanel.add(lineComboBox);

        yPosition += yOffset;
        dateLabel = createLabel("Date:", xPosition, yPosition, size, font, Color.WHITE);
        dateComboBox = new JComboBox<>(dates);
        dateComboBox.setFont(font);
        dateComboBox.setBounds(xPosition + 150, yPosition, 200, 30);
        innerPanel.add(dateLabel);
        innerPanel.add(dateComboBox);

        yPosition += yOffset;
        timeLabel = createLabel("Time:", xPosition, yPosition, size, font, Color.WHITE);
        timeComboBox = new JComboBox<>();
        timeComboBox.setFont(font);
        timeComboBox.setBounds(xPosition + 150, yPosition, 200, 30);
        innerPanel.add(timeLabel);
        innerPanel.add(timeComboBox);

        yPosition += yOffset;
        originLabel = createLabel("Origin:", xPosition, yPosition, size, font, Color.WHITE);
        originValueLabel = createLabel(selectedReservation.getOrigin(), xPosition + 150, yPosition, new Dimension(200, 30), font, Color.WHITE);
        innerPanel.add(originLabel);
        innerPanel.add(originValueLabel);

        yPosition += yOffset;
        destinationLabel = createLabel("Destination:", xPosition, yPosition, size, font, Color.WHITE);
        destinationBox = new JComboBox<>(destinations);
        destinationBox.setFont(font);
        destinationBox.setBounds(xPosition + 150, yPosition, 200, 30);
        innerPanel.add(destinationLabel);
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

        saveButton = new JButton("Save");
        saveButton.setFont(font);
        saveButton.setBounds(xPosition, yPosition + yOffset, 120, 40); // Adjusted size
        innerPanel.add(saveButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(font);
        cancelButton.setBounds(xPosition + 150, yPosition + yOffset, 120, 40); // Adjusted size
        innerPanel.add(cancelButton);

        saveButton.addActionListener(e -> {
            // Update the table model with the new values
            tableModel.setValueAt(lineComboBox.getSelectedItem(), selectedRow, 1);
            tableModel.setValueAt(dateComboBox.getSelectedItem(), selectedRow, 2);
            tableModel.setValueAt(timeComboBox.getSelectedItem(), selectedRow, 3);
            tableModel.setValueAt(originValueLabel.getText(), selectedRow, 4);
            tableModel.setValueAt(destinationBox.getSelectedItem(), selectedRow, 5);
            JOptionPane.showMessageDialog(null, "Reservation updated successfully!");
        });

        cancelButton.addActionListener(e -> {
            // Close the dialog or perform any necessary cleanup
            JOptionPane.showMessageDialog(null, "Edit cancelled.");
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