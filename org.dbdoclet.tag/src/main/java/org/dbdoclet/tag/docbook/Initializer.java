/* 
 * ### Copyright (C) 2008  Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Initializer extends DocBookElement {

	private static final String tag = "initializer";

	Initializer() {

		super(tag);
		setFormatType(FORMAT_CONTENT);
	}

	Initializer(String text) {

		this();
		appendChild(hardenText(text));
	}

	public static String getTag() {
		return tag;
	}
}
