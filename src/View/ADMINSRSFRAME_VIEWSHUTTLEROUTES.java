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
    private JTextField timeTextField;
    private JButton backButton, deleteButton, addButton;

    protected DLSU_SRSAdmin_controller Acontroller;
    protected ArrayList<String> times;

    public ADMINSRSFRAME_VIEWSHUTTLEROUTES(DLSU_SRSAdmin_controller Acontroller, ArrayList<String> times) {
        this.Acontroller = Acontroller;
        this.times = times;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel for line label, combo box, and time input
        JPanel linePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lineLabel = new JLabel("Line:");
        lineComboBox = new JComboBox<>(new String[]{
            "MANILA<-->LAGUNA",
            "PASEO<-->LAGUNA",
            "CARMONA<-->LAGUNA",
            "PAVILION<-->LAGUNA",
            "WALTER<-->LAGUNA"
        });

        JLabel timeLabel = new JLabel("Insert Time:");
        timeTextField = new JTextField(10);

        linePanel.add(lineLabel);
        linePanel.add(lineComboBox);
        linePanel.add(timeLabel);
        linePanel.add(timeTextField);

        // Add an ActionListener to the combo box for refreshing the table
        lineComboBox.addActionListener(e -> {
            String selectedLine = (String) lineComboBox.getSelectedItem();
            if (selectedLine != null) {
                refreshTable(selectedLine);
            }
        });

        // Initialize table
        tableModel = new DefaultTableModel(new String[]{"Time"}, 0);
        reservationTable = new JTable(tableModel);
        reservationTable.setFillsViewportHeight(true);
        JScrollPane tableScrollPane = new JScrollPane(reservationTable);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButton = new JButton("Back");
        deleteButton = new JButton("Delete");
        addButton = new JButton("Add"); // New Add button

        buttonPanel.add(backButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(addButton);

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

        addButton.addActionListener(e -> {
           
            
                // Get the selected time and line
                String enteredTime = timeTextField.getText();
                String selectedLine = (String) lineComboBox.getSelectedItem();
                if(!Acontroller.checkTimeExists(enteredTime)){
                    Acontroller.insertIntoTime(enteredTime);
                } else {
                    // Call the method to handle insertion
                    
                    Acontroller.insertLineTime(selectedLine, enteredTime);

                    times.add(enteredTime);
                    populateTable();

                // Clear the input field
                timeTextField.setText("");

            JOptionPane.showMessageDialog(this, "Time successfully added!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                // Call the method to handle deletion
                
            
        });
        deleteButton.addActionListener(e -> {
            int selectedRow = reservationTable.getSelectedRow();
            if (selectedRow >= 0) {
                // Get the selected time and line
                String selectedTime = (String) tableModel.getValueAt(selectedRow, 0);
                String selectedLine = (String) lineComboBox.getSelectedItem();
        
                // Call the method to handle deletion
                Acontroller.deleteLineTime(selectedLine, selectedTime);
        
                // Remove the selected row from the table
                tableModel.removeRow(selectedRow);
                times.remove(selectedTime); // Update the ArrayList
            } else {
                JOptionPane.showMessageDialog(this, "Please select a time to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
            }
        });
        // Populate table initially
        populateTable();
    }


    

    private void populateTable() {
        // Clear any existing rows
        tableModel.setRowCount(0);

        // Add rows from the times ArrayList
        for (String time : times) {
            tableModel.addRow(new Object[]{time});
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

    private void addTime(String newTime) {
        // Add the new time to the table and the times ArrayList
        times.add(newTime);
        tableModel.addRow(new Object[]{newTime});
        timeTextField.setText(""); // Clear the input field
    }

    // This method is called by the controller after it updates the times
    public void updateTimes(ArrayList<String> newTimes) {
        this.times = newTimes;
        populateTable(); // Refresh the table with the new data
    }
}
