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

public class Pre extends Inline2Element {

    private static final String tag = "pre";
    private static HashMap<String, HashMap<String, String>> validParentMap;

    static {

	validParentMap = new HashMap<String, HashMap<String, String>>();
	validParentMap.put(Applet.getTag(), Applet.getAttributeMap());
	validParentMap.put(Blockquote.getTag(), HtmlElement.getAttributeMap());
	validParentMap.put(Body.getTag(), HtmlElement.getAttributeMap());
	validParentMap.put(Button.getTag(), Button.getAttributeMap());
	validParentMap.put(Center.getTag(), HtmlElement.getAttributeMap());
	validParentMap.put(Dd.getTag(), HtmlElement.getAttributeMap());
	validParentMap.put(Del.getTag(), Del.getAttributeMap());
	validParentMap.put(Div.getTag(), HtmlElement.getAttributeMap());
	validParentMap.put(Fieldset.getTag(), Fieldset.getAttributeMap());
	validParentMap.put(Form.getTag(), Form.getAttributeMap());
	validParentMap.put(Iframe.getTag(), Iframe.getAttributeMap());
	validParentMap.put(Ins.getTag(), Ins.getAttributeMap());
	validParentMap.put(Li.getTag(), HtmlElement.getAttributeMap());
	validParentMap.put(Map.getTag(), Map.getAttributeMap());
	validParentMap.put(Noframes.getTag(), HtmlElement.getAttributeMap());
	validParentMap.put(Noscript.getTag(), HtmlElement.getAttributeMap());
	validParentMap.put(HtmlObject.getTag(), HtmlObject.getAttributeMap());
	validParentMap.put(Td.getTag(), HtmlElement.getAttributeMap());
	validParentMap.put(Th.getTag(), HtmlElement.getAttributeMap());

	new HashMap<String, String>();
    }

    public static String getTag() {

	return tag;
    }

    public Pre() {

	setNodeName(tag);
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
