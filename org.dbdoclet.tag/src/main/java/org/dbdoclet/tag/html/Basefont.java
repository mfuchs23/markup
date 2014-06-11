/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;


public class Basefont extends InlineElement {

    private static final String tag = "basefont";

    public Basefont() {

        setNodeName(tag);
        setFormatType(FORMAT_INLINE);
        isEmpty(true);

        setAttribute("size", "12px");
    }
}
