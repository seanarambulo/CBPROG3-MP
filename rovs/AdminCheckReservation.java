import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class AdminCheckReservation extends AbstractReservationFrame {
    protected DLSU_SRSAdmin_controller Acontroller;
    protected ArrayList<Reservation> reservations;
    public AdminCheckReservation(DLSU_SRSAdmin_controller Acontroller, ArrayList<Reservation> reservations) {
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
                Acontroller.AdminMenu1Frame();
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

        for (Reservation reservation : reservations) {
            tableModel.addRow(new Object[]{
                reservation.getAttendance(),
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
