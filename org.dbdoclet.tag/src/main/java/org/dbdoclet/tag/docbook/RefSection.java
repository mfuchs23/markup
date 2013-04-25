/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import java.util.HashMap;

public class RefSection extends DocBookElement {

	private static String tagName = "refsection";

	RefSection() {

		super(tagName);

		setFormatType(FORMAT_BLOCK);
		isContentModel(true);
	}

	RefSection(String title) {

		this();
		appendChild(new Title(title));
	}

	public static String getTag() {
		return tagName;
	}

	public static HashMap<String, Object> getAttributeMap() {
		return new HashMap<String, Object>();
	}
}
