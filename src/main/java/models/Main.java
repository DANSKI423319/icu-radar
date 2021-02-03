package models;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import radar.Chart;

public class Main {

    static ArrayList<Model> models = new ArrayList<>();

    public static void main(String[] args) {

        Cpax cpax = new Cpax(5, 5, 2, 2, 4, 2, 2, 2, 1, 0, 25);
        Mrc mrc = new Mrc(0, 5, 3, 0, 0, 5, 0, 4, 0, 5, 0, 4, 5, 0, 5, 0, 5, 0, 5, 0, 0, 5, 5, 0, 51);
        Sofa sofa = new Sofa(5, 2, 4, 1, 3, 0, 3);
        Model m = new Model("1234", "John", "Smith", "5 Transfers with assistance", cpax, mrc, sofa);
        
        models.add(m);

        System.out.println(Arrays.toString(m.getSofa().getScores()));

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                createChart();
            }

        });
    }
    
    private static void createChart() {
        JFrame mainFrame = new JFrame("Radar Tool");
        JPanel mainPanel = new JPanel();
        
        mainPanel.setBackground(new Color(255, 255, 255, 255));

        // Chart Scores
        // int scores[] = models.get(0).getSofa().getScores();
        int scores[] = models.get(0).getMrc().getScores();
        // int scores[] = models.get(0).getCpax().getScores();
        int slices = scores.length;
        int size = 500; 

        mainPanel.add(new Chart(slices, scores, size));
        mainFrame.add(mainPanel);
        
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
}
