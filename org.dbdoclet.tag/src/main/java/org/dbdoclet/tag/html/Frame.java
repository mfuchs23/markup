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


public class Frame extends StrictElement {

    private static final String tag = "frame";
    private static HashMap<String, HashMap<String, String>> validParentMap;

    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.put(Frameset.getTag(), HtmlElement.getAttributeMap());
    }

    public Frame() {

        setNodeName(tag);
        setFormatType(FORMAT_CONTENT);
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