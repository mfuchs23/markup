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

import org.dbdoclet.xiphias.dom.DocumentFragmentImpl;

public class Article extends Inline2Element {

	private static final String tag = "article";

	public Article() {

		setNodeName(tag);
		setFormatType(FORMAT_BLOCK);
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
			validParentMap.remove(Address.getTag());
		}
	}
}
