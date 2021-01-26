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
        
        // Chart Scores
        int scores[] = {5, 4, 3, 2, 3, 3, 2};
        int slices = scores.length;
        int range = 0;
        int size = 500;

        for (int i = 0; i < scores.length; i++)
        {
            if (scores[i] > range)
            {
                range = scores[i];
            }

            if (range < 5)
            {
                range = 5;
            }
        }

        mainFrame.add(lblTitle, BorderLayout.NORTH);
        mainPanel.add(new Chart(slices, scores, range, size));
        mainFrame.add(mainPanel, BorderLayout.CENTER);
        
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
}
