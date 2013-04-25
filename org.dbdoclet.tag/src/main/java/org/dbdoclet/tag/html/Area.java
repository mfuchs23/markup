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

public class Area extends ReplaceElement {

    private static final String tag = "area";
    private static HashMap<String, HashMap<String, String>> validParentMap;
    private static HashMap<String, String> attributeMap;

    static {

	validParentMap = new HashMap<String, HashMap<String, String>>();
	validParentMap.put(Map.getTag(), Map.getAttributeMap());

	attributeMap = new HashMap<String, String>();
    }

    public static HashMap<String, String> getAttributeMap() {
	return attributeMap;
    }

    public static String getTag() {
	return tag;
    }

    public Area() {

	setNodeName(tag);
	setFormatType(FORMAT_CONTENT);
	isEmpty(true);

	setAttribute("alt", "area");
    }

    @Override
	public boolean validate() {

	if (validate(validParentMap)) {
	    return true;
	}

	return false;
    }
}
