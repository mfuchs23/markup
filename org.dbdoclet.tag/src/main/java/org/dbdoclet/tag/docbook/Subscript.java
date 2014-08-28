/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;



public class Subscript extends DocBookElement {

    private static String tag = "subscript";

    Subscript() {
        super(tag);
        setFormatType(FORMAT_INLINE);
    }

    Subscript(String text) {
        super(tag);
        appendChild(text);
        setFormatType(FORMAT_INLINE);
    }

    public static String getTag() {

        return tag;
    }
}
