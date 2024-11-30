package src.View;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
import src.Controller.DLSU_SRSUser_controller;
import src.Model.*;

public class AdminSRSFRAME1_VIEWSHUTTLEROUTES extends FrameBackground {

    private final DLSU_SRSUser_controller controller;
    private JTable reservationTable;
    private DefaultTableModel tableModel;
    private ArrayList<ShuttleBookingView> reservations;
    private JComboBox<String> lineComboBox;
    private JButton backButton, editButton;

    public AdminSRSFRAME1_VIEWSHUTTLEROUTES(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;
        setDesignationTitle("View Shuttle Routes", 20, 0, 0, 0);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    public void initComponets() {

        // Panel for line label and combo box
        JPanel linePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lineLabel = new JLabel("Line:");
        lineComboBox = new JComboBox<>(new String[] {"Line 1", "Line 2", "Line 3"}); // Example lines
        linePanel.add(lineLabel);
        linePanel.add(lineComboBox);

        // Initialize table
        tableModel = new DefaultTableModel(new String[] {"Time", "Route"}, 0);
        reservationTable = new JTable(tableModel);
        reservationTable.setFillsViewportHeight(true);
        JScrollPane tableScrollPane = new JScrollPane(reservationTable);

        // Populate table with example data (optional)
        populateTable();

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButton = new JButton("Back");
        editButton = new JButton("Edit");
        buttonPanel.add(backButton);
        buttonPanel.add(editButton);

        // Add components to the frame
        add(linePanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

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

    public static void main(String[] args) {
        new AdminSRSFRAME1_VIEWSHUTTLEROUTES(new DLSU_SRSUser_controller());
    }
}
