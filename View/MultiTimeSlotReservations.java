import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiTimeSlotReservations {

    String[] LagunaDepartureTimes = {"5:45", "6:15", "7:00", "8:00", "9:00", "11:00", "1:00", "2:30", "3:30", "5:10", "6:15", "7:45"};
    String[] ManilaDepartureTimes = {"6:00", "7:30", "9:30", "11:00", "1:00", "2:30", "3:30", "5:10", "6:15", "7:45"};

    public static void main(String[] args) {
        JFrame frame = new JFrame("Reservations with Timeslots");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());

        // Header label
        JLabel headerLabel = new JLabel("Reservations - Timeslot Attendance", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(headerLabel, BorderLayout.NORTH);

        // Create route selection panel
        JPanel routePanel = new JPanel();
        routePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JComboBox<String> routeSelector = new JComboBox<>(new String[]{"MNL->LAG", "LAG->MNL"});
        routePanel.add(new JLabel("Select Route: "));
        routePanel.add(routeSelector);
        frame.add(routePanel, BorderLayout.PAGE_START);

        // Main panel to hold all tables
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(220, 240, 220));

        // Create panels for each route
        JPanel mnlToLagPanel = createMNLtoLAGPanel();
        JPanel lagToMnlPanel = createLAGtoMNLPanel();

        // Add to card layout
        JPanel cardPanel = new JPanel(new CardLayout());
        cardPanel.add(mnlToLagPanel, "MNL->LAG");
        cardPanel.add(lagToMnlPanel, "LAG->MNL");

        // Add card panel to scroll pane
        JScrollPane scrollPane = new JScrollPane(cardPanel);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Route selector action listener
        routeSelector.addActionListener(e -> {
            CardLayout cl = (CardLayout) cardPanel.getLayout();
            cl.show(cardPanel, (String) routeSelector.getSelectedItem());
        });

        // Submit button
        JButton submitButton = new JButton("SUBMIT");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setBackground(new Color(44, 100, 84));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(submitButton, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel createMNLtoLAGPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] timeSlots = {"6:00 AM", "7:30 AM", "9:30 AM", "11:00 AM", "1:00 PM", "2:30 PM", "3:30 PM", "5:10 PM", "6:15 PM", "7:45 PM"};
        JComboBox<String> timeSlotSelector = new JComboBox<>(timeSlots);
        timeSlotSelector.setMaximumSize(new Dimension(Integer.MAX_VALUE, timeSlotSelector.getPreferredSize().height));
        panel.add(new JLabel("Select Time Slot: "));
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(timeSlotSelector);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(tablePanel);

        timeSlotSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTimeSlot = (String) timeSlotSelector.getSelectedItem();
                Object[][] data = getMNLtoLAGData(selectedTimeSlot);
                updateTable(tablePanel, selectedTimeSlot, data);
            }
        });

        // Initialize with the first time slot
        timeSlotSelector.setSelectedIndex(0);

        return panel;
    }

    private static JPanel createLAGtoMNLPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] timeSlots = {"5:45 AM", "6:15 AM", "7:00 AM", "8:00 AM", "9:00 AM", "11:00 AM", "1:00 PM", "2:30 PM", "3:30 PM", "5:10 PM", "6:15 PM", "7:45 PM"};
        JComboBox<String> timeSlotSelector = new JComboBox<>(timeSlots);
        timeSlotSelector.setMaximumSize(new Dimension(Integer.MAX_VALUE, timeSlotSelector.getPreferredSize().height));
        panel.add(new JLabel("Select Time Slot: "));
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(timeSlotSelector);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(tablePanel);

        timeSlotSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTimeSlot = (String) timeSlotSelector.getSelectedItem();
                Object[][] data = getLAGtoMNLData(selectedTimeSlot);
                updateTable(tablePanel, selectedTimeSlot, data);
            }
        });

        // Initialize with the first time slot
        timeSlotSelector.setSelectedIndex(0);

        return panel;
    }

    private static void updateTable(JPanel tablePanel, String timeSlot, Object[][] data) {
        tablePanel.removeAll();

        String[] columnNames = {"Name", "CheckMark"};
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 1 ? Boolean.class : String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 1;
            }
        };

        JTable table = new JTable(tableModel);
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane tableScrollPane = new JScrollPane(table);
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);

        tablePanel.revalidate();
        tablePanel.repaint();
    }

    private static Object[][] getMNLtoLAGData(String timeSlot) {
        switch (timeSlot) {
            case "6:00 AM":
                return new Object[][]{{"John Doe", false}, {"Jane Smith", true}};
            case "7:30 AM":
                return new Object[][]{{"Bob Johnson", false}, {"Emily Davis", true}};
            case "9:30 AM":
                return new Object[][]{{"Charlie Brown", false}, {"Fiona Wilson", true}};
            case "11:00 AM":
                return new Object[][]{{"George Harris", false}, {"Hannah Taylor", true}};
            case "1:00 PM":
                return new Object[][]{{"Ivy Young", false}, {"Jack White", true}};
            case "2:30 PM":
                return new Object[][]{{"Kelly Green", false}, {"Liam Harris", true}};
            case "3:30 PM":
                return new Object[][]{{"Mia Brown", false}, {"Noah Wilson", true}};
            case "5:10 PM":
                return new Object[][]{{"Olivia Harris", false}, {"Peter Taylor", true}};
            case "6:15 PM":
                return new Object[][]{{"Quinn Young", false}, {"Rachel White", true}};
            case "7:45 PM":
                return new Object[][]{{"Samuel Green", false}, {"Tina Harris", true}};
            default:
                return new Object[][]{};
        }
    }

    private static Object[][] getLAGtoMNLData(String timeSlot) {
        switch (timeSlot) {
            case "5:45 AM":
                return new Object[][]{{"Sara Wilson", false}, {"Tom White", true}};
            case "6:15 AM":
                return new Object[][]{{"Alice Brown", false}, {"Chris Lee", true}};
            case "7:00 AM":
                return new Object[][]{{"Mike Green", false}, {"Linda Hall", true}};
            case "8:00 AM":
                return new Object[][]{{"Samuel King", false}, {"Olivia Scott", true}};
            case "9:00 AM":
                return new Object[][]{{"Henry Young", false}, {"Sophia Adams", true}};
            case "11:00 AM":
                return new Object[][]{{"Ella Baker", false}, {"William Clark", true}};
            case "1:00 PM":
                return new Object[][]{{"Ava Evans", false}, {"Jack Hill", true}};
            case "2:30 PM":
                return new Object[][]{{"Grace King", false}, {"James Lee", true}};
            case "3:30 PM":
                return new Object[][]{{"Nora Martin", false}, {"Oscar Nelson", true}};
            case "5:10 PM":
                return new Object[][]{{"Penny Olson", false}, {"Quinn Parker", true}};
            case "6:15 PM":
                return new Object[][]{{"Rose Quinn", false}, {"Ryan Smith", true}};
            case "7:45 PM":
                return new Object[][]{{"Samantha Taylor", false}, {"Toby Underwood", true}};
            default:
                return new Object[][]{};
        }
    }
}