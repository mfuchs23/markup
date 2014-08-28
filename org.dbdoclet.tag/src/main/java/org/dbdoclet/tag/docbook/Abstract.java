/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Abstract extends DocBookElement {

    private static String tagName = "abstract";

    Abstract() {

        super(tagName);
        setFormatType(FORMAT_CONTENT);
    }
}
