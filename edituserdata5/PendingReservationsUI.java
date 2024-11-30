import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PendingReservationsUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PendingReservationsUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Pending Reservations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Set the layout
        frame.setLayout(new BorderLayout());

        // Panel for the title
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("PENDING RESERVATIONS");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titlePanel.add(titleLabel);

        // Table for pending reservations
        String[] columns = {"Verify", "ID number", "Date", "Time", "Destination", "Reason"};
        Object[][] data = {
            {false, "12345678", "11-17-2024", "7:00 AM", "Laguna", " ako ay may lobo lumipad sa langit di ko na nakita pumutok na pala"},
            {false, "12452981", "11-17-2024", "2:30 PM", "Manila", "..."},
            {false, "12166712", "11-18-2024", "7:00 AM", "Laguna", "..."},
            {false, "12678945", "11-19-2024", "9:00 AM", "Cebu", "..."},
            {false, "12987654", "11-20-2024", "1:00 PM", "Davao", "..."},
            {false, "12345679", "11-21-2024", "8:00 AM", "Baguio", "..."},
            {false, "12452982", "11-22-2024", "3:00 PM", "Quezon City", "..."},
            {false, "12166713", "11-23-2024", "6:00 AM", "Laguna", "..."},
            {false, "12678946", "11-24-2024", "10:00 AM", "Cebu", "..."},
            {false, "12987655", "11-25-2024", "2:00 PM", "Davao", "..."},
            {false, "12345680", "11-26-2024", "7:30 AM", "Laguna", "..."},
            {false, "12452983", "11-27-2024", "4:00 PM", "Manila", "..."},
            {false, "12166714", "11-28-2024", "8:00 AM", "Laguna", "..."},
            {false, "12678947", "11-29-2024", "11:00 AM", "Cebu", "..."},
            {false, "12987656", "11-30-2024", "3:00 PM", "Davao", "..."},
            {false, "12345681", "12-01-2024", "9:00 AM", "Laguna", "..."},
            {false, "12452984", "12-02-2024", "2:00 PM", "Manila", "..."},
            {false, "12166715", "12-03-2024", "7:00 AM", "Laguna", "..."},
            {false, "12678948", "12-04-2024", "10:00 AM", "Cebu", "..."},
            {false, "12987657", "12-05-2024", "1:00 PM", "Davao", "..."},
            {false, "12345682", "12-06-2024", "8:00 AM", "Baguio", "..."},
            {false, "12452985", "12-07-2024", "3:00 PM", "Quezon City", "..."},
            {false, "12166716", "12-08-2024", "6:00 AM", "Laguna", "..."},
            {false, "12678949", "12-09-2024", "10:00 AM", "Cebu", "..."},
            {false, "12987658", "12-10-2024", "2:00 PM", "Davao", "..."},
            {false, "12345683", "12-11-2024", "7:30 AM", "Laguna", "..."},
            {false, "12452986", "12-12-2024", "4:00 PM", "Manila", "..."},
            {false, "12166717", "12-13-2024", "8:00 AM", "Laguna", "..."},
            {false, "12678950", "12-14-2024", "11:00 AM", "Cebu", "..."},
            {false, "12987659", "12-15-2024", "3:00 PM", "Davao", "..."}
        };
        
        DefaultTableModel tableModel = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0; // Only the 'Verify' column is editable
            }
        
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class; // The 'Verify' column contains Boolean values
                }
                return super.getColumnClass(columnIndex);
            }
        };
        JTable table = new JTable(tableModel);
        
        // Scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Panel for Submit button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton submitButton = new JButton("SUBMIT");
        buttonPanel.add(submitButton);
        
        // Add components to the frame
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        
        // Action listener for the submit button
        submitButton.addActionListener(e -> {
            boolean anyChecked = false;
            for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
                Boolean isChecked = (Boolean) tableModel.getValueAt(i, 0);
                if (isChecked != null && isChecked) {
                    tableModel.removeRow(i);
                    anyChecked = true;
                }
            }
            if (!anyChecked) {
                JOptionPane.showMessageDialog(frame, "No reservations selected for verification.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // Display the frame
        frame.setVisible(true);
            }
        }
