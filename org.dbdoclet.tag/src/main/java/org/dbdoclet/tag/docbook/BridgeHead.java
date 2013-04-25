/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class BridgeHead extends DocBookElement {

    BridgeHead() {
	super("bridgehead");
        setFormatType(FORMAT_BLOCK);
    }

    BridgeHead(String bridgehead) {
        this();
        appendChild(bridgehead);
    }

    BridgeHead(String bridgehead, String renderAs) {
        this();
        setAttribute("renderas", renderAs);
        appendChild(bridgehead);
    }

    public void setRenderAs(String renderAs) {
        setAttribute("renderas", renderAs);
    }
}
