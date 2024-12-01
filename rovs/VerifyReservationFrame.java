import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;



    public class VerifyReservationFrame extends AbstractReservationFrame {
    protected DLSU_SRSAdmin_controller Acontroller;
    protected ArrayList<IrregReservation> reservations;
    public VerifyReservationFrame(DLSU_SRSAdmin_controller Acontroller, ArrayList<IrregReservation> reservations) {
        super("Pending Reservations");
        this.Acontroller = Acontroller;
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
                        boolean isChecked = (boolean) tableModel.getValueAt(i, 5); // Check the 'Verify' column
                        if (isChecked) {
                            IrregReservation reservation = reservations.get(i); // Access the corresponding reservation
                            int bookingID = reservation.getbookingID();
                            
                            
                            Acontroller.updateIrregAttendance(bookingID); // Update attendance
                            System.out.println(bookingID);
                        }
                    }
                    JOptionPane.showMessageDialog(frame, "Attendance updated successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error updating attendance: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                frame.dispose();
                Acontroller.AdminMenu1Frame();
            }
        });
           
    }

    @Override
    protected DefaultTableModel createTableModel() {
        String[] columns = {"Destination", "Date", "Time", "ID Number", "Reason","Verify"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5; // Only the 'Verify' column is editable
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 5) return Boolean.class; // Boolean for 'Verify' column
                return super.getColumnClass(columnIndex);
            }
        };

        // Populate table with reservations
        for (IrregReservation reservation : reservations) {
            tableModel.addRow(new Object[]{
                reservation.getDestination(),
                reservation.getDate(),
                reservation.getTime(),
                reservation.getUserID(),
                reservation.getReason(),
                false
            });
        }

        return tableModel;
    }
}
