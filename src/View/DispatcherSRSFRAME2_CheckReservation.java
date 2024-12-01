package src.View;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import src.Controller.DLSU_SRSDispatcher_controller;
import src.Model.ShuttleBookingView;

public class DispatcherSRSFRAME2_CheckReservation extends TableFrame {
    
    private DLSU_SRSDispatcher_controller Dcontroller;
    private ArrayList<ShuttleBookingView> shuttleBookings;

    public DispatcherSRSFRAME2_CheckReservation(DLSU_SRSDispatcher_controller Dcontroller, ArrayList<ShuttleBookingView> shuttleBookings) {
        super();
        setDesignationTitle("Pending Reservations", 20, 0, 0, 0);
        this.Dcontroller = Dcontroller;
        this.shuttleBookings = shuttleBookings;
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    protected void initComponets(){

        this.tableModel = createTableModel(new String[] {"Verify", "Booking ID","ID Number", "Date", "Time", "Destination"});
        this.reservationTable = createReservationTable(this.tableModel);
        this.scrollPane = createScrollPane(this.reservationTable);
        innerPanel.add(this.scrollPane, BorderLayout.CENTER);
        loadObjects(this.tableModel, this.shuttleBookings);
        
        JButton submitButton = configureButton("SUBMIT", new Font("Arial", Font.PLAIN, 14), Color.BLACK, 0, 0, new Dimension(100, 20), e -> {
            try {
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    boolean isChecked = (boolean) tableModel.getValueAt(i, 0); // Check the 'Verify' column
                    if (isChecked) {
                        int bookingID = (int) tableModel.getValueAt(i, 1); // Get the Booking ID
                        
                        Dcontroller.updateAttendance(bookingID); // Update attendance
                        System.out.println(bookingID);
                                    
                    }
                }
                JOptionPane.showMessageDialog(this, "Attendance updated successfully!");
                this.dispose();
                Dcontroller.DispatcherMenu1Frame_Menu_DispatcherController();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error updating attendance: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        innerPanel.add(submitButton, BorderLayout.SOUTH);
        innerPanel.revalidate();
        innerPanel.repaint();

    }

    @Override
    protected DefaultTableModel createTableModel(String[] columns) {
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
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
        return tableModel;
    }

    @Override
    protected void loadObjects(DefaultTableModel tableModel, ArrayList<?> reservations) {
        ShuttleBookingView booking;
        for (Object reservation : reservations) {
            if (!(reservation instanceof ShuttleBookingView)) {
                throw new IllegalArgumentException("Invalid reservation type");
            }
            else {            
                booking = (ShuttleBookingView) reservation;
                tableModel.addRow(new Object[]{
                false,
                booking.getShuttleBookingID(), 
                booking.getArrowsExpressLine(), 
                booking.getDate(), 
                booking.getTime(), 
                booking.getOrigin(), 
                booking.getDestination()});
            }
        }
    }

    

}
