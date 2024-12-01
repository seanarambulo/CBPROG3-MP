package src.View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import src.Controller.DLSU_SRSUser_controller;
import src.Model.*;

public class UserSRSFRAME5_VIEWSHUTTLEBOOKING extends TableFrame {
    
    private final DLSU_SRSUser_controller controller;
    private ArrayList<ShuttleBookingView> shuttleBookings;

    public UserSRSFRAME5_VIEWSHUTTLEBOOKING(DLSU_SRSUser_controller controller) {
        super();
        setDesignationTitle("View Bookings", 20, 0, 0, 0);
        this.controller = controller;
        SwingUtilities.invokeLater(() -> initComponets());
    };

    @Override
    protected void initComponets() {        
        this.tableModel = createTableModel(new String[] {"Booking ID", "Shuttle Line", "Date", "Time", "Origin", "Destination"});
        this.reservationTable = createReservationTable(this.tableModel);
        this.scrollPane = createScrollPane(this.reservationTable);
        
        innerPanel.setLayout(null);
        try {
            this.shuttleBookings = controller.ReservationsList();
        } catch (SQLException e) {
            Logger.getLogger(UserSRSFRAME5_VIEWSHUTTLEBOOKING.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "An error occurred while retrieving reservations.", "Error", JOptionPane.ERROR_MESSAGE);
            this.shuttleBookings = new ArrayList<>(); // Initialize with an empty list in case of error
        }
        
        loadObjects(this.tableModel, this.shuttleBookings);

        innerPanel.add(this.scrollPane);

        addTableSelectionListener(this.reservationTable, shuttleBookings, this.controller);

        innerPanel.revalidate();
        innerPanel.repaint();
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

    protected void addTableSelectionListener(JTable reservationTable, ArrayList<ShuttleBookingView> reservations, DLSU_SRSUser_controller controller) {
        reservationTable.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = reservationTable.getSelectedRow();
                if (selectedRow != -1) {
                    ShuttleBookingView selectedReservation = reservations.get(selectedRow);
                    int response = JOptionPane.showConfirmDialog(this,
                        "Reservation ID: " + selectedReservation.getShuttleBookingID() + "\n" +
                        "Shuttle Line: " + selectedReservation.getArrowsExpressLine() + "\n" +
                        "Date: " + selectedReservation.getDate() + "\n" +
                        "Time: " + selectedReservation.getTime() + "\n" +
                        "Origin: " + selectedReservation.getOrigin() + "\n" +
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
    }

    @Override
    protected void loadObjects(DefaultTableModel tableModel, ArrayList<?> reservations) {
        ShuttleBookingView booking;
        for (Object reservation : reservations) {
            if (!(reservation instanceof ShuttleBookingView)) {
                throw new IllegalArgumentException("Invalid reservation type");
                
            } else {
                booking = (ShuttleBookingView) reservation;
                tableModel.addRow(new Object[]{booking.getShuttleBookingID(), 
                booking.getArrowsExpressLine(), booking.getDate(), 
                booking.getTime(), booking.getOrigin(), 
                booking.getDestination()});                
            }
        }
    }
}

