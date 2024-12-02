package src.View;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
import src.Controller.*;
import src.Model.*;

public class AdminSRSFRAME4_VIEWSHUTTLEROUTES extends TableFrame {

    private final DLSU_SRSAdmin_controller controller;
    private ArrayList<ShuttleBookingView> reservations;
    private JComboBox<String> lineComboBox;
    private JButton backButton, editButton;

    public AdminSRSFRAME4_VIEWSHUTTLEROUTES(DLSU_SRSAdmin_controller controller) {
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
        this.tableModel = createTableModel(new String[] {"Time", "Route"});
        this.reservationTable = createReservationTable(tableModel);
        this.scrollPane = createScrollPane(reservationTable);
        this.scrollPane.setBounds(50, 120, 600, 250); // Adjust bounds to avoid overlap
    
        // Populate table with example data (optional)
        populateTable();
    
        // Panel for buttons
        backButton = configureButton("Back", new Font("Helvetica Neue", Font.PLAIN, 14), Color.BLACK, 0, 0, new Dimension(80, 30), e -> {
            this.dispose();
            controller.AdminSRSFRAME1_Menu_AdminController();
        });
        editButton = configureButton("Edit", new Font("Helvetica Neue", Font.PLAIN, 14), Color.BLACK, 0, 0, new Dimension(80, 30), e -> {
            // Edit button action
        });
        buttonPanel.add(backButton);
        buttonPanel.add(editButton);
        buttonPanel.setBounds(50, 370, 600, 40); // Adjust bounds to avoid overlap
    
        // Add components to the inner panel
        innerPanel.setLayout(null);
        innerPanel.add(linePanel);
        innerPanel.add(this.scrollPane);
        innerPanel.add(buttonPanel);
    
        innerPanel.revalidate();
        innerPanel.repaint();

    }

    private void populateTable() {
        // Example data
        String[][] exampleData = {
            {"08:00 AM", "Route A"},
            {"09:00 AM", "Route B"},
            {"10:00 AM", "Route C"},
            {"11:00 AM", "Route D"},
            {"12:00 PM", "Route E"},
            {"01:00 PM", "Route F"},
            {"02:00 PM", "Route G"},
            {"03:00 PM", "Route H"},
            {"04:00 PM", "Route I"},
            {"05:00 PM", "Route J"}
        };

        for (String[] row : exampleData) {
            tableModel.addRow(row);
        }
    }

    @Override
    protected void loadObjects(DefaultTableModel tableModel, ArrayList<?> reservations) {
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

}
