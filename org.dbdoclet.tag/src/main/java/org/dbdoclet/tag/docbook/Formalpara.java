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

public class Formalpara extends DocBookElement {

	private static String tag = "formalpara";

	Formalpara() {
		super("formalpara");
		setFormatType(FORMAT_BLOCK);
	}

	public static String getTag() {
		return tag;
	}

	public static HashMap<String, Object> getAttributeMap() {
		return new HashMap<String, Object>();
	}
}
