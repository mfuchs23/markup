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

public class Caution extends DocBookElement {

    private static String tag = "caution";

    Caution() {
        super("caution");
        setFormatType(FORMAT_BLOCK);
    }

    Caution(String strTitle) {
        
        this();
        
        Title title = new Title(strTitle);
        title.setParentNode(this);
        
        appendChild(title);
    }

    public static String getTag() {
        return tag;
    }

    public static HashMap<String, Object> getAttributeMap() {
        return new HashMap<String, Object>();
    }
}
