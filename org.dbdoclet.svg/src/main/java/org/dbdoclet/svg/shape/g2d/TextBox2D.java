/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg.shape.g2d;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbdoclet.svg.shape.Text;
import org.dbdoclet.svg.shape.TextBox;

public class TextBox2D extends TextBox {

    private static Log logger = LogFactory.getLog(TextBox2D.class);

    public TextBox2D(Graphics2D g2d, String id, int row, int column) {

        super(id, row, column);

        if (g2d == null) {
            throw new IllegalArgumentException("The argument g2d must not be null!");
        }

        setGraphics2D(g2d);

        textHeight = getTopPadding() + getBottomPadding();
        textWidth = 0;
        lineList = new ArrayList<Text>();
    }
    
    public TextBox2D(Graphics2D g2d, String id, int row, int column, Text text) {

        super(id, row, column);

        if (g2d == null) {
            throw new IllegalArgumentException("The argument g2d must not be null!");
        }

        setGraphics2D(g2d);

        textHeight = getTopPadding() + getBottomPadding();
        textWidth = 0;
        
        lineList = new ArrayList<Text>();

        if (text != null) {
            addText(text);
        }
    }
    
    public void setText(Text text) {

        lineList.clear();
        textHeight = getTopPadding() + getBottomPadding();
        textWidth = 0;
        
        addText(text);
    }
    
    public int getWidth() {

        if (textWidth < minTextWidth) {
            textWidth = minTextWidth;
        }

        return textWidth;
    }
    
    public int getHeight() {
        return textHeight;
    }

    public void draw(int x, int y) {
        
        Graphics2D g2d = getGraphics2D();

        int width = getWidth();
        int height = getHeight();
        
        logger.debug("Zeichne Textbox an Position: " + x + "," + y + ", Breite: " + width + ", Höhe: " + height);
        drawBox(x, y, width, height);
        g2d.setPaint(Color.black);
        
        int ypos = y + getTopPadding();
        int xpos;
        int lineWidth;
        
        Iterator<Text> iterator = lineList.iterator();
        
        while (iterator.hasNext()) {

            Text line = (Text) iterator.next();
            Font font = line.getFont();

            FontMetrics fm;

            if (font != null) {

                g2d.setFont(font);
                fm = g2d.getFontMetrics(font);

            } else {

                fm = g2d.getFontMetrics();
            }

            ypos += fm.getAscent();

            lineWidth = fm.stringWidth(line.getText());
            xpos = x + ((width - lineWidth) / 2);
            g2d.drawString(line.getText(), xpos, ypos);

            ypos += fm.getDescent() + fm.getLeading();
        }
    }
    
    public void drawBox(int x, int y, int width, int height) {
        
        Graphics2D g2d = getGraphics2D();

        g2d.setPaint(getBackgroundColor());
        g2d.fill(new Rectangle(x, y, width, height));
        g2d.setPaint(getStrokeColor());
        g2d.draw(new Rectangle(x, y, width, height));
    }
}
