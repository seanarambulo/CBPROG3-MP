package src.View;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import src.Controller.DLSU_SRSUser_controller;
import src.Model.*;

public class UserSRSFRAME5_VIEWSHUTTLEBOOKING extends FrameBackground {
    
    private final DLSU_SRSUser_controller controller;
    private JTable reservationTable;
    private DefaultTableModel tableModel;
    private ArrayList<ShuttleBookingView> reservations;

    public UserSRSFRAME5_VIEWSHUTTLEBOOKING(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;
        setDesignationTitle("View Shuttle Booking", 0, 0, 0, 0);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    public void initComponets(){

        tableModel = new DefaultTableModel(new Object[]{"Reservation ID", "Shuttle Name", "Date", "Time", "Origin", "Destination"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        reservationTable = new JTable(tableModel);

        reservationTable.setBackground(new Color(255, 255, 255)); // White background
        reservationTable.setForeground(new Color(0, 0, 0)); // Black text
        reservationTable.setSelectionBackground(new Color(108, 194, 168)); // Light green selection background
        reservationTable.setSelectionForeground(new Color(255, 255, 255)); // White selection text

        // Customize table header colors
        JTableHeader tableHeader = reservationTable.getTableHeader();
        tableHeader.setBackground(new Color(31, 95, 79)); // Dark green header background
        tableHeader.setForeground(new Color(255, 255, 255)); // White header text

        JScrollPane scrollPane = new JScrollPane(reservationTable);
        scrollPane.setBounds(50, 100, 700, 300);
        try {
            reservations = controller.ReservationsList();
        } catch (SQLException e) {
            // Log the exception
            Logger.getLogger(UserSRSFRAME5_VIEWSHUTTLEBOOKING.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "An error occurred while retrieving reservations.", "Error", JOptionPane.ERROR_MESSAGE);
            reservations = new ArrayList<>(); // Initialize with an empty list in case of error
        }
        for (ShuttleBookingView reservation : reservations) {
            tableModel.addRow(new Object[]{reservation.getShuttleBookingID(),reservation.getArrowsExpressLine(), reservation.getDate(), reservation.getTime(), reservation.getOrigin(), reservation.getDestination()});
        }
    
        // Populate table with reservations
        // Add panel to the frame
        // Populate table with reservations
        // Add scrollPane to the innerPanel
        innerPanel.add(scrollPane);

        // Add a ListSelectionListener to handle row selection
        reservationTable.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = reservationTable.getSelectedRow();
                if (selectedRow != -1) {
                    ShuttleBookingView selectedReservation = reservations.get(selectedRow);
                    int response = JOptionPane.showConfirmDialog(UserSRSFRAME5_VIEWSHUTTLEBOOKING.this,
                            "Reservation ID: " + selectedReservation.getShuttleBookingID() + "\n" +
                            "Shuttle Line: " + selectedReservation.getArrowsExpressLine() + "\n" +
                            "Date: " + selectedReservation.getDate() + "\n" +
                            "Time: " + selectedReservation.getTime() + "\n" +
                            "Origin: " + selectedReservation.getDestination() + "\n" +
                            "Destination: " + selectedReservation.getDestination() + "\n\n" +
                            "Do you want to edit this information?",
                            "Selected Reservation",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

                    if (response == JOptionPane.YES_OPTION) {
                        this.dispose();
                        controller.setShuttleBookingView(selectedReservation);
                        controller.SRSFRAME6_EDITSHUTTLEBOOKING_userController();
                    }
                }
            }
        });

        innerPanel.revalidate();
        innerPanel.repaint();
    }
}

