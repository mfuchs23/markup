/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;

import org.w3c.dom.Node;

public class Html extends StrictElement {

    @Override
    public boolean validate() {

	Node parent = getParentNode();
	
	if (parent instanceof HtmlDocument) {
	    
	    nodeStack.removeAllElements();
	    nodeStack.push(this);
	    return true;
	}
	
	return false;
    }

    private static final String tag = "html";

    public static String getTag() {
	return tag;
    }

    public Html() {
	setNodeName(tag);
	setFormatType(FORMAT_BLOCK);
    }
}
