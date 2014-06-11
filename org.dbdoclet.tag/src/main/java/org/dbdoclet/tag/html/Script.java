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


public class Script extends InlineElement {

    private static final String tag = "script";
    private static HashMap<String, HashMap<String, String>> validParentMap;
    private static HashMap<String, String> attributeMap;

    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.putAll(blockElementMap);
        validParentMap.putAll(inlineElementMap);
        validParentMap.put(Head.getTag(), HtmlElement.getAttributeMap());

        attributeMap = new HashMap<String, String>();
    }

    public Script() {

        setNodeName(tag);

        setAttribute("type", "javascript");
    }

    public static HashMap<String, String> getAttributeMap() {

        return attributeMap;
    }
}
