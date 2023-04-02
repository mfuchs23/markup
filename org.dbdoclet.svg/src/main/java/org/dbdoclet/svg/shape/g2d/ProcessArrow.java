/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg.shape.g2d;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import org.dbdoclet.svg.shape.Shape;

public class ProcessArrow extends Shape {

    protected int bottomPadding = 10;
    protected int leftPadding = 10;
    protected int rightPadding = 10;
    protected int topPadding = 10;
    protected String text;
    protected FontMetrics fontMetrics;
    
    public ProcessArrow(String id, int row, int col) {

        super(id, row, col);
        this.text = "";
        setGraphics2D(null);
    }

    public ProcessArrow(Graphics2D g2d, String id, int row, int col, String text) {

        super(id, row, col);
        this.text = text;

        setGraphics2D(g2d);
        fontMetrics = g2d.getFontMetrics();
    }

    public void setGraphics2D(Graphics2D g2d) {
        
        setGraphics2D(g2d);
        fontMetrics = g2d.getFontMetrics();
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getText() {
        return text;
    }

    public int getWidth() {
        return leftPadding + fontMetrics.stringWidth(text) + rightPadding;
    }
    
    public int getHeight() {
        return topPadding + fontMetrics.getHeight() + bottomPadding;
    }

    public void draw(int x, int y) {

        Graphics2D g2d = getGraphics2D();
        int width = getWidth();
        int height = getHeight();
        
        Polygon p = new Polygon();
        p.addPoint(x - 17, y);
        p.addPoint(x , y + height - (height / 2));
        p.addPoint(x - 17, y + height);
        p.addPoint(x + width, y + height);
        p.addPoint(x + width + 17, y + height - (height / 2));
        p.addPoint(x + width, y);
        
        g2d.setPaint(backgroundColor);
        g2d.fillPolygon(p);
        g2d.setPaint(foregroundColor);
        g2d.draw(p);
        g2d.drawString(text, x + leftPadding, y + topPadding + fontMetrics.getAscent());
    }
    
}
