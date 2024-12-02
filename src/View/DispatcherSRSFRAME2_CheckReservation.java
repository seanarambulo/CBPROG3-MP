package src.View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import src.Controller.DLSU_SRSDispatcher_controller;
import src.Model.ShuttleBookingView;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DispatcherSRSFRAME2_CheckReservation extends TableFrame {
    protected DLSU_SRSDispatcher_controller Dcontroller;
    protected ArrayList<ShuttleBookingView> reservations;
    public DispatcherSRSFRAME2_CheckReservation(DLSU_SRSDispatcher_controller Dcontroller, ArrayList<ShuttleBookingView> reservations) {
        super("Pending Reservations");
        this.Dcontroller = Dcontroller;
        this.reservations = reservations;
       
        DefaultTableModel tableModel = createTableModel();
        JTable table = new JTable(tableModel);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Add Submit button
        addButton("SUBMIT",tableModel);

        display();
    }

    @Override
    protected void addButton(String buttonName, DefaultTableModel tableModel){
        JButton submitButton = new JButton(buttonName);
        buttonPanel.add(submitButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        boolean isChecked = (boolean) tableModel.getValueAt(i, 0); // Check the 'Verify' column
                        if (isChecked) {
                            int bookingID = (int) tableModel.getValueAt(i, 1); // Get the Booking ID
                            
                            Dcontroller.updateAttendance(bookingID); // Update attendance
                            System.out.println(bookingID);
                        }
                    }
                    JOptionPane.showMessageDialog(frame, "Attendance updated successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error updating attendance: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                frame.dispose();
                Dcontroller.DispatcherMenu1Frame_Menu_DispatcherController();

    

            }
        });
}

    @Override
    protected DefaultTableModel createTableModel() {
        String[] columns = {"Verify", "Booking ID","ID Number", "Date", "Time", "Destination"};
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

        for (ShuttleBookingView reservation : reservations) {
            tableModel.addRow(new Object[]{
                false, // Checkbox is initially unchecked
                reservation.getShuttleBookingID(),
                reservation.getUserID(),
                reservation.getDate(),
                reservation.getTime(),
                reservation.getDestination()
            });
        }
        WriteFile(reservations);
        return tableModel;
    }

    protected void WriteFile(ArrayList<?> reservations) {
		ShuttleBookingView booking;
		
        // Write to a text file
        try (FileWriter writer = new FileWriter("reservations.txt")) {
            // Write header
            writer.write(String.format("%-20s %-20s %-20s %-20s%n", "Shuttle Booking ID", "Date", "Time", "Destination"));
            writer.write("-------------------- -------------------- -------------------- --------------------\n");
			// Write contents
			for (Object reservation : reservations) {
				booking = (ShuttleBookingView) reservation;
                writer.write(String.format("%-20s %-20s %-20s %-20s%n", booking.getShuttleBookingID(), booking.getDate(), booking.getTime(), booking.getDestination()));
            }

            System.out.println("Table has been successfully written to 'reservations.txt'!");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
