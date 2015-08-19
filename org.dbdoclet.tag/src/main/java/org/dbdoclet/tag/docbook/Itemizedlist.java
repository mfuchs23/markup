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

public class Itemizedlist extends DocBookElement {

	private static String tag = "itemizedlist";

	public static HashMap<String, Object> getAttributeMap() {
		return new HashMap<String, Object>();
	}

	public static String getTag() {
		return tag;
	}

	Itemizedlist() {
		super("itemizedlist");
		setFormatType(FORMAT_BLOCK);
	}
}