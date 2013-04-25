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


public class Iframe extends InlineElement {

    private static final String tagName = "iframe";
    private static HashMap<String, HashMap<String, String>> validParentMap;
    private static HashMap<String, String> attributeMap;

    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.putAll(blockElementMap);
        validParentMap.putAll(inlineElementMap);
        validParentMap.remove("button");

        attributeMap = new HashMap<String, String>();
        attributeMap.put("align", "center");
        attributeMap.put("frameborder", "1");
        attributeMap.put("height", "");
        attributeMap.put("longdesc", "");
        attributeMap.put("marginwidth", "");
        attributeMap.put("marginheight", "");
        attributeMap.put("name", "");
        attributeMap.put("scrolling", "auto");
        attributeMap.put("src", "");
        attributeMap.put("width", "");
    }

    public Iframe() {

        setNodeName(tagName);
        setFormatType(FORMAT_BLOCK);
    }

    public static String getTag() {

        return tagName;
    }

    public static HashMap<String, String> getAttributeMap() {

        return attributeMap;
    }

    @Override
	public void init() {

    }

    @Override
	public boolean validate() {

        validateAttributes(attributeMap);

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
