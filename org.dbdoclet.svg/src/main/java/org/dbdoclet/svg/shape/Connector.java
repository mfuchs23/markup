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

public abstract class Connector extends Element {

    public final static int STYLE_SOLID = 0;
    public final static int STYLE_DASHED = 1;

    public final static int ANCHOR_NONE = 0;
    public final static int ANCHOR_NORTH = 1;
    public final static int ANCHOR_NORTH_BY_EAST = 2;
    public final static int ANCHOR_NORTH_NORTHEAST = 3;
    public final static int ANCHOR_NORTHEAST_BY_NORTH = 4;
    public final static int ANCHOR_NORTHEAST = 5;
    public final static int ANCHOR_NORTHEAST_BY_EAST = 6;
    public final static int ANCHOR_EAST_NORTHEAST = 7;
    public final static int ANCHOR_EAST_BY_NORTH = 8;
    public final static int ANCHOR_EAST = 9;
    public final static int ANCHOR_EAST_BY_SOUTH = 10;
    public final static int ANCHOR_EAST_SOUTHEAST = 11;
    public final static int ANCHOR_SOUTHEAST_BY_EAST = 12;
    public final static int ANCHOR_SOUTHEAST = 13;
    public final static int ANCHOR_SOUTHEAST_BY_SOUTH = 14;
    public final static int ANCHOR_SOUTH_SOUTHEAST = 15;
    public final static int ANCHOR_SOUTH_BY_EAST = 16;
    public final static int ANCHOR_SOUTH = 17;
    public final static int ANCHOR_SOUTH_BY_WEST = 18;
    public final static int ANCHOR_SOUTH_SOUTHWEST = 19;
    public final static int ANCHOR_SOUTHWEST_BY_SOUTH = 20;
    public final static int ANCHOR_SOUTHWEST = 21;
    public final static int ANCHOR_SOUTHWEST_BY_WEST = 22;
    public final static int ANCHOR_WEST_SOUTHWEST = 23;
    public final static int ANCHOR_WEST_BY_SOUTH = 24;
    public final static int ANCHOR_WEST = 25;
    public final static int ANCHOR_WEST_BY_NORTH = 26;
    public final static int ANCHOR_WEST_NORTHWEST = 27;
    public final static int ANCHOR_NORTHWEST_BY_WEST = 28;
    public final static int ANCHOR_NORTHWEST = 29;
    public final static int ANCHOR_NORTHWEST_BY_NORTH = 30;
    public final static int ANCHOR_NORTH_NORTHWEST = 31;
    public final static int ANCHOR_NORTH_BY_WEST = 32;

    private Shape from;
    private Shape to;
    protected boolean directMode = true;
    private int startAnchor = ANCHOR_NONE;
    private int endAnchor = ANCHOR_NONE;
    private int linePadding = 15;
    private Font font = new Font("Dialog", Font.PLAIN, 9);

    public abstract void draw(int xpos1, int ypos1, int xpos2, int ypos2);

    public Connector(String id, Shape from, Shape to) {

	super(id);

	if (from == null) {
	    throw new IllegalArgumentException("The argument from must not be null!");
	}

	if (to == null) {
	    throw new IllegalArgumentException("The argument to must not be null!");
	}

	this.from = from;
	this.to = to;
    }

    public void setFrom(Shape from) {
	this.from = from;
    }

    public Shape getFrom() {
	return from;
    }

    public void setTo(Shape to) {
	this.to = to;
    }

    public Shape getTo() {
	return to;
    }

    public int getLinePadding() {
	return linePadding;
    }

    public void setLinePadding(int linePadding) {
	this.linePadding = linePadding;
    }

    public void setDirectMode(boolean directMode) {
	this.directMode = directMode;
    }

    public boolean getDirectMode() {
	return directMode;
    }

    public int getStartAnchor() {
	return startAnchor;
    }

    public void setStartAnchor(int startAnchor) {
	this.startAnchor = startAnchor;
    }

    public int getEndAnchor() {
	return endAnchor;
    }

    public void setEndAnchor(int endAnchor) {
	this.endAnchor = endAnchor;
    }

    public void setFont(Font font) {
	this.font = font;
    }

    public Font getFont() {
        return font;
    }
}
