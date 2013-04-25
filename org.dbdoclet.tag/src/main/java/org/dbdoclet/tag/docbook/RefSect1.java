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

public class RefSect1 extends DocBookElement {

    private static String tagName = "refsect1";

    RefSect1() {

        super(tagName);

        setFormatType(FORMAT_BLOCK);
        isContentModel(true);
    }

    RefSect1(String title) {

        this();
        appendChild(new Title(title));
    }

    public static String getTag() {
        return tagName;
    }

    public static HashMap<String, Object> getAttributeMap() {
        return new HashMap<String, Object>();
    }
}
