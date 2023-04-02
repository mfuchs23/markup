/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg.shape.g2d;

import java.awt.Graphics2D;
import java.awt.Polygon;

public class ProcessStartArrow extends ProcessArrow {

    public ProcessStartArrow(String id, int row, int col) {
        super(id, row, col);
    }

    public ProcessStartArrow(Graphics2D g2d, String id, int row, int col, String text) {

        super(g2d, id, row, col, text);
    }

    public void draw(int x, int y) {

        Graphics2D g2d = getGraphics2D();

        int width = getWidth();
        int height = getHeight();

        Polygon p = new Polygon();
        p.addPoint(x, y);
        p.addPoint(x, y + height);
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
