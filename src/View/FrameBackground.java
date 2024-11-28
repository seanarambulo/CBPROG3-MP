package src.View;

import java.awt.*;
import javax.swing.*;

public abstract class FrameBackground extends JFrame{
    
    protected JPanel outerPanel;
    protected JPanel innerPanel;
    protected GridBagConstraints innerGbc;
    protected GridBagConstraints outerGbc;
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

        this.outerPanel.add(this.innerPanel, createInnerGbc());
        this.add(outerPanel, BorderLayout.CENTER);

    }

    private void createOuterPanel() {
        this.outerPanel = new JPanel();
        this.outerPanel.setBackground(new Color(108, 194, 162));
        this.outerPanel.setLayout(new GridBagLayout()); // Use GridBagLayout to center innerPanel
        this.outerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void createInnerPanel() {
        this.innerPanel = new JPanel();
        this.innerPanel.setBackground(new Color(53, 95, 79));
        this.innerPanel.setLayout(new GridBagLayout());
        this.innerPanel.setPreferredSize(new Dimension(710, 430)); // Set preferred size to make the panel larger
    }

    private GridBagConstraints createInnerGbc() {
        this.innerGbc = new GridBagConstraints();
        this.innerGbc.insets = new Insets(10, 10, 10, 10);
        this.innerGbc.anchor = GridBagConstraints.NORTH;
        this.innerGbc.fill = GridBagConstraints.BOTH;
        this.innerGbc.weightx = 1.0;
        this.innerGbc.weighty = 1.0;
        return this.innerGbc;
    }

    public JLabel setDesignationTitle(String title) {
        this.DesignationTitle = new JLabel(title);
        this.innerGbc.gridx = 0;
        this.innerGbc.gridy = 0;
        this.innerGbc.gridwidth = 2;
        this.DesignationTitle.setFont(new Font("Baskerville", Font.PLAIN, 36));
        this.DesignationTitle.setForeground(Color.WHITE);
        this.DesignationTitle.setHorizontalAlignment(SwingConstants.CENTER);
        this.innerPanel.add(DesignationTitle, innerGbc);
        return this.DesignationTitle;
    }

    public abstract void initComponets();

}
