package src.View;

import java.awt.*;
import javax.swing.*;
import java.util.HashMap;
import src.Controller.DLSU_SRSUser_controller;
import src.Model.ShuttleBookingView;

public class UserSRSFRAME7_REGULAR extends FrameBackground {
    // UI components
    private JComboBox<String> lineComboBox;
    private JComboBox<String> originComboBox;
    private JComboBox<String> destinationComboBox;
    private DLSU_SRSUser_controller controller;

    // Map to store valid locations for each line
    private final HashMap<String, String[]> lineLocations = new HashMap<>();

    public UserSRSFRAME7_REGULAR(DLSU_SRSUser_controller controller) {
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
        createLabel("Origin:", (panelWidth - 80) / 2 - 200, 180, new Dimension(80, 40), new Font("Segoe UI", Font.PLAIN, 24), Color.BLACK);
        originComboBox = new JComboBox<>();
        originComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        originComboBox.setBounds((panelWidth - 400) / 2 + 80, 180, 300, 50);
        originComboBox.addActionListener(e -> validateOriginAndDestination());
        innerPanel.add(originComboBox);

        // Destination Label and ComboBox
        createLabel("Destination:", (panelWidth - 80) / 2 - 200, 260, new Dimension(80, 40), new Font("Segoe UI", Font.PLAIN, 24), Color.BLACK);
        destinationComboBox = new JComboBox<>();
        destinationComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        destinationComboBox.setBounds((panelWidth - 400) / 2 + 80, 260, 300, 50);
        destinationComboBox.addActionListener(e -> validateOriginAndDestination());
        innerPanel.add(destinationComboBox);

        // Initialize options based on the first line
        updateOriginAndDestinationOptions();

        // Submit Button
        createButton("SUBMIT", (panelWidth - 150) / 2 - 80, 350, 150, 50, e -> handleSubmitAction());

        // Back Button
        createButton("BACK", (panelWidth - 150) / 2 + 80, 350, 150, 50, e -> handleBackAction());

        innerPanel.revalidate();
        innerPanel.repaint();
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

    private void handleSubmitAction() {
        ShuttleBookingView booking = new ShuttleBookingView();
        
        String line = (String) lineComboBox.getSelectedItem();
        String origin = (String) originComboBox.getSelectedItem();
        String destination = (String) destinationComboBox.getSelectedItem();
        booking.setArrowsExpressLine(line); 
        booking.setOrigin(origin);
        booking.setDestination(destination);
        // Validate selections
        if (line == null || origin == null || destination == null) {
            JOptionPane.showMessageDialog(this,
                    "Please select all fields before submitting.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Reservation added:\nLine: " + line + "\nOrigin: " + origin + "\nDestination: " + destination,
                "Reservation Confirmation",
                JOptionPane.INFORMATION_MESSAGE);

        controller.SRSFRAME8_REGULAR_userController(booking);
    }

    private void handleBackAction() {
        this.dispose();
        controller.SRSFRAME4_ADDSHUTTLEBOOKING_userController();
    }
}
