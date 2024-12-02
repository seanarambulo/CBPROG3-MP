package src.View;

import java.awt.*;
import javax.swing.*;
import java.util.HashMap;
import src.Controller.DLSU_SRSUser_controller;
import src.Model.IrregReservation;

public class UserSRSFRAME9_IRREGULAR extends FrameBackground {
    // UI components
    private JComboBox<String> lineComboBox;
    private JComboBox<String> originComboBox;
    private JComboBox<String> destinationComboBox;
    private DLSU_SRSUser_controller controller;

    // Map to store valid locations for each line
    private final HashMap<String, String[]> lineLocations = new HashMap<>();

    public UserSRSFRAME9_IRREGULAR(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;

        // Initialize valid locations for each line
        lineLocations.put("MANILA<-->LAGUNA", new String[]{"MANILA", "LAGUNA"});
        lineLocations.put("PASEO<-->LAGUNA", new String[]{"PASEO", "LAGUNA"});
        lineLocations.put("CARMONA<-->LAGUNA", new String[]{"CARMONA", "LAGUNA"});
        lineLocations.put("PAVILION<-->LAGUNA", new String[]{"PAVILION", "LAGUNA"});
        lineLocations.put("WALTER<-->LAGUNA", new String[]{"WALTER", "LAGUNA"});

        setDesignationTitle("Add Reservation", 30, 0, 0, 0);
        SwingUtilities.invokeLater(() -> {
            initComponets();
        });
    }
// Reason Label and TextField
private JLabel reasonLabel;
private JTextField reasonTextField;

@Override
public void initComponets() {
    innerPanel.setLayout(null);

    int panelWidth = innerPanel.getWidth();

    // Line Label and ComboBox
    createLabel("Line:", (panelWidth - 80) / 2 - 200, 100, new Dimension(80, 40), new Font("Segoe UI", Font.PLAIN, 24), Color.BLACK);
    lineComboBox = new JComboBox<>(lineLocations.keySet().toArray(new String[0]));
    lineComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 24));
    lineComboBox.setBounds((panelWidth - 400) / 2 + 80, 100, 300, 50);
    lineComboBox.addActionListener(e -> updateOriginAndDestinationOptions());
    innerPanel.add(lineComboBox);

    // Origin Label and ComboBox
    createLabel("Origin:", (panelWidth - 80) / 2 - 200, 170, new Dimension(80, 40), new Font("Segoe UI", Font.PLAIN, 24), Color.BLACK);
    originComboBox = new JComboBox<>();
    originComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 24));
    originComboBox.setBounds((panelWidth - 400) / 2 + 80, 170, 300, 50);
    originComboBox.addActionListener(e -> validateOriginAndDestination());
    innerPanel.add(originComboBox);

    // Destination Label and ComboBox
    createLabel("Destination:", (panelWidth - 80) / 2 - 200, 240, new Dimension(80, 40), new Font("Segoe UI", Font.PLAIN, 24), Color.BLACK);
    destinationComboBox = new JComboBox<>();
    destinationComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 24));
    destinationComboBox.setBounds((panelWidth - 400) / 2 + 80, 240, 300, 50);
    destinationComboBox.addActionListener(e -> validateOriginAndDestination());
    innerPanel.add(destinationComboBox);

    // Reason Label and TextField
    reasonLabel = createLabel("Reason:", (panelWidth - 80) / 2 - 200, 310, new Dimension(80, 40), new Font("Segoe UI", Font.PLAIN, 24), Color.BLACK);
    innerPanel.add(reasonLabel);

    reasonTextField = new JTextField();
    reasonTextField.setFont(new Font("Segoe UI", Font.PLAIN, 11));
    reasonTextField.setBounds((panelWidth - 400) / 2 + 80, 310, 300, 50);
    innerPanel.add(reasonTextField);

    // Submit Button
    createButton("SUBMIT", (panelWidth - 150) / 2 - 80, 380, 150, 30, e -> handleSubmitAction());

    // Back Button
    createButton("BACK", (panelWidth - 150) / 2 + 80, 380, 150, 30, e -> handleBackAction());

    innerPanel.revalidate();
    innerPanel.repaint();
}

private void handleSubmitAction() {
    IrregReservation booking = new IrregReservation();

    String line = (String) lineComboBox.getSelectedItem();
    String origin = (String) originComboBox.getSelectedItem();
    String destination = (String) destinationComboBox.getSelectedItem();
    String reason = reasonTextField.getText();

    booking.setArrowsExpressLine(line);
    booking.setOrigin(origin);
    booking.setDestination(destination);
    booking.setReason(reason);
    // Validate selections and reason
    if (line == null || origin == null || destination == null || reason.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Please fill in all fields before submitting.",
                "Validation Error",
                JOptionPane.WARNING_MESSAGE);
        return;
    }

    JOptionPane.showMessageDialog(this,
            "Reservation added:\nLine: " + line + "\nOrigin: " + origin + "\nDestination: " + destination + "\nReason: " + reason,
            "Reservation Confirmation",
            JOptionPane.INFORMATION_MESSAGE);

    booking.setReason(reason); // Add reason to the booking
    controller.SRSFRAME8_IRREGULAR_userController(booking);
}

private void updateOriginAndDestinationOptions() {
    // Get selected line
    String selectedLine = (String) lineComboBox.getSelectedItem();
    if (selectedLine == null) return;

    // Get valid locations for the selected line
    String[] validLocations = lineLocations.get(selectedLine);

    // Update origin and destination combo boxes
    originComboBox.setModel(new DefaultComboBoxModel<>(validLocations));
    destinationComboBox.setModel(new DefaultComboBoxModel<>(validLocations));

    // Clear validation on update
    originComboBox.setSelectedIndex(-1);
    destinationComboBox.setSelectedIndex(-1);
}

private void validateOriginAndDestination() {
    // Ensure origin and destination are not the same
    String origin = (String) originComboBox.getSelectedItem();
    String destination = (String) destinationComboBox.getSelectedItem();

    if (origin != null && destination != null && origin.equals(destination)) {
        JOptionPane.showMessageDialog(this,
                "Origin and destination cannot be the same.",
                "Validation Error",
                JOptionPane.WARNING_MESSAGE);
        destinationComboBox.setSelectedIndex(-1); // Reset destination
    }
}
    private void handleBackAction() {
        this.dispose();
        controller.SRSFRAME4_ADDSHUTTLEBOOKING_userController();
    }
}
