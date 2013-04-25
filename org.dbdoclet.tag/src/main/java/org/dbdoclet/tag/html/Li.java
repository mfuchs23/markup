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


public class Li extends StrictElement {

    private static final String tag = "li";
    private static HashMap<String, HashMap<String, String>> validParentMap;

    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.put(Dir.getTag(), HtmlElement.getAttributeMap());
        validParentMap.put(Menu.getTag(), HtmlElement.getAttributeMap());
        validParentMap.put(Ol.getTag(), HtmlElement.getAttributeMap());
        validParentMap.put(Ul.getTag(), HtmlElement.getAttributeMap());
    }

    public Li() {

        setNodeName("li");
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
