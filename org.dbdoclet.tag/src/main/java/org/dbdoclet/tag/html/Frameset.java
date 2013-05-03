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


public class Frameset extends StrictElement {

    private static final String tag = "frameset";
    private static HashMap<String, HashMap<String, String>> validParentMap;

    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.put(Html.getTag(), HtmlElement.getAttributeMap());
    }

    public Frameset() {

        setNodeName(tag);
        setFormatType(FORMAT_BLOCK);
    }

    @Override
	public void init() {

    }

    public static String getTag() {

        return tag;
    }

    @Override
	public boolean validate() {

        if (validate(validParentMap)) {

            return true;
        }

        return false;
    }
}