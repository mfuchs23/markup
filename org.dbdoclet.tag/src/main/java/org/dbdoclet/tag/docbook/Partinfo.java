/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Partinfo extends DocBookElement {

    private static final String tag = "partinfo";

    Partinfo() {

        super(tag);
        setFormatType(FORMAT_BLOCK);
    }

    public static String getTag() {
        return tag;
    }
}
