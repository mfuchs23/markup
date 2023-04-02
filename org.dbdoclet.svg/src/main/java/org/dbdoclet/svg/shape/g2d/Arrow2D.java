/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg.shape.g2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

import org.dbdoclet.svg.shape.Arrow;
import org.dbdoclet.svg.shape.Shape;

public class Arrow2D extends Arrow {
    
    public Arrow2D(Graphics2D g2d, String id, Shape from, Shape to) {

        super(id, from, to);

        if (g2d == null) {
            throw new IllegalArgumentException("The argument g2d must not be null!");
        }

        setGraphics2D(g2d);
        
        setFillEnabled(true);
        setStyle(STYLE_SOLID);
    }

    public boolean getFillEnabled() {
        return isFillEnabled();
    }

    public void draw(int xpos1, int ypos1, int xpos2, int ypos2) {

        if (getDirectMode() == true) {
            drawDirect(xpos1, ypos1, xpos2, ypos2);
        } else {
            drawRightAngled(xpos1, ypos1, xpos2, ypos2);
        }
    }

    public void drawRightAngled(int xpos1, int ypos1, int xpos2, int ypos2) {

        int ymid = 0;
        Graphics2D g2d = getGraphics2D();
        
        // Von unten nach oben
        if (ypos2 < ypos1) {
            ymid = ypos2 + ((ypos1 - ypos2) * 2 / 3);
        }

        int[] xlist = new int[4];
        int[] ylist = new int[4];
        
        xlist[0] = xpos1;
        xlist[1] = xpos1;
        xlist[2] = xpos2;
        xlist[3] = xpos2;

        ylist[0] = ypos1;
        ylist[1] = ymid;
        ylist[2] = ymid;
        ylist[3] = ypos2;
        
        g2d.setStroke(new BasicStroke());
        Point neck = drawArrowHead(g2d, xlist[2], ylist[2], xlist[3], ylist[3]);

        xlist[3] = neck.x;
        ylist[3] = neck.y;

        g2d.drawPolyline(xlist, ylist, 4);
    }
    
    public void drawDirect(int xpos1, int ypos1, int xpos2, int ypos2) {

        Graphics2D g2d = getGraphics2D();

        if (g2d == null) {
            throw new IllegalStateException("The field g2d must not be null!");
        }

        g2d.setStroke(new BasicStroke());
        Point neck = drawArrowHead(g2d, xpos1, ypos1, xpos2, ypos2);

        if (getStyle() == STYLE_DASHED) {
            g2d.setStroke(new BasicStroke(1.0F, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0F, new float[] { 4.0F, 4.0F}, 2.0F));
        } else {
            g2d.setStroke(new BasicStroke());
        }

        g2d.drawLine(xpos1, ypos1, neck.x, neck.y);

    }
        
    private Point drawArrowHead(Graphics2D g2d, int xpos1, int ypos1, int xpos2, int ypos2) {

        if (g2d == null) {
            throw new IllegalStateException("The field g2d must not be null!");
        }

        double a = Math.abs(xpos2 - xpos1);
        // logger.debug("a = " + a);
        double b = Math.abs(ypos2 - ypos1);
        // logger.debug("b = " + b);
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b,2));
        // logger.debug("c = " + c);
        
        double sin1 = 0;
        double cos1 = 1;
        
        if (c != 0) {
            sin1 = b / c;
            // logger.debug("sin1 = " + sin1);
            cos1 = a / c;
            // logger.debug("cos1 = " + cos1);
        }
        
        double c0 = arrowHeadLength;
        double a0 = cos1 * c0;
        // logger.debug("a0 = " + a0);
        double b0 = sin1 * c0;
        // logger.debug("b0 = " + b0);

        double x0;
        double y0;
        
        if (xpos2 > xpos1) {
            x0 = xpos2 - a0;
        } else {
            x0 = xpos2 + a0;
        }

        if (ypos2 > ypos1) {
            y0 = ypos2 - b0;
        } else {
            y0 = ypos2 + b0;
        }

        // logger.debug("x0 = " + x0 + ", y0 = " + y0);
        
        double cl = arrowHeadWidth;
        double al = cos1  * cl;
        double bl = sin1 * cl;
        
        // logger.debug("al = " + al + ", bl = " + bl);

        double xl, yl, xr, yr;
        
        if (xpos2 > xpos1) {
            xl = x0 - bl;
            xr = x0 + bl;
        } else {
            xl = x0 + bl;
            xr = x0 - bl;
        }

        if (ypos2 > ypos1) {
            yl = y0 + al;
            yr = y0 - al;
        } else {
            yl = y0 - al;
            yr = y0 + al;
        }

        // logger.debug("xl = " + xl + ", yl = " + yl);
        // logger.debug("xr = " + xr + ", yr = " + yr);

        Polygon p = new Polygon();
        p.addPoint(xpos2, ypos2);
        p.addPoint((int) xl,(int)  yl);
        p.addPoint((int ) xr, (int)yr);
        
        g2d.setPaint(Color.black);

        if (isFillEnabled() == true) {
            g2d.fillPolygon(p);
        } else {
            g2d.drawPolygon(p);
        }
        
        /*
        g2d.setPaint(Color.green);
        g2d.fillOval((int) x0, (int) y0, 4, 4);
        */

        return new Point((int) x0, (int) y0);
    }
}
 