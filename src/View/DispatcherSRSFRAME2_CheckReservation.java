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

        Dimension buttonSize = new Dimension(100, 50);
        Font buttonFont = new Font("Helvetica Neue", Font.BOLD, 18);
        Color buttonColor = new Color(108, 194, 162);

        innerPanel.setLayout(null);
        int panelWidth = innerPanel.getWidth();
        int xPosition = (panelWidth - buttonSize.width) / 2;

        this.tableModel = createTableModel(new String[] {"Verify", "Booking ID","ID Number", "Date", "Time", "Destination"});
        this.reservationTable = createReservationTable(this.tableModel);
        this.scrollPane = createScrollPane(this.reservationTable);
        innerPanel.add(this.scrollPane, BorderLayout.CENTER);
        loadObjects(this.tableModel, this.shuttleBookings);
        
        this.buttonPanel.add(configureButton(getName(), buttonFont, buttonColor, xPosition, 700, buttonSize, e -> {
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
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error updating attendance: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
            Dcontroller.DispatcherMenu1Frame_Menu_DispatcherController();
        }));
        innerPanel.add(this.buttonPanel, BorderLayout.SOUTH);
        
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

    protected void WriteFile(ArrayList<?> reservations) {
		ShuttleBookingView booking;
        // Write to a text file
        try (FileWriter writer = new FileWriter("reservations.txt")) {
            // Write header
            writer.write(String.format("%-20s %-20s %-20s %-20s %-20s %-20s%n", "Shuttle Booking ID", "Arrows Express Line", "Date", "Time", "Origin", "Destination"));
            writer.write("-------------------- -------------------- -------------------- -------------------- -------------------- --------------------\n");
			// Write contents
			for (Object reservation : reservations) {
				booking = (ShuttleBookingView) reservation;
                writer.write(String.format("%-20s %-20s %-20s %-20s %-20s %-20s%n", booking.getShuttleBookingID(), booking.getArrowsExpressLine(), booking.getDate(), booking.getTime(), booking.getOrigin(), booking.getDestination()));
            }
            System.out.println("Table has been successfully written to 'table.txt'!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    

}
