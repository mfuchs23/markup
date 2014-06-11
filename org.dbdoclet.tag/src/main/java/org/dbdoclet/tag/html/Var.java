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


public class Var extends InlineElement {

    private static String tag = "var";
    private static HashMap<String, HashMap<String, String>> validParentMap;
    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.putAll(blockElementMap);
        validParentMap.putAll(inlineElementMap);
    }

    public Var() {

        setNodeName(tag);
        setFormatType(FORMAT_INLINE);
    }

    public static String getTag() {

        return tag;
    }

    @Override
	public void init() {

    }

}
