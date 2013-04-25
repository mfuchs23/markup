/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg.shape;

import java.awt.Graphics2D;

import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.w3c.dom.Document;

public class Element {

    public final static String SVGNS = SVGDOMImplementation.SVG_NAMESPACE_URI;

    private Document doc;
    private Graphics2D g2d;
    
    public Element(String id) {
    }
    
    public void setDocument(Document doc) {
        this.doc = doc;
    }
    
    public Document getDocument() {
        return doc;
    }

    public void setGraphics2D(Graphics2D g2d) {
        this.g2d = g2d;
    }
    
    public Graphics2D getGraphics2D() {
        return g2d;
    }

}
