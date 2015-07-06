/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

public class Informalfigure extends DocBookElement {

	private static final String TAG = "informalfigure";

	public static String getTag() {
		return TAG;
	}

	Informalfigure() {
		super("informalfigure");
		setFormatType(FORMAT_BLOCK);
	}
}
