/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;

import java.util.HashMap;

import org.dbdoclet.xiphias.dom.ElementImpl;
import org.dbdoclet.xiphias.dom.NodeImpl;

public class Select extends InlineElement {

    private static String tag = "select";
    private static HashMap<String, HashMap<String, String>> validParentMap;
    static {

	validParentMap = new HashMap<String, HashMap<String, String>>();
	validParentMap.putAll(blockElementMap);
	validParentMap.putAll(inlineElementMap);
	validParentMap.remove(Button.getTag());
    }

    public Select() {

	setNodeName(tag);
	setFormatType(FORMAT_BLOCK);
    }

    @Override
	public void closed() {

	boolean hasOptions = false;

	if (hasChildNodes() == true && getNumberOfChildNodes() > 0) {

	    for (NodeImpl node : getTrafoChildNodes()) {

		if (node instanceof HtmlElement) {

		    ElementImpl elem = (ElementImpl) node;

		    if (elem instanceof Option) {
			hasOptions = true;
		    }
		}
	    }
	}

	if (hasOptions == false) {
	    appendChild(new Option());
	}
    }
}
