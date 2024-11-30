package src.View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import src.Model.ShuttleBookingView;

public abstract class TableFrame extends FrameBackground {

    protected JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    protected abstract DefaultTableModel createTableModel(String[] columns);

    protected JTable createReservationTable(DefaultTableModel tableModel) {
        JTable reservationTable = new JTable(tableModel);
        reservationTable.setBackground(new Color(255, 255, 255)); // White background
        reservationTable.setForeground(new Color(0, 0, 0)); // Black text
        reservationTable.setSelectionBackground(new Color(108, 194, 168)); // Light green selection background
        reservationTable.setSelectionForeground(new Color(255, 255, 255)); // White selection text

        // Customize table header colors
        JTableHeader tableHeader = reservationTable.getTableHeader();
        tableHeader.setBackground(new Color(31, 95, 79)); // Dark green header background
        tableHeader.setForeground(new Color(255, 255, 255)); // White header text

        return reservationTable;
    }

    protected JScrollPane createScrollPane(JTable reservationTable) {
        JScrollPane scrollPane = new JScrollPane(reservationTable);
        scrollPane.setBounds(50, 100, 600, 300);
        scrollPane.setLayout(new ScrollPaneLayout());
        return scrollPane;
    }

    protected abstract void loadReservations(DefaultTableModel tableModel, ArrayList<ShuttleBookingView> reservations);
    
}
