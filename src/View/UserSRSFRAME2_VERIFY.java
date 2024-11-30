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
    private final JComboBox<String> DesignationCB; // New ComboBox
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
        innerGbc.gridy = 1;
        innerGbc.gridwidth = 1;
        innerGbc.anchor = GridBagConstraints.CENTER;
        FullNameLabel3.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        FullNameLabel3.setForeground(Color.WHITE);
        FullNameLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        innerPanel.add(FullNameLabel3, innerGbc);

        // Center the fileTextField 
        innerGbc.gridx = 1;
        innerGbc.gridy = 1;
        innerGbc.gridwidth = 1;
        innerGbc.anchor = GridBagConstraints.CENTER;
        fileTextField.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        fileTextField.setForeground(new Color(102, 102, 102));
        fileTextField.setPreferredSize(new Dimension(200, 30)); // Adjust dimensions to match the button
        innerPanel.add(fileTextField, innerGbc);

        // Add DesignationCB
        DesignationCB = new JComboBox<>(new String[]{"College - Laguna Enrolled without class/es in Manila", "College - Laguna Enrolled with class/es in Manila", "College - Manila Enrolled without class/es in Laguna", "College - Manila Enrolled with class/es in Laguna", "Integrated School - Laguna Enrolled", "Integrated School - Manila Enrolled"});
        innerGbc.gridx = 1;
        innerGbc.gridy = 2; // Positioned below fileTextField
        innerGbc.gridwidth = 1;
        DesignationCB.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        DesignationCB.setForeground(new Color(102, 102, 102));
        DesignationCB.setPreferredSize(new Dimension(200, 30)); // Same dimensions as fileTextField
        innerPanel.add(DesignationCB, innerGbc);

        // Reset gridwidth and anchor for checkboxes
        innerGbc.gridwidth = 1;
        innerGbc.anchor = GridBagConstraints.CENTER;

        innerGbc.gridx = 0;
        innerGbc.gridy = 3;
        innerPanel.add(jCheckBox2, innerGbc);

        innerGbc.gridx = 0;
        innerGbc.gridy = 4;
        innerPanel.add(jCheckBox3, innerGbc);

        innerGbc.gridx = 0;
        innerGbc.gridy = 5;
        innerPanel.add(jCheckBox4, innerGbc);

        innerGbc.gridx = 1;
        innerGbc.gridy = 3;
        innerPanel.add(jCheckBox5, innerGbc);

        innerGbc.gridx = 1;
        innerGbc.gridy = 4;
        innerPanel.add(jCheckBox7, innerGbc);

        innerGbc.gridx = 1;
        innerGbc.gridy = 5;
        innerPanel.add(jCheckBox8, innerGbc);

        innerGbc.gridx = 0;
        innerGbc.gridy = 6;
        innerGbc.gridwidth = 2;
        jButton3.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        innerPanel.add(jButton3, innerGbc);

        jButton3.addActionListener(e -> {
            String EAFPath = fileTextField.getText();
            String Designation = (String) DesignationCB.getSelectedItem();
            if (EAFPath.isEmpty()){
                JOptionPane.showMessageDialog(outerPanel, "Please input an EAF path.");
            } else {
                if (jCheckBox2.isSelected()){
                    //monday query
                } if (jCheckBox3.isSelected()){
                    //tuesday query
                } if (jCheckBox4.isSelected()){
                    //wednesday query
                } if (jCheckBox5.isSelected()){
                    //thursday query
                } if (jCheckBox7.isSelected()){
                    //friday query
                } if (jCheckBox8.isSelected()){
                    //saturday query
                } if (!jCheckBox2.isSelected() || !jCheckBox3.isSelected() || !jCheckBox4.isSelected() || !jCheckBox5.isSelected() || !jCheckBox7.isSelected() || !jCheckBox8.isSelected()){
                    //no days selected query
                }
                // insert query
                JOptionPane.showMessageDialog(outerPanel, "Account successfully created");
                this.dispose();
                new SRS_LOGIN();
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
