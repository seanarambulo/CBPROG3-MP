package src.View;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
import src.Controller.DLSU_SRSAdmin_controller;
import src.Model.*;

public class AdminSRSFRAME5_VERIFYRESERVATION extends TableFrame {
    protected DLSU_SRSAdmin_controller Acontroller;
    protected ArrayList<IrregReservation> reservations;

    public AdminSRSFRAME5_VERIFYRESERVATION(DLSU_SRSAdmin_controller Acontroller, ArrayList<IrregReservation> reservations) {
        super();
        this.Acontroller = Acontroller;
        this.reservations = reservations;
        setDesignationTitle("Verify Reservation", 20, 0, 0, 0);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    protected void initComponets() {
        String[] columns = {"Destination", "Line", "Date", "Time", "ID Number", "Reason", "Verify"};
        this.tableModel = createTableModel(columns);
        this.reservationTable = createReservationTable(tableModel);
        this.scrollPane = createScrollPane(this.reservationTable);
        
        loadObjects(this.tableModel, this.reservations);

        innerPanel.add(this.scrollPane, BorderLayout.CENTER);
        JButton submitButton = configureButton("SUBMIT", new Font("Arial", Font.PLAIN, 14), Color.BLACK, 0, 0, new Dimension(100, 20), e -> {
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
        });
        innerPanel.add(submitButton, BorderLayout.SOUTH);
        innerPanel.revalidate();
        innerPanel.repaint();
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
    protected void loadObjects(DefaultTableModel tableModel, ArrayList<?> objs) {
        IrregReservation reservation;
        for (Object obj : objs) {
            if (!(obj instanceof IrregReservation)){
                throw new IllegalArgumentException("Invalid reservation type");
            } else {
                reservation = (IrregReservation) obj;
                tableModel.addRow(new Object[]{
                    reservation.getDestination(),
                    reservation.getArrowsExpressLine(),
                    reservation.getDate(),
                    reservation.getTime(),
                    reservation.getUserID(),
                    reservation.getReason(),
                    false
                });
            }
        }
    }
}
