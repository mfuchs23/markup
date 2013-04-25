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


public class Acronym extends DocBookElement {

    private static final String tag = "acronym";
    private static final HashMap<String, HashMap<String, Object>> invalidParentMap;

    static {

        invalidParentMap = new HashMap<String, HashMap<String, Object>>();
        invalidParentMap.put(Address.getTag(), Address.getAttributeMap());
        invalidParentMap.put(Subscript.getTag(), Subscript.getAttributeMap());
        invalidParentMap.put(Superscript.getTag(),
			       Superscript.getAttributeMap());
    }

    Acronym() {
        super(tag);
        setFormatType(FORMAT_INLINE);
    }

    Acronym(String text) {
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
