/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import java.util.HashMap;

public class Note extends DocBookElement {

    private static String tag = "note";

    public static HashMap<String, Object> getAttributeMap() {
	return new HashMap<String, Object>();
    }

    public static String getTag() {

	return tag;
    }

    Note() {
	super("note");
	setFormatType(FORMAT_BLOCK);
    }

    Note(String strTitle) {
	super("note");

	Title title = new Title(strTitle);
	title.setParentNode(this);

	appendChild(title);

	setFormatType(FORMAT_BLOCK);
    }
}
