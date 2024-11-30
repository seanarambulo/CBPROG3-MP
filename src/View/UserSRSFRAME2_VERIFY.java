package src.View;

import java.awt.*;
import javax.swing.*;
import src.Controller.DLSU_SRSUser_controller;

public class UserSRSFRAME2_VERIFY extends FrameBackground {

    private final String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private final JComboBox<String> DesignationCB = new JComboBox<>(new String[]{"College - Laguna Enrolled without class/es in Manila", "College - Laguna Enrolled with class/es in Manila", "College - Manila Enrolled without class/es in Laguna", "College - Manila Enrolled with class/es in Laguna", "Integrated School - Laguna Enrolled", "Integrated School - Manila Enrolled"}); // New ComboBox
    private final JCheckBox[] checkBoxes = new JCheckBox[days.length];
    private DLSU_SRSUser_controller controller;

    public UserSRSFRAME2_VERIFY(DLSU_SRSUser_controller controller) {
        super();
        this.controller = controller;
        setDesignationTitle("Verify Schedule", 20, 0, 0, 0);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    public void initComponets() {
        innerPanel.setLayout(null);

        createLabel("Select EAF File:", 205, 80, new Dimension(300, 50), new Font("Helvetica Neue", Font.BOLD, 20), Color.WHITE);
        createButton("Select a File", 205, 120, 300, 50, e -> {/* Action listener code */});

        DesignationCB.setBounds(205, 180, 400, 50); // Made wider
        DesignationCB.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        DesignationCB.setForeground(new Color(102, 102, 102));
        DesignationCB.setPreferredSize(new Dimension(200, 30)); // Same dimensions as fileTextField
        innerPanel.add(DesignationCB);

        for (int i = 0; i < days.length; i++) {
            checkBoxes[i] = createCheckbox(days[i]);
            int x = (i < 3) ? 205 : 405; // Adjusted x position for wider checkboxes
            int y = 240 + (i % 3) * 40; // Shifted down by 60 pixels
            checkBoxes[i].setBounds(x, y, 200, 30); // Made wider
            innerPanel.add(checkBoxes[i]);
        }

        createButton("Submit", 205, 360, 400, 50, e -> {
            
            new SRS_LOGIN();
        }); // Made wider

    }

    private JCheckBox createCheckbox(String text) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        checkBox.setForeground(new Color(108, 194, 162));
        checkBox.setBackground(Color.WHITE);
        return checkBox;
    }
}
