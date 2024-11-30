import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class verifyUser {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Verify User Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(null);

        // Title label
        JLabel titleLabel = new JLabel("Verify User Registration");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(150, 20, 300, 30);
        frame.add(titleLabel);

        // User ID input label and text field
        JLabel userIdLabel = new JLabel("Enter User ID:");
        userIdLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        userIdLabel.setBounds(50, 70, 100, 25);
        frame.add(userIdLabel);

        JTextField userIdField = new JTextField();
        userIdField.setBounds(150, 70, 200, 25);
        frame.add(userIdField);

        // Table with sample data
        String[] columnNames = {"Day", "Destination"};
        Object[][] data = {
            {"Monday", "Laguna"},
            {"Thursday", "Manila"},
            {"Friday", "Laguna"},
        };

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 120, 400, 150);
        frame.add(scrollPane);

        // Approve and Reject buttons
        JButton rejectButton = new JButton("REJECT");
        rejectButton.setBounds(100, 300, 120, 40);
        rejectButton.setBackground(Color.RED);
        rejectButton.setForeground(Color.WHITE);
        frame.add(rejectButton);

        JButton approveButton = new JButton("APPROVE");
        approveButton.setBounds(280, 300, 120, 40);
        approveButton.setBackground(Color.GREEN);
        approveButton.setForeground(Color.WHITE);
        frame.add(approveButton);

        // Show the frame
        frame.setVisible(true);
    }
}

