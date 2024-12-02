package src.View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import src.Controller.DLSU_SRSAdmin_controller;
import src.Model.IrregReservation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class AdminSRSFRAME5_VERIFYRESERVATION extends TableFrame {
    protected DLSU_SRSAdmin_controller Acontroller;
    protected ArrayList<IrregReservation> reservations;
    public AdminSRSFRAME5_VERIFYRESERVATION(DLSU_SRSAdmin_controller Acontroller, ArrayList<IrregReservation> reservations) {
        super("Pending Reservations");
        this.Acontroller = Acontroller;
        this.reservations = reservations;
       
        DefaultTableModel tableModel = createTableModel();
        JTable table = new JTable(tableModel);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Add Submit button
        addButton("BACK",tableModel);

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
                
                frame.dispose();
                Acontroller.AdminSRSFRAME1_Menu_AdminController();
            }
        });
}

    @Override
    protected DefaultTableModel createTableModel() {
        String[] columns = {"Attendance", "Booking ID","ID Number", "Date", "Time", "Destination"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        for (IrregReservation reservation : reservations) {
            tableModel.addRow(new Object[]{
                reservation.getAttendance(),
                reservation.getShuttleBookingID(),
                reservation.getUserID(),
                reservation.getDate(),
                reservation.getTime(),
                reservation.getDestination()
            });
        }
        return tableModel;
    }
}