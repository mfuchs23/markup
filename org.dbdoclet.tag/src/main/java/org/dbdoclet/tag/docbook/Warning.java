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


public class Warning extends DocBookElement {

    private static String tag = "warning";

    Warning() {
        super(tag);

        setFormatType(FORMAT_BLOCK);
    }

    Warning(String strTitle) {
        super(tag);

        Title title = new Title(strTitle);
        title.setParentNode(this);
        appendChild(title);

        setFormatType(FORMAT_BLOCK);
    }

    Warning(String strTitle, String text) {
        super(tag);

        Title title = new Title(strTitle);
        title.setParentNode(this);
        appendChild(title);

        appendChild(new Para(text));

        setFormatType(FORMAT_BLOCK);
    }

    public static String getTag() {

        return tag;
    }

    public static HashMap<String, Object> getAttributeMap() {

        return new HashMap<String, Object>();
    }
}
