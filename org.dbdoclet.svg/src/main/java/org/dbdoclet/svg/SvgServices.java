/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.PathIterator;

import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.dbdoclet.svg.shape.Connector;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SvgServices {

    public final static String SVGNS = SVGDOMImplementation.SVG_NAMESPACE_URI;

    public static void drawPolygon(Document doc, Polygon polygon, Color color) {
        
        if (doc == null) {
            throw new IllegalStateException("The field doc must not be null!");
        }
        
        PathIterator pi = polygon.getPathIterator(null);
        
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
        
        Element root = doc.getDocumentElement();
        Element elem = doc.createElementNS(SVGNS, "polygon");
        elem.setAttributeNS(null, "stroke", getColorAsHexString(color));
        elem.setAttributeNS(null, "fill", "none");
        elem.setAttributeNS(null, "points", points.toString());
        root.appendChild(elem);
    }

    public static void drawPolyline(Document doc, int[] xlist, int[] ylist, int size, Color color, int style) {
        
        if (doc == null) {
            throw new IllegalStateException("The field doc must not be null!");
        }
        
        StringBuffer points = new StringBuffer();

        for (int i = 0; i < size; i++) {
            points.append(xlist[i]);
            points.append(',');
            points.append(ylist[i]);
            points.append(' ');
        }

        Element root = doc.getDocumentElement();
        Element polyline = doc.createElementNS(SVGNS, "polyline");
        polyline.setAttributeNS(null, "fill", "none");
        polyline.setAttributeNS(null, "stroke", getColorAsHexString(color));

        if (style == Connector.STYLE_DASHED) {
            polyline.setAttributeNS(null, "stroke-dasharray", "5, 5");
		}

        polyline.setAttributeNS(null, "points", points.toString());
        root.appendChild(polyline);
    }

    public static String getColorAsHexString(Color color) {

        String red = Integer.toHexString(color.getRed());
        String green = Integer.toHexString(color.getGreen());
        String blue = Integer.toHexString(color.getBlue());

        StringBuffer buffer = new StringBuffer();
        buffer.append('#');
        
        if (red.length() == 1) {
            buffer.append('0');
        }

        buffer.append(red);
        
        if (green.length() == 1) {
            buffer.append('0');
        }

        buffer.append(green);
        
        if (blue.length() == 1) {
            buffer.append('0');
        }

        buffer.append(blue);

        return buffer.toString();
    }
    
    
}
