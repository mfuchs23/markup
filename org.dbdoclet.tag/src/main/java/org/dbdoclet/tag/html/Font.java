/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;


public class Font extends InlineElement {

    private static final String tag = "font";

    public Font() {
        setNodeName(tag);
        setFormatType(FORMAT_INLINE);
    }
}
