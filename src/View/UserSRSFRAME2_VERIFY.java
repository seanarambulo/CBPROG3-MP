package src.View;

import java.awt.*;
import javax.swing.*;
import src.Controller.DLSU_SRSUser_controller;

public class UserSRSFRAME2_VERIFY extends FrameBackground {

    private final JLabel FullNameLabel3 = new JLabel("Select EAF File:");
    private final JButton jButton2 = new JButton("Select a File");
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
        innerGbc.gridy = 1;
        innerGbc.gridwidth = 1;
        innerGbc.anchor = GridBagConstraints.CENTER;
        FullNameLabel3.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        FullNameLabel3.setForeground(Color.WHITE);
        FullNameLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        innerPanel.add(FullNameLabel3, innerGbc);

        // Center the jButton2
        innerGbc.gridx = 1;
        innerGbc.gridy = 1;
        innerGbc.gridwidth = 1;
        innerGbc.anchor = GridBagConstraints.CENTER;
        jButton2.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        jButton2.setForeground(new Color(102, 102, 102));
        innerPanel.add(jButton2, innerGbc);

        innerGbc.gridwidth = 1; // Reset gridwidth for checkboxes
        innerGbc.anchor = GridBagConstraints.CENTER; // Reset anchor for checkboxes

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
        
        // Revalidate and repaint to ensure the layout is updated
        innerPanel.revalidate();
        innerPanel.repaint();
    }

    private JCheckBox createCheckbox(String text) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        checkBox.setForeground(new Color(108, 194, 162));
        checkBox.setBackground(Color.WHITE);
        return checkBox;
    }
}
