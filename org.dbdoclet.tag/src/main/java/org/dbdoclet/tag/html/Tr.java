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

import org.dbdoclet.xiphias.dom.NodeImpl;

public class Tr extends StrictElement {

    private static String tagName = "tr";
    private static HashMap<String, HashMap<String, String>> validParentMap;
    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.put(Table.getTag(), HtmlElement.getAttributeMap());
        validParentMap.put(Tbody.getTag(), HtmlElement.getAttributeMap());
        validParentMap.put(Thead.getTag(), HtmlElement.getAttributeMap());
        validParentMap.put(Tfoot.getTag(), HtmlElement.getAttributeMap());
    }

    public static String getTag() {

        return tagName;
    }

    public Tr() {

        setNodeName(tagName);
        setFormatType(FORMAT_BLOCK);
    }

    @Override
    public void closed() {

        boolean hasColumns = false;

        if (hasChildNodes() == true && getNumberOfChildNodes() > 0) {

            for (NodeImpl node : getTrafoChildNodes()) {

                if (node instanceof HtmlElement) {

                    HtmlElement elem = (HtmlElement) node;

                    if (elem instanceof TableColumnElement) {
                        hasColumns = true;
                    }
                }
            }
        }

        if (hasColumns == false) {

            appendChild(new Td());
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

        return false;
    }

    @Override
    public boolean validateAttributes() {

        String valign = getAttribute("valign");

        if (valign != null) {

            if (valign.equalsIgnoreCase("top") == false && valign.equalsIgnoreCase("middle") == false
                    && valign.equalsIgnoreCase("bottom") == false && valign.equalsIgnoreCase("baseline") == false) {

                setAttribute("valign", "middle");
            }
        }

        return true;
    }

	public Integer getHeight() {
		return getIntAttribute("height");
	}
}
