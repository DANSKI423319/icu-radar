
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.WindowConstants;

public class Circle extends JPanel {

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
        int radius2 = 0;

        // DRAWS CIRCLES
        // If I wanted to specify lines to certain circles, I will need
        // to take this out of a loop, and specify each radius(2)...
        for (int i = 0; i < 5; i++) { // Change both 5s to change amount of lines
            radius = i * superOrigin / 5;
            radius2 = Math.abs(superOrigin - radius) / 6;
            G2D.drawOval(xOrigin - radius, yOrigin - radius, 2 * radius, 2 * radius);
        }

        // Draw main circle //       
        // radius = 4 * superOrigin / 5;
        // radius2 = Math.abs(superOrigin - radius) / 3;
        // g2d.drawOval(xOrigin - radius, yOrigin - radius, 2 * radius, 2 * radius); 
        
        // Cut slices into radar
        for (int i = 0; i < slices; i++) {
            G2D.setColor(Color.blue);
            double angle = 2 * Math.PI * i / slices;
            int xCoord = (int) Math.round(xOrigin + radius * Math.cos(angle)); // Get angles
            int yCoord = (int) Math.round(yOrigin + radius * Math.sin(angle)); // and coordinates
            
            G2D.drawLine(xOrigin, yOrigin, xCoord, yCoord); // Draw line to new coordinates
            
            G2D.fillOval(xCoord - radius2, yCoord - radius2, 2 * radius2, 2 * radius2); // Create point
            G2D.setColor(Color.red);

            String txt = i + " X: " + Integer.toString(xCoord) + ", Y:" + Integer.toString(yCoord) + ".";
            G2D.drawString(txt, xCoord, yCoord - 36);
        }
    }

    private static void createFrame() {
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Custom Radar");

        // Create chart with 'x' slices
        mainFrame.add(new Circle(3));

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
