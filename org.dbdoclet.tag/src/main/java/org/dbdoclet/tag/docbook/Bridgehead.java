/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Bridgehead extends DocBookElement {

    Bridgehead() {
	super("bridgehead");
        setFormatType(FORMAT_BLOCK);
    }

    Bridgehead(String Bridgehead) {
        this();
        appendChild(Bridgehead);
    }

    Bridgehead(String Bridgehead, String renderAs) {
        this();
        setAttribute("renderas", renderAs);
        appendChild(Bridgehead);
    }

    public void setRenderAs(String renderAs) {
        setAttribute("renderas", renderAs);
    }
}
