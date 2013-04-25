/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;



public class Tgroup extends DocBookElement {

    Tgroup() {
	super("tgroup");
	setFormatType(FORMAT_BLOCK);
    }

    Tgroup setAlign(String align) {

	setAttribute("align", align);

	return this;
    }

    public Tgroup setCols(int cols) {

	setAttribute("cols", new Integer(cols));

	return this;
    }
}
