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

public class Strike extends InlineElement {

    private static String tag = "strike";
    private static HashMap<String, HashMap<String, String>> validParentMap;
    static {

	validParentMap = new HashMap<String, HashMap<String, String>>();
	validParentMap.putAll(blockElementMap);
	validParentMap.putAll(inlineElementMap);
    }

    public static String getTag() {

	return tag;
    }

    public Strike() {

	setNodeName(tag);
	setFormatType(FORMAT_INLINE);
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
