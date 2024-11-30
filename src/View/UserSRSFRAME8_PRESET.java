package src.View;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import src.Controller.DLSU_SRSUser_controller;
import src.Model.ShuttleBookingPreset;
import src.Model.ShuttleBookingView;

public class UserSRSFRAME8_PRESET extends FrameBackground {

    private JTable mnlReservationTable;
    private DefaultTableModel mnlTableModel;
    private JTable lagReservationTable;
    private DefaultTableModel lagTableModel;
    private JTable viewPresetTable;
    private DefaultTableModel viewPresetTableModel;
    private List<ShuttleBookingPreset> presets;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JComboBox<String> presetDropdown;
    private DLSU_SRSUser_controller controller;

    public UserSRSFRAME8_PRESET(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;
        setDesignationTitle("Preset Booking", 0, 0, 0, 0);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    public void initComponets() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        presets = new ArrayList<>();

        // Sample data for the tables
        String[] columnNames = {"Select", "Shuttle Line", "Time", "Origin", "Destination"};
        Object[][] data = {
                {false, "MNL<->LAG", "5:45 AM", "LAG", "MNL"},
                {false, "MNL<->LAG", "6:15 AM", "LAG", "MNL"},
                {false, "MNL<->LAG", "7:00 AM", "LAG", "MNL"},
                {false, "MNL<->LAG", "8:00 AM", "LAG", "MNL"},
                {false, "MNL<->LAG", "9:00 AM", "LAG", "MNL"},
                {false, "MNL<->LAG", "11:00 AM", "LAG", "MNL"},
                {false, "MNL<->LAG", "1:00 PM", "LAG", "MNL"},
                {false, "MNL<->LAG", "2:30 PM", "LAG", "MNL"},
                {false, "MNL<->LAG", "3:30 PM", "LAG", "MNL"},
                {false, "MNL<->LAG", "5:10 PM", "LAG", "MNL"},
                {false, "MNL<->LAG", "6:15 PM", "LAG", "MNL"},
                {false, "MNL<->LAG", "7:45 PM", "LAG", "MNL"},
                {false, "MNL<->LAG", "6:00 AM", "MNL", "LAG"},
                {false, "MNL<->LAG", "7:30 AM", "MNL", "LAG"},
                {false, "MNL<->LAG", "9:30 AM", "MNL", "LAG"},
                {false, "MNL<->LAG", "11:00 AM", "MNL", "LAG"},
                {false, "MNL<->LAG", "1:00 PM", "MNL", "LAG"},
                {false, "MNL<->LAG", "2:30 PM", "MNL", "LAG"},
                {false, "MNL<->LAG", "3:30 PM", "MNL", "LAG"},
                {false, "MNL<->LAG", "5:10 PM", "MNL", "LAG"},
                {false, "MNL<->LAG", "6:15 PM", "MNL", "LAG"},
                {false, "MNL<->LAG", "7:45 PM", "MNL", "LAG"}
        };

        // Separate data based on destination
        List<Object[]> mnlData = new ArrayList<>();
        List<Object[]> lagData = new ArrayList<>();
        for (Object[] row : data) {
            if ("MNL".equals(row[4])) {
                mnlData.add(row);
            } else if ("LAG".equals(row[4])) {
                lagData.add(row);
            }
        }

        // Create MNL reservation table
        mnlTableModel = new DefaultTableModel(mnlData.toArray(new Object[0][]), columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        mnlReservationTable = new JTable(mnlTableModel);

        // Customize MNL reservation table colors
        mnlReservationTable.setBackground(new Color(255, 255, 255)); // White background
        mnlReservationTable.setForeground(new Color(0, 0, 0)); // Black text
        mnlReservationTable.setSelectionBackground(new Color(108, 194, 168)); // Light green selection background
        mnlReservationTable.setSelectionForeground(new Color(255, 255, 255)); // White selection text

        // Customize MNL reservation table header colors
        JTableHeader mnlTableHeader = mnlReservationTable.getTableHeader();
        mnlTableHeader.setBackground(new Color(31, 95, 79)); // Dark green header background
        mnlTableHeader.setForeground(new Color(255, 255, 255)); // White header text

        JScrollPane mnlScrollPane = new JScrollPane(mnlReservationTable);

        // Create LAG reservation table
        lagTableModel = new DefaultTableModel(lagData.toArray(new Object[0][]), columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        lagReservationTable = new JTable(lagTableModel);

        // Customize LAG reservation table colors
        lagReservationTable.setBackground(new Color(255, 255, 255)); // White background
        lagReservationTable.setForeground(new Color(0, 0, 0)); // Black text
        lagReservationTable.setSelectionBackground(new Color(108, 194, 168)); // Light green selection background
        lagReservationTable.setSelectionForeground(new Color(255, 255, 255)); // White selection text

        // Customize LAG reservation table header colors
        JTableHeader lagTableHeader = lagReservationTable.getTableHeader();
        lagTableHeader.setBackground(new Color(31, 95, 79)); // Dark green header background
        lagTableHeader.setForeground(new Color(255, 255, 255)); // White header text

        JScrollPane lagScrollPane = new JScrollPane(lagReservationTable);

        // Create a panel with BoxLayout to hold the tables and labels
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Add MNL<->LAG label and table
        createLabel("MNL<->LAG", 50, 50, new Dimension(400, 30), new Font("Helvetica Neue", Font.BOLD, 16), Color.BLACK);
        centerPanel.add(mnlScrollPane);

        // Add LAG<->MNL label and table
        createLabel("LAG<->MNL", 50, 100, new Dimension(400, 30), new Font("Helvetica Neue", Font.BOLD, 16), Color.BLACK);
        centerPanel.add(lagScrollPane);

        // Add the center panel to the main panel
        JPanel addPresetPanel = new JPanel(new BorderLayout());
        addPresetPanel.add(centerPanel, BorderLayout.CENTER);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        configureButton("Save as Preset", new Font("Helvetica Neue", Font.PLAIN, 20), Color.BLACK, 0, 0, new Dimension(150, 30), e -> saveSelectedReservationsAsPreset());
        configureButton("View Presets", new Font("Helvetica Neue", Font.PLAIN, 20), Color.BLACK, 0, 0, new Dimension(150, 30), e -> cardLayout.show(mainPanel, "viewPresetsPanel"));
        buttonPanel.add(savePresetButton);
        buttonPanel.add(viewPresetsButton);
        addPresetPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Create the view presets panel
        JPanel viewPresetsPanel = createViewPresetsPanel();

        // Add both panels to the main panel
        mainPanel.add(addPresetPanel, "addPresetPanel");
        mainPanel.add(viewPresetsPanel, "viewPresetsPanel");

        // Add the main panel to the frame
        innerPanel.add(mainPanel, BorderLayout.CENTER);

        innerPanel.revalidate();
        innerPanel.repaint();
    }

    private JPanel createViewPresetsPanel() {
        // Create view preset table
        String[] viewPresetColumnNames = {"Shuttle Line", "Time", "Origin", "Destination"};
        viewPresetTableModel = new DefaultTableModel(viewPresetColumnNames, 0);
        viewPresetTable = new JTable(viewPresetTableModel);

        // Customize view preset table colors
        viewPresetTable.setBackground(new Color(255, 255, 255)); // White background
        viewPresetTable.setForeground(new Color(0, 0, 0)); // Black text
        viewPresetTable.setSelectionBackground(new Color(108, 194, 168)); // Light green selection background
        viewPresetTable.setSelectionForeground(new Color(255, 255, 255)); // White selection text

        // Customize view preset table header colors
        JTableHeader viewPresetTableHeader = viewPresetTable.getTableHeader();
        viewPresetTableHeader.setBackground(new Color(31, 95, 79)); // Dark green header background
        viewPresetTableHeader.setForeground(new Color(255, 255, 255)); // White header text

        JScrollPane viewPresetScrollPane = new JScrollPane(viewPresetTable);

        // Create a dropdown box to select a preset
        presetDropdown = new JComboBox<>();
        presetDropdown.addActionListener(e -> {
            String selectedPresetName = (String) presetDropdown.getSelectedItem();
            if (selectedPresetName != null) {
                updateViewPresetTable(selectedPresetName);
            }
        });

        // Populate the dropdown with preset names
        for (ShuttleBookingPreset preset : presets) {
            presetDropdown.addItem(preset.getPresetName());
        }

        // Create a panel to hold the dropdown and the view preset table
        JPanel viewPresetsPanel = new JPanel(new BorderLayout());
        viewPresetsPanel.add(presetDropdown, BorderLayout.NORTH);
        viewPresetsPanel.add(viewPresetScrollPane, BorderLayout.CENTER);

        // Add a button to switch back to the add presets panel
        JButton backButton = new JButton("Back to Add Preset");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "addPresetPanel"));
        viewPresetsPanel.add(backButton, BorderLayout.SOUTH);

        return viewPresetsPanel;
    }

