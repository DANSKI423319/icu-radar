package radar;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Plot extends JPanel {

    private final Color selectedColor;
    private final int[] scores;
    private final int points;
    private int radius;
    private final boolean drawLines;
    private final boolean drawScores;
    private final boolean drawNumbers;
    private final boolean drawPolygons;
    private int finalRange;
    private final Color transparent = new Color(0, 0, 0, 0);

    public Plot(Color color, int nPoints, int[] nScores, int scale,
            boolean boolLines, boolean boolScores, boolean boolNumbers, boolean boolPolygons) {
        super(true);
        this.setPreferredSize(new Dimension(scale, scale));
        this.setBackground(transparent);
        this.selectedColor = color;
        this.points = nPoints;
        this.scores = nScores;
        this.drawLines = boolLines;
        this.drawScores = boolScores;
        this.drawNumbers = boolNumbers;
        this.drawPolygons = boolPolygons;
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

        if (range == 0) {
            range = 5 + 1;
        }

        finalRange = range;

        // Range check
        int rangeText = 0;
        // Adding a number makes the chart smaller, minusing a number makes it bigger
        if (drawNumbers == true) {
            finalRange = range + 1;
            rangeText = range;
        }

        int xOrigin = getWidth() / 2;
        int yOrigin = getHeight() / 2;
        int superOrigin = Math.min(xOrigin, yOrigin);
        G2D.translate(superOrigin, superOrigin);

        int xPoints[] = new int[scores.length];
        int yPoints[] = new int[scores.length];
        int xCoord, yCoord;

        // Get coordinates for the scores
        for (int i = 0; i < scores.length; i++) {

            double angle = 2 * Math.PI * i / points;
            xCoord = (int) Math.round(0 + (scores[i] * superOrigin / finalRange) * Math.cos(angle));
            yCoord = (int) Math.round(0 + (scores[i] * superOrigin / finalRange) * Math.sin(angle));

            if (xCoord == 0) {
                if (scores[i] > 0) {
                    // Score validation check
                    xPoints[i] = -xCoord;
                    yPoints[i] = yCoord;
                }
            } else {
                xPoints[i] = -xCoord;
                yPoints[i] = yCoord;
            }

        }

        // Draw lines between zeros
        if (drawLines == true) {

            // Array for lines between zeros
            ArrayList<Integer> startPoints = new ArrayList<>();
            ArrayList<Integer> endPoints = new ArrayList<>();

            for (int i = 1; i < (scores.length); i++) {

                // If a score is zero, take the previous point as a start point
                // Loop for a score that is more than zero, take that point as an end point               
                if (scores[i] == 0) {
                    if (scores[(i - 1)] == 0) {
                        // Skip over if true...
                    } else {
                        startPoints.add(i - 1);
                        for (int ii = i; ii < scores.length; ii++) {
                            if (scores[ii] > 0) {
                                endPoints.add(ii);
                                break;
                            }
                        }
                    }
                }
            }

            // If the final point is a zero, assign the first number above zero as an end point
            if (scores[scores.length - 1] == 0) {
                for (int j = 0; j < scores.length; j++) {
                    if (scores[j] > 0) {
                        endPoints.add(j);
                        break;
                    }
                }
            }

            // If the first score is a zero, go backwards to find the start point
            if (scores[0] == 0) {
                for (int ii = (scores.length - 1); ii > 0; ii--) {
                    if (scores[ii] > 0) {
                        startPoints.add(ii);
                        for (int iii = 0; iii < scores.length; iii++) {
                            if (scores[iii] > 0) {
                                endPoints.add(iii);
                                break;
                            }
                        }
                        break;
                    }
                }
            }

            // Reassign array list to actual array
            Integer[] start = startPoints.toArray(new Integer[0]);
            Integer[] end = endPoints.toArray(new Integer[0]);

            G2D.setColor(selectedColor);

            for (int i = 0; i < start.length; i++) {
                G2D.drawLine(yPoints[start[i]], xPoints[start[i]], yPoints[end[i]], xPoints[end[i]]);
            }
        }

        // Plot radar with loaded arrays
        if (drawPolygons == true) {
            G2D.setColor(selectedColor);
            G2D.drawPolygon(yPoints, xPoints, points);
            G2D.setColor(new Color(selectedColor.getRed(), selectedColor.getGreen(), selectedColor.getBlue(), 40));
            G2D.fillPolygon(yPoints, xPoints, points);
        }

        //   Draw scores onto the chart
        if (drawScores == true) {
            int ovalSize = 0;

            G2D.setFont(new Font("Arial", Font.BOLD, 15));
            for (int i = 0; i < scores.length; i++) {
                G2D.setColor(selectedColor);

                if (scores[i] > 0) {
                    if (drawNumbers == true) {
                        ovalSize = Math.abs(superOrigin - radius) / 23;
                    } else {
                        ovalSize = Math.abs(superOrigin - radius) / 25;
                    }
                    G2D.fillOval(yPoints[i] - ovalSize, xPoints[i] - ovalSize, 2 * ovalSize, 2 * ovalSize);
                    G2D.setColor(Color.WHITE);

                    String txt = "" + (scores[i]);
                    G2D.drawString(txt, yPoints[i] - 4, xPoints[i] + 5);
                }
            }
        }
    }
}
