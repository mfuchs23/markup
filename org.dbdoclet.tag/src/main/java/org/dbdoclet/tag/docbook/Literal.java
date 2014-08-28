/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */

package org.dbdoclet.tag.docbook;

public class Literal extends DocBookElement {

	private static String tag = "literal";

	public static String getTag() {

		return tag;
	}

	Literal() {
		super(tag);
		setFormatType(FORMAT_INLINE);
	}

	Literal(String text) {
		this();
		appendChild(text);
	}
}
