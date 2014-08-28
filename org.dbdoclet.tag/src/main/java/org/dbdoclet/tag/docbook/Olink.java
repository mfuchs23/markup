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

public class Olink extends DocBookElement {

	Olink() {
		super("olink");
	}

	Olink(DocBookElement label, String targetdoc, String targetptr) {

		this(targetdoc, targetptr);
		appendChild(label);
	}

	Olink(String targetdoc, String targetptr) {

		this();

		setAttribute("targetdoc", hardenId(targetdoc));
		setAttribute("targetptr", hardenId(targetptr));
		setFormatType(FORMAT_INLINE);
	}

	Olink(String label, String targetdoc, String targetptr) {

		this(targetdoc, targetptr);
		appendChild(XmlServices.textToXml(label));
	}

	public void setTargetDoc(String targetdoc) {
		setAttribute("targetdoc", targetdoc);
	}

	public void setTargetPtr(String targetptr) {
		setAttribute("targetptr", targetptr);
	}
}
