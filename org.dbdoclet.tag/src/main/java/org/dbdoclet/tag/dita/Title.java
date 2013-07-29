/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.dita;

import java.util.HashMap;

import org.dbdoclet.xiphias.XmlServices;

public class Title extends DitaElement {

	private static final String tag = "title";

	public static HashMap<String, Object> getAttributeMap() {
		return new HashMap<String, Object>();
	}

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
