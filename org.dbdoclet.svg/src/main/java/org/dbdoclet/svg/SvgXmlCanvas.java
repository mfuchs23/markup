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
import java.util.ArrayList;

import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.dbdoclet.svg.shape.Connector;
import org.dbdoclet.svg.shape.Shape;
import org.dbdoclet.svg.shape.xml.XmlRectangle;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;

public class SvgXmlCanvas extends SvgCanvas {

	private Element defs;

	public SvgXmlCanvas() {

		DOMImplementation domImpl = SVGDOMImplementation.getDOMImplementation();
		doc = domImpl.createDocument(SVGNS, "svg", null);

		Element root = doc.getDocumentElement();
		defs = doc.createElementNS(SVGNS, "defs");
		root.appendChild(defs);

		addBlurFilter();
		addRadialGradient();

		shapeList = new ArrayList<Shape>();
		connectorList = new ArrayList<Connector>();
	}

	public void setImageSize(int imageWidth, int imageHeight, int scaledWidth,
			int scaledHeight) {

		Element root = doc.getDocumentElement();

		if ((scaledWidth > 0 && scaledWidth < imageWidth)
				|| (scaledHeight > 0 && scaledHeight < imageHeight)) {

			root.setAttributeNS(null, "width", String.valueOf(scaledWidth));
			root.setAttributeNS(null, "height", String.valueOf(scaledHeight));

		} else {

			root.setAttributeNS(null, "width", String.valueOf(imageWidth));
			root.setAttributeNS(null, "height", String.valueOf(imageHeight));
		}

		root.setAttributeNS(null, "viewBox", "0 0 " + imageWidth + " "
				+ imageHeight);
		root.setAttributeNS(null, "preserveAspectRatio", "none");

		XmlRectangle rect = new XmlRectangle(doc, 0, 0, imageWidth, imageHeight);
		rect.setFill(Color.white);
		rect.setStroke(Color.white);
		rect.draw();
	}

	public void addBlurFilter() {

		Element filter = doc.createElementNS(SVGNS, "filter");
		filter.setAttributeNS(null, "id", "blur");
		defs.appendChild(filter);

		Element blur = doc.createElementNS(SVGNS, "feGaussianBlur");
		blur.setAttributeNS(null, "in", "SourceGraphic");
		blur.setAttributeNS(null, "stdDeviation", "3");
		blur.setAttributeNS(null, "result", "blur");
		filter.appendChild(blur);
	}

	public void addRadialGradient() {

		Element gradient = doc.createElementNS(SVGNS, "radialGradient");
		defs.appendChild(gradient);
		gradient.setAttributeNS(null, "id", "grad1");
		gradient.setAttributeNS(null, "fx", "30%");
		gradient.setAttributeNS(null, "fy", "30%");

		Element stop1 = doc.createElementNS(SVGNS, "stop");
		gradient.appendChild(stop1);
		stop1.setAttributeNS(null, "offset", "0%");
		stop1.setAttributeNS(null, "stop-color", "#fff");

		Element stop2 = doc.createElementNS(SVGNS, "stop");
		gradient.appendChild(stop2);
		stop2.setAttributeNS(null, "offset", "100%");
		stop2.setAttributeNS(null, "stop-color", "#99abc6");
	}
}
