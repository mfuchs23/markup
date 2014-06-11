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


public class Map extends InlineElement {

    private static final String tag = "map";
    private static HashMap<String, HashMap<String, String>> validParentMap;
    private static HashMap<String, String> attributeMap;

    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.putAll(blockElementMap);
        validParentMap.putAll(inlineElementMap);

        attributeMap = new HashMap<String, String>();
    }

    public Map() {

        setNodeName(tag);
        setFormatType(FORMAT_BLOCK);

        setAttribute("name", "map");
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

    @Override
	public void closed() {

        if ((getChildNodes() == null) || (getChildNodes().getLength() == 0)) {
            appendChild(new Area());
        }
    }
}
