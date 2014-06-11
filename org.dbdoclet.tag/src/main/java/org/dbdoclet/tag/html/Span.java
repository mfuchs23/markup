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


public class Span extends InlineElement {

    private static final String tag = "span";
    private static HashMap<String, HashMap<String, String>> validParentMap;
    private static HashMap<String, String> attributeMap;

    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.putAll(blockElementMap);
        validParentMap.putAll(inlineElementMap);

        attributeMap = new HashMap<String, String>();
    }

    public Span() {

        setNodeName(tag);
    }

    public static String getTag() {

        return tag;
    }

    public static HashMap<String, String> getAttributeMap() {

        return attributeMap;
    }

    @Override
	public void init() {

    }
}
