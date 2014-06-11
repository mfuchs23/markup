/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;

public class Iframe extends InlineElement {

    private static final String tagName = "iframe";
    
    public Iframe() {

        setNodeName(tagName);
        setFormatType(FORMAT_BLOCK);
    }
}
