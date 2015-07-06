/* 
 * ### Copyright (C) 2015 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Termdef extends DocBookElement {

	private static String tag = "termdef";

	public static String getTag() {
		return tag;
	}

	Termdef() {

		super(tag);
		setFormatType(FORMAT_BLOCK);
	}
}

