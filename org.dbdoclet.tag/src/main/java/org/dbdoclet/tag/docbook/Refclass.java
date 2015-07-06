/* 
 * ### Copyright (C) 2015 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Refclass extends DocBookElement {

	private static String tag = "refclass";

	public static String getTag() {
		return tag;
	}

	Refclass() {

		super(tag);
		setFormatType(FORMAT_BLOCK);
	}
}

