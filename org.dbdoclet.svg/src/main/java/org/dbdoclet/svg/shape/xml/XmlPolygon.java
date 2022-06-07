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
import java.awt.Polygon;
import java.awt.geom.PathIterator;

import org.dbdoclet.svg.SvgConstants;
import org.dbdoclet.svg.SvgServices;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlPolygon extends XmlElement {

    private Element polygon;
    private Element parent;
    public XmlPolygon(Document doc, Polygon p) {

        super(doc);
        
        if (doc == null) {
            throw new IllegalArgumentException("The argument doc must not be null!");
        }

        PathIterator pi = p.getPathIterator(null);
        StringBuffer points = new StringBuffer();
        double[] coords = new double[2];
		
        while(pi.isDone() == false){

            pi.currentSegment(coords);
            points.append((int) coords[0]);
            points.append(',');
            points.append((int) coords[1]);
            points.append(' ');
            
            pi.next();
        }

        polygon = doc.createElementNS(SvgConstants.SVGNS, "polygon");
        polygon.setAttributeNS(null, "stroke", "black");
        polygon.setAttributeNS(null, "fill", "none");
        polygon.setAttributeNS(null, "points", points.toString());
    }
    
    public void setFill(Color fillColor) {
        polygon.setAttributeNS(null, "fill", SvgServices.getColorAsHexString(fillColor));
    }
    
    public void setStroke(Color strokeColor) {
        polygon.setAttributeNS(null, "stroke", SvgServices.getColorAsHexString(strokeColor));
    }
    
    public void draw() {

        if (parent == null) {
            parent = getDocumentElement();
        }

        parent.appendChild(polygon);
    }
}
