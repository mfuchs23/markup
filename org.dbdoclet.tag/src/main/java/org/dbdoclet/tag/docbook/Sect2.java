/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

public class Sect2 extends SectionElement {

    private final static String tag = "sect2";

    Sect2() {

        super(tag);
        setFormatType(FORMAT_BLOCK);
    }

    public static String getTag() {
        return tag;
    }
}
