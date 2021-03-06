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

public class Simpara extends DocBookElement {

    private static final String tag = "simpara";
    private static HashMap<String, HashMap<String, Object>> invalidParentMap;

    static {

        invalidParentMap = new HashMap<String, HashMap<String, Object>>();
        invalidParentMap.put(Address.getTag(), Address.getAttributeMap());
        invalidParentMap.put(Subscript.getTag(), Subscript.getAttributeMap());
        invalidParentMap.put(Superscript.getTag(),
			       Superscript.getAttributeMap());
    }

    Simpara() {
        super(tag);

        setFormatType(FORMAT_BLOCK);
    }

    Simpara(String text) {
        this();

        appendChild(text);
    }

    public static String getTag() {

        return tag;
    }
}
