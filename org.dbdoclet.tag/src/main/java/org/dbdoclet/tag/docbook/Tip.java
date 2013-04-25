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


public class Tip extends DocBookElement {

    private static String tag = "tip";

    Tip() {
        super(tag);
        setFormatType(FORMAT_BLOCK);
    }

    Tip(String strTitle) {
        super(tag);

        Title title = new Title(strTitle);
        title.setParentNode(this);

        appendChild(title);

        setFormatType(FORMAT_BLOCK);
    }

    public static String getTag() {

        return tag;
    }

    public static HashMap<String, Object> getAttributeMap() {

        return new HashMap<String, Object>();
    }
}
