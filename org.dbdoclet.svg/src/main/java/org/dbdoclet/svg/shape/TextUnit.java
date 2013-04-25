/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg.shape;

import java.awt.Font;

public class TextUnit 
    implements Text {

    private String text;
    private Font font;
    
    public TextUnit(String text) {

        this(text, null);
    }
    
    public TextUnit(String text, Font font) {

        this.text = text;
        this.font = font;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public String getText() {
        return text;
    }

    public void setFont(Font font) {
        this.font = font;
    }
    
    public Font getFont() {
        return font;
    }
}
