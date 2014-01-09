/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg;

import org.dbdoclet.svg.shape.Arrow;
import org.dbdoclet.svg.shape.ClassBox;
import org.dbdoclet.svg.shape.Shape;
import org.dbdoclet.svg.shape.TextBox;
import org.dbdoclet.svg.shape.TextCircle;
import org.dbdoclet.svg.shape.xml.XmlArrow;
import org.dbdoclet.svg.shape.xml.XmlClassBox;
import org.dbdoclet.svg.shape.xml.XmlTextBox;
import org.dbdoclet.svg.shape.xml.XmlTextCircle;
import org.w3c.dom.Document;

public class ShapeXmlFactory implements ShapeFactory {

    private Document doc;
    
    public ShapeXmlFactory(Document doc) {

        if (doc == null) {
            throw new IllegalArgumentException("The argument doc must not be null!");
        }

        this.doc = doc;
    }
    
    public Arrow createArrow(String id, Shape from, Shape to) {
        return new XmlArrow(doc, id, from, to);
    }

    public ClassBox createClassBox(String id, int row, int column) {
        return new XmlClassBox(doc, id, row, column);
    }

    public TextBox createTextBox(String id, int row, int column) {
        return new XmlTextBox(doc, id, row, column);
    }

    public TextCircle createTextCircle(String id, int row, int column) {
        return new XmlTextCircle(doc, id, row, column);
    }
}
