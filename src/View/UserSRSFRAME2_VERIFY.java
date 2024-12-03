
import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;



public class UserSRSFRAME2_VERIFY extends FrameBackground {

    private final String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private final JComboBox<String> DesignationCB = new JComboBox<>(new String[]{"College - Laguna Enrolled without class/es in Manila", "College - Laguna Enrolled with class/es in Manila", "College - Manila Enrolled without class/es in Laguna", "College - Manila Enrolled with class/es in Laguna", "Integrated School - Laguna Enrolled", "Integrated School - Manila Enrolled"});
    private final JCheckBox[] checkBoxes = new JCheckBox[days.length];
    private DatabaseManager dbm;
    private int studentID;

    public UserSRSFRAME2_VERIFY(int studentID) {
        super();
        this.studentID = studentID;
        try {
            this.dbm = new DatabaseManager();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setDesignationTitle("Verify Schedule", 20, 0, 0, 0);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    public void initComponets() {
        innerPanel.setLayout(null);

        createLabel("Select EAF File:", 205, 80, new Dimension(300, 50), new Font("Helvetica Neue", Font.BOLD, 20), Color.WHITE);

        // Create a JTextField instead of a button
        JTextField fileTextField = new JTextField();
        fileTextField.setBounds(205, 120, 300, 50); // Same size and position as the previous button
        fileTextField.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        innerPanel.add(fileTextField);

        DesignationCB.setBounds(205, 180, 400, 50); // Made wider
        DesignationCB.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        DesignationCB.setForeground(new Color(102, 102, 102));
        DesignationCB.setPreferredSize(new Dimension(200, 30));
        innerPanel.add(DesignationCB);

        for (int i = 0; i < days.length; i++) {
            checkBoxes[i] = createCheckbox(days[i]);
            int x = (i < 3) ? 205 : 405; // Adjusted x position for wider checkboxes
            int y = 240 + (i % 3) * 40; // Shifted down by 60 pixels
            checkBoxes[i].setBounds(x, y, 200, 30); // Made wider
            innerPanel.add(checkBoxes[i]);
        }

        createButton("Submit", 205, 360, 400, 50, e -> {
            
            String eaf = fileTextField.getText();

            try {
                // Insert the student record
                String enrolledAs = (String) DesignationCB.getSelectedItem();
                dbm.insertIntoStudent(studentID, 1, eaf, false, enrolledAs);

                // Loop through checkboxes and insert selected days into the database
                for (int i = 0; i < checkBoxes.length; i++) {
                    if (checkBoxes[i].isSelected()) {
                        System.out.println("Inserting: studentID=" + studentID + ", day=" + i+1);
                        dbm.insertIntoClassDays(i + 1 ,studentID); // Assuming days are indexed 1-6 (Monday = 1, Saturday = 6)
                    }
                }

                JOptionPane.showMessageDialog(innerPanel, "Schedule verified successfully!");
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(innerPanel, "An error occurred while verifying the schedule.", "Error", JOptionPane.ERROR_MESSAGE);
            }

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
