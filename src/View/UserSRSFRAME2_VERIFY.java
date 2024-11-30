package src.View;

import java.awt.*;
import javax.swing.*;
import src.Controller.DLSU_SRSUser_controller;

public class UserSRSFRAME2_VERIFY extends FrameBackground {

    private final String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
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

        createLabel("Select EAF File:", 205, 80, new Dimension(300, 50), "Helvetica Neue", Font.BOLD, 20, Color.WHITE);
        createButton("Select a File", 205, 120, 300, 50, e -> {/* Action listener code */});

        for (int i = 0; i < days.length; i++) {
            checkBoxes[i] = createCheckbox(days[i]);
            int x = (i < 3) ? 205 : 355;
            int y = 180 + (i % 3) * 40;
            checkBoxes[i].setBounds(x, y, 150, 30);
            innerPanel.add(checkBoxes[i]);
        }

        createButton("Submit", 205, 300, 300, 50, e -> {/* Action listener code */});

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
