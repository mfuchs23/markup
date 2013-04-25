/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg.shape.xml;

import java.awt.Color;

import org.dbdoclet.svg.SvgServices;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlLine extends XmlElement {

    private Element line;
    private Element parent;
    
    public XmlLine(Document doc, int x1, int y1, int x2, int y2) {

        super(doc);
        
        if (doc == null) {
            throw new IllegalArgumentException("The argument doc must not be null!");
        }

        line = doc.createElementNS(SVGNS, "line");
        line.setAttributeNS(null, "x1", String.valueOf(x1));
        line.setAttributeNS(null, "y1", String.valueOf(y1));
        line.setAttributeNS(null, "x2", String.valueOf(x2));
        line.setAttributeNS(null, "y2", String.valueOf(y2));
        line.setAttributeNS(null, "stroke", "black");
        line.setAttributeNS(null, "stroke-width", "2");
    }
    
    public void setStroke(Color strokeColor) {
        line.setAttributeNS(null, "stroke", SvgServices.getColorAsHexString(strokeColor));
    }
    
    public void draw() {

        if (parent == null) {
            parent = getDocumentElement();
        }

        parent.appendChild(line);
    }
}
