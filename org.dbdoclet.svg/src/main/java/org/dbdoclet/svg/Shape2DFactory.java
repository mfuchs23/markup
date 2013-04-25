/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg;

import java.awt.Graphics2D;

import org.dbdoclet.svg.shape.Arrow;
import org.dbdoclet.svg.shape.Shape;
import org.dbdoclet.svg.shape.TextBox;
import org.dbdoclet.svg.shape.TextCircle;
import org.dbdoclet.svg.shape.g2d.Arrow2D;
import org.dbdoclet.svg.shape.g2d.TextBox2D;

public class Shape2DFactory implements ShapeFactory {

    private Graphics2D g2d;
    
    public Shape2DFactory(Graphics2D g2d) {
        
        if (g2d == null) {
            throw new IllegalStateException("The field g2d must not be null!");
        }

        this.g2d = g2d;
    }
    
    public Arrow createArrow(String id, Shape from, Shape to) {
        return new Arrow2D(g2d, id, from, to);
    }

    public TextBox createTextBox(String id, int row, int column) {
        return new TextBox2D(g2d, id, row, column);
    }

    public TextCircle createTextCircle(String id, int row, int column) {
	throw new IllegalStateException("TextCircle2D not yet implemented!");
    }
}
