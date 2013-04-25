/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Reference extends DocBookElement {

    private static String tagName = "reference";

    Reference() {

        super(tagName);
        setFormatType(FORMAT_BLOCK);
    }

    public static String getTag() {
        return tagName;
    }
}
