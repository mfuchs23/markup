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


public class Title extends StrictElement {

    private static final String tag = "title";
    private static HashMap<String, HashMap<String, String>> validParentMap;

    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.put(Head.getTag(), HtmlElement.getAttributeMap());
    }

    public Title() {

        setNodeName(tag);
        setFormatType(FORMAT_CONTENT);
    }

    @Override
	public void init() {

    }

    public static String getTag() {

        return tag;
    }
}
