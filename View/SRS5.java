import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SRS5 extends JFrame {

    private JTable reservationTable;
    private DefaultTableModel tableModel;
    private JLabel lineLabel;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JLabel originLabel;
    private JLabel originValueLabel;
    private JLabel destinationLabel;
    private JComboBox<String> lineComboBox;
    private JComboBox<String> dateComboBox;
    private JComboBox<String> timeComboBox;
    private JComboBox<String> destinationBox;
    
    public SRS5(List<Reservation> reservations) {
        setTitle("User Shuttle Reservations");
        setSize(810, 530); // Set the size to 810 x 530 px
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    
        // Create table model and set column names
        tableModel = new DefaultTableModel(new Object[]{"Reservation ID", "Shuttle Line", "Date", "Time", "Origin", "Destination"}, 0);
        reservationTable = new JTable(tableModel);

        // Customize table colors
        reservationTable.setBackground(new Color(255, 255, 255)); // White background
        reservationTable.setForeground(new Color(0, 0, 0)); // Black text
        reservationTable.setSelectionBackground(new Color(108, 194, 168)); // Light green selection background
        reservationTable.setSelectionForeground(new Color(255, 255, 255)); // White selection text

        // Customize table header colors
        JTableHeader tableHeader = reservationTable.getTableHeader();
        tableHeader.setBackground(new Color(31, 95, 79)); // Dark green header background
        tableHeader.setForeground(new Color(255, 255, 255)); // White header text

        JScrollPane scrollPane = new JScrollPane(reservationTable);
    
        // Populate table with reservations
        for (Reservation reservation : reservations) {
            tableModel.addRow(new Object[]{reservation.getShuttleReservationID(),reservation.getShuttleLine(), reservation.getDate(), reservation.getTime(), reservation.getOrigin(), reservation.getDestination()});
        }
    
        // Add panel to the frame
        add(scrollPane, BorderLayout.CENTER);

        // Add a ListSelectionListener to handle row selection
        reservationTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = reservationTable.getSelectedRow();
                    if (selectedRow != -1) {
                        // Retrieve selected row data
                        int reservationID = (int) tableModel.getValueAt(selectedRow, 0);
                        String shuttleLine = (String) tableModel.getValueAt(selectedRow, 1);
                        String date = (String) tableModel.getValueAt(selectedRow, 2);
                        String time = (String) tableModel.getValueAt(selectedRow, 3);
                        String origin = (String) tableModel.getValueAt(selectedRow, 4);
                        String destination = (String) tableModel.getValueAt(selectedRow, 5);

                        // Display selected data (for example, in a dialog)
                        // Ask the user if they want to edit the information
                        int response = JOptionPane.showConfirmDialog(SRS5.this,
                                "Reservation ID: " + reservationID + "\n" +
                                "Shuttle Line: " + shuttleLine + "\n" +
                                "Date: " + date + "\n" +
                                "Time: " + time + "\n" +
                                "Origin: " + origin + "\n" +
                                "Destination: " + destination + "\n\n" +
                                "Do you want to edit this information?",
                                "Selected Reservation",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            // Code to edit the information
                            // For example, you can open a new dialog to edit the information
                            // or enable editing directly in the table
                            editReservation(selectedRow, reservationID, shuttleLine, date, time, origin, destination);
                        }
                    }
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        // Example usage

        // Create some dummy reservations
        List<Reservation> reservations = getUserReservations(); // Assume this method exists
        SwingUtilities.invokeLater(() -> {
            SRS5 userView = new SRS5(reservations);
            userView.setVisible(true);
        });
    }

    private void editReservation(int selectedRow, int reservationID, String shuttleLine, String date, String time, String origin, String destination) {
        // Sample data for JComboBox
        String[] shuttleLines = {"MNL<->LAG"};
        String[] destinations = {"MNL", "LAG"};
        String[] dates = {"2021-10-01", "2021-10-02", "2021-10-03", "2021-10-04", "2021-10-05"};
        String[] LagunaDepartureTimes = {"5:45", "6:15", "7:00", "8:00", "9:00", "11:00", "1:00", "2:30", "3:30", "5:10", "6:15", "7:45"};
        String[] ManilaDepartureTimes = {"6:00", "7:30", "9:30", "11:00", "1:00", "2:30", "3:30", "5:10", "6:15", "7:45"};
    
        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(new Color(108, 194, 162));
        outerPanel.setLayout(new GridBagLayout()); // Use GridBagLayout to center innerPanel
        outerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(new Color(53, 95, 79));
        innerPanel.setLayout(new GridBagLayout());
        innerPanel.setPreferredSize(new Dimension(600, 400)); // Set preferred size to make the panel larger
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        lineLabel = new JLabel("Shuttle Line:");
        lineLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lineLabel.setForeground(Color.WHITE);
		gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(lineLabel, gbc);

        lineComboBox = new JComboBox<>(shuttleLines);
        lineComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(lineComboBox, gbc);

        dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        dateLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(dateLabel, gbc);

        dateComboBox = new JComboBox<>(dates);
        dateComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(dateComboBox, gbc);

        timeLabel = new JLabel("Time:");
        timeLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        timeLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(timeLabel, gbc);

        timeComboBox = new JComboBox<>();
        timeComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(timeComboBox, gbc);

        originLabel = new JLabel("Origin:");
        originLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        originLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(originLabel, gbc);

        originValueLabel = new JLabel(origin);
        originValueLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        originValueLabel.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(originValueLabel, gbc);

        destinationLabel = new JLabel("Destination:");
        destinationLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        destinationLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(destinationLabel, gbc);
    
        destinationBox = new JComboBox<>(destinations);
        destinationBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(destinationBox, gbc);

        // Update destination box based on the selected origin
        lineComboBox.setSelectedItem(shuttleLine);
        dateComboBox.setSelectedItem(date);
        destinationBox.setSelectedItem(destination);
        updateTimeComboBox(timeComboBox, LagunaDepartureTimes, ManilaDepartureTimes);
        timeComboBox.setSelectedItem(time);

        // Add ActionListener to destinationBox to update the origin label
        destinationBox.addActionListener(e -> {
            String selectedDestination = (String) destinationBox.getSelectedItem();
            if ("MNL".equals(selectedDestination)) {
                originValueLabel.setText("LAG");
            } else if ("LAG".equals(selectedDestination)) {
                originValueLabel.setText("MNL");
            }
            updateTimeComboBox(timeComboBox, LagunaDepartureTimes, ManilaDepartureTimes);
        });

        int result = JOptionPane.showConfirmDialog(null, innerPanel, "Edit Reservation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            // Update the table model with the new values
            tableModel.setValueAt(lineComboBox.getSelectedItem(), selectedRow, 1);
            tableModel.setValueAt(dateComboBox.getSelectedItem(), selectedRow, 2);
            tableModel.setValueAt(timeComboBox.getSelectedItem(), selectedRow, 3);
            tableModel.setValueAt(originValueLabel.getText(), selectedRow, 4);
            tableModel.setValueAt(destinationBox.getSelectedItem(), selectedRow, 5);
        }
    }
    
    private void updateTimeComboBox(JComboBox<String> timeComboBox, String[] LagunaDepartureTimes, String[] ManilaDepartureTimes) {
        switch (originValueLabel.getText()) {
            case "LAG" -> timeComboBox.setModel(new DefaultComboBoxModel<>(LagunaDepartureTimes));
            case "MNL" -> timeComboBox.setModel(new DefaultComboBoxModel<>(ManilaDepartureTimes));
            default -> timeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{}));
        }
    }

    // Mock method to get user reservations
    private static List<Reservation> getUserReservations() {
        // This should be replaced with actual logic to fetch reservations
        return List.of(
            new Reservation(1, "MNL<->LAG", "2021-10-01", "9:30", "MNL", "LAG"),
            new Reservation(2, "MNL<->LAG", "2021-10-02", "9:30", "MNL", "LAG"),
            new Reservation(3, "MNL<->LAG", "2021-10-03", "9:30", "MNL", "LAG"),
            new Reservation(4, "MNL<->LAG", "2021-10-04", "9:30", "MNL", "LAG"),
            new Reservation(5, "MNL<->LAG", "2021-10-05", "9:30", "MNL", "LAG"),
            new Reservation(6, "MNL<->LAG", "2021-10-01", "5:10", "LAG", "MNL"),
            new Reservation(7, "MNL<->LAG", "2021-10-02", "5:10", "LAG", "MNL"),
            new Reservation(8, "MNL<->LAG", "2021-10-03", "5:10", "LAG", "MNL"),
            new Reservation(9, "MNL<->LAG", "2021-10-04", "5:10", "LAG", "MNL"),
            new Reservation(10, "MNL<->LAG", "2021-10-05", "5:10", "LAG", "MNL"),
            new Reservation(11, "MNL<->LAG", "2021-10-06", "9:30", "MNL", "LAG"),
            new Reservation(12, "MNL<->LAG", "2021-10-07", "9:30", "MNL", "LAG"),
            new Reservation(13, "MNL<->LAG", "2021-10-08", "9:30", "MNL", "LAG"),
            new Reservation(14, "MNL<->LAG", "2021-10-09", "9:30", "MNL", "LAG"),
            new Reservation(15, "MNL<->LAG", "2021-10-10", "9:30", "MNL", "LAG"),
            new Reservation(16, "MNL<->LAG", "2021-10-06", "5:10", "LAG", "MNL"),
            new Reservation(17, "MNL<->LAG", "2021-10-07", "5:10", "LAG", "MNL"),
            new Reservation(18, "MNL<->LAG", "2021-10-08", "5:10", "LAG", "MNL"),
            new Reservation(19, "MNL<->LAG", "2021-10-09", "5:10", "LAG", "MNL"),
            new Reservation(20, "MNL<->LAG", "2021-10-10", "5:10", "LAG", "MNL")

        );
    }
}

class Reservation {
    private int shuttleReservationID;
    private String shuttleLine;
    private String date;
    private String time;
    private String origin;
    private String destination;
    private boolean attendance = false;

    public Reservation(int shuttleReservationID, String shuttleLine, String date, String time, String origin, String destination) {
        this.shuttleReservationID = shuttleReservationID;
        this.shuttleLine = shuttleLine;
        this.date = date;
        this.time = time;
        this.origin = origin;
        this.destination = destination;
    }

    public String getShuttleLine() {
        return shuttleLine;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public boolean getAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public int getShuttleReservationID() {
        return shuttleReservationID;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }
}
