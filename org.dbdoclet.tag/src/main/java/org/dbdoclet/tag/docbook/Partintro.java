/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;



public class Partintro extends SectionElement {

    private static final String tagName = "partintro";

    Partintro() {

        super(tagName);
        setFormatType(FORMAT_BLOCK);
    }

    Partintro(String title) {

        this();
        appendChild(new Title(title));
    }

    public static String getTag() {
        return tagName;
    }
}
