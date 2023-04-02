/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

public class SvgFontMetrics {

    private Graphics2D g2d;
    private String text;
    private FontMetrics fm;
    
    public SvgFontMetrics(Font font, String text) {

        if (font == null) {
            throw new IllegalArgumentException("The argument font must not be null!");
        }

        if (text == null) {
            throw new IllegalArgumentException("The argument text must not be null!");
        }

        this.text = text;

        // BufferedImage bi = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        // g2d = bi.createGraphics();

        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        Document document = domImpl.createDocument(SvgConstants.SVGNS, "svg", null);

        g2d = new SVGGraphics2D(document);

        fm = g2d.getFontMetrics(font);
    }

    public int stringWidth() {

        return fm.stringWidth(text);
    }

    public int stringHeight() {

        return fm.getHeight();
    }

    public float getAscent() {
        return fm.getAscent();
    }

    public float getDescent() {
        return fm.getDescent();
    }

    public float getLeading() {
        return fm.getLeading();
    }
}
