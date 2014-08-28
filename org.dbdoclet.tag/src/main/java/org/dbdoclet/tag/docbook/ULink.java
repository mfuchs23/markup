/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class ULink extends DocBookElement {

	private static final String tag = "ulink";

	ULink() {
		super(tag);
		setFormatType(FORMAT_INLINE);
	}

	ULink(String text) {
		this();
		appendChild(text);
	}

	public void setUrl(String url) {

		if ((url == null) || (url.length() == 0)) {
			url = "#";
		}

		setAttribute("url", url);
	}

	public String getUrl() {
		return getAttribute("url");
	}

	public static String getTag() {
		return tag;
	}
}
