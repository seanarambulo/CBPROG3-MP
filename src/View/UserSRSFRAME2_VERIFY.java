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

        FullNameLabel3.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        FullNameLabel3.setForeground(Color.WHITE);
        FullNameLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        FullNameLabel3.setBounds(205, 60, 300, 50); // Set bounds for absolute positioning
        innerPanel.add(FullNameLabel3);

        jButton2.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        jButton2.setForeground(new Color(102, 102, 102));
        jButton2.setBounds(205, 120, 300, 50); // Set bounds for absolute positioning
        innerPanel.add(jButton2);

        jCheckBox2.setBounds(205, 180, 150, 30); // Set bounds for absolute positioning
        innerPanel.add(jCheckBox2);

        jCheckBox3.setBounds(205, 220, 150, 30); // Set bounds for absolute positioning
        innerPanel.add(jCheckBox3);

        jCheckBox4.setBounds(205, 260, 150, 30); // Set bounds for absolute positioning
        innerPanel.add(jCheckBox4);

        jCheckBox5.setBounds(355, 180, 150, 30); // Set bounds for absolute positioning
        innerPanel.add(jCheckBox5);

        jCheckBox7.setBounds(355, 220, 150, 30); // Set bounds for absolute positioning
        innerPanel.add(jCheckBox7);

        jCheckBox8.setBounds(355, 260, 150, 30); // Set bounds for absolute positioning
        innerPanel.add(jCheckBox8);

        jButton3.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        jButton3.setBounds(205, 300, 300, 50); // Set bounds for absolute positioning
        innerPanel.add(jButton3);
        
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
