import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddReservationFrame extends JFrame {
    
    // UI components
    private JButton submitButton;
    private JButton backButton;
    private JComboBox<String> lineComboBox;
    private JComboBox<String> dateComboBox;
    private JComboBox<String> timeComboBox;
    private JLabel lineLabel;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JLabel titleLabel;

    public AddReservationFrame() {
        // Set up the frame
        setTitle("Add Reservations");
        setSize(810, 530);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        // Initialize components
        initUIComponents();
    }

    private void initUIComponents() {
        // Title Label
        titleLabel = new JLabel("ADD RESERVATIONS");
        titleLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 36));
        titleLabel.setBounds(240, 70, 370, 40);
        add(titleLabel);

        // Line Label and ComboBox
        lineLabel = new JLabel("Line:");
        lineLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        lineLabel.setBounds(180, 150, 70, 40);
        add(lineLabel);

        lineComboBox = new JComboBox<>(new String[]{"Line 1", "Line 2", "Line 3"});
        lineComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        lineComboBox.setBounds(260, 150, 380, 50);
        add(lineComboBox);

        // Date Label and ComboBox
        dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        dateLabel.setBounds(180, 230, 80, 40);
        add(dateLabel);

        dateComboBox = new JComboBox<>(new String[]{"2024-11-16", "2024-11-17", "2024-11-18"});
        dateComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        dateComboBox.setBounds(260, 220, 380, 50);
        add(dateComboBox);

        // Time Label and ComboBox
        timeLabel = new JLabel("Time:");
        timeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        timeLabel.setBounds(180, 300, 80, 40);
        add(timeLabel);

        timeComboBox = new JComboBox<>(new String[]{"8:00 AM", "12:00 PM", "6:00 PM"});
        timeComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        timeComboBox.setBounds(260, 290, 380, 50);
        add(timeComboBox);

        // Submit Button
        submitButton = new JButton("SUBMIT");
        submitButton.setForeground(new Color(108, 194, 162));
        submitButton.setBounds(260, 390, 110, 40);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmitAction();
            }
        });
        add(submitButton);

        // Back Button
        backButton = new JButton("BACK");
        backButton.setForeground(new Color(108, 194, 162));
        backButton.setBounds(460, 390, 110, 40);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleBackAction();
            }
        });
        add(backButton);
    }

    private void handleSubmitAction() {
        String line = (String) lineComboBox.getSelectedItem();
        String date = (String) dateComboBox.getSelectedItem();
        String time = (String) timeComboBox.getSelectedItem();

        JOptionPane.showMessageDialog(this,
                "Reservation added:\nLine: " + line + "\nDate: " + date + "\nTime: " + time,
                "Reservation Confirmation",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleBackAction() {
        JOptionPane.showMessageDialog(this, "Going back to the previous screen.", "Back", JOptionPane.INFORMATION_MESSAGE);
        // You can close this frame or perform other actions here
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AddReservationFrame frame = new AddReservationFrame();
            frame.setVisible(true);
        });
    }
}
