/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.dita;

public class U extends DitaElement {

	private static String tag = "u";

	U() {
		super(tag);
		setFormatType(FORMAT_INLINE);
	}
}
