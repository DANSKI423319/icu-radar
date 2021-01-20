
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

    public Circle(int n) {
        super(true);
        this.setPreferredSize(new Dimension(size, size));
        this.slices = n;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D G2D = (Graphics2D) g;

        // Smooth lines
        G2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        G2D.setColor(Color.black);

        // Cuts window size in half to get origin
        xOrigin = getWidth() / 2;
        yOrigin = getHeight() / 2;

        // Returns shortest number between both, uses as definite origin
        int superOrigin = Math.min(xOrigin, yOrigin);
        int radiusSum = 0;

        // DRAWS CIRCLE LOOP
        for (int i = 0; i < 6; i++) { // Change both 5s to change amount of lines
            radius = i * superOrigin / 6;
            G2D.drawOval(xOrigin - radius, yOrigin - radius, 2 * radius, 2 * radius);
        }

        // Plot points
        int points[] = {3, 4, 5, 2, 1, 4, 5};

        int xPoints[] = new int[slices];
        int yPoints[] = new int[slices];
        int xCoord, yCoord;

        // Cut slices into radar
        for (int i = 0; i < slices; i++) {
            G2D.setColor(Color.black);
            double angle = 2 * Math.PI * i / slices;

            xCoord = (int) Math.round(xOrigin + (5 * superOrigin / 6) * Math.cos(angle)); // Get angles
            yCoord = (int) Math.round(yOrigin + (5 * superOrigin / 6) * Math.sin(angle)); // and coordinates

            G2D.drawLine(xOrigin, yOrigin, xCoord, yCoord); // Draw line to new coordinates
        }

        // Plot Scores
        for (int i = 0; i < points.length; i++) {
            double angle = 2 * Math.PI * i / slices;
            xCoord = (int) Math.round(xOrigin + (points[i] * superOrigin / 6) * Math.cos(angle));
            yCoord = (int) Math.round(yOrigin + (points[i] * superOrigin / 6) * Math.sin(angle));

            G2D.setColor(Color.red);
            G2D.drawLine(xOrigin, yOrigin, xCoord, yCoord);
            G2D.fillOval(xCoord - radiusSum, yCoord - radiusSum, 2 * radiusSum, 2 * radiusSum);

            G2D.setColor(Color.black);
            String txt = i + " X: " + Integer.toString(xCoord) + ", Y:" + Integer.toString(yCoord) + ".";
            G2D.drawString(txt, xCoord, yCoord - 12);

            xPoints[i] = xCoord;
            yPoints[i] = yCoord;   
        }

        // Draw radar
        int alpha = 80;
        Color myColor = new Color(255, 0, 0, alpha);
        G2D.setColor(Color.red);
        G2D.drawPolygon(xPoints, yPoints, 7);
        G2D.setColor(myColor);
        G2D.fillPolygon(xPoints, yPoints, 7);
    }

    private static void createFrame() {
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Custom Radar");

        // Create chart with 'x' slices
        mainFrame.add(new Circle(7));

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
