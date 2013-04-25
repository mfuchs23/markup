/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg.shape;

public class DefaultShape extends Shape {

    public DefaultShape(String id, int row, int col) {

        super(id, row, col);
    }

    public int getWidth() {
        return 1;
    }
    
    public int getHeight() {
        return 1;
    }

    public void draw(int x, int y) {
    }
    
}

