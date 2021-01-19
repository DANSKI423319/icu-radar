
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.WindowConstants;

public class Circle extends JPanel {

    private int slices;
    private int radius, rad1, rad2, rad3, rad4, rad5;
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

        /*
        // DRAWS CIRCLES
        // If I wanted to specify lines to certain circles, I will need
        // to take this out of a loop, and specify each radius(2)...
        for (int i = 0; i < 5; i++) { // Change both 5s to change amount of lines
            radius = i * superOrigin / 5;
            radius2 = Math.abs(superOrigin - radius) / 6;
            G2D.drawOval(xOrigin - radius, yOrigin - radius, 2 * radius, 2 * radius);
        }
         */
        
        // Draw main circle //
        radiusSum = Math.abs(superOrigin - rad5) / 10;
        
        rad1 = 1 * superOrigin / 6;
        G2D.drawOval(xOrigin - rad1, yOrigin - rad1, 2 * rad1, 2 * rad1);

        rad2 = 2 * superOrigin / 6;
        G2D.drawOval(xOrigin - rad2, yOrigin - rad2, 2 * rad2, 2 * rad2);

        rad3 = 3 * superOrigin / 6;
        G2D.drawOval(xOrigin - rad3, yOrigin - rad3, 2 * rad3, 2 * rad3);

        rad4 = 4 * superOrigin / 6;
        G2D.drawOval(xOrigin - rad4, yOrigin - rad4, 2 * rad4, 2 * rad4);
        
        rad5 = 5 * superOrigin / 6;
        G2D.drawOval(xOrigin - rad5, yOrigin - rad5, 2 * rad5, 2 * rad5);

        // Plot points
        int points[] = {1, 2, 1, 4, 1};

        // Cut slices into radar
        for (int i = 0; i < slices; i++) {
            G2D.setColor(Color.green);
            double angle = 2 * Math.PI * i / slices;

            int xCoord = (int) Math.round(xOrigin + rad5 * Math.cos(angle)); // Get angles
            int yCoord = (int) Math.round(yOrigin + rad5 * Math.sin(angle)); // and coordinates

            G2D.drawLine(xOrigin, yOrigin, xCoord, yCoord); // Draw line to new coordinates
        }
        
        // Plot Scores
        for (int i = 0; i < points.length; i++) {
            G2D.setColor(Color.blue);
            double angle = 2 * Math.PI * i / slices;
            int xCoord;
            int yCoord;
            
            if (points[i] == 1) {
                xCoord = (int) Math.round(xOrigin + rad1 * Math.cos(angle));
                yCoord = (int) Math.round(yOrigin + rad1 * Math.sin(angle));

                G2D.drawLine(xOrigin, yOrigin, xCoord, yCoord);
                G2D.fillOval(xCoord - radiusSum, yCoord - radiusSum, 2 * radiusSum, 2 * radiusSum);
                
                G2D.setColor(Color.red);

                String txt = i + " X: " + Integer.toString(xCoord) + ", Y:" + Integer.toString(yCoord) + ".";
                G2D.drawString(txt, xCoord, yCoord - 12);
            }
        }
        
    }

    private static void createFrame() {
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Custom Radar");

        // Create chart with 'x' slices
        mainFrame.add(new Circle(5));

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

    /* 
    // Original circle drawing method
    int[] sizes = new int[]{60, 120, 180, 240, 300};
    int[] ovalCords = new int[]{150, 120, 90, 60, 30};
    for (int i = 0; i < 5; i++) { g.drawOval(ovalCords[i], ovalCords[i], sizes[i], sizes[i]);}
     */
}
