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

public class Address extends DocBookElement {

	private static final String tag = "address";

	Address() {

		super(tag);
		setFormatType(FORMAT_BLOCK);
	}

	Address(String text) {

		this();
		appendChild(XmlServices.textToXml(text));
	}

	public static String getTag() {
		return tag;
	}
}
