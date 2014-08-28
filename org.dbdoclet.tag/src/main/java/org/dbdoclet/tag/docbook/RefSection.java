/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

public class RefSection extends DocBookElement {

	private static String tagName = "refsection";

	RefSection() {

		super(tagName);
		setFormatType(FORMAT_BLOCK);
	}
}
