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
import java.awt.Font;

import org.dbdoclet.svg.SvgServices;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class XmlText extends XmlElement {

    private Element parent;
    private Element text;

    public XmlText(Document doc, int x, int y, String string) {

	super(doc);

	if (doc == null) {
	    throw new IllegalArgumentException("The argument doc must not be null!");
	}

	if (string == null) {
	    throw new IllegalArgumentException("The argument string must not be null!");
	}

	text = doc.createElementNS(SVGNS, "text");
	Text textNode = doc.createTextNode(string);
	text.appendChild(textNode);
	text.setAttributeNS(null, "x", String.valueOf(x));
	text.setAttributeNS(null, "y", String.valueOf(y));
	text.setAttributeNS(null, "color", "black");
    }

    public void setFont(Font font) {

	if (text == null) {
	    throw new IllegalStateException("The field text must not be null!");
	}

	if (font == null) {
	    throw new IllegalArgumentException("The argument font must not be null!");
	}

	String fontFamily = font.getFamily();

	if (fontFamily.equalsIgnoreCase("SansSerif")) {
	    fontFamily = "sans-serif";
	}

	if (fontFamily.equalsIgnoreCase("Dialog")) {
	    fontFamily = "sans-serif";
	}

	if (fontFamily.equalsIgnoreCase("sans-serif")) {
	    fontFamily = "Helvetica";
	}

	String style = "font-size:" + String.valueOf(font.getSize());
	style += ";font-family:" + fontFamily;
	
	if (font.isBold()) {
	    style += ";font-weight:bold";
	}

	if (font.isItalic()) {
	    style += ";font-style:italic";
	}

	text.setAttribute("style", style);
	
	/*
	text.setAttributeNS(null, "font-family", fontFamily);
	text.setAttributeNS(null, "font-size", String.valueOf(font.getSize()));

	if (font.isBold()) {
	    text.setAttributeNS(null, "font-weight", "bold");
	}

	if (font.isItalic()) {
	    text.setAttributeNS(null, "font-style", "italic");
	}
	*/
    }

    public void setFill(Color fillColor) {
	text.setAttributeNS(null, "fill", SvgServices.getColorAsHexString(fillColor));
    }

    public void draw() {

	if (parent == null) {
	    parent = getDocumentElement();
	}

	parent.appendChild(text);
    }
}
