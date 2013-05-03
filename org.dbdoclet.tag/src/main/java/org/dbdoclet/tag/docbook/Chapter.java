/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Chapter extends SectionElement {

    private static final String tag = "chapter";

    Chapter() {

        super(tag);
        setFormatType(FORMAT_BLOCK);
        isContentModel(true);
    }

    Chapter(String title) {

        this();
        appendChild(new Title(title));
    }

    public static String getTag() {
        return tag;
    }
}