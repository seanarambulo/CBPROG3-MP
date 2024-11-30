package src.View;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
import src.Controller.*;
import src.Model.*;

public class AdminSRSFRAME1_VIEWSHUTTLEROUTES extends TableFrame {

    private final DLSU_SRSAdmin_controller controller;
    private JTable reservationTable;
    private DefaultTableModel tableModel;
    private ArrayList<ShuttleBookingView> reservations;
    private JComboBox<String> lineComboBox;
    private JButton backButton, editButton;

    public AdminSRSFRAME1_VIEWSHUTTLEROUTES(DLSU_SRSAdmin_controller controller) {
        super();
        this.controller = controller;
        setDesignationTitle("View Shuttle Routes", 20, 0, 0, 0);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    public void initComponets() {

        // Panel for line label and combo box
        innerPanel.setLayout(null);
        JPanel linePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lineLabel = createLabel("Line:", 0, 0, new Dimension(50, 30), new Font("Arial", Font.PLAIN, 14), Color.BLACK);
        lineComboBox = new JComboBox<>(new String[] {"Line 1", "Line 2", "Line 3"}); // Example lines
        linePanel.add(lineLabel);
        linePanel.add(lineComboBox);
        linePanel.setBounds(50, 90, 600, 30); // Adjust bounds to avoid overlap
    
        // Initialize table using TableFrame methods
        tableModel = createTableModel(new String[] {"Time", "Route"});
        reservationTable = createReservationTable(tableModel);
        JScrollPane tableScrollPane = createScrollPane(reservationTable);
        tableScrollPane.setBounds(50, 120, 600, 250); // Adjust bounds to avoid overlap
    
        // Populate table with example data (optional)
        populateTable();
    
        // Panel for buttons
        backButton = configureButton("Back", new Font("Arial", Font.PLAIN, 14), Color.BLACK, 0, 0, new Dimension(80, 30), e -> {
            // Back button action
        });
        editButton = configureButton("Edit", new Font("Arial", Font.PLAIN, 14), Color.BLACK, 0, 0, new Dimension(80, 30), e -> {
            // Edit button action
        });
        buttonPanel.add(backButton);
        buttonPanel.add(editButton);
        buttonPanel.setBounds(50, 370, 600, 40); // Adjust bounds to avoid overlap
    
        // Add components to the inner panel
        innerPanel.setLayout(null);
        innerPanel.add(linePanel);
        innerPanel.add(tableScrollPane);
        innerPanel.add(buttonPanel);
    
        innerPanel.revalidate();
        innerPanel.repaint();

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

    @Override
    protected void loadReservations(DefaultTableModel tableModel, ArrayList<ShuttleBookingView> reservations) {
        // Load reservations from the database
    }

    @Override
    protected DefaultTableModel createTableModel(String[] columns) {
        return new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public static void main(String[] args) {
        new AdminSRSFRAME1_VIEWSHUTTLEROUTES(new DLSU_SRSAdmin_controller());
    }
}
