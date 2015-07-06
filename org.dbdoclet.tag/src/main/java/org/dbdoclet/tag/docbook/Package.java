/* 
 * ### Copyright (C) 2015 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Package extends DocBookElement {

	private static String tag = "package";

	public static String getTag() {
		return tag;
	}

	Package() {

		super(tag);
		setFormatType(FORMAT_BLOCK);
	}
}

