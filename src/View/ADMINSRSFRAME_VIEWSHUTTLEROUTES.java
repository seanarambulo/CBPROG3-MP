
package src.View;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import src.Controller.DLSU_SRSAdmin_controller;

public class ADMINSRSFRAME_VIEWSHUTTLEROUTES extends JFrame {

    private JTable reservationTable;
    private DefaultTableModel tableModel;
    private JComboBox<String> lineComboBox;
    private JButton backButton, editButton;

    protected DLSU_SRSAdmin_controller Acontroller;
    protected ArrayList<String> times;

    public ADMINSRSFRAME_VIEWSHUTTLEROUTES(DLSU_SRSAdmin_controller Acontroller, ArrayList<String> times) {
        this.Acontroller = Acontroller;
        this.times = times;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel for line label and combo box
        JPanel linePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lineLabel = new JLabel("Line:");
        lineComboBox = new JComboBox<>(new String[] {
            "MANILA<-->LAGUNA",
            "PASEO<-->LAGUNA",
            "CARMONA<-->LAGUNA",
            "PAVILION<-->LAGUNA",
            "WALTER<-->LAGUNA"
        });
        linePanel.add(lineLabel);
        linePanel.add(lineComboBox);

        // Add an ActionListener to the combo box for refreshing the table
        lineComboBox.addActionListener(e -> {
            String selectedLine = (String) lineComboBox.getSelectedItem();
            if (selectedLine != null) {
                refreshTable(selectedLine);
            }
        });

        // Initialize table
        tableModel = new DefaultTableModel(new String[] {"Time"}, 0);
        reservationTable = new JTable(tableModel);
        reservationTable.setFillsViewportHeight(true);
        JScrollPane tableScrollPane = new JScrollPane(reservationTable);

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

        // Set frame properties
        setTitle("View Shuttle Booking");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Action listeners for buttons
        backButton.addActionListener(e -> {
            this.dispose(); 
            Acontroller.AdminSRSFRAME1_Menu_AdminController();
        });
/*
        editButton.addActionListener(e -> {
            // Create and show the UserSRSFRAME11_VIEWSHUTTLEROUTES frame when the Edit button is clicked
            // new ADMINSRSFRAME_EDITSHUTTLEROUTES();
            // this.dispose(); // Close the current frame (optional)
        });

        */

        // Populate table initially
        populateTable();
    }

    private void populateTable() {
        // Clear any existing rows
        tableModel.setRowCount(0);

        // Add rows from the times ArrayList
        for (String time : times) {
            tableModel.addRow(new Object[] {time});
        }
    }

    private void refreshTable(String lineName) {
        try {
            // Call the controller method to update the times list
            this.dispose();
            Acontroller.ADMINSRSFRAME_VIEWSHUTTLEROUTES(lineName);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to refresh table: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // This method is called by the controller after it updates the times
    public void updateTimes(ArrayList<String> newTimes) {
        this.times = newTimes;
        populateTable(); // Refresh the table with the new data
    }
}
