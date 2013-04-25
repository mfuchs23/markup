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

import org.dbdoclet.xiphias.dom.DocumentFragmentImpl;
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

    public static String getTag() {

	return tag;
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

		    HtmlElement elem = (HtmlElement) node;

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

    @Override
	public void init() {

    }

    @Override
	public boolean validate() {

	if (validate(validParentMap)) {

	    return true;
	}

	if (getParentNode() instanceof DocumentFragmentImpl) {

	    Div div = new Div();
	    div.appendChild(this);

	    nodeStack.push(div);

	    return true;
	}

	return false;
    }
}
