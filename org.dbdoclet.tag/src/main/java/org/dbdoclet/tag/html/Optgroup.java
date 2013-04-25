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

public class Optgroup extends StrictElement {

    private static final String tag = "optgroup";
    private static HashMap<String, HashMap<String, String>> validParentMap;
    private static HashMap<String, String> attributeMap;

    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.put(Select.getTag(), HtmlElement.getAttributeMap());

        attributeMap = new HashMap<String, String>();
    }

    public static HashMap<String, String> getAttributeMap() {

        return attributeMap;
    }

    public static String getTag() {

        return tag;
    }

    public Optgroup() {

        setNodeName(tag);
        setFormatType(FORMAT_BLOCK);
        setAttribute("label", "Optgroup");
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

        return false;
    }
}
