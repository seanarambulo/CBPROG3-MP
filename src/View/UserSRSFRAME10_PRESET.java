package src.View;

import java.awt.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import src.Controller.DLSU_SRSUser_controller;
import src.Model.*;

public class UserSRSFRAME10_PRESET extends TableFrame {


    private static final String DESTINATION_MNL = "MANILA";
    private static final String DESTINATION_LAG = "LAGUNA";
    private static final String[] COLUMN_NAMES = {"Select", "Shuttle Line", "Time", "Origin", "Destination"};

    private JTable mnlReservationTable;
    private DefaultTableModel mnlTableModel;
    private JTable lagReservationTable;
    private DefaultTableModel lagTableModel;
    private JTable viewPresetTable;
    private DefaultTableModel viewPresetTableModel;
    private ArrayList<ShuttleBookingPreset> presets;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JComboBox<String> presetDropdown;
    private DLSU_SRSUser_controller controller;
    private JScrollPane mnlScrollPane;
    private JScrollPane lagScrollPane;
    private ArrayList<ShuttleBookingView> shuttleBookings;

    public UserSRSFRAME10_PRESET(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;
        System.out.println("Initializing UserSRSFRAME10_PRESET");
        setDesignationTitle("Preset Booking", 18, 0, 0, 0);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    public void initComponets(){
        System.out.println("Initializing components");
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        presets = new ArrayList<>();

        try {
            System.out.println("Fetching shuttle bookings");
            shuttleBookings = controller.getShuttleBookings();
            System.out.println(shuttleBookings);

            Map<String, ArrayList<ShuttleBookingView>> separatedData = separateDataByDestination(shuttleBookings);

            ArrayList<ShuttleBookingView> mnlData = new ArrayList<>();
            ArrayList<ShuttleBookingView> lagData = new ArrayList<>();

            for (ShuttleBookingView booking : separatedData.get(DESTINATION_MNL)) {
                mnlData.add(new ShuttleBookingView(booking.getArrowsExpressLine(), booking.getTime(), booking.getOrigin(), booking.getDestination()));
            }

            for (ShuttleBookingView booking : separatedData.get(DESTINATION_LAG)) {
                lagData.add(new ShuttleBookingView(booking.getArrowsExpressLine(), booking.getTime(), booking.getOrigin(), booking.getDestination()));
            }

            System.out.println("MNL DATA: " + mnlData);
            System.out.println("LAG DATA: " + lagData);

            mnlTableModel = createTableModel(COLUMN_NAMES);
            lagTableModel = createTableModel(COLUMN_NAMES);
    
            loadObjects(mnlTableModel, mnlData);
            loadObjects(lagTableModel, lagData);

            mnlReservationTable = createReservationTable(mnlTableModel);
            lagReservationTable = createReservationTable(lagTableModel);

            mnlScrollPane = createScrollPane(mnlReservationTable);
            lagScrollPane = createScrollPane(lagReservationTable);
    
        } catch (SQLException e) {
            e.printStackTrace();
            mnlReservationTable = new JTable();
            lagReservationTable = new JTable();
            mnlScrollPane = new JScrollPane(mnlReservationTable);
            lagScrollPane = new JScrollPane(lagReservationTable);
        }
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(createLabel("MANILA<-->LAGUNA", 50, 50, new Dimension(400, 30), new Font("Helvetica Neue", Font.BOLD, 16), Color.BLACK));
        centerPanel.add(mnlScrollPane);
        centerPanel.add(createLabel("LAGUNA<-->MANILA", 50, 100, new Dimension(400, 30), new Font("Helvetica Neue", Font.BOLD, 16), Color.BLACK));
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

    private Map<String, ArrayList<ShuttleBookingView>> separateDataByDestination(ArrayList<ShuttleBookingView> shuttleBookings) {

            System.out.println("Separating data by destination");
            Map<String, ArrayList<ShuttleBookingView>> dataMap = new HashMap<>();
            dataMap.put(DESTINATION_MNL, new ArrayList<>());
            dataMap.put(DESTINATION_LAG, new ArrayList<>());

            for (ShuttleBookingView booking : shuttleBookings) {
                if (DESTINATION_MNL.equals(booking.getDestination())) {
                    dataMap.get(DESTINATION_MNL).add(booking);
                } else if (DESTINATION_LAG.equals(booking.getDestination())) {
                    dataMap.get(DESTINATION_LAG).add(booking);
                }
            }
            return dataMap;
        }

    private Object[] createRowFromBooking(ShuttleBookingView booking) {
        System.out.println("Creating row from booking");
        return new Object[]{
            false,
            booking.getArrowsExpressLine(),
            booking.getTime(),
            booking.getOrigin(),
            booking.getDestination()
        };
    }

    private JPanel createButtonPanel() {
        System.out.println("Creating button panel");
        JPanel buttonPanel = new JPanel();
        JButton savePresetButton = configureButton("Save as Preset", new Font("Helvetica Neue", Font.PLAIN, 20), Color.BLACK, 0, 0, new Dimension(150, 30), e -> saveSelectedReservationsAsPreset());
        JButton viewPresetsButton = configureButton("View Presets", new Font("Helvetica Neue", Font.PLAIN, 20), Color.BLACK, 0, 0, new Dimension(150, 30), e -> cardLayout.show(mainPanel, "viewPresetsPanel"));
        buttonPanel.add(savePresetButton);
        buttonPanel.add(viewPresetsButton);
        return buttonPanel;
    }

    private JPanel createViewPresetsPanel() {
        System.out.println("Creating view presets panel");
        viewPresetTableModel = createTableModel(new String[]{"Shuttle Line", "Time", "Origin", "Destination"});
        viewPresetTable = createReservationTable(viewPresetTableModel);

        JScrollPane viewPresetScrollPane = createScrollPane(viewPresetTable);

        presetDropdown = new JComboBox<>();
        presetDropdown.addActionListener(e -> {
            String selectedPreset = (String) presetDropdown.getSelectedItem();
            if (selectedPreset != null) {
                updateViewPresetTable();
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

    private void updateViewPresetTable() {
        System.out.println("Updating view preset table");
        viewPresetTableModel.setRowCount(0); // Clear the table
        for (ShuttleBookingView reservation : shuttleBookings) {
            viewPresetTableModel.addRow(new Object[]{
                reservation.getArrowsExpressLine(),
                reservation.getTime(),
                reservation.getOrigin(),
                reservation.getDestination()
            }); 
        }
    }

    private void saveSelectedReservationsAsPreset() {
        System.out.println("Saving selected reservations as preset");
        saveSelectedReservationsFromTable(mnlTableModel);
        saveSelectedReservationsFromTable(lagTableModel);

        JOptionPane.showMessageDialog(this, "Reservation preset saved successfully!");
        resetCheckboxes();
    }

    private void saveSelectedReservationsFromTable(DefaultTableModel tableModel) {
        System.out.println("Saving selected reservations from table");
        int presetID = presets.size() + 1;
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            Boolean isSelected = (Boolean) tableModel.getValueAt(row, 0);
            if (isSelected != null && isSelected) {
                String shuttleLine = (String) tableModel.getValueAt(row, 1);
                String time = (String) tableModel.getValueAt(row, 2);
                String origin = (String) tableModel.getValueAt(row, 3);
                String destination = (String) tableModel.getValueAt(row, 4);

                ShuttleBookingPreset newPreset = new ShuttleBookingPreset(presetID, origin, destination, shuttleLine, time);
                presets.add(newPreset);
                presetDropdown.addItem(String.valueOf(newPreset.getPresetID())); // Add the new preset to the dropdown
            }
        }
    }

    private void resetCheckboxes() {
        System.out.println("Resetting checkboxes");
        resetCheckboxesInTable(mnlTableModel);
        resetCheckboxesInTable(lagTableModel);
    }

    private void resetCheckboxesInTable(DefaultTableModel tableModel) {
        System.out.println("Resetting checkboxes in table");
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            tableModel.setValueAt(false, row, 0);
        }
    }

    @Override
    protected DefaultTableModel createTableModel(String[] columns) {
        System.out.println("Creating table model");
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
        System.out.println("Loading objects into table model");
        for (Object obj : objectlist) {
            if (obj instanceof ShuttleBookingPreset preset) {
                tableModel.addRow(new Object[] {
                    false,
                    preset.getArrowsExpressLine(),
                    preset.getTime(),
                    preset.getOrigin(),
                    preset.getDestination()
                });
            }
        }
    }
}