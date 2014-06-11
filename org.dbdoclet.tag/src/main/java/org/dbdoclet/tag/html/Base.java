/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;


public class Base extends ReplaceElement {

    private static final String tag = "base";

    public Base() {

        setNodeName(tag);
        setFormatType(FORMAT_INLINE);
    }
}
