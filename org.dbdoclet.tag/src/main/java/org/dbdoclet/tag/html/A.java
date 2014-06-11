/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;


public class A extends InlineElement {

    private static final String tag = "a";

    public A() {
        setNodeName(tag);
        setFormatType(FORMAT_INLINE);
    }

    public String getHref() {
        return getAttribute("href");
    }

    public String getName() {
        return getAttribute("name");
    }
}
