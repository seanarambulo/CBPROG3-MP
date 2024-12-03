
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class UserSRSFRAME5_VIEWSHUTTLEBOOKING extends TableFrame2 {
    
    private final DLSU_SRSUser_controller controller;
    private ArrayList<ShuttleBookingView> shuttleBookings;
    private DefaultTableModel tableModel;
    private JTable reservationTable;
    private JScrollPane scrollPane;
    private JButton backButton, deleteButton;

    public UserSRSFRAME5_VIEWSHUTTLEBOOKING(DLSU_SRSUser_controller controller, ArrayList<ShuttleBookingView> shuttleBookings) {
        super();
        this.shuttleBookings = shuttleBookings;
        setDesignationTitle("View Bookings", 20, 0, 0, 0);
        this.controller = controller;
        initComponets();
    }

    @Override
    protected void initComponets() {        
        this.tableModel = createTableModel(new String[] {"Select", "Booking ID", "UserID", "Date", "Time", "Destination"});
        this.reservationTable = createReservationTable(this.tableModel);
        this.scrollPane = createScrollPane(this.reservationTable);

        innerPanel.setLayout(null);

        loadObjects(this.tableModel, this.shuttleBookings);

        this.scrollPane.setBounds(50, 70, 600, 300); // Adjust table position and size
        innerPanel.add(this.scrollPane);

        // Back button
        this.backButton = new JButton("Back");
        this.backButton.setBounds(200, 380, 100, 30); // Position button at the bottom left
        this.backButton.addActionListener(e -> {
            this.dispose(); // Close this frame
            controller.SRSFRAME3_USERINTERFACE_userController(); // Navigate to the previous menu
        });
        innerPanel.add(this.backButton);

        // Delete button
        this.deleteButton = new JButton("Delete");
        this.deleteButton.setBounds(400, 380, 100, 30); // Position button at the bottom right
        this.deleteButton.addActionListener(e -> {
            ArrayList<Integer> selectedBookingIDs = getSelectedBookingIDs();
            if (!selectedBookingIDs.isEmpty()) {
                for (Integer bookingID : selectedBookingIDs) {
                    controller.deleteBookings(bookingID); // Pass each ID individually to the controller
                }
                JOptionPane.showMessageDialog(this, "Selected bookings deleted successfully.");
                controller.SRSFRAME3_USERINTERFACE_userController();
            } else {
                JOptionPane.showMessageDialog(this, "No bookings selected for deletion.");
            }
        });
        innerPanel.add(this.deleteButton);

        innerPanel.revalidate();
        innerPanel.repaint();
    }

    @Override
    protected DefaultTableModel createTableModel(String[] columns) {
        return new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Only allow checkbox column to be editable
                return column == 0;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // Return Boolean class for the checkbox column
                if (columnIndex == 0) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
    }



    /**
     * Collects the Booking IDs of the rows where the checkbox is selected.
     *
     * @return ArrayList<Integer> containing selected Booking IDs.
     */
    private ArrayList<Integer> getSelectedBookingIDs() {
        ArrayList<Integer> selectedBookingIDs = new ArrayList<>();
        for (int i = 0; i < reservationTable.getRowCount(); i++) {
            Boolean isSelected = (Boolean) reservationTable.getValueAt(i, 0); // Check checkbox value
            if (isSelected != null && isSelected) {
                Integer bookingID = (Integer) reservationTable.getValueAt(i, 1); // Get Booking ID as Integer
                selectedBookingIDs.add(bookingID);
            }
        }
        return selectedBookingIDs;
    }

    @Override
    protected void loadObjects(DefaultTableModel tableModel, ArrayList<?> objs) {
        for (Object obj : objs) {
            if (obj instanceof ShuttleBookingView) {
                ShuttleBookingView reservation = (ShuttleBookingView) obj; // Proper casting
                tableModel.addRow(new Object[] {
                    false, // Checkbox initially unchecked
                    reservation.getShuttleBookingID(),
                    reservation.getUserID(),
                    reservation.getDate(),
                    reservation.getTime(),
                    reservation.getDestination()
                });
            }
        }
    }

}