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

public class FormalPara extends DocBookElement {

    private static String tag = "formalpara";

    FormalPara() {
        super("formalpara");
        setFormatType(FORMAT_BLOCK);
    }

    FormalPara(String text) {
        this();
        appendChild(text);
    }

    public static String getTag() {
        return tag;
    }

    public static HashMap<String, Object> getAttributeMap() {
        return new HashMap<String, Object>();
    }
}
