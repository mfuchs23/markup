/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;

public class Aside extends Inline2Element {

    private static final String tag = "aside";

    public Aside() {

        setNodeName(tag);
        setFormatType(FORMAT_BLOCK);
    }

    public static String getTag() {
        return tag;
    }
}
