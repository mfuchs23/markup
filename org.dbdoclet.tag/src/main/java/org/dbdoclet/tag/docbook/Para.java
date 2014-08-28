/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Para extends DocBookElement {

	private static String tag = "para";

	public static String getTag() {
		return tag;
	}

	Para() {

		super(tag);
		setFormatType(FORMAT_CONTENT);
	}

	Para(String text) {
		this();
		appendChild(text);
	}
}
