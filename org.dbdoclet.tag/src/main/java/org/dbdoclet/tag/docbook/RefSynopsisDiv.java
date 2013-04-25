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


public class RefSynopsisDiv extends DocBookElement {

    private static String tag = "refsynopsisdiv";

    RefSynopsisDiv() {
        super(tag);
    }

    public static String getTag() {

        return tag;
    }

    public static HashMap<String, Object> getAttributeMap() {

        return new HashMap<String, Object>();
    }
}
