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

public class A extends InlineElement {

    private static final String tag = "a";
    private static HashMap<String, HashMap<String, String>> validParentMap;

    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.putAll(blockElementMap);
        validParentMap.putAll(inlineElementMap);
        validParentMap.put(Caption.getTag(), HtmlElement.getAttributeMap());
        validParentMap.remove("a");
        validParentMap.remove("button");
    }

    public static String getTag() {

        return tag;
    }

    public A() {
        super();
        setNodeName(tag);
        setFormatType(FORMAT_INLINE);
    }

    public String getHref() {

        return getAttribute("href");
    }

    public String getName() {

        return getAttribute("name");
    }

    @Override
    public boolean validate() {

        if (super.validate(validParentMap)) {

            return true;
        }

        if (getParentNode() instanceof Body) {

            Div div = new Div();
            div.appendChild(this);

            nodeStack.push(div);
            return true;
        }

        return false;
    }
}
