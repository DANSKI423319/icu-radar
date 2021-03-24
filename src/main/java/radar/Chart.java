package radar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Chart extends JPanel {

    private final int SIZE = 400;
    private final Point[] scores;
    private final int slices;
    private int radius;
    private int finalRange = 0;
    private final boolean drawNumbers;
    private final boolean drawLines;
    private final boolean drawCircles;
    private final boolean drawColLines;
    private final Color transparent = new Color(0, 0, 0, 0);

    public Chart(int nSlices, Point[] nScores,
            boolean boolNumbers, boolean boolLines, boolean boolCircles, boolean boolColLines) {
        super(true);
        this.setPreferredSize(new Dimension(SIZE, SIZE));
        this.setBackground(transparent);
        this.slices = nSlices;
        this.scores = nScores;
        this.drawNumbers = boolNumbers;
        this.drawLines = boolLines;
        this.drawCircles = boolCircles;
        this.drawColLines = boolColLines;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D G2D = (Graphics2D) g;

        G2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int range = 0;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i].getScore() == 12345) {
                scores[i].setScore(0);
                scores[i].setMissing(true);
            }
        }
        
        // Set range for chart if more than 5
        for (int i = 0; i < scores.length; i++) {
            if (scores[i].getScore() > range) {
                range = scores[i].getScore();
                range = range + 1;
                if (range <= 5) {
                    range = 5 + 1;
                }
            }
        }

        if (range == 0) {
            range = 5 + 1;
        }

        // Range check
        int rangeText = 0;

        finalRange = range;

        // Adding a number makes the chart smaller, minusing a number makes it bigger
        if (drawNumbers == true) {
            finalRange = range + 1;
            rangeText = range;
        }

        int xOrigin = getWidth() / 2;
        int yOrigin = getHeight() / 2;

        // Change to Cartesian coordinates...
        int superOrigin = Math.min(xOrigin, yOrigin);
        G2D.translate(superOrigin, superOrigin);
        G2D.setColor(Color.GRAY);

        // Draw circle loop
        if (drawCircles == true) {
            for (int i = 0; i < (range); i++) { // Range is the maximum score given, tells how many circles to make
                radius = i * superOrigin / (finalRange);
                G2D.drawOval(0 - radius, 0 - radius, 2 * radius, 2 * radius);
            }
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
                if (drawColLines == true) {
                    G2D.setColor(scores[i].getColor());
                    // Fill Arc could be an interesting thing?
                }
                
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
            G2D.setColor(Color.BLACK);
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