    private void updateViewPresetTable(String presetName) {
        viewPresetTableModel.setRowCount(0); // Clear the table
        for (ShuttleBookingPreset preset : presets) {
            if (preset.getPresetName().equals(presetName)) {
                for (ShuttleBookingView reservation : preset.getReservations()) {
                    viewPresetTableModel.addRow(new Object[]{
                            reservation.getShuttleLine(),
                            reservation.getTime(),
                            reservation.getOrigin(),
                            reservation.getDestination()
                    });
                }
                break;
            }
        }
    }

    private void saveSelectedReservationsAsPreset() {
        int presetID = presets.size() + 1; // Generate a new preset ID
        ShuttleBookingPreset newPreset = new ShuttleBookingPreset(presetID);

        // Save selected reservations from MNL table
        for (int row = 0; row < mnlTableModel.getRowCount(); row++) {
            processReservationRow(mnlTableModel, row, newPreset);
        }

        // Save selected reservations from LAG table
        for (int row = 0; row < lagTableModel.getRowCount(); row++) {
            processReservationRow(lagTableModel, row, newPreset);
        }

        if (newPreset.getReservations().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No reservations selected!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            presets.add(newPreset);
            presetDropdown.addItem(newPreset.getPresetName()); // Add the new preset to the dropdown
            JOptionPane.showMessageDialog(this, "Reservation preset saved successfully!");
            resetCheckboxes(); // Reset all checkboxes
        }
    }

    private void processReservationRow(DefaultTableModel tableModel, int row, ShuttleBookingPreset newPreset) {
        Boolean isSelected = (Boolean) tableModel.getValueAt(row, 0);
        if (isSelected != null && isSelected) {
            String shuttleLine = (String) tableModel.getValueAt(row, 1);
            String time = (String) tableModel.getValueAt(row, 2);
            String origin = (String) tableModel.getValueAt(row, 3);
            String destination = (String) tableModel.getValueAt(row, 4);

            ShuttleBookingView reservation = new ShuttleBookingView(0, origin, destination, date, shuttleLine, time);
            newPreset.addReservation(reservation);
        }
    }

    private void resetCheckboxes() {
        // Reset checkboxes in MNL table
        for (int row = 0; row < mnlTableModel.getRowCount(); row++) {
            mnlTableModel.setValueAt(false, row, 0);
        }

        // Reset checkboxes in LAG table
        for (int row = 0; row < lagTableModel.getRowCount(); row++) {
            lagTableModel.setValueAt(false, row, 0);
        }
    }
}
