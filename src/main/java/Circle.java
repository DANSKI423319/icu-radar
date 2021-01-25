
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.WindowConstants;

public class Circle extends JPanel {

    private final int[] scores;
    private final int slices;
    private final int range;
    private int radius;
    private final int size = 500;

    public Circle(int n, int input[], int nn) {
        super(true);
        this.setPreferredSize(new Dimension(size, size));
        this.slices = n;
        this.scores = input;
        this.range = nn + 1;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D G2D = (Graphics2D) g;

        int alpha = 80;
        Color myColor = new Color(255, 0, 0, alpha);

        // Smooth lines
        G2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Cuts window size in half to get origin
        int xOrigin = getWidth() / 2;
        int yOrigin = getHeight() / 2;

        // Change to Cartesian coordinates...
        int superOrigin = Math.min(xOrigin, yOrigin);
        G2D.translate(superOrigin, superOrigin);

        // Draw circle loop
        for (int i = 0; i < (range); i++) { // Range is the maximum score given, tells how many circles to make
            radius = i * superOrigin / (range);
            G2D.drawOval(0 - radius, 0 - radius, 2 * radius, 2 * radius);
        }

        // Plot points
        int xPoints[] = new int[slices];
        int yPoints[] = new int[slices];
        int xCoord, yCoord;

        // Cut slices into radar
        for (int i = 0; i < slices; i++) {
            G2D.setColor(Color.black);
            double angle = 2 * Math.PI * i / slices;

            xCoord = (int) Math.round(0 + ((range - 1) * superOrigin / range) * Math.cos(angle)); // Get angles
            yCoord = (int) Math.round(0 + ((range - 1) * superOrigin / range) * Math.sin(angle)); // and coordinates

            G2D.drawLine(0, 0, yCoord, -xCoord); // Draw line
        }

        // Get scores, load array(s)
        for (int i = 0; i < scores.length; i++) {
            double angle = 2 * Math.PI * i / slices;
            xCoord = (int) Math.round(0 + (scores[i] * superOrigin / range) * Math.cos(angle));
            yCoord = (int) Math.round(0 + (scores[i] * superOrigin / range) * Math.sin(angle));

            xPoints[i] = -xCoord;
            yPoints[i] = yCoord;
        }

        // Plot radar, with loaded array(s)
        G2D.setColor(Color.red);
        G2D.drawPolygon(yPoints, xPoints, slices);
        G2D.setColor(myColor);
        G2D.fillPolygon(yPoints, xPoints, slices);

        int radiusSum = Math.abs(superOrigin - radius) / 3;

        // Plot scores
        for (int i = 0; i < scores.length; i++) {
            G2D.setColor(Color.red);
            G2D.fillOval(yPoints[i] - radiusSum, xPoints[i] - radiusSum, 2 * radiusSum, 2 * radiusSum);

            /*
            String txt = (i + 1) + " X: " + Integer.toString(xCoord) + ", Y:" + Integer.toString(yCoord) + ".";
            int pointVal = scores[i];
            String stringVal = Integer.toString(pointVal);
            G2D.drawString(stringVal, yPoints[i] - 3, xPoints[i] + 4);
            */
        }
    }

    private static void createFrame() {
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Custom Radar");
        
        // Chart Scores
        int scores[] = {5, 4, 3, 2, 3, 3, 2};
        int slices = scores.length;
        int range = 0;

        for (int i = 0; i < scores.length; i++)
        {
            if (scores[i] > range)
            {
                range = scores[i];
            }
        }

        mainFrame.add(new Circle(slices, scores, range));

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
