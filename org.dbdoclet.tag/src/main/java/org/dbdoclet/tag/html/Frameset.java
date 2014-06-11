/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;



public class Frameset extends StrictElement {

    private static final String tag = "frameset";
    public Frameset() {

        setNodeName(tag);
        setFormatType(FORMAT_BLOCK);
    }
}
