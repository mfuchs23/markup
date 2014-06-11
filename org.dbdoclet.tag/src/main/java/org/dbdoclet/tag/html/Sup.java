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

public class Sup extends InlineElement {

    private static String tag = "sup";
    private static HashMap<String, HashMap<String, String>> validParentMap;

    static {

	validParentMap = new HashMap<String, HashMap<String, String>>();
	validParentMap.putAll(blockElementMap);
	validParentMap.putAll(inlineElementMap);
	validParentMap.remove(Pre.getTag());
    }

    public static String getTag() {

	return tag;
    }

    public Sup() {

	setNodeName(tag);
	setFormatType(FORMAT_INLINE);
    }

    @Override
    public void init() {

    }
}
