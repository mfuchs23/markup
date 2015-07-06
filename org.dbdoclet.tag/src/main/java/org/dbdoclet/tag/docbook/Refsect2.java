/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

public class Refsect2 extends DocBookElement {

    public static final String tagName = "refsect2";

    Refsect2() {

        super(tagName);
        setFormatType(FORMAT_BLOCK);
    }
}
