package radar;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Plot extends JPanel {

    private final int SIZE = 400;
    private final Color selectedColor;
    private final Point[] scores;
    private final int points;
    private int radius;
    private final boolean drawLines;
    private final boolean drawScores;
    private final boolean drawNumbers;
    private final boolean drawPolygons;
    private final boolean drawMissing;
    private final boolean drawLinks;
    private final boolean drawZeros;
    private final boolean drawRelativeRange;
    private final boolean drawMissingZeros;
    private int modifiedRange;
    private final Color transparent = new Color(0, 0, 0, 0);

    public Plot(Color color, int nPoints, Point[] nScores,
            boolean boolLines, boolean boolScores, boolean boolNumbers,
            boolean boolPolygons, boolean boolMissing, boolean boolLinks,
            boolean boolZeros, boolean boolRelRange, boolean boolMissingZeros) {
        super(true);
        this.setPreferredSize(new Dimension(SIZE, SIZE));
        this.setBackground(transparent);
        this.selectedColor = color;
        this.points = nPoints;
        this.scores = nScores;
        this.drawLines = boolLines;
        this.drawScores = boolScores;
        this.drawNumbers = boolNumbers;
        this.drawPolygons = boolPolygons;
        this.drawMissing = boolMissing;
        this.drawLinks = boolLinks;
        this.drawZeros = boolZeros;
        this.drawRelativeRange = boolRelRange;
        this.drawMissingZeros = boolMissingZeros;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D G2D = (Graphics2D) g;

        G2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        G2D.setStroke(new BasicStroke(2));
        var defaultStroke = G2D.getStroke();

        // Check for zeros, set boolean
        for (int i = 0; i < scores.length; i++) {
            if (scores[i].getScore() == 0) {
                scores[i].setZero(true);
            }
        }

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
        int textRange;

        if (range <= imposedMaximum) {
            if (drawRelativeRange == true) {
                range = range + 2;
            } else {
                range = imposedMaximum;
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

        int xPoints[] = new int[scores.length];
        int yPoints[] = new int[scores.length];
        int xCoord, yCoord;

        // Get coordinates for the scores
        for (int i = 0; i < scores.length; i++) {

            // This will include zeros
            int theScore = scores[i].getScore() + 1;

            double angle = 2 * Math.PI * i / points;
            yCoord = (int) -Math.round(0 + (theScore * superOrigin / modifiedRange) * Math.cos(angle));
            xCoord = (int) Math.round(0 + (theScore * superOrigin / modifiedRange) * Math.sin(angle));

            xPoints[i] = xCoord;
            yPoints[i] = yCoord;

        }

        // Draw lines between zeros
        if (drawLines == true) {
            // <editor-fold defaultstate="collapsed" desc="Draw Lines Procedure">
            // Array for lines between zeros
            ArrayList<Integer> startPoints = new ArrayList<>();
            ArrayList<Integer> endPoints = new ArrayList<>();

            for (int i = 1; i < (scores.length); i++) {

                // If a score is zero, take the previous point as a start point
                // Loop for a score that is more than zero, take that point as an end point               
                if (scores[i].getZero() == true && scores[i].getMissing() == false) {
                    if (scores[(i - 1)].getZero() == true && scores[i].getMissing() == false) {
                        // Skip over if true...
                    } else {
                        startPoints.add(i - 1);
                        for (int ii = i; ii < scores.length; ii++) {
                            if (scores[ii].getScore() > 0) {
                                endPoints.add(ii);
                                break;
                            }
                        }
                    }
                }
            }

            // If the final point is a zero, assign the first number above zero as an end point
            if (scores[scores.length - 1].getZero() == true && scores[scores.length - 1].getMissing() == false) {
                for (int j = 0; j < scores.length; j++) {
                    if (scores[j].getScore() > 0) {
                        endPoints.add(j);
                        break;
                    }
                }
            }

            // If the first score is a zero, go backwards to find the start point
            if (scores[0].getZero() == true && scores[0].getMissing() == false) {
                for (int ii = (scores.length - 1); ii > 0; ii--) {
                    if (scores[ii].getScore() > 0) {
                        startPoints.add(ii);
                        for (int iii = 0; iii < scores.length; iii++) {
                            if (scores[iii].getScore() > 0) {
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

            float[] pattern = {10f, 10f, 1f, 10f};
            Stroke dashPatternStroke = new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1, pattern, 0);

            if (start.length > end.length || start.length < end.length) {
                // Do nothing... bad if this happens
            } else {
                for (int i = 0; i < start.length; i++) {
                    if (scores[start[i]].getScore() == 0 || scores[end[i]].getScore() == 0) {
                        // If the start OR end point is a zero, this skewers the visualization, and should not be drawn
                    } else {

                        if (drawLinks == true) {

                            if (scores[start[i]].getAlias().equals(scores[end[i]].getAlias())) {
                                G2D.setStroke(defaultStroke);
                                G2D.drawLine(xPoints[start[i]], yPoints[start[i]], xPoints[end[i]], yPoints[end[i]]);
                            } else {
                                G2D.setStroke(dashPatternStroke);
                                G2D.drawLine(xPoints[start[i]], yPoints[start[i]], xPoints[end[i]], yPoints[end[i]]);
                            }

                        } else {

                            if (scores[start[i]].getAlias().equals(scores[end[i]].getAlias())) {
                                G2D.setStroke(defaultStroke);
                                G2D.drawLine(xPoints[start[i]], yPoints[start[i]], xPoints[end[i]], yPoints[end[i]]);
                            }

                        }

                    }
                }
            }
            // </editor-fold>
        }

        // Draw lines between missing scores
        if (drawMissing == true) {
            // <editor-fold defaultstate="collapsed" desc="Draw Lines Procedure">
            // Array for lines between zeros
            ArrayList<Integer> startPoints = new ArrayList<>();
            ArrayList<Integer> endPoints = new ArrayList<>();

            for (int i = 1; i < (scores.length); i++) {
                // If a score is missing, take the previous point as a start point
                // Loop for a score that is not missing, take that point as an end point               
                if (scores[i].getMissing() == true) {

                    if (scores[(i - 1)].getMissing() == true) {
                        // Skip over if true...
                    } else {
                        String tempAlias = scores[i - 1].getAlias();
                        startPoints.add(i - 1);
                        for (int ii = i; ii < scores.length; ii++) {
                            if (scores[ii].getScore() > 0) {
                                endPoints.add(ii);
                                break;
                            }
                        }
                    }

                }
            }

            // If the final point is missing, assign the first number as an end point
            if (scores[scores.length - 1].getMissing() == true) {
                for (int j = 0; j < scores.length; j++) {
                    if (scores[j].getScore() > 0) {
                        endPoints.add(j);
                        break;
                    }
                }
            }

            // If the first score is a missing, go backwards to find the start point
            if (scores[0].getMissing() == true) {
                for (int j = (scores.length - 1); j > 0; j--) {
                    if (scores[j].getScore() > 0) {
                        startPoints.add(j);
                        String tempAlias = scores[j].getAlias();
                        for (int iii = 0; iii < scores.length; iii++) {
                            if (scores[iii].getScore() > 0) {
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

            G2D.setColor(Color.BLACK);

            if (start.length > end.length || start.length < end.length) {
                // Do nothing... bad if this happens
            } else {

                Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0);
                G2D.setStroke(dashed);

                float[] pattern = {10f, 10f, 1f, 10f};
                Stroke dashPatternStroke = new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1, pattern, 0);

                for (int j = 0; j < start.length; j++) {
                    if (scores[start[j]].getScore() == 0 || scores[end[j]].getScore() == 0) {
                        // If the start OR end point is a zero, this skewers the visualization, and should not be drawn
                    } else {
                        if (drawLinks == true) {

                            if (scores[start[j]].getAlias().equals(scores[end[j]].getAlias())) {
                                G2D.setStroke(dashed);
                                G2D.drawLine(xPoints[start[j]], yPoints[start[j]], xPoints[end[j]], yPoints[end[j]]);
                            } else {
                                G2D.setStroke(dashPatternStroke);
                                G2D.drawLine(xPoints[start[j]], yPoints[start[j]], xPoints[end[j]], yPoints[end[j]]);
                            }

                        } else {

                            if (scores[start[j]].getAlias().equals(scores[end[j]].getAlias())) {
                                G2D.setStroke(dashed);
                                G2D.drawLine(xPoints[start[j]], yPoints[start[j]], xPoints[end[j]], yPoints[end[j]]);
                            }

                        }

                    }
                }
                G2D.setStroke(defaultStroke);
            }

            // </editor-fold>
        }

        // Plot radar with loaded arrays
        if (drawPolygons == true) {
            G2D.setColor(selectedColor);
            G2D.drawPolygon(xPoints, yPoints, points);
            G2D.setColor(new Color(selectedColor.getRed(), selectedColor.getGreen(), selectedColor.getBlue(), 40));
            G2D.fillPolygon(xPoints, yPoints, points);
        }

        // Draw scores onto the chart
        if (drawScores == true) {
            int ovalSize = 0;
            int altOvalSize = Math.abs(superOrigin - radius) / 64;

            G2D.setFont(new Font("Arial", Font.BOLD, 15));
            for (int i = 0; i < scores.length; i++) {
                G2D.setColor((scores[i].getColor()));

                if (drawNumbers == true) {
                    ovalSize = Math.abs(superOrigin - radius) / 26;
                } else {
                    ovalSize = Math.abs(superOrigin - radius) / 28;
                }

                if (scores[i].getScore() >= 1) {
                    G2D.fillOval(xPoints[i] - ovalSize, yPoints[i] - ovalSize, 2 * ovalSize, 2 * ovalSize);
                    G2D.setColor(Color.WHITE);

                    String txt = "" + (scores[i].getScore());
                    G2D.drawString(txt, xPoints[i] - 4, yPoints[i] + 5);
                } else {

                    // Draw zeros in the middle of the plot
                    if (drawZeros == true) {

                        if (scores[i].getMissing() == true) {

                            if (drawMissingZeros == true) {
                                G2D.fillOval(xPoints[i] - ovalSize, yPoints[i] - ovalSize, 2 * ovalSize, 2 * ovalSize);
                                G2D.setColor(Color.WHITE);

                                String txt = "" + (scores[i].getScore());
                                G2D.drawString(txt, xPoints[i] - 4, yPoints[i] + 5);
                            } else {
                                G2D.setColor(Color.BLACK);
                                G2D.fillOval(xPoints[i] - altOvalSize, yPoints[i] - altOvalSize, 2 * altOvalSize, 2 * altOvalSize);
                            }

                        } else {
                            G2D.fillOval(xPoints[i] - ovalSize, yPoints[i] - ovalSize, 2 * ovalSize, 2 * ovalSize);
                            G2D.setColor(Color.WHITE);

                            String txt = "" + (scores[i].getScore());
                            G2D.drawString(txt, xPoints[i] - 4, yPoints[i] + 5);
                        }

                    }

                }
            }
        }
    }
}
