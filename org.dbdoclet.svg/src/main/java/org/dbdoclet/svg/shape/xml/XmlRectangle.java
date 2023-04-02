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

import org.dbdoclet.svg.SvgConstants;
import org.dbdoclet.svg.SvgServices;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlRectangle extends XmlElement {

    private Document doc;
    private Element rect;
    private Element parent;
    private boolean shadowEnabled = false;
    private int x;
    private int y;
    private int rx;
    private int ry;
    private int width;
    private int height;
    
    public XmlRectangle(Document doc,int x, int y, int width, int height) {

        super(doc);
        
        if (doc == null) {
            throw new IllegalArgumentException("The argument doc must not be null!");
        }

        this.doc = doc;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        rect = doc.createElementNS(SvgConstants.SVGNS, "rect");
        rect.setAttributeNS(null, "x", String.valueOf(x));
        rect.setAttributeNS(null, "y", String.valueOf(y));
        rect.setAttributeNS(null, "width", String.valueOf(width));
        rect.setAttributeNS(null, "height", String.valueOf(height));
        rect.setAttributeNS(null, "fill", "white");
        rect.setAttributeNS(null, "stroke", "black");
    }

    public void draw() {

        if (parent == null) {
            parent = getDocumentElement();
        }

        if (shadowEnabled == true) {

            Element shadow = doc.createElementNS(SvgConstants.SVGNS, "rect");
            shadow.setAttributeNS(null, "x", String.valueOf(x + 3));
            shadow.setAttributeNS(null, "y", String.valueOf(y + 3));
            shadow.setAttributeNS(null, "width", String.valueOf(width));
            shadow.setAttributeNS(null, "height", String.valueOf(height));
            shadow.setAttributeNS(null, "fill", "dimgray");
            shadow.setAttributeNS(null, "stroke", "dimgray");
            shadow.setAttributeNS(null, "filter", "url(#blur)");

            if (rx > 0) {
                shadow.setAttributeNS(null, "rx", String.valueOf(rx));
            }

            if (ry > 0) {
                shadow.setAttributeNS(null, "ry", String.valueOf(ry));
            }

            parent.appendChild(shadow);
        }

        parent.appendChild(rect);
    }


	public int getHeight() {
		return height;
	}

	public int getRx() {
    	
    	String rx = rect.getAttributeNS(null, "rx");
    	
    	if (rx == null) {
    		return 0;
    	}
    	
    	return Integer.valueOf(rx);
    }

	public int getWidth() {
		return width;
	}

	public int getX() {
		return x;
	}
    
    public int getY() {
		return y;
	}

    public void setFill(Color fillColor) {
        rect.setAttributeNS(null, "fill", SvgServices.getColorAsHexString(fillColor));
    }

    public void setFilter(String filterId) {
        rect.setAttributeNS(null, "filter", filterId);
    }
    
    public void setRx(int rx) {
        rect.setAttributeNS(null, "rx", String.valueOf(rx));
    }

    public void setRy(int ry) {
        rect.setAttributeNS(null, "ry", String.valueOf(ry));
    }
    
    public void setShadowEnabled(boolean shadowEnabled) {
        this.shadowEnabled = shadowEnabled;
    }
    
    public void setStroke(Color strokeColor) {
        rect.setAttributeNS(null, "stroke", SvgServices.getColorAsHexString(strokeColor));
    }
    
    public void setStrokeDashArray(String dashArray) {
        rect.setAttributeNS(null, "stroke-dasharray", dashArray);
    }
}
