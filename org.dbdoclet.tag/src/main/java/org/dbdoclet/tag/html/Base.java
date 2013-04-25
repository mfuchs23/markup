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

public class Base extends ReplaceElement {

    private static final String tag = "base";
    private static HashMap<String, HashMap<String, String>> validParentMap;

    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.put(Head.getTag(), HtmlElement.getAttributeMap());
    }

    public Base() {

        setNodeName(tag);
        setFormatType(FORMAT_INLINE);
    }

    @Override
    public boolean validate() {

        if (validate(validParentMap)) {

            return true;
        }

        return false;
    }
}
