/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import org.dbdoclet.xiphias.XmlConstants;
import org.dbdoclet.xiphias.XmlServices;

public class Link extends DocBookElement {

	private static final String tag = "link";

	Link() {
		super(tag);
	}

	Link(DocBookElement label, String linkend) {

		this(linkend);
		appendChild(label);
	}

	Link(String linkend) {

		this();

		setAttribute("linkend", hardenId(linkend));
		setFormatType(FORMAT_INLINE);
	}

	Link(String label, String linkend) {

		this(linkend);
		appendChild(XmlServices.textToXml(label));
	}

	public void setHref(String href) {

		if (isDocBook5() == true) {
			setAttributeNS(XmlConstants.NAMESPACE_XLINK, "xl:href", href);
		} else {
			setAttribute("linkend", href);
		}
	}
}
