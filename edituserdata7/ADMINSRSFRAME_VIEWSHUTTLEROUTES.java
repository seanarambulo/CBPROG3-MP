import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ADMINSRSFRAME_VIEWSHUTTLEROUTES extends JFrame {

    private JTable reservationTable;
    private DefaultTableModel tableModel;
    private JComboBox<String> lineComboBox;
    private JButton backButton, editButton;

    protected DLSU_SRSAdmin_controller Acontroller;
    protected ArrayList<ShuttleRoute> shuttleRoutes;

    public ADMINSRSFRAME_VIEWSHUTTLEROUTES(DLSU_SRSAdmin_controller Acontroller, ArrayList<ShuttleRoute> shuttleRoutes) {
        this.Acontroller = Acontroller;
        this.shuttleRoutes = shuttleRoutes;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel for line label and combo box
        JPanel linePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lineLabel = new JLabel("Line:");
        lineComboBox = new JComboBox<>(new String[] {"Line 1", "Line 2", "Line 3", "Line 4", "Line 5"});
        linePanel.add(lineLabel);
        linePanel.add(lineComboBox);

        // Initialize table
        tableModel = new DefaultTableModel(new String[] {"Time", "Route"}, 0);
        reservationTable = new JTable(tableModel);
        reservationTable.setFillsViewportHeight(true);
        JScrollPane tableScrollPane = new JScrollPane(reservationTable);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButton = new JButton("Back");
        editButton = new JButton("Edit");
        buttonPanel.add(backButton);
        buttonPanel.add(editButton);

        // Add components to the frame
        add(linePanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set frame properties
        setTitle("View Shuttle Booking");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Action listeners for buttons
        backButton.addActionListener(e -> {
            this.dispose(); // Close the current window
            // You can implement the back action here if needed
        });

        editButton.addActionListener(e -> {
            // Create and show the UserSRSFRAME11_VIEWSHUTTLEROUTES frame when the Edit button is clicked
            // new ADMINSRSFRAME_EDITSHUTTLEROUTES();
            // this.dispose(); // Close the current frame (optional)
        });

        // Populate table with example data
        populateTable();
    }

    private void populateTable() {
        // Example data
        String[][] exampleData = {
            {"08:00 AM", "Mnl -> Lag"},
            {"09:00 AM", "Route B"},
            {"10:00 AM", "Route C"}
        };

        for (String[] row : exampleData) {
            tableModel.addRow(row);
        }
    }
}
