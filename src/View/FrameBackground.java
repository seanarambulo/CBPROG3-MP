package src.View;

import java.awt.*;
import javax.swing.*;

public abstract class FrameBackground extends JFrame{
    
    protected JPanel outerPanel;
    protected JPanel innerPanel;
    private JLabel DesignationTitle;

    public FrameBackground() {
        super("DLSU Shuttle Reservation");
        initializeFrame();
        initializePanels();
    }

    private void initializeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(810, 530);
        setResizable(false); // Make the frame non-resizable
        setLayout(new BorderLayout());
        setVisible(true);
    }

    private void initializePanels() {
        createOuterPanel();
        createInnerPanel();
        this.outerPanel.add(this.innerPanel);
        this.add(outerPanel, BorderLayout.CENTER);
    }

    private void createOuterPanel() {
        this.outerPanel = new JPanel();
        this.outerPanel.setBackground(new Color(108, 194, 162));
        this.outerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20)); // Use FlowLayout to center innerPanel
        this.outerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
    
    private void createInnerPanel() {
        this.innerPanel = new JPanel();
        this.innerPanel.setBackground(new Color(53, 95, 79));
        this.innerPanel.setLayout(new BorderLayout()); // Use BorderLayout to center components
        this.innerPanel.setPreferredSize(new Dimension(710, 430)); // Set preferred size to make the panel larger
    }
    
    public void setDesignationTitle(String title, int top, int left, int bottom, int right) {
        this.DesignationTitle = new JLabel(title, SwingConstants.CENTER);
        this.DesignationTitle.setFont(new Font("Baskerville Old Face", Font.PLAIN, 48)); // Adjusted font size to 24
        this.DesignationTitle.setForeground(Color.WHITE);
        this.DesignationTitle.setHorizontalAlignment(SwingConstants.CENTER);
        this.DesignationTitle.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right)); // Add vertical gap above the title
        this.innerPanel.add(DesignationTitle, BorderLayout.NORTH); // Add to the top of the inner panel
    }

    public abstract void initComponets();

}
