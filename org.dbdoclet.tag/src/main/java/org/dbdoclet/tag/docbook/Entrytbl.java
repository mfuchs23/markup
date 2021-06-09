/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

public class Entrytbl extends DocBookElement {

	Entrytbl() {
		super("entrytbl");
	}

	public Entrytbl setCols(int cols) {
		setAttribute("cols", Integer.valueOf(cols));
		return this;
	}
}
