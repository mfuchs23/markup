/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import java.util.HashMap;

public class Variablelist extends DocBookElement {

    private static String tag = "variablelist";

    Variablelist() {
        super(tag);
        setFormatType(FORMAT_BLOCK);
    }

    public static String getTag() {

        return tag;
    }

    public static HashMap<String, Object> getAttributeMap() {

        return new HashMap<String, Object>();
    }

    @Override
    public void closed() {

        if (hasChildNodes() == false) {
            appendChild(new Varlistentry().appendChild(new Term()).appendChild(
                    new Listitem().appendChild(new Simpara())));
        }
    }
}
