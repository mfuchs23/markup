/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

public class Emphasis extends DocBookElement {

	private final static String tag = "emphasis";

	Emphasis() {

		super(tag);
		setFormatType(FORMAT_INLINE);
	}

	Emphasis(String text) {

		this();
		appendChild(text);
	}

	Emphasis(String text, String role) {

		super(tag);
		appendChild(text);
		setAttribute("role", role);
		setFormatType(FORMAT_INLINE);
	}

	Emphasis(DocBookElement elem) {

		super(tag);
		appendChild(elem);
		setFormatType(FORMAT_INLINE);
	}

	public static String getTag() {
		return tag;
	}
}
