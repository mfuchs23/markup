/* 
 * ### Copyright (C) 2011 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Markup extends DocBookElement {

	private static String tag = "markup";

	Markup() {

		super(tag);
		setFormatType(FORMAT_INLINE);
	}

	Markup(String text) {

		super(tag);
		appendChild(text);
		setFormatType(FORMAT_INLINE);
	}

	Markup(String text, String role) {

		super(tag);
		appendChild(text);
		setAttribute("role", role);
		setFormatType(FORMAT_INLINE);
	}

	Markup(DocBookElement elem) {

		super(tag);
		appendChild(elem);
		setFormatType(FORMAT_INLINE);
	}

	public static String getTag() {
		return tag;
	}

}
