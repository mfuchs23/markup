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


public class Colgroup extends ReplaceElement {

    private static final String tag = "colgroup";
    private static HashMap<String, HashMap<String, String>> validParentMap;

    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.put(Table.getTag(), HtmlElement.getAttributeMap());
    }

    public Colgroup() {

        setNodeName(tag);
        setFormatType(FORMAT_BLOCK);
    }

    public static String getTag() {

        return tag;
    }

    @Override
	public void init() {

    }

    @Override
	public boolean validate() {

        if (validate(validParentMap)) {

            return true;
        }

        return false;
    }
}
