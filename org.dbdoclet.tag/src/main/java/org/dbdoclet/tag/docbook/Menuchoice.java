/* 
 * ### Copyright (C) 2015 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Menuchoice extends DocBookElement {

	private static String tag = "menuchoice";

	public static String getTag() {
		return tag;
	}

	Menuchoice() {

		super(tag);
		setFormatType(FORMAT_BLOCK);
	}
}

