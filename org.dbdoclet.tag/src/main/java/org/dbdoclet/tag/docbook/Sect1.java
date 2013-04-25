/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Sect1 extends SectionElement {

    private final static String tagName = "sect1";

    Sect1() {

        super(tagName);

        setFormatType(FORMAT_BLOCK);
        isContentModel(true);
    }

    Sect1(String title) {

        this();
        appendChild(new Title(title));
    }

    public static String getTag() {
        return tagName;
    }
}
