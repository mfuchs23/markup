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


public class Sub extends InlineElement {

    private static String tag = "sub";
    private static HashMap<String, HashMap<String, String>> validParentMap;
    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.putAll(blockElementMap);
        validParentMap.putAll(inlineElementMap);
        validParentMap.remove(Pre.getTag());
    }

    public Sub() {

        setNodeName(tag);
        setFormatType(FORMAT_INLINE);
    }

    public static String getTag() {

        return tag;
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