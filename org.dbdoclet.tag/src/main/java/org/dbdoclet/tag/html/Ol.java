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

public class Ol extends Inline2Element {

    private static String tag = "ol";
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
    }

    public static String getTag() {

	return tag;
    }

    public Ol() {

	setNodeName(tag);
	setFormatType(FORMAT_BLOCK);
    }

    @Override
    public void closed() {

	if ((getChildNodes() == null) || (getChildNodes().getLength() == 0)) {

	    appendChild(new Li());
	} // end of if ()
    }

    @Override
    public void init() {

    }
}
