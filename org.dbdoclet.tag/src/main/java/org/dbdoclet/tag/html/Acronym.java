/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;

public class Acronym extends InlineElement {

    private static final String tag = "acronym";

    public static String getTag() {
        return tag;
    }

    public Acronym() {
        setNodeName(tag);
        setFormatType(FORMAT_INLINE);
    }
}
