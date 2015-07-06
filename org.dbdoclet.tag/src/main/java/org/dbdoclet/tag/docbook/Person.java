/* 
 * ### Copyright (C) 2015 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Person extends DocBookElement {

	private static String tag = "person";

	public static String getTag() {
		return tag;
	}

	Person() {

		super(tag);
		setFormatType(FORMAT_BLOCK);
	}
}

