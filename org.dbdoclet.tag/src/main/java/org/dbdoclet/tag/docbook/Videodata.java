/* 
 * ### Copyright (C) 2015 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Videodata extends DocBookElement {

	private static String tag = "videodata";

	public static String getTag() {
		return tag;
	}

	Videodata() {

		super(tag);
		setFormatType(FORMAT_BLOCK);
	}
}

