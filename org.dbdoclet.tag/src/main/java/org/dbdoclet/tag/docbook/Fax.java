/* 
 * ### Copyright (C) 2015 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Fax extends DocBookElement {

	private static String tag = "fax";

	public static String getTag() {
		return tag;
	}

	Fax() {

		super(tag);
		setFormatType(FORMAT_BLOCK);
	}
}

