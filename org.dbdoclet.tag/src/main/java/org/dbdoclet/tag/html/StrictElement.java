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

public abstract class StrictElement extends HtmlElement {

    @Override
	protected boolean validate(HashMap<String, HashMap<String, String>> validParentMap) {

	if (validParentMap == null) {
	    throw new IllegalArgumentException("Parameter validParentMap is null!");
	}

	if (getParentNode() == null) {
	    throw new NullPointerException("Variable getParent() is null!");
	}

	if (nodeStack == null) {
	    throw new NullPointerException("Variable nodeStack is null!");
	}

	nodeStack.removeAllElements();
	nodeStack.push(this);

	if (validParentMap.get(getParentNode().getNodeName()) != null) {
	    return true;
	}

	return false;
    }
}
