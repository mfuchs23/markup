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

public class Applet extends InlineElement {

    private static final String tag = "applet";
    private static HashMap<String, HashMap<String, String>> validParentMap;
    private static HashMap<String, String> attributeMap;

    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.putAll(blockElementMap);
        validParentMap.putAll(inlineElementMap);
        validParentMap.remove(Pre.getTag());

        attributeMap = new HashMap<String, String>();
    }

    public Applet() {

        setNodeName(tag);
        setFormatType(FORMAT_INLINE);

        setAttribute("width", "400");
        setAttribute("height", "300");
    }

    public static String getTag() {

        return tag;
    }

    public static HashMap<String, String> getAttributeMap() {

        return attributeMap;
    }

    @Override
    public boolean validate() {

        if (validate(validParentMap)) {

            return true;
        }

        if (getParentNode() instanceof Body || getParentNode() instanceof DocumentFragmentImpl) {

            Div div = new Div();
            div.appendChild(this);

            nodeStack.push(div);

            return true;
        }

        return false;
    }
}