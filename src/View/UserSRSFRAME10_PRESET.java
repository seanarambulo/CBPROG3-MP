package src.View;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.SQLException;
import java.util.List;
import src.Controller.DLSU_SRSUser_controller;
import src.Model.*;

public class UserSRSFRAME10_PRESET extends TableFrame {

    private static final String DESTINATION_MNL = "MNL";
    private static final String DESTINATION_LAG = "LAG";
    private static final String[] COLUMN_NAMES = {"Select", "Shuttle Line", "Time", "Origin", "Destination"};

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
    private JScrollPane mnlScrollPane;
    private JScrollPane lagScrollPane;

    public UserSRSFRAME10_PRESET(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;
        setDesignationTitle("Preset Booking", 20, 0, 0, 0);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    public void initComponets(){

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        presets = new ArrayList<>();

        List<ShuttleBookingView> shuttleBookings;

        try {

            shuttleBookings = controller.getShuttleBookings();

            Map<String, List<Object[]>> separatedData = separateDataByDestination(shuttleBookings);

            List<Object[]> mnlData = separatedData.get(DESTINATION_MNL);
            List<Object[]> lagData = separatedData.get(DESTINATION_LAG);

            mnlTableModel = createTableModel(COLUMN_NAMES);
            lagTableModel = createTableModel(COLUMN_NAMES);
    
            loadObjects(mnlTableModel, new ArrayList<>(mnlData));
            loadObjects(lagTableModel, new ArrayList<>(lagData));

            mnlReservationTable = createReservationTable(mnlTableModel);
            lagReservationTable = createReservationTable(lagTableModel);

            JScrollPane mnlScrollPane = createScrollPane(mnlReservationTable);
            JScrollPane lagScrollPane = createScrollPane(lagReservationTable);
    
        } catch (SQLException e) {
            e.printStackTrace();
            mnlReservationTable = new JTable();
            lagReservationTable = new JTable();
            mnlScrollPane = new JScrollPane(mnlReservationTable);
            lagScrollPane = new JScrollPane(lagReservationTable);
        }
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(createLabel("MNL<->LAG", 50, 50, new Dimension(400, 30), new Font("Helvetica Neue", Font.BOLD, 16), Color.BLACK));
        centerPanel.add(mnlScrollPane);
        centerPanel.add(createLabel("LAG<->MNL", 50, 100, new Dimension(400, 30), new Font("Helvetica Neue", Font.BOLD, 16), Color.BLACK));
        centerPanel.add(lagScrollPane);

        JPanel addPresetPanel = new JPanel(new BorderLayout());
        addPresetPanel.add(centerPanel, BorderLayout.CENTER);
        addPresetPanel.add(createButtonPanel(), BorderLayout.SOUTH);

        JPanel viewPresetsPanel = createViewPresetsPanel();

        mainPanel.add(addPresetPanel, "addPresetPanel");
        mainPanel.add(viewPresetsPanel, "viewPresetsPanel");

        innerPanel.add(mainPanel, BorderLayout.CENTER);
        innerPanel.revalidate();
        innerPanel.repaint();
    }

    private Map<String, List<Object[]>> separateDataByDestination(List<ShuttleBookingView> shuttleBookings) {
        Map<String, List<Object[]>> dataMap = new HashMap<>();
        dataMap.put(DESTINATION_MNL, new ArrayList<>());
        dataMap.put(DESTINATION_LAG, new ArrayList<>());

        for (ShuttleBookingView booking : shuttleBookings) {
            Object[] row = createRowFromBooking(booking);
            if (DESTINATION_MNL.equals(booking.getDestination())) {
                dataMap.get(DESTINATION_MNL).add(row);
            } else if (DESTINATION_LAG.equals(booking.getDestination())) {
                dataMap.get(DESTINATION_LAG).add(row);
            }
        }

        return dataMap;
    }

    private Object[] createRowFromBooking(ShuttleBookingView booking) {
        return new Object[]{
            false,
            booking.getArrowsExpressLine(),
            booking.getTime(),
            booking.getOrigin(),
            booking.getDestination()
        };
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        JButton savePresetButton = configureButton("Save as Preset", new Font("Helvetica Neue", Font.PLAIN, 20), Color.BLACK, 0, 0, new Dimension(150, 30), e -> saveSelectedReservationsAsPreset());
        JButton viewPresetsButton = configureButton("View Presets", new Font("Helvetica Neue", Font.PLAIN, 20), Color.BLACK, 0, 0, new Dimension(150, 30), e -> cardLayout.show(mainPanel, "viewPresetsPanel"));
        buttonPanel.add(savePresetButton);
        buttonPanel.add(viewPresetsButton);
        return buttonPanel;
    }

    private JPanel createViewPresetsPanel() {
        viewPresetTableModel = createTableModel(new String[]{"Shuttle Line", "Time", "Origin", "Destination"});
        viewPresetTable = createReservationTable(viewPresetTableModel);

        JScrollPane viewPresetScrollPane = createScrollPane(viewPresetTable);

        presetDropdown = new JComboBox<>();
        presetDropdown.addActionListener(e -> {
            String selectedPresetName = (String) presetDropdown.getSelectedItem();
            if (selectedPresetName != null) {
                updateViewPresetTable(Integer.parseInt(selectedPresetName));
            }
        });

        for (ShuttleBookingPreset preset : presets) {
            presetDropdown.addItem(String.valueOf(preset.getPresetID()));
        }

        JPanel viewPresetsPanel = new JPanel(new BorderLayout());
        viewPresetsPanel.add(presetDropdown, BorderLayout.NORTH);
        viewPresetsPanel.add(viewPresetScrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Add Preset");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "addPresetPanel"));
        viewPresetsPanel.add(backButton, BorderLayout.SOUTH);

        return viewPresetsPanel;
    }

    private void updateViewPresetTable(int presetID) {
        viewPresetTableModel.setRowCount(0); // Clear the table
        for (ShuttleBookingPreset preset : presets) {
            if (preset.getPresetID() == presetID) {
                for (ShuttleBookingView reservation : preset.get()) {
                    viewPresetTableModel.addRow(new Object[]{
                        reservation.getArrowsExpressLine(),
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

        saveSelectedReservationsFromTable(mnlTableModel, newPreset);
        saveSelectedReservationsFromTable(lagTableModel, newPreset);

        if (newPreset.getReservations().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No reservations selected!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            presets.add(newPreset);
            presetDropdown.addItem(newPreset.getPresetName()); // Add the new preset to the dropdown
            JOptionPane.showMessageDialog(this, "Reservation preset saved successfully!");
            resetCheckboxes();
        }
    }

    private void saveSelectedReservationsFromTable(DefaultTableModel tableModel, ShuttleBookingPreset newPreset) {
        for (int row = 0; row < tableModel.getRowCount(); row++) {
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
    }

    private void resetCheckboxes() {
        resetCheckboxesInTable(mnlTableModel);
        resetCheckboxesInTable(lagTableModel);
    }

    private void resetCheckboxesInTable(DefaultTableModel tableModel) {
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            tableModel.setValueAt(false, row, 0);
        }
    }

    @Override
    protected DefaultTableModel createTableModel(String[] columns) {
        return new DefaultTableModel(columns, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
    }

    @Override
    protected void loadObjects(DefaultTableModel tableModel, ArrayList<?> objectlist) {
        for (Object obj : objectlist) {
            if (obj instanceof ShuttleBookingPreset) {
                tableModel.addRow((Object[]) obj);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserSRSFRAME10_PRESET(new DLSU_SRSUser_controller()));
    }
}