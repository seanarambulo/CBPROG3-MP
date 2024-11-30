import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class AbstractReservationFrame {
    protected JFrame frame;
    protected JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    public AbstractReservationFrame(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Add a title panel
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);
    }

    // Abstract method to define custom table model
    protected abstract DefaultTableModel createTableModel(ArrayList<Reservation> reservations);

    

    
    protected abstract void addButton(String buttonName, DefaultTableModel tableModel);
    public void display() {
        frame.setVisible(true);
    }
}
