package radar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Chart extends JPanel {

    private final int[] scores;
    private final int slices;
    private int radius;
    private boolean drawLines;
    private boolean drawScores;
    private boolean drawNumbers;

    public Chart(int n, int input[], int size, boolean lines, boolean scores, boolean numbers) {
        super(true);
        this.setPreferredSize(new Dimension(size, size));
        this.slices = n;
        this.scores = input;
        this.drawLines = lines;
        this.drawScores = scores;
        this.drawNumbers = numbers;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D G2D = (Graphics2D) g;

        int alpha = 80;
        Color myColor = new Color(0, 255, 0, alpha);

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
        int rangeScaled = 0;
        int rangeText = 0;

        // Adding a number makes the chart smaller, minusing a number makes it bigger
        if (drawNumbers == true) {
            rangeScaled = range + 1;
            rangeText = range;
        } else {
            rangeScaled = range;
        }

        int xOrigin = getWidth() / 2;
        int yOrigin = getHeight() / 2;

        // Change to Cartesian coordinates...
        int superOrigin = Math.min(xOrigin, yOrigin);
        G2D.translate(superOrigin, superOrigin);

        // Draw circle loop
        for (int i = 0; i < (range); i++) { // Range is the maximum score given, tells how many circles to make
            radius = i * superOrigin / (rangeScaled);
            G2D.drawOval(0 - radius, 0 - radius, 2 * radius, 2 * radius);
        }

        // Plot points
        int xPoints[] = new int[slices];
        int yPoints[] = new int[slices];
        int xCoord, yCoord;

        G2D.setColor(Color.black);
        G2D.setFont(new Font("Arial", Font.PLAIN, 14));

        /*
            Creates lines for points on the radar
         */
        for (int i = 0; i < slices; i++) {
            double angle = 2 * Math.PI * i / slices;

            xCoord = (int) Math.round(0 + ((range - 1) * superOrigin / rangeScaled) * Math.cos(angle));
            yCoord = (int) Math.round(0 + ((range - 1) * superOrigin / rangeScaled) * Math.sin(angle));

            G2D.drawLine(0, 0, yCoord, -xCoord);

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
                    G2D.drawString("0" + Integer.toString(i + 1), yCoord - 7, -xCoord);
                } else {
                    G2D.drawString(Integer.toString(i + 1), yCoord - 7, -xCoord);
                }
            }
        }

        /*
            Get coordinates for the scores
         */
        for (int i = 0; i < scores.length; i++) {

            double angle = 2 * Math.PI * i / slices;
            xCoord = (int) Math.round(0 + (scores[i] * superOrigin / rangeScaled) * Math.cos(angle));
            yCoord = (int) Math.round(0 + (scores[i] * superOrigin / rangeScaled) * Math.sin(angle));

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

        /*
           Draw lines between zeros
         */
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

            G2D.setColor(Color.green);

            for (int i = 0; i < start.length; i++) {
                G2D.drawLine(yPoints[start[i]], xPoints[start[i]], yPoints[end[i]], xPoints[end[i]]);
            }

        }

        /*
            Plot radar with loaded arrays
         */
        G2D.setColor(Color.green);
        G2D.drawPolygon(yPoints, xPoints, slices);
        G2D.setColor(myColor);
        G2D.fillPolygon(yPoints, xPoints, slices);


        /*
            Draw scores onto the chart
         */
        if (drawScores == true) {
            int ovalSize = 0;

            G2D.setFont(new Font("Arial", Font.BOLD, 15));
            for (int i = 0; i < scores.length; i++) {
                G2D.setColor(Color.green);

                if (scores[i] > 0) {
                    if (drawNumbers == true) {
                        ovalSize = Math.abs(superOrigin - radius) / 5;
                    } else {
                        ovalSize = Math.abs(superOrigin - radius) / 3;
                    }
                    G2D.fillOval(yPoints[i] - ovalSize, xPoints[i] - ovalSize, 2 * ovalSize, 2 * ovalSize);
                    G2D.setColor(Color.blue);

                    String txt = "" + (scores[i]);
                    G2D.drawString(txt, yPoints[i] - 4, xPoints[i] + 5);
                }
            }
        }
    }

}
