package src.View;

import java.awt.*;
import java.awt.event.*;
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
       super("Verify Reservations");
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
protected void addButton(String buttonName, DefaultTableModel tableModel) {
    JButton submitButton = new JButton(buttonName);
    buttonPanel.add(submitButton);
    frame.add(buttonPanel, BorderLayout.SOUTH);
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    boolean isChecked = (boolean) tableModel.getValueAt(i, 6); // Check the 'Verify' column
                    if (isChecked) {
                        IrregReservation reservation = (IrregReservation) reservations.get(i); // Access the corresponding reservation
                        int bookingID = reservation.getShuttleBookingID();
                        try {
                            Acontroller.updateIrregAttendance(bookingID);
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        } // Update attendance
                    }
                }
                
            
            frame.dispose();
            Acontroller.AdminSRSFRAME1_Menu_AdminController();
        }
    });
}


    @Override
    protected DefaultTableModel createTableModel() {
        String[] columns = {"Destination", "Line", "Date", "Time", "ID Number", "Reason", "Verify"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
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

        // Populate table with reservations
        for ( IrregReservation reservation: reservations) {
            
                tableModel.addRow(new Object[]{
                    reservation.getDestination(),
                    reservation.getLineID(),
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