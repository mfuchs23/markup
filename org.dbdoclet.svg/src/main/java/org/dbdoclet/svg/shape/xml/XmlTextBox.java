/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg.shape.xml;

import java.awt.Font;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbdoclet.svg.Area;
import org.dbdoclet.svg.SvgFontMetrics;
import org.dbdoclet.svg.shape.Text;
import org.dbdoclet.svg.shape.TextBox;
import org.w3c.dom.Document;

public class XmlTextBox extends TextBox {

    private static Log logger = LogFactory.getLog(TextBox.class);

    public XmlTextBox(Document doc, String id, int x, int y) {

        super(id, x, y);

        if (doc == null) {
            throw new IllegalArgumentException("The argument doc must not be null!");
        }

        setDocument(doc);
    }
    
    public void draw(int x, int y) {
        
        Document doc = getDocument();

        int width = getWidth();
        int height = getHeight();
        int roundedCorner = getRoundedCorner();
        
        logger.debug("Zeichne Textbox an Position: " + x + ", " + y + ", Breite: " + width + ", Höhe: " + height);

        Area area = new Area();
        area.addCoords(x, y);
        area.addCoords(x + width, y + height);
		area.setName(getName());
        setArea(area);
        
        XmlRectangle rect = new XmlRectangle(doc, x, y, width, height);
        rect.setFill(getBackgroundColor());
        rect.setStroke(getStrokeColor());
        rect.setShadowEnabled(isShadowEnabled());
        
        if (roundedCorner > 0) {
            rect.setRx(roundedCorner);
            rect.setRy(roundedCorner);
        }

        rect.draw();
        
        int ypos = y + getTopPadding();
        int xpos;
        int lineWidth;
        
        Iterator<Text> iterator = getLineList().iterator();
        
        while (iterator.hasNext()) {

            Text line = (Text) iterator.next();
            Font font = line.getFont();

            SvgFontMetrics fm;

            if (font != null) {
                fm = new SvgFontMetrics(font, line.getText());
            } else {
                fm = new SvgFontMetrics(getDefaultFont(), line.getText());
            }

            ypos += fm.getAscent();

            lineWidth = fm.stringWidth();
            xpos = x + ((width - lineWidth) / 2);

            XmlText text = new XmlText(doc, xpos, ypos, line.getText());
            text.setFont(line.getFont());
            text.setFill(getTextColor());
            text.draw();
            
            // SvgServices.drawString(doc, xpos, ypos, line.getText(), line.getFont());

            ypos += fm.getDescent() + fm.getLeading();
        }
    }
}
