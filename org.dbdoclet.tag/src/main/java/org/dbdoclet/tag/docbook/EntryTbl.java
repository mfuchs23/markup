/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class EntryTbl extends DocBookElement {

    EntryTbl() {
	super("entrytbl");
    }

    public EntryTbl setCols(int cols) {
	setAttribute("cols", new Integer(cols));
	return this;
    }
}
