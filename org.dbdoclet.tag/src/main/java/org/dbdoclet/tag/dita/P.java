/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.dita;

public class P extends DitaElement {

	private static String tag = "p";

	P() {
		super(tag);
		setNodeName(tag);
		setFormatType(FORMAT_CONTENT);
	}
}
