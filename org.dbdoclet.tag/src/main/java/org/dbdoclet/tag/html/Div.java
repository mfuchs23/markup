/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;


public class Div extends Inline2Element {

    private static final String tag = "div";

    public Div() {

        setNodeName(tag);
        setFormatType(FORMAT_BLOCK);
    }
}
