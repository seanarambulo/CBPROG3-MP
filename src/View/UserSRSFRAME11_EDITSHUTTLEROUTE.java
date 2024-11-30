package src.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import src.Controller.DLSU_SRSUser_controller;
import src.Model.*;

public class UserSRSFRAME11_VIEWSHUTTLEROUTES extends FrameBackground {

    private final DLSU_SRSUser_controller controller;
    private JTable reservationTable;
    private DefaultTableModel tableModel;
    private ArrayList<ShuttleBookingView> reservations;
    private JComboBox<String> lineComboBox;
    private JButton backButton, deleteButton, addButton;
    private JTextField timeTextField, routeTextField;

    public UserSRSFRAME10_VIEWSHUTTLEROUTES(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;
        SwingUtilities.invokeLater(this::initComponents);
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel for line, time, and route inputs
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Line label and combo box
        JLabel lineLabel = new JLabel("Line:");
        lineComboBox = new JComboBox<>(new String[]{"Line 1", "Line 2", "Line 3", "Line 4", "Line 5"});
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(lineLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(lineComboBox, gbc);

        // Time label and text field
        JLabel timeLabel = new JLabel("Time:");
        timeTextField = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(timeLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(timeTextField, gbc);

        // Route label and text field
        JLabel routeLabel = new JLabel("Route:");
        routeTextField = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(routeLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(routeTextField, gbc);

        // Initialize table
        tableModel = new DefaultTableModel(new String[]{"Time", "Route"}, 0);
        reservationTable = new JTable(tableModel);
        reservationTable.setFillsViewportHeight(true);
        JScrollPane tableScrollPane = new JScrollPane(reservationTable);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButton = new JButton("Back");
        deleteButton = new JButton("Delete");
        addButton = new JButton("Add");
        buttonPanel.add(backButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(addButton);

        // Add action listeners for buttons
        addButton.addActionListener(e -> addReservation());
        deleteButton.addActionListener(e -> deleteReservation());
        backButton.addActionListener(e -> {
            this.dispose();
            controller.UserSRSFRAME10_VIEWSHUTTLEROUTES();
            });

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set frame properties
        setTitle("View Shuttle Routes");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void populateTable() {
        // Example data
        String[][] exampleData = {
            {"08:00 AM", "Route A"},
            {"09:00 AM", "Route B"},
            {"10:00 AM", "Route C"}
        };

        for (String[] row : exampleData) {
            tableModel.addRow(row);
        }
    }

    private void addReservation() {
        // Get input from text fields
        String time = timeTextField.getText();
        String route = routeTextField.getText();

        // Validate input
        if (time.isEmpty() || route.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in both Time and Route fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Add new reservation to the table
        tableModel.addRow(new String[]{time, route});

        // Clear text fields
        timeTextField.setText("");
        routeTextField.setText("");
    }

    private void deleteReservation() {
        // Get selected row
        int selectedRow = reservationTable.getSelectedRow();

        // Check if a row is selected
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a reservation to delete.", "Delete Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Remove selected row
        tableModel.removeRow(selectedRow);
    }
}
