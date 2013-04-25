/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg.shape.xml;

import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlElement {

    public final static String SVGNS = SVGDOMImplementation.SVG_NAMESPACE_URI;

    public Document doc;
    
    public XmlElement(Document doc) {

        if (doc == null) {
            throw new IllegalArgumentException("The argument doc must not be null!");
        }

        this.doc = doc;
    }

    public Element getDocumentElement() {
        return doc.getDocumentElement();
    }
}
