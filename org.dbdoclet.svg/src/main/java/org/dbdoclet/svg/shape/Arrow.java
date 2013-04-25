/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg.shape;

public abstract class Arrow extends Connector {

    private boolean fillEnabled;
    private int style;
    protected int arrowHeadLength = 10;
    protected int arrowHeadWidth = 5;
    private String text;
    private boolean endArrowHeadEnabled = true;
    
    public Arrow(String id, Shape from, Shape to) {

	super(id, from, to);

	setFillEnabled(true);
	setStyle(STYLE_SOLID);
    }

    public boolean getFillEnabled() {
	return isFillEnabled();
    }

    public int getStyle() {
	return style;
    }

    public String getText() {
	return text;
    }

    public boolean hasText() {
	
	if (text != null && text.trim().length() > 0) {
	    return true;
	} else {
	    return false;
	}
    }

    public boolean isEndArrowHeadEnabled() {
        return endArrowHeadEnabled;
    }

    public boolean isFillEnabled() {
	return fillEnabled;
    }

    public void setEndArrowHeadEnabled(boolean endArrowHeadEnabled) {
        this.endArrowHeadEnabled = endArrowHeadEnabled;
    }

    public void setFillEnabled(boolean fillEnabled) {
	this.fillEnabled = fillEnabled;
    }

    public void setStyle(int style) {
	this.style = style;
    }

    public void setText(String text) {
	this.text = text;
    }

}
