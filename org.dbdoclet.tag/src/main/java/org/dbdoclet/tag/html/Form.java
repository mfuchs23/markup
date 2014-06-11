/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;



public class Form extends ReplaceElement {

    private static final String tag = "form";
    public Form() {

        setNodeName(tag);
        setFormatType(FORMAT_INLINE);

        setAttribute("action", "#");
    }
}
