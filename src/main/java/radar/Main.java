package radar;

import java.awt.*;
import javax.swing.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
    
            @Override
            public void run() {
                createFrame();
            }
        });
    }
 
    private static void createFrame() {
        JFrame mainFrame = new JFrame("Radar Tool");
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 255, 255, 255));

        JLabel lblTitle = new JLabel("Medical Chart");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        mainFrame.add(lblTitle, BorderLayout.NORTH);
        
        // Chart Scores
        int scores[] = {1, 0, 2, 2, 0, 2, 2, 0, 5, 2};
        int slices = scores.length;
        int range = 0;
        int size = 500; 

        mainPanel.add(new Chart(slices, scores, size, true, true));
        mainFrame.add(mainPanel, BorderLayout.CENTER);
        
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
}
