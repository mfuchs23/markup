/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Classsynopsisinfo extends DocBookElement {

    private static final String tag = "classsynopsisinfo";

    Classsynopsisinfo() {

        super(tag);

        setFormatType(FORMAT_CONTENT);
        isLiteral(true);
    }

    Classsynopsisinfo(String text) {

        this();
        appendChild(text);
    }
}

