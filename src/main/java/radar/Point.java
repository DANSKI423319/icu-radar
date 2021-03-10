/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radar;

import java.awt.*;

/**
 *
 * @author Daniel
 */
public class Point {
    
    private int score;
    private Color color;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point(int score, Color color) {
        this.score = score;
        this.color = color;
    }
    
}
