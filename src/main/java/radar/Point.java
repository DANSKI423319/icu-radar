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
    private int position;
    private String alias;
    private Color color;
    private Boolean zero;
    private Boolean missing;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Boolean getZero() {
        return zero;
    }

    public void setZero(Boolean zero) {
        this.zero = zero;
    }

    public Boolean getMissing() {
        return missing;
    }

    public void setMissing(Boolean missing) {
        this.missing = missing;
    }

    public Point(int score, int position, String alias, Color color) {
        this.score = score;
        this.position = position;
        this.alias = alias;
        this.color = color;
        this.zero = false;
        this.missing = false;        
    }

    public Point() {
    }

}
