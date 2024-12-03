
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.*;


public class UserSRSFRAME8_REGULAR extends FrameBackground {
    // UI components
    private JComboBox<String> timeComboBox;
    private JComboBox<String> dateComboBox;
  
    private JLabel lineLabel;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private DLSU_SRSUser_controller controller;
    private ShuttleBookingView booking;


    public UserSRSFRAME8_REGULAR(DLSU_SRSUser_controller controller, ShuttleBookingView booking) {
        super();
        this.controller = controller;
        this.booking = booking;

        setDesignationTitle("Add Reservation", 30, 0, 0, 0);
        SwingUtilities.invokeLater(() -> {
            initComponets();
        });
    }

    @Override
public void initComponets() {
    innerPanel.setLayout(null);

    int panelWidth = innerPanel.getWidth();
    ArrayList<String> times = controller.getTimesForLine(booking.getArrowsExpressLine());
    ArrayList<String> dateList = new ArrayList<>();
    populateDateArray(dateList);

    if (times == null || times.isEmpty()) {
        times = new ArrayList<>();
        times.add("No times available"); // Fallback message
    }

    // Time ComboBox
    createLabel("Time:", (panelWidth - 80) / 2 - 200, 100, new Dimension(80, 40), new Font("Segoe UI", Font.PLAIN, 24), Color.BLACK);
    timeComboBox = new JComboBox<>(times.toArray(new String[0])); // Populate time comboBox
    timeComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 24));
    timeComboBox.setBounds((panelWidth - 400) / 2 + 80, 100, 300, 50);
    timeComboBox.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setVerticalAlignment(SwingConstants.CENTER);
            return label;
        }
    });
    innerPanel.add(timeComboBox);

    // Date Label and ComboBox
    createLabel("Date:", (panelWidth - 80) / 2 - 200, 180, new Dimension(80, 40), new Font("Segoe UI", Font.PLAIN, 24), Color.BLACK);
    dateComboBox = new JComboBox<>(dateList.toArray(new String[0])); // Populate date comboBox with dateList
    dateComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 24));
    dateComboBox.setBounds((panelWidth - 400) / 2 + 80, 180, 300, 50);
    dateComboBox.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setVerticalAlignment(SwingConstants.CENTER);
            return label;
        }
    });
    innerPanel.add(dateComboBox);

    // Submit Button
    createButton("SUBMIT", (panelWidth - 150) / 2 - 80, 350, 150, 50, e -> handleSubmitAction());

    // Back Button
    createButton("BACK", (panelWidth - 150) / 2 + 80, 350, 150, 50, e -> handleBackAction());

    innerPanel.revalidate();
    innerPanel.repaint();
}


private void handleSubmitAction() {
    // Get the selected items from the combo boxes
    String selectedTime = (String) timeComboBox.getSelectedItem();
    String selectedDate = (String) dateComboBox.getSelectedItem();
   

    // Update the booking object
  
    booking.setDate(selectedDate);
    booking.setTime(selectedTime);

    // Pass the booking object to the controller method
    int lineID = controller.getLineIDByLineName(booking.getArrowsExpressLine());
    int timeID = controller.getTimeIDByTime(selectedTime);
        controller.insertBooking(false,booking.getOrigin(),booking.getDestination(),selectedDate, lineID,controller.getUserID_userController(),timeID);
    // Provide feedback to the user
    
    // Close the current frame or perform other actions as needed
    this.dispose();
}


    private void handleBackAction() {
        this.dispose();
        controller.SRSFRAME4_ADDSHUTTLEBOOKING_userController();
        // You can close this frame or perform other actions here
    }

    private void populateDateArray(ArrayList<String> dateList) {
        // Formatter for the dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ArrayList<String> classDays = controller.getDayNamesByStudentID(controller.getUserID_userController());
    
        
    
        // Get today's date
        LocalDate today = LocalDate.now();
    
        // Iterate through the next 21 days (3 weeks)
        for (int i = 1; i <= 21; i++) {
            LocalDate date = today.plusDays(i);
            String dayOfWeek = date.getDayOfWeek().toString(); // Get day of the week in uppercase
    
            // Check if the day is in the classDays list
            if (classDays.contains(dayOfWeek)) {
                dateList.add(date.format(formatter)); // Add the date to the list
            }
        }
    }
    
    
}
