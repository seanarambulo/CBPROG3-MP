import java.awt.*;
import javax.swing.*;

public class VerifyUserPanel {

    private JFrame frame;
    private JLabel DesignationTitle;
    private JPanel outerPanel;
    private JPanel innerPanel;

    public static void main(String[] args) {
        // Outer panel with light green background
        outerPanel = new JPanel();
        outerPanel.setBackground(new Color(108, 194, 162));
        outerPanel.setLayout(new GridBagLayout());
        outerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Inner panel with dark green background
        innerPanel = new JPanel();
        innerPanel.setBackground(new Color(53, 95, 79));
        innerPanel.setLayout(null); // Using null layout for precise positioning
        innerPanel.setPreferredSize(new Dimension(710, 430));

        // Label: DLSU Shuttle Reservation
        DesignationTitle = new JLabel("DLSU Shuttle Reservation");
        DesignationTitle.setFont(new Font("Baskerville", Font.PLAIN, 36));
        DesignationTitle.setForeground(Color.WHITE);
        DesignationTitle.setBounds(180, 20, 400, 40);
        innerPanel.add(DesignationTitle);
    }
}

