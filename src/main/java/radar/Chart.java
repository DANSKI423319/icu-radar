package radar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Chart extends JPanel {

    private final int[] scores;
    private final int slices;
    private int radius;
    private int finalRange = 0;
    private final boolean drawNumbers;
    private final boolean drawLines;
    private final Color transparent = new Color(0, 0, 0, 0);

    public Chart(int nSlices, int[] nScores, int size, boolean boolNumbers, boolean boolLines) {
        super(true);
        this.setPreferredSize(new Dimension(size, size));
        this.setBackground(transparent);
        this.slices = nSlices;
        this.scores = nScores;
        this.drawNumbers = boolNumbers;
        this.drawLines = boolLines;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D G2D = (Graphics2D) g;

        G2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int range = 0;

        // Set range for chart if more than 5
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > range) {
                range = scores[i];
                range = range + 1;
                if (range <= 5) {
                    range = 5;
                    range = range + 1;
                }
            }
        }

        // Range check
        int rangeText = 0;

        // Adding a number makes the chart smaller, minusing a number makes it bigger
        if (drawNumbers == true) {
            finalRange = range + 1;
            rangeText = range;
        } else {
            finalRange = range;
        }

        int xOrigin = getWidth() / 2;
        int yOrigin = getHeight() / 2;

        // Change to Cartesian coordinates...
        int superOrigin = Math.min(xOrigin, yOrigin);
        G2D.translate(superOrigin, superOrigin);
        G2D.setColor(Color.GRAY);
        
        // Draw circle loop
        for (int i = 0; i < (range); i++) { // Range is the maximum score given, tells how many circles to make
            radius = i * superOrigin / (finalRange);
            G2D.drawOval(0 - radius, 0 - radius, 2 * radius, 2 * radius);
        }

        // Plot points
        int xPoints[] = new int[slices];
        int yPoints[] = new int[slices];
        int xCoord, yCoord;

        G2D.setFont(new Font("Arial", Font.PLAIN, 14));

        /*
            Creates lines for points on the radar
         */
        if (drawLines == true) {
            for (int i = 0; i < slices; i++) {
                double angle = 2 * Math.PI * i / slices;

                xCoord = (int) Math.round(0 + ((range - 1) * superOrigin / finalRange) * Math.cos(angle));
                yCoord = (int) Math.round(0 + ((range - 1) * superOrigin / finalRange) * Math.sin(angle));

                G2D.drawLine(0, 0, yCoord, -xCoord);

            }
        }

        /*
            Draws numbers at the end of slices to show the user how they
            can be reviewed from a table in the GUI
         */
        if (drawNumbers == true) {
            for (int i = 0; i < slices; i++) {
                double angle = 2 * Math.PI * i / slices;

                xCoord = (int) Math.round(0 + ((range - 1) * superOrigin / rangeText) * Math.cos(angle));
                yCoord = (int) Math.round(0 + ((range - 1) * superOrigin / rangeText) * Math.sin(angle));

                if (i < 9) {
                    G2D.drawString("0" + Integer.toString(i + 1), yCoord - 7, -xCoord + 3);
                } else {
                    G2D.drawString(Integer.toString(i + 1), yCoord - 7, -xCoord + 3);
                }
            }
        }
    }

}
