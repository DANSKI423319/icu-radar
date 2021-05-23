package graphics;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Daniel
 */
public class Score extends JPanel {

    private int total;
    private final Color transparent = new Color(0, 0, 0, 0);

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Score(int total) {
        super(true);
        this.total = total;
        this.setBackground(transparent);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D G2D = (Graphics2D) g;

        G2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        int xOrigin = getWidth() / 2;
        int yOrigin = getHeight() / 2;
        int superOrigin = Math.min(xOrigin, yOrigin);
        G2D.translate(superOrigin, superOrigin);
        
        G2D.setFont(new Font("Arial", Font.BOLD, 18));
        
        int tempSize = 25;
        G2D.setColor(Color.GRAY);
        G2D.fillOval(0 - tempSize, 0 - tempSize, 2 * tempSize, 2 * tempSize);
        G2D.setColor(Color.WHITE);
        
        if (total >= 10 && total <= 99) {
            G2D.drawString("" + total, 0 - 10, 0 + 6);
        } else if (total >= 100) {
            G2D.drawString("" + total, 0 - 15, 0 + 6);
        } else {
            G2D.drawString("0" + total, 0 - 10, 0 + 6);
        }

    }
}
