/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import java.util.HashMap;


public class Subscript extends DocBookElement {

    private static HashMap<String, HashMap<String, Object>> invalidParentMap;
    private static String tag = "subscript";

    static {

        invalidParentMap = new HashMap<String, HashMap<String, Object>>();
        invalidParentMap.put(Abbrev.getTag(), Abbrev.getAttributeMap());
        invalidParentMap.put(Address.getTag(), Address.getAttributeMap());
    }

    Subscript() {
        super(tag);
        setFormatType(FORMAT_INLINE);
    }

    Subscript(String text) {
        super(tag);
        appendChild(text);
        setFormatType(FORMAT_INLINE);
    }

    public static String getTag() {

        return tag;
    }

    @Override
    public boolean validate() {

        return validate(invalidParentMap);
    }
}
