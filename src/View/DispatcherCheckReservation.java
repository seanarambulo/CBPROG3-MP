package src.View;

import src.Controller.DLSU_SRSDispatcher_controller;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class DispatcherCheckReservation {

    public DispatcherCheckReservation(DLSU_SRSDispatcher_controller Dcontroller) {
        createAndShowGUI(Dcontroller);
    }

    private static void createAndShowGUI(DLSU_SRSDispatcher_controller Dcontroller) {
        JFrame frame = new JFrame("Pending Reservations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Set the layout
        frame.setLayout(new BorderLayout());

        // Panel for the title
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("RESERVATIONS");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titlePanel.add(titleLabel);

        // Table for pending reservations
        String[] columns = {"Verify", "ID number", "Date", "Time", "Destination"};
        Object[][] data = {
            {false, "12345678", "11-17-2024", "7:00 AM", "Laguna"},
            {false, "12452981", "11-17-2024", "2:30 PM", "Manila"},
            {false, "12166712", "11-18-2024", "7:00 AM", "Laguna"},
            {false, "12678945", "11-19-2024", "9:00 AM", "Cebu"},
            {false, "12987654", "11-20-2024", "1:00 PM", "Davao"},
            {false, "12345679", "11-21-2024", "8:00 AM", "Baguio"}
        };

        DefaultTableModel tableModel = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0; // Only the 'Verify' column is editable
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class; // The 'Verify' column contains Boolean values
                }
                return super.getColumnClass(columnIndex);
            }
        };
        JTable table = new JTable(tableModel);

        // Scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Panel for Submit button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton submitButton = new JButton("SUBMIT");
        buttonPanel.add(submitButton);

        // Add components to the frame
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Action listener for the submit button
        submitButton.addActionListener(e -> {
            ArrayList<Object[]> verifiedReservations = new ArrayList<>();
            boolean anyChecked = false;

            // Iterate through the rows and store checked rows in the ArrayList
            for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
                Boolean isChecked = (Boolean) tableModel.getValueAt(i, 0);
                if (isChecked != null && isChecked) {
                    // Store the entire row in the ArrayList
                    Object[] row = new Object[tableModel.getColumnCount()];
                    for (int j = 0; j < tableModel.getColumnCount(); j++) {
                        row[j] = tableModel.getValueAt(i, j);
                    }
                    verifiedReservations.add(row);

                    // Remove the row from the table
                    tableModel.removeRow(i);
                    anyChecked = true;
                }
            }

            if (!anyChecked) {
                JOptionPane.showMessageDialog(frame, "No reservations selected for verification.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Print the verified reservations (for debugging or further processing)
                System.out.println("Verified Reservations:");
                for (Object[] row : verifiedReservations) {
                    System.out.println(java.util.Arrays.toString(row));
                }
            }
        });

        // Display the frame
        frame.setVisible(true);
    }

    
}
