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

public class BlockQuote extends DocBookElement {

    private static String tag = "blockquote";

    BlockQuote() {
        super("blockquote");
        setFormatType(FORMAT_BLOCK);
        isContentModel(true);
    }

    BlockQuote(String text) {
        this();
        appendChild(text);
    }

    public static String getTag() {

        return tag;
    }

    public static HashMap<String, Object> getAttributeMap() {

        return new HashMap<String, Object>();
    }
}
