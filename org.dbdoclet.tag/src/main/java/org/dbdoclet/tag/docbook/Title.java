/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import org.dbdoclet.xiphias.XmlServices;

public class Title extends DocBookElement {

	private static final String tag = "title";

	public static String getTag() {
		return tag;
	}

	Title() {
		super(tag);
	}

	Title(String title) {

		super(tag);

		if (title != null) {
			appendChild(XmlServices.textToXml(title));
		}
	}
}
