
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public abstract class TableFrame2 extends FrameBackground {

    protected JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    protected DefaultTableModel tableModel;
    protected JTable reservationTable;
    protected JScrollPane scrollPane;

    protected abstract DefaultTableModel createTableModel(String[] columns);

    protected JTable createReservationTable(DefaultTableModel tableModel) {
        JTable TreservationTable = new JTable(tableModel);
        TreservationTable.setBackground(new Color(255, 255, 255)); // White background
        TreservationTable.setForeground(new Color(0, 0, 0)); // Black text
        TreservationTable.setSelectionBackground(new Color(108, 194, 168)); // Light green selection background
        TreservationTable.setSelectionForeground(new Color(255, 255, 255)); // White selection text

        // Customize table header colors
        JTableHeader tableHeader = TreservationTable.getTableHeader();
        tableHeader.setBackground(new Color(31, 95, 79)); // Dark green header background
        tableHeader.setForeground(new Color(255, 255, 255)); // White header text

        return TreservationTable;
    }

    protected JScrollPane createScrollPane(JTable reservationTable) {
        JScrollPane createScrollPane = new JScrollPane(reservationTable);
        createScrollPane.setBounds(50, 100, 600, 300);
        createScrollPane.setLayout(new ScrollPaneLayout());
        return createScrollPane;
    }

    protected abstract void loadObjects(DefaultTableModel tableModel, ArrayList<?> objectlist);
    
}