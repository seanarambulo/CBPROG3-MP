package src.View;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import src.Controller.DLSU_SRSAdmin_controller;
import src.Model.*;

public class AdminCheckReservation extends TableFrame {

    protected DLSU_SRSAdmin_controller Acontroller;
    protected ArrayList<ShuttleBookingView> reservations;


    public AdminCheckReservation(DLSU_SRSAdmin_controller Acontroller, ArrayList<ShuttleBookingView> reservations) {
        super();
        this.Acontroller = Acontroller;
        this.reservations = reservations;
        setDesignationTitle("Pending Reservations", 20,0,0,0);
        innerPanel.setLayout(null);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    protected void initComponets(){
        tableModel = createTableModel(new String[] {"Attendance", "Booking ID","ID Number", "Date", "Time", "Destination"});
        reservationTable = new JTable(tableModel);
        scrollPane = new JScrollPane(reservationTable);
        innerPanel.add(this.scrollPane, BorderLayout.CENTER);
        JButton submitButton = new JButton("BACK");
        buttonPanel.add(submitButton);
        add(buttonPanel, BorderLayout.SOUTH);
        submitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Attendance updated successfully!");
            this.dispose();
        });
    }

    @Override
    protected DefaultTableModel createTableModel(String[] columns) {
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        return tableModel;
    }
    
    @Override
    protected void loadObjects(DefaultTableModel tableModel, ArrayList<?> objs){
        ShuttleBookingView reservation;
        for (Object obj : objs) {
            reservation = new ShuttleBookingView();
            tableModel.addRow(new Object[]{
                reservation.getAttendance(),
                reservation.getShuttleBookingID(),
                reservation.getUserID(),
                reservation.getDate(),
                reservation.getTime(),
                reservation.getDestination()
            });
        }
        
    }


}
