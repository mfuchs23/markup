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


public class Th extends TableColumnElement {

    private static String tag = "th";
    private static HashMap<String, HashMap<String, String>> validParentMap;
    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.put(Tr.getTag(), HtmlElement.getAttributeMap());
    }

    public Th() {

        setNodeName(tag);
        setFormatType(FORMAT_CONTENT);
    }

    public static String getTag() {

        return tag;
    }

    @Override
	public void init() {

    }
}
