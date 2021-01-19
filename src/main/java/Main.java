import java.awt.*;
import java.util.*;
import javax.swing.*;
import org.knowm.xchart.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("This is a radar chart builder");

        // Arrays
        String[] pointNames = new String[]{"A", "B", "C", "D"};
        double[] defaultValues = new double[]{0.2, 0.4, 0.4, 0.8};
        
        buildChart(pointNames, defaultValues);
    }

    public static void buildChart(String[] pointNames, double[] pointValues) {
        // Build chart
        RadarChart chart = new RadarChartBuilder().width(800).height(600).title("Radar Chart").build();
        //chart.getStyler().setToolTipsEnabled(true);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setMarkerSize(15);

        // Add to chart
        chart.setVariableLabels(pointNames);
        // chart.addSeries("Entered Scores", pointValues);
        chart.addSeries("Scores", pointValues);
        
        JFrame frame = new JFrame("XChart Example");
        JPanel chartPanel = new XChartPanel(chart);
        frame.add(chartPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }
}
