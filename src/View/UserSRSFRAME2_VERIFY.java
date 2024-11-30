package src.View;

import java.awt.*;
import javax.swing.*;
import src.Controller.DLSU_SRSUser_controller;

public class UserSRSFRAME2_VERIFY extends FrameBackground {

    private final JLabel FullNameLabel3 = new JLabel("Select EAF File:");
    private final JTextField fileTextField = new JTextField();
    private final JButton jButton3 = new JButton("Submit");
    private final JCheckBox jCheckBox2 = createCheckbox("Monday");
    private final JCheckBox jCheckBox3 = createCheckbox("Tuesday");
    private final JCheckBox jCheckBox4 = createCheckbox("Wednesday");
    private final JCheckBox jCheckBox5 = createCheckbox("Thursday");
    private final JCheckBox jCheckBox7 = createCheckbox("Friday");
    private final JCheckBox jCheckBox8 = createCheckbox("Saturday");
    private DLSU_SRSUser_controller controller;

    public UserSRSFRAME2_VERIFY(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    public void initComponets() {
        setDesignationTitle("Verify Schedule");

        // Center the FullNameLabel3
        innerGbc.gridx = 0;
        innerGbc.gridy = 0; // Move up one position
        innerGbc.gridwidth = 2; // Span across two columns
        innerGbc.anchor = GridBagConstraints.CENTER;
        FullNameLabel3.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        FullNameLabel3.setForeground(Color.WHITE);
        FullNameLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        innerPanel.add(FullNameLabel3, innerGbc);

        // Center the fileTextField
        innerGbc.gridx = 0;
        innerGbc.gridy = 1;
        innerGbc.gridwidth = 2; // Span across two columns
        innerGbc.anchor = GridBagConstraints.CENTER;
        fileTextField.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        fileTextField.setForeground(new Color(102, 102, 102));
        fileTextField.setPreferredSize(new Dimension(300, 30)); // Adjust dimensions
        innerPanel.add(fileTextField, innerGbc);

        // Add Checkboxes
        innerGbc.gridwidth = 1; // Reset gridwidth for individual components
        innerGbc.anchor = GridBagConstraints.WEST; // Align to the left

        // First column checkboxes
        innerGbc.gridx = 0;
        innerGbc.gridy = 2;
        innerPanel.add(jCheckBox2, innerGbc);

        innerGbc.gridy = 3;
        innerPanel.add(jCheckBox3, innerGbc);

        innerGbc.gridy = 4;
        innerPanel.add(jCheckBox4, innerGbc);

        // Second column checkboxes
        innerGbc.gridx = 1;
        innerGbc.gridy = 2;
        innerPanel.add(jCheckBox5, innerGbc);

        innerGbc.gridy = 3;
        innerPanel.add(jCheckBox7, innerGbc);

        innerGbc.gridy = 4;
        innerPanel.add(jCheckBox8, innerGbc);

        // Add Submit Button
        innerGbc.gridx = 0;
        innerGbc.gridy = 5;
        innerGbc.gridwidth = 2; // Center the button across both columns
        innerGbc.anchor = GridBagConstraints.CENTER;
        jButton3.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        innerPanel.add(jButton3, innerGbc);

        // Add ActionListener for the Submit button
        jButton3.addActionListener(e -> {
            String EAFPath = fileTextField.getText();
            if (EAFPath.isEmpty()) {
                JOptionPane.showMessageDialog(outerPanel, "Please input an EAF path.");
                return;
            }

            // Validate that at least one checkbox is selected
            boolean isAnyDaySelected = jCheckBox2.isSelected() || jCheckBox3.isSelected() ||
                                       jCheckBox4.isSelected() || jCheckBox5.isSelected() ||
                                       jCheckBox7.isSelected() || jCheckBox8.isSelected();

            if (!isAnyDaySelected) {
                JOptionPane.showMessageDialog(outerPanel, "Please select at least one day.");
                return;
            }

            // Placeholder for database operations or other logic
            try {
                // Perform database insert operations here
                JOptionPane.showMessageDialog(outerPanel, "Account successfully created");
                this.dispose();
                new SRS_LOGIN(); // Ensure this initializes correctly
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(outerPanel, "Error creating account: " + ex.getMessage());
            }
        });
    }

    private JCheckBox createCheckbox(String text) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        checkBox.setForeground(new Color(108, 194, 162));
        checkBox.setBackground(Color.WHITE);
        return checkBox;
    }
}
