package radar;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Daniel
 */
public class Chart extends JPanel {

    private final int SIZE = 400;
    private final Point[] scores;
    private final int slices;
    private int radius;
    private int modifiedRange = 0;
    private final boolean drawNumbers;
    private final boolean drawLines;
    private final boolean drawCircles;
    private final boolean drawColLines;
    private final boolean drawRelativeRange;
    private final Color transparent = new Color(0, 0, 0, 0);

    public Chart(int nSlices, Point[] nScores,
            boolean boolNumbers, boolean boolLines, boolean boolCircles, boolean boolColLines, boolean boolRelRange) {
        super(true);
        this.setPreferredSize(new Dimension(SIZE, SIZE));
        this.setBackground(transparent);
        this.slices = nSlices;
        this.scores = nScores;
        this.drawNumbers = boolNumbers;
        this.drawLines = boolLines;
        this.drawCircles = boolCircles;
        this.drawColLines = boolColLines;
        this.drawRelativeRange = boolRelRange;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D G2D = (Graphics2D) g;

        G2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        Font defaultFont = G2D.getFont();

        int range = 0;
        int imposedMaximum = 7;
        
        int largestNum = scores[0].getScore();
        int largestPos = 0;

        // Search array for the largest number and the position
        for (int i = 0; i < scores.length; i++) {
            if (scores[i].getScore() > largestNum) {
                largestNum = scores[i].getScore();
                largestPos = i;
            }
        }
        
        range = scores[largestPos].getScore();
        int circleRange = 0;
        int textRange = 0;
        
        // If less than the imposed maximum, look to see if relative scoring is enabled
        if (range <= imposedMaximum) {
            if (drawRelativeRange == true) {
                range = range + 2;
                circleRange = range;
            } else {
                range = imposedMaximum;
                circleRange = range;
            }     
        }
        
        modifiedRange = range;

        // Adding a number makes the chart smaller, minusing a number makes it bigger
        if (drawNumbers == true) {
            modifiedRange = range + 1;
            textRange = range;
        }

        int xOrigin = getWidth() / 2;
        int yOrigin = getHeight() / 2;

        // Change to Cartesian coordinates...
        int superOrigin = Math.min(xOrigin, yOrigin);
        G2D.translate(superOrigin, superOrigin);
        
        G2D.setColor(Color.GRAY);

        // Plot points
        int xCoord, yCoord;
        
        // Draw circles for the radar
        if (drawCircles == true) {
            for (int i = 0; i < (circleRange); i++) { // The amount of circles there are...
                radius = i * superOrigin / (modifiedRange);
                G2D.drawOval(0 - radius, 0 - radius, 2 * radius, 2 * radius);
            }
        }

        G2D.setFont(new Font("Arial", Font.PLAIN, 14));

        // Draw lines for the radar
        if (drawLines == true) {
            for (int i = 0; i < slices; i++) {
                if (drawColLines == true) {
                    G2D.setColor(scores[i].getColor());
                }

                double angle = 2 * Math.PI * i / slices;

                yCoord = (int) -Math.round(0 + ((range - 1) * superOrigin / modifiedRange) * Math.cos(angle));
                xCoord = (int) Math.round(0 + ((range - 1) * superOrigin / modifiedRange) * Math.sin(angle));

                G2D.drawLine(0, 0, xCoord, yCoord);
            }
        }

        /*
            Draws numbers at the end of slices to show the user how they
            can be reviewed from a table in the GUI
         */
        if (drawNumbers == true) {
            G2D.setFont(new Font("Arial", Font.BOLD, 13));

            for (int i = 0; i < slices; i++) {
                double angle = 2 * Math.PI * i / slices;
                G2D.setColor(scores[i].getColor());

                if (range < 5) {
                    yCoord = (int) -Math.round(0 + ((5) * superOrigin / 6) * Math.cos(angle));
                    xCoord = (int) Math.round(0 + ((5) * superOrigin / 6) * Math.sin(angle));
                } else {
                    yCoord = (int) -Math.round(0 + ((range - 1) * superOrigin / textRange) * Math.cos(angle));
                    xCoord = (int) Math.round(0 + ((range - 1) * superOrigin / textRange) * Math.sin(angle));
                }

                if (scores[i].getPosition() < 9) {
                    G2D.drawString("" + (scores[i].getPosition() + 1), xCoord - 3, yCoord + 3);
                } else {
                    G2D.drawString("" + (scores[i].getPosition() + 1), xCoord - 7, yCoord + 3);
                }
            }

            G2D.setFont(defaultFont);
        }
    }

}
