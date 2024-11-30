import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class DispatcherCheckReservation extends AbstractReservationFrame {
    protected DLSU_SRSDispatcher_controller Dcontroller;
    protected ArrayList<Reservation> reservations;
    public DispatcherCheckReservation(DLSU_SRSDispatcher_controller Dcontroller, ArrayList<Reservation> reservations) {
        super("Pending Reservations");
        this.Dcontroller = Dcontroller;
        this.reservations = reservations;
       
        DefaultTableModel tableModel = createTableModel(reservations);
        JTable table = new JTable(tableModel);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Add Submit button
        addButton("SUBMIT",tableModel);

        display();
    }

    @Override
    protected void addButton(String buttonName, DefaultTableModel tableModel){
        JButton submitButton = new JButton("SUBMIT");
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
                Dcontroller.DispatcherMenu1Frame();
            }
        });
}

    @Override
    protected DefaultTableModel createTableModel(ArrayList<Reservation> reservations) {
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

        for (Reservation reservation : reservations) {
            tableModel.addRow(new Object[]{
                false, // Checkbox is initially unchecked
                reservation.getbookingID(),
                reservation.getUserID(),
                reservation.getDate(),
                reservation.getTime(),
                reservation.getDestination()
            });
        }
        return tableModel;
    }
}
