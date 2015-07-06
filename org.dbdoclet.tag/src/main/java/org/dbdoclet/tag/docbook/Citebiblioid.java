/* 
 * ### Copyright (C) 2015 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Citebiblioid extends DocBookElement {

	private static String tag = "citebiblioid";

	public static String getTag() {
		return tag;
	}

	Citebiblioid() {

		super(tag);
		setFormatType(FORMAT_BLOCK);
	}
}

