/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg.shape;

import java.util.ArrayList;


public abstract class TextBox extends TextShape {

    private int roundedCorner = 0;
    private boolean shadowEnabled = false;

    public abstract void draw(int x, int y);
    
    public TextBox(String id, int row, int column) {

        super(id, row, column);

        textHeight = topPadding + bottomPadding;
        textWidth = 0;
        lineList = new ArrayList<Text>();
    }
    
    public void setRoundedCorner(int roundedCorner) {
        this.roundedCorner = roundedCorner;
    }
    
    public int getRoundedCorner() {
        return roundedCorner;
    }

    public void setShadowEnabled(boolean shadowEnabled) {
        this.shadowEnabled = shadowEnabled;
    }
    
    public boolean isShadowEnabled() {
        return shadowEnabled;
    }
}
