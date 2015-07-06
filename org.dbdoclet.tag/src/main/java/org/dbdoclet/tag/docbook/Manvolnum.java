/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

public class Manvolnum extends DocBookElement {

	private static String tag = "manvolnum";

	public static String getTag() {
		return tag;
	}

	Manvolnum() {
		super(tag);
	}
}
