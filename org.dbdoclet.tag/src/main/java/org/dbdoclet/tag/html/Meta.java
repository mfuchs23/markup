/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;

import java.util.HashMap;

public class Meta extends ReplaceElement {

	private static final String tag = "meta";
	private static HashMap<String, HashMap<String, String>> validParentMap;

	static {

		validParentMap = new HashMap<String, HashMap<String, String>>();
		validParentMap.put(Head.getTag(), HtmlElement.getAttributeMap());
	}

	public Meta() {

		setNodeName("meta");
		setFormatType(FORMAT_CONTENT);
		isEmpty(true);
	}

	public static String getTag() {
		return tag;
	}

	public String getName() {
		return getAttribute("name");
	}

	public String getContent() {
		return getAttribute("content");
	}
}
