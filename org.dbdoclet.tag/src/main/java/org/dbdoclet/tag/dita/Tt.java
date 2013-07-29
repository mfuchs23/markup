/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.dita;

public class Tt extends DitaElement {

	private static String tag = "tt";

	Tt() {
		super(tag);
		setFormatType(FORMAT_INLINE);
	}
}
