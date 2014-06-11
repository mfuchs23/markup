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

import org.dbdoclet.xiphias.dom.ElementImpl;
import org.dbdoclet.xiphias.dom.NodeImpl;

public class Tbody extends StrictElement {

    private static String tag = "tbody";
    private static HashMap<String, HashMap<String, String>> validParentMap;
    static {

        validParentMap = new HashMap<String, HashMap<String, String>>();
        validParentMap.put(Table.getTag(), HtmlElement.getAttributeMap());
    }

    public static String getTag() {

        return tag;
    }

    public Tbody() {

        setNodeName(tag);
    }

    @Override
    public void closed() {

        boolean hasRows = false;

        if (hasChildNodes() == true && getNumberOfChildNodes() > 0) {

            for (NodeImpl node : getTrafoChildNodes()) {

                if (node instanceof HtmlElement) {

                    ElementImpl elem = (ElementImpl) node;

                    if (elem instanceof Tr) {
                        hasRows = true;
                    }
                }
            }
        }

        if (hasRows == false) {
            appendChild(new Tr().appendChild(new Td()));
        }
    }

    @Override
    public void init() {

    }
}
