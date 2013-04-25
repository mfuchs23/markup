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

public class Important extends DocBookElement {

    private static String tag = "important";

    public static HashMap<String, Object> getAttributeMap() {
	return new HashMap<String, Object>();
    }

    public static String getTag() {

	return tag;
    }

    Important() {
	super("important");
	setFormatType(FORMAT_BLOCK);
    }

    Important(String strTitle) {
	this();

	Title title = new Title(strTitle);
	title.setParentNode(this);

	appendChild(title);
    }
}
