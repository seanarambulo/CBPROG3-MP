package src.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import src.Controller.DLSU_SRSUser_controller;
import src.Model.ShuttleBooking;

public class UserSRSFRAME5_VIEWSHUTTLEBOOKING extends FrameBackground {
    
    private final DLSU_SRSUser_controller controller;
    private JTable reservationTable;
    private DefaultTableModel tableModel;
    private ShuttleBooking[] reservations;

    public UserSRSFRAME5_VIEWSHUTTLEBOOKING(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;
        SwingUtilities.invokeLater(() -> initComponets());
    }

    public void initComponets(){

        setDesignationTitle("View Shuttle Booking");
        // Create table model and set column names
        tableModel = new DefaultTableModel(new Object[]{"Reservation ID", "Shuttle Line", "Date", "Time", "Origin", "Destination"}, 0);
        reservationTable = new JTable(tableModel);

        // Customize table colors
        reservationTable.setBackground(new Color(255, 255, 255)); // White background
        reservationTable.setForeground(new Color(0, 0, 0)); // Black text
        reservationTable.setSelectionBackground(new Color(108, 194, 168)); // Light green selection background
        reservationTable.setSelectionForeground(new Color(255, 255, 255)); // White selection text

        // Customize table header colors
        JTableHeader tableHeader = reservationTable.getTableHeader();
        tableHeader.setBackground(new Color(31, 95, 79)); // Dark green header background
        tableHeader.setForeground(new Color(255, 255, 255)); // White header text

        JScrollPane scrollPane = new JScrollPane(reservationTable);
    
        for (Reservation reservation : reservations) {
            tableModel.addRow(new Object[]{reservation.getShuttleReservationID(),reservation.getShuttleLine(), reservation.getDate(), reservation.getTime(), reservation.getOrigin(), reservation.getDestination()});
        }

        // Populate table with reservations
        // Add panel to the frame
        // Populate table with reservations
        // Add scrollPane to the innerPanel
        innerGbc.gridx = 0;
        innerGbc.gridy = 1;
        innerGbc.gridwidth = 2;
        innerGbc.fill = GridBagConstraints.BOTH;
        innerGbc.weightx = 1.0;
        innerGbc.weighty = 1.0;
        innerPanel.add(scrollPane, innerGbc);

        // Add a ListSelectionListener to handle row selection
        reservationTable.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = reservationTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Retrieve selected row data
                    int reservationID = (int) tableModel.getValueAt(selectedRow, 0);
                    String shuttleLine = (String) tableModel.getValueAt(selectedRow, 1);
                    String date = (String) tableModel.getValueAt(selectedRow, 2);
                    String time = (String) tableModel.getValueAt(selectedRow, 3);
                    String origin = (String) tableModel.getValueAt(selectedRow, 4);
                    String destination = (String) tableModel.getValueAt(selectedRow, 5);

                    // Display selected data (for example, in a dialog)
                    // Ask the user if they want to edit the information
                    /*
                    int response = JOptionPane.showConfirmDialog(SRSFRAME5_VIEWSHUTTLEBOOKING.this,
                            "Reservation ID: " + reservationID + "\n" +
                            "Shuttle Line: " + shuttleLine + "\n" +
                            "Date: " + date + "\n" +
                            "Time: " + time + "\n" +
                            "Origin: " + origin + "\n" +
                            "Destination: " + destination + "\n\n" +
                            "Do you want to edit this information?",
                            "Selected Reservation",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

                    if (response == JOptionPane.YES_OPTION) {
                        // Code to edit the information
                        // For example, you can open a new dialog to edit the information
                        // or enable editing directly in the table
                        controller.SRSFRAME6_EDITSHUTTLEBOOKING_userController();
                    }*/
                }
            }
        });

        innerPanel.revalidate();
        innerPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DLSU_SRSUser_controller controller = new DLSU_SRSUser_controller();
            UserSRSFRAME5_VIEWSHUTTLEBOOKING frame = new UserSRSFRAME5_VIEWSHUTTLEBOOKING(controller);
        });
    }
}

