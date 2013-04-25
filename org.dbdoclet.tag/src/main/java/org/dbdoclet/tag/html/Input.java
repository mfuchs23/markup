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

public class Input extends InlineElement {

    private static final String tag = "input";
    private static HashMap<String, HashMap<String, String>> validParentMap;
    private static HashMap<String, String> attributeMap;

    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.putAll(blockElementMap);
        validParentMap.putAll(inlineElementMap);
        validParentMap.remove("button");

        attributeMap = new HashMap<String, String>();
        attributeMap.put("accept", "");
        attributeMap.put("accesskey", "");
        attributeMap.put("align", "top, middle, bottom, left, center, right");
        attributeMap.put("alt", "");
        attributeMap.put("checked", "");
        attributeMap.put("datafld", "");
        attributeMap.put("datasrc", "");
        attributeMap.put("dataformatas", "");
        attributeMap.put("disabled", "");
        attributeMap.put("id", "");
        attributeMap.put("ismap", "");
        attributeMap.put("maxlength", "");
        attributeMap.put("name", "");
        attributeMap.put("onblur", "");
        attributeMap.put("onchange", "");
        attributeMap.put("onfocus", "");
        attributeMap.put("onselect", "");
        attributeMap.put("readonly", "");
        attributeMap.put("size", "");
        attributeMap.put("src", "");
        attributeMap.put("tabindex", "");
        attributeMap.put("", "");
        attributeMap.put("type", "text, password, checkbox, radio, submit, reset, file, hidden, image, button");
        attributeMap.put("usemap", "");
        attributeMap.put("value", "");
    }

    public Input() {

        setNodeName(tag);
        setFormatType(FORMAT_INLINE);
        isEmpty(true);
    }

    public static String getTag() {

        return tag;
    }

    public static HashMap<String, String> getAttributeMap() {

        return attributeMap;
    }

    @Override
    public void init() {

    }

    @Override
    public boolean validate() {

        // validateAttributes(attributeMap);

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
