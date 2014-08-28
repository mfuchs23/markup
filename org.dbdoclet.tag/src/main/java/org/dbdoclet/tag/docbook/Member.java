/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Member extends DocBookElement {

	private static String tag = "member";

	public static String getTag() {
		return tag;
	}

	Member() {
		super(tag);
		setFormatType(FORMAT_CONTENT);
	}

	Member(String text) {
		this();
		appendChild(text);
	}
}
