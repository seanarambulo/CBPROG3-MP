import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class mocktest extends JFrame {

    private DefaultTableModel tableModel;
    private JTable reservationTable;
    private JScrollPane scrollPane;

    public mocktest() {
        super("View Bookings");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        initComponets();
    }

    private void initComponets() {
        // Create table model and table
        this.tableModel = createTableModel(new String[]{"Booking ID", "Shuttle Line", "Date", "Time", "Origin", "Destination"});
        this.reservationTable = new JTable(this.tableModel);
        this.scrollPane = new JScrollPane(this.reservationTable);

        // Hardcoded data
        loadReservations(this.tableModel, createSampleData());

        // Add components to the frame
        add(scrollPane, BorderLayout.CENTER);
    }

    private DefaultTableModel createTableModel(String[] columns) {
        return new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    private void loadReservations(DefaultTableModel tableModel, ArrayList<String[]> reservations) {
        for (String[] reservation : reservations) {
            tableModel.addRow(reservation);
        }
    }

    private ArrayList<String[]> createSampleData() {
        ArrayList<String[]> sampleData = new ArrayList<>();
        sampleData.add(new String[]{"1", "Line A", "2024-12-01", "08:00 AM", "Point A", "Point B"});
        sampleData.add(new String[]{"2", "Line B", "2024-12-02", "10:00 AM", "Point C", "Point D"});
        sampleData.add(new String[]{"3", "Line C", "2024-12-03", "02:00 PM", "Point E", "Point F"});
        return sampleData;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            mocktest frame = new mocktest();
            frame.setLocationRelativeTo(null); // Center the frame
            frame.setVisible(true);
        });
    }
}
