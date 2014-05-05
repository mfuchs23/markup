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

public class Datalist extends InlineElement {

	private static final String tag = "datalist";

	public Datalist() {

		setNodeName(tag);
		setFormatType(FORMAT_INLINE);
	}

	public static String getTag() {
		return tag;
	}

	@Override
	public void init() {

		if (validParentMap == null) {

			validParentMap = new HashMap<String, HashMap<String, String>>();
    		validParentMap.putAll(blockElementMap);
    		validParentMap.putAll(inlineElementMap);
		}
	}
}
