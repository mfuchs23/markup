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

import org.dbdoclet.xiphias.XmlServices;

public class Address extends DocBookElement {

    private static final String tagName = "address";
    private static final HashMap<String, HashMap<String, Object>> invalidParentMap;

    static {

        invalidParentMap = new HashMap<String, HashMap<String, Object>>();
        invalidParentMap.put(Subscript.getTag(), Subscript.getAttributeMap());
        invalidParentMap.put(Superscript.getTag(),
                             Superscript.getAttributeMap());
    }

    Address() {

        super(tagName);
        setFormatType(FORMAT_BLOCK);
        isMixedContentModel(true);
    }

    Address(String text) {

        this();
        appendChild(XmlServices.textToXml(text));
    }

    public static String getTag() {
        return tagName;
    }

    @Override
    public boolean validate() {
        return validate(invalidParentMap);
    }
}
