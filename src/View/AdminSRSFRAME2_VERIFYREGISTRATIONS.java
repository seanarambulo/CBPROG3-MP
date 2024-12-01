package src.View;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import src.Controller.DLSU_SRSAdmin_controller;
import src.Model.*;

public class AdminSRSFRAME2_VERIFYREGISTRATIONS extends TableFrame {
    private DLSU_SRSAdmin_controller Acontroller; 
    private ArrayList<Student> students;

    public AdminSRSFRAME2_VERIFYREGISTRATIONS(DLSU_SRSAdmin_controller Acontroller, ArrayList<Student> students) {
        super();
        this.Acontroller = Acontroller;
        this.students = students;
        setDesignationTitle("Pending Reservations", 20, 0, 0, 0);
        innerPanel.setLayout(null);
        SwingUtilities.invokeLater(() -> initComponets());
    }

    @Override
    protected void initComponets() {        
        this.tableModel = createTableModel(new String[] {"Student ID", "Day", "EAF", "Verify"});
        this.reservationTable = createReservationTable(this.tableModel);
        this.scrollPane = createScrollPane(this.reservationTable);
        innerPanel.add(this.scrollPane, BorderLayout.CENTER);
        
        JButton submitButton = createButton("SUBMIT", 0, 0, 100, 30, e -> {
            try {
                ArrayList<Integer> userIdsToUpdate = new ArrayList<>();

                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    int userId = (int) tableModel.getValueAt(i, 0);
                    boolean allChecked = true;

                    for (int j = 0; j < tableModel.getRowCount(); j++) {
                        if ((int) tableModel.getValueAt(j, 0) == userId) {
                            boolean isChecked = (boolean) tableModel.getValueAt(j, 3);
                            if (!isChecked) {
                                allChecked = false;
                                break;
                            }
                        }
                    }

                    if (allChecked && !userIdsToUpdate.contains(userId)) {
                        userIdsToUpdate.add(userId);
                    }
                }

                for (int userId : userIdsToUpdate) {
                    Acontroller.updateVerification(userId);
                }

                JOptionPane.showMessageDialog(AdminSRSFRAME2_VERIFYREGISTRATIONS.this, "Verification updated successfully!");
                AdminSRSFRAME2_VERIFYREGISTRATIONS.this.dispose();
                Acontroller.AdminSRSFRAME1_Menu_AdminController();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(AdminSRSFRAME2_VERIFYREGISTRATIONS.this, "Error updating verification: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonPanel.add(submitButton);
        AdminSRSFRAME2_VERIFYREGISTRATIONS.this.add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    protected DefaultTableModel createTableModel(String[] columns) {
        
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3) return Boolean.class;
                return super.getColumnClass(columnIndex);
            }
        };
        return tableModel;
    }

    @Override
    protected void loadObjects(DefaultTableModel tableModel, ArrayList<?> objs) {
        Student student;
        for (Object obj : objs) {
            if (!(obj instanceof Student)) {
                throw new IllegalArgumentException("Invalid reservation type");
            }
            else {            
                student = (Student) obj;
                tableModel.addRow(new Object[]{
                    student.getUserID(),
                    student.getClassDayID(),
                    student.getEAF(),
                    false
                });
            }
        }
    }
}
