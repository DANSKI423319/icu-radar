package radar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Chart extends JPanel {

    private final int[] scores;
    private final int slices;
    private int radius;

    public Chart(int n, int input[], int size) {
        super(true);
        this.setPreferredSize(new Dimension(size, size));
        this.slices = n;
        this.scores = input;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D G2D = (Graphics2D) g;

        int alpha = 80;
        Color myColor = new Color(0, 255, 0, alpha);

        // Smooth lines
        G2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int range = 0;

        // Set range for chart
        for (int i = 0; i < scores.length; i++) {

            if (scores[i] > range) {
                range = scores[i];
                range = range + 1;
            } else if (scores[i] < 5) {
                range = 5;
                range = range + 1;
            }

        }

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

        ArrayList<Integer> startPoints = new ArrayList<>();
        ArrayList<Integer> endPoints = new ArrayList<>();

        // Get scores, load array(s)
        for (int i = 0; i < scores.length; i++) {

            double angle = 2 * Math.PI * i / slices;
            xCoord = (int) Math.round(0 + (scores[i] * superOrigin / range) * Math.cos(angle));
            yCoord = (int) Math.round(0 + (scores[i] * superOrigin / range) * Math.sin(angle));

            // Long drawn expression to draw lines between values where this is a zero
            // Can this be shortened?
            if (xCoord == 0) {

                if (i == 0) {
                    startPoints.add(scores.length - 1);
                } else {
                    startPoints.add(i - 1);
                }

                for (int ii = i; ii < scores.length; ii++) {
                    angle = 2 * Math.PI * ii / slices;
                    xCoord = (int) Math.round(0 + (scores[ii] * superOrigin / range) * Math.cos(angle));

                    if (ii == (scores.length - 1)) {
                        endPoints.add(scores.length - 1);
                    } else {
                        if (xCoord > 0) {
                            endPoints.add(ii);
                            break;
                        }
                        if (xCoord < 0) {
                            endPoints.add(ii);
                            break;
                        }
                    }
                }

            } else {
                xPoints[i] = -xCoord;
                yPoints[i] = yCoord;
            }

        }

        // Draw lines between values that have a score of zero
        Integer[] start = startPoints.toArray(new Integer[0]);
        Integer[] end = endPoints.toArray(new Integer[0]);

        G2D.setColor(Color.blue);

        // Draw lines where there are zeroes
        for (int i = 0; i < start.length; i++) {
            G2D.drawLine(yPoints[start[i]], xPoints[start[i]], yPoints[end[i]], xPoints[end[i]]);
            // System.out.println(start[i]);
            // System.out.println(end[i]);
        }

        // Plot radar, with loaded array(s)
        G2D.setColor(Color.green);
        G2D.drawPolygon(yPoints, xPoints, slices);
        G2D.setColor(myColor);
        G2D.fillPolygon(yPoints, xPoints, slices);

        int radiusSum = Math.abs(superOrigin - radius) / 3;

        // Plot scores
        for (int i = 0; i < scores.length; i++) {
            G2D.setColor(Color.green);

            if (scores[i] > 0) {
                G2D.fillOval(yPoints[i] - radiusSum, xPoints[i] - radiusSum, 2 * radiusSum, 2 * radiusSum);
                G2D.setColor(Color.blue);

                String txt = "" + (scores[i]);
                G2D.setFont(new Font("Arial", Font.PLAIN, 18));
                //String txt = (i + 1) + " X: " + Integer.toString(xPoints[i]) + ", Y:" + Integer.toString(yPoints[i]) + ".";
                G2D.drawString(txt, yPoints[i] - 5, xPoints[i] + 6);
            }

        }

        // String txt = (i + 1) + " X: " + Integer.toString(xPoints[i]) + ", Y:" + Integer.toString(yPoints[i]) + ".";
        /*
            int pointVal = scores[i];
            String stringVal = Integer.toString(pointVal);
         */
    }
}
