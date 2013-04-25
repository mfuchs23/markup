/* 
 * ### Copyright (C) 2008  Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import java.util.HashMap;

public class Initializer extends DocBookElement {

    private static final String tagName = "initializer";
    private static final HashMap<String, HashMap<String, Object>> validParentMap;

    static {

        validParentMap = new HashMap<String, HashMap<String, Object>>();

        validParentMap.put(FieldSynopsis.getTag(), FieldSynopsis.getAttributeMap());
        validParentMap.put(MethodParam.getTag(), MethodParam.getAttributeMap());
        validParentMap.put(ParamDef.getTag(), ParamDef.getAttributeMap());
    }

    Initializer() {

        super(tagName);
        setFormatType(FORMAT_CONTENT);
        isMixedContentModel(true);
    }

    Initializer(String text) {

        this();
        appendChild(hardenText(text));
    }

    public static String getTag() {
        return tagName;
    }

    @Override
    public boolean validate() {

        return validate2(validParentMap);
    }
}
