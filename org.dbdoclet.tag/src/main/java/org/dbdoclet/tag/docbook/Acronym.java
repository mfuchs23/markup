/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

public class Acronym extends DocBookElement {

	private static final String tag = "acronym";

	Acronym() {
		super(tag);
		setFormatType(FORMAT_INLINE);
	}

	Acronym(String text) {
		super(tag);
		appendChild(text);
		setFormatType(FORMAT_INLINE);
	}

	public static String getTag() {

		return tag;
	}
}
