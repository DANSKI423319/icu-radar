
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.*;
import javax.swing.WindowConstants;

public class Circle extends JPanel {

    private int[] scores;
    private int slices;
    private int radius;
    private int size = 500;
    private int xOrigin, yOrigin = size / 2;

    public Circle(int n, int input[]) {
        super(true);
        this.setPreferredSize(new Dimension(size, size));
        this.slices = n;
        this.scores = input;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D G2D = (Graphics2D) g;

        // Smooth lines
        G2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Cuts window size in half to get origin
        xOrigin = getWidth() / 2;
        yOrigin = getHeight() / 2;

        // Change to Cartesian coordinates...
        int superOrigin = Math.min(xOrigin, yOrigin);
        G2D.translate(superOrigin, superOrigin);

        // Draw circle loop
        for (int i = 0; i < 6; i++) { // Change both 5s to change amount of lines
            radius = i * superOrigin / 6;
            G2D.drawOval(0 - radius, 0 - radius, 2 * radius, 2 * radius);
        }

        // Plot points
        // int points[] = {3, 4, 5, 2, 1, 4, 5};

        int xPoints[] = new int[slices];
        int yPoints[] = new int[slices];
        int xCoord, yCoord;

        // Cut slices into radar
        for (int i = 0; i < slices; i++) {
            G2D.setColor(Color.black);
            double angle = 2 * Math.PI * i / slices;

            xCoord = (int) Math.round(0 + (5 * superOrigin / 6) * Math.cos(angle)); // Get angles
            yCoord = (int) Math.round(0 + (5 * superOrigin / 6) * Math.sin(angle)); // and coordinates

            G2D.drawLine(0, 0, xCoord, yCoord); // Draw line
        }

        int radiusSum = Math.abs(superOrigin - radius) / 3;

        // Get scores, load array(s)
        for (int i = 0; i < scores.length; i++) {
            double angle = 2 * Math.PI * i / slices;
            xCoord = (int) Math.round(0 + (scores[i] * superOrigin / 6) * Math.cos(angle));
            yCoord = (int) Math.round(0 + (scores[i] * superOrigin / 6) * Math.sin(angle));

            xPoints[i] = xCoord;
            yPoints[i] = yCoord;
        }

        // Draw radar, with loaded array(s)
        G2D.setColor(Color.red);
        G2D.drawPolygon(xPoints, yPoints, slices);

        int alpha = 80;
        Color myColor = new Color(255, 0, 0, alpha);
        G2D.setColor(myColor);
        G2D.fillPolygon(xPoints, yPoints, slices);
        
        for (int i = 0; i < scores.length; i++) {
            G2D.setColor(Color.red);
            G2D.fillOval(xPoints[i] - radiusSum, yPoints[i] - radiusSum, 2 * radiusSum, 2 * radiusSum);

            G2D.setColor(Color.white);
            //String txt = (i + 1) + " X: " + Integer.toString(xCoord) + ", Y:" + Integer.toString(yCoord) + ".";
            int pointVal = scores[i];
            String stringVal = Integer.toString(pointVal);
            G2D.drawString(stringVal, xPoints[i] - 3, yPoints[i] + 4);
        }
    }

    private static void createFrame() {
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Custom Radar");

        int input[] = {3, 4, 4, 2, 3, 4, 5};
        // Create chart with 'x' slices
        mainFrame.add(new Circle(7, input));

        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                createFrame();
            }
        });
    }
}
