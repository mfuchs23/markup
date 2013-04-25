/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class ClassSynopsisInfo extends DocBookElement {

    private static final String tag = "classsynopsisinfo";

    ClassSynopsisInfo() {

        super(tag);

        setFormatType(FORMAT_CONTENT);
        isLiteral(true);
    }

    ClassSynopsisInfo(String text) {

        this();
        appendChild(text);
    }
}

