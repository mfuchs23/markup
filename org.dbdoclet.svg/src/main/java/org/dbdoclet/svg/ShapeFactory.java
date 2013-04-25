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
import org.dbdoclet.svg.shape.Shape;
import org.dbdoclet.svg.shape.TextBox;
import org.dbdoclet.svg.shape.TextCircle;

public interface ShapeFactory {

    public Arrow createArrow(String id, Shape from, Shape to);
    public TextBox createTextBox(String id, int row, int column);
    public TextCircle createTextCircle(String id, int row, int column);
}
