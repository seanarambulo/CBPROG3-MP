import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShuttleRouteMenu {

    private JLabel titleLabel;
    private JLabel lineLabel;
    private JComboBox<String> lineComboBox;
    private JLabel originLabel;
    private JComboBox<String> originComboBox;
    private JLabel designationTitle;
    private JButton submitButton;
    private JButton backButton;
    private JComboBox<String> destinationComboBox;
    private JLabel destinationLabel;

    private ArrayList<String> lineList;
    private ArrayList<String> originList;
    private ArrayList<String> destinationList;

    public ShuttleRouteMenu(DLSU_SRSAdmin_controller Acontroller) {
        initComponents(Acontroller);
    }

    private void initComponents(DLSU_SRSAdmin_controller Acontroller) {
        // Initialize ArrayLists for ComboBox items
        lineList = new ArrayList<>();
        originList = new ArrayList<>();
        destinationList = new ArrayList<>();

        // Populate ArrayLists
        lineList.add("Line 1");
        lineList.add("Line 2");
        lineList.add("Line 3");
        lineList.add("Line 4");
        lineList.add("Line 5");

        originList.add("Laguna");
        originList.add("Manila");
        originList.add("Paseo");

        destinationList.add("Laguna");
        destinationList.add("Manila");
        destinationList.add("Paseo");

        // Convert ArrayLists to ComboBox items
        lineComboBox = new JComboBox<>(lineList.toArray(new String[0]));
        originComboBox = new JComboBox<>(originList.toArray(new String[0]));
        destinationComboBox = new JComboBox<>(destinationList.toArray(new String[0]));

        JFrame frame = new JFrame("Dispatcher Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(810, 530);
        frame.setResizable(false); // Make the frame non-resizable
        frame.setLayout(new BorderLayout());

        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(new Color(108, 194, 162));
        outerPanel.setLayout(new GridBagLayout()); // Use GridBagLayout to center innerPanel
        outerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(new Color(53, 95, 79));
        innerPanel.setLayout(new GridBagLayout());
        innerPanel.setPreferredSize(new Dimension(710, 430)); // Set preferred size to make the panel larger
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        designationTitle = new JLabel("DLSU Shuttle Reservation");
        designationTitle.setFont(new Font("Baskerville", Font.PLAIN, 36));
        designationTitle.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        innerPanel.add(designationTitle, gbc);

        titleLabel = new JLabel("Dispatcher Menu");
        titleLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        innerPanel.add(titleLabel, gbc);

        lineLabel = new JLabel("Line:");
        lineLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lineLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(lineLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(lineComboBox, gbc);

        originLabel = new JLabel("Origin:");
        originLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        originLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(originLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(originComboBox, gbc);

        destinationLabel = new JLabel("Destination:");
        destinationLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        destinationLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        innerPanel.add(destinationLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        innerPanel.add(destinationComboBox, gbc);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gbc.gridx = 1;  
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;  
        innerPanel.add(submitButton, gbc);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        gbc.gridx = 0;  
        gbc.anchor = GridBagConstraints.EAST;  
        innerPanel.add(backButton, gbc);


        // Add ActionListener to Submit Button
        submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                                frame.dispose();
                                Acontroller.ADMINSRSFRAME_VIEWSHUTTLEROUTES();
                                //Acontroller.DispatcherCheckReservation((String) lineComboBox.getSelectedItem(),
                                                                       // (String) originComboBox.getSelectedItem(),
                                                                       // (String) destinationComboBox.getSelectedItem());

            }
        });

        // Add ActionListener to Back Button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current frame
                System.out.println("Back button clicked. Returning to the previous menu.");
            }
        });

        GridBagConstraints outerGbc = new GridBagConstraints();
        outerGbc.gridx = 0;
        outerGbc.gridy = 0;
        outerGbc.anchor = GridBagConstraints.CENTER;
        outerPanel.add(innerPanel, outerGbc);

        frame.getContentPane().add(outerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    
}
