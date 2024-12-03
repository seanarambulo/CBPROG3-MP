
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;




    public class AdminSRSFRAME2_VERIFYREGISTRATIONS extends TableFrame {
    protected DLSU_SRSAdmin_controller Acontroller;
    protected ArrayList<Student> students;
    public AdminSRSFRAME2_VERIFYREGISTRATIONS(DLSU_SRSAdmin_controller Acontroller, ArrayList<Student> students) {
        super("Pending Reservations");
        this.Acontroller = Acontroller;
        this.students = students;
       
        DefaultTableModel tableModel = createTableModel();
        JTable table = new JTable(tableModel);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Add Submit button
        addButton("SUBMIT",tableModel);

        display();
    }
    @Override
protected void addButton(String buttonName, DefaultTableModel tableModel) {
    JButton submitButton = new JButton(buttonName);
    buttonPanel.add(submitButton);
    frame.add(buttonPanel, BorderLayout.SOUTH);
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Collect user IDs that should be updated
                ArrayList<Integer> userIdsToUpdate = new ArrayList<>();

                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    int userId = (int) tableModel.getValueAt(i, 0);
                    boolean allChecked = true;

                    // Check if all rows for this user ID have checkboxes ticked
                    for (int j = 0; j < tableModel.getRowCount(); j++) {
                        if ((int) tableModel.getValueAt(j, 0) == userId) {
                            boolean isChecked = (boolean) tableModel.getValueAt(j, 3);
                            if (!isChecked) {
                                allChecked = false;
                                break;
                            }
                        }
                    }

                    // If all checkboxes for this user ID are ticked, add to list
                    if (allChecked && !userIdsToUpdate.contains(userId)) {
                        userIdsToUpdate.add(userId);
                    }
                }

                // Update verification for all valid user IDs
                for (int userId : userIdsToUpdate) {
                    Acontroller.updateVerification(userId);
                }

                JOptionPane.showMessageDialog(frame, "Verification updated successfully!");
                frame.dispose();
                Acontroller.AdminSRSFRAME1_Menu_AdminController();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error updating verification: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });
}


    @Override
    protected DefaultTableModel createTableModel() {
        String[] columns = {"Student ID", "Day", "EAF", "Verify"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3; // Only the 'Verify' column is editable
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3) return Boolean.class; // Boolean for 'Verify' column
                return super.getColumnClass(columnIndex);
            }
        };

        // Populate table with reservations
        for (Student student: students) {
            tableModel.addRow(new Object[]{
                student.getUserID(),
                student.getClassDay(),
                student.getEAF(),
                false
            });
        }

        return tableModel;
    }
}