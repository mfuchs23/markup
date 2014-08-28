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

public class ListItem extends DocBookElement {

	private static String tag = "listitem";

	public static HashMap<String, Object> getAttributeMap() {
		return new HashMap<String, Object>();
	}

	public static String getTag() {
		return tag;
	}

	ListItem() {

		super("listitem");
		setFormatType(FORMAT_BLOCK);
	}

	ListItem(String text) {

		this();
		appendChild(text);
	}
}
