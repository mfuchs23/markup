/* 
 * ### Copyright (C) 2015 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Seg extends DocBookElement {

	private static String tag = "seg";

	public static String getTag() {
		return tag;
	}

	Seg() {

		super(tag);
		setFormatType(FORMAT_BLOCK);
	}
}

