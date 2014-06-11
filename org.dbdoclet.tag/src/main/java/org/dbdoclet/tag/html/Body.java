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


public class Body extends ReplaceElement {

    private static final String tag = "body";
    private static HashMap<String, HashMap<String, String>> validParentMap;
    private static HashMap<String, String> attributeMap;

    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.put(Html.getTag(), HtmlElement.getAttributeMap());

        attributeMap = new HashMap<String, String>();
        attributeMap.put("bgcolor", "white");
    }

    public Body() {

        setNodeName(tag);
        setFormatType(FORMAT_BLOCK);
    }

}
