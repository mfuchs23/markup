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

public class XmlCircle extends XmlElement {

    private Document doc;
    private Element circle;
    private Element parent;
    private boolean shadowEnabled = false;
    private int cx;
    private int cy;
    private int radius;
    
    public XmlCircle(Document doc, int cx, int cy, int radius) {

        super(doc);
        
        if (doc == null) {
            throw new IllegalArgumentException("The argument doc must not be null!");
        }

        this.doc = doc;
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;

        circle = doc.createElementNS(SVGNS, "circle");
        circle.setAttributeNS(null, "cx", String.valueOf(cx));
        circle.setAttributeNS(null, "cy", String.valueOf(cy));
        circle.setAttributeNS(null, "r", String.valueOf(radius));
        circle.setAttributeNS(null, "fill", "white");
        circle.setAttributeNS(null, "stroke", "black");
    }
    
    public void setFill(Color fillColor) {
        circle.setAttributeNS(null, "fill", SvgServices.getColorAsHexString(fillColor));
    }
    
    public void setStroke(Color strokeColor) {
        circle.setAttributeNS(null, "stroke", SvgServices.getColorAsHexString(strokeColor));
    }
    
    public void setGradient(String gradientId) {
        circle.setAttributeNS(null, "fill", "url(#" + gradientId + ")");
    }
    
    public void setShadowEnabled(boolean shadowEnabled) {
        this.shadowEnabled = shadowEnabled;
    }
    
    public void draw() {

        if (parent == null) {
            parent = getDocumentElement();
        }

        if (shadowEnabled == true) {

            Element shadow = doc.createElementNS(SVGNS, "circle");
            shadow.setAttributeNS(null, "cx", String.valueOf(cx + 3));
            shadow.setAttributeNS(null, "cy", String.valueOf(cy + 3));
            shadow.setAttributeNS(null, "r", String.valueOf(radius));
            shadow.setAttributeNS(null, "fill", "dimgray");
            shadow.setAttributeNS(null, "stroke", "dimgray");
            shadow.setAttributeNS(null, "filter", "url(#blur)");

            parent.appendChild(shadow);
        }

        parent.appendChild(circle);
    }
}
