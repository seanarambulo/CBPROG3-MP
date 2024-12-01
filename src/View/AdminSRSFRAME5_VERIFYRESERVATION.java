package src.View;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import src.Controller.DLSU_SRSAdmin_controller;
import src.Model.*;

public class AdminSRSFRAME5_VERIFYRESERVATION extends TableFrame {
    protected DLSU_SRSAdmin_controller Acontroller;
    protected ArrayList<ShuttleBookingView> reservations;

    public AdminSRSFRAME5_VERIFYRESERVATION(DLSU_SRSAdmin_controller Acontroller, ArrayList<ShuttleBookingView> reservations) {
        super();
        this.Acontroller = Acontroller;
        this.reservations = reservations;

        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    protected void initComponets() {
        String[] columns = {"Destination", "Line", "Date", "Time", "ID Number", "Reason", "Verify"};
        DefaultTableModel tableModel = createTableModel(columns);
        loadReservations(tableModel, this.reservations);

        JTable table = createReservationTable(tableModel);
        innerPanel.add(createScrollPane(table), BorderLayout.CENTER);
        JButton submitButton = configureButton("SUBMIT", new Font("Arial", Font.PLAIN, 14), Color.BLACK, 0, 0, new Dimension(100, 30), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        boolean isChecked = (boolean) tableModel.getValueAt(i, 5); // Check the 'Verify' column
                        if (isChecked) {
                            IrregReservation reservation = (IrregReservation) reservations.get(i); // Access the corresponding reservation
                            int bookingID = reservation.getShuttleBookingID();
                            Acontroller.updateIrregAttendance(bookingID); // Update attendance
                        }
                    }
                    JOptionPane.showMessageDialog(AdminSRSFRAME5_VERIFYRESERVATION.this, "Attendance updated successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(AdminSRSFRAME5_VERIFYRESERVATION.this, "Error updating attendance: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                AdminSRSFRAME5_VERIFYRESERVATION.this.dispose();
                Acontroller.AdminSRSFRAME1_Menu_AdminController();
            }
        });
        buttonPanel.add(submitButton);
        innerPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    protected DefaultTableModel createTableModel(String[] columns) {
        return new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6; // Only the 'Verify' column is editable
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 6) return Boolean.class; // Boolean for 'Verify' column
                return super.getColumnClass(columnIndex);
            }
        };
    }

    @Override
    protected void loadReservations(DefaultTableModel tableModel, ArrayList<ShuttleBookingView> reservations) {
        for (ShuttleBookingView reservation : this.reservations) {
            tableModel.addRow(new Object[]{
                reservation.getDestination(),
                reservation.getArrowsExpressLine(),
                reservation.getDate(),
                reservation.getTime(),
                reservation.getUserID(),
                ((IrregReservation) reservation).getReason(),
                false
            });
        }
    }
}
