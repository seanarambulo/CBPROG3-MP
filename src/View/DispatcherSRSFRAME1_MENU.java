package src.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import src.Controller.DLSU_SRSDispatcher_controller;

public class DispatcherSRSFRAME1_MENU extends FrameBackground {

    private JLabel titleLabel;
    private JComboBox<String> lineComboBox;
    private JComboBox<String> dateComboBox;
    private JComboBox<String> timeComboBox;
    private DLSU_SRSDispatcher_controller Dcontroller;
private final HashMap<String, String[]> lineLocations = new HashMap<>();
    private ArrayList<String> lineList;
    private ArrayList<String> dateList;
    private ArrayList<String> timeList;

    public DispatcherSRSFRAME1_MENU(DLSU_SRSDispatcher_controller Dcontroller) {
        super();
        setDesignationTitle("Dispatcher Menu", 30, 0, 0, 0);
        this.Dcontroller = Dcontroller;
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    protected void initComponets() {

        Dimension buttonSize = new Dimension(100, 50);
        Font buttonFont = new Font("Helvetica Neue", Font.BOLD, 18);
        Color buttonColor = Color.WHITE;

        innerPanel.setLayout(null);
        int panelWidth = innerPanel.getWidth();
        int xPosition = (panelWidth - buttonSize.width) / 2;
        int yPosition = 100; // Starting y position
        int yOffset = 70; // Vertical space between buttons

        // Initialize ArrayLists for ComboBox items
       
        dateList = new ArrayList<>();
        timeList = new ArrayList<>();

        lineLocations.put("MANILA<-->LAGUNA", new String[]{"MANILA", "LAGUNA"});
        lineLocations.put("PASEO<-->LAGUNA", new String[]{"PASEO", "LAGUNA"});
        lineLocations.put("CARMONA<-->LAGUNA", new String[]{"CARMONA", "LAGUNA"});
        lineLocations.put("PAVILION<-->LAGUNA", new String[]{"PAVILION", "LAGUNA"});
        lineLocations.put("WALTER<-->LAGUNA", new String[]{"WALTER", "LAGUNA"});

        timeList.add("10:00:00");
        timeList.add("13:00:00");
        timeList.add("6:00 PM");

        
        // Populate Date list (3 weeks ahead, excluding Sundays)
        populateDateComboBox();

        // Convert ArrayLists to ComboBox items
        lineComboBox = new JComboBox<>(lineLocations.keySet().toArray(new String[0]));
        dateComboBox = new JComboBox<>(dateList.toArray(new String[0]));
        timeComboBox = new JComboBox<>(timeList.toArray(new String[0]));

        titleLabel = new JLabel("Dispatcher Menu", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
        titleLabel.setForeground(Color.WHITE);
        innerPanel.add(titleLabel, BorderLayout.CENTER);

        createLabel("Line:", xPosition-230, yPosition, buttonSize, buttonFont, buttonColor);
        lineComboBox.setBounds(xPosition-100, yPosition, 300, 50);
        innerPanel.add(lineComboBox);

        yPosition += yOffset;
        createLabel("Date:", xPosition-230, yPosition, buttonSize, buttonFont, buttonColor);
        dateComboBox.setBounds(xPosition-100, yPosition, 300, 50);
        innerPanel.add(dateComboBox);

        yPosition += yOffset;
        createLabel("Time:", xPosition-230, yPosition, buttonSize, buttonFont, buttonColor);
        timeComboBox.setBounds(xPosition-100, yPosition, 300, 50);
        innerPanel.add(timeComboBox);
       
        yPosition += yOffset;   
            
        configureButton("Submit", buttonFont, Color.BLACK, xPosition+100, yPosition, buttonSize, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Dcontroller.DispatcherViewSRSFRAME2_CheckReservation_DispatchController((String) lineComboBox.getSelectedItem(),
                        (String) dateComboBox.getSelectedItem(),
                        (String) timeComboBox.getSelectedItem());
            }
        });

        configureButton("Back", buttonFont, Color.BLACK, xPosition-100, yPosition, buttonSize, e -> {
            this.dispose(); // Close the current frame
            System.out.println("Back button clicked. Returning to the previous menu.");
        });


    }

    private void populateDateComboBox() {
        // Formatter for the dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Get today's date
        LocalDate today = LocalDate.now();

        // Iterate through the next 21 days
        for (int i = 0; i < 21; i++) {
            LocalDate date = today.plusDays(i);
            // Check if the day is not Sunday
            if (!date.getDayOfWeek().name().equals("SUNDAY")) {
                dateList.add(date.format(formatter));
            }
        }
    }
}
